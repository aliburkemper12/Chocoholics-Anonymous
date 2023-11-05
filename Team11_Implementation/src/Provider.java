import java.util.ArrayList;
public class Provider{
    private String name;
    private int credentials;
    private ArrayList<Service> services;
    
    Provider(String name, int credentials){
        this.name = name;
        this.credentials = credentials;
    }

    public void addService(Service newService){
        services.add(newService);
    }
    public String getName(){
        return name;
    }
    public int getCreds(){
        return credentials;
    }
    public ArrayList<Service> getServices(){
        return services;
    }
}