package com.example.soulbro.jardin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //fragmento dinamico
        //FragmentManager fm = getFragmentManager();
        //FragmentTransaction ft=fm.beginTransaction();

        //instancia de mi fragment
        //HotelUnoFragment fragment = new HotelUnoFragment();
        //ft.add(android.R.id.content,fragment).commit(); //ojo con lo de las librerias de soporte


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu3,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id =item.getItemId();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        //instancia de mi fragment




        /*switch (id)
        {
            case R.id.mhotel1:
                HotelUnoFragment fragment = new HotelUnoFragment();
                ft.replace(android.R.id.content,fragment).commit(); //ojo con lo de las librerias de soporte

                break;


            case R.id.mhotel2:
                HotelDosFragment fragment2 = new HotelDosFragment();
                ft.replace(android.R.id.content,fragment2).commit(); //ojo con lo de las librerias de soporte

                break;




        }*/

        return true;
    }
}

