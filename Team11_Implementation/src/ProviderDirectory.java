import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProviderDirectory {
    ProviderDirectory(){

    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Provider Directory"));
        return panel;
    }
}
