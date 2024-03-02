const http = new XMLHttpRequest();
const url = '/api/v1/signers/get/random';
http.open("GET", url);
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
        
        const note = 
                document.getElementById("resp_div");
    

        note.innerHTML += `<b>ID: </b>${data.id                           || ''    } `;
        note.innerHTML += `<b>Age: </b>${data.age                         || ''    } `;
        note.innerHTML += `<b>Experience: </b>${data.experience           || ''    } `;
        note.innerHTML += `<b>Kind of Nicotine: </b>${data.kindOfNicotine || ''    } `;
        note.innerHTML += 
                `<b>Physically Affected: </b>${data.physicallyAffected ? 'Yes' : 'No'} `;
        note.innerHTML += 
                `<p></p><b>Commentary: </b>
                 <p></p>${data.commentary} `;
    }
};


