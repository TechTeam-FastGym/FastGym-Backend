package org.fastgym.iam.domain.model.queries;

import org.fastgym.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
