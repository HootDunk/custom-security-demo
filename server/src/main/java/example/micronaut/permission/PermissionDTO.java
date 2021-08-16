package example.micronaut.permission;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Introspected
public class PermissionDTO {
    @NotBlank
    private UUID role_id;
    @NotBlank
    private String permission_id;

    public UUID getId() {
        return role_id;
    }

    public void setId(UUID id) {
        this.role_id = id;
    }

    public String getPermission() {
        return permission_id;
    }

    public void setPermission(String permission) {
        this.permission_id = permission;
    }

    @Override
    public String toString() {
        return "PermissionDTO{" +
                "role_id=" + role_id +
                ", permission_id='" + permission_id + '\'' +
                '}';
    }
}
