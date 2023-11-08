import java.util.List;


// Class containing information for members.

// @author Ali Burkemper


public class Member {

    private String name;
    private int memberNumber;
    private String status;

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
    public Member getNumber(String name) {
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
