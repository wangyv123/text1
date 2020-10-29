package cn.jiyun.mapper;

import cn.jiyun.pojo.Users;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

public interface UsersMapper extends BaseMapper<Users> {

    @Select("select * from users where name=#{name}")
    Users selectusername(String name);
}
