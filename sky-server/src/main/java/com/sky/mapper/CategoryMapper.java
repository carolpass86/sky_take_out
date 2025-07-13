package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CategoryMapper {
    /**
     * add a new category
     */
    @Insert("insert into category (type, name, sort ,status, create_time, update_time, create_user, update_user)" +
            " values (#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void save(Category category);

    /**
     * query category by page
     * @return
     */


    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * del a category
     * @param id
     */
    @Delete("delete  from category where  id = #{id}")
    void delById(Long id);

    /**
     * update category
     * @param
     */

    void update(Category category);
}
