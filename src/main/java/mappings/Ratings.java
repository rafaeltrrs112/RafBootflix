package mappings;

import com.google.gson.JsonObject;

/**
 * Ratings ORM.
 */
public class Ratings implements Mappable {
    final int idFavorites;
    final int rating;
    final int idUser;
    final int idMovies;

    public Ratings(int idFavorites, int rating, int idUser, int idMovies) {
        this.idFavorites = idFavorites;
        this.rating = rating;
        this.idUser = idUser;
        this.idMovies = idMovies;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "idFavorites=" + idFavorites +
                ", rating=" + rating +
                ", idUser=" + idUser +
                ", idMovies=" + idMovies +
                '}';
    }

    public JsonObject toJson() {
        final JsonObject object = new JsonObject();
        object.addProperty("idFavorites", this.idFavorites);
        object.addProperty("rating", this.rating);
        object.addProperty("idUser", this.idUser);
        object.addProperty("idMovies", this.idMovies);
        return object;
    }
}
