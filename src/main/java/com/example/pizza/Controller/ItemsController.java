package com.example.pizza.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza.Entity.Items;
import com.example.pizza.Service.ItemsService;
import com.github.pagehelper.PageInfo;

import lombok.experimental.Delegate;

@RestController
@RequestMapping("/api/v1")
public class ItemsController {

    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }
    
    @PostMapping("/items")
    public ResponseEntity<String> insertItems(@RequestBody Items items) {
        Integer result = itemsService.insertItems(items);
        
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add item.");
        }
    }

    // 更新項目
    @PutMapping("/update/items/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody Items items) {
        items.setItem_id(id); // 設置項目 ID 以便更新
        try {
            Integer result = itemsService.updateItems(items);
            if (result > 0) {
                return ResponseEntity.ok("Item updated successfully");
            } else {
                return ResponseEntity.status(500).body("Failed to update item");
            }
        } catch (Exception e) {
            // 捕捉異常並返回 500 錯誤碼
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/items/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        try {
            Integer result = itemsService.deleteItemsById(id);
            if (result > 0) {
                return ResponseEntity.ok("Item deleted successfully");
            } else {
                return ResponseEntity.status(500).body("Failed to delete item");
            }
        } catch (Exception e) {
            // 捕捉異常並返回 500 錯誤碼
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<List<Items>> getItemById(@PathVariable Long id) {
        List<Items> itemList = itemsService.getItemsById(id);  // 假設這裡回傳的是清單
        if (itemList != null && !itemList.isEmpty()) {
            return ResponseEntity.ok(itemList);  // 回傳找到的項目清單
        } else {
            return ResponseEntity.notFound().build();  // 若未找到則回傳 404 Not Found
        }
    }

    @GetMapping("/items")
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> itemList = itemsService.getAllItems();  // 假設這裡回傳的是清單
        if (itemList != null && !itemList.isEmpty()) {
            return ResponseEntity.ok(itemList);  // 回傳找到的項目清單
        } else {
            return ResponseEntity.notFound().build();  // 若未找到則回傳 404 Not Found
        }
    }
    @GetMapping("/items/paged/{page}/{size}")
    public ResponseEntity<List<Items>> getItemsPaged(
        @PathVariable int page, // 從 URL 路徑中獲取頁碼
        @PathVariable int size) { // 從 URL 路徑中獲取每頁顯示的數量
        PageInfo<Items> pageInfo = itemsService.getAllItems(page, size);
        List<Items> itemsList = pageInfo.getList();  // 從 PageInfo 中提取 List<Items>
        return ResponseEntity.ok(itemsList); // 返回 List<Items> 而不是 PageInfo<Items>
    }
    
}
