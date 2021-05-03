var stompClient = null

function setConnected(connected) {
    $("#connect").prop("disabled", connected)
    $("#disconnect").prop("disabled", !connected)
    if (connected) {
        $("#systemInfo").show()
        $("#mymessage").prop("disabled", !connected)
    }
    else {
        $("#systemInfo").hide()
        $("#mymessage").prop("disabled", true)
    }
    $("#systemInfo").html("")
}

function connect() {
    let socket = new SockJS('http://localhost:8090/websocket')
    stompClient = Stomp.over(socket)
    stompClient.debug = false;
    stompClient.connect({}, function (frame) {
        setConnected(true)
        //console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/states', function (response) {
            //showMesage(JSON.parse(response.body));
            showMesage(response.body)
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    setConnected(false);
    console.log("Disconnected")
}

function sendMessage() {
    let mymessage = $("#mymessage").val()
    //stompClient.send("/states", {}, JSON.stringify({'name': mymessage}))
    stompClient.send("/states", {}, mymessage)
}

function showMesage(message) {
    $("#systemInfo").prepend("<tr><td>" + message + "</td></tr>")
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault()
    })
    $("#connect").click(function() { connect() })
    $("#disconnect").click(function() { disconnect() })
    $("#send").click(function() { 
        sendMessage()
        $("#mymessage").val('')
    })
});