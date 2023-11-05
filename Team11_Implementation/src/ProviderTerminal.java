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

        //now we know if code was valid or not
        if(codeIsValid && !memberCode){//provider code was right
            panel.removeAll();
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
            JButton accessDirectory = new JButton();
            JButton addBill = new JButton();

            panel.add(verifyMember);
            panel.add(accessDirectory);
            panel.add(addBill);
        }
        else if(!codeIsValid && !memberCode){//provider code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Provider Code, Please Retry");
        }
        else if(codeIsValid && memberCode){//member code was right
            JOptionPane.showMessageDialog(null, "Valid Member Code!");
        }
        else if(!codeIsValid && memberCode){//member code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Member Code, Please Retry");
        }

        //repaint and revalidate reloads the panel with updates
        panel.repaint();
        panel.revalidate();
    }
}

