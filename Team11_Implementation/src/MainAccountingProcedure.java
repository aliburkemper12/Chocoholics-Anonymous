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

        public void findMember(long memberNumber){
            for (int i = 0; i < memberList.size(); i++) {
                Member toFindMember = memberList.get(i);
                if (toFindMember = /* in the billing list */){
                    Report newMemberReport = new Report();
                    newMemberReport.generateMemberReport(memberNumber);
                }
            }
        }

        // request report is called and members and stuff are passed in
  
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
