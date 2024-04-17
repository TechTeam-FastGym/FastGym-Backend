package org.fastgym.iam.application.internal.queryservices;

import org.fastgym.iam.domain.model.aggregates.User;
import org.fastgym.iam.domain.model.queries.GetAllUsersQuery;
import org.fastgym.iam.domain.model.queries.GetUserByIdQuery;
import org.fastgym.iam.domain.services.UserQueryService;
import org.fastgym.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User query service implementation
 * <p>
 *     This class is used to handle the user queries.
 * </p>
 * @see UserQueryService
 * @see UserRepository
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Handle the get all users query
     */
    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    /**
     * Handle the get user by id query
     */
    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }
}
