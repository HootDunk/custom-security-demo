package example.micronaut.security;

public @interface RequiredPermission {

    /**
     * The permission required, e.g. Can View Organization Members, Can Create/Delete Organization Members
     * @return permission
     */
    Permissions value();
}
