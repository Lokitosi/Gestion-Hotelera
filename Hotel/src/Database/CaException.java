package Database;

public class CaException extends Exception {
    private String detalle;
    private String clase;
      
    /* Constructor */
    public CaException(String clase,String error) {
        this.clase = clase; 
        detalle = error;
    }

    /* Convert to String */
    public String toString() {
        return "[" + clase + "]" + detalle;
    }
 }

