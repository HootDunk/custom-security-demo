package example.micronaut.role;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Column;

@Introspected
public class Permission {

    private String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
