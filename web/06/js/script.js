function startFreeTrial(){
  let emailHolder = document.getElementById("email-holder").value;
  if((emailHolder.indexOf("@") == -1) || (emailHolder.indexOf(".com") == -1)){
    alert("Incorrect email!");
  }
  else{
    alert("Check your email for next steps");
  }
}
function buttonMouseOver(){
    document.getElementById("buy-button").style.backgroundColor = "#f3f2f3";
    document.getElementById("buy-button").style.color = "#212021";

}
function buttonMouseOut(){

  document.getElementById("buy-button").style.backgroundColor = "#212021";
  document.getElementById("buy-button").style.color = "white";
}
function buttonMouseDown(){
  document.getElementById("buy-button").style.backgroundColor = "#827d82";
  document.getElementById("buy-button").style.color = "white";
}

let discountClock = setInterval(discountFunk, 1000);
let discountDate = new Date("01 Jan 1970 03:28:30 GMT+3");
let secconds = 5;
function discountFunk() {
  document.getElementById("clock").innerHTML = "Limited time ofter! " + discountDate.toLocaleTimeString() + " left.";
  if(secconds == 0){
    secconds = 59;
  }
  discountDate.setSeconds(secconds--);
}

function companyIconsOnMouseOver(number){
  document.getElementById('company-icons').getElementsByTagName("img")[number].style.width = "12%";
}
function companyIconsOnMouseOut(number){
  document.getElementById('company-icons').getElementsByTagName("img")[number].style.width = "7%";
}


// function rainbowMouseOver(){
//   let rainbowColors = ["#FF0000", "#FF7F00", "#FFFF00", "#00FF00", "#0000FF", "#2E2B5F", "#8B00FF"];
// }
