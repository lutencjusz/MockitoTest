import model.RandomUserDto;
import model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        // given
        RandomUserService randomUserService = Mockito.mock(RandomUserService.class);
        RandomUserDto randomUserDto = new RandomUserDto();
        randomUserDto.setUsername("random_username_123");
        randomUserDto.setAvatar("http://example.com/image.jpg");
        randomUserDto.setFirst_name("Krzysztof");
        randomUserDto.setLast_name("Kowalski");
        Mockito.when(randomUserService.fetchRandomUser()).thenReturn(randomUserDto);

        UserBuilder userBuilder = new UserBuilder(randomUserService);
        String email = "user@example.com";

        // when
        User user = userBuilder.createUser(email, null, null, null, null);

        // then
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getUsername()).isEqualTo("random_username_123");
        assertThat(user.getAvatar()).isEqualTo("http://example.com/image.jpg");
    }
}
