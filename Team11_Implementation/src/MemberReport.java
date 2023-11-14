// Class containing information for member report.

// @author Ali Burkemper

// passes in member to generate member report

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MemberReport {
    String member_report = "";
    ArrayList<ServiceRecord> records;

    // Generate member report
    public void generateReport(Member member){
        this.records = member.getService();
     
        String memberName;
        String memberAddress;
        String memberCity;
        String memberState;
        int memberZip;
        long memberNum;
        String serviceDate = "";
        int serviceCode = 0;
        long providerNumber = 0;

        // Gather member information
        memberName = member.getName();
        memberNum = member.getMemberNumber();
        memberAddress = member.getAddress();
        memberCity = member.getCity();
        memberState = member.getState();
        memberZip = member.getZip();

        // Add member information to report string
        member_report += "Name: " + memberName + "\n" + "Member number: " + memberNum + "\n" + "Member address: " + memberAddress + "\n" + "Member City: " + memberCity + "\n" + "Member state: " + memberState + "\n" + "Member zipcode: " + memberZip + "\n";


        // Get all services for currMember and add to report string
        for(ServiceRecord record : records) {
            // Provider tempProvider;
            // tempProvider = tempProvider.getProvider(record.getProviderNum());
            // String providerName = tempProvider.getName();
            // Service tempService;

            serviceDate = record.getDate();
            serviceCode = record.getServiceCode();
            providerNumber = record.getProviderNum();
            member_report +=  "Service name: " + serviceCode + "\n" + "Date of service: " + serviceDate + "\n" + "Provider name: " + providerNumber + "\n";
        }

        // Get local date and format it
        LocalDate currDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formatDate = currDate.format(formatter);

        // Create file containing report string
        File outputFile = new File("Team11_Implementation" + File.separator + "data" + File.separator + "MemberReports" + File.separator + memberName + formatDate + ".txt");
        try{
            if(!outputFile.createNewFile()) {
                outputFile.delete();
                outputFile.createNewFile();
            }
            FileWriter myWriter = new FileWriter("Team11_Implementation" + File.separator + "data" + File.separator + "MemberReports" + File.separator + memberName + formatDate + ".txt");
            myWriter.write(member_report);
            myWriter.close();
        } catch(IOException e){
            System.out.println("error occurred in member report file creation\n");
            e.printStackTrace();
        };


    }

}
