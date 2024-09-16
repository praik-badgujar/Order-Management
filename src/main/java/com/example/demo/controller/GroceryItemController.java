package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GroceryItem;
import com.example.demo.service.GroceryItemService;

@RestController
@RequestMapping("/grocery-items")
public class GroceryItemController {

	@Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long id) {
        Optional<GroceryItem> groceryItem = groceryItemService.getGroceryItemById(id);
        return groceryItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GroceryItem> createGroceryItem(@RequestBody GroceryItem groceryItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groceryItemService.saveGroceryItem(groceryItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        if (groceryItemService.getGroceryItemById(id).isPresent()) {
            groceryItem.setId(id);
            return ResponseEntity.ok(groceryItemService.saveGroceryItem(groceryItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        if (groceryItemService.getGroceryItemById(id).isPresent()) {
            groceryItemService.deleteGroceryItem(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
