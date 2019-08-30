package com.oracle.mapper;

import com.oracle.pojo.ProImg;
import com.oracle.pojo.ProImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProImgMapper {
    int countByExample(ProImgExample example);

    int deleteByExample(ProImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProImg record);

    int insertSelective(ProImg record);

    List<ProImg> selectByExample(ProImgExample example);

    ProImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProImg record, @Param("example") ProImgExample example);

    int updateByExample(@Param("record") ProImg record, @Param("example") ProImgExample example);

    int updateByPrimaryKeySelective(ProImg record);

    int updateByPrimaryKey(ProImg record);
}