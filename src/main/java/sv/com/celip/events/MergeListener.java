package sv.com.celip.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter
@NoArgsConstructor
public class MergeListener implements ActionListener {
    private JTextComponent[] textComponents;
    private JComponent[] components;
    private JProgressBar progressBar;

    public MergeListener(JProgressBar progressBar, JComponent[] components,
                         JTextComponent... textComponents)
    {
        this.progressBar = progressBar;
        this.components = components;
        this.textComponents = textComponents;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String strPath = textComponents[0].getText();
        String strSaveFile = textComponents[1].getText();

        if (strPath == null || strPath.isEmpty() || strSaveFile == null ||
                strSaveFile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Asegurate de haber ingresado" +
                    " la ruta de archivos JSON y de resguardo de CSV a " +
                    "generar", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Path jsonFiles;
        try {
            jsonFiles = Paths.get(strPath);
        } catch (InvalidPathException e1) {
            JOptionPane.showMessageDialog(null,
                    "La ruta de ubicacion de los archivos JSON es invalida." +
                            System.lineSeparator() + e1.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Path mergedFile;
        try {
            mergedFile = Paths.get(strSaveFile);
        } catch (InvalidPathException e1) {
            JOptionPane.showMessageDialog(null, "La ruta en la que guardar " +
                    "los archivos CSV es ivalida" + System.lineSeparator() +
                    e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // TODO: execute converter function
    }
}
