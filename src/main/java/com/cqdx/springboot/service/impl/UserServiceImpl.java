package com.cqdx.springboot.service.impl;

import com.cqdx.springboot.dao.MenuDao;
import com.cqdx.springboot.dto.LoginUserDTo;
import com.cqdx.springboot.entity.Menu;
import com.cqdx.springboot.entity.User;
import com.cqdx.springboot.dao.UserDao;
import com.cqdx.springboot.service.MenuService;
import com.cqdx.springboot.service.UserService;
import com.cqdx.springboot.utils.VerifyUtil;
import com.cqdx.springboot.utils.result.DataResult;
import com.cqdx.springboot.utils.result.code.Code;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-06-29 09:43:13
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    MenuDao menuDao;

    @Resource
    HttpSession session;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public DataResult loginUser(User user) {
        //判断参数
        if(VerifyUtil.isNull(user.getUsername()) || VerifyUtil.isNull(user.getPassword())){
            return DataResult.errByErrCode(Code.LOGIN_ERROR);
        }
        //查询用户
        User loginUser = userDao.loginUser(user);
        if(loginUser == null){
            return DataResult.errByErrCode(Code.NO_EXIST);
        }
        //登陆成功
        loginUser.setPassword("");
        //将用户信息存入session
        session.setAttribute("user",loginUser);
        session.setMaxInactiveInterval(60 * 60 * 24);
        //查询当前用户可以看到的菜单
        List<Menu> menuByUserType = menuDao.getMenuByUserType(loginUser.getUserType());
        //整理返回数据
        LoginUserDTo loginUserDTo = new LoginUserDTo();
        loginUserDTo.setUser(loginUser);
        loginUserDTo.setMenus(menuByUserType);
        return DataResult.successByData(loginUserDTo);
    }
}
