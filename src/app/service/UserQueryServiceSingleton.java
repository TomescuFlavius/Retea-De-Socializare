package app.service;

public class UserQueryServiceSingleton {
    private static class Lazy{
        private static final UserQueryService USER_QUERY_SERVICE= (UserQueryService) new UserCommandServiceImpl();

    }
    public static UserQueryService getInstance(){
        return Lazy.USER_QUERY_SERVICE;
    }
}
