package com.oracle.service;

import com.oracle.entity.Permission;
import com.oracle.entity.Roles;
import com.oracle.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public List<Roles> list() {
        return this.rolesMapper.selectByExample(null);
    }

    @Override
    public Roles selectRolesById(Integer id) {
        return this.rolesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> selectRoleInPer(Integer id) {
        return this.rolesMapper.selectRoleInPer(id);
    }

    @Override
    public void UpdateRoleInPer(Roles role, Integer[] perIds) {
        this.rolesMapper.updateByPrimaryKeySelective(role);
        this.rolesMapper.deleteRoleInPer(role.getId());
        for (int i = 0; i < perIds.length; i++) {
            this.rolesMapper.addPermissionByRoleId(role.getId(),perIds[i]);
        }
    }

    @Override
    public void add(Roles role, Integer[] perIds) {
        this.rolesMapper.insertSelective(role);
        for (int i=0; i<perIds.length; i++){
            this.rolesMapper.addPermissionByRoleId(role.getId(),perIds[i]);
        }
    }

    @Override
    public void deleteRoleById(Integer id) {
        this.rolesMapper.deleteByPrimaryKey(id);
        //  删除  角色对应的权限
        this.rolesMapper.deleteRoleInPer(id);
    }


}
