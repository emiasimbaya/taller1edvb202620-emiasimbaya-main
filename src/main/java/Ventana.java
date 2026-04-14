import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private SistemaTurnosSoporte sistema;
    private JTextField txtCodigo;
    private JTextField txtProblema;
    private JTextArea areaResultado;

    public Ventana() {
        sistema = new SistemaTurnosSoporte();

        setTitle("Sistema de Turnos de Soporte");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Ingreso de datos"));

        panelCampos.add(new JLabel("Código del turno:"));
        txtCodigo = new JTextField();
        panelCampos.add(txtCodigo);

        panelCampos.add(new JLabel("Problema:"));
        txtProblema = new JTextField();
        panelCampos.add(txtProblema);

        add(panelCampos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 10, 10));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Opciones"));

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnVerSiguiente = new JButton("Ver siguiente");
        JButton btnAtender = new JButton("Atender");
        JButton btnCantidad = new JButton("Cantidad");
        JButton btnEspacios = new JButton("Espacios");
        JButton btnMostrarCola = new JButton("Mostrar cola");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnVerSiguiente);
        panelBotones.add(btnAtender);
        panelBotones.add(btnCantidad);
        panelBotones.add(btnEspacios);
        panelBotones.add(btnMostrarCola);

        add(panelBotones, BorderLayout.CENTER);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultado"));
        scroll.setPreferredSize(new Dimension(600, 180));

        add(scroll, BorderLayout.SOUTH);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String problema = txtProblema.getText();

                boolean registrado = sistema.registrarTurno(codigo, problema);

                if (registrado) {
                    areaResultado.setText("Turno registrado correctamente");
                    txtCodigo.setText("");
                    txtProblema.setText("");
                } else {
                    areaResultado.setText("No se pudo registrar el turno");
                }
            }
        });

        btnVerSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText(sistema.verSiguienteTurno());
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText(sistema.atenderSiguienteTurno());
            }
        });

        btnCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText("Cantidad de turnos: " + sistema.obtenerCantidadTurnos());
            }
        });

        btnEspacios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText("Espacios disponibles: " + sistema.obtenerEspaciosDisponibles());
            }
        });

        btnMostrarCola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText(sistema.mostrarCola());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
}