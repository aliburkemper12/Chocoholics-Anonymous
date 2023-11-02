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
   
    ManagerTerminal(AllProviders providers, AllMembers members, AllManagers managers){
        this.providers = providers;
        this.members = members;
        this.managers = managers;
    }

    //Called from App when Manager Terminal is selcted
    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Manager #:"));
        JTextField input = new JTextField(20);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(input.getText(), panel);
            }
        });
        panel.add(input);
        panel.add(submitButton);
        return panel;
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

        //if invalid int then inputInt will be -1 and line below will be false
        boolean codeIsValid = managers.verifyManager(inputInt);

        //now we know if code was valid or not
        if(codeIsValid){//Manager code was right
            panel.removeAll();
            JButton requestReport = new JButton(new AbstractAction("Request Reports") {
                public void actionPerformed(ActionEvent e) {
                    requestReport();
                }
            });
            panel.add(requestReport);
        }
        else{//provider code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Manager Code, Please Retry");
        }

        //repaint and revalidate reloads the panel with updates
        panel.repaint();
        panel.revalidate();
    }

    //initiateReport is going to be called from GUI (getPanel function)
    private void requestReport(){
        Report newReport = new Report();
        newReport.generateReport();
        newReport.sendReport();
    }
}
