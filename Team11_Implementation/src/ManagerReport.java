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
    private LocalDate today = LocalDate.now(z); // current date

    private File myObj;

    public ArrayList<String> linesInReport;

    public ManagerReport() {

    }

    public void createReport(AllProviders providers) {
        makeFile();
        ArrayList<Provider> pList = providers.providerList;
        linesInReport = new ArrayList<String>();
        for (int i = 0; i < pList.size(); i++) {
            ArrayList<ServiceRecord> sRecords = pList.get(i).getRecords();
            String name = pList.get(i).getName();
            int totalFee = 0;
            int totalConsultations = 0;
            for (int j = 0; j < sRecords.size(); j++) {
                ServiceRecord s = sRecords.get(j);
                LocalDate ld = s.getDateService();
                if (checkIfSameWeek(today, ld)) {
                    // totalFee += s.getServiceFee(); //need service fee in ServiceReport
                    totalConsultations++;
                }
                // if not in week just ignore
            }
            linesInReport.add("Provider: "+name + "-> Total Consultations: " + totalConsultations + ",  Total Fee: " + totalFee + ";");
        }
        writeToFile();
    }

    private boolean checkIfSameWeek(LocalDate today, LocalDate check) {
        DayOfWeek sun = DayOfWeek.of(0); // Sunday = 0.
        DayOfWeek sat = DayOfWeek.of(6); // Saturday = 6.

        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(sat)); // Gets next friday
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(sun));

        return !(check.isBefore(startOfWeek) || check.isAfter(endOfWeek));
    }

    private void makeFile() {
        try {
            myObj = new File("Team11_Implementation" + File.separator + "data" + File.separator + "ManagerReport.txt");
            if (myObj.createNewFile()) {
                // System.out.println("File created: " + myObj.getName());
            } else {
                // System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

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
