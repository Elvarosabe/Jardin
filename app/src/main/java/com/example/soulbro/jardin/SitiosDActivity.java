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

public class SitiosDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter; //permite adaptar los fragmentos que quiero colocarle

    private ViewPager mViewPager;

    String username, correo;
    Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_d);
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
        getMenuInflater().inflate(R.menu.sitios_d, menu);
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

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
            intent = new Intent(SitiosDActivity.this,MainDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
        }
        else if (id == R.id.nav_gallery)
        {
            intent = new Intent(SitiosDActivity.this,HotelDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
        }
        else if (id == R.id.nav_slideshow)
        {
            intent = new Intent(SitiosDActivity.this,RestauDActivity.class);
            intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
            intent.putExtra("correo",correo);
            startActivity(intent);
        }
        else if (id == R.id.nav_manage)
        {
            intent = new Intent(SitiosDActivity.this,LoginActivity.class);
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
            // return PlaceholderFragment.newInstance(position + 1);

            //unica cosa a programar
            switch (position)
            {

                case 0:
                    Sitio_unoFragment tab1 = new Sitio_unoFragment();
                    return tab1;


                case 1:
                    Sitio_dosFragment tab2 = new Sitio_dosFragment();
                    return tab2;


                case 2:
                    Sitio_tresFragment tab3 = new Sitio_tresFragment();
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
                    return  getResources().getString(R.string.sitiouno);
                case 1:
                    return getResources().getString(R.string.sitiodos);
                case 2:
                    return getResources().getString(R.string.sitiotres);
            }
            return null;
        }
    }

}
