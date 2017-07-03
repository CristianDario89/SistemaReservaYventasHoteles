/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia
 */
public class Conexion {
    public String db ="ventas-reservas"; //var q se almacene el nombre de la bd
    public String url="jdbc:mysql://127.0.0.1/"+db; //alm la cedana de conexion:JDBC, de motor sql e indico la cad de IP donde esta mi BD y concateno con mi var bd
    public String user="root";
    public String pass="MIfuturama89";
    
    public Conexion(){
    
    }
    
    public Connection conectar(){  //func pa poder conectarse a la base d dat
        Connection link=null; //crear var q haga una istancia con la var connection
        try {
            Class.forName("org.gjt.mm.mysql.Driver");//cargar el driver de la conexion dentro del parentesis
            link=DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }
      
}
