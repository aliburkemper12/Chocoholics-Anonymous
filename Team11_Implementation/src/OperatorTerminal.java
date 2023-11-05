import javax.swing.JLabel;
import javax.swing.JPanel;

public class OperatorTerminal {

    AllProviders providers;
    AllMembers members;
    AllOperators operators;
    

    OperatorTerminal(AllProviders providers, AllMembers members, AllOperators operators){
        this.providers = providers;
        this.members = members;
        this.operators = operators;

    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Operator"));
        return panel;
    }
}
