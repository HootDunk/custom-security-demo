package example.micronaut.role_permissions;

import example.micronaut.role.Role;
import io.micronaut.data.annotation.Embeddable;

import javax.persistence.Column;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class RolePermissionId {
    @Column(name = "role_id")
    private final Role roleId;
    @Column(name = "permission_id")
    private final String permissionId;

    public RolePermissionId(Role roleId, String permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermissionId that = (RolePermissionId) o;
        return permissionId == that.permissionId && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, permissionId);
    }
}
