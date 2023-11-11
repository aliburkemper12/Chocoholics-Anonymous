// Class containing information for member report.

// @author Ali Burkemper

// passes in member to generate member report

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MemberReport {
    ArrayList<Member> memberList;
    String service;
    String providerName;
    long number;
    String member_report;

    public void generateReport(Member member){
        String memberName;
        String memberAddress;
        String memberCity;
        String memberState;
        int memberZip;
        long memberNum;

        // String serviceDate;
        // int serviceCode;
        // String providerName;

        ArrayList<ServiceRecord> sRecords = member.getService();
        String service = sRecords.toString();

        memberName = member.getName();
        memberNum = member.getMemberNumber();
        memberAddress = member.getAddress();
        memberCity = member.getCity();
        memberState = member.getState();
        memberZip = member.getZip();
        // currDate = sRecords.getDate();
        member_report += memberName + "\n" + memberNum + "\n" + memberAddress + "\n" + memberCity + "\n" + memberState + "\n" + memberZip + "\n" + service + "\n";
        LocalDate currDate = LocalDate.now();


        // Create file
        File outputFile = new File("../data/" + memberName + currDate + ".txt");
        try{
            FileWriter myWriter = new FileWriter("../data/" + memberName + currDate + ".txt");
            myWriter.write(member_report);
            myWriter.close();
        } catch(IOException e){
            System.out.println("error occurred in member report file creation\n");
        };


    }

}
