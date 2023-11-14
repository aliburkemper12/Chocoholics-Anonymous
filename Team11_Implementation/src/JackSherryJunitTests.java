import org.junit.Assert.*;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array; 
import org.junit.Before;
import org.junit.Test;

public class JackSherryJunitTests {

    AllMembers members;
    AllProviders providers;

    @Before
    public void setUp(AllMembers members, AllProviders providers) {
        this.members = members;
        this.providers = providers;
    }

    @Test
    public void clearTest1() {
        ArrayList<Member> memberList = members.memberList;
        memberList.clear();
        assertTrue(memberList.isEmpty());
    }

    @Test
    public void clearTest2() {
        ArrayList<Provider> providerList = providers.providerList;
        providerList.clear();
        assertTrue(providerList.isEmpty());
    }

}
