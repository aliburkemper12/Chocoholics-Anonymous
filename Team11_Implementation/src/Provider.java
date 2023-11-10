import java.util.ArrayList;

//@author Luca Jontz

public class Provider{

    private String name;
    private long credentials;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private ArrayList<Service> services;
    private ArrayList<DiskRecord> records;
    
    Provider(String name, long credentials, String address, String city, String state, int zipcode){
        this.name = name;
        this.credentials = credentials;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
    }

    public void addService(Service newService){
        services.add(newService);
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreds(){
        return credentials;
    }

    public void setCreds(long credentials) {
        this.credentials = credentials;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zipcode;
    }

    public void setZip(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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