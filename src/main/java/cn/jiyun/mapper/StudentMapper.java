package cn.jiyun.mapper;

import cn.jiyun.pojo.Student;
import cn.jiyun.pojo.StudentVo;
import cn.jiyun.pojo.Users;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {


    List<StudentVo> selectfrom(Student student);


    @Select("select * from users where name=#{name} and paw=#{paw}")
    Users selectlogin(Users u);
}
