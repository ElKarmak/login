package com.example.login;




import static com.example.login.usuariocontroller.obtenerRol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private String user;
    private String miButton;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.login_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user= String.valueOf(findViewById(R.id.password_input));
                password= String.valueOf(findViewById(R.id.password_input));

                boolean Credenciales= usuariocontroller.verificarCredenciales(user,password);

                if (Credenciales){
                    String rol= obtenerRol(user);
                    Intent intetar= new Intent(MainActivity.this, usuariocontroller.class);
                    MainActivity.this.startActivity(intetar);

                }else{

                    Toast.makeText(MainActivity.this, "Error de usuario", Toast.LENGTH_SHORT).show();
                }




            }
        });




    }
}