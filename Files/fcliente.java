/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import Datos.vproducto;
import Datos.vcliente;

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
public class fcliente {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //var q se almacena la caden d conex
    private String sSQL2 = "";//al momento d insertar un cleinte necesito tmbn insertar una persona previamnte, se crea otra cadena d instrucciones
    public Integer totalregistros;//q cuente el total d reg q obtiene
//crear funcion pa mostrar rregistros d la tabla habi

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        //Declarar 2 vectores, 1 para tituls d la column tipo String
        //UNir todos los campos de las dos tablas   
        String[] titulos = {"ID", "Nombre", "apaterno", "amaterno", "doc", "numero_docu", "direccion", "telefono", "email", "codigo"};
        String[] registro = new String[10]; //almacenar los reg d cu d los titulos,
        totalregistros = 0; //inicializo mi var total de reg
        modelo = new DefaultTableModel(null, titulos);  //agreg los titulos q ya tengo
        
        //unimos las dos tablas con INNER JOIN  y los dos prefijos p y c, que coincidan las ID con ON
        sSQL = "select p.idpersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.num_documento,"
                + "p.direccion,p.telefono,p.email,c.codigo_cliente from persona p inner join cliente c "
                + "on p.idpersona=c.idpersona where num_documento like '%"
                + buscar + "%' order by idpersona desc";//empiezo a armar mi instrucc sql q va a tener todos los reg d mi tabla habi
        
        try { //iniciar declarador d errores. pa generar cod d secc d errores
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            //hacer navegac d reg, pa q recorra uno a uno
            while (rs.next()) {
                registro[0] = rs.getString("idpersona"); //almacenar aki todos los reg obtenidos en rs
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("codigo_cliente");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vcliente dts) {
        sSQL = "insert into persona(nombre,apaterno,amaterno,tipo_documento,num_documento,direccion,telefono,email)" + "values(?,?,?,?,?,?,?,?)";
                                                                  //se selecciona el idpersona de la tabla personas
        sSQL2 = "insert into cliente(idpersona,codigo_cliente)" + "values((select idpersona from persona order by idpersona desc limit 1),?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            
         pst2.setString(1, dts.getCodigo_cliente());

            //enviar 1 a 1 al preparestatement
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {  //entonces logre isertar el cliente
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vcliente dts) {
        sSQL = "update persona set nombre=?,apaterno=?,amaterno=?,tipo_documento=?,num_documento=?,"
                + " direccion=?,telefono=?,email=? where idpersona=?";
         sSQL2 = "update cliente set codigo_cliente=?"
                + "where idpersona=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpersona());
            
         pst2.setString(1, dts.getCodigo_cliente());
         pst2.setInt(2, dts.getIdpersona());

            //enviar 1 a 1 al preparestatement
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vcliente dts) {
        sSQL = "delete from cliente where idpersona =?";
                sSQL2 = "delete from persona where idpersona =?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
          
            pst.setInt(1, dts.getIdpersona());
         
         pst2.setInt(1, dts.getIdpersona());

            //enviar 1 a 1 al preparestatement
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
