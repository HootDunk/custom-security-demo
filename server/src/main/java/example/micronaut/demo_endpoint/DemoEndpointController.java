package example.micronaut.demo_endpoint;

import example.micronaut.security.RequiredPermission;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;


@Controller("/example")
public class DemoEndpointController {

    // Can View Organization Members
    @RequiredPermission(permission = "Can View Organization Members")
    @Get("/view-members")
    public HttpResponse<DemoEndpointReponseDTO> viewMembers() {
        return HttpResponse.ok(new DemoEndpointReponseDTO("Current User Can view organization members"));
    }

    // Can Create/Delete Organization Members
    @RequiredPermission(permission = "Can Create/Delete Organization Members")
    @Get("/edit-members")
    public HttpResponse<DemoEndpointReponseDTO> editOrganizationMembers() {
        return HttpResponse.ok(new DemoEndpointReponseDTO("Current User Can Create/Delete Organization Members"));
    }

    // Can Edit Team Membership
    @RequiredPermission(permission = "Can Edit Team Membership")
    @Get("/edit-team-membership")
    public HttpResponse<DemoEndpointReponseDTO> editTeamMembership() {
        return HttpResponse.ok(new DemoEndpointReponseDTO("Current User Can Edit Team Membership"));
    }

    // Can View PDL Data
    @RequiredPermission(permission = "Can View PDL Data")
    @Get("/view-pdl-data")
    public HttpResponse<DemoEndpointReponseDTO> viewPDLData() {
        return HttpResponse.ok(new DemoEndpointReponseDTO("Can View PDL Data"));
    }
}
