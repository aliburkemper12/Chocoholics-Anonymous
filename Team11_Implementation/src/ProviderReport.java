import java.util.ArrayList;

public class ProviderReport {
    ArrayList<DiskRecord> records;
    int weekFee;
    String memberName;

    ProviderReport(){
    }

    public void addRecord(DiskRecord record){
        records.add(record);
    }

    public String writeReport(){
        String currDate;
        String serviceDate;
        
        
        for(DiskRecord record : records){

        }
    }
}
