package com.example.soulbro.jardin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    String username, correo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        List<Componentes> items = new ArrayList<>(); //Inicializo mi lista de componentes

        //Defino que va a llevar cada molde de lo que cree con el recyclerview
        items.add(new Componentes(R.drawable.iglesia," Historia"));
        items.add(new Componentes(R.drawable.personaje1," Personajes"));
        items.add(new Componentes(R.drawable.funda,"Ubicación"));

        //Para obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);



        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ComponentesAdapter(items);
        recycler.setAdapter(adapter);
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recycler ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //Toast.makeText(getApplicationContext(), "position" + position, Toast.LENGTH_SHORT).show();
                        switch (position)
                        {
                            case 0:
                                intent = new Intent(MainDActivity.this,SitiosDActivity.class);
                                intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                                intent.putExtra("correo",correo);
                                startActivity(intent);
                                break;

                            case 1:
                                intent = new Intent(MainDActivity.this,RestauDActivity.class);
                                intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                                intent.putExtra("correo",correo);
                                startActivity(intent);
                                break;


                            case 2:
                                intent = new Intent(MainDActivity.this,HotelDActivity.class);
                                intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                                intent.putExtra("correo",correo);
                                startActivity(intent);

                                break;


                        }



                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        username =extras.getString("username"); //recibo la info proveniente de LoginActivity y que este obtuvo de RegisterAct
        correo  = extras.getString("correo");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        //mViewPager = (ViewPager) findViewById(R.id.container);
        //mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager = (ViewPager) findViewById(R.id.container);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();




          if (id == R.id.nav_gallery) //Sitios
        {
            intent = new Intent(MainDActivity.this,SitiosDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
            //Toast.makeText(this, id, Toast.LENGTH_SHORT).show();

        }
          else if (id == R.id.nav_slideshow) // Restaurantes
          {
              intent = new Intent(MainDActivity.this,RestauDActivity.class);
              intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
              intent.putExtra("correo",correo);
              startActivity(intent);
             // Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
          }
        else if (id == R.id.hot) // Restaurantes
        {
            intent = new Intent(MainDActivity.this,HotelDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
           // Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_manage) //Cerrar sesion
        {
            intent =new Intent(MainDActivity.this,LoginActivity.class);
            startActivity(intent);

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
