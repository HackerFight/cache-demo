package com.qiuguan.cache.mapper;

import com.qiuguan.cache.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author created by qiuguan on 2021/12/21 10:53
 */
@Mapper
public interface UserInfoMapper {

    /**
     * select user
     * @param id
     * @return
     */
    @Select("select id, name, age, phone from user_info where id = #{id}")
    UserInfo getUserInfo(Long id);
}
