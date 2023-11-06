import java.awt.Panel;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberTerminal {

    //All... instances (passed from App on creation)
    AllMembers members;

    Member currentMember; //is null until after verify
   
    MemberTerminal(AllMembers members){
        this.members = members;
    }

    //Called from App when Manager Terminal is selcted
    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Member #:"));
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
        boolean codeIsValid = members.verifyMember(inputInt);

        //now we know if code was valid or not
        if(codeIsValid){//Manager code was right
            panel.removeAll();
            currentMember = members.getMember(inputInt);
            panel.add(showReports(currentMember));
        }
        else{//provider code was wrong
            JOptionPane.showMessageDialog(null, "Invalid Member Code, Please Retry");
        }

        //repaint and revalidate reloads the panel with updates
        panel.repaint();
        panel.revalidate();
    }

    //initiateReport is going to be called from GUI (getPanel function)
    private Panel showReports(Member member){
        return new Panel();
    }
}
