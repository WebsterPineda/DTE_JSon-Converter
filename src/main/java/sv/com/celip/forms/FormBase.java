package sv.com.celip.forms;

import javax.swing.*;

public class FormBase {
    private FormBase() {}

    protected static JFrame generarFormulario() {
        return new JFrame();
    }

    protected static JFrame generarFormulario(String titulo) {
        return new JFrame(titulo);
    }
}
