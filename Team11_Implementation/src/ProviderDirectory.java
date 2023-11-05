import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class ProviderDirectory {
    ProviderDirectory(){

    }

    ArrayList<Service> Services;

    public void requestDirectory(){
        Collections.sort(Services, new ServiceComparator());
            
        File outputFile = new File("Provider_Directory.txt");

        try{
            FileWriter myWriter = new FileWriter("Provider_Directory.txt");
            myWriter.write(Services.toString());
        } catch(IOException e){};
        return;
    }

    class Service extends ProviderDirectory {
        private String name;
        private int code;
        private int fee;
        public Service(String name, int code, int fee){
            this.name = name;
            this.code = code;
            this.fee = fee;
        }
        public String getName(){
            return name;
        }
        public int getCode(){
            return code;
        }
        public int getFee(){
            return fee;
        }
        public String toString(){
            return name + " code: " + code + " fee: " + fee + "\n";
        }
    }

    class ServiceComparator implements java.util.Comparator<Service> {
        public int compare(Service a, Service b){
            String aName = a.getName();
            String bName = b.getName();
            return aName.compareTo(bName);
        }
    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Provider Directory"));
        return panel;
    }
}
