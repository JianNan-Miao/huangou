package com.cheer.huangou.item.controller;

import com.cheer.huangou.bo.SpuBo;
import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.common.model.SpuQueryByPageParameter;
import com.cheer.huangou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询商品spu
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @param saleable
     * @return
     */
    @GetMapping("/spu/page")
  public ResponseEntity<PageResult<SpuBo>> querySpuByPage
          (@RequestParam(value = "page", defaultValue = "1") Integer page,
           @RequestParam(value = "rows", defaultValue = "5") Integer rows,
           @RequestParam(value = "sortBy", required = false) String sortBy,
           @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
           @RequestParam(value = "key", required = false) String key,
           @RequestParam(value = "saleable",defaultValue = "true") Boolean saleable){
      SpuQueryByPageParameter spuQueryByPageParameter=new SpuQueryByPageParameter(page,rows,sortBy,desc,key,saleable);
      PageResult<SpuBo> result=goodsService.querySpuByPageAndSort(spuQueryByPageParameter);
      System.out.println("查询数据量："+result.getTotal());
      return ResponseEntity.ok(result);
  }
}
