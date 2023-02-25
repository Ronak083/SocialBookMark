package Constants;
public enum userType {

    USER( "user"),
    EDITOR( "editor"),
    CHIEF_EDITOR( "chiefeditor");

    userType(String name){
        this.name = name;
    }
    private String name;
    public String getName(){
        return name;
    }

}
