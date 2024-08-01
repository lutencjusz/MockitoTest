import model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.RandomUserService;

import static org.assertj.core.api.Assertions.assertThat;

public class UserBuilderTest {
    @Test
    public void shouldCreateUserWithGivenData() {
        // given
        UserBuilder userBuilder = new UserBuilder(null);
        String email = "user@example.com";
        String username = "magiczny_krzysztof";
        String avatar = "https://www.funny.pl/images/items/d7a84628c025d30f7b2c52c958767e76.jpg";
        String first_name = "Krzysztof";
        String last_name = "Kowalski";

        // when
        User user = userBuilder.createUser(email, username, avatar, first_name, last_name);

        // then
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getAvatar()).isEqualTo(avatar);
        assertThat(user.getFirst_name()).isEqualTo(first_name);
        assertThat(user.getLast_name()).isEqualTo(last_name);
    }

    @Test
    public void shouldUseRandomUserData() {

        final String AVATAR = "http://example.com/image.jpg";
        final String FIRST_NAME = "Krzysztof";
        final String LAST_NAME = "Kowalski";
        final String USERNAME = "random_username_123";
        // given
        RandomUserService randomUserService = Mockito.mock(RandomUserService.class);
        User randomUserDto = new User();
        randomUserDto.setUsername(USERNAME);
        randomUserDto.setAvatar(AVATAR);
        randomUserDto.setFirst_name(FIRST_NAME);
        randomUserDto.setLast_name(LAST_NAME);
        Mockito.when(randomUserService.fetchRandomUser()).thenReturn(randomUserDto);

        UserBuilder userBuilder = new UserBuilder(randomUserService);
        String email = "user@example.com";

        // when
        User user = userBuilder.createUser(email, null, null, null, null);

        // then
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getUsername()).isEqualTo(USERNAME);
        assertThat(user.getAvatar()).isEqualTo(AVATAR);
        assertThat(user.getFirst_name()).isEqualTo(FIRST_NAME);
        assertThat(user.getLast_name()).isEqualTo(LAST_NAME);
    }
}
