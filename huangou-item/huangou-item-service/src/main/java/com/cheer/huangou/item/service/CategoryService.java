package com.cheer.huangou.item.service;

import com.cheer.huangou.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryListByParent(Long parentId);
}
