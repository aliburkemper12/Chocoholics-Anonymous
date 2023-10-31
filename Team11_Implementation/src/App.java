import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
class gui{
     // //Creating the panel at bottom and adding components
     

      public static void main(String args[]){

          //Terminal instances below
          ManagerTerminal mngTerm = new ManagerTerminal();
          ProviderTerminal provTerm = new ProviderTerminal();
          OperatorTerminal opTerm = new OperatorTerminal();

          //Creating the Frame
          JFrame frame = new JFrame("GUI");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(400, 400);
               
          //Creating the MenuBar and adding components
          JMenuBar mb = new JMenuBar();
          JMenu m1 = new JMenu("Select Terminal");
          mb.add(m1);

          //South Panel
          JPanel sPanel = new JPanel();

          //Below is menu item 'Operator' and it's onClick function
          JMenuItem m1_1 = new JMenuItem(new AbstractAction("Operator") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Operator Terminal");
                    m1.setEnabled(false);
                    sPanel.add(opTerm.getPanel());
                    frame.getContentPane().add(BorderLayout.SOUTH, sPanel);
               }
          });
          //Below is menu item 'Provider' and it's onClick function
          JMenuItem m1_2 = new JMenuItem(new AbstractAction("Provider") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Provider Terminal");
                    m1.setEnabled(false);
                    sPanel.add(provTerm.getPanel());
                    frame.getContentPane().add(BorderLayout.SOUTH, sPanel);
               }
          });
          //Below is menu item 'Manager' and it's onClick function
          JMenuItem m1_3 = new JMenuItem(new AbstractAction("Manager") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Manager Terminal");
                    m1.setEnabled(false);
                    sPanel.add(mngTerm.getPanel());
                    frame.getContentPane().add(BorderLayout.SOUTH, sPanel);
               }
          });
          //Restart below just resets the menu, puts in a blank panel, and clears sPanel
          JMenuItem m2 = new JMenuItem(new AbstractAction("Restart") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Select Terminal");
                    m1.setEnabled(true);

                    sPanel.removeAll();
                    frame.repaint();
                    frame.revalidate();
               }
          });
          mb.add(m2); //adding restart to menubar

          //Adding operator, manager, and provider to menu item 'Select Terminal'
          m1.add(m1_1);
          m1.add(m1_2);
          m1.add(m1_3);

          

          //Adding menuBar to the frame. Selected terminal will be added in the actual menu item actionPerformed function
          frame.getContentPane().add(BorderLayout.NORTH, mb);
          frame.setVisible(true);
     }
}
