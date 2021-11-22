const express = require( 'express' );
const app = express();
const server = require('http').Server(app);
const { v4: uuidv4 } = require("uuid");
const io = require('socket.io')(server);

const { ExpressPeerServer } = require("peer");
const peerServer = ExpressPeerServer(server, {
  debug: true,
});

const hostname = '127.0.0.1';
const port = 3000;

app.set('view engine', 'ejs');
app.use("/peerjs", peerServer);
app.use(express.static("assets"));

app.get("/", (req, res) => {
  res.redirect(`/${uuidv4()}`);
});

app.get("/:room", (req, res) => {
  res.render('index', { roomId: req.params.room });
});

// trigger when have new user connect
io.on("connection", (socket) => {
  socket.on("join-room", (roomId, userId, userName) => {
    console.log(roomId);
    socket.join(roomId);
    
    // alert to other user that there new user connect
    socket.to(roomId).broadcast.emit("user-connected", userId);
  })
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});