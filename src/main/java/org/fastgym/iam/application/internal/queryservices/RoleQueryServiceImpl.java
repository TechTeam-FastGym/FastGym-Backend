package org.fastgym.iam.application.internal.queryservices;

import org.fastgym.iam.domain.model.entities.Role;
import org.fastgym.iam.domain.model.queries.GetAllRolesQuery;
import org.fastgym.iam.domain.model.queries.GetRoleByNameQuery;
import org.fastgym.iam.domain.services.RoleQueryService;
import org.fastgym.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Role query service implementation
 * <p>
 *     This class is used to handle the role queries.
 * </p>
 * @see RoleQueryService
 * @see RoleRepository
 */
@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Handle the get all roles query
     */
    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    /**
     * Handle the get role by name query
     */
    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}
