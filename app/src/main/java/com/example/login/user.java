package com.example.login;

public class user {
    int id;
    String user, password , rol;

    public user() {

     }

    public user( String user, String password, String rol) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public boolean isNull(){
        if (user.equals("")&& password.equals("")&&rol.equals("")){
            return false;
        }else {
            return true;
        }
}

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
