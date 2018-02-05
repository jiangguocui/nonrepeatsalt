package com.jgc.salt.dao;


import com.jgc.salt.entity.Id;
import com.jgc.salt.entity.IdCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface IdMapper {
    int countByExample(IdCriteria example);

    int deleteByExample(IdCriteria example);

    int insert(Id record);

    int insertSelective(Id record);

    List<Id> selectByExampleWithRowbounds(IdCriteria example, RowBounds rowBounds);

    List<Id> selectByExample(IdCriteria example);
    
    List<Id> selectForUpdate();
    
    int inc(@Param("size") Long size, @Param("id") Long id);
    
    int dec(Long size);

    int updateByExampleSelective(@Param("record") Id record, @Param("example") IdCriteria example);

    int updateByExample(@Param("record") Id record, @Param("example") IdCriteria example);
}