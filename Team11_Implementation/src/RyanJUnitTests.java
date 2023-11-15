import static org.junit.Assert.*;

import org.junit.After;
import  org.junit.Before;
import org.junit.Test;

// RyanJUnitTests is just the class for running the testing.
// Methods testManagerTerminalVerify and testProviderTerminalAddService use
// methods made in MY classes. Other method is testing someone elses class.

// @author Ryan Kutella

public class RyanJUnitTests {
    
    ManagerTerminal mT;
    ProviderTerminal pT;
    OperatorTerminal oT;

    Member memToTest;
    Provider provToTest;

    @Before
    public void setUp(){
        //Setup for both
        AllProviders providers = new AllProviders();
        AllMembers members = new AllMembers();

        //setup for testManagerTerminalVerify
        AllManagers managers = new AllManagers();
        managers.addManager(1, "Manager One");
        mT = new ManagerTerminal(providers, new AllMembers(), managers, new ManagerReport(providers));

        //setup for testProviderTerminalAddService
        pT = new ProviderTerminal(providers, members);
        members.addMember(2, "Fake Girl", "Unpaid", "11 Road", "Birmingham", "Alabama", 0);
        providers.addProvider(2, "Fake Prov", "10 Road", "Tuscaloosa", "Alabama", 0);
        memToTest = members.getMember(2);
        provToTest = providers.getProvider(2);

        //setup for idk
        AllOperators operators = new AllOperators();
        oT = new OperatorTerminal(providers, members, operators);

    }

    //Test the verify function in ManagerTerminal class;
    @Test
    public void testManagerTerminalVerify(){
        if(mT.managerVerified!=false){
            fail("Manager terminal verify should be false by default");
        }
        mT.verify("1");
        if(mT.managerVerified!=true){
            fail("Manager terminal verify should have been true after inputting valid manager");
        }
    }
    
    //Test the addService function in ProviderTerminal class;
    @Test
    public void testProviderTerminalAddService(){
        int memberServicesBefore = memToTest.serviceReports.size();
        int providerServicesBefore = provToTest.getRecords().size();

        pT.addServiceReports(provToTest, memToTest, "12-12-2000", 1, "No Comments", 20, "Blank");

        int memberServicesAfter = memToTest.serviceReports.size();
        int providerServicesAfter = provToTest.getRecords().size();
        
        if(memberServicesBefore+1!=memberServicesAfter){
            fail("Did not add one service");
        }   
        if(providerServicesBefore+1!=providerServicesAfter){
            fail("Did not add one service");
        }

        ServiceRecord mRecord = memToTest.serviceReports.get(memberServicesAfter-1);
        if(mRecord.getServiceFee()!=20){
            fail("Service fee wrong");
        }
        if(mRecord.getServiceCode()!=1){
            fail("Service code wrong");
        }
        if(!mRecord.getDate().equals("12-12-2000")){
            fail("Service date wrong");
        }
        if(!mRecord.getComment().equals("No Comments")){
            fail("Service comment wrong");
        }

        ServiceRecord pRecord = provToTest.getRecords().get(memberServicesAfter-1);
        if(pRecord.getServiceFee()!=20){
            fail("Service fee wrong");
        }
        if(pRecord.getServiceCode()!=1){
            fail("Service code wrong");
        }
        if(!pRecord.getDate().equals("12-12-2000")){
            fail("Service date wrong");
        }
        if(!pRecord.getComment().equals("No Comments")){
            fail("Service comment wrong");
        }
    }

    //Test idk function in Jack B's Operator Terminal Class
    @Test
    public void idk(){
        
    }

    @After
    public void notNeeded(){}
}
