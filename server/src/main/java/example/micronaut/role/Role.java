package example.micronaut.role;

import example.micronaut.role_permissions.RolePermission;
import io.micronaut.data.annotation.*;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.jdbc.annotation.JoinColumn;
import io.micronaut.data.jdbc.annotation.JoinColumns;
import io.micronaut.data.model.DataType;

//import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;


@MappedEntity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name="id")
    @AutoPopulated
    @TypeDef(type= DataType.STRING)
    private UUID id;

    @NotBlank
    @Column(name = "role")
    private String role;

    @NotBlank
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    @JoinColumn(name="role_id")
    List<RolePermission> permissions;


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

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }
}
