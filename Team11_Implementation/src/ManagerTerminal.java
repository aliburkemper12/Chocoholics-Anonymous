import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagerTerminal {

    //All... instances (passed from App on creation)
    AllProviders providers;
    AllMembers members;
    AllManagers managers;

    Manager currentManager;
    boolean managerVerified = false;

    JPanel panel = new JPanel();
   
    ManagerTerminal(AllProviders providers, AllMembers members, AllManagers managers){
        this.providers = providers;
        this.members = members;
        this.managers = managers;
    }

    //Called from App when Manager Terminal is selcted
    public JPanel getPanel() {
        managerVerified = false; // set managerVerified to false so everytime provider terminal is opened
        refreshPanel();
        return panel;
    }

    // Called to update screen to either verified or unverified page
    private void refreshPanel() {
        panel.removeAll();

        if (managerVerified) {
            setVerfiedPanel();
        } else {
            setUnverifiedPanel();
        }

        // need to repaint and revalidate for screen to update
        panel.revalidate();
        panel.repaint();
    }

    // Sets panel to verified page
    private void setVerfiedPanel() {
        JButton requestReport = new JButton(new AbstractAction("Request Reports") {
            public void actionPerformed(ActionEvent e) {
                requestReport();
            }
        });
        panel.add(requestReport);
    }

    // Sets panel to the manager # _____ page
    private void setUnverifiedPanel() {
        JTextField input = new JTextField(10);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(input.getText(), panel);
            }
        });

        JLabel label = new JLabel("Manager #:");
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(label);
        panel.add(input);
        panel.add(submitButton);
    }


    //Called when submit is clicked when asking for Provider OR Member #
    private void verify(String input, JPanel panel){
        int inputInt;
        try {
            inputInt = Integer.parseInt(input);
        }
        catch (NumberFormatException rand) {
            inputInt = -1;
        }

        //now we know if code was valid or not
        if(managers.verifyManager(inputInt)){//Manager code was right
            currentManager = managers.getManager(inputInt);
            managerVerified = true;
            refreshPanel();
        }
        else{//provider code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Manager Code, Please Retry");
        }
    }

    //initiateReport is going to be called from GUI (getPanel function)
    private void requestReport(){
        MainAccountingProcedure temp = new MainAccountingProcedure(members, providers);
        temp.runMainAccountingProcedure();
    }
}
