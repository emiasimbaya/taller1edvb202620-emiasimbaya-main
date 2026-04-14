import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObtenerCantidadTurnosTest {

    private SistemaTurnosSoporte sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaTurnosSoporte();
    }

    @Test
    public void deberiaRetornarCeroAlIniciar() {
        assertEquals(0, sistema.obtenerCantidadTurnos());
    }

    @Test
    public void deberiaContarTurnosEnEspera() {
        sistema.registrarTurno("T001", "No enciende el equipo");
        sistema.registrarTurno("T002", "Pantalla azul");
        sistema.registrarTurno("T003", "Sin internet");

        assertEquals(3, sistema.obtenerCantidadTurnos());
    }
}
