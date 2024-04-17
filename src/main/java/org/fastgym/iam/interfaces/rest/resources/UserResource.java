package org.fastgym.iam.interfaces.rest.resources;

import java.util.List;

public record UserResource(Long id, String username, String firstname, String lastname, List<String> roles) {
}
