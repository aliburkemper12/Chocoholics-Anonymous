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
    private AllProviders providers;
    private AllMembers members;

    //Creates the class, called from App
    ProviderTerminal(AllProviders providers, AllMembers members) {
        this.providers = providers;
        this.members = members;
    }

    private boolean providerVerified = false;
    private Provider currentProvider;

    // The actual screen and menu
    private JPanel panel = new JPanel();
    private JMenu menu;

    // Called from App to get this panel
    public JPanel getPanel(JMenu mb) {
        providerVerified = false; // set providerVerified to false so everytime provider terminal is opened
        refreshPanel();
        menu = mb;
        return panel;
    }

    // Called to update screen to either verified or unverified page
    private void refreshPanel() {
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
    // fromBill is true when it's called from Bill Service btn.
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
            JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
            return;
        }

        if (memberCode) {
            String memberStatus = members.verifyMember(inputInt);

            if (memberStatus.equals("Validated")) {
                JOptionPane.showMessageDialog(null, "Member Valid");
                if (fromBill) {
                    Member cMember = members.getMember(inputInt);
                    setBillPanel(cMember, false);
                    return;
                }
            } else if (memberStatus.equals("Member suspended")) {
                JOptionPane.showMessageDialog(null, "Member Suspended");
            } else
                JOptionPane.showMessageDialog(null, "Invalid Code, Please Retry");
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

    //variables used for setBillPanel and setConfirmationPanel
    private String codeText;
    private String monthText;
    private String dayText;
    private String yearText; 
    private String comments;

    // Panel for filling out bill after member was verified
    // Called when "Bill Service" clicked
    private void setBillPanel(Member cMember, boolean useTextValues) {
        Member currentMember = cMember;
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
        JLabel commentLabel = new JLabel("Comments:");
        rowThree.add(commentLabel);

        JPanel rowFour = new JPanel();
        JTextArea textArea = new JTextArea(4, 30);
        rowFour.add(textArea);

        JButton submitButton = new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                codeText = codeInput.getText();
                monthText = monthInput.getText();
                dayText = dayInput.getText();
                yearText = yearInput.getText();
                comments = textArea.getText();
                setConfirmationPanel(currentMember);
            }
        });

        JPanel rowFive = new JPanel();
        rowFive.add(submitButton);

        tempPanel.add(rowOne);
        tempPanel.add(rowTwo);
        tempPanel.add(rowThree);
        tempPanel.add(rowFour);
        tempPanel.add(rowFive);

        panel.add(tempPanel);

        if(useTextValues){
            monthInput.setText(monthText);
            dayInput.setText(dayText);
            yearInput.setText(yearText);
            codeInput.setText(codeText);
            textArea.setText(comments);
        }

        panel.revalidate();
        panel.repaint();
    }

    // The screen after submit is clicked when billing
    // Show the service code and name and asks if it's correct
    // If "No" pressed then goes back to billPanel 
    // If "Yes" pressed then calls addServiceReports and alerts it worked and calls refreshPanel()
    private void setConfirmationPanel(Member cMember) {
        int monthInt;
        int dayInt;
        int yearInt;
        int codeInt;
        try {
            codeInt = Integer.parseInt(codeText);
            // check if codeInt is valid service, if not then alert and return
        } catch (NumberFormatException rand) {
            JOptionPane.showMessageDialog(null, "Code needs to be all numbers");
            return;
        }
        // get month input
        try {
            monthInt = Integer.parseInt(monthText);
            if (monthInt < 1 || monthInt > 12) {
                JOptionPane.showMessageDialog(null, "Month isn't valid (Needs to be number 1-12)");
                return;
            }
        } catch (NumberFormatException rand) {
            JOptionPane.showMessageDialog(null, "Month isn't valid (Needs to be number 1-12)");
            return;
        }
        // get day input
        try {
            dayInt = Integer.parseInt(dayText);
            if (dayInt < 1 || dayInt > 31) {
                JOptionPane.showMessageDialog(null, "Day isn't valid (Needs to be number 1-31)");
                return;
            }
        } catch (NumberFormatException rand) {
            JOptionPane.showMessageDialog(null, "Day isn't valid (Needs to be number 1-31)");
            return;
        }
        // get year input
        try {
            yearInt = Integer.parseInt(yearText);
            if (yearInt < 1990) {
                JOptionPane.showMessageDialog(null, "Year isn't valid (Needs to be number greater than 1990)");
                return;
            }
        } catch (NumberFormatException rand) {
            JOptionPane.showMessageDialog(null, "Year isn't valid (Needs to be number greater than 1990)");
            return;
        }
        // at this point: code is valid service code and month, day, and year are valid;

        JPanel rowOne = new JPanel();
        JLabel isCorrectLabel = new JLabel("Is this service correct?");
        rowOne.add(isCorrectLabel);

        JPanel rowTwo = new JPanel();
        JLabel serviceCodeLabel = new JLabel("Service Code: " + codeInt);
        rowTwo.add(serviceCodeLabel);

        JPanel rowThree = new JPanel();
        // Get service name from code
        String serviceName = "Temp";
        JLabel serviceCodeName = new JLabel("Service Name: " + serviceName);
        rowThree.add(serviceCodeName);

        JPanel rowFour = new JPanel();
        JButton yesButton = new JButton(new AbstractAction("Yes") {
            public void actionPerformed(ActionEvent e) {
                String date = monthInt + "-" + dayInt + "-" + yearInt;
                addServiceReports(currentProvider, cMember, date, codeInt, comments);
                JOptionPane.showMessageDialog(null, "Service successfully billed!");
                refreshPanel();
            }
        });
        JButton noButton = new JButton(new AbstractAction("No") {
            public void actionPerformed(ActionEvent e) {
                setBillPanel(cMember, true);
            }
        });
        rowFour.add(noButton);
        rowFour.add(yesButton);

        JPanel tempPanel1 = new JPanel();
        tempPanel1.setLayout(new BoxLayout(tempPanel1, BoxLayout.Y_AXIS));

        tempPanel1.add(rowOne);
        tempPanel1.add(rowTwo);
        tempPanel1.add(rowThree);
        tempPanel1.add(rowFour);
        panel.removeAll();
        panel.add(tempPanel1);

        panel.revalidate();
        panel.repaint();
    }

    // Opens new frame which should show all services available
    private void showProviderDirectory() {
        JFrame frame = new JFrame("Provider Directory");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        // frame.add(provDirectoryPanel);
        frame.setVisible(true);
    }

    // Uses information passed in to make a new ServiceRecord() and add it to the member and provider involved
    private void addServiceReports(Provider cProvider, Member cMember, String date, int serviceCode, String comments) {
        // ServiceRecord temp = new ServiceRecord(date, date, cProvider.getCreds(),
        // cMember.getMemberNumber(), serviceCode, comments);
        // cProvider.addService(temp);
        // cMember.addService(temp);
    }
}
