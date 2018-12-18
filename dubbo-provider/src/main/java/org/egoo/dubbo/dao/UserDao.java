package org.egoo.dubbo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {
    List  queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
