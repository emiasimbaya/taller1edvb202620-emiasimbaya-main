import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VerSiguienteTurnoTest {

    private SistemaTurnosSoporte sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaTurnosSoporte();
    }

    @Test
    public void deberiaVerElPrimerTurnoSinEliminarlo() {
        sistema.registrarTurno("T001", "No enciende el equipo");
        sistema.registrarTurno("T002", "Pantalla azul");

        assertEquals("T001 | No enciende el equipo", sistema.verSiguienteTurno());
        assertEquals(2, sistema.obtenerCantidadTurnos());
    }

    @Test
    public void deberiaRetornarMensajeSiNoHayTurnos() {
        assertEquals("No hay turnos", sistema.verSiguienteTurno());
    }
}
