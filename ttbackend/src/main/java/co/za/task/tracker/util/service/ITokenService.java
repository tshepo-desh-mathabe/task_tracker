package co.za.task.tracker.util.service;

import co.za.task.tracker.entity.User;

public interface ITokenService {

    void revokeAllUserTokens(User user);

    void saveUserToken(User user, String jwtToken);
}
