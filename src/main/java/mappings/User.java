package mappings;

import com.google.gson.JsonObject;

/**
 * User class representation;
 */
public class User implements Mappable {
    final int userId;
    final String userName;
    final String email;

    public User(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public JsonObject toJson() {
        final JsonObject object = new JsonObject();
        object.addProperty("userId", this.userId);
        object.addProperty("userName", this.userName);
        object.addProperty("email", this.email);
        return object;
    }
}
