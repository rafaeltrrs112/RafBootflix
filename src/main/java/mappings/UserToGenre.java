package mappings;

import com.google.gson.JsonObject;

/**
 * User to Genre ORM
 */
public class UserToGenre implements Mappable {
    final int idUser;
    final int idGenre;

    @Override
    public String toString() {
        return "UserToGenre{" +
                "idUser=" + idUser +
                ", idGenre=" + idGenre +
                '}';
    }

    public UserToGenre(int idUser, int idGenre) {
        this.idUser = idUser;
        this.idGenre = idGenre;
    }

    public JsonObject toJson() {
        final JsonObject object = new JsonObject();
        object.addProperty("idUser", this.idUser);
        object.addProperty("idGenre", this.idGenre);
        return object;
    }
}
