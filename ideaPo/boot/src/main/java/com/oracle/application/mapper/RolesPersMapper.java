package com.oracle.application.mapper;

import com.oracle.application.pojo.RolesPersExample;
import com.oracle.application.pojo.RolesPersKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPersMapper {
    int countByExample(RolesPersExample example);

    int deleteByExample(RolesPersExample example);

    int deleteByPrimaryKey(RolesPersKey key);

    int insert(RolesPersKey record);

    int insertSelective(RolesPersKey record);

    List<RolesPersKey> selectByExample(RolesPersExample example);

    int updateByExampleSelective(@Param("record") RolesPersKey record, @Param("example") RolesPersExample example);

    int updateByExample(@Param("record") RolesPersKey record, @Param("example") RolesPersExample example);
}