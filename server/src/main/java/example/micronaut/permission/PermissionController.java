package example.micronaut.permission;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

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
