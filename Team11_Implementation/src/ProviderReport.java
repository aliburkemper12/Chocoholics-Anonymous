import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//@author Luca Jontz

public class ProviderReport extends Report{
    ArrayList<ServiceRecord> records;
    int weekFee;
    String memberName;
    String report;
    AllMembers members;
    Member currMember;
    Provider currProvider;

    ProviderReport(AllMembers members, Provider provider){
        weekFee = 0;
        memberName = "";
        report = "";
        currMember = null;
        this.members = members;
        this.records = provider.getRecords();
        this.currProvider = provider;
        receiverName = currProvider.getName();
        receiverNum = currProvider.getCreds();
        receiverAdress = currProvider.getAddress();
        receiverCity = currProvider.getCity();
        receiverState = currProvider.getState();
        receiverZip = currProvider.getZip();
    }

    public void writeReport(){
        String currDate;
        LocalDate serviceDate;
        Long memberNum;
        int serviceCode;
        int fee = 0;
        int consultations = 0;
        makeFile(true);
        report+= "Provider name: ";
        report+= receiverName;
        report+= "\nProvider number: ";
        report+= receiverNum;
        report+= "\nProvider street adress: ";
        report+= receiverAdress;
        report+= "\nProvider city: ";
        report+= receiverCity;
        report+= "\nProvider state: ";
        report+= receiverState;
        report+= "\nProvider zip: ";
        report+= receiverZip;
        report+= "\n\n";

        linesInReport.add("Provider name: "+ receiverName);
        linesInReport.add("Provider number: "+ receiverNum);
        linesInReport.add("Provider street address: "+ receiverAdress);
        linesInReport.add("Provider city: "+ receiverCity);
        linesInReport.add("Provider state: "+ receiverState);
        linesInReport.add("Provider zip: "+ receiverZip);
        linesInReport.add("");
        linesInReport.add("");

        for(ServiceRecord record : records){
            currDate = record.getDate();
            serviceDate = record.getDateService();
            memberNum = record.getMemberNum();
            serviceCode = record.getServiceCode();
            fee = record.getServiceFee();
            report += "Date of Service: ";
            report += currDate;
            report += "\nService Recieved on Date: ";
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

            linesInReport.add("Date of Service: "+ currDate);
            linesInReport.add("Service Recieved on Date: "+ formattedString);
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


    // private File myObj;
    // private void makeFile(boolean providerReport) {
    //     try {
    //         ZoneId z = ZoneId.of( "America/Chicago" ); //just sets zone
    //         LocalDate today = LocalDate.now(z); //current date
    //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    //         String formatDate = today.format(formatter);

    //         String name = receiverName;
    //         name = name.replaceAll("\\s", "");

    //         String whichFolder = "MemberReports";
    //         if(providerReport) whichFolder = "ProviderReports";
    //         myObj = new File("Team11_Implementation" + File.separator + "data" + File.separator + whichFolder+File.separator+name+"_"+formatDate+".txt");
    //         int count = 0;
    //         while (!myObj.createNewFile()) {
    //             //file already exists but want to keep old file
    //             count++;
    //             myObj = new File("Team11_Implementation" + File.separator + "data" + File.separator + whichFolder+File.separator+name+"_"+formatDate+"("+count+").txt");
    //         }
    //     } catch (IOException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }
    // }

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
