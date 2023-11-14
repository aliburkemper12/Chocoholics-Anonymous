import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.time.ZonedDateTime;

//@author Jack Sherry

public class MainAccountingProcedure {
    
    AllMembers members;
    AllProviders providers;

    MainAccountingProcedure(AllMembers members, AllProviders providers){
        this.members = members;
        this.providers = providers;
    }

    public void runMainAccountingProcedure(){

        ArrayList<Member> memberList = members.memberList;
        ArrayList<Provider> providerList = providers.providerList;

        for (int i = 0; i < memberList.size(); i++) {
            Member toFindMember = memberList.get(i);
            //ArrayList<ServiceRecord> serviceReport = toFindMember.getService();
            //for (int j = 0; j < serviceReport.size(); j++) {
                //ServiceRecord toFindServiceReport = serviceReport.get(j);
                
                //LocalDate reportDate = toFindServiceReport.getDateService();
                //ZoneId zone = ZoneId.of( "America/Chicago" ); 
                //LocalDate today = LocalDate.now(zone);
                //DayOfWeek todayEnum = today.getDayOfWeek();
                //DayOfWeek reportDateEnum = reportDate.getDayOfWeek();
                // how do I convert the enums to ints???
                //if (reportDate < today) {
                    Report newMemberReport = new Report();
                    newMemberReport.generateMemberReport(toFindMember.getMemberNumber());
                    toFindMember.serviceReports.clear();
                //}
            //}
        }
        

        for (int i = 0; i < providerList.size(); i++) {
            Provider toFindProvider = providerList.get(i);
            //ArrayList<ServiceRecord> serviceReport = toFindProvider.getRecords();

            Report newProviderReport = new Report();
            newProviderReport.generateProviderReport(toFindProvider.getCreds());
            toFindProvider.records.clear();
        }
    } 

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
