import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
class gui{

     
     
     

      public static void main(String args[]){

          //Creating the Frame
          JFrame frame = new JFrame("Chat Frame");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(400, 400);

          // Text Area at the Center
          JPanel ta = new JPanel();

          //Creating the panel at bottom and adding components
          JPanel panel = new JPanel(); 
          panel.setVisible(false);
          JLabel label = new JLabel("Enter Provider Number");
          JTextField tf = new JTextField(10); // accepts upto 10 characters
          JButton send = new JButton("Send");
          JButton reset = new JButton("Reset");
          panel.add(label); // Components Added using Flow Layout
          panel.add(tf);
          panel.add(send);
          panel.add(reset);
               
          //Creating the MenuBar and adding components
          JMenuBar mb = new JMenuBar();
          JMenu m1 = new JMenu("Select Terminal");
          mb.add(m1);
          JMenuItem m1_1 = new JMenuItem(new AbstractAction("Operator") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Operator Terminal");
                    m1.setEnabled(false);
                    panel.setVisible(true);
                    label.setText("Enter Operator Number");
               }
          });
          JMenuItem m1_2 = new JMenuItem(new AbstractAction("Provider") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Provider Terminal");
                    m1.setEnabled(false);
                    panel.setVisible(true);
                    label.setText("Enter Provider Number");
               }
          });
          JMenuItem m1_3 = new JMenuItem(new AbstractAction("Manager") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Manager Terminal");
                    m1.setEnabled(false);
                    panel.setVisible(true);
                    label.setText("Enter Manager Number");
               }
          });
          JMenuItem m2 = new JMenuItem(new AbstractAction("Restart") {
               public void actionPerformed(ActionEvent e) {
                    m1.setText("Select Terminal");
                    m1.setEnabled(true);
                    panel.setVisible(false);
               }
          });
          mb.add(m2);

          m1.add(m1_1);
          m1.add(m1_2);
          m1.add(m1_3);

          

          //Adding Components to the frame.
          frame.getContentPane().add(BorderLayout.SOUTH, panel);
          frame.getContentPane().add(BorderLayout.NORTH, mb);
          frame.getContentPane().add(BorderLayout.CENTER, ta);
          frame.setVisible(true);
     }
}
