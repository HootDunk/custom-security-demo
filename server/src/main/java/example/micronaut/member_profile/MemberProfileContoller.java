package example.micronaut.member_profile;

import example.micronaut.permission.Permission;
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
@Controller("/member-profile")
public class MemberProfileContoller {

    private final MemberProfileRepository memberProfileRepository;

    public MemberProfileContoller(MemberProfileRepository memberProfileRepository) {
        this.memberProfileRepository = memberProfileRepository;
    }

    @RequiredPermission(permission = "Can View Organization Members")
    @Get
    public HttpResponse<List<MemberProfile>> getAll() {
        return HttpResponse.ok(memberProfileRepository.findAll());
    }

    @Get("/{id}")
    public HttpResponse<MemberProfile> getOne(@PathVariable UUID id) {
        return HttpResponse.ok(memberProfileRepository.findById(id).orElse(null));
    }



//    @Get("/permissions/{id}")
//    public HttpResponse<List<Permission>> findUserPermissions(@PathVariable UUID id) {
//        return HttpResponse.ok(memberProfileRepository.findUserPermissions(id).orElse(null));
//    }
}
