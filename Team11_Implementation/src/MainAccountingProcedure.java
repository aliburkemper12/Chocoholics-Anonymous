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

        managerReport.createReport();   //the only thing we need to do for the manager portion

        for (int i = 0; i < memberList.size(); i++) {
            Member toFindMember = memberList.get(i);   //create an instance of a single member in the list
            MemberReport newMemberReport = new MemberReport();
            newMemberReport.generateReport(toFindMember, providers);   //generate a new report with the member we need and the list of providers
            toFindMember.serviceReports.clear();   //clear the report so we don't generate the same report multiple times
        }
        

        for (int i = 0; i < providerList.size(); i++) {
            Provider toFindProvider = providerList.get(i);   //create an instance of a single provider in the list
            ProviderDirectory pDir = new ProviderDirectory(toFindProvider);   //create an object to request the provider directory
            pDir.requestDirectory();
            ProviderReport newProviderReport = new ProviderReport(members, toFindProvider);
            toFindProvider.setReport(newProviderReport);   //generate a new report with the provider we need and the list of members
            newProviderReport.writeReport();
            toFindProvider.records.clear();   //clear the report so we don't generate the same report multiple times
        }
    } 
}
