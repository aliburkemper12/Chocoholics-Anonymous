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
    }

    /*  pseudo code:
    search through the services and check for the ones from that week
    make a list of the service codes from that week
    */

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
