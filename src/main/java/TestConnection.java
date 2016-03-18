/**
 * The connection runner class.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mappings.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Test for JDBC connection to EC2 MySQL connection.
 */
public class TestConnection {
    final static String LOCAL_HOST = "localhost";
    final static String PUBLIC_DNS = "ec2-54-187-101-228.us-west-2.compute.amazonaws.com";
    private static final String PORT = "3306";
    private static final String DATABASE = "testdb";
    private static final String REMOTE_DATABASE_USERNAME = "remoteu";
    private static final String DATABASE_USER_PASSWORD = "rafa1234";
    private static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String GET_ALL = "SELECT * FROM ";
    public static final Optional<Connection> connection = connectJDBCToAWSEC2();


    enum Tables {
        Movies("movies"),
        Genres("genre"), Users("user"), History("history"), Ratings("ratings"), UserToGenres("user_to_genre");

        private String name;

        Tables(String name) {
            this.name = name;
        }
    }

    public static JsonObject flixToJson() {
        Optional<List<Mappable>> moviesOpt = getMovies(connection.get());
        Optional<List<Mappable>> usersOpt = getUsers(connection.get());
        Optional<List<Mappable>> genreOpt = getGenre(connection.get());
        Optional<List<Mappable>> historyOpt = getHistory(connection.get());
        Optional<List<Mappable>> ratingsOpt = getRatings(connection.get());
        Optional<List<Mappable>> userToGenresOpt = getUserToGenres(connection.get());

        JsonObject mappable = new JsonObject();

        mappable.add(Tables.Movies.name, fromMappings(moviesOpt.get()));
        mappable.add(Tables.Genres.name, fromMappings(genreOpt.get()));
        mappable.add(Tables.Users.name, fromMappings(usersOpt.get()));
        mappable.add(Tables.History.name, fromMappings(historyOpt.get()));
        mappable.add(Tables.Ratings.name, fromMappings(ratingsOpt.get()));
        mappable.add(Tables.UserToGenres.name, fromMappings(userToGenresOpt.get()));

        return mappable;
    }

    private static JsonArray fromMappings(List<Mappable> m){
        Stream<JsonObject> object = m.stream().map(Mappable::toJson);
        JsonArray jsonArray = new JsonArray();
        object.forEach(jsonArray::add);
        return jsonArray;
    }

    private static Optional<List<Mappable>> getUserToGenres(Connection connection) {
        Optional<Statement> statement = createStatement(connection);
        ResultSet set = query(statement.get(), GET_ALL.concat(Tables.UserToGenres.name)).get();
        try {
            List<Mappable> userToGenres = new ArrayList<>();
            while (set.next()) {
                userToGenres.add(UserToGenre_(set.getInt(1), set.getInt(2)));
            }
            return Optional.of(userToGenres);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }


    private static Optional<List<Mappable>> getRatings(Connection connection) {
        Optional<Statement> statement = createStatement(connection);
        ResultSet set = query(statement.get(), GET_ALL.concat(Tables.Ratings.name)).get();
        try {
            List<Mappable> histories = new ArrayList<>();
            while (set.next()) {
                histories.add(Ratings_(set.getInt(1), set.getInt(2), set.getInt(3), set.getInt(4)));
            }
            return Optional.of(histories);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    private static Optional<List<Mappable>> getHistory(Connection connection) {
        Optional<Statement> statement = createStatement(connection);
        ResultSet set = query(statement.get(), GET_ALL.concat(Tables.History.name)).get();
        try {
            List<Mappable> histories = new ArrayList<>();
            while (set.next()) {
                histories.add(History_(set.getInt(1), set.getInt(2), set.getInt(3), set.getInt(4)));
            }
            return Optional.of(histories);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    private static Optional<List<Mappable>> getGenre(Connection connection) {
        Optional<Statement> statement = createStatement(connection);
        ResultSet set = query(statement.get(), GET_ALL.concat(Tables.Genres.name)).get();
        try {
            List<Mappable> genres = new ArrayList<>();
            while (set.next()) {
                genres.add(Genre_(set.getInt(1), set.getString(2)));
            }
            return Optional.of(genres);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }


    private static Optional<List<Mappable>> getMovies(Connection connection) {
        Optional<Statement> statement = createStatement(connection);
        ResultSet set = query(statement.get(), GET_ALL.concat(Tables.Movies.name)).get();
        try {
            List<Mappable> movies = new ArrayList<>();
            while (set.next()) {
                movies.add(Movie_(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4)));
            }
            return Optional.of(movies);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    private static Optional<List<Mappable>> getUsers(Connection connection) {
        Optional<Statement> statement = createStatement(connection);
        ResultSet set = query(statement.get(), GET_ALL.concat(Tables.Users.name)).get();
        try {
            List<Mappable> users = new ArrayList<>();
            while (set.next()) {
                users.add(User_(set.getInt(1), set.getString(2), set.getString(3)));
            }
            return Optional.of(users);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    private static Optional<ResultSet> query(Statement statement, String sql) {
        try {
            return Optional.ofNullable(statement.executeQuery(sql));
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    private static Optional<Statement> createStatement(Connection connection) {

        try {
            return Optional.ofNullable(connection.createStatement());
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    public static Optional<Connection> connectJDBCToAWSEC2() {
        Optional<Connection> con;

        try {
            Class.forName(SQL_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        try {
            con = Optional.of(DriverManager.
                    getConnection("jdbc:mysql://" + LOCAL_HOST + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD));
        } catch (SQLException e) {
            return Optional.empty();
        }

        return con;
    }

    private static Movie Movie_(int id, String name, int year, int genreId) {
        return new Movie(id, name, year, genreId);
    }

    private static User User_(int userId, String userName, String email) {
        return new User(userId, userName, email);
    }

    private static Genre Genre_(int genreId, String name) {
        return new Genre(genreId, name);
    }

    private static History History_(int idHistory, int percentage, int idUser, int idMovie) {
        return new History(idHistory, percentage, idUser, idMovie);
    }

    private static Ratings Ratings_(int idFavorites, int rating, int idUser, int idMovies) {
        return new Ratings(idFavorites, rating, idUser, idMovies);
    }

    private static UserToGenre UserToGenre_(int idUser, int idGenre) {
        return new UserToGenre(idUser, idGenre);
    }
}
