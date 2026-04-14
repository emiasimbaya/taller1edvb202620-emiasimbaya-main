import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtenderSiguienteTurnoTest {

    private SistemaTurnosSoporte sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaTurnosSoporte();
    }

    @Test
    public void deberiaAtenderEnOrdenFIFO() {
        sistema.registrarTurno("T001", "No enciende el equipo");
        sistema.registrarTurno("T002", "Pantalla azul");

        assertEquals("T001 | No enciende el equipo", sistema.atenderSiguienteTurno());
        assertEquals("T002 | Pantalla azul", sistema.atenderSiguienteTurno());
    }

    @Test
    public void deberiaReducirLaCantidadAlAtender() {
        sistema.registrarTurno("T001", "No enciende el equipo");
        sistema.atenderSiguienteTurno();

        assertEquals(0, sistema.obtenerCantidadTurnos());
    }

    @Test
    public void deberiaRetornarMensajeSiNoHayTurnos() {
        assertEquals("No hay turnos", sistema.atenderSiguienteTurno());
    }
}
