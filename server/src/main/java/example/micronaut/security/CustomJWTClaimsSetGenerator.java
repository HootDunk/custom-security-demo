package example.micronaut.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jwt.JWTClaimsSet;
import example.micronaut.permission.Permission;
import example.micronaut.permission.PermissionDTO;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.jackson.serialize.JacksonObjectSerializer;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.token.config.TokenConfiguration;
import io.micronaut.security.token.jwt.generator.claims.ClaimsAudienceProvider;
import io.micronaut.security.token.jwt.generator.claims.JWTClaimsSetGenerator;
import io.micronaut.security.token.jwt.generator.claims.JwtIdGenerator;

import javax.inject.Singleton;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            List<PermissionDTO> permissions = extended.getPermissions();

            // had to manually do the json serialization for some reason
            try {
                String json = new ObjectMapper().writeValueAsString(permissions);

                System.out.println(json);
                builder.claim("permissions", json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            // TODO figure out why id isn't included in each permission of the JWT (list of permissions does map to JSON entity?)
//            builder.claim("permissions", ((ExtendedUserDetails)userDetails).getPermissions());
//            System.out.println(builder.getClaims().get("permissions").toString());

        }
    }
}
// can change default names of jwt claims (username could be email and roles could be permissions)
// https://micronaut-projects.github.io/micronaut-security/latest/guide/#jwt
