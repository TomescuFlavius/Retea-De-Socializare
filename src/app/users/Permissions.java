package app.users;

public enum Permissions {
    //USER MANAGEMENT
    USER_CREATE("user:create"),
    USER_DELETE("user:delete"),
    USER_UPDATE("user:update"),
    USER_READ("user:read");


    private final String value;
    Permissions(String value){
        this.value=value;
    }
}
