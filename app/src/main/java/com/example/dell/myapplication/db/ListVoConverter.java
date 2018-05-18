package com.example.dell.myapplication.db;

import com.example.dell.myapplication.UserData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: GreenDaoDone-master
 * @Package com.example.dell.myapplication.db
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/18 10:11
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class ListVoConverter implements PropertyConverter<List<ListVo>, String> {
    private final Gson gson;
    public ListVoConverter() {
        gson = new Gson();
    }

    @Override
    public List<ListVo> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null)
            return null;
        else {
            Type type = new TypeToken<List<ListVo>>() {
            }.getType();
            ArrayList<ListVo> list = gson.fromJson(databaseValue, type);
            return list;
        }
    }

    @Override
    public String convertToDatabaseValue(List<ListVo> entityProperty) {
        if (entityProperty == null)
            return null;
        else {
            return new Gson().toJson(entityProperty);
        }
    }
}
