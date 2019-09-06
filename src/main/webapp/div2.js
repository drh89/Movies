
var names = ["Dennis", "Christian", "Henning", "Emil"];
var divMaster = document.getElementById("master");

function text(evt){
    var div = evt.target;
    console.log(div.id);
//    this = document.getElementsById(div.id)
//    this.innerText = "Hello from " + div.id;
    document.getElementById("p1").innerText = div.id;
    
//divMaster.forEach(d=> this.innerHTML = "<p> Hello from " + this.id + "</p>");
};
//divMaster.addEventListener("click",text);


function makeList(arr){
    var list = arr.map(function(name){
        return "<li>" + name + "</li>";
    })
    return "<ul>" + list.join("") + "</ul>";
};
function load(){
    document.getElementById("namelist").innerHTML = makeList(names);
    console.log(makeList(names));
}
onload = load;
//document.getElementById("namelist").innerHTML = makeList(names);
document.getElementById("btnadd").addEventListener("click", function(){
    var nta = document.getElementById("addname").value;
    names.push(nta);
    document.getElementById("namelist").innerHTML = makeList(names);
});

