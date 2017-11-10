package com.cookie.sso.service.impl;






import com.alibaba.dubbo.config.annotation.Service;
import com.cookie.framework.base.BaseService;
import com.cookie.framework.base.PageBean;
import com.cookie.sso.model.SysUser;
import com.cookie.sso.service.inter.SysUserService;

import java.io.Serializable;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author z77z
 * @since 2017-02-10
 */
@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements SysUserService {

    public List<SysUser> selectByMap(SysUser sysUser) {
        return super.select(sysUser);
    }
    public PageBean<SysUser> selectForPage() {
        return super.getPageBeanBySelectAll(0,10);
    }

    public boolean deleteBatchIds(List<? extends Serializable> idList) {
        return false;
    }

}
