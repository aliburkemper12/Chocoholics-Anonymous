import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProviderReport {
    ArrayList<ServiceRecord> records;
    int weekFee;
    String memberName;
    String report;
    AllMembers members;
    Member currMember;

    ProviderReport(AllMembers members, ArrayList<ServiceRecordecord> records){
        weekFee = 0;
        this.members = members;
        this.records = records;
    }

    public void writeReport(){
        String currDate;
        String serviceDate;
        Long memberNum;
        int serviceCode;
        int fee;
        int consultations = 0;
        makeFile();
        for(ServiceRecord record : records){
            currDate = record.getCurrDate();
            serviceDate = record.serviceDate();
            memberNum = record.getMemberNum();
            serviceCode = record.getServiceCode();
            fee = record.getFee();
            report += "Current date and time: ";
            report += currDate;
            report += "\nService date: ";
            report += serviceDate;
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
            report += "\n\n"
            consultations++;
            weekFee += fee;
        }
        report += "Number of consultations: ";
        report += consultations;
        report += "\nTotal fee for the week: ";
        report += fee;
        report += "\n";
        writeToFile();
    }

    private void makeFile() {
        try {
            myObj = new File("Team11_Implementation" + File.separator + "data" + File.separator + "ProviderReport.txt");
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
            myWriter.write(report);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error writing to ProviderReport.txt occurred.");
            e.printStackTrace();
        }
    }
}
