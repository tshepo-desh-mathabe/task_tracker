package co.za.task.tracker.service;

import co.za.task.tracker.entity.Token;
import co.za.task.tracker.entity.User;
import co.za.task.tracker.repository.ITokenRepository;
import co.za.task.tracker.util.constants.TokenType;
import co.za.task.tracker.util.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// todo - implement abstractly
@Service
public class TokenService implements ITokenService {
    @Autowired
    private ITokenRepository repository;

    @Override
    public void revokeAllUserTokens(User user) {
        var validUserTokens = repository.findAllValidTokenByUser(user.getUserId());

        if (validUserTokens.isEmpty()) return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        repository.saveAll(validUserTokens);
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        repository.save(token);
    }
}
