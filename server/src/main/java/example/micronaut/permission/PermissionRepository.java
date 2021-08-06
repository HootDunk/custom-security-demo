package example.micronaut.permission;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PermissionRepository extends CrudRepository<Permission, UUID> {
    List<Permission> findAll();

    @Query("SELECT DISTINCT permissions.id, permissions.permission " +
            "FROM member_profile " +
            "JOIN member_roles " +
            "    ON member_profile.id = member_roles.member_id " +
            "JOIN roles " +
            "    ON roles.id = member_roles.role_id " +
            "JOIN role_permissions " +
            "    ON roles.id = role_permissions.role_id " +
            "JOIN permissions " +
            "    ON permissions.id = role_permissions.permission_id " +
            "WHERE member_profile.id = :id")
    List<Permission> findUserPermissions(UUID id);

}
