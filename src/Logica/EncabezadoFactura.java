/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Base_Datos.BD;
import static Base_Datos.BD.Conectar;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pc
 */
public class EncabezadoFactura {
    
    private int IdFactura;
    private String Fecha;
    private int IdCliente;
    private int TotalFactura;
    public DetalleFactura DetalleFactura = new DetalleFactura();

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getTotalFactura() {
        return TotalFactura;
    }

    public void setTotalFactura(int TotalFactura) {
        this.TotalFactura = TotalFactura;
    }
    
    
    public EncabezadoFactura(){
    IdFactura=0;
    Fecha="";
    IdCliente=0;
    TotalFactura=0;
    }
    
    public int Nuevo() 
    {
      // TODO add your handling code here:
        String Sql;
        int resultado;

        Sql="insert into encabezadoFactura (idFactura,fecha, idCliente,totalFactura) " +
                "values (" + IdFactura+ ",'" + Fecha + "',"+IdCliente+","+TotalFactura+")";
       resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
    }
    
     public ResultSet Obtener_Id_Factura() 
   {
    // TODO add your handling code here:
         
         try{
         String Sql="Select max(idFactura) as idFactura from encabezadofactura";
   return BD.RetornarRegistro(Sql);
        }
catch(SQLException e){
   return null;
    }
   }
}
