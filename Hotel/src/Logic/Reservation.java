package Logic;

/**
 *
*/

public class Reservation {
    private long k_code;
    private int q_peopleQuant;
    private int q_duration;
    private char i_state;
    private String f_start;
    
    /* Constructor */
    public Reservation() {
        k_code = 0;
        q_peopleQuant = 0;
        q_duration = 0;
        i_state = 0;
        f_start = "";
    }
    
    /* Setters */
    public void setCode(long k_code) {
        this.k_code = k_code;
    }
    
    public void setPeopleQuant(int q_peopleQuant) {
        this.q_peopleQuant = q_peopleQuant;
    }
    
    public void setDuration(int q_duration) {
        this.q_duration = q_duration;
    }
    
    public void setState(char i_state) {
        this.i_state = i_state;
    }
    
    public void setStartDate(String f_start) {
        this.f_start = f_start;
    }
    
    /* Getters */
    public long getCode() {
        return k_code;
    }
    
    public int getPeopleQuant() {
        return q_peopleQuant;
    }
    
    public int getDuration() {
        return q_duration;
    }
    
    public char getState() {
        return i_state;
    }
    
    public String getStartDate() {
        return f_start;
    }
}
