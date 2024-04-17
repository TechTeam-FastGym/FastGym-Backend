package org.fastgym.iam.domain.services;

import org.fastgym.iam.domain.model.commands.GiveRolesCommand;

/**
 * RoleCommandService
 * <p>
 *     This interface defines the contract for the role command service.
 *     The role command service is responsible for handling the commands related to the role domain entity.
 * </p>
 */
public interface RoleCommandService {

    /**
     * Handle the seed roles command.
     * <p>
     *     This method is responsible for populating database with default roles.
     * </p>
     * @param command The seed roles command.
     * @see GiveRolesCommand
     */
    void handle(GiveRolesCommand command);
}