package Logic;

/**
 *
 * @author andre
*/

public class RoomType {
    private String k_idTipo;
    private String n_descripcion;
    private Double v_precio;
    
    
    /* Constructor */
   public RoomType(){
       k_idTipo = "";
       n_descripcion = "";
       v_precio = 0.0;
   }

   /* Getters */
    public String getK_idTipo() {
        return k_idTipo;
    }

    public String getN_descripcion() {
        return n_descripcion;
    }
    
    public Double getV_precio() {
        return v_precio;
    }
    
    /*Setters*/
    public void setK_idTipo(String k_idTipo) {
        this.k_idTipo = k_idTipo;
    }
    
    public void setN_descripcion(String n_descripcion) {
        this.n_descripcion = n_descripcion;
    }
    
    public void setV_precio(Double v_precio) {
        this.v_precio = v_precio;
    } 
}
