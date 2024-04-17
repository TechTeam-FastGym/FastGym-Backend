package org.fastgym.iam.interfaces.rest.transform;

import org.fastgym.iam.domain.model.commands.SignUpCommand;
import org.fastgym.iam.domain.model.entities.Role;
import org.fastgym.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.firstname(), resource.lastname(), resource.password(), roles);
    }
}
