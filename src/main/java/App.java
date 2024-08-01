import model.Post;
import model.User;
import service.PostService;
import service.RandomUserService;

public class App {
    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder(new RandomUserService());
        PostBuilder postBuilder = new PostBuilder(new PostService());
        User user = userBuilder.createUser("email@example.com", null, null, null, null);
        Post post = postBuilder.createPost(null, null, "1");
        System.out.println(user);
        System.out.println(post);
    }
}
