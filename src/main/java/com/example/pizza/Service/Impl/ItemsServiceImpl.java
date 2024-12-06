package com.example.pizza.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza.Dao.ItemsDAO;
import com.example.pizza.Entity.Items;
import com.example.pizza.Service.ItemsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDAO itemsDAO;

    @Override
    public Integer insertItems(Items items) {
        return itemsDAO.insertItems(items)
                + itemsDAO.insertDetails(items)
                + itemsDAO.insertItemDetail(items);
    }

    @Override
    public Integer updateItems(Items items) {
        return itemsDAO.updateItems(items);
    }

    @Override
    public Integer deleteItemsById(Long id) {
        return itemsDAO.deleteItemDetailByItemId(id)
        + itemsDAO.deleteItemsById(id);
    }

    @Override
    public List<Items> getItemsById(Long id) {
        return itemsDAO.getItemsById(id);
    }

    @Override
    public List<Items> getAllItems() {
        return itemsDAO.getAllItems();
    }

    @Override
    public PageInfo<Items> getAllItems(int page, int size) {
        // 開始分頁，設置頁數和每頁大小
        PageHelper.startPage(page, size);
        List<Items> itemsList = itemsDAO.getAllItems(); // 獲取資料
        return new PageInfo<>(itemsList);  // 使用 PageInfo 包裝返回資料
    }
}
