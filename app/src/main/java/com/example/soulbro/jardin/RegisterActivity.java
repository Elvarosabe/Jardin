package com.example.soulbro.jardin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    EditText nameUs,fpass,spass,correo;
    Button Registra,Cancela;

    String usuario="",contra="",mail="",contrados="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nameUs  =  (EditText) findViewById(R.id.tunom);
        fpass  =   (EditText) findViewById(R.id.tucontra);
        spass  =   (EditText) findViewById(R.id.tucontra2);
        correo =   (EditText) findViewById(R.id.tucorreo);
        Registra= (Button) findViewById(R.id.bregistra);
        Cancela = (Button) findViewById(R.id.bcancela);



        //Clic para Registrar usuario(enviar datos a la otra actividad)
        Registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(nameUs.getText().toString().equals("") && fpass.getText().toString().equals("") && spass.getText().toString().equals("") &&  correo.getText().toString().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();

                }

                // pendiente validar que todos los campos esten llenos
                //pendiente validar pass iguales y  que las contraseñas sean iguales
                else
                {
                    usuario = nameUs.getText().toString();
                    contra = fpass.getText().toString();
                    contrados = spass.getText().toString();
                    mail   = correo.getText().toString();


                         //defino el elemento para conectarme, aqui estoy respondiendole a alguien que me llamo
                        //putExtra me permite enviar informacion a quien me llamo

                    if (fpass.getText().toString().equals(spass.getText().toString()) )
                    {
                        Intent intent = new Intent();

                        intent.putExtra("username", nameUs.getText().toString()); //envio mi nombre de usuario a Login
                        intent.putExtra("password", fpass.getText().toString());//envio mi contraseña a login
                        intent.putExtra("correo", correo.getText().toString()); //envio mi correo a login
                        setResult(RESULT_OK, intent); //configuro mi resultado y envio mi informacion
                        finish();
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext()," Las contraseñas deben ser iguales ",Toast.LENGTH_SHORT).show();

                    }
                        //termino mi llamado y destruye mi actividad
                     //   Toast.makeText(getApplicationContext()," Las contraseñas deben ser iguales ",Toast.LENGTH_SHORT).show();
                       // fpass.setText("");
                        //spass.setText("");


                }



                //En caso de que las contraseñas sean invalidads o no esten llene todds los campos
                //se debe mostrar mensajes o notificacion tipo TOAST

            }
        });



        //Clic para regresar a la actividad anterior
        Cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //aqui estoy respondiendole a alguien que me llamo
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });







    }
}
