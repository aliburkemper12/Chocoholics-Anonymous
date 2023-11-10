import java.util.ArrayList;
public class Provider{
    private String name;
    private long credentials;
    private ArrayList<Service> services;
    private ArrayList<DiskRecord> records;
    
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
    public long getCreds(){
        return credentials;
    }
    public ArrayList<Service> getServices(){
        return services;
    }
    public void addRecord(DiskRecord record){
        records.add(record);
    }
    public ArrayList<DiskRecord> getRecords(){
        return records;
    }
}