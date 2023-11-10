import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerReport {

    public ManagerReport() {

    }

    public void createReport(AllProviders providers) {
        ArrayList<Provider> pList = providers.providerList;
        try {
            // File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
            File myObj = new File("Team11_Implementation"+ File.separator + "data"+ File.separator +"newFile.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // for(int i = 0; i < pList.size(); i ++){
        // ArrayList<ServiceRecord> sRecords = pList.get(i).getRecords();
        // int totalFee = 0;
        // int totalConsultations = 0;
        // for(int j = 0; j < sRecords.size(); j++){
        // ServiceRecord s = sRecords.get(j);
        // LocalDate ld = s.getDateService();
        // if(ld)
        // }
        // }
    }
}
