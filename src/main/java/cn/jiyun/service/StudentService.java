package cn.jiyun.service;

import cn.jiyun.mapper.StudentMapper;
import cn.jiyun.mapper.UsersMapper;
import cn.jiyun.pojo.Student;
import cn.jiyun.pojo.StudentVo;
import cn.jiyun.pojo.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {


        @Autowired
        private StudentMapper studentMapper;

        @Autowired
        private UsersMapper usersMapper;



        public PageInfo<StudentVo> selectfrom(Student student, Integer pageNum) {


            PageHelper.startPage(pageNum,2);
            List<StudentVo> list = studentMapper.selectfrom(student);
            PageInfo<StudentVo> pages = new PageInfo<>(list);
            return pages;
        }

        public void insert(Student s) {

            studentMapper.insert(s);
        }

        public void delete(int id) {

            studentMapper.deleteByPrimaryKey(id);
        }

        public Student selectid(int id) {

            return studentMapper.selectByPrimaryKey(id);
        }

        public void update(Student s) {

            studentMapper.updateByPrimaryKey(s);
        }

        public Users selectlogin(Users u) {

            return studentMapper.selectlogin(u);
        }


        public void adduser(Users u) {

            usersMapper.insert(u);

        }

    public Users selectusername(String name) {

            return usersMapper.selectusername(name);
    }
}
