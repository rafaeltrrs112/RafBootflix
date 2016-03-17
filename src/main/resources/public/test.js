addfriend();

function addfriend() {
    console.log("Is Running");
    //alert("USER:" + user + " TARG:" + target);
    $.ajax({
        url: 'bar',
        success: function (response) {
            console.log(response)
        },
        error: function (error) {
            console.log(error)
        }
    });
}