package com.example.dell.myapplication.db;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: GreenDaoDone-master
 * @Package com.example.dell.myapplication.db
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/18 10:08
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
@Entity
public class DownListDb {
    @Id(autoincrement = true)
    private Long id;
    @Convert(converter = ListVoConverter.class, columnType = String.class)
    private List<ListVo> data;
    private String oid;
    @Generated(hash = 998478592)
    public DownListDb(Long id, List<ListVo> data, String oid) {
        this.id = id;
        this.data = data;
        this.oid = oid;
    }
    @Generated(hash = 2042778581)
    public DownListDb() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<ListVo> getData() {
        return this.data;
    }
    public void setData(List<ListVo> data) {
        this.data = data;
    }
    public String getOid() {
        return this.oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }

}
