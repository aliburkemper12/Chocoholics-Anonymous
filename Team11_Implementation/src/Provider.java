import java.util.arrayList;
public class Provider{
    private String name;
    private int credentials;
    private arrayList<Service> services;
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
    public arrayList<Service> getServices(){
        return services;
    }
}