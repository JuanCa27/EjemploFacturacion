/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Base_Datos.BD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Cliente {
    
    private int Cedula;
    private String Nombre;
    private String Email;
    private int Telefono;

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    
    
    public Cliente(){
    Cedula = 0;
    Nombre = "";
    Email = "";
    Telefono = 0;
    }
    
    public int Nuevo() 
    {
      // TODO add your handling code here:
        String Sql;
        int resultado;
        Sql="insert into clientes (cedula, nombre, email, telefono ) " +
                "values ('" +Cedula + "','" + Nombre + "','" + Email + " ',"+Telefono+")";
       resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
    }
    
    public int Eliminar() 
    {
// TODO add your handling code here:
         String Sql;
         int resultado;
        Sql="delete from clientes where cedula='"+ Cedula + "'";
     resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
}
    public int Actualizar()
       {
         String Sql;
         int resultado;
         //me actualiza lo que se digita en los txt.
        Sql="update clientes set nombre='" + Nombre + "', email ='"+ Email+ "', telefono= " + Telefono + 
                " Where cedula='"+ Cedula + "'";
      resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
}
   public ResultSet Obtener_Datos(String pvar) 
   {
    // TODO add your handling code here:
         
         try{
         String Sql="Select * from clientes Where cedula='"+ pvar + "'";
         //el  return llama a la clase bd y al método retornar registro indicando q el nuevo parametro va a ser sql.
   return BD.RetornarRegistro(Sql);
        }
catch(SQLException e){
   return null;
    }
   }
   
   public ResultSet Otener_Todos() 
   {
         
         try{
         String Sql="Select * from clientes";
   //el  return llama a la clase bd y al método retornar registro indicando q el nuevo parametro va a ser sql.
   return BD.RetornarRegistro(Sql);
        }
catch(SQLException e){
   return null;
    }
   }
}
