package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;

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
    public Result saveCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("Add Category,{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();

    }

    /**
     * query category by page
     * @return
     */
    @GetMapping("/page"  )
    public Result<PageResult> categoryPage(CategoryPageQueryDTO categoryPageQueryDTO){
            log.info("query category by page,{}",categoryPageQueryDTO);
            PageResult pageResults =categoryService.query(categoryPageQueryDTO);
            return Result.success(pageResults);
    }

    /**
     * update a new category
     * @param id
     * @return
     */
//    @PutMapping
//    public Result updateCategory(Long id){
//
//       categoryService.getById(id);
//    }


}
