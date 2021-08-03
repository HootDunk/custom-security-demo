package example.micronaut.role;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Get
    public HttpResponse<List<Role>> getAll(){
        return HttpResponse.ok(roleRepository.findAll());
    }
}
