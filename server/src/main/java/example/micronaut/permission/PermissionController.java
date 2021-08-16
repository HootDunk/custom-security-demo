package example.micronaut.permission;

import example.micronaut.security.RequiredPermission;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;
import java.util.UUID;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/permissions")
public class PermissionController {

    private final PermissionRepository permissionRepository;

    public PermissionController(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Get
    public HttpResponse<List<Permission>> getAll(){
        return HttpResponse.ok(permissionRepository.findAll());
    }

    @Get("/user/{id}")
    public HttpResponse<List<Permission>> findUserPermissions(UUID id) {
        return HttpResponse.ok(permissionRepository.findUserPermissions(id));
    }
}
