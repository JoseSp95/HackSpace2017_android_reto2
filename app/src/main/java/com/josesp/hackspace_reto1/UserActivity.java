package com.josesp.hackspace_reto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class UserActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name","NOMBRE");
        String email = bundle.getString("email", "EMAIL");
        String phone = bundle.getString("phone", "PHONE");

        TextView lblName = findViewById(R.id.name);
        TextView lblEmail = findViewById(R.id.lblEmail);
        TextView lblPhone  = findViewById(R.id.lblPhone);
        lblName.setText(name.toUpperCase());
        lblEmail.setText(email);
        lblPhone.setText(phone);

        TextView closeSesion = findViewById(R.id.close_sesion);
        closeSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
