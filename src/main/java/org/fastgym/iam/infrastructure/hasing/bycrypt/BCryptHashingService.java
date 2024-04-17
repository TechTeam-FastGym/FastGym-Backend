package org.fastgym.iam.infrastructure.hasing.bycrypt;

import org.fastgym.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Hashing service implementation.
 * Implementation of {@link HashingService} using BCrypt algorithm.
 * Implementation of {@link PasswordEncoder} using BCrypt algorithm.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
