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
public class Usuarios {
    private int CedulaUsuario;
    private String Nombre;
    private String Contraseña;
    private String Usuario;
    
    private static Usuarios instance;

    public int getCedulaUsuario() {
        return CedulaUsuario;
    }

    public void setCedulaUsuario(int CedulaUsuario) {
        this.CedulaUsuario = CedulaUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

   public static Usuarios getInstance() {
        if (instance == null)
            instance = new Usuarios();
        return instance;
    }
      public Usuarios() {
    CedulaUsuario = 0;
    Nombre = "";
    Contraseña= "";
    }
 
       
    public int Nuevo() 
    {
      // TODO add your handling code here:
        String Sql;
        int resultado;
        Sql="insert into Usuarios (cedulaUsuario, nombre, contraseña) " +
                "values ('" +CedulaUsuario + "','" + Nombre + "'," + Contraseña +")";
       resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
    }
    
    public int Eliminar() 
    {
// TODO add your handling code here:
         String Sql;
         int resultado;
        Sql="delete from Usuarios where cedulaUsuario='"+ CedulaUsuario + "'";
     resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
}
    public int Actualizar()
       {
               // TODO add your handling code here:
         String Sql;
         int resultado;
        Sql="update usuarios set nombre='" + Nombre + "', contraseña='"+ Contraseña+ 
                "' Where CedulaUsuario='"+ CedulaUsuario + "'";
      resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
}
   public ResultSet Obtener_Datos(String pvar) 
   {
    // TODO add your handling code here:
         
         try{
         String Sql="Select * from Usuarios Where CedulaUsuario='"+ pvar + "'";
   return BD.RetornarRegistro(Sql);
        }
catch(SQLException e){
   return null;
    }
   }
   
   public ResultSet Otener_Todos() 
   {
    // TODO add your handling code here:
         
         try{
         String Sql="Select * from Usuarios";
   return BD.RetornarRegistro(Sql);
        }
catch(SQLException e){
   return null;
    }
   }
}
