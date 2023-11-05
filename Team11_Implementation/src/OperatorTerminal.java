import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OperatorTerminal {
    OperatorTerminal(){

    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Operator"));
        return panel;
    }
}
