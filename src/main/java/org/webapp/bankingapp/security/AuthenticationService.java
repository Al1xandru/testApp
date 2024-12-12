package org.webapp.bankingapp.security;

import org.webapp.bankingapp.security.model.JwtAuthenticationResponse;
import org.webapp.bankingapp.security.model.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse authenticate(SignInRequest request);
}
