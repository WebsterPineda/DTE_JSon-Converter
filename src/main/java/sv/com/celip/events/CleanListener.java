package sv.com.celip.events;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class CleanListener implements ActionListener {
    private List<JComponent> components;

    public CleanListener(JComponent... components) {
        this.components = new ArrayList<>(Arrays.asList(components));
    }

    public CleanListener() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            components.forEach(c -> {
                if (c instanceof JTextField txt){
                    txt.setText("");
                    if (c == components.get(0)) {
                        txt.requestFocus();
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
