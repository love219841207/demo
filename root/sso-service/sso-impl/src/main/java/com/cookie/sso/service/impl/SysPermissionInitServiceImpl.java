package com.cookie.sso.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.cookie.framework.base.BaseService;
import com.cookie.sso.model.SysPermissionInit;
import com.cookie.sso.service.inter.SysPermissionInitService;


import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z77z
 * @since 2017-02-16
 */
@Service
public class SysPermissionInitServiceImpl extends BaseService<SysPermissionInit> implements SysPermissionInitService {
	
	public List<SysPermissionInit> selectAll() {
		return super.selectAll();
	}
}
