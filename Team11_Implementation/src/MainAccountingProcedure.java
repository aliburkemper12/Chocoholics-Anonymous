//@author Jack Sherry

public class MainAccountingProcedure {
    
    // prompt the creation of a new report when prompted by timer (runMainAccountingProcedure) or prompted from manager terminal

    public void runMainAccountingProcedure(){
        // request report is called and members and stuff are passed in
        Report newReport = new Report();
        newReport.generateReport();
        newReport.sendReport();
    }

    public void summaryReport(){

    }

    public void EFTReport(){

    }


}
