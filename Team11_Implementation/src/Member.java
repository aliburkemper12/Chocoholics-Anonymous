import java.util.List;


// Class containing information for members.

// @author Ali Burkemper

// name number address city zipcode
// pulling from array in all members, see provider
// store data here
public class Member {

    private String name;
    private int memberNumber;
    private String status;
    private String address;
    private String city;
    private int zipcode;
    private 

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zipcode;
    }

    public void setZip(int zipcode) {
        this.zipcode = zipcode;
    }
}
