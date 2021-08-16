package example.micronaut.role;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
//@Join(value = "role_permissions", type = Join.Type.FETCH)
public interface RoleRepository extends CrudRepository<Role, UUID> {
//    @Query("SELECT * FROM roles " +
//            "JOIN role_permissions " +
//            "ON roles.id = role_permissions.role_id;"
//    )
//    List<Role> findAll();
//    @Join(value = "role_permissions", type = Join.Type.FETCH)
    List<Role> findAll();

}
