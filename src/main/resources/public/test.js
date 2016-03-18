addfriend();

function addfriend() {
    console.log("Is Running");
    //alert("USER:" + user + " TARG:" + target);
    $.ajax({
        url: 'bar',
        success: function (response) {
            var data = JSON.parse(response);
            console.log(data);
            var moviesTableHTML = ' ';
            var userTableHTML = ' ';
            var userToGenreHTML = ' ';
            var ratingsHTML = ' ';
            var genreHTML = ' ';
            var historyHTML = ' ';

            $.each(data.movies, function (i, el) {
                moviesTableHTML += '<tr><td>' + el.id + '</td><td>' + el.name + '</td><td>' + el.year + '</td><td>' + el.genreId + '</td></tr>';
            });

            $.each(data.user, function (i, el) {
                userTableHTML += '<tr><td>' + el.userId + '</td><td>' + el.userName + '</td><td>' + el.email + '</td></tr>';
            });

            $.each(data.user_to_genre, function (i, el) {
                userToGenreHTML += '<tr><td>' + el.idUser + '</td><td>' + el.idGenre + '</td></tr>';
            });

            $.each(data.ratings, function (i, el) {
                ratingsHTML += '<tr><td>' + el.idFavorites + '</td><td>' + el.rating + '</td><td>' + el.idUser + '</td><td>' + el.idMovies + '</td></tr>';
            });

            $.each(data.genre, function (i, el) {
                genreHTML += '<tr><td>' + el.genreId + '</td><td>' + el.name + '</td></tr>';
            });

            $.each(data.history, function (i, el) {
                historyHTML += '<tr><td>' + el.idHistory + '</td><td>' + el.percentage + '</td><td>' + el.idUser + '</td><td>' + el.idMovie + '</td></tr>';
            });

            $('#moviesTableBody').append(moviesTableHTML);
            $('#usersTableBody').append(userTableHTML);

            $('#userGenreTableBody').append(userToGenreHTML);
            $('#ratingsTableBody').append(ratingsHTML);

            $('#historyTableBody').append(historyHTML);
            $('#genreTableBody').append(genreHTML);


        },
        error: function (error) {
            console.log(error)
        }
    });
}