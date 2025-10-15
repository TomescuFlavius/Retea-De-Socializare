package app.service;

public class UserCommandServiceSingleton {
    private static class LazyHolder{
        private static final UserCommandService USER_COMMAND_SERVICE= (UserCommandService) new UserCommandServiceImpl();
    }
    public static UserCommandService getInstance(){
        return LazyHolder.USER_COMMAND_SERVICE;
    }
}
