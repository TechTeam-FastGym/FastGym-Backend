package org.fastgym.iam.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.fastgym.iam.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

/**
 * Role entity
 *
 * <p>
 *     This entity represents the role of a user in the system.
 *     It is used to define the permissions of a user.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    /**
     * Constructor
     * @param name Role name
     */
    public Role(Roles name) {
        this.name = name;
    }

    /**
     * Get the role name as a String
     * @return Role name
     */
    public String getStringName() {
        return name.name();
    }

    /**
     * Get the default role as defined in the system
     * @return Role name
     */
    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_CUSTOMER);
    }

    /**
     * Get the role from a String
     * @param name Role name
     * @return Role
     */
    public static Role toRoleFromName(String name) {
        try {
            return new Role(Roles.valueOf(name));
        } catch (IllegalArgumentException e) {
            // Handle the exception, log it, or return a default role.
            return getDefaultRole();
        }
    }

    /**
     * Validate the role set if it is null or empty
     * @param roles Role set
     * @return Role set
     */
    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }
}
