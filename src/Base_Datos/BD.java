/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Datos;

import static Base_Datos.BD.Conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class BD {
  PreparedStatement ps;

private static Connection conexion;
   private static ResultSet Registro; 
   private static PreparedStatement Ps;
   
    
   public static String bd = "mantenimientos";
   public static String usuario = "root";
   public static String password = "Utnbd01";
   public static String url = "jdbc:mysql://localhost/"+bd;
  
   
   public static void Conectar()
   {
   try{
           conexion=(Connection) DriverManager.getConnection(url, usuario, password);
           }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Conexion Incompleta");
       }  
   }
   
   public static int Enviar_Sentencia(String psql){
        try{
            // Statement,  me ejecuta la sentencia sql
            Statement st;
            Conectar();
            st=conexion.createStatement();
            //executeUpdate; se usa para ejecutar sentencias INSERT, UPDATE ó DELETE
            st.executeUpdate(psql);
            return 0;
        }catch(SQLException e)   {
         return  e.getErrorCode();
        }   
    }
    
   public static ResultSet RetornarRegistro(String psql) throws SQLException
   {
            Statement st;
            Conectar();
            st=conexion.createStatement();
            Registro=st.executeQuery(psql);         
            return Registro;   
 }    
    //Creo un metodo de int que me va a retornar un numero.
    public int ConsultarLogin( String Users, String Pass){
        //declaro la variable resultado, iniciandola en 0 y la variable statement como st
        Integer resultado=0;
             Statement st;
             //llamo el metodo conectar
            Conectar();
            
            try{
            //instancio la conexion 
            st=conexion.createStatement();
            // con el metodo resulset le doy un parametro a la base de datos: 
            // select count me seleciona el nombre de la linea en la tabla usuarios
            // donde cedula y contraseña es igual a las ingresadas con el executeQuery me enviara un resultado
            ResultSet rs= st.executeQuery("Select count(nombre) as i from usuarios where cedulaUsuario = '"+Users+"'"+ " and contraseña = '"+Pass+"'");
            
            // abro un if else, donde se cumpla me desplegara el mensaje bienvenido y me renombrara a reultado por un 1
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Bienvenido");
                resultado=1;
            }else{
                JOptionPane.showMessageDialog(null,"Usuario ó contraseña incorrecto");
            }
            }catch(Exception e ){
                JOptionPane.showMessageDialog(null, "Error al conectarse"+e.getMessage(), e.getMessage(),JOptionPane.ERROR_MESSAGE);
            }
            return resultado; 
            // me retorna el numero de resultado. 
    }
//    
//    public String IdVenta(){
//        String id="";
//          // Statement;  me ejecuta la sentencia sql
//        Statement st;
//        String sql="Select max(idFactura) as idFactura from encabezadofactura";
//        try{
//            // sirve para modificar/insertar/buscar uno o varios registros con sólo cambiar los valores de los parámetros que especifiquemos.
//            ps=conexion.prepareStatement(sql);
//            // executeQuery; esta diseñado para sentencias que producen como resultado un único result set tal como las sentencias SELECT
//            Registro=ps.executeQuery();
//            if(Registro.next()){
//                id=Registro.getString(1);
//            }
//        }catch(SQLException e ){
//            System.out.println(e.toString());
//        }
//        return id;
//    }
}