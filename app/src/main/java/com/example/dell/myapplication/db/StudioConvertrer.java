package com.example.dell.myapplication.db;

import com.example.dell.myapplication.Stuidon;
import com.google.gson.Gson;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.IllegalFormatCodePointException;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: GreenDaoDone-master
 * @Package com.example.dell.myapplication.db
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/9 14:50
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class StudioConvertrer implements PropertyConverter<Stuidon, String> {

    private final Gson gson;

    public StudioConvertrer() {
        gson = new Gson();
    }

    @Override
    public Stuidon convertToEntityProperty(String databaseValue) {
        if (databaseValue == null)
            return null;
        else {
            return new Gson().fromJson(databaseValue, Stuidon.class);
        }
    }

    @Override
    public String convertToDatabaseValue(Stuidon entityProperty) {
        if (entityProperty == null)
            return null;
        else {
            return new Gson().toJson(entityProperty);
        }
    }
}
