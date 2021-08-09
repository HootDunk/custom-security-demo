package example.micronaut.security;

import example.micronaut.permission.Permission;
import example.micronaut.permission.PermissionDTO;
import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;
import java.util.List;


public class ExtendedUserDetails extends UserDetails {

    private List<PermissionDTO> permissions;

    public ExtendedUserDetails(String username, Collection<String> roles) {
        super(username, roles);
    }

    public ExtendedUserDetails(String username, Collection<String> roles, List<PermissionDTO> permissions) {
        super(username, roles);
        this.permissions = permissions;
    }


    public List<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
