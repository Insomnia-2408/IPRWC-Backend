package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Credentials {

    private String email;
    private String password;
    private String token;

    @JsonCreator
    public Credentials(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("token") String token
    ) {

        this.email = email;
        this.password = password;
        this.token = token;

    }

    @NotNull
    @JsonProperty
    public String getEmail() {
        return this.email;
    }

    @JsonProperty
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public String getToken() {
        return this.token;
    }

}
