package com.example.forma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class total extends MainActivity {
    EditText t,m;
    String d;
    Float a;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        setContentView(R.layout.activity_total);
        t=findViewById(R.id.total);
        m=findViewById(R.id.awelkathya);
        d=basededonne.firstdate();
        m.setText(d);
        a=basededonne.total();
        t.setText(Float.toString(a));

    }
}
