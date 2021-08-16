package example.micronaut.role_permissions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.data.annotation.MappedEntity;

import javax.persistence.*;
import java.util.UUID;

@MappedEntity
@Table(name = "role_permissions")
public class RolePermission {

    @EmbeddedId
    private RolePermissionId rolePermissionId;

    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "permission_id")
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
// In SQL, the RolePermission owns (literally contains) the connection (info/fk).
// So in sql the RolePermission owns the Role.

// many side is the owner the one side is the inverse.



// https://stackoverflow.com/questions/11938253/jpa-joincolumn-vs-mappedby

// https://stackoverflow.com/questions/47657075/jpa-unidirectional-one-to-many-relationship-with-composite-semi-shared-primary