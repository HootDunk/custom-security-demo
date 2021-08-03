package example.micronaut.member_profile;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
// this join annotation allows us to fetch the roles associated when accessing the MemberProfile entity
@Join(value = "roles", type = Join.Type.FETCH)
public interface MemberProfileRepository extends CrudRepository<MemberProfile, UUID> {
    List<MemberProfile> findAll();
}
