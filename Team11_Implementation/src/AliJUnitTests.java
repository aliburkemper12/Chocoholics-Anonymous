// @author Ali Burkemper
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

// Class to run testing.
// Testing methods getMemberNumber() and runMainAccountingProcedure() from MY classes.
// Testing getServiceCode() from ServiceRecord.java class.

public class AliJUnitTests {
    
    long memTestNum;
    Member memToTest;
    ProviderTerminal pT;
    ArrayList<ServiceRecord> rT;

    @Before
    public void setUp(){
        // Setup for getMemberNumber()
        AllMembers members = new AllMembers();
        AllProviders providers = new AllProviders();
        pT = new ProviderTerminal(providers, members);

        members.addMember(2, "Fake Girl", "Unpaid", "1 ABC street", "St. Louis", "Missouri", 1);
        providers.addProvider(1, "Bob", "1", "NYC", "NY", 0);
        memToTest = members.getMember(2);
        pT.addServiceReports(providers.getProvider(1), members.getMember(2), "01-01-2023", 883948, "null", 150, "Swimming");
        rT = memToTest.getService();
    }

    @Test
    public void testMemberNumber(){
        if(memToTest.getMemberNumber() != 2){
            fail("Not the right member number");
        }
    }

    @Test
    public void testMainAccountingProcedure(){
        
    }

    @Test
    public void testGetServiceCode(){
        if(rT.get(0).getServiceCode() != 883948) {
            fail("Not the right service code");
        }
    }

    @After
    public void notNeeded(){}
}
