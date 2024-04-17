package org.fastgym.iam.interfaces.rest.transform;

import org.fastgym.iam.domain.model.commands.LogInCommand;
import org.fastgym.iam.interfaces.rest.resources.LogInResource;

public class LogInCommandFromResourceAssembler {
    public static LogInCommand toCommandFromResource(LogInResource signInResource) {
        return new LogInCommand(signInResource.username(), signInResource.password());
    }
}
