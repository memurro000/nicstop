const id = document.getElementById("id");
const key = document.getElementById("key");

const signToken = JSON.parse(sessionStorage.getItem("signer_key"));

id.innerHTML += signToken.id;
key.innerHTML += signToken.key;

