
public class ProviderReport {
    ProviderReport(String timeReceived, String memberName, int memberNum, int serviceCode, int fee, int consultationsNum){
        this.timeReceived = timeReceived;
        this.memberName = memberName;
        this.serviceCode = serviceCode;
        this.fee = fee;
        this.consultationsNum = consultationsNum;
        this.weekFee = fee;
    }
    
    String timeReceived;
    String memberName;
    int memberNum;
    int serviceCode;
    int fee;
    int consultationsNum;
    int weekFee;
}
