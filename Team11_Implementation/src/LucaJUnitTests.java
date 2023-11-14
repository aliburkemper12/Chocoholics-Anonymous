import static org.junit.Assert.*;

import org.junit.After;
import  org.junit.Before;
import org.junit.Test;
import.java.util.ArrayList;

//Class for testing
//Method testProviderGetName() and testProviderDirectoryRequestServices() are from my classes
//Method testOperatorGetName is from Adison's class
//@author Luca Jontz

public class RyanJUnitTests {
    
    @Before
    public void setUp(){
        //Setup for all
        Provider testProv = new Provider("prov1", 123456789, "4405 ridge ave", "Tuscaloosa", "Alabama", 20198);
        Service testService = new Service("service1", 123456, 50);
        testProv.addService(testService);
        ProviderDirectory testDirectory = new ProviderDirectory(testProv);
        ArrayList<Service> services;
        services.add(testService);
        Operator testOperator = new Operator(123456789, "operator1");
    }

    //Test the getName function in Provider class;
    @Test
    public void testProviderGetName(){
        if(!testProv.getName().equals("prov1")){
            fail("Provider name wrong");
        }
    }
    
    //Test the requestServices function in ProviderDirectory class;
    @Test
    public void testProviderDirectoryRequestServices(){
        if(!testDirectory.requestServices().equals(services)){
            fail("Services ArrayList wrong");
        }
    }

    //Test the getName function in Operator class;
    @Test
    public void testOperatorGetName(){
        if(!testOperator.getName().equals("operator1")){
            fail("Operator name wrong");
        }
    }

    @After
    public void notNeeded(){}
}
