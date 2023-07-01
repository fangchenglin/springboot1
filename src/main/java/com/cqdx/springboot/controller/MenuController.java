package com.cqdx.springboot.controller;

import com.cqdx.springboot.entity.Menu;
import com.cqdx.springboot.service.MenuService;
import com.cqdx.springboot.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2023-06-29 09:43:46
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Menu>> queryByPage(Menu menu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.menuService.queryByPage(menu, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Long id) {
        return DataResult.successByData(this.menuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param menu 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(Menu menu) {
        return DataResult.successByData(this.menuService.insert(menu));
    }

    /**
     * 编辑数据
     *
     * @param menu 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(Menu menu) {
        return DataResult.successByData(this.menuService.update(menu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Long id) {
        return DataResult.successByData(this.menuService.deleteById(id));
    }

}

