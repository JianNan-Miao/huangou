package com.cheer.huangou.item.service;

import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.model.Brand;

import java.util.List;

public interface BrandService {
    PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key);

     void saveBrand(Brand brand, List<Long> cids);
}
