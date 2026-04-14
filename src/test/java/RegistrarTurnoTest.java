import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrarTurnoTest {

    private SistemaTurnosSoporte sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaTurnosSoporte();
    }

    @Test
    public void deberiaRegistrarTurnoValido() {
        assertTrue(sistema.registrarTurno("T001", "No enciende el equipo"));
        assertEquals(1, sistema.obtenerCantidadTurnos());
    }

    @Test
    public void noDeberiaRegistrarCodigoNulo() {
        assertFalse(sistema.registrarTurno(null, "No enciende el equipo"));
    }

    @Test
    public void noDeberiaRegistrarProblemaNulo() {
        assertFalse(sistema.registrarTurno("T001", null));
    }

    @Test
    public void noDeberiaRegistrarCodigoVacio() {
        assertFalse(sistema.registrarTurno("", "No enciende el equipo"));
        assertFalse(sistema.registrarTurno("   ", "No enciende el equipo"));
    }

    @Test
    public void noDeberiaRegistrarProblemaVacio() {
        assertFalse(sistema.registrarTurno("T001", ""));
        assertFalse(sistema.registrarTurno("T001", "   "));
    }

    @Test
    public void noDeberiaRegistrarTurnoDuplicado() {
        assertTrue(sistema.registrarTurno("T001", "No enciende el equipo"));
        assertFalse(sistema.registrarTurno("T001", "Pantalla azul"));
        assertEquals(1, sistema.obtenerCantidadTurnos());
    }

    @Test
    public void noDeberiaRegistrarSiLaColaEstaLlena() {
        for (int i = 1; i <= 10; i++) {
            assertTrue(sistema.registrarTurno("T" + i, "Problema " + i));
        }

        assertFalse(sistema.registrarTurno("T11", "Problema extra"));
        assertEquals(10, sistema.obtenerCantidadTurnos());
    }
}
