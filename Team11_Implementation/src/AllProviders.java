import java.util.ArrayList;

//Class containing a list of all providers to be edited by operators
//@author Adison Viars

public class AllProviders {

    ArrayList<Provider> providerList = new ArrayList<Provider>();
    int credentials;
    String name;

    public AllProviders(){}

    //Terminal verifies that provider credentials are valid
    //when they log in
    public boolean verifyProvider(int credentials){
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
    public void addProvider(int credentials, String name) {
        Provider toAdd = new Provider(name, credentials);
        providerList.add(toAdd);
    }

    //Operator chooses to delete the provider with input credentials
    public void deleteProvider(int credentials) {
        for (int i = 0; i < providerList.size(); i++) {
            Provider toDelete = providerList.get(i);
            if (toDelete.getCreds() == credentials) {
                providerList.remove(i);
            }
        }
    }

    //Operator chooses to update the provider with input credentials
    //might need setter function to be able to change name, address, etc.
    public void updateProvider(int credentials, String name) {
        for (int i = 0; i < providerList.size(); i++) {
            Provider toUpdate = providerList.get(i);
            if (toUpdate.getCreds() == credentials) {
                providerList.set(i, /*whatever needs to be updated*/);
            }
        }
    }
}

