import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProviderTerminal {

    // All... instances (passed from App on creation)
    AllProviders providers;
    AllMembers members;

    // provDirectory and provDirectoryPanel will be initialized after provider is
    // verified
    ProviderDirectory provDirectory;
    JPanel provDirectoryPanel;
    boolean providerVerified = false;

    Provider currentProvider;

    ProviderTerminal(AllProviders providers, AllMembers members) {
        this.providers = providers;
        this.members = members;
    }

    // The actual screen
    private JPanel panel = new JPanel();
    private JMenu menu;

    // Called from App to get this panel
    public JPanel getPanel(JMenu mb) {
        resetClass();
        refreshPanel();
        menu = mb;
        return panel;
    }

    private void resetClass(){
        providerVerified = false;
    }

    // Called to update screen
    public void refreshPanel() {
        panel.removeAll();

        if (providerVerified) {
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
        JButton verifyMember = new JButton(new AbstractAction("Provide Services") {
            public void actionPerformed(ActionEvent e) {
                setMemberRequestPanel(false);
            }
        });
        JButton accessDirectory = new JButton(new AbstractAction("Show Directory") {
            public void actionPerformed(ActionEvent e) {
                showProviderDirectory();
            }
        });

        JButton addBill = new JButton(new AbstractAction("Bill Service") {
            public void actionPerformed(ActionEvent e) {
                setMemberRequestPanel(true);
            }
        });

        panel.add(verifyMember);
        panel.add(addBill);
        panel.add(accessDirectory);
    }

    // Sets panel to the provider # _____ page
    private void setUnverifiedPanel() {
        JTextField input = new JTextField(10);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(false, input.getText(), false);
            }
        });

        JLabel label = new JLabel("Provider #:");
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(label);
        panel.add(input);
        panel.add(submitButton);
    }

    // Sets panel to the member # ___ page
    private void setMemberRequestPanel(boolean fromBill) {
        panel.removeAll();

        JLabel label = new JLabel("Member #:");
        label.setHorizontalAlignment(JLabel.RIGHT);
        JTextField input = new JTextField(10);
        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                verify(true, input.getText(), fromBill);
            }
        });

        panel.add(label);
        panel.add(input);
        panel.add(submitButton);
        panel.revalidate();
        panel.repaint();
    }

    // Called when submit is clicked when asking for Provider OR Member #
    // memberCode is true when it was prompting for member num,
    // fromBill is true when it's called from Bill Service btn.
    private void verify(boolean memberCode, String input, boolean fromBill) {
        long inputInt;
        try {
            inputInt = Long.parseLong(input);
        } catch (NumberFormatException rand) {
            inputInt = -1;
        }

        if (memberCode) {
            String memberStatus = members.verifyMember(inputInt);
        
            if (memberStatus.equals("Validated")) {
                JOptionPane.showMessageDialog(null, "Member Valid");
                if (fromBill) {
                    setBillPanel(inputInt);
                    return;
                }
            } else if(memberStatus.equals("Member suspended")){
                JOptionPane.showMessageDialog(null, "Member Suspended");
            } 
            else JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
        } else {
            if (providers.verifyProvider(inputInt)) {
                providerVerified = true;
                JMenuItem m1 = new JMenuItem(new AbstractAction("Show Directory") {
                    public void actionPerformed(ActionEvent e) {
                        showProviderDirectory();
                    }
                });
                menu.setText("Show Directory");
                menu.add(m1);
                // currentProvider = providers.getProvider(inputInt);
                // provDirectory = new ProviderDirectory(currentProvider);
                // provDirectoryPanel = provDirectory.getPanel();
            } else
                JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
        }

        refreshPanel();
    }

    // Panel for filling out bill after member was verified
    private void setBillPanel(long memberCode) {
        Member currentMember = members.getMember(memberCode);
        panel.removeAll();

        JPanel tempPanel = new JPanel();

        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
        // panel.add(datePicker);
        JPanel rowOne = new JPanel();
        JLabel label = new JLabel("MM-DD-YYYY:");
        JLabel dash1 = new JLabel("-");
        JLabel dash2 = new JLabel("-");
        JTextField monthInput = new JTextField(2);

        JTextField dayInput = new JTextField(2);

        JTextField yearInput = new JTextField(4);
        
        rowOne.add(label);
        rowOne.add(monthInput);
        rowOne.add(dash1);
        rowOne.add(dayInput);
        rowOne.add(dash2);
        rowOne.add(yearInput);

        JPanel rowTwo = new JPanel();
        JLabel serviceLabel = new JLabel("Service Code:");
        JTextField codeInput = new JTextField(10);
        rowTwo.add(serviceLabel);
        rowTwo.add(codeInput);

        JPanel rowThree = new JPanel();
        JTextArea textArea = new JTextArea(4,30);
        rowThree.add(textArea);

        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                String date = monthInput.getText()+ "-" + dayInput.getText()+ "-" + yearInput.getText();
                //check if serviceLabel is real code
                //make it an int
                addServices(currentProvider, currentMember, date, 1, textArea.getText());
            }
        });

        JPanel rowFour = new JPanel();
        rowFour.add(submitButton);

        tempPanel.add(rowOne);
        tempPanel.add(rowTwo);
        tempPanel.add(rowThree);
        tempPanel.add(rowFour);

        panel.add(tempPanel);

        panel.revalidate();
        panel.repaint();
    }

    JPanel getTempPanel(){
        JPanel test = new JPanel();
        return test;
    }

    // Opens new frame of the provDirectoryPanel which shows services
    private void showProviderDirectory() {
        JFrame frame = new JFrame("Provider Directory");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        // frame.add(provDirectoryPanel);
        frame.setVisible(true);
    }

    //add to cProvider and cMember and get current date
    private void addServices(Provider cProvider, Member cMember, String date, int serviceCode, String comments){
        ServiceRecord temp = new ServiceRecord(date, date, cProvider.getCreds(), cMember.getMemberNumber(), serviceCode, comments);
    }
}
