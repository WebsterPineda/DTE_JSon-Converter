package sv.com.celip;

import sv.com.celip.forms.MasterForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            MasterForm.generateForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
