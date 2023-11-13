import java.util.ArrayList;

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
            if (toFindMember.getMemberNumber() =  /* was on a report this week */){
                Report newMemberReport = new Report();
                newMemberReport.generateMemberReport(toFindMember.getMemberNumber());
        

        for (int i = 0; i < providerList.size(); i++) {
            Provider toFindProvider = providerList.get(i);
            Report newProviderReport = new Report();
            newProviderReport.generateProviderReport(toFindProvider.getCreds());
        }
    } 

    /*  The problem is that this is sending every single member to have their report created

    */

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
