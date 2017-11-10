package com.cookie.sso.mapper;

import com.cookie.framework.base.MyMapper;
import com.cookie.sso.model.SysPermissionInit;

import java.util.List;



/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author z77z
 * @since 2017-02-16
 */
public interface SysPermissionInitMapper extends MyMapper<SysPermissionInit> {

	List<SysPermissionInit> selectAll();

}