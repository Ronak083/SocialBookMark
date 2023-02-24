package Constants;

public enum KidFriendlyStatus {
    APPROVED("approved"),
    REJECTED("rejected"),
    UNKNOWN("unknown");

    KidFriendlyStatus(String name){
        this.name = name;
    }
    private String name;
    public String getName(){
        return name;
    }
}
