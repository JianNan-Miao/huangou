package com.cheer.huangou.item.service.impl;

import com.cheer.huangou.item.mapper.CategoryMapper;
import com.cheer.huangou.item.service.CategoryService;
import com.cheer.huangou.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
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

    /**
     * 根据ids查询名字
     * @param asList
     * @return
     */
    @Override
    public List<String> queryNameByIds(List<Long> asList) {
        List<String> names = new ArrayList<>();
        if (asList != null && asList.size() !=0){
            for (Long id : asList) {
                names.add(this.categoryMapper.queryNameById(id));
            }
        }
        return names;
        //使用通用mapper接口中的SelectByIdListMapper接口查询
        //return this.categoryMapper.selectByIdList(asList).stream().map(Category::getName).collect(Collectors.toList());
    }
}
