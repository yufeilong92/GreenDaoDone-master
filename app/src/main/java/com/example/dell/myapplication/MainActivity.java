package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.myapplication.db.DownListDb;
import com.example.dell.myapplication.db.DownListDbDao;
import com.example.dell.myapplication.db.ListVo;
import com.example.dell.myapplication.db.userinfom;
import com.example.dell.myapplication.db.userinfomDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        DBHelper.initDb(this);
        DBHelper.getDaoSession().getDownListDbDao().deleteAll();

    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn3 = (Button) findViewById(R.id.btn3);

        mBtn.setOnClickListener(this);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn4.setOnClickListener(this);
        mBtn5 = (Button) findViewById(R.id.btn5);
        mBtn5.setOnClickListener(this);
        mBtn6 = (Button) findViewById(R.id.btn6);
        mBtn6.setOnClickListener(this);
        mBtn7 = (Button) findViewById(R.id.btn7);
        mBtn7.setOnClickListener(this);
        mBtn8 = (Button) findViewById(R.id.btn8);
        mBtn8.setOnClickListener(this);
    }

    int a = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                userinfom userinfom = new userinfom();
                userinfom.setDate(++a + "");
                userinfom.setIsreight(true);
                userinfom.setName("小明");
                ArrayList<UserData> userData1 = new ArrayList<>();
                int b = 5;
                for (int i = 0; i < b; i++) {
                    UserData userData = new UserData();
                    userData.setId("" + i);
                    userData.setData("" + i);
                    userData.setTime("" + i);
                    userData1.add(userData);
                }
                userinfom.setMDatas(userData1);
                Stuidon stuidon = new Stuidon();
                stuidon.setName("龙");
                userinfom.setStuInfom(stuidon);
                DBHelper.getDaoSession().getUserinfomDao().insert(userinfom);
                break;
            case R.id.btn1:
                DBHelper.getDaoSession().getUserinfomDao().deleteAll();

                break;
            case R.id.btn2:
                userinfomDao dao = DBHelper.getDaoSession().getUserinfomDao();
                com.example.dell.myapplication.db.userinfom unique = dao.queryBuilder().where(userinfomDao.Properties.Date.eq("5")).unique();
                if (unique == null) {
                    return;
                }
                ArrayList<UserData> userData2 = new ArrayList<>();
                UserData userData = new UserData();

                userData.setId("小敏感和");
                userData.setData("小敏感和");
                userData.setTime("小敏感和");
                userData2.add(userData);
                com.example.dell.myapplication.db.userinfom userinfom1 = new userinfom();
                userinfom1 = unique;
                userinfom1.setMDatas(userData2);
                DBHelper.getDaoSession().getUserinfomDao().update(userinfom1);
                break;
            case R.id.btn3:
                List<com.example.dell.myapplication.db.userinfom> all =
                        DBHelper.getDaoSession().getUserinfomDao().loadAll();
                for (int i = 0; i < all.size(); i++) {
                    com.example.dell.myapplication.db.userinfom userinfom3 = all.get(i);
                    Log.d("yfl", "onClick: " + userinfom3.getName() + userinfom3.getDate());
                    Log.d("yfl", "onClick: " + userinfom3.getStuInfom().getName());
                    List<UserData> mDatas = userinfom3.getMDatas();
                    for (int i1 = 0; i1 < mDatas.size(); i1++) {
                        UserData userData23 = mDatas.get(i1);
                        Log.d("yfl", "onClick: " + userData23.getData() + "/////" + userData23.getId());
                    }
                }
                break;

            case R.id.btn4:
                DownListDbDao downListDbDao = DBHelper.getDaoSession().getDownListDbDao();
                DownListDb downListDb = new DownListDb();
                List<ListVo> data = new ArrayList<>();
                int a = 2;
                for (int i = 0; i < a; i++) {
                    ListVo listVo = new ListVo();
                    listVo.setId("i==" + i);
                    listVo.setName("小米==" + i);
                    data.add(listVo);
                }
                downListDb.setOid("22");
                downListDb.setData(data);
                downListDbDao.insert(downListDb);
                break;
            case R.id.btn5:
                DownListDbDao dbDao = DBHelper.getDaoSession().getDownListDbDao();
                List<DownListDb> list = dbDao.queryBuilder().where(DownListDbDao.Properties.Oid.eq("22")).list();
                Log.e("========", "onClick: " + list.size());
                for (int i = 0; i < list.size(); i++) {
                    DownListDb downListDb1 = list.get(i);
                    Log.e("yfl==========" + i, "onClick:\n " + downListDb1.getOid() + downListDb1);
                    List<ListVo> data1 = downListDb1.getData();
                    if (data1 != null && !data1.isEmpty())
                        for (int j = 0; j < data1.size(); j++) {
                            ListVo listVo = data1.get(j);
                            Log.e("yfl", "onClick: " + listVo.getName() + "\n" + listVo.getId());

                        }
                }


                break;
            case R.id.btn6:
                DBHelper.getDaoSession().getDownListDbDao().deleteAll();
                break;
            case R.id.btn7:
                DownListDbDao dbDao1 = DBHelper.getDaoSession().getDownListDbDao();
                List<DownListDb> list1 = dbDao1.queryBuilder().where(DownListDbDao.Properties.Oid.eq("22")).list();
                DownListDb downListDb1 = list1.get(0);
                List<ListVo> listVos = new ArrayList<>();
                int v2 = 3;
                for (int i = 0; i < v2; i++) {
                    ListVo listVo = new ListVo();
                    listVo.setName("龙龙");
                    listVo.setId("" + i);
                    listVos.add(listVo);
                }
                downListDb1.setData(null);
                dbDao1.update(downListDb1);
                break;
            case R.id.btn8:
                DownListDbDao dbDao2 = DBHelper.getDaoSession().getDownListDbDao();
                List<DownListDb> list2 = dbDao2.queryBuilder().where(DownListDbDao.Properties.Oid.eq("22")).list();
                for (int i = 0; i < list2.size(); i++) {
                    DownListDb db = list2.get(i);
                    if (i == 1)
                        dbDao2.deleteByKey(db.getId());
                }
                break;
        }

    }
}
