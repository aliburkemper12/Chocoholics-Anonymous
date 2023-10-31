import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProviderTerminal {
    ProviderTerminal(){

    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Provider"));
        return panel;
    }
}
