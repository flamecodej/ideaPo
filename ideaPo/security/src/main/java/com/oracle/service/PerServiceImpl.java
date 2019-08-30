package com.oracle.service;

import com.oracle.entity.Permission;
import com.oracle.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerServiceImpl implements PerService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> list() {
        return this.permissionMapper.selectByExample(null);
    }
}
