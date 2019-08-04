package com.cheer.huangou.item.service;

import com.cheer.huangou.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryListByParent(Long parentId);

    /**
     * 根据ids查询分类信息
     * @param asList
     * @return
     */
    List<String> queryNameByIds(List<Long> asList);
}
