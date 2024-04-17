package org.fastgym.iam.domain.services;

import org.fastgym.iam.domain.model.aggregates.User;
import org.fastgym.iam.domain.model.queries.GetAllUsersQuery;
import org.fastgym.iam.domain.model.queries.GetUserByIdQuery;

import java.util.*;

/**
 * UserQueryService
 * <p>
 *     Service to handle user queries.
 * </p>
 */
public interface UserQueryService {

    /**
     * Handle the get all users query.
     * <p>
     *     This method is responsible for retrieving all the users from the database.
     * </p>
     * @param query The get all users query.
     * @return The list of users.
     * @see GetAllUsersQuery
     */
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
