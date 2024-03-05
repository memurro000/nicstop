const EDIT_URL = "/api/v1/signers/update";

const check_resp = document.getElementById("check_resp");

const SIGNER_FIELDS = [ 
    "age", 
    "experience", 
    "physicallyAffected",
    "kindOfNicotine",
    "commentary",
    "id"
];

const KEY_FIELDS = [
    "key"
];

const json_body = {};
const signer = {};

function validateSigner(signer){
    if(!signer.age) {
        check_resp.innerHTML = 
                `<label>Age is required</label>`;
        return -1;
    }
    if(signer.age < 10 || signer.age > 99) {
        check_resp.innerHTML = 
                `<label>Invalid age</label>`;
        return -1;
    }
    if(!signer.experience) {
        check_resp.innerHTML = 
                `<label>Experience is required</label>`;
        return -1;
    }
    if(signer.experience < 0 || signer.experience > 89) {
        check_resp.innerHTML = 
                `<label>Invalid experience</label>`;
        return -1;
    }
    if(signer.commentary.length > 500) {
        check_resp.innerHTML = 
                `<label>Too many characters in commentary</label>`;
        return -1;
    }
    if(signer.id === null) {
        check_resp.innerHTML = 
                `<label>ID is required</label>`;
        return -1;
    }
}

function validateKey(key) {
    if(key.key === null) {
        check_resp.innerHTML = 
                `<label>Key must be a number</label>`;
        return -1;
    }
}

function submit() {
    for(const x of SIGNER_FIELDS) {
        signer[x] = document.getElementsByName(x)[0].value.trim();
    }
    
    if(validateSigner(signer) === -1) return;
    
    json_body["signer"] = signer;
    
    for(const x of KEY_FIELDS) {
        json_body[x] = document.getElementsByName(x)[0].value.trim();
    }
    
    if(validateKey(json_body) === -1) return;
    
    const request = new XMLHttpRequest();
    
    request.open("PUT", EDIT_URL, true);
    request.setRequestHeader("Content-Type", "application/json");
    
    request.onreadystatechange = function() {
        if(request.readyState === 4 && request.status === 200){
            window.location.href = "success/success.html";
        }
    };
    
    request.send(JSON.stringify(json_body));
    
};
