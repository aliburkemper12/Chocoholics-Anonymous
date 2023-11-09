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

        public String findMember(long memberNumber){
            for (int i = 0; i < memberList.size(); i++) {
                Member toFindMember = memberList.get(i);
                if (toFindMember = /* in the billing list */){
                    // generate member report
                }
            }
        }

        // request report is called and members and stuff are passed in
        Report newReport = new Report();
        newReport.generateProviderReport();
        newReport.generateMemberReport();
        //newReport.sendReport();
    }

    /*  pseudo code:
    get list of providers that billed for services that week
    check that they are valid
    run generate provider report
    
    same thing with member report
    */

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
