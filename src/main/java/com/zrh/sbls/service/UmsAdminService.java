package com.zrh.sbls.service;

import com.zrh.sbls.dto.UmsAdminParam;
import com.zrh.sbls.model.UmsAdmin;
import com.zrh.sbls.model.UmsPermission;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/7/26
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     * @author zhangrenhua
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId
     * @return
     * @author zhangrenhua
     */
    List<UmsPermission> getPermissionList(Long adminId);


    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     * @author zhangrenhua
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     * @author zhangrenhua
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     * @param oldToken
     * @return
     * @author zhangrenhua
     */
    String refreshToken(String oldToken);


    /**
     * 搜索用户
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<UmsAdmin> search(String keyword, Integer pageNum, Integer pageSize);


    /**
     * 导入数据
     */
    void importData();
}
