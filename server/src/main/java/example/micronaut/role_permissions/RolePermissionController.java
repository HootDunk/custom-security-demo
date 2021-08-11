package example.micronaut.role_permissions;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/role-permission")
public class RolePermissionController {

    private RolePermissionRepository rolePermissionRepository;

    public RolePermissionController(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Get
    HttpResponse<Iterable<RolePermission>> getAllRolePermissions() {
        return HttpResponse.ok(rolePermissionRepository.findAll());
    }
}
