package mappings;

import com.google.gson.JsonObject;

/**
 * Genre class ORM.
 */
public class Genre implements Mappable {
    final int genreId;
    final String name;

    public Genre(int genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                '}';
    }

    public JsonObject toJson(){
        final JsonObject object = new JsonObject();
        object.addProperty("genreId", this.genreId);
        object.addProperty("name", this.name);
        return object;
    }

}
