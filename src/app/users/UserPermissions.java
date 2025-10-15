package app.users;

import java.util.List;

public interface UserPermissions {
    List<Permissions> getPermissions();
    void addPermission(Permissions permissions);
    void erasePermission(Permissions permissions);
}
