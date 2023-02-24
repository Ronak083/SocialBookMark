package Constants;

public enum Gender {
    MALE(0),
    FEMALE(1),
    TRANSGENDER(2);

    private Gender(int s) {
        this.value = s;
    }
    private int value;
    public int getValue(){
        return value;
    }
}
