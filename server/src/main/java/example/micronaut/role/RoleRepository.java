package example.micronaut.role;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
@Join(value = "permissions", type = Join.Type.FETCH)
public interface RoleRepository extends CrudRepository<Role, UUID> {

    @Query("SELECT roles.id, roles.role, roles.description, member_roles.member_id as member_id, permissions.id as permissions_id, permissions.permission as permissions_permission " +
            "FROM roles " +
            "join member_roles " +
            "on roles.id = member_roles.role_id " +
            "JOIN role_permissions " +
            "    ON roles.id = role_permissions.role_id " +
            "JOIN permissions " +
            "    ON permissions.id = role_permissions.permission_id")
    List<Role> findAll();

//
//    @Query("SELECT * " +
//            "FROM roles " +
//            "join member_roles " +
//            "on roles.id = member_roles.role_id " +
//            "join member_profile " +
//            "on member_profile.id = member_roles.member_id")
//    List<RoleDTO> findAllDTO();


}
