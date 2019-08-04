package com.cheer.huangou.item.service.impl;

import com.cheer.huangou.item.mapper.SpecificationMapper;
import com.cheer.huangou.item.service.SpecificationService;
import com.cheer.huangou.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;
    @Override
    public Specification queryById(Long id) {
        return specificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveSpecification(Specification specification) {
        specificationMapper.insert(specification);
    }

    @Override
    public void updateSpecification(Specification specification) {
        specificationMapper.updateByPrimaryKeySelective(specification);
    }

    @Override
    public void deleteSpecification(Specification specification) {
       specificationMapper.deleteByPrimaryKey(specification);
    }
}
