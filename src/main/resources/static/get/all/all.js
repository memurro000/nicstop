const TABLE_HEADERS = ["ID", "Age", "Experience", 
    "Kind of Nicotine", "Physically Affected"];

const http = new XMLHttpRequest();
const url = '/api/v1/signers/get/all';
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

        var data = JSON.parse(http.responseText);
        
        const table = 
                document.getElementById("resp_div")
                .appendChild(document.createElement("table"));
        
        const header = table.createTHead();
        var row = header.insertRow();
        for(const x in TABLE_HEADERS) {
            row.innerHTML += `<th>${TABLE_HEADERS[x]}</th>`;
        }        

        for (var i = 0; i < data.length; ++i) {
            row = table.insertRow();
            row.innerHTML += `<td>${data[i].id             || ''    }</td>`;
            row.innerHTML += `<td>${data[i].age            || ''    }</td>`;
            row.innerHTML += `<td>${data[i].experience     || ''    }</td>`;
            row.innerHTML += `<td>${data[i].kindOfNicotine || ''    }</td>`;
            row.innerHTML += 
                    `<td>${data[i].physicallyAffected ? 'Yes' : 'No'}</td>`;

        }

    }
};


