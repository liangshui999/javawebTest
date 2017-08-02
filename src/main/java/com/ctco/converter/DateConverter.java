package com.ctco.converter;

import com.ctco.utils.Log;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus-cp on 2017-07-31.
 */
public class DateConverter extends DefaultTypeConverter {

    @Override
    public Object convertValue(Object value, Class toType) {
        Log.log("value" + value);
        Log.log("toType.getName() = " + toType.getName());
        /*if(value == null || value.equals("")){
            return false;
        }*/
        /*if(toType != Date.class){
            return false;
        }*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
        Date result = null;
        try {
            //注意这里是数组，不是字符串，否则极容易转换出错
            String[] time = (String[]) value;
            Log.log("time = " + time[0]);
            result = simpleDateFormat.parse(time[0]);
            Log.log("result = " + result);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e.toString());
        }
        return result;
    }
}
