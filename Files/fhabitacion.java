/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import Datos.vhabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silvia
 */
public class fhabitacion {
    
        private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar(); //llamar a mi func CONECTAR de mi variable q hace la instancia,  a travez de la var creada connection(CN)
    private String sSQL = ""; //var q se almacena la caden d conex
    public Integer totalregistros;//q cuente el total d reg q obtiene
//crear funcion pa mostrar rregistros d la tabla habi

    public DefaultTableModel mostrar(String buscar) { // FUNCION: Defaulttablemodel, pa mostrar los reg
        DefaultTableModel modelo;  //Empiezo a declarar una var de tipo def..
        //Declarar 2 vectores, 1 para tituls d la column tipo String
        String[] titulos = {"idHabitacion", "numero", "piso", "descripcion", "caracteristicas", "precio_diario", "estado", "tipo_habitacion"};
        String[] registro = new String[8]; //almacenar los reg d cu d los titulos
        totalregistros = 0; //inicializo mi var total de reg
        modelo = new DefaultTableModel(null, titulos);  //agreg los titulos q ya tengo
        
        sSQL = "select*from habitacion where piso like '%" + buscar + "%' and estado='Disponible Kapo' order by idHabitacion";//empiezo a armar mi instrucc sql q va a tener todos los reg d mi tabla habi
        try { //iniciar declarador d errores. pa generar cod d secc d errores
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); //va a ejecutar el statement
            //hacer navegac d reg, pa q recorra uno a uno
            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion"); //almacenar aki todos los reg obtenidos en rs
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precio_diario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_habitacion");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro); //ag a la var modelo a manera de fila todo mi vctor registro

            }
            return modelo;  //termina el bucle retorna modelo
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Número","Piso","Descripción","Caracteristicas","Precio","Estado","Tipo habitación"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from habitacion where piso like '%"+ buscar + "%' and estado='Disponible' order by idhabitacion";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idhabitacion");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descripcion");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("precio_diario");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_habitacion");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 

    public boolean insertar(vhabitacion dts) {  //recibe toda la var habitacion instanciada en dts
   //1ro: asignar a la var sSQL la instruccion sl pa poder insertar reg
        sSQL = "insert into habitacion(numero,piso,descripcion,caracteristicas,precio_diario,estado,tipo_habitacion)" + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //
            pst.setString(1, dts.getNumero());        //enviar 1 a 1 al preparestatement
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            int n = pst.executeUpdate();  // almacena el result de la ejec del statement
            if (n != 0) {  //declarar cond a ver si se cumple la cond d reg d mi tabla Dif de 0 entonc si devolvio un TRUE
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);  //error x si no pudiste conectarte a la bd
            return false;
        }
    }
    
    public boolean editar(vhabitacion dts) {
        sSQL="update habitacion set numero =?,piso=?,descripcion=?,caracteristicas=?,precio_diario=?,estado=?,tipo_habitacion=?+"
                + "where idHabitacion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //
            pst.setString(1, dts.getNumero());        //enviar 1 a 1 al preparestatement
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            pst.setInt(7, dts.getIdHabitacion());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

     public boolean eliminar(vhabitacion dts) {
        sSQL="delete from habitacion where idhabitacion =?";
        try {
PreparedStatement pst = cn.prepareStatement(sSQL); //
            pst.setInt(1, dts.getIdHabitacion());        //enviar 1 a 1 al preparestatement
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
     
     public boolean desocupar (vhabitacion dts){
       sSQL="update habitacion set estado='Disponible'"+
               " where idhabitacion=?";
           //alt + 39
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getIdHabitacion());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }   
    
 public boolean ocupar (vhabitacion dts){
       sSQL="update habitacion set estado='Ocupado amiguito'"+
               " where idhabitacion=?";
           //alt + 39
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getIdHabitacion());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   } 
  //se regresa al frmPago pa poner el codigo pa desocupar y ocupar
    
}
