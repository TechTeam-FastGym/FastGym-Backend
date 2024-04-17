package org.fastgym.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String username, String firstname, String lastname,String password, List<String> roles) {
}
