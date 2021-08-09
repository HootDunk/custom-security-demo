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
    private UUID id;
    @NotBlank
    private String permission;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "PermissionDTO{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
