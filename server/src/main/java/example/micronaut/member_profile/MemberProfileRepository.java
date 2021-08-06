package example.micronaut.member_profile;

import example.micronaut.permission.Permission;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
@Join(value = "roles", type = Join.Type.FETCH)
public interface MemberProfileRepository extends CrudRepository<MemberProfile, UUID> {
    List<MemberProfile> findAll();

    Optional<MemberProfile> findById(UUID id);

    Optional<MemberProfile> findByWorkEmail(String email);

//    @Query("SELECT DISTINCT permissions.id, permissions.permission " +
//            "FROM member_profile " +
//            "JOIN member_roles " +
//            "    ON member_profile.id = member_roles.member_id " +
//            "JOIN roles " +
//            "    ON roles.id = member_roles.role_id " +
//            "JOIN role_permissions " +
//            "    ON roles.id = role_permissions.role_id " +
//            "JOIN permissions " +
//            "    ON permissions.id = role_permissions.permission_id " +
//            "WHERE member_profile.id = :id;")
//    Optional<List<Permission>> findUserPermissions(UUID id);

}
