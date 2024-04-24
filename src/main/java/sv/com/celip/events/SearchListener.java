package sv.com.celip.events;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchListener implements ActionListener {
    private final FileNameExtensionFilter jsonFilter =
            new FileNameExtensionFilter("Archivos JSON (*.json)", "json");
    private final JFrame parent;
    private final JTextField textField;
    private final String title;
    private final boolean converter;

    public SearchListener(final JFrame parent, final JTextField textField,
                          final String title, final boolean converter)
    {
        this.parent = parent;
        this.textField = textField;
        this.title = title;
        this.converter = converter;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {

        boolean isSelected = !textField.getText()
                                       .trim()
                                       .isEmpty();

        String ruta = isSelected ? textField.getText()
                                            .trim() :
                      FileSystemView.getFileSystemView()
                                    .getDefaultDirectory()
                                    .getAbsolutePath();

        Path folder = Paths.get(ruta);

        if (isSelected && !converter) {
            folder = folder.getParent();
        }

        JFileChooser chooser = new JFileChooser(folder.toAbsolutePath()
                                                      .toString());
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle(this.title);

        if (!converter) {
            chooser.addChoosableFileFilter(this.jsonFilter);
            chooser.setFileFilter(jsonFilter);
        } else {
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }

        int option = chooser.showOpenDialog(parent);

        if (option == JFileChooser.APPROVE_OPTION) {
            textField.setText(chooser.getSelectedFile()
                                     .getAbsolutePath());
        }
    }
}
