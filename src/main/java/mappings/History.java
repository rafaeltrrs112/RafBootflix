package mappings;

import com.google.gson.JsonObject;

/**
 * User to Genre ORM.
 */
public class History implements Mappable {
    int idHistory;
    int percentage;
    int idUser;
    int idMovie;

    public History(int idHistory, int percentage, int idUser, int idMovie) {
        this.idHistory = idHistory;
        this.percentage = percentage;
        this.idUser = idUser;
        this.idMovie = idMovie;
    }


    @Override
    public String toString() {
        return "History{" +
                "idHistory=" + idHistory +
                ", percentage=" + percentage +
                ", idUser=" + idUser +
                ", idMovie=" + idMovie +
                '}';
    }

    public JsonObject toJson() {
        final JsonObject object = new JsonObject();
        object.addProperty("idHistory", this.idHistory);
        object.addProperty("percentage", this.percentage);
        object.addProperty("idUser", this.idUser);
        object.addProperty("idMovie", this.idMovie);
        return object;
    }
}
