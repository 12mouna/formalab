package com.example.forma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter extends MainActivity {
    EditText m,n;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        m=findViewById(R.id.chrit);
        n=findViewById(R.id.flous);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m1=m.getText().toString();
                String m2=n.getText().toString();
                model model = new model(m1,m2);
                basededonne.ajoutersomthg(model);

                Toast.makeText(ajouter.this, " ajouté ", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ajouter.this,MainActivity.class);
                startActivity(intent);
                mylist=basededonne.afficher();



            }
        });
    }


}
