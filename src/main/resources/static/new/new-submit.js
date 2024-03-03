const REG_URL = "/api/v1/signers/new";

const check_resp = document.getElementById("check_resp");

const FIELDS = [ 
    "age", 
    "experience", 
    "physicallyAffected",
    "kindOfNicotine",
    "commentary"
];

const signer = {};

function validate(signer){
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
}

function submit() {
    for(const x of FIELDS) {
        signer[x] = document.getElementsByName(x)[0].value.trim();
    }
    
    if(validate(signer) === -1) return;
    
    const request = new XMLHttpRequest();
    
    request.open("POST", REG_URL, true);
    request.setRequestHeader("Content-Type", "application/json");
    
    request.onreadystatechange = function() {
        if(request.readyState === 4 && request.status === 200){
            sessionStorage.setItem("signer_key", request.responseText);
            window.location.href = "token/token.html";
        }
    };
    
    request.send(JSON.stringify(signer));
    
    

};
