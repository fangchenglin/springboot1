package com.cqdx.springboot.service;

import com.cqdx.springboot.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2023-06-29 09:43:46
 */
public interface MenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    Menu queryById(Long menuId);

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Menu> queryByPage(Menu menu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu insert(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    boolean deleteById(Long menuId);


}
