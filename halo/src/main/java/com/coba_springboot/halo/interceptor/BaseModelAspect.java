package com.coba_springboot.halo.interceptor;

import java.lang.reflect.Method;
import java.util.Calendar;

import javax.persistence.Id;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.coba_springboot.halo.model.BaseModel;

@Aspect
@Component
public class BaseModelAspect {

    @Before("execution(* *..impl.GeneralServiceImpl.save(..)) "
			+ "|| execution(* *..impl.GeneralServiceImpl.remove(..)) "
			+ "|| execution(* *..impl.GeneralServiceImpl.softRemove(..))")
	public void setGenericObject(JoinPoint jp) throws Throwable {
        System.out.println("========================================================== "+jp.getSignature().getName());
        Object[] args = jp.getArgs();
		Object newObject = (Object)args[0];	
		// String username = StringUtils.isEmpty(UserUtil.getCurrentUsername())?"System":UserUtil.getCurrentUsername();
		
		if ("save".equals(jp.getSignature().getName()) 
				&& newObject instanceof BaseModel) {
			
			BaseModel model = (BaseModel) newObject; 
			Class modelClass = model.getClass();
			for(Method method : modelClass.getMethods()){
				Id identityAnnotation = method.getAnnotation(Id.class);
				if(identityAnnotation != null){
					Object value = method.invoke(model, null);
					if(value == null){// this is action add
						// model.setCreatedBy(username);
						model.setCreatedAt(Calendar.getInstance().getTime());
						break;
					}
				}
			}
			// if (((BaseModel) newObject).getUpdatedBy() == null)((BaseModel) newObject).setUpdatedBy(username);
			if (((BaseModel) newObject).getUpdatedAt() == null)((BaseModel) newObject).setUpdatedAt(Calendar.getInstance().getTime());
			
        }
    }
    
}
