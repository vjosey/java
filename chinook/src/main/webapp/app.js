document.getElementById('add').addEventListener('submit', 
    function(e){
       e.preventDefault(); // stops expecting a page refresh
       console.log('axios post')
       let artist = {
           name: document.getElementById('artist').value
       };
       var id = 5;
       let api = `http://localhost:8080/chinook/api/artist?id=${id}` 
       // template literal (string interpolation)
       console.log(id);
       let url = '/chinook/api/artist';
       let promise = axios.post(url, artist);
       // 1 callback for a successful response
       promise.then(response => {
           // 2xx
           console.log(response);
           // add to the table
           appendArtist(response.data);
           // clear the form
           document.getElementById('artist').value = null;
       });
       // another callback for a failed response
       promise.catch(function(response){
           // 4xx or 5xx
           console.log(response);
       });
       //axios.post('','').then(function(){}).catch(function(){});
    });


document.addEventListener('DOMContentLoaded', function(){
    // ajax call (XMLHttpRequest: xhr) to fetch artists
    var xhr = new XMLHttpRequest();
    // ready state 0 - unopened
    xhr.open('GET', '/chinook/api/artist');
    // ready state 1 - opened
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState === 4 && xhr.status === 200){
            // parse HTTP response body
            var json = JSON.parse(xhr.responseText);
            console.log(json);
            artistification(json);
        }
    };

    xhr.send(); // creating HTTP request, and send to server async
    // ready state 2 - headers received
    // ready state 3 - responseText has partial data
    // ready state 4 - xhr request DONE
    console.log('Sent');
});

function artistification(list){
    for(let artist of list){
        appendArtist(artist);
    }
};

function appendArtist(artist){
    // template logic
    let tr = document.createElement('tr');
    let id = document.createElement('td');
    id.innerText = artist.artistId;
    let name = document.createElement('td');
    name.innerText = artist.name;
    tr.appendChild(id); 
    tr.appendChild(name);
    document.getElementById('list').appendChild(tr);
};