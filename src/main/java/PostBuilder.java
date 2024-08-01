import model.Post;
import service.PostService;

public class PostBuilder {
    private final PostService postService;

    public PostBuilder(PostService postService) {
        this.postService = postService;
    }

    public Post createPost(String title, String userId, String id) {
        Post post = new Post();
        post.setId(id);

        Post randomPostDto = null;
        if (title == null || userId == null) {
            randomPostDto = postService.fetchPost(id);
        }
        post.setTitle(title != null ? title : randomPostDto.getTitle());
        post.setUserId(userId != null ? userId : randomPostDto.getUserId());
        return post;
    }
}
