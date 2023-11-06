public class Service{
    private String name;
    private int code;
    private int fee;

    public Service(){}

    public Service(String name, int code, int fee){
        this.name = name;
        this.code = code;
        this.fee = fee;
    }

    public String getName(){
        return name;
    }
    public int getCode(){
        return code;
    }
    public int getFee(){
        return fee;
    }
    public String toString(){
        return name + " code: " + code + " fee: " + fee + "\n";
    }
}
