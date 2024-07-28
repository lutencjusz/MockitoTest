package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String username;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
