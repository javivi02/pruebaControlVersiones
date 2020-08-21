package ajedrez;

public class turno {
    
    private String turno;
    
    public turno(){
        
        turno = "blancas";
    }
    
    public String turnoActual(){
        
        return this.turno;
    }
    
    public String cambiarTurno(){
        
        if (turnoActual().equalsIgnoreCase("blancas")) turno = "negras";
        else if (turnoActual().equalsIgnoreCase("negras")) turno = "blancas";

        
        return turno;
    }
}
