const socket = io("/");
const myVideo = document.createElement("video");
const videoGrid = document.getElementById("video-grid");

const user = prompt("Enter your name");

var peer = new Peer(undefined, {
	host: "/",
	port: "3001",
});

// add media
let myVideoStream;
navigator.mediaDevices.getUserMedia({
	audio: true,
	video: true,
}).then((stream) => {

	// show video my video to broser
	myVideoStream = stream;
	addVideoStream(myVideo, stream);
	//

	// answer myvideo for call request
	peer.on("call", (call) => {
		call.answer(stream);
		const video = document.createElement("video");
		call.on("stream", (userVideoStream) => {
			addVideoStream(video, userVideoStream);
		});
	});

	// trigger when new user connected
	socket.on("user-connected", (userId) => {
		connectToNewUser(userId, stream);
	});
});

const connectToNewUser = (userId, stream) => {

	const call = peer.call(userId, stream);
	const video = document.createElement("video");
	call.on("stream", (userVideoStream) => {
		addVideoStream(video, userVideoStream);
	});
}

peer.on("open", (id) => {
  socket.emit("join-room", ROOM_ID, id, user);
});

const addVideoStream = (video, stream) => {
	video.srcObject = stream;
	video.addEventListener("loadedmetadata", () => {
		video.play();
		videoGrid.append(video);
	});
};