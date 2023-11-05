import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
class App{

     static AllProviders providers;
     static AllMembers members;
     static AllManagers managers;

     //Main functions is just holding instances of terminal and running gui
      public static void main(String args[]){
          //Initialize All... Instances
          providers = new AllProviders();
          members = new AllMembers();
          managers = new AllManagers();

          //Terminal instances below
          ManagerTerminal mngTerm = new ManagerTerminal(providers, members, managers);
          ProviderTerminal provTerm = new ProviderTerminal(providers, members);
          OperatorTerminal opTerm = new OperatorTerminal();

          //Timer instance and start timer
          TimerClass timer = new TimerClass();
          timer.runTask(5,23,59,59);     //5,23,59,59 is correct parameters for friday at 11:59:59 PM

          //Creating the Frame
          JFrame frame = new JFrame("ChocAn System");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(800, 800);
               
          //Creating the MenuBar and adding components
          JMenuBar mb = new JMenuBar();
          JMenu m1 = new JMenu("Select Terminal");
          mb.add(m1);

          //South Panel
          JPanel terminalPanel = new JPanel();

          //Demo menu below just shows demo options
          JMenu m2 = new JMenu("Demo Options");
     
          //Below is menu item 'Operator' and it's onClick function
          JMenuItem m1_1 = new JMenuItem(new AbstractAction("Operator") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Operator Terminal");
                    m1.setEnabled(false);    //make it so you can't select other terminals
                    m2.setVisible(false);    //remove demo options
                    terminalPanel.add(opTerm.getPanel());
                    frame.repaint();
                    frame.revalidate();
               }
          });

          //Below is menu item 'Provider' and it's onClick function
          JMenuItem m1_2 = new JMenuItem(new AbstractAction("Provider") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Provider Terminal");
                    m1.setEnabled(false);    //make it so you can't select other terminals
                    m2.setVisible(false);    //remove demo options
                    terminalPanel.add(provTerm.getPanel());
                    frame.repaint();
                    frame.revalidate();
               }
          });
          //Below is menu item 'Manager' and it's onClick function
          JMenuItem m1_3 = new JMenuItem(new AbstractAction("Manager") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Manager Terminal");
                    m1.setEnabled(false);    //make it so you can't select other terminals
                    m2.setVisible(false);    //remove demo options
                    terminalPanel.add(mngTerm.getPanel());
                    frame.repaint();
                    frame.revalidate();
               }
          });
          
          JMenu m3 = new JMenu("Restart/End");
          //Restart below just resets the menu, puts in a blank panel, and clears sPanel
          JMenuItem m3_1 = new JMenuItem(new AbstractAction("Restart") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Select Terminal");
                    m1.setEnabled(true);     //enable selecting terminal
                    m2.setVisible(true);     //enable demo options
                    terminalPanel.removeAll();    //clear anything inside terminalPanels
                    frame.repaint();    
                    frame.revalidate();
               }
          });
          //End Program below just disposes the frame (the view) and terminates the program
          JMenuItem m3_2 = new JMenuItem(new AbstractAction("End Program") {
               public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    System.exit(0);
               }
          });
          mb.add(m2); //adding restart to menubar

          //Adding operator, manager, and provider to menu item 'Select Terminal'
          m1.add(m1_1);
          m1.add(m1_2);
          m1.add(m1_3);
          m3.add(m3_1);
          m3.add(m3_2);

          mb.add(Box.createHorizontalGlue());
          mb.add(m3); //adding restart to menubar
          m3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

          //Adding menuBar to the frame. Selected terminal will be added in the actual menu item actionPerformed function
          frame.getContentPane().add(BorderLayout.NORTH, mb);
          frame.getContentPane().add(BorderLayout.SOUTH, terminalPanel);     //This is the terminal panel
          frame.setVisible(true);
     }
}