package com.cheer.huangou.item.service;

import com.cheer.huangou.bo.SpuBo;
import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.common.model.SpuQueryByPageParameter;

public interface GoodsService {
    /**
     * 分页查询
     * @param spuQueryByPageParameter
     * @return
     */
    PageResult<SpuBo> querySpuByPageAndSort(SpuQueryByPageParameter spuQueryByPageParameter);
}
