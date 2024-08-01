import model.Post;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.PostService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostBuilderTest {
    @Test
    public void shouldCreatePostWithGivenData() {
        PostService postService = new PostService();
        PostBuilder postBuilder = new PostBuilder(postService);
        Post post = postBuilder.createPost("title", "userId", "1");
        assertEquals("title", post.getTitle());
        assertEquals("userId", post.getUserId());
        assertEquals("1", post.getId());
        System.out.println(post);
    }

    @Test
    public void shouldUseRandomPostData() {
        final String TITLE = "mock title";
        final String USER_ID = "mock userId";

        PostService mockPostService = Mockito.mock(PostService.class);
        Post mockPost = new Post();
        mockPost.setTitle(TITLE);
        mockPost.setUserId(USER_ID);
        Mockito.when(mockPostService.fetchPost("1")).thenReturn(mockPost);

        PostBuilder postBuilder = new PostBuilder(mockPostService);

        Post post = postBuilder.createPost(null, null, "1");
        assertEquals(TITLE, post.getTitle());
        assertEquals(USER_ID, post.getUserId());
        assertEquals("1", post.getId());
        System.out.println(post);
    }
}
