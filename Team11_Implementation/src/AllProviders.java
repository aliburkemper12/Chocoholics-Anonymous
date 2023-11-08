import java.util.ArrayList;

//Class containing a list of all providers to be edited by operators
//@author Adison Viars

public class AllProviders {

    ArrayList<Provider> providerList = new ArrayList<Provider>();
    long credentials; // 9 digits
    String name; // 25 characters
    String address; // 25 characters
    String city; // 14 characters
    String state; // 2 characters
    int zip; // 5 digits

    public AllProviders(){}

    //Terminal verifies that provider credentials are valid
    //when they log in
    //GOOD
    public boolean verifyProvider(long credentials){
        for (int i = 0; i < providerList.size(); i++) {
            Provider toVerify = providerList.get(i);
            if (toVerify.getCreds() == credentials) {
                return true;
            }
        }
        return false;
    }

    //Operator chooses to add a provider with specified
    //credentials and name
    //NEED MORE INPUTS
    public void addProvider(long credentials, String name, String address, String city, String state, int zip) {
        Provider toAdd = new Provider(name, credentials);
        providerList.add(toAdd);
    }

    //Operator chooses to delete the provider with input credentials
    //GOOD
    public void deleteProvider(long credentials) {
        for (int i = 0; i < providerList.size(); i++) {
            Provider toDelete = providerList.get(i);
            if (toDelete.getCreds() == credentials) {
                providerList.remove(i);
            }
        }
    }

    //Operator chooses to update the provider with input credentials
    //might need setter function to be able to change name, address, etc.
    //NEED MORE INPUTS
    public void updateProvider(long credentials, String name) {
        for (int i = 0; i < providerList.size(); i++) {
            Provider toUpdate = providerList.get(i);
            if (toUpdate.getCreds() == credentials) {
                providerList.set(i, /*whatever needs to be updated*/);
            }
        }
    }
}

