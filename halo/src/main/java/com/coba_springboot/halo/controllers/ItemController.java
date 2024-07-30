package com.coba_springboot.halo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coba_springboot.halo.model.Item;
import com.coba_springboot.halo.model.apiResponse;
import com.coba_springboot.halo.services.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<apiResponse<List<Item>>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(new apiResponse<>(200, "Success Response", items));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<Item>> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.getItemById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(new apiResponse<>(200, "Success Response", item.get()));
        } else {
            return ResponseEntity.status(404).body(new apiResponse<>(404, "Item not found", null));
        }
    }

    @SuppressWarnings("unchecked")
    @PostMapping
    public ResponseEntity<apiResponse<Item>> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        @SuppressWarnings("rawtypes")
        apiResponse Response = new apiResponse<>(201, "Item created successfully", createdItem);
        return ResponseEntity.status(201).body(Response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<apiResponse<Item>> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Optional<Item> updatedItem = itemService.updateItem(id, item);
        if (updatedItem.isPresent()) {
            return ResponseEntity.ok(new apiResponse<>(200, "Item updated successfully", updatedItem.get()));
        } else {
            return ResponseEntity.status(404).body(new apiResponse<>(404, "Item not found", null));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<apiResponse<Item>> partialUpdateItem(@PathVariable Long id, @RequestBody Item item) {
        Optional<Item> updatedItem = itemService.partialUpdateItem(id, item);
        if (updatedItem.isPresent()) {
            return ResponseEntity.ok(new apiResponse<>(200, "Item partially updated successfully", updatedItem.get()));
        } else {
            return ResponseEntity.status(404).body(new apiResponse<>(404, "Item not found", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<apiResponse<Void>> deleteItem(@PathVariable Long id) {
        boolean deleted = itemService.deleteItem(id);
        if (deleted) {
            return ResponseEntity.ok(new apiResponse<>(200, "Item deleted successfully", null));
        } else {
            return ResponseEntity.status(404).body(new apiResponse<>(404, "Item not found", null));
        }
    }
}
