package com.create.testserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void test(View view){
        //Button的点击事件
        Person person = new Person();
        person.setAge(18);
        person.setName("Reoger");
        person.setSex("male");
        person.setPhone(131110);
        Bundle bundle = new Bundle();
        bundle.putSerializable("person",person);
        //传递对象实例
        Intent intent = new Intent(this,NextActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
