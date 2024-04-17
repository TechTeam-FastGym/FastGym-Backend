package org.fastgym.iam.interfaces.rest.transform;

import org.fastgym.iam.domain.model.entities.Role;
import org.fastgym.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
