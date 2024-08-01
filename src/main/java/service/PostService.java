package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Post;

public class PostService {
    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    public Post fetchPost(String id) {
        RestAssured.baseURI = POST_URL;
        Response response = RestAssured.given().when().get("/" + id);
        return response.as(Post.class);
    }
}
