
package Files;

import Datos.vhabitacion;
import Datos.vproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fproducto {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //var q se almacena la caden d conex
    public Integer totalregistros;//Contador de registros: q cuente el total d reg q obtiene
//crear funcion pa mostrar rregistros d la tabla habi

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        //Declarar 2 vectores, 1 para tituls d la column tipo String
        String[] titulos = {"ID", "producto", "descripcion", "unidad_medida", "precio_venta"};
        String[] registro = new String[5]; //almacenar los reg d cu d los titulos
        totalregistros = 0; //inicializo mi var total de reg
        modelo = new DefaultTableModel(null, titulos);  //agreg los titulos q ya tengo
        //que busque where nombre se parzca a buscar
        sSQL = "select*from producto where nombre like '%" + buscar + "%' order by idproducto desc";//empiezo a armar mi instrucc sql q va a tener todos los reg d mi tabla habi
        try { //iniciar declarador d errores. pa generar cod d secc d errores
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            //hacer navegac d reg, pa q recorra uno a uno
            while (rs.next()) {
                registro[0] = rs.getString("idproducto"); //almacenar aki todos los reg obtenidos en rs
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("unidad_medida");
                registro[4] = rs.getString("precio_venta");
               
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vproducto dts) {
        sSQL = "insert into producto(nombre,descripcion,unidad_medida,precio_venta)" + "values(?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //
            pst.setString(1, dts.getNombre());        //enviar 1 a 1 al preparestatement
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_medida());
            pst.setDouble(4, dts.getPrecio_venta());
           
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

    public boolean editar(vproducto dts) {
        sSQL="update producto set nombre =?,descripcion=?,unidad_medida=?,precio_venta=?"+
                 "where idproducto=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //
        //escrito en tabla--escrito y capturado x Mysql
            pst.setString(1, dts.getNombre());        //enviar 1 a 1 al preparestatement
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_medida());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setInt(5, dts.getIdproducto());
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

    public boolean eliminar(vproducto dts) {
        sSQL="delete from producto where idProducto =?";
        try {
PreparedStatement pst = cn.prepareStatement(sSQL); //
            pst.setInt(1, dts.getIdproducto());        //enviar 1 a 1 al preparestatement
            
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
}
