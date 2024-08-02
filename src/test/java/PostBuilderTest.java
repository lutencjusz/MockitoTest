import model.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import service.PostService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MockitoSettings(strictness = Strictness.WARN)
@ExtendWith(MockitoExtension.class)
public class PostBuilderTest {
    @Mock PostService mockPostService;
    @InjectMocks PostBuilder postBuilder;

    @Test
    public void shouldCreatePostWithGivenData() {
        Post post = postBuilder.createPost("title", "userId", "1");
        assertEquals("title", post.getTitle());
        assertEquals("userId", post.getUserId());
        assertEquals("1", post.getId());
        System.out.println(post);
        Mockito.verify(mockPostService, Mockito.never()).fetchPost(Mockito.anyString());
        Mockito.verifyNoInteractions(mockPostService);
    }

    @Test
    public void shouldUseRandomPostData() {

        final String TITLE = "mock title";
        final String USER_ID = "mock userId";

        Post mockPost = new Post();
        mockPost.setTitle(TITLE);
        mockPost.setUserId(USER_ID);
        Mockito.when(mockPostService.fetchPost("1")).thenReturn(mockPost);
        Mockito.when(mockPostService.fetchPost("2")).thenReturn(mockPost);

        PostBuilder postBuilder = new PostBuilder(mockPostService);

        Post post = postBuilder.createPost(null, null, "1");
        assertEquals(TITLE, post.getTitle());
        assertEquals(USER_ID, post.getUserId());
        assertEquals("1", post.getId());
        System.out.println(post);
    }
}
