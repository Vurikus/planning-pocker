let webSocket = openWebSocket();

function sendMsg() {
    webSocket.send("ASD");
}

function openWebSocket() {
    const ws = new WebSocket("ws://localhost:8080/currentRoom");

    ws.onmessage = function(message) {
        console.log("Received: " + message);
        console.log("Received data: " + message.data);
        if (message.data.error) {
            console.log("ERROR!!!")
        }
        updateRoom(message);
    };
    ws.onopen = function() {
        console.log("connection opened");
    };
    ws.onclose = function() {
        console.log("connection closed");
    };
    ws.onerror = function wserror(message) {
        console.log("error: " + message.toString());
    };
    return ws;
}

function updateRoom(message) {
    document.getElementById('roomTitle').textContent = "1231";
}