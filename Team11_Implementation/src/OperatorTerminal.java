import javax.swing.JLabel;
import javax.swing.JPanel;

public class OperatorTerminal {

    AllProviders providers;
    AllMembers members;

    OperatorTerminal(AllProviders providers, AllMembers members){
        this.providers = providers;
        this.members = members;
    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Operator"));
        return panel;
    }
}
