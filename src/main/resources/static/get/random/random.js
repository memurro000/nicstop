function displaySignerInSingle(signer, single_note){
    for(var x in signer) {
        if(x !== 'ip'){
            if(signer[x] === true ) signer[x] = 'Yes';
            if(signer[x] === false) signer[x] = 'No';
            console.log(x);
            var format = x.replace(/([A-Z])/g, " $1");
            format = format.charAt(0).toUpperCase() + format.slice(1);
            single_note.innerHTML += 
                `<div><b>${format}: </b><label>${signer[x] || ''}</label></div>`;
        }
        
    }
    
}

const http = new XMLHttpRequest();
const url = '/api/v1/signers/get/random';
http.open("GET", url, true);
http.send();

http.onreadystatechange = (e) => {
    console.log("Answer ready state: " + http.readyState);
    console.log(http.responseText);
    
    if(!(http.status >= 200 && http.status < 300)){
        console.log("Trouble!");
    }

    if(http.readyState === 4){
        console.log("Answer status: " + http.status);

        const data = JSON.parse(http.responseText);
       
        const note = document.getElementById("resp_div");

        displaySignerInSingle(data, note);
        
    }
};


