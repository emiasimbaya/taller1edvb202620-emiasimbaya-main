import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnosSoporte {

    private Queue<Turno> cola;
    private static final int CAPACIDAD_MAXIMA = 10;

    public SistemaTurnosSoporte() {
        cola = new LinkedList<>();
    }

    public class Turno {
        private String codigo;
        private String problema;

        public Turno(String codigo, String problema) {
            this.codigo = codigo;
            this.problema = problema;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getProblema() {
            return problema;
        }

        @Override
        public String toString() {
            return "Turno: " + codigo + " - Problema: " + problema;
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

        for (Turno t : cola) {
            if (t.getCodigo().equals(codigo)) {
                return false;
            }
        }

        cola.add(new Turno(codigo, problema));
        return true;
    }

    public String verSiguienteTurno() {
        if (cola.isEmpty()) {
            return "No hay turnos";
        }
        return cola.peek().toString();
    }

    public String atenderSiguienteTurno() {
        if (cola.isEmpty()) {
            return "No hay turnos";
        }
        return cola.poll().toString();
    }

    public int obtenerCantidadTurnos() {
        return cola.size();
    }

    public int obtenerEspaciosDisponibles() {
        return CAPACIDAD_MAXIMA - cola.size();
    }

    public String mostrarCola() {
        if (cola.isEmpty()) {
            return "Cola vacía";
        }

        String resultado = "";
        for (Turno t : cola) {
            resultado += t.toString() + "\n";
        }
        return resultado;
    }
}