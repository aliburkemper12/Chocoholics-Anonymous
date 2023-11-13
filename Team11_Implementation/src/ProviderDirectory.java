import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;

//@author Luca Jontz

public class ProviderDirectory {
    
    ArrayList<Service> services;
    Provider currProvider;

    ProviderDirectory(Provider provider){
        services = provider.getServices();
        currProvider = provider;
    }

    public void requestDirectory(){
        Collections.sort(services, new ServiceComparator());
            
        String name = currProvider.getName();
        name = name.replaceAll("\\s", "");
        File outputFile = new File("Team11_Implementation" + File.separator + "data" + File.separator + "ProviderDirectories"+File.separator+name+"Services.txt");

        try{
            FileWriter myWriter = new FileWriter(outputFile.getPath());
            if(services!=null){
                for(Service s : services){
                    myWriter.write(s.toString());
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch(IOException e){
            System.out.println("error occurred in provider directory file creation\n");
        };
        return;
    }

    public ArrayList<Service> requestServices(){
        return services;
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
