import static org.junit.Assert.*;

import org.junit.After;
import  org.junit.Before;
import org.junit.Test;

//@author Jack Bentley

public class JackBentleyJUnitTests {
    OperatorTerminal oT;

    AllMembers testMember;
    AllProviders testProvider;

    @Before
    public void setUp(){
        //Setup for both
        AllMembers members = new AllMembers();
        AllOperators operators = new AllOperators();

        //setup for testOperatorTerminalVerify
        AllProviders provider = new AllProviders();
        provider.addProvider(1, "Provider One", "stuff", "stuff", "stuff", 12345);
        oT = new OperatorTerminal(provider, members, operators);

        //setup for testAddMember
        
    }

    @Test
    public void testOperatorTerminalVerify(){
        if(oT.operatorVerified!=false){
            fail("Operator terminal verify should be false by default");
        }
        oT.verify("1");
        if(oT.operatorVerified!=true){
            fail("Operator terminal verify should have been true");
        }
    }
    @Test
    public void testAddMember(){
        int totalMembersBefore = testMember.memberList.size();

        testMember.addMember(123456789, "stuff", "stuff", "stuff", "stuff", "stuff", 123456);
        int totalMembersAfter = testMember.memberList.size();

        if(totalMembersAfter + 1 != totalMembersBefore){
            fail("Did not add one member");
        }

        
    }
}
