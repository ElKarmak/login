package com.example.login;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText user, password;
    Button loginEntrar;
usingUsuario doa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.usermane_input);
        password=(EditText)findViewById(R.id.password_input);
        loginEntrar=(Button)findViewById(R.id.loginEntrar);
        doa=new usingUsuario(this);
        loginEntrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int i = v.getId();
        if (i == R.id.loginEntrar) {

          String u=user.getText().toString();
          String p=password.getText().toString();

          if (u.equals("")&& p.equals("")){
              Toast.makeText(this, "ERROR CAMPOS VACÍOS!", Toast.LENGTH_SHORT).show();
          }else  if(doa.login(u,p)==1){
              user ux=doa.getUser(u,p);
              Toast.makeText(this, "DATOS CARERCTOS!", Toast.LENGTH_SHORT).show();
              Intent inteto=new Intent(MainActivity.this,welcome.class);
              inteto.putExtra("id", ux.getId());
              startActivity(inteto);
              finish();
          }else {
              Toast.makeText(this, "USUARIO y/O PASSWORD incorrectos!", Toast.LENGTH_SHORT).show();
          }

        }

    }

}