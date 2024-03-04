package com.example.login;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class usingUsuario extends com.example.login.user {
    Context c;
    SQLiteDatabase sql;
    ArrayList<user> lista;
    String db = "DBuser";
    String tabla = "CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY AUTOINCREMENT, user text, password text, rol text )";
    public usingUsuario(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(db, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        insertDefaultUsers();
    }
      public boolean insertUser(String user, String password, String rol){
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("password", password);
        contentValues.put("rol", rol);
        long result = sql.insert("users", null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }
    private void insertDefaultUsers() {
        // Introduce la información de usuario para tres roles por defecto.
        String defaultPassword = "Admin"; // Considera el uso de contraseñas más seguras
        insertUser("Administrador", defaultPassword, "Administrador");
        insertUser("Operador", defaultPassword, "Operador");
        insertUser("Encargado", defaultPassword, "Encargado");
    }

    public ArrayList<user> selectUsers(){
        ArrayList<user> Lista= new ArrayList<user>();
        lista.clear();
        Cursor cr= sql.rawQuery("SELECT * FROM users", null);
        if (cr!=null&& cr.moveToFirst()){
            do {
                user u=new user();
                u.setId(cr.getInt(0));
                u.setUser(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setRol(cr.getString(3));
                lista.add(u);
            }while (cr.moveToNext());

        }
        return lista;
    }


    public int login(String u, String p){
        int comparador=0;
        Cursor cr=sql.rawQuery("SELECT * FROM users", null);
        if(cr!=null && cr.moveToFirst()){
            do {
                if (cr.getString(1).equals(u)&& cr.getString(2).equals(p)){
                    comparador++;
                }
            }while (cr.moveToNext());
        }
        return comparador;
    }
    
    public  user getUser(String u, String p){
        lista= selectUsers();
        for(user ignore: lista){
            if (ignore.getUser().equals(u) && ignore.getPassword().equals(p)){
                return ignore;
            }
        }
        return null;
    }

    public  user getUserById( int id){
        lista= selectUsers();
        for(user ingor: lista){
            if (ingor.getId()==id){
                return ingor;
            }
        }
        return null;
    }

}