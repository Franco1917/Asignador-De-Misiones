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


public class MisionesDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    int r;
    
    public List listar(){
        List<Misiones> lista= new ArrayList<>();
        String sql="select * from misiones";
        try{
            
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Misiones mision = new Misiones();
                mision.setId(rs.getInt("id"));
                mision.setDescripcion(rs.getString("descripcion"));
                mision.setDificultad(rs.getString("dificultad"));
                mision.setShinobi(rs.getString("shinobi"));
                mision.setRango(rs.getString("rango"));
                mision.setEstado(rs.getString("estado"));
                mision.setResultado(rs.getString("resultado"));
                
                lista.add(mision);
                
                
                
            }
           
            
        }catch(SQLException e){
            
        }
        return lista;
        
    }
    
    public int Agregarm(Misiones mision) {
       
        String sentencia = "INSERT INTO misiones (descripcion,dificultad,shinobi,rango,estado,resultado) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, mision.getDescripcion());
            ps.setString(2, mision.getDificultad());
            ps.setString(3, mision.getShinobi());
            ps.setString(4, mision.getRango());
            ps.setString(5, mision.getEstado());
            ps.setString(6, mision.getResultado());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MisionesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

}
    public Misiones ListarPorId(int id){
        Misiones m = new Misiones();
        String consulta = "SELECT * FROM misiones WHERE id="+id;
         con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                m.setDescripcion(rs.getString(2));
                m.setDificultad(rs.getString(3));
                m.setShinobi(rs.getString(4));
                m.setRango(rs.getString(4));
                m.setEstado(rs.getString(6));
                m.setResultado(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MisionesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }
    
 public void ActualizarE(int id) {
        String sentencia = "UPDATE misiones set estado='finalizado', resultado='exito' WHERE id=" +id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MisionesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
 public void Actualizarf(int id) {
        String sentencia = "UPDATE misiones set estado='finalizado', resultado='fracaso' WHERE id=" +id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MisionesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
           

}
