package org.fastgym.iam.interfaces.rest.transform;

import org.fastgym.iam.domain.model.aggregates.User;
import org.fastgym.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername());
    }
}
