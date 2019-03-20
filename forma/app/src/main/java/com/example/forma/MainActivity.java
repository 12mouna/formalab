package com.example.forma;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<model> mylist;
    public static adapter array ;
    ListView l;

    public static basededonne basededonne ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=findViewById(R.id.liste);
        mylist=new ArrayList<model>();
        basededonne=new basededonne(this);
        mylist= basededonne.afficher();
        array =new adapter(this,R.layout.activity_model,mylist);
        l.setAdapter(array);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(MainActivity.this).setTitle("Delete").setMessage("do want to delete this?").setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        basededonne.remove(mylist.get(position).getId());
                        mylist=basededonne.afficher();

                        array=new adapter(MainActivity.this,R.layout.activity_model,mylist);

                        l.setAdapter(array);
                        Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_SHORT).show(); }}).setNegativeButton(android.R.string.no, null).setIcon(android.R.drawable.ic_lock_lock).show();


            }

        }     );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId()== R.id.ajouter){
            Intent intent=new Intent(MainActivity.this,ajouter.class);
            startActivity(intent);}
        if (item.getItemId()== R.id.total){
            Intent intent= new Intent(MainActivity.this, total.class);
            startActivity(intent);}
        return true;
    }



}


