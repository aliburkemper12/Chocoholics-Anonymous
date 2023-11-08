import java.util.ArrayList;

public class ProviderReport {
    ArrayList<DiskRecord> records;
    int weekFee;
    String memberName;
    String report;

    ProviderReport(){
        weekFee = 0;
    }

    public void addRecord(DiskRecord record){
        records.add(record);
    }

    public String writeReport(){
        String currDate;
        String serviceDate;
        Long memberNum;
        int serviceCode;
        int fee;
        int consultations = 0;
        
        for(DiskRecord record : records){
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
            memberName = 
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
        return report;
    }
}
