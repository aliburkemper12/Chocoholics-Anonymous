import java.util.List;


// Class containing information for members.

// @author Ali Burkemper

// name number address city zipcode
// pulling from array in all members, see provider
public class Member {

    private String name;
    private int memberNumber;
<<<<<<< HEAD
=======
    private String status;
>>>>>>> 56beeb5a2091a17a99a6f0c66810ae778ccfb7db

    //Could do this for constructor - Adison
    /*
     * public Member(String name, int memberNumber) {
     *   this.name = name;
     *   this.memberNumber = memberNumber;
     * }
     * 
     * public int getMemberNumber() {
     *   return memberNumber;
     * }
     */

    // returns member ID number from database by searching for 
    // name [CSV files?] 
    public Member getMemberNumber(String name) {
        List<Member> members = getMemberInfo();
        for (Member member : members) {
            if(member.getName().equals(name))
                return member;
        }
        return null;
    }
    
    // returns list of members and their info after searching database
    public List<Member> getMemberInfo() {
        // Do stuff
        return null;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
