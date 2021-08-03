package example.micronaut.member_profile;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller("/member-profile")
public class MemberProfileContoller {

    private final MemberProfileRepository memberProfileRepository;

    public MemberProfileContoller(MemberProfileRepository memberProfileRepository) {
        this.memberProfileRepository = memberProfileRepository;
    }

    @Get
    public HttpResponse<List<MemberProfile>> getAll() {
        return HttpResponse.ok(memberProfileRepository.findAll());
    }

    @Get("/{id}")
    public HttpResponse<MemberProfile> getOne(@PathVariable UUID id) {
        return HttpResponse.ok(memberProfileRepository.findById(id).orElse(null));
    }
}
