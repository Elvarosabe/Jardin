package com.example.soulbro.jardin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView mostrar,mos2;
    String user,correo,aux,aux2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        mostrar = (TextView) findViewById(R.id.muestralo);
        mos2    = (TextView) findViewById(R.id.muestralo2);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        user =extras.getString("username"); //recibo la info proveniente de LoginActivity y que este obtuvo de RegisterAct
        correo  = extras.getString("correo");

        aux = " Nombre de Usuario: " + user;
        aux2= " Correo Electrónico: " + correo;
        mostrar.setText(aux);
        mos2.setText(aux2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    @Override //con este voy a validar que opcion del menu(que item) que la que presiono
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.pagprinc:
                //llamo mi actividad
                Intent intent = new Intent();
                // intent = new Intent(PerfilActivity.this,MainActivity.class);
                setResult(RESULT_OK, intent);
                finish();
                //startActivity(intent);
                break;

            case R.id.hoteles:

                intent = new Intent(PerfilActivity.this,HotelDActivity.class);
                intent.putExtra("username",user); //envio mi nombre de usuario a PerfilActivity
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.sitios:

                intent = new Intent(PerfilActivity.this,SitiosDActivity.class);
                intent.putExtra("username",user); //envio mi nombre de usuario a PerfilActivity
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.rest:

                intent = new Intent(PerfilActivity.this,RestauDActivity.class);
                intent.putExtra("username",user); //envio mi nombre de usuario a PerfilActivity
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.mLogOut:
                intent =new Intent(PerfilActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();


                break;

        }


        return true;
    }



}
