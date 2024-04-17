package org.fastgym.iam.application.internal.commandservices;

import org.fastgym.iam.application.internal.outboundservices.hashing.HashingService;
import org.fastgym.iam.domain.model.aggregates.User;
import org.fastgym.iam.domain.model.commands.LogInCommand;
import org.fastgym.iam.domain.model.commands.SignUpCommand;
import org.fastgym.iam.domain.model.commands.UpdateUserCommand;
import org.fastgym.iam.domain.model.commands.DeleteUserCommand;
import org.fastgym.iam.domain.services.UserCommandService;
import org.fastgym.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.fastgym.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username())) throw new RuntimeException("Username already exists");

        var roles = command.roles().stream().map(role -> roleRepository.findByName(role.getName())
                .orElseThrow(() -> new RuntimeException("Role name not found"))).toList();
        var user = new User(command.username(), command.firstname(), command.lastname(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<User> handle(LogInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        return user;
    }

    @Override
    public Optional<User> handle(UpdateUserCommand command) {
        var user = userRepository.findById(command.userId());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        user.get().setUsername(command.username());
        user.get().setFirstname(command.firstname());
        user.get().setLastname(command.lastname());
        user.get().setPassword(hashingService.encode(command.password()));

        userRepository.save(user.get());
        return userRepository.findById(command.userId());
    }

    @Override
    public Optional<User> handle(DeleteUserCommand command) {
        var user = userRepository.findById(command.userId());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        userRepository.deleteById(user.get().getId());
        return user;
    }
}
