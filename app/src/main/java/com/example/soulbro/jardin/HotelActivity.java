package com.example.soulbro.jardin;

import android.content.Intent;
import android.support.design.widget.TabLayout;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class HotelActivity extends AppCompatActivity {

    String username, correo;


    Intent intent,intent1;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter; //permite adaptar los fragmentos que quiero colocarle

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        username =extras.getString("username"); //recibo la info proveniente de LoginActivity y que este obtuvo de RegisterAct
        correo  = extras.getString("correo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hotel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id)
        {
            /*case R.id.hot:

                //intent = new Intent(HotelActivity.this,MainActivity.class);
                //startActivity(intent);
                Intent intent = new Intent();
                // intent = new Intent(PerfilActivity.this,MainActivity.class);
                setResult(RESULT_OK, intent);
                finish();

              */  //break;

            case R.id.miPerfil:
                //llamo mi actividad
                intent = new Intent(HotelActivity.this,PerfilActivity.class);
                intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;


            case R.id.sitios:

                intent = new Intent(HotelActivity.this,SitiosActivity.class);
                intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                intent.putExtra("correo",correo);
                startActivity(intent);
                //finish();
                break;

            case R.id.rest:

                intent = new Intent(HotelActivity.this,RestaurantesActivity.class);
                intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                intent.putExtra("correo",correo);
                startActivity(intent);
                //finish();
                break;


            case R.id.mLogOut:
                intent =new Intent(HotelActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

                break;

        }


        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
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
