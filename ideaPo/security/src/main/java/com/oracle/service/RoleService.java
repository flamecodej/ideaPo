package com.oracle.service;

import com.oracle.entity.Permission;
import com.oracle.entity.Roles;

import java.util.List;

public interface RoleService {

    List<Roles> list();

    Roles selectRolesById(Integer id);

    List<Permission> selectRoleInPer(Integer id);

    void UpdateRoleInPer(Roles role,Integer[] perIds);

    void add(Roles role,Integer [] perIds);

    void deleteRoleById(Integer id);
}
