/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


 
public class ShibisDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    int r;
    
    
    
    public List Listar(){
        List<Shinobis> lista= new ArrayList<>();
        String sql = "select * from shinobis where estado ='activo'";
        
        try{
          
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                  Shinobis shinobi=new Shinobis();
                shinobi.setId(rs.getInt("id"));
                shinobi.setNomnrbre(rs.getString("nombre"));
                shinobi.setCloan(rs.getString("clan"));
                shinobi.setRango(rs.getString("rango"));
                shinobi.setEstado(rs.getString("estado"));
                shinobi.setMisionc(rs.getInt("misioncompletada"));
                shinobi.setMisionf(rs.getInt("misionfallida"));
                
                lista.add(shinobi);
                
                
                
                
                
            }
            
            
            
            
        }catch(SQLException e ){
            
        }
        
        return lista;
        
    }
    public List ListarInactivo(){
        List<Shinobis> lista= new ArrayList<>();
        String sql = "select * from shinobis where estado ='inactivo'";
        
        try{
          
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                  Shinobis shinobi=new Shinobis();
                shinobi.setId(rs.getInt("id"));
                shinobi.setNomnrbre(rs.getString("nombre"));
                shinobi.setCloan(rs.getString("clan"));
                shinobi.setRango(rs.getString("rango"));
                shinobi.setEstado(rs.getString("estado"));
                shinobi.setMisionc(rs.getInt("misioncompletada"));
                shinobi.setMisionf(rs.getInt("misionfallida"));
                
                lista.add(shinobi);
                
                
                
                
                
            }
            
            
            
            
        }catch(SQLException e ){
            
        }
        
        return lista;
        
    }
    
    public int agregar(Shinobis shinobi){
        String sentencia = "INSERT INTO shinobis (nombre,clan, rango, estado, misioncompletada, misionfallida) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, shinobi.getNomnrbre());
            ps.setString(2, shinobi.getCloan());
            ps.setString(3, shinobi.getRango());
            ps.setString(4, shinobi.getEstado());
            ps.setInt(5, shinobi.getMisionc());
            ps.setInt(6, shinobi.getMisionf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

}
     public int Actualizar(Shinobis shinobi) {
        String sentencia;
        sentencia = "UPDATE shinobis set nombre=?,clan=?, rango=?, estado=?, misioncompletada=?, misionfallida=? where id=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, shinobi.getNomnrbre());
            ps.setString(2, shinobi.getCloan());
            ps.setString(3, shinobi.getRango());
            ps.setString(4, shinobi.getEstado());
            ps.setInt(5, shinobi.getMisionc());
          
            ps.setInt(6, shinobi.getMisionf());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
      public void Eliminar(int id){
               String sql= "DELETE from shinobis where id=" + id;
               con=cn.Conexion();
               try{
                   ps=con.prepareStatement(sql);
                   ps.executeUpdate();
                   
               }
                   catch(SQLException e){
                           
                           }
               }
           
      public Shinobis ListarPorId(int id){
        Shinobis shinobi = new Shinobis();
        String consulta = "SELECT * FROM shinobis WHERE id="+id;
         con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                shinobi.setNomnrbre(rs.getString(2));
                shinobi.setCloan(rs.getString(3));
                shinobi.setRango(rs.getString(4));
                shinobi.setEstado(rs.getString(5));
                shinobi.setMisionc(rs.getInt(6));
                shinobi.setMisionf(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return shinobi;
        
    }
      
      public void ActualizarI(int id) {
        String sentencia = "UPDATE shinobis set estado='inactivo' WHERE id=" +id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
      public void ActualizarA(int id) {
        String sentencia = "UPDATE shinobis set estado='Activo' WHERE id=" +id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
      public void Actualizarm(String shinobi) {
        String sentencia = "UPDATE shinobis set misioncompletada=misioncompletada + 1 WHERE nombre='"+ shinobi +"'" ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
      public void Actualizarmf(String shinobi) {
        String sentencia = "UPDATE shinobis set misionfallida=misionfallida + 1 WHERE nombre='"+ shinobi +"'" ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ShibisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
      
}

