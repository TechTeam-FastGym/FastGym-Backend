package org.fastgym.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fastgym.iam.domain.services.UserCommandService;
import org.fastgym.iam.interfaces.rest.resources.AuthenticatedUserResource;
import org.fastgym.iam.interfaces.rest.resources.LogInResource;
import org.fastgym.iam.interfaces.rest.resources.SignUpResource;
import org.fastgym.iam.interfaces.rest.resources.UserResource;
import org.fastgym.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import org.fastgym.iam.interfaces.rest.transform.LogInCommandFromResourceAssembler;
import org.fastgym.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import org.fastgym.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Authentication Controller
 * This controller is responsible for handling the authentication endpoints
 * <p>
 *     The authentication endpoints are:
 *     <ul>
 *         <li>Log In</li>
 *         <li>Sign Up</li>
 *     </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoints")
public class AuthenticationController {
    private final UserCommandService userCommandService;


    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    /** Log In
     * This endpoint is responsible for handling the sign-in request
     * @param logInResource The log-in resource
     * @return The authenticated user resource
     */
    @PostMapping("/log-in")
    public ResponseEntity<AuthenticatedUserResource> logIn(@RequestBody LogInResource logInResource) {
        var logInCommand = LogInCommandFromResourceAssembler.toCommandFromResource(logInResource);
        var userOptional = userCommandService.handle(logInCommand);

        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var user = userOptional.get();

        // Assuming you don't need the token anymore
        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler.toResourceFromEntity(user);

        return ResponseEntity.ok(authenticatedUserResource);
    }

    /** Sign Up
     * This endpoint is responsible for handling the sign-up request
     * @param signUpResource The sign-up resource
     * @return The user resource
     */
    @PostMapping("/sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource signUpResource) {
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(signUpResource);
        var user = userCommandService.handle(signUpCommand);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }
}
