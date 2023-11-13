public class Report {
    String receiverName;
    Long receiverNum;
    String receiverAdress;
    String receiverCity;
    String receiverState;
    int receiverZip;

    Report(){
    }

    public void generateProviderReport(long providerNum){
        //do stuff
    }

    public void generateMemberReport(long memberNum){
        //do stuff
    }

    public void sendReport(){
        if(receiverName == ""|| receiverNum == 0 || receiverAdress == "" || receiverCity == "" || receiverState == "" || receiverZip == 0){
            //Prompt that not all info filled out or not generated
            return;
        }
        //do whatever needed
    }

    public void printReport(){
        if(receiverName == ""|| receiverNum == 0 || receiverAdress == "" || receiverCity == "" || receiverState == "" || receiverZip == 0){
            //Prompt that not all info filled out or not generated
            return;
        }
        //do whatever needed
    }

}
