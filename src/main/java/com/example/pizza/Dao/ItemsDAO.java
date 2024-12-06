package com.example.pizza.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pizza.Entity.Items;
import com.github.pagehelper.PageInfo;

@Mapper
public interface ItemsDAO extends BaseMapper<Items> {

    int insertItems(Items items);

    int insertDetails(Items items);

    int insertItemDetail(Items items);

    int updateItems(Items items);

    int deleteItemsById(Long id);

    int deleteItemDetailByItemId(Long id);

    List<Items> getItemsById(Long id);

    List<Items> getAllItems();

    PageInfo<Items> getAllItems(int page, int size);
} 
