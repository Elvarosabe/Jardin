package com.example.soulbro.jardin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario,eClave;
    Button biniciar;
    TextView reg;

    String username="";
    String password="";
    String correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Enlace java-xml
        eUsuario = (EditText) findViewById(R.id.usuario);
        eClave   = (EditText) findViewById(R.id.clave);
        reg      = (TextView) findViewById(R.id.reg); //Para registrarse
        biniciar = (Button)   findViewById(R.id.inses);

        /* Estas lineas de aqui no van a funcionar, simplemente es para exponer el uso del bundle
        //Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        //extras.getString("username"); //estoy cargando la etiqueta con la que lo guarde o cree
        */



        //clic de registrarse
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent= new Intent(LoginActivity.this, RegisterActivity.class); //me permite abrir una actividad
                startActivityForResult(intent,1234); //llamo a la sgte actividad pero me quedare esperando una confirmacion y enviare un codigo
            }
        });



        //abrir actividad de iniciar sesion
        biniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar que el usuario y contraseña sean iguales a los recibidos
                if (eUsuario.getText().toString().equals(username) && eClave.getText().toString().equals(password)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("password",password);
                    intent.putExtra("correo",correo);
                    startActivity(intent); //estoy enviando nformacion en una sola direccion hacia mi perfil_Activity
                }
            }
        });





    }

    //Este metodo me permite recibir la respuesta de la actividad que llame inicialmente
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1234 && resultCode==RESULT_OK)
            {
                username = data.getExtras().getString("username"); //aqui almaceno lo que guarde desde register activity
                password = data.getExtras().getString("password");//aqui almaceno lo que guarde desde register activity
                correo   = data.getExtras().getString("correo");//aqui almaceno lo que guarde desde register activiy
                //Log.d("nombre",data.getExtras().getString("username")); //me permite ver lo que estoy recibiendo pero en consola en vez de en la app como tal
            }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED)
        {
            Toast.makeText(this, "Error en login", Toast.LENGTH_SHORT).show();

        }



    }
}
