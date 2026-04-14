import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnosSoporte {

    private Queue<Turno> cola;
    private static final int CAPACIDAD_MAXIMA = 10;

    public SistemaTurnosSoporte() {
        cola = new LinkedList<>();
    }

    private class Turno {
        private String codigo;
        private String problema;

        public Turno(String codigo, String problema) {
            this.codigo = codigo;
            this.problema = problema;
        }

        public String getCodigo() {
            return codigo;
        }

        @Override
        public String toString() {
            return codigo + " - " + problema;
        }
    }

    public boolean registrarTurno(String codigo, String problema) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }

        if (problema == null || problema.trim().isEmpty()) {
            return false;
        }

        if (cola.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }

        for (Turno turno : cola) {
            if (turno.getCodigo().equals(codigo)) {
                return false;
            }
        }

        cola.offer(new Turno(codigo, problema));
        return true;
    }
    

    public int obtenerCantidadTurnos() {
        return cola.size();
    }

    public int obtenerEspaciosDisponibles() {
        return CAPACIDAD_MAXIMA - cola.size();
    }

    public String mostrarCola() {
        if (cola.isEmpty()) {
            return "";
        }

        String texto = "";
        for (Turno turno : cola) {
            texto += turno.toString() + "\n";
        }
        return texto.trim();
    }
}