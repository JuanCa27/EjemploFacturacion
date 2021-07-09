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
public class Productos {
    
    private String Codigo;
    private String Nombre;
    private int Precio;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    
    public Productos() {
    Codigo = "";
    Nombre = "";
    Precio = 0;
    }
    
    public int Nuevo() 
    {
      // TODO add your handling code here:
        String Sql;
        int resultado;
        Sql="insert into productos (codigo, nombre, precio) " +
                "values ('" + Codigo + "','" + Nombre + "'," + Precio +")";
       resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
    }
    
    public int Eliminar() 
    {
         String Sql;
         int resultado;
        Sql="delete from productos where codigo='"+ Codigo + "'";
     resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
}
    public int Actualizar()
       {
         String Sql;
         int resultado;
        Sql="update productos set nombre='" + Nombre + "', precio="+ Precio+ 
                " Where codigo='"+ Codigo + "'";
      resultado=BD.Enviar_Sentencia(Sql);
         return resultado;

}
    
     public ResultSet Obtener_Datos(String pvar) 
   {
    // TODO add your handling code here:
         
         try{
         String Sql="Select * from productos Where codigo='"+ pvar + "'";
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
         String Sql="Select * from productos";
   return BD.RetornarRegistro(Sql);
        }
catch(SQLException e){
   return null;
    }
   }
    
}
