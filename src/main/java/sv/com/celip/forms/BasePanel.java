package sv.com.celip.forms;

import sv.com.celip.events.CleanListener;
import sv.com.celip.events.MergeListener;
import sv.com.celip.events.SearchListener;

import javax.swing.*;
import java.awt.*;

public class BasePanel {
    private final JFrame frame;
    private GridBagConstraints gbc;

    public BasePanel(JFrame frame) {
        this.frame = frame;
    }

    public JPanel generatePanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        gbc = new GridBagConstraints();

        assignGridPos(0, 0, 10, 15);
        panel.add(new JLabel("Ruta de archivos: "), gbc);

        JTextField txtRuta = new JTextField(20);
        txtRuta.setName("txtRuta");
        txtRuta.setEditable(false);
        txtRuta.setFocusable(false);
        assignGridPos(0, 1, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtRuta, gbc);

        JButton btnLoadJsonFiles = new JButton("Archivo DTE JSON");
        btnLoadJsonFiles.setSize(35, 24);
        assignGridPos(1, 0, 0, 0);
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnLoadJsonFiles, gbc);

        assignGridPos(2, 0, 10, 0);
        panel.add(new JLabel(" "), gbc);

        assignGridPos(3, 0, 10, 15);
        panel.add(new JLabel("Ruta a guardar: "), gbc);

        JTextField txtRutaUnificado = new JTextField(20);
        txtRutaUnificado.setName("txtRutaUnificado");
        txtRutaUnificado.setEditable(false);
        txtRutaUnificado.setFocusable(false);
        assignGridPos(3, 1, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtRutaUnificado, gbc);

        JButton btnLoadCsvFolder = new JButton("Destino CSV");
        btnLoadCsvFolder.setSize(35, 24);
        assignGridPos(4, 0, 0, 0);
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnLoadCsvFolder, gbc);

        assignGridPos(5, 0, 10, 10);
        panel.add(new JLabel(" "), gbc);

        JButton btnSave = new JButton("Guardar");
        btnSave.setSize(15, 24);
        assignGridPos(6, 0, 0, 0);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnSave, gbc);

        JButton btnClean = new JButton("Limpiar");
        assignGridPos(7, 0, 0, 0);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnClean, gbc);

        JProgressBar progressBar = new JProgressBar();
        assignGridPos(8, 0, 0, 0);
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(progressBar, gbc);

        JComponent[] components =
                new JComponent[]{btnLoadJsonFiles, btnLoadCsvFolder, btnSave,
                                 btnClean};

        btnLoadJsonFiles.addActionListener(
                new SearchListener(frame, txtRuta, "Seleccionar archivo JSON",
                        false));
        btnLoadCsvFolder.addActionListener(
                new SearchListener(frame, txtRutaUnificado,
                        "Seleccionar carpeta...", true));
        btnClean.addActionListener(
                new CleanListener(txtRuta, txtRutaUnificado));
        btnSave.addActionListener(
                new MergeListener(progressBar, components, txtRuta,
                        txtRutaUnificado));

        return panel;
    }

    public final void assignGridPos(int row, int col, int padX, int padY) {
        if (gbc == null) {
            return;
        }

        gbc.gridx = col;
        gbc.gridy = row;
        gbc.ipadx = padX;
        gbc.ipady = padY;
        gbc.anchor =
                (col == 0) ? GridBagConstraints.EAST : GridBagConstraints.WEST;
        gbc.fill = (col == 0) ? GridBagConstraints.HORIZONTAL :
                   GridBagConstraints.NONE;
    }
}
