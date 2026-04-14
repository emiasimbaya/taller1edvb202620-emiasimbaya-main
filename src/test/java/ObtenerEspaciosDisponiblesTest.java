import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObtenerEspaciosDisponiblesTest {

    private SistemaTurnosSoporte sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaTurnosSoporte();
    }

    @Test
    public void deberiaRetornarDiezEspaciosAlIniciar() {
        assertEquals(10, sistema.obtenerEspaciosDisponibles());
    }

    @Test
    public void deberiaDisminuirEspaciosAlRegistrar() {
        sistema.registrarTurno("T001", "No enciende el equipo");
        sistema.registrarTurno("T002", "Pantalla azul");

        assertEquals(8, sistema.obtenerEspaciosDisponibles());
    }
}
