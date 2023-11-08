import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Random;




public class OperatorTerminal {

    AllProviders providers;
    AllMembers members;
    AllOperators operators;
    
    private long RandomGeneratedNumber() {        
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
    JPanel panel;
    JPanel mainPanel;
    JPanel dirPanel;


    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Operator"));
        
        JButton addBill = new JButton(new AbstractAction("Verify Operator") {
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    
                    JTextField input = new JTextField(10);
                    JButton submitButton = new JButton(new AbstractAction("Submit") {
                        public void actionPerformed(ActionEvent e) {
                            verify(true, input.getText(), true);
                        }
                    });

                    JLabel label = new JLabel("Credentials:");
                    label.setHorizontalAlignment(JLabel.RIGHT);
                    mainPanel.add(label);
                    mainPanel.add(input);
                    mainPanel.add(submitButton);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            });return panel;
    }
    
}
