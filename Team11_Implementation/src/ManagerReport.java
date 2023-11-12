import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class ManagerReport {

    private ZoneId z = ZoneId.of("America/Chicago"); // just sets zone
    private LocalDate today = LocalDate.now(z); // current date (needs time zone above)

    private File myObj;

    public ArrayList<String> linesInReport = new ArrayList<String>();
    
    private AllProviders providers;

    public ManagerReport(AllProviders providers) {
        this.providers = providers;
    }

    // Called in managerReport
    public void createReport() {
        makeFile();
        ArrayList<Provider> pList = providers.providerList;
        for (int i = 0; i < pList.size(); i++) {
            ArrayList<ServiceRecord> sRecords = pList.get(i).getRecords();
            String name = pList.get(i).getName();
            int totalFee = 0;
            int totalConsultations = 0;
            for (int j = 0; j < sRecords.size(); j++) {
                ServiceRecord s = sRecords.get(j);
                LocalDate ld = s.getDateService();
                if (checkIfSameWeek(ld)) {
                    totalFee += s.getServiceFee(); //need service fee in ServiceReport
                    totalConsultations++;
                }
                // if not in week just ignore
            }
            linesInReport.add("Provider Name: "+name + ",  Total Consultations: " + totalConsultations + ",  Total Fee: " + totalFee);
        }
        writeToFile();
    }

    // Returns true if check date is in the week of gloabl variable today
    private boolean checkIfSameWeek(LocalDate check) {
        DayOfWeek sun = DayOfWeek.of(7); // Sunday = 7.
        DayOfWeek sat = DayOfWeek.of(6); // Saturday = 6.

        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(sat)); // Gets next friday
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(sun));

        return !(check.isBefore(startOfWeek) || check.isAfter(endOfWeek));
    }

    // Makes file in data folder called "ManagerReport.txt"
    private void makeFile() {
        try {
            myObj = new File("Team11_Implementation" + File.separator + "data" + File.separator + "ManagerReport.txt");
            if (!myObj.createNewFile()) {
                //file already exists so delete what's in there
                myObj.delete();
                myObj.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // After linesInReport is complete this just takes each string in array and writes to new line
    private void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter(myObj.getPath());
            for(int i = 0; i < linesInReport.size(); i++){
                myWriter.write(linesInReport.get(i));
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error writing to ManagerReport.txt occurred.");
            e.printStackTrace();
        }
    }
}
