import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Random;




public class OperatorTerminal {

    AllProviders providers;
    AllMembers members;
    AllOperators operators;
    
    private long RandomGeneratedNumber(String[] args) {        
        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random 9-digit number
        long min = 100000000L; // Smallest 9-digit number
        long max = 999999999L; // Largest 9-digit number

        long generatedNumber = min + ((long) (random.nextDouble() * (max - min)));
        return generatedNumber;

    }

    OperatorTerminal(AllProviders providers, AllMembers members, AllOperators operators){
        this.providers = providers;
        this.members = members;
        this.operators = operators;
        
    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Operator"));
        
        JButton addBill = new JButton(new AbstractAction("Bill Service") {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
            return panel;
    }
    
}
