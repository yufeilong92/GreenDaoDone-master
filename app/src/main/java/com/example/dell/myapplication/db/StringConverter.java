package com.example.dell.myapplication.db;

import com.example.dell.myapplication.UserData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: GreenDaoDone-master
 * @Package com.example.dell.myapplication.db
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/9 9:05
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class StringConverter implements PropertyConverter<List<UserData>, String> {
    private final Gson mGson;

    public StringConverter() {
        mGson = new Gson();
    }

    @Override
    public List<UserData> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {

            Type type = new TypeToken<ArrayList<UserData>>() {
            }.getType();
            ArrayList<UserData> list = mGson.fromJson(databaseValue, type);
            return list;

        }
    }

    @Override
    public String convertToDatabaseValue(List<UserData> entityProperty) {
        if (entityProperty == null)
            return null;
        else {
            return mGson.toJson(entityProperty);
        }
    }
}
