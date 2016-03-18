package mappings;

import com.google.gson.JsonObject;

/**
 * Represents a movie.
 */
public class Movie implements Mappable {
    final int id;
    final String name;
    final int year;
    final int genreId;

    public Movie(int id, String name, int year, int genreId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genreId=" + genreId +
                '}';
    }

    public JsonObject toJson() {
        final JsonObject object = new JsonObject();
        object.addProperty("id", this.id);
        object.addProperty("name", this.name);
        object.addProperty("year", this.year);
        object.addProperty("genreId", this.genreId);
        return object;
    }
}