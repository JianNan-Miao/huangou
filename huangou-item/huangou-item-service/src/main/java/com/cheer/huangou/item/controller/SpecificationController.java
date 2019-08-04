package com.cheer.huangou.item.controller;



import com.cheer.huangou.item.service.SpecificationService;
import com.cheer.huangou.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spec")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    /**
     * 查询商品分类对应的规格参数模板
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<String> querySpecificationByCategoryId(@PathVariable("id") Long id){
        Specification spec = this.specificationService.queryById(id);
        if (spec == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(spec.getSpecifications());
    }

    /**
     * 新增商品规格参数
     * @param specification
     * @return
     */
    @PostMapping
    public ResponseEntity<Void>  saveSpecification(Specification specification){
        specificationService.saveSpecification(specification);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /**
     * 修改商品规格参数
     * @param specification
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateSpecification(Specification specification){
        specificationService.updateSpecification(specification);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    /**
     * 删除商品规格
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSpecification(@PathVariable("id")Long id){
        Specification specification=new Specification();
        specification.setCategoryId(id);
        specificationService.deleteSpecification(specification);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
