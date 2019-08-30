package com.oracle.shiro;

import com.oracle.entity.Admins;
import com.oracle.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AuthenticationRealm extends AuthorizingRealm{

	@Autowired
	private AdminService adminService;


	/**
	 *  鉴权  当认证 之后   有请求时   需要 执行这个方法
	 * @Title: doGetAuthorizationInfo
	 * @return org.apache.shiro.authz.AuthorizationInfo
	 * @author: Flame
	 * @since: 2019/7/15 11:57
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		Principal principal=(Principal) principals.fromRealm(getName()).iterator().next();
		if(principal!=null) {
		List<String> listPer=this.adminService.getUrlById(principal.getId());
			if(listPer!=null) {
				SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
				authorizationInfo.addStringPermissions(listPer);
				return authorizationInfo;
			}
		}
		return null;
	}


	/**
	 *  执行一个  用户的认证操作
	 * @Title: doGetAuthenticationInfo
	 * @return org.apache.shiro.authc.AuthenticationInfo
	 * @author: Flame
	 * @since: 2019/7/15 11:58
	 */
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationToKen authenticationToKen=(AuthenticationToKen) token;
		String loginName=authenticationToKen.getUsername();
		String password=new String(authenticationToKen.getPassword());
		if(!authenticationToKen.isValid()) {
			throw new UnsupportedTokenException();
		}
		if(loginName!=null&&!"".equals(loginName)) {
			// 根据 登录名 获取  admin 对象
			Admins admin=this.adminService.getAdminByLoginName(loginName);
			if(admin==null) {
				throw new UnknownAccountException();
			}
			if(!admin.getPwd().equals(password)) {
				throw new IncorrectCredentialsException();
			}
			// 登录时间
			admin.setLogindate(new Date());
			//this.adminService.updateAdmin(admin);
			// 当登陆成功 将信息 存放进 身份牌 Session 30 分钟
			return new SimpleAuthenticationInfo(new Principal(admin.getId(), loginName), password, getName());
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
