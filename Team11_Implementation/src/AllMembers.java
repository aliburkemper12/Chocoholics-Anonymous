import java.util.ArrayList;

// Class containing a list of all members to be edited by operators
// @author Adison Viars

public class AllMembers {

    public AllMembers(){}

    //Creates a new list of members
    ArrayList<Member> memberList = new ArrayList<Member>(); 
    int memberNumber;
    String name;

    //Provider needs to verify that member is valid in order to provide
    //services and bill ChocAn
    public boolean verifyMember(int memberNumber){
        for (int i = 0; i < memberList.size(); i++) {
            Member toVerify = memberList.get(i);
            //need to use getMemberNumber() from Member class
            if (toVerify.getMemberNumber() == memberNumber) {
                return true;
            }
        }
        return false;
    }

    //Operator chooses to add a member with specified
    //memberNumber and name
    public void addMember(int memberNumber, String name) {
        Member toAdd = new Member(name, memberNumber);
        memberList.add(toAdd);
    }

    //Operator chooses to delete the member with input memberNumber
    public void deleteMember(int memberNumber) {
        for (int i = 0; i < memberList.size(); i++) {
            Member toDelete = memberList.get(i);
            //need to use getMemberNumber() from Member class
            if (toDelete.getMemberNumber() == memberNumber) {
                memberList.remove(i);
            }
        }
    }

    //Operator chooses to update the member with input memberNumber
    //Need options for update name, number, address, city, state, zip
    public void updateMember(int memberNumber, String name) {
        for (int i = 0; i < memberList.size(); i++) {
            Member toUpdate = memberList.get(i);
            //need to use getMemberNumber() from Member class
            if (toUpdate.getMemberNumber() == memberNumber) {
                memberList.set(i, /*whatever needs to be updated*/);
            }
        }
    }
}
