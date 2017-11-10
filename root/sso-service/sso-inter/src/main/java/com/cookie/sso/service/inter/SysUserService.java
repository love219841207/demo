package com.cookie.sso.service.inter;

import com.cookie.framework.base.PageBean;
import com.cookie.sso.model.SysUser;

import java.io.Serializable;
import java.util.List;

public interface SysUserService {
    public List<SysUser> selectByMap(SysUser sysUser);

    public PageBean<SysUser> selectForPage();

    public boolean deleteBatchIds(List<? extends Serializable> idList);
}
