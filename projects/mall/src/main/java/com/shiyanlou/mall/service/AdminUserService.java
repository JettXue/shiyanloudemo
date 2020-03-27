package com.shiyanlou.mall.service;

import com.shiyanlou.mall.entity.AdminUser;
import com.shiyanlou.mall.utils.PageResult;
import com.shiyanlou.mall.utils.PageUtil;

/**
 * @author Jettx
 * @date 3/25/2020 2:31 PM
 */
public interface AdminUserService {
    /**
     * 分页功能
     *
     * @param pageUtil
     * @return
     */
    PageResult getAdminUserPage(PageUtil pageUtil);

    /**
     * 登陆功能
     *
     * @return
     */
    AdminUser updateTokenAndLogin(String userName, String password);
}
