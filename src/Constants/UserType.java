package Constants;
public enum UserType {

    USER("user"),
    EDITOR("editor"),
    CHIEF_EDITOR("chiefeditor");

    UserType(String name){
        this.name = name;
    }
    private String name;
}
