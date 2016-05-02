package com.create.testserializable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by 24540 on 2016/5/2.
 */
public class NextActivity extends Activity {
 private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_next);
        text = (TextView) findViewById(R.id.text);
        Bundle bunder = this.getIntent().getExtras();
        Person person = (Person) bunder.get("person");
        text.setText("名字是："+person.getName()+" 年龄"+person.getAge()+" 电话"+person.getPhone()+" 性别"+person.getSex());
    }
}
