package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据主键查询菜品
     * @param id
     */
    @Select("select * from dish where id = #{id}")
    Dish getiById(Long id);

    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);

    /**
     * 根据id动态修改菜品
     * @param dish
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);


    /**
     * 动态条件查询菜品
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);
}
