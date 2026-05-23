package com.ruoyi.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.common.core.domain.entity.SysUser;

import java.util.Date;
import java.util.List;

/**
 * 用户表 数据层
 *
 * @author ruoyi
 */
public interface SysUserMapper extends BaseMapper<SysUser>
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 根据条件分页查询已配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);



    /**
     * 重置用户密码
     *
     * @param userId 用户ID
     * @param password 密码
     * @return 结果
     */
    default int resetUserPwd(Long userId, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setUpdateTime(new Date());
        sysUser.setPassword(password);
        sysUser.setPwdUpdateDate(new Date());
        return update(sysUser);
    }

}
