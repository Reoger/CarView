package com.create.carview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.cheshouye.api.client.WeizhangClient;
import com.cheshouye.api.client.WeizhangIntentService;
import com.cheshouye.api.client.json.CarInfo;
import com.cheshouye.api.client.json.WeizhangResponseJson;



public class MainActivity extends AppCompatActivity {
    private int mCityId;
    private WeizhangResponseJson info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent weizhangIntent = new Intent(this, WeizhangIntentService.class);
        weizhangIntent.putExtra("appId",1704);// 您的appId
        weizhangIntent.putExtra("appKey", "ecd215026a372d727020edc01dabf8a7");// 您的appKey
        startService(weizhangIntent);

    }

    public void TestConnect(View view){

       // step4();
        Intent intent = new Intent(MainActivity.this,ProvinceList.class);
        startActivity(intent);
        Log.e("TAG",mCityId+"数字");
    }

    public void step4() {

        // 声明一个子线程
        new Thread() {
            @Override
            public void run() {
                // 这里写入子线程需要做的工作

                CarInfo car = new CarInfo();
                car.setChepai_no("粤B12345");
                car.setChejia_no("123456");
                car.setEngine_no("");
                car.setRegister_no("");
                car.setCity_id(109);


                 info = WeizhangClient.getWeizhang(car);

                System.out.println(info.toJson());
                int status = info.getStatus();
                System.out.println(status);

            }
        }.start();
    }



    public  void test2(View view){

        startResultList();
        }



    public void startResultList(){
        CarInfo car = new CarInfo();
        car.setChepai_no("粤B12345");
        car.setChejia_no("123456");
        car.setEngine_no("");
        car.setRegister_no("");

        //这里需要通过用户选择要查询的地区，
        car.setCity_id(109);

        Bundle bundle = new Bundle();
        bundle.putSerializable("carInfo", car);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(MainActivity.this, WeizhangResul.class);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TAG","A");
        if(data == null){
            return;
        }
        switch (requestCode){
            case 2002:
                Bundle bundle = data.getExtras();
                Log.e("TAG","B");
                String cityId = bundle.getString("city_id");
                String cityName = bundle.getString("city_name");
                mCityId= Integer.parseInt(cityId);
                Log.e("TAG","C");
                Log.e("TAG","A"+cityName);
                break;
        }
    }
}
