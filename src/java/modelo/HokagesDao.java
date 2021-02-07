/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EVE
 */
public class HokagesDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    
    
    public Hokages Validar(String user, String pass){
     Hokages hokage = new Hokages();
        String  sql="select * from hokages where username= ? and pass =?";
     con=cn.Conexion();
     try{
         ps=con.prepareStatement(sql);
         ps.setString(1, user);
         ps.setString(2, pass);
         rs = ps.executeQuery();
         
        rs.next();
         do{
              hokage.setId(rs.getInt("id"));
                hokage.setUser(rs.getString("username"));
                hokage.setPass(rs.getString("pass"));
         }while(rs.next());
         
         
         
         
         
     }catch(SQLException e ){
         
     } return hokage;
     
        
        
        
    
}
    public List Listar(){
        List<Hokages> lista= new ArrayList<>();
        
        String sql="select * from hokages";
        con=cn.Conexion();
        try{
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Hokages hokage= new Hokages();
                hokage.setId(rs.getInt("id"));
                hokage.setUser(rs.getString("username"));
                hokage.setPass(rs.getString("pass"));
                
                lista.add(hokage);
                
                
            }
            
            
        }catch (SQLException e){
            
            
        }
        
        return lista;
        
    }
    
    
        
    }

