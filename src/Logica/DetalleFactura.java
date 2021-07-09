/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Base_Datos.BD;

/**
 *
 * @author pc
 */
public class DetalleFactura {
    
    private int IdDetalle;
    private int IdFactura;
    private String CodigoProducto;
    private int Precio;
    private int Cantidad;
    private int TotalLinea;

    public int getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getTotalLinea() {
        return TotalLinea;
    }

    public void setTotalLinea(int TotalLinea) {
        this.TotalLinea = TotalLinea;
    }
    
    
    public DetalleFactura() {
    IdFactura=0;
    CodigoProducto="";
    Precio=0;
    Cantidad=0;
    TotalLinea=0;
    }
        
    public int Nuevo() 
    {
      // TODO add your handling code here:
        String Sql;
        int resultado;
        Sql="insert into detalleFactura (idFactura,codigoProducto,precio,cantidad,totalLinea) " +
                "values (" + IdFactura + ",'" + CodigoProducto + "'," + Precio + ","+Cantidad+","+TotalLinea+")";
       resultado=BD.Enviar_Sentencia(Sql);
         return resultado;
    }
}
