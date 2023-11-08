public class DiskRecord{
    String currDate;
    String serviceDate;
    Long providerNum;
    Long memberNum;
    int serviceCode;
    String comments;

    DiskRecord(String currDate, String serviceDate, Long providerNum, Long memberNum, int serviceCode, String comments){
        this.currDate = currDate;
        this.serviceDate = serviceDate;
        this.providerNum = providerNum;
        this.serviceCode = serviceCode;
        this.comments = comments;
    }

    public String getCurrDate(){
        return currDate;
    }

    public String getServiceDate(){
        return serviceDate;
    }

    public Long getMemberNum(){
        return memberNum;
    }

    public int getServiceCode()
}