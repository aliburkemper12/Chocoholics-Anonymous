import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.time.ZonedDateTime;

//@author Jack Sherry

public class MainAccountingProcedure {
    
    AllMembers members;
    AllProviders providers;
    ManagerReport managerReport;

    MainAccountingProcedure(AllMembers members, AllProviders providers, ManagerReport managerReport){
        this.members = members;
        this.providers = providers;
        this.managerReport = managerReport;
    }

    public void runMainAccountingProcedure(){

        ArrayList<Member> memberList = members.memberList;
        ArrayList<Provider> providerList = providers.providerList;

        managerReport.createReport();

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
                    MemberReport newMemberReport = new MemberReport();
                    newMemberReport.generateReport(toFindMember, providers);
                    toFindMember.serviceReports.clear();
                //}
            //}
        }
        

        for (int i = 0; i < providerList.size(); i++) {
            Provider toFindProvider = providerList.get(i);

            ProviderDirectory pDir = new ProviderDirectory(toFindProvider);
            pDir.requestDirectory();
            //ArrayList<ServiceRecord> serviceReport = toFindProvider.getRecords();

            ProviderReport newProviderReport = new ProviderReport(members, toFindProvider);
            toFindProvider.setReport(newProviderReport);
            newProviderReport.writeReport();
            toFindProvider.records.clear();
        }
    } 

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
