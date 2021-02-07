/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;

/**
 *
 * @author EVE
 */
public class Hokages {
    int id;
    String user, pass;
   
    
            

    public Hokages() {
    }

    public Hokages(int id, String user, String pass, InputStream foto) {
        this.id = id;
        this.user = user;
        this.pass = pass;
       
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
