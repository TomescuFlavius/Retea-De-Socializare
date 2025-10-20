package app.tags.services;

public class TagCommandServiceSingleton {
    public static class LazyHolder{
        private static final TagCommandService TAG_COMMAND_SERVICE=new TagCommandServiceImpl();
    }
    public static TagCommandService getInstance(){
        return LazyHolder.TAG_COMMAND_SERVICE;
    }
}
