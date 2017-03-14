package com.example.soulbro.jardin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String username, correo;
    Intent intent; //instancia de mi objeto tipo intent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        username =extras.getString("username"); //recibo la info proveniente de LoginActivity y que este obtuvo de RegisterAct
        correo  = extras.getString("correo"); //recibo la info proveniente de LoginActivity y que este obtuvo de RegisterAct
    }

    @Override //con este cree el menu
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu); //sigue siendo un recurso entonces lo llamo de esta forma
        return true;
    }


    @Override //con este voy a validar que opcion del menu(que item) que la que presiono
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

            switch (id)
            {
                case R.id.miPerfil:
                    //llamo mi actividad
                     intent = new Intent(MainActivity.this,PerfilActivity.class);
                    intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                    intent.putExtra("correo",correo); //envio mi correo de usuario a PerfilActivity
                    startActivity(intent);
                    break;

                case R.id.hoteles:

                    intent = new Intent(MainActivity.this,HotelActivity.class);
                    intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                    break;

                case R.id.sitios:

                    intent = new Intent(MainActivity.this,SitiosActivity.class);
                    intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                    break;

                case R.id.rest:

                    intent = new Intent(MainActivity.this,RestaurantesActivity.class);
                    intent.putExtra("username",username); //envio mi nombre de usuario a PerfilActivity
                    intent.putExtra("correo",correo);
                    startActivity(intent);

                    break;

                case R.id.mLogOut:
                     intent =new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);


                    break;



            }


        return true;
    }
}
