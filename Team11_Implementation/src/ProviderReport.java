import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//@author Luca Jontz

public class ProviderReport {
    ArrayList<ServiceRecord> records;
    int weekFee;
    String memberName;
    String report;
    AllMembers members;
    Member currMember;
    Provider currProvider;

    public ArrayList<String> linesInReport = new ArrayList<String>();

    ProviderReport(AllMembers members, Provider provider){
        weekFee = 0;
        memberName = "";
        report = "";
        currMember = null;
        this.members = members;
        this.records = provider.getRecords();
        this.currProvider = provider;
    }

    public void writeReport(){
        String currDate;
        LocalDate serviceDate;
        Long memberNum;
        int serviceCode;
        int fee = 0;
        int consultations = 0;
        makeFile();
        report+= "Provider name: ";
        report+= currProvider.getName();
        report+= "\nProvider number: ";
        report+= currProvider.getCreds();
        report+= "\nProvider street adress: ";
        report+= currProvider.getAddress();
        report+= "\nProvider city: ";
        report+= currProvider.getCity();
        report+= "\nProvider state: ";
        report+= currProvider.getState();
        report+= "\nProvider zip: ";
        report+= currProvider.getZip();
        report+= "\n\n";

        linesInReport.add("Provider name: "+ currProvider.getName());
        linesInReport.add("Provider number: "+ currProvider.getCreds());
        linesInReport.add("Provider street address: "+ currProvider.getAddress());
        linesInReport.add("Provider city: "+ currProvider.getCity());
        linesInReport.add("Provider state: "+ currProvider.getState());
        linesInReport.add("Provider zip: "+ currProvider.getZip());
        linesInReport.add("");
        linesInReport.add("");

        for(ServiceRecord record : records){
            currDate = record.getDate();
            serviceDate = record.getDateService();
            memberNum = record.getMemberNum();
            serviceCode = record.getServiceCode();
            fee = record.getServiceFee();
            report += "Current date and time: ";
            report += currDate;
            report += "\nService date: ";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String formattedString = serviceDate.format(formatter);
            report += formattedString;
            report += "\nMember name and number: ";
            currMember = members.getMember(memberNum);
            memberName = currMember.getName();
            report += memberName;
            report += " ";
            report += memberNum;
            report += "\nService code: ";
            report += serviceCode;
            report += "\nFee: ";
            report += fee;
            report += "\n\n";
            consultations++;
            weekFee += fee;

            linesInReport.add("Current date and time: "+ currDate);
            linesInReport.add("Service date: "+ formattedString);
            linesInReport.add("Member name and number: "+ memberName +" "+memberNum);
            linesInReport.add("Service code: "+ serviceCode);
            linesInReport.add("Fee: "+ fee);
            linesInReport.add("");
            linesInReport.add("");
        }
        report += "Number of consultations: ";
        report += consultations;
        report += "\nTotal fee for the week: ";
        report += fee;
        report += "\n";

        linesInReport.add("Number of consultations: "+ consultations);
        linesInReport.add("Total fee for the week: "+ fee);

        writeToFile();
    }


    private File myObj;
    private void makeFile() {
        try {
            ZoneId z = ZoneId.of( "America/Chicago" ); //just sets zone
            LocalDate today = LocalDate.now(z); //current date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String formatDate = today.format(formatter);
            String name = currProvider.getName();
            name = name.replaceAll("\\s", "");
            myObj = new File("Team11_Implementation" + File.separator + "data" + File.separator + "ProviderReports"+File.separator+name+":"+formatDate+".txt");
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

    private void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter(myObj.getPath());
            myWriter.write(report);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error writing to ProviderReport.txt occurred.");
            e.printStackTrace();
        }
    }
}
