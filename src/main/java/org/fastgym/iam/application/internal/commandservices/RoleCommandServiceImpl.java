package org.fastgym.iam.application.internal.commandservices;


import org.fastgym.iam.domain.model.commands.GiveRolesCommand;
import org.fastgym.iam.domain.model.entities.Role;
import org.fastgym.iam.domain.model.valueobjects.Roles;
import org.fastgym.iam.domain.services.RoleCommandService;
import org.fastgym.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link RoleCommandService}
 * <p>
 *     This class is responsible for handling the commands for {@link Role} entity
 * </p>
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(GiveRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
