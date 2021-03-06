package example.micronaut.security;

import example.micronaut.permission.Permission;
import example.micronaut.permission.PermissionDTO;
import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;
import java.util.List;


public class ExtendedUserDetails extends UserDetails {

    private Collection<String> permissions;

    public ExtendedUserDetails(String username, Collection<String> roles) {
        super(username, roles);
    }

    public ExtendedUserDetails(String username, Collection<String> roles, Collection<String> permissions) {
        super(username, roles);
        this.permissions = permissions;
    }


    public Collection<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<String> permissions) {
        this.permissions = permissions;
    }
}
