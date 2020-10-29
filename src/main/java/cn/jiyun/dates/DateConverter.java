package cn.jiyun.dates;


import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;


public class DateConverter implements Converter<String, Date>{
    @Override
    public Date convert(String s) {


        String[] patterns = new String[]{
                "yyyy-MM-dd","yyyy-MM-dd hh:mm:ss","yyyy/MM/dd","yyyy/MM/dd hh:mm:ss",
                "MM-dd-yyyy","dd-MM-yyyy"};


        try {
             Date date = DateUtils.parseDate(s, patterns);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  null;


    }
}
