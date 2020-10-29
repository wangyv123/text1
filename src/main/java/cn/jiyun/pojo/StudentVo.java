package cn.jiyun.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentVo extends Student{

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tou;
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date wei;

    public Date getTou() {
        return tou;
    }

    public void setTou(Date tou) {
        this.tou = tou;
    }

    public Date getWei() {
        return wei;
    }

    public void setWei(Date wei) {
        this.wei = wei;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "tou=" + tou +
                ", wei=" + wei +
                '}';
    }
}
