import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MostrarColaTest {

    private SistemaTurnosSoporte sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaTurnosSoporte();
    }

    @Test
    public void deberiaMostrarMensajeSiLaColaEstaVacia() {
        assertEquals("Cola vacía", sistema.mostrarCola());
    }

    @Test
    public void deberiaMostrarTodaLaCola() {
        sistema.registrarTurno("T001", "No enciende el equipo");
        sistema.registrarTurno("T002", "Pantalla azul");

        String resultado = sistema.mostrarCola();

        assertTrue(resultado.contains("T001 | No enciende el equipo"));
        assertTrue(resultado.contains("T002 | Pantalla azul"));
    }
}
