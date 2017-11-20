package com.josesp.hackspace_reto1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.josesp.hackspace_reto1.model.UsuarioDB;
import com.josesp.hackspace_reto1.model.UsuarioDBHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtEmail = findViewById(R.id.txt_login_email);
        final EditText txtPassword = findViewById(R.id.txt_login_password);

        final UsuarioDBHelper dbHelper = new UsuarioDBHelper(this);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                String [] proyeccion = {
                        UsuarioDB.UsuarioEntrada.correo_col1,
                        UsuarioDB.UsuarioEntrada.nombre_col2,
                        UsuarioDB.UsuarioEntrada.phone_col3
                };

                String seleccion = UsuarioDB.UsuarioEntrada.correo_col1 +" = ?  and "
                        + UsuarioDB.UsuarioEntrada.password_col4 + " = ?";

                String [] seleccionArgs = {
                        txtEmail.getText().toString(),
                        txtPassword.getText().toString()
                };

                Cursor cursor = db.query(
                        UsuarioDB.UsuarioEntrada.TABLA_NOMBRE,
                        proyeccion,
                        seleccion,
                        seleccionArgs,
                        null,
                        null,
                        null
                );

                if(cursor.moveToFirst()){
                    //Toast.makeText(getBaseContext(),"Acceso : " + cursor.getString(1) , Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getBaseContext(), UserActivity.class);
                    intent.putExtra("name",cursor.getString(1));
                    intent.putExtra("email",cursor.getString(0));
                    intent.putExtra("phone",cursor.getString(2));
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getBaseContext(), "Usuario no registrado", Toast.LENGTH_LONG).show();
                }
                //"Acceso : " + cursor.getString(1) + ""
                //cursor.moveToFirst();
                cursor.close();

            }

        });

    }

    public void onButtonSingUpclick(View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment)fragmentManager.findFragmentByTag(RegisterDialog.TAG);

        if(dialogFragment == null){
            dialogFragment = new RegisterDialog();

            Bundle bundle = new Bundle();
            bundle.putString("message", RegisterDialog.MESSAGE);
            dialogFragment.setArguments(bundle);
        }

        //DialogFragment dialogFragment =  new RegisterDialog();
        dialogFragment.show(getSupportFragmentManager(), RegisterDialog.TAG);
    }
    /*
    @Override
    public void onLoginButtonClick() {
        Toast.makeText(this,"ingresando",Toast.LENGTH_LONG).show();
    }
    */
}

