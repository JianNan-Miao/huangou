package com.cheer.huangou.item.controller;

import com.cheer.huangou.common.model.PageResult;
import com.cheer.huangou.item.service.BrandService;
import com.cheer.huangou.model.Brand;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
            log.traceEntry();

        PageResult<Brand> pageResult = this.brandService.queryBrandByPageAndSort(page, rows, sortBy, desc, key);

        if (null == pageResult || pageResult.getItems().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(pageResult);
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids  商品类别列表
     * @return
     */
    @PostMapping
    public ResponseEntity<Void>  saveBrand(Brand brand, @RequestParam("categories")List<Long> cids){
      brandService.saveBrand(brand,cids);
      return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
