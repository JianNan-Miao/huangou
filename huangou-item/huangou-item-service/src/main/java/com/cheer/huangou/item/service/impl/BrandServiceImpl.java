package com.cheer.huangou.item.service.impl;

import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.item.mapper.BrandMapper;
import com.cheer.huangou.item.service.BrandService;
import com.cheer.huangou.model.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 品牌的分页查询
     * @param page  page是一共多少页
     * @param rows  rows表示一页多少行
     * @param sortBy  按照上面排序
     * @param desc
     * @param key  关键字搜索
     * @return
     */
    @Override
    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 分页 自动将查询的结果进行分页 page是一共多少页，rows表示一页多少行
        PageHelper.startPage(page, rows);

        // 过滤
        /*
         * select * from tb_brand where name like "%key%" or letter==key order by id desc
         * */
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            // 构造查询条件
            example.createCriteria().andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        // 排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }

        // 查询
        Page<Brand> pageInfo = (Page<Brand>) this.brandMapper.selectByExample(example);

        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }
}
