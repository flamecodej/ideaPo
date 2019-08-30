package com.oracle.service;

import com.oracle.entity.Admins;
import com.oracle.mapper.AdminsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Override
    public Admins getAdminByLoginName(String loginname) {
        return this.adminsMapper.selectAdminByName(loginname);
    }

    @Override
    public List<String> getUrlById(Integer id) {
        return this.adminsMapper.selectUrlById(id);
    }

    @Override
    public void updateAdmin(Admins adminVo) {
        this.adminsMapper.updateByPrimaryKey(adminVo);
    }

    @Override
    public List<Admins> getList() {
        return this.adminsMapper.selectContainRole();
    }

    @Override
    public Admins selectAdminById(Integer id) {
        return this.adminsMapper.selectContainRoleById(id).get(0);
    }

    @Override
    public boolean updateById(Admins adminVo) {
        boolean result=false;
        //  更新
        this.adminsMapper.updateByPrimaryKeySelective(adminVo);
        //  更新（删除、添加）  第三张表
        this.adminsMapper.deleteRoleByAdminId(adminVo.getId());
        this.adminsMapper.addRoleByAdminId(adminVo.getRoleId(),adminVo.getId());
        result=true;
        return result;
    }

    @Override
    public boolean add(Admins adminVo) {
        boolean result=false;
        this.adminsMapper.insertSelective(adminVo);
        this.adminsMapper.addRoleByAdminId(adminVo.getRoleId(),adminVo.getId());
        result=true;
        return result;
    }

    @Override
    public void deleteAdminById(Integer id) {
        this.adminsMapper.deleteByPrimaryKey(id);
        this.adminsMapper.deleteRoleByAdminId(id);
    }
}
