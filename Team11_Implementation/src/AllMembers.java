import java.util.ArrayList;

// Class containing a list of all members to be edited by operators
// @author Adison Viars

public class AllMembers {

    public AllMembers(){}

    //Creates a new list of members
    ArrayList<Member> memberList = new ArrayList<Member>(); 
    long memberNumber; // 9 digits
    String name; // 25 characters
    String status;
    String address; // 25 characters
    String city; // 14 characters
    String state; // 2 characters
    int zip; // 5 digits

    //Provider needs to verify that member is valid in order to provide
    //services and bill ChocAn
    public String verifyMember(long memberNumber) {
        for (int i = 0; i < memberList.size(); i++) {
            Member toVerify = memberList.get(i);
            if (toVerify.getMemberNumber() == memberNumber && toVerify.getStatus() == "Paid") {
                return "Validated";
            }
            else if (toVerify.getMemberNumber() == memberNumber) {
                return "Member suspended";
            }
        }
        return "Invalid number";
    }

    public Member getMember(long memberNumber) {
        for (int i = 0; i < memberList.size(); i++) {
            Member toGet = memberList.get(i);
            if (toGet.getMemberNumber() == memberNumber) {
                return toGet;
            }
        }
        return null;
    }

    //Operator chooses to add a member with specified
    //memberNumber and name
    public void addMember(long memberNumber, String name, String status, String address, String city, String state, int zip) {
        Member toAdd = new Member(name, memberNumber, status, address, city, zip, state);
        memberList.add(toAdd);
    }

    //Operator chooses to delete the member with input memberNumber
    public void deleteMember(long memberNumber) {
        for (int i = 0; i < memberList.size(); i++) {
            Member toDelete = memberList.get(i);
            if (toDelete.getMemberNumber() == memberNumber) {
                memberList.remove(i);
            }
        }
    }

    //Operator chooses to update the member with input memberNumber
    //Need options for update name, number, address, city, state, zip
    //NEED MORE INPUTS
    public void updateMember(long memberNumber, String name) {
        for (int i = 0; i < memberList.size(); i++) {
            Member toUpdate = memberList.get(i);
            if (toUpdate.getMemberNumber() == memberNumber) {
                memberList.set(i, /*whatever needs to be updated*/);
            }
        }
    }
}
