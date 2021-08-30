package example.micronaut.role;

import example.micronaut.permission.Permission;
import example.micronaut.permission.PermissionDTO;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Introspected
public class RoleDTO {
    @NotBlank
    @Column(name = "id")
    private UUID id;

    @NotBlank
    private String role;

    @NotBlank
    private String description;


    private Set<Permission> permission;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Permission> getPermission() {
        return permission;
    }

    public void setPermission(Set<Permission> permission) {
        this.permission = permission;
    }


}
