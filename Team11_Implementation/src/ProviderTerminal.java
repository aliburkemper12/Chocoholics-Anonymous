import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProviderTerminal {
    
    //All... instances (passed from App on creation)
    AllProviders providers;
    AllMembers members;

    //Provider directory instance
    ProviderDirectory provDirectory;

    Provider currentProvider;
   
    ProviderTerminal(AllProviders providers, AllMembers members){
        this.providers = providers;
        this.members = members;
    }

    //Called from App when Provider Terminal is selcted
    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Provider #:"));
        JTextField input = new JTextField(20);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(false, input.getText(), panel);
            }
        });
        panel.add(input);
        panel.add(submitButton);
        return panel;
    }

    
    //Called when submit is clicked when asking for Provider OR Member #
    private void verify(boolean memberCode, String input, JPanel panel){
        boolean codeIsValid = false;
        int inputInt;

        try {
            inputInt = Integer.parseInt(input);
        }
        catch (NumberFormatException rand) {
            inputInt = -1;
        }
        
        if(memberCode){
            //if invalid int then inputInt will be -1 and line below will be false
            codeIsValid = members.verifyMember(inputInt);
        }
        else{
            //if invalid int then inputInt will be -1 and line below will be false
            codeIsValid = providers.verifyProvider(inputInt);
        }

        if (codeIsValid && memberCode) {    //removes all if code is right and if memberCode was checked also adds valid label
            panel.removeAll();
            panel.setLayout(new GridLayout(2, 1));
            JLabel label = new JLabel("Member was VALID!");
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label);
        }else if (codeIsValid && !memberCode) panel.removeAll();

        if(codeIsValid){    //since code was right show verified terminal
            currentProvider = providers.getProvider(inputInt);
            JButton verifyMember = new JButton(new AbstractAction("Provide Services") {
                public void actionPerformed(ActionEvent e) {
                    panel.removeAll();
                    panel.add(new JLabel("Member #:"));
                    JTextField input = new JTextField(20);
                    JButton submitButton = new JButton(new AbstractAction("Submit") {
                        public void actionPerformed(ActionEvent e) {
                            verify(true, input.getText(), panel);
                        }
                    });
                    panel.add(input);
                    panel.add(submitButton);
                    panel.repaint();
                    panel.revalidate();
                }
            });
            JButton accessDirectory = new JButton(new AbstractAction("Access Directory") {
                public void actionPerformed(ActionEvent e) {
                    provDirectory = new ProviderDirectory(currentProvider);
                    panel.removeAll();
                    panel.add(provDirectory.getPanel());
                    panel.repaint();
                    panel.revalidate();
                }
            });;
            JButton addBill = new JButton();

            //this below just makes these go below the label
            JPanel tempLowerPanel = new JPanel();
            tempLowerPanel.add(verifyMember);
            tempLowerPanel.add(accessDirectory);
            tempLowerPanel.add(addBill);

            panel.add(tempLowerPanel);
        }
        else{//code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
        }

        //repaint and revalidate reloads the panel with updates
        panel.repaint();
        panel.revalidate();
    }
}

