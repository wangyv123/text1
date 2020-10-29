package cn.jiyun.controller;

import cn.jiyun.pojo.Student;
import cn.jiyun.pojo.StudentVo;
import cn.jiyun.pojo.Users;
import cn.jiyun.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;


    //初始化数据展示
    @RequestMapping("show")
    public String show(StudentVo student, @RequestParam(defaultValue = "1")Integer pageNum, Model model){


        PageInfo<StudentVo> page = studentService.selectfrom(student, pageNum);

        model.addAttribute("page",page);
        model.addAttribute("s",student);

        return "show";
    }


    //跳转添加页面
    @RequestMapping("/add")
    public String add(){

        return "add";
    }


    //添加
    @RequestMapping("/insert")
    public String insert(Student s){

        studentService.insert(s);

        return "redirect:/show";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(int id){

       // System.out.println(id);
        studentService.delete(id);
        return "redirect:/show";
    }


    //修改回显
    @RequestMapping("/selectid")
    public String selectid(int id,Model model){


        Student s = studentService.selectid(id);


        model.addAttribute("s",s);
        return "update";
    }


    //修改
    @RequestMapping("/update")
    public String update(Student s){

        studentService.update(s);
        return "redirect:/show";
    }


    //登录
    @RequestMapping("/tologin")
    public String tologin(){


        return "login";
    }


    //登录判断
    @RequestMapping("/login")
    public String login(Users u, Model model, HttpSession session){


        Users us = studentService.selectlogin(u);

        if(us!=null){

            session.setAttribute("us",us);
            return "redirect:/show";

        }else {

            model.addAttribute("cuo","用户名或密码错误");
            return "login";
        }


    }

    @RequestMapping("/register")
    public String register(){

       return "register";
    }

    @RequestMapping("/zhuce")
    public String zhuce(Users u,Model model){
        String name = u.getName().trim();


            studentService.adduser(u);
            return "login";

    }

    @RequestMapping("/chongfu")
    @ResponseBody
    public String congfu(String name){

        Users uu = studentService.selectusername(name);

       if(uu==null){

           return "ok";
       }else {

           return "no";
       }

    }
}
