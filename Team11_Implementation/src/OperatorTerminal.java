import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperatorTerminal {

    AllProviders providers;
    AllMembers members;
    AllOperators operators;

    boolean operatorVerified = false;
    Operator currentOperator;

    private long RandomGeneratedNumber() {
        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random 9-digit number
        long min = 100000000L; // Smallest 9-digit number
        long max = 999999999L; // Largest 9-digit number

        long generatedNumber = min + ((long) (random.nextDouble() * (max - min)));
        return generatedNumber;

    }

    OperatorTerminal(AllProviders providers, AllMembers members, AllOperators operators) {
        this.providers = providers;
        this.members = members;
        this.operators = operators;

    }

    private JPanel panel = new JPanel();

    public JPanel getPanel() {
        refreshPanel();
        return panel;
    }

    // Called to update screen
    public void refreshPanel() {
        panel.removeAll();

        if (operatorVerified) {
            setVerfiedPanel();
        } else {
            setUnverifiedPanel();
        }

        // need to repaint and revalidate for screen to update
        panel.revalidate();
        panel.repaint();
    }

    // Sets mainPanel to verified page
    private void setVerfiedPanel() {
        JButton addMember = new JButton(new AbstractAction("Add Member") {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        JButton deleteMember = new JButton(new AbstractAction("Delete Member") {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        JButton updateMember = new JButton(new AbstractAction("Update Member") {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        panel.add(addMember);
        panel.add(deleteMember);
        panel.add(updateMember);
    }

    // Sets panel to the provider # _____ page
    private void setUnverifiedPanel() {
        JTextField input = new JTextField(10);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                // when submitted do more stuff here
                // like setting currentOperator and checking if input is verified
                verify(input.getText());
            }
        });

        JLabel label = new JLabel("Member #:");
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(label);
        panel.add(input);
        panel.add(submitButton);
        panel.repaint();
        panel.revalidate();
    }

    // Called when submit is clicked when asking for Operator #
    private void verify(String input) {
        int inputInt;
        try {
            inputInt = Integer.parseInt(input);
        } catch (NumberFormatException rand) {
            inputInt = -1;
        }

        if (operators.verifyOperator(inputInt)) {
            operatorVerified = true;
            currentOperator = operators.getOperator(inputInt);
        } else
            JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");

        refreshPanel();
    }

}
