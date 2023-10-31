import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ManagerTerminal {

    ManagerTerminal(){

    }

    //might need to be string if we want more than 2 outcomes (ex. invalid, valid, and expired etc.)
    private boolean verifyManager(int credentials){
        //need to make
        return true;
    }

    //initiateReport is going to be called from GUI (getPanel function)
    private void requestReport(){
        Report newReport = new Report();
        newReport.generateReport();
        newReport.sendReport();
    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Manager"));
        return panel;
    }
}
