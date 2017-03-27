package com.example.soulbro.jardin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class HotelDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter; //permite adaptar los fragmentos que quiero colocarle

    private ViewPager mViewPager;

    String username, correo;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        username =extras.getString("username"); //recibo la info proveniente de LoginActivity y que este obtuvo de RegisterAct
        correo  = extras.getString("correo");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //otra forma de hacer un listener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
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
        getMenuInflater().inflate(R.menu.hotel_d, menu);
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
    //este es el metodo del listener
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {  //Va a ser para acceder al MainActivity

            intent = new Intent(HotelDActivity.this,MainDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
        }
        else if (id == R.id.nav_gallery) //Sitios Activity
        {
            intent = new Intent(HotelDActivity.this,SitiosDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
        }
        else if (id == R.id.nav_slideshow) //Restaurantes Activity
        {
            intent = new Intent(HotelDActivity.this,RestauDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);


        }
        else if (id == R.id.nav_manage) //Cerrar sesion
        {
            intent = new Intent(HotelDActivity.this,LoginActivity.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //        return PlaceholderFragment.newInstance(position + 1);


            //unica cosa a programar
            switch (position)
            {

                case 0:
                    HotelUnoFragment tab1= new HotelUnoFragment();
                    return tab1;


                case 1:
                    HotelDosFragment tab2 = new HotelDosFragment();
                    return tab2;


                case 2:
                    HoteltresFragment tab3 = new HoteltresFragment();
                    return tab3;
                default: return null;

            }


        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.hoteluno);
                case 1:
                    return getResources().getString(R.string.hoteldos); //"HOTEL 2";
                case 2:
                    return getResources().getString(R.string.hoteltres);//"HOTEL 3";
            }
            return null;
        }
    }







}
