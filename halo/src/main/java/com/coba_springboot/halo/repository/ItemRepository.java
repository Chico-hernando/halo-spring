package com.coba_springboot.halo.repository;

import com.coba_springboot.halo.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    private List<Item> items = new ArrayList<>();
    private long currentId = 1;

    public List<Item> findAll() {
        return items;
    }

    public Optional<Item> findById(Long id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public Item save(Item item) {
        item.setId(currentId++);
        items.add(item);
        return item;
    }

    public Optional<Item> update(Long id, Item item) {
        Optional<Item> existingItem = findById(id);
        existingItem.ifPresent(i -> {
            i.setName(item.getName());
            i.setDescription(item.getDescription());
        });
        return existingItem;
    }

    public Optional<Item> partialUpdate(Long id, Item item) {
        Optional<Item> existingItem = findById(id);
        existingItem.ifPresent(i -> {
            if (item.getName() != null) {
                i.setName(item.getName());
            }
            if (item.getDescription() != null) {
                i.setDescription(item.getDescription());
            }
        });
        return existingItem;
    }

    public boolean deleteById(Long id) {
        return items.removeIf(item -> item.getId().equals(id));
    }
}