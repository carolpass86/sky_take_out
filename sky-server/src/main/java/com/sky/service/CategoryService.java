package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    /**
     * add a new category
     */
    void save(CategoryDTO categoryDTO);

    /**
     * query category by page
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult query(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * del a category
     * @param id
     */
    void delById(Long id);

    /**
     * update category
     * @param
     */
    void update(CategoryDTO categoryDTO);
}
