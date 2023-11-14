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
    String name; // 25 characters
    String status;
    String address; // 25 characters
    String city; // 14 characters
    String state; // 2 characters
    int zip; 
    long memberNumber;
    long credentials;
    // Sets mainPanel to verified page
    private void setVerfiedPanel() {
        JButton addMember = new JButton(new AbstractAction("Add Member") {
            public void actionPerformed(ActionEvent e) {
                //
                panel.removeAll();
                JTextField memberName = new JTextField(1);
                JTextField memberStatus = new JTextField(1);
                JTextField  memberAddress = new JTextField(1);
                JTextField memberCity = new JTextField(1);
                JTextField memberState = new JTextField(1);
                JTextField memberZip = new JTextField(1);
                
                memberNumber = RandomGeneratedNumber();
                


        
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                // when submitted do more stuff here
                // like setting currentOperator and checking if input is verified
                status = memberStatus.getText();
                name = memberName.getText();
                address = memberAddress.getText();
                state = memberState.getText();
                city = memberCity.getText();
                boolean caughtError;
                try {
                    zip = Integer.parseInt(memberZip.getText());
                    JOptionPane.showMessageDialog(null, "Member added. Member number is: " + memberNumber);
                    refreshPanel();
                } catch (NumberFormatException rand) {
                    caughtError = true;
                    JOptionPane.showMessageDialog(null, "Invalid Zip, Please Retry");
                }
                panel.revalidate();
                panel.repaint();
            }
             });
             
             panel.add(memberStatus);
             panel.add(memberName);
             panel.add(memberAddress);
             panel.add(memberState);
             panel.add(memberCity);
             panel.add(memberZip);
             panel.add(submitButton);
             panel.revalidate();
             panel.repaint();
            }
        });
        JButton deleteMember = new JButton(new AbstractAction("Delete Member") {
            public void actionPerformed(ActionEvent e) {
                //
                members.deleteMember(memberNumber);
                JOptionPane.showMessageDialog(null, "Member successfully deleted"); 
            }
        });

        JButton updateMember = new JButton(new AbstractAction("Update Member") {
            public void actionPerformed(ActionEvent e) {
                //
                members.getMember(memberNumber);
                memberUpdatePanel(null);
                panel.revalidate();
                panel.repaint();
            }
        });
        JButton addProvider = new JButton(new AbstractAction("Add Provider") {
            public void actionPerformed(ActionEvent e) {
                //
               credentials = RandomGeneratedNumber(); 
               panel.removeAll();
                JTextField providerName = new JTextField(1);
                JTextField  providerAddress = new JTextField(1);
                JTextField providerCity = new JTextField(1);
                JTextField providerState = new JTextField(1);
                JTextField providerZip = new JTextField(1);
                
                
                


        
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                // when submitted do more stuff here
                // like setting currentOperator and checking if input is verified
                name = providerName.getText();
                address = providerAddress.getText();
                state = providerState.getText();
                city = providerCity.getText();
                boolean caughtError;
                try {
                    zip = Integer.parseInt(providerZip.getText());
                    JOptionPane.showMessageDialog(null, "Provider added. Provider credentials is: " + credentials);
                } catch (NumberFormatException rand) {
                    caughtError = true;
                    JOptionPane.showMessageDialog(null, "Invalid Zip, Please Retry");
                }
                panel.revalidate();
                panel.repaint(); 
            }
             });
             
                panel.add(providerName);
                panel.add(providerAddress);
                panel.add(providerState);
                panel.add(providerCity);
                panel.add(providerZip);
                panel.add(submitButton);
                panel.revalidate();
                panel.repaint();
            }
        });
        JButton deleteProvider = new JButton(new AbstractAction("Delete Provider") {
            public void actionPerformed(ActionEvent e) {
                //
                providers.deleteProvider(credentials);
                JOptionPane.showMessageDialog(null, "Provider successfully deleted");  
            }
        });
        JButton updateProvider = new JButton(new AbstractAction("Update Provider") {
            public void actionPerformed(ActionEvent e) {
                //
                providerUpdatePanel(null);
            }
        });
        panel.add(addMember);
        panel.add(deleteMember);
        panel.add(updateMember);
        panel.add(addProvider);
        panel.add(deleteProvider);
        panel.add(updateProvider);
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

        JLabel label = new JLabel("Credentials:");
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

    private void memberUpdatePanel(Member cMember) {
        panel.removeAll();
        JPanel rowOne = new JPanel();
        JLabel nameLabel = new JLabel(cMember.getName());
        rowOne.add(nameLabel);

        JPanel rowTwo = new JPanel();
        JLabel addressLabel = new JLabel(cMember.getAddress());
        rowTwo.add(addressLabel);

        JPanel rowThree = new JPanel();
        JLabel cityLabel = new JLabel(cMember.getCity());
        rowThree.add(cityLabel);

        JPanel rowFour = new JPanel();
        JLabel stateLabel = new JLabel(cMember.getState());
        rowFour.add(stateLabel);

        JPanel rowFive = new JPanel();
        JLabel zipLabel = new JLabel(cMember.getZip() + "");
        rowFive.add(zipLabel);

        JPanel rowSix = new JPanel();
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                int zipInt;
                try {
                    zipInt = Integer.parseInt(zipLabel.getText());
                } catch (NumberFormatException rand) {
                    JOptionPane.showMessageDialog(null, "Invalid Zip, Please Retry");
                    return;
                }
                cMember.setName(nameLabel.getText());
                cMember.setAddress(addressLabel.getText());
                cMember.setCity(cityLabel.getText());
                cMember.setState(stateLabel.getText());
                cMember.setZip(zipInt);
            }
        });
        rowSix.add(submitButton);

        panel.add(rowOne);
        panel.add(rowTwo);
        panel.add(rowThree);
        panel.add(rowFour);
        panel.add(rowFive);
        panel.add(rowSix);
    }
    private void providerUpdatePanel(Provider cProvider) {
        panel.removeAll();
        JPanel rowOne = new JPanel();
        JLabel nameLabel = new JLabel(cProvider.getName());
        rowOne.add(nameLabel);

        JPanel rowTwo = new JPanel();
        JLabel addressLabel = new JLabel(cProvider.getAddress());
        rowTwo.add(addressLabel);

        JPanel rowThree = new JPanel();
        JLabel cityLabel = new JLabel(cProvider.getCity());
        rowThree.add(cityLabel);

        JPanel rowFour = new JPanel();
        JLabel stateLabel = new JLabel(cProvider.getState());
        rowFour.add(stateLabel);

        JPanel rowFive = new JPanel();
        JLabel zipLabel = new JLabel(cProvider.getZip() + "");
        rowFive.add(zipLabel);

        JPanel rowSix = new JPanel();
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                int zipInt;
                try {
                    zipInt = Integer.parseInt(zipLabel.getText());
                } catch (NumberFormatException rand) {
                    JOptionPane.showMessageDialog(null, "Invalid Zip, Please Retry");
                    return;
                }
                cProvider.setName(nameLabel.getText());
                cProvider.setAddress(addressLabel.getText());
                cProvider.setCity(cityLabel.getText());
                cProvider.setState(stateLabel.getText());
                cProvider.setZip(zipInt);
            }
        });
        rowSix.add(submitButton);

        panel.add(rowOne);
        panel.add(rowTwo);
        panel.add(rowThree);
        panel.add(rowFour);
        panel.add(rowFive);
        panel.add(rowSix);
    }
}
