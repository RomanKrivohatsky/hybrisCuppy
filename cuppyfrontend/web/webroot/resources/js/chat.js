

var newMessages = function fetchMessages(all) {
    var today = new Date();
   /* var options = {
        year: 'numeric', month: 'numeric', day: 'numeric',
        hour: 'numeric', minute: 'numeric', second: 'numeric',
        hour12: false
    };
    console.log(today.toLocaleString('en-US', options));
// → "12/19/2012, 19:00:00"


    var from = today.toLocaleString('en-US', options);

    var year = today.getFullYear()
    var month = (today.getMonth() + 1);
     month = month < 10 ? "0" + today.getMonth() : month+1
    var day = today.getDate();
    var hours = today.getHours();
    var min = today.getMinutes();
    var second = today.getSeconds();

    "-" + (today.getMonth()+1) + "-" + today.getDate() + " " + today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();*/
    var url;

    if (all==1) {
        url = "/cuppyfrontend/fetchChatMessages";
    } else {
        url = "/cuppyfrontend/fetchChatMessagesFromDate/" + encodeURI(today.toISOString());
    }

    $.ajax({
        url:url
    }).then(function (data) {
        var chat = $("#chatWindow");
        for (var i = 0; i < data.length; i++) {
            var message = "<div><p>" + data[i].content + "</p></div>";
            chat.append(message);
        }
    });



}

/*
$( document ).ready(function() {
    console.log( "document loaded" );
});

$( window ).load(function() {
    console.log( "window loaded" );
});
*/

$(document).ready(newMessages(1)) ;

$(window).load(function () {
    var input = $("#postMessageButton");
    input.click(function () {
        var message = $("#inputMessage")
        $.ajax({
            url:"/cuppyfrontend/saveMessage",
            type:"POST",
            data:{"message":message[0].value}
        }).then(function (data) {
            //newMessages(0);
        });
    })

}) ;

$(window).setInterval(newMessages(0), 100);

/*
document.addEventListener('DOMContentLoaded',function(){
    alert("DOMContentLoaded");
    /!*fun code to run*!/
})*/
