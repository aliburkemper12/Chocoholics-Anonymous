import java.util.ArrayList;

//@author Luca Jontz

public class Provider{

    private String name;
    private long credentials;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private ArrayList<Service> services = new ArrayList<Service>();
    public ArrayList<ServiceRecord> records = new ArrayList<ServiceRecord>();
    public ProviderReport report;
    
    Provider(String name, long credentials, String address, String city, String state, int zipcode){
        this.name = name;
        this.credentials = credentials;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        Service temp1 = new Service("Session with Dietitian", 598470, 50);
        Service temp2 = new Service("Aerobics Exercise Session", 883948, 150);
        services.add(temp1);
        services.add(temp2);
    }

    public void addService(Service newService){
        services.add(newService);
    }

    public void setReport(ProviderReport newReport){
        report = newReport;
    }

    public ProviderReport getReport(){
        return report;
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
    public void addRecord(ServiceRecord record){
        records.add(record);
    }
    public ArrayList<ServiceRecord> getRecords(){
        return records;
    }
    public void clearReports(ArrayList<ServiceRecord> serviceReports) {
        serviceReports.clear();
    }
}