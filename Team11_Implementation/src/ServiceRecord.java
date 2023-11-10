import java.util.ArrayList;
import java.util.List;

// @author Jack Sherry

public class ServiceRecord {

    public ArrayList<ServiceRecord> serviceRecordList = new ArrayList<ServiceRecord>();
    private String date = "";
    private String dateService = "";
    private long providerNum = 0;
    private long memberNum = 0;
    private int serviceCode = 0;
    private String comment = "";

    public ServiceRecord(String date, String dateService, long providerNum, long memberNum, int serviceCode, String comment){
        this.date = date;
        this.dateService = dateService;
        this.providerNum = providerNum;
        this.memberNum = memberNum;
        this.serviceCode = serviceCode;
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateService(String dateService) {
        this.dateService = dateService;
    }

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

    public String getDateService() {
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
}