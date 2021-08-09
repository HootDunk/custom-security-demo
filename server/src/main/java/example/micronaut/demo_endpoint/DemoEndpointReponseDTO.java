package example.micronaut.demo_endpoint;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class DemoEndpointReponseDTO {
    private String permission;

    public DemoEndpointReponseDTO(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
