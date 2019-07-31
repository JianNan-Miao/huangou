package com.cheer.huangou.item.service.impl;

import com.cheer.huangou.item.mapper.CategoryMapper;
import com.cheer.huangou.item.service.CategoryService;
import com.cheer.huangou.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryListByParent(Long parentId) {
        Category category = new Category();
        category.setParentId(parentId);

        List<Category> categoryList = this.categoryMapper.select(category);
        return categoryList;
    }
}
