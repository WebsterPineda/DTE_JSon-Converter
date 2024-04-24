package sv.com.celip.forms;

import javax.swing.*;

public class MasterForm {
    private MasterForm() {
    }

    public static JFrame generateForm() {
        return generateForm("Procesador DTEs - JSon-Merger v1.0");
    }

    public static JFrame generateForm(String title) {
        JFrame form = FormBase.generarFormulario(title);
        visualAspect(form);
        defaultBehavior(form);

        return form;
    }

    protected static void visualAspect(JFrame form) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        BasePanel panel = new BasePanel(form);
        form.add(panel.generatePanel());
        form.setSize(400, 300);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.setResizable(false);
        form.toFront();
    }

    protected static void defaultBehavior(JFrame form) {
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
