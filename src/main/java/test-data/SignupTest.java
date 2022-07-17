import kong.unirest.Unirest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Signup API
 * Parameter list:
 * email string
 * password string
 * re_pass string: Should be the same as password
 * address string(optional)
 * name string
 * phone string
 * avatar file(optional)
 */
public class SignupTest {
    //cover properly signup
    @Test
    void SignUp() {
        String randomEmail = Utility.getRandomEmail(10);
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", randomEmail)
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Tuan Tran")
                .field("phone", "034209874")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        System.out.println(res.message);

        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }

    @Test
    void SignUp2() {
        String randomEmail = Utility.getRandomEmail(220);
        System.out.println(randomEmail);
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", randomEmail)
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Tuan Tran")
                .field("phone", "034209874")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        System.out.println(res.message);
    }
}
