import model.User;
import service.RandomUserService;

import java.util.Objects;

public class UserBuilder {

    private final RandomUserService randomUserService;

    public UserBuilder(RandomUserService randomUserService) {
        this.randomUserService = randomUserService;
    }

    public User createUser(String email, String username, String avatar, String first_name, String last_name) {
        User user = new User();
        user.setEmail(email);

        User randomUserDto = null;
        if (username == null || avatar == null || first_name == null || last_name == null) {
            randomUserDto = randomUserService.fetchRandomUser();
        }
        user.setAvatar(avatar != null ? avatar : randomUserDto.getAvatar());
        user.setUsername(username != null ? username : randomUserDto.getUsername());
        user.setFirst_name(first_name != null ? first_name : Objects.requireNonNull(randomUserDto).getFirst_name());
        user.setLast_name(last_name != null ? last_name : Objects.requireNonNull(randomUserDto).getLast_name());

        return user;
    }
}

