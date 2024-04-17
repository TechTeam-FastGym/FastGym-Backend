package org.fastgym.iam.domain.model.commands;

public record UpdateUserCommand(Long userId, String username, String firstname, String lastname, String password) {
}
