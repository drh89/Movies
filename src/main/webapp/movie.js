


var btnall = document.getElementById("btnall");
var table = document.getElementById("table");


function getAllMovies() {
    event.preventDefault();
    let url = "http://localhost:8080/jpareststarter/api/movie/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                console.log("data", data);
        table.innerHTML = "<table>" + "<tr>" +  
        "<th>id</th><th>Name</th><th>Type</th><th>Length</th><th>Score</th> </tr>";
        data.forEach(m => 
                table.innerHTML += "<tr>"+ 
                "<td>" + m.id +"</td>" +        
                "<td>" + m.movieName +"</td>" +        
                "<td>" + m.movieType +"</td>" +        
                "<td>" + m.movieLength +"</td>" +        
                "<td>" + m.imdbScore +"</td>" +        
                
                "</tr>")
        table.innerHTML += "</table>";
            })
}

btnall.addEventListener("click", getAllMovies);