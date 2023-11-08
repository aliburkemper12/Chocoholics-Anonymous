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

        //getmemberlist

        ArrayList<Member> memberList = members.memberList;
        ArrayList<Provider> providerList = providers.providerList;

        public boolean findMember(int memberNumber){
            for (int i = 0; i < members.size(); i++) {
                Member toFindMember = memberList.get(i);
            }
        }

        // request report is called and members and stuff are passed in
        Report newReport = new Report();
        newReport.generateProviderReport();
        newReport.generateMemberReport();
        newReport.sendReport();
    }

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
