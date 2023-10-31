import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ManagerTerminal {
    ManagerTerminal(){

    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Manager"));
        return panel;
    }
}
