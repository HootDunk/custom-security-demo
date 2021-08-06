package example.micronaut.security;

import com.nimbusds.jwt.JWTClaimsSet;
import example.micronaut.permission.Permission;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.token.config.TokenConfiguration;
import io.micronaut.security.token.jwt.generator.claims.ClaimsAudienceProvider;
import io.micronaut.security.token.jwt.generator.claims.JWTClaimsSetGenerator;
import io.micronaut.security.token.jwt.generator.claims.JwtIdGenerator;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@Replaces(bean = JWTClaimsSetGenerator.class)
public class CustomJWTClaimsSetGenerator extends JWTClaimsSetGenerator {

    public CustomJWTClaimsSetGenerator(TokenConfiguration tokenConfiguration,
                                       @Nullable JwtIdGenerator jwtIdGenerator,
                                       @Nullable ClaimsAudienceProvider claimsAudienceProvider,
                                       @Nullable ApplicationConfiguration applicationConfiguration) {
        super(tokenConfiguration, jwtIdGenerator, claimsAudienceProvider, applicationConfiguration);
    }

    @Override
    protected void populateWithUserDetails(JWTClaimsSet.Builder builder, UserDetails userDetails) {
        super.populateWithUserDetails(builder, userDetails);
        if (userDetails instanceof ExtendedUserDetails) {
            ExtendedUserDetails extended = (ExtendedUserDetails) userDetails;
            List<Permission> permissions = extended.getPermissions();
            permissions.forEach(permission -> System.out.println(permission.getId() + " " + permission.getPermission()));
            // TODO figure out why id isn't included in each permission of the JWT (list of permissions does map to JSON entity?)
            builder.claim("permissions", ((ExtendedUserDetails)userDetails).getPermissions());
        }
    }
}
