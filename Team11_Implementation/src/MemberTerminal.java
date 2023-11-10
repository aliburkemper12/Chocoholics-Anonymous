import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberTerminal {

    // All... instances (passed from App on creation)
    AllMembers members;

    Member currentMember; // is null until after verify
    boolean memberVerified = false;
    JPanel panel = new JPanel();

    MemberTerminal(AllMembers members) {
        this.members = members;
    }

    public JPanel getPanel() {
        memberVerified = false; // set providerVerified to false so everytime provider terminal is opened
        refreshPanel();
        return panel;
    }

    // Called to update screen to either verified or unverified page
    private void refreshPanel() {
        panel.removeAll();

        if (memberVerified) {
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
        JButton showButton = new JButton(new AbstractAction("Show Reports") {
            public void actionPerformed(ActionEvent e) {
                showReports();
            }
        });
        panel.add(showButton);
    }

    // Sets panel to the provider # _____ page
    private void setUnverifiedPanel() {
        JTextField input = new JTextField(10);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(input.getText());
            }
        });

        JLabel label = new JLabel("Member #:");
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(label);
        panel.add(input);
        panel.add(submitButton);
    }

    // Called when submit is clicked when asking for Provider OR Member #
    private void verify(String input) {
        int inputInt;
        try {
            inputInt = Integer.parseInt(input);
        } catch (NumberFormatException rand) {
            JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
            return;
        }

        String memberStatus = members.verifyMember(inputInt);
        if (memberStatus.equals("Validated")) {
            JOptionPane.showMessageDialog(null, "Member Valid");
            currentMember = members.getMember(inputInt);
            memberVerified = true;
        } else if (memberStatus.equals("Member suspended")) JOptionPane.showMessageDialog(null, "Member Suspended");
        else JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");

        refreshPanel();
    }

    // initiateReport is going to be called from GUI (getPanel function)
    private void showReports() {
        panel.removeAll();
        
        JLabel temp = new JLabel("Test");

        panel.add(temp);
        panel.revalidate();
        panel.repaint();
    }
}
