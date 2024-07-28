import model.User;

public class App {
    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder(new RandomUserService());
        User user = userBuilder.createUser("email@example.com", null, null, null, null);
        System.out.println(user);
    }
}
