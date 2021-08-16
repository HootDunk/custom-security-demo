package example.micronaut.role_permissions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import example.micronaut.role.Role;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.jdbc.annotation.JoinColumn;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@MappedEntity(value = "role_permissions", alias = "role_permissions")
@Table(name = "role_permissions")
public class RolePermission {

    @Column(name = "id")
    @EmbeddedId
    private RolePermissionId rolePermissionId;

    @ManyToOne
    private Role roleId;

    @Column(name = "permission_id")
    private String permissionId;

    public RolePermission(RolePermissionId rolePermissionId, Role roleId, String permissionId) {
        this.rolePermissionId = rolePermissionId;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public RolePermissionId getRolePermissionId() {
        return rolePermissionId;
    }

    public Role getRoleId() {
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


// https://stackoverflow.com/questions/31600142/how-to-define-onetomany-in-parent-entity-when-child-has-composite-pk?rq=1
// https://stackoverflow.com/questions/11938253/jpa-joincolumn-vs-mappedby


// seems to be the best resource
// https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/