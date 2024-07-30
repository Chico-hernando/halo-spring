package com.coba_springboot.halo.services;

import com.coba_springboot.halo.model.Item;
import com.coba_springboot.halo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> updateItem(Long id, Item item) {
        return itemRepository.update(id, item);
    }

    public Optional<Item> partialUpdateItem(Long id, Item item) {
        return itemRepository.partialUpdate(id, item);
    }

    public boolean deleteItem(Long id) {
        return itemRepository.deleteById(id);
    }
}