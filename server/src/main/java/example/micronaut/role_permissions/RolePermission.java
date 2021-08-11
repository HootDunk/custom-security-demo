package example.micronaut.role_permissions;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "role_permissions")
public class RolePermission {

    @EmbeddedId
    private RolePermissionId rolePermissionId;

    private UUID roleId;

    private String permissionId;

    public RolePermission(RolePermissionId rolePermissionId, UUID roleId, String permissionId) {
        this.rolePermissionId = rolePermissionId;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public RolePermissionId getRolePermissionId() {
        return rolePermissionId;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }
}



// In OO, the Role owns the RolePermissions (each role has a list of role permissions).
// In SQL, the RolePermission owns (literally contains)s the connection (info/fk).
// So in sql the RolePermission owns the Role.

// many side is the owner the one side is the inverse.