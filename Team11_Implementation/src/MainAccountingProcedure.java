//@author Jack Sherry

public class MainAccountingProcedure {
    
    public void runMainAccountingProcedure(){
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
