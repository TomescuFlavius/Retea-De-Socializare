package app.users.repository;

import app.users.services.UserQueryService;
import app.users.services.UserQueryServiceImpl;

public class UserRepositorySingleton {
    private static class Lazy{
        private static final UserRepository USER_REPOSITORY=  new UserRepositoryImpl();

    }
    public static UserRepository getInstance(){
        return Lazy.USER_REPOSITORY;
    }
}
