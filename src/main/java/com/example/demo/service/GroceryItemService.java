package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GroceryItem;
import com.example.demo.repository.GroceryItemRepository;

@Service
public class GroceryItemService {

	@Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public Optional<GroceryItem> getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id);
    }

    public GroceryItem saveGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
