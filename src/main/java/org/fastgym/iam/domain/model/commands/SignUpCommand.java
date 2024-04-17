package org.fastgym.iam.domain.model.commands;

import org.fastgym.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String firstname, String lastname, String password, List<Role> roles) {
}
