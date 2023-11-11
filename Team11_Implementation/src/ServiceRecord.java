import java.time.LocalDate;
import java.time.ZoneId;

// @author Jack Sherry

public class ServiceRecord {

    //public ArrayList<ServiceRecord> serviceRecordList = new ArrayList<ServiceRecord>();
    private String date = "";
    private LocalDate dateService;
    private long providerNum = 0;
    private long memberNum = 0;
    private int serviceCode = 0;
    private String comment = "";
    private int serviceFee = 0;

    public ServiceRecord(String date, long providerNum, long memberNum, int serviceCode, String comment, int serviceFee){
        this.date = date;
        ZoneId z = ZoneId.of( "America/Chicago" ); //just sets zone
        LocalDate today = LocalDate.now(z); //current date
        this.dateService = today;
        this.providerNum = providerNum;
        this.memberNum = memberNum;
        this.serviceCode = serviceCode;
        this.comment = comment;
        this.serviceFee = serviceFee;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // public void setDateService(Loc dateService) {
    //     this.dateService = dateService;
    // }

    public void setMemberNum(long memberNum) {
        this.memberNum = memberNum;
    }

    public void setProviderNum(long providerNum) {
        this.providerNum = providerNum;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public LocalDate getDateService() {
        return dateService;
    }

    public long getProviderNum() {
        return providerNum;
    }

    public long getMemberNum() {
        return memberNum;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public String getComment() {
        return comment;
    }

    public int getServiceFee(){
        return serviceFee;
    }
}