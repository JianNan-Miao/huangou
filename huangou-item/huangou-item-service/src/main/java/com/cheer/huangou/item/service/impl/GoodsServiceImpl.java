package com.cheer.huangou.item.service.impl;

import com.cheer.huangou.bo.SpuBo;
import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.common.model.SpuQueryByPageParameter;
import com.cheer.huangou.item.mapper.BrandMapper;
import com.cheer.huangou.item.mapper.SpuDetailMapper;
import com.cheer.huangou.item.mapper.SpuMapper;
import com.cheer.huangou.item.service.CategoryService;
import com.cheer.huangou.item.service.GoodsService;
import com.cheer.huangou.model.Brand;
import com.cheer.huangou.model.Spu;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SpuMapper spuMapper;



    @Autowired
    private CategoryService categoryService;

    @Override
    public PageResult<SpuBo> querySpuByPageAndSort(SpuQueryByPageParameter spuQueryByPageParameter) {
        //1.查询spu，分页查询，最多查询100条
        PageHelper.startPage(spuQueryByPageParameter.getPage(),Math.min(spuQueryByPageParameter.getRows(),100));
        //2.创建查询条件
        Example example=new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        //3.条件过滤
        //3.1 是否过滤上下架
        if(spuQueryByPageParameter.getSaleable()!=null){
            System.out.println(spuQueryByPageParameter.getSaleable());
            criteria.orEqualTo("saleable",spuQueryByPageParameter.getSaleable());
        }
        //3.2 是否模糊查询
        if(StringUtils.isNotBlank(spuQueryByPageParameter.getKey())){
            criteria.andLike("title","%"+spuQueryByPageParameter.getKey()+"%");
        }
        //3.3 是否排序
        if(StringUtils.isNotBlank(spuQueryByPageParameter.getSortBy())){
            example.setOrderByClause(spuQueryByPageParameter.getSortBy()+(spuQueryByPageParameter.getDesc()?" DESC":" ASC"));
        }
        Page<Spu> pageInfo = (Page<Spu>) spuMapper.selectByExample(example);

        //将spu变为spubo
        List<SpuBo> list = pageInfo.getResult().stream().map(spu -> {
            SpuBo spuBo=new SpuBo();
            //1.属性拷贝
            BeanUtils.copyProperties(spu,spuBo);
            //2.查询spu的商品分类名称，各级分类
            List<String> nameList= categoryService.queryNameByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
            //3.拼接名字,并存入
            spuBo.setCname(StringUtils.join(nameList,"/"));
            //4.查询品牌名称
            Brand brand = brandMapper.selectByPrimaryKey(spu.getBrandId());
            spuBo.setBname(brand.getName());
            return spuBo;
        }).collect(Collectors.toList());
        return new PageResult<>(pageInfo.getTotal(),list);
    }
}
