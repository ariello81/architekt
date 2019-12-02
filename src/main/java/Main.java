import models.Home;

public class Main {
    public static void main(String[] args) {
        // when HomeLoaderImpl is singleton
        //HomeLoader homeLoader = HomeLoaderImpl.getInstance();

        HomeLoader homeLoader = new HomeLoaderImpl();

        Home home = homeLoader.loadHome("home", "%");

        System.out.println("Home: " + home);
    }
}
