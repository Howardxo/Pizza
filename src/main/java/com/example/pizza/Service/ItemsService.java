package com.example.pizza.Service;

import java.util.List;

import com.example.pizza.Entity.Items;
import com.github.pagehelper.PageInfo;

public interface ItemsService {
    
    Integer insertItems(Items items);

    Integer updateItems(Items items);

    Integer deleteItemsById(Long id);

    List<Items> getItemsById(Long id);

    List<Items> getAllItems();

    PageInfo<Items> getAllItems(int page, int size);
}
