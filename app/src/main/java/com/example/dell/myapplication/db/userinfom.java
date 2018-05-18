package com.example.dell.myapplication.db;

import com.example.dell.myapplication.Stuidon;
import com.example.dell.myapplication.UserData;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: userinfom.java
 * @Package com.example.dell.myapplication.db
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/8 23:40
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/8 星期二
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Entity
public class userinfom {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private boolean isreight;
    @Convert(converter = StudioConvertrer.class, columnType = String.class)
    private Stuidon stuInfom;
    private String date;
    @Convert(converter = StringConverter.class, columnType = String.class)
    private List<UserData> mDatas;
    @Generated(hash = 2121446061)
    public userinfom(Long id, String name, boolean isreight, Stuidon stuInfom,
            String date, List<UserData> mDatas) {
        this.id = id;
        this.name = name;
        this.isreight = isreight;
        this.stuInfom = stuInfom;
        this.date = date;
        this.mDatas = mDatas;
    }
    @Generated(hash = 1704430872)
    public userinfom() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsreight() {
        return this.isreight;
    }
    public void setIsreight(boolean isreight) {
        this.isreight = isreight;
    }
    public Stuidon getStuInfom() {
        return this.stuInfom;
    }
    public void setStuInfom(Stuidon stuInfom) {
        this.stuInfom = stuInfom;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<UserData> getMDatas() {
        return this.mDatas;
    }
    public void setMDatas(List<UserData> mDatas) {
        this.mDatas = mDatas;
    }

}
