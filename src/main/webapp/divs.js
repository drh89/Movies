var divs = document.getElementsByTagName("div");
var div1 = document.getElementById("div1");
var div2 = document.getElementById("div2");
var div3 = document.getElementById("div3");
var btn = document.getElementById("btn");

function color() {

//    for (var i = 0; i < divs.length; i++) {
//        divs[i].style.background = "green";
//    }
    divs.forEach(e=> style.backgroundColor = "green");

}
function colorClick() {

    document.getElementById("div1").style.backgroundColor = "blue";
    document.getElementById("div2").style.backgroundColor = "green";
    document.getElementById("div3").style.backgroundColor = "purple";

}
onload = color;
btn.onclick = colorClick;