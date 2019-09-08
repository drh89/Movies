var btnall = document.getElementById("btnall");
var table = document.getElementById("table");
var text = document.getElementById("text");
var btndetail = document.getElementById("btndetail");


function getAllMovies() {
    event.preventDefault();
    let url = "http://localhost:8080/jpareststarter/api/movie/all";
//    var conf = {menthod: "get"};
    console.log(text);
    fetch(url)
            .then(res => res.json())
            .then(data => {
                console.log("data", data);

        table.innerHTML = "<tr><th>id</th><th>Name</th></tr>";
        data.forEach(m => 
                table.innerHTML += "<tr>"+ 
                "<td>" + m.id +"</td>" +        
                "<td>" + m.movieName +"</td>" +        
                       
                
                "</tr>");
       
            })
}

function getMovie(){
    event.preventDefault();
    let url = "http://localhost:8080/jpareststarter/api/movie/name/" + text.value;
    fetch(url).then(res=> res.json()).then(data=> {
        console.log("data", data);
        
        table.innerHTML = "<tr><th>id</th><th>Name</th><th>Type</th><th>Length</th><th>Score</th></tr>";
        table.innerHTML += "<td>" + data.id + "</td><td>" + data.movieName + "</td>" +
                "<td>" + data.movieType + "</td><td>" + data.movieLength + "</td><td>" + 
                data.imdbScore + "</td></tr>";
    })
}

btnall.addEventListener("click", getAllMovies);
btndetail.addEventListener("click", getMovie);