package com.cheer.huangou.item.service;

import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.model.Brand;

public interface BrandService {
    PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key);
}
