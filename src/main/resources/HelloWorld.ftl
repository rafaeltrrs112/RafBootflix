<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link type="text/css" rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css"
          media="screen,projection"/>


</head>
<body>


<div class="row">

    <div class="col s12">
        <ul class="tabs">
            <li class="tab col s3"><a href="#moviesTable">Movies</a></li>
            <li class="tab col s3"><a class="active" href="#usersTable">Users</a></li>
            <li class="tab col s3"><a href="#userGenreTable">Users Preferences</a></li>
            <li class="tab col s3"><a class="active" href="#ratingsTable">Ratings</a></li>
            <li class="tab col s3"><a href="#genreTable">Genre</a></li>
            <li class="tab col s3"><a class="active" href="#historyTable">History</a></li>
        </ul>
    </div>

    <table id="moviesTable" class="highlight">
        <thead>
        <tr>
            <th data-field="id">Movie ID</th>
            <th data-field="name">Title</th>
            <th data-field="price">Release Year</th>
            <th data-field="price">Genre</th>
        </tr>
        </thead>

        <tbody id="moviesTableBody">


        </tbody>
    </table>
</div>

<div class="container col s6">
    <table id="usersTable" class="highlight">
        <thead>
        <tr>
            <th data-field="idUser">User ID</th>
            <th data-field="name">Name</th>
            <th data-field="email">E-Mail</th>
        </tr>
        </thead>

        <tbody id="usersTableBody">


        </tbody>
    </table>
</div>

<div class="container col s6">
    <table id="userGenreTable" class="highlight">
        <thead>
        <tr>
            <th data-field="idUser">User ID</th>
            <th data-field="genre">Genre</th>
        </tr>
        </thead>

        <tbody id="userGenreTableBody">


        </tbody>
    </table>
</div>

<div class="container col s6">
    <table id="ratingsTable" class="highlight">
        <thead>
        <tr>
            <th data-field="idFavorites">User ID</th>
            <th data-field="rating">Rating</th>
            <th data-field="idUser">User</th>
            <th data-field="idMovies">Movies</th>

        </tr>
        </thead>

        <tbody id="ratingsTableBody">

        </tbody>
    </table>
</div>

<div class="container col s6">
    <table id="genreTable" class="highlight">
        <thead>
        <tr>
            <th data-field="genreId">Genre ID</th>
            <th data-field="name">Name</th>
        </tr>
        </thead>

        <tbody id="genreTableBody">

        </tbody>
    </table>
</div>

<div class="container col s6">
    <table id="historyTable" class="highlight">
        <thead>
        <tr>
            <th data-field="idHistory">History ID</th>
            <th data-field="percentage">Percentage</th>
            <th data-field="idUser">User ID</th>
            <th data-field="idMovie">Movies</th>

        </tr>
        </thead>

        <tbody id="historyTableBody">

        </tbody>
    </table>
</div>



</body>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

<script src="test.js"></script>

</html>