public class Report {
    String receiverName;
    int receiverNum;
    String receiverAdress;
    String receiverCity;
    String receiverState;
    int receiverZip;
    String serviceDate;

    Report(){
        receiverName = "";
        receiverNum = 0;
        receiverAdress = "";
        receiverCity = "";
        receiverState = "";
        receiverZip = 0;
        serviceDate = "";
    }

    public void generateProviderReport(){
        //do stuff
    }

    public void generateMemberReport(){
        //do stuff
    }

    public void sendReport(){
        if(receiverName == ""|| receiverNum == 0 || receiverAdress == "" || receiverCity == "" || receiverState == "" || receiverZip == 0 || serviceDate == ""){
            //Prompt that not all info filled out or not generated
            return;
        }
        //do whatever needed
    }

    public void printReport(){
        if(receiverName == ""|| receiverNum == 0 || receiverAdress == "" || receiverCity == "" || receiverState == "" || receiverZip == 0 || serviceDate == ""){
            //Prompt that not all info filled out or not generated
            return;
        }
        //do whatever needed
    }

}
