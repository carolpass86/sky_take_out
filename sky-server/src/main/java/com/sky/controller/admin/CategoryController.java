package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /**
     * add a new category
     */
    @PostMapping
    @ApiOperation("add a new category")
    public Result saveCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("Add Category,{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();

    }

    /**
     * query category by page
     * @return
     */
    @ApiOperation("query category by page")
    @GetMapping("/page"  )
    public Result<PageResult> categoryPage(CategoryPageQueryDTO categoryPageQueryDTO){
            log.info("query category by page,{}",categoryPageQueryDTO);
            PageResult pageResults =categoryService.query(categoryPageQueryDTO);
            return Result.success(pageResults);
    }

    /**
     * delete one record of  category
     * @return
     */
    @DeleteMapping()
    @ApiOperation("delete one record of  category")
    public Result categoryDelById( Long id){
        log.info("delete one record of  category,{}",id);
        categoryService.delById(id);
        return Result.success();

    }

    /**
     * update a new category
     * @param
     * @return
     */
    @PutMapping
    @ApiOperation("update the category")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO){
      log.info(" update a new category,{}",categoryDTO);
       categoryService.update(categoryDTO);
       return Result.success();
    }

    @PostMapping("/status/{status}")
    public Result startOrStop(@PathVariable("status") Integer status,Long id){
          log.info("status ,id,{},{}",status,id );
          categoryService.startOrStop(status,id);
          return  Result.success();

    }
    @GetMapping("/list")
    public Result<List<Category>> list(Integer type){
       List<Category> list =categoryService.list(type);
        return Result.success(list);

    }


}
