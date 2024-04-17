package org.fastgym.iam.interfaces.rest.transform;

import org.fastgym.iam.domain.model.aggregates.User;
import org.fastgym.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(role -> role.getStringName()).toList();
        return new UserResource(user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(), roles);
    }
}
