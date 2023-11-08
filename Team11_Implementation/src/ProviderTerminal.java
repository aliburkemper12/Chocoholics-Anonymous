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
    boolean directoryToggle = false;

    Provider currentProvider;
   
    ProviderTerminal(AllProviders providers, AllMembers members){
        this.providers = providers;
        this.members = members;
    }

    JPanel panel;
    JPanel mainPanel;
    JPanel dirPanel;

    //Called from App when Provider Terminal is selcted
    public JPanel getPanel(){
        panel = new JPanel(); 

        mainPanel = new JPanel();
        dirPanel = new JPanel();
        JLabel test = new JLabel("Directory Here");
        dirPanel.add(test);

        panel.setLayout(new GridLayout(1,1));
        panel.add(mainPanel);
        // panel.add(dirPanel);

        JTextField input = new JTextField(10);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(false, input.getText(), false);
            }
        });

        JLabel label = new JLabel("Provider #:");
        label.setHorizontalAlignment(JLabel.RIGHT);
        mainPanel.add(label);
        mainPanel.add(input);
        mainPanel.add(submitButton);

        return panel;
    }

    
    //Called when submit is clicked when asking for Provider OR Member #
    private void verify(boolean memberCode, String input, boolean fromBill){
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
            mainPanel.removeAll();
            JOptionPane.showMessageDialog(null, "Member Approved");
            // mainPanel.setLayout(new GridLayout(2,1));
            // JLabel label = new JLabel("Member was VALID!");
            // label.setHorizontalAlignment(JLabel.CENTER);
            // mainPanel.add(label);
        }else if (codeIsValid && !memberCode){
            mainPanel.removeAll();
            currentProvider = providers.getProvider(inputInt);
        } 

        if(codeIsValid){    //since code was right show verified terminal
            JButton verifyMember = new JButton(new AbstractAction("Provide Services") {
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    
                    JLabel label = new JLabel("Member #:");
                    label.setHorizontalAlignment(JLabel.RIGHT);
                    mainPanel.add(label);
                    JTextField input = new JTextField(10);
                    JButton submitButton = new JButton(new AbstractAction("Submit") {
                        public void actionPerformed(ActionEvent e) {
                            verify(true, input.getText(), false);
                        }
                    });
                    
                    mainPanel.add(input);
                    mainPanel.add(submitButton);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            });
            JButton accessDirectory = new JButton(new AbstractAction("Toggle Directory") {
                public void actionPerformed(ActionEvent e) {
                    if(!directoryToggle){
                        panel.removeAll();
                        panel.setLayout(new GridLayout(1,2));
                        panel.add(mainPanel);
                        panel.add(dirPanel);
                    }
                    else{
                        panel.removeAll();
                        panel.setLayout(new GridLayout(1,1));
                        panel.add(mainPanel);
                    }
                    directoryToggle = !directoryToggle;
                    dirPanel.repaint();
                    dirPanel.revalidate();
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            });;
            JButton addBill = new JButton(new AbstractAction("Bill Service") {
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    
                    JTextField input = new JTextField(10);
                    JButton submitButton = new JButton(new AbstractAction("Submit") {
                        public void actionPerformed(ActionEvent e) {
                            verify(true, input.getText(), true);
                        }
                    });

                    JLabel label = new JLabel("Member #:");
                    label.setHorizontalAlignment(JLabel.RIGHT);
                    mainPanel.add(label);
                    mainPanel.add(input);
                    mainPanel.add(submitButton);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            });

            //this below just makes these go below the label
            JPanel tempLowerPanel = new JPanel();
            
            tempLowerPanel.add(verifyMember);
            tempLowerPanel.add(addBill);
            tempLowerPanel.add(accessDirectory);

            mainPanel.add(tempLowerPanel);
        }
        else{//code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
        }

        //repaint and revalidate reloads the panel with updates
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void requestDirectory(){
        ProviderDirectory directory = new ProviderDirectory(currentProvider);
        directory.requestDirectory();
    }

    

    JPanel getTempPanel(){
        JPanel test = new JPanel();
        return test;
    }
}

