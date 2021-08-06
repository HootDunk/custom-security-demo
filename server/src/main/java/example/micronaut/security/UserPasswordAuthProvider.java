package example.micronaut.security;

import example.micronaut.exceptions.NotFoundException;
import example.micronaut.member_profile.MemberProfile;
import example.micronaut.member_profile.MemberProfileRepository;

import example.micronaut.permission.Permission;
import example.micronaut.permission.PermissionRepository;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Singleton
public class UserPasswordAuthProvider implements AuthenticationProvider {
    private final MemberProfileRepository memberProfileRepository;
    private final PermissionRepository permissionRepository;

    public UserPasswordAuthProvider(MemberProfileRepository memberProfileRepository, PermissionRepository permissionRepository) {
        this.memberProfileRepository = memberProfileRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authReq){

        MemberProfile memberProfile = memberProfileRepository.findByWorkEmail(authReq.getIdentity().toString()).orElse(null);
        if (memberProfile == null){
            throw new NotFoundException("No email address found");
        }
        if (!memberProfile.getPassword().equals(authReq.getSecret().toString())){
            throw new NotFoundException(("Password does not match"));
        }

        List<Permission> permissions = permissionRepository.findUserPermissions(memberProfile.getId());
        // everything works here
//        permissions.forEach(permission -> System.out.println(permission.getId() + " " + permission.getPermission()));
        String email = authReq.getIdentity().toString();
        // but permission id's are not included in jwt ?
        return Flowable.just(new ExtendedUserDetails(email, new ArrayList<>(), permissions));



    }


}
