package com.oracle.service;

import com.oracle.entity.Admins;

import java.util.List;

public interface AdminService {

    // 根据登录名返回一个 admin
    Admins getAdminByLoginName(String loginname);

    // url
    List<String> getUrlById(Integer id);

    void updateAdmin(Admins adminVo);

    List<Admins> getList();

    Admins selectAdminById(Integer id);

    boolean updateById(Admins adminVo);

    boolean add(Admins adminVo);

    void deleteAdminById(Integer id);
}
