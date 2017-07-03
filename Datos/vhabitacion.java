
package Datos;

/**
 *
 * @author Silvia
 */
public class vhabitacion {
   private int idHabitacion;
   private String numero;
   private String piso;
           private String descripcion;
                   private String caracteristicas;
                   private Double precio_diario;
                   private String estado;
                   private String tipo_habitacion;
                   
public vhabitacion(int idHabitacion,String numero,String piso,String descripcion,String caracteristicas,Double precio_diario, String estado,String tipo_habitacion){
  this.idHabitacion=idHabitacion;
  this.numero=numero;
  this.piso=piso;
  this.descripcion=descripcion;
  this.caracteristicas=caracteristicas;
  this.estado=estado;
  this.tipo_habitacion=tipo_habitacion;
  this.precio_diario=precio_diario;
}

    public vhabitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecio_diario() {
        return precio_diario;
    }

    public void setPrecio_diario(Double precio_diario) {
        this.precio_diario = precio_diario;
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

}