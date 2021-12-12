const header = document.getElementsByTagName("header")[0];
//(header.offsetTop + header.offsetHeight >= window.scrollY)
window.addEventListener("scroll", event => {
  if (window.scrollY >= document.getElementsByClassName("slideshow-container")[0].offsetHeight-(header.offsetHeight+30)) {
    header.classList.add("sticky");
  } else{
    header.classList.remove("sticky");
  }
});

let slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}
setInterval(function(){showSlides(slideIndex+=1)}, 4000);

function showSlides(n) {
  var slides = document.getElementsByClassName("topSlides");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (let i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  slides[slideIndex-1].style.display = "block";
}
let triggered = false;
let lastCountry;
function airplaneFly(country){
  if(!triggered && country != lastCountry){
    triggered = true;
    let countryImg = document.getElementById("country-1");
    switch (country) {
      case "Paris":
        countryImg.src = "../img/france.png";
        flyFly("37%", "3%", 0);
        setTimeout(function() {triggered = false;}, 2200);
        break;
      case "London":
        countryImg.src = "../img/britain.png";
        flyFly("39%", "14.5%", 1);
        setTimeout(function() {triggered = false;}, 2200);
        break;
      case "Berlin":
        countryImg.src = "../img/germany.png";
        flyFly("40%", "3%", 2);
        setTimeout(function() {triggered = false;}, 2200);
        break;
      case "Barcelona":
        countryImg.src = "../img/spain.png";
        flyFly("42%", "2.5%", 3);
        setTimeout(function() {triggered = false;}, 2200);
        break;
    }
    lastCountry = country;
  }
}

function flyFly(startLeft, startTop, element){
  $("#plane").stop();
  let plane = document.getElementById("plane");
  plane.style.left = startLeft;
  plane.style.marginTop = startTop;
  document.getElementsByClassName("c-destination")[element].style.color = "#ff8000";
  document.getElementsByClassName("c-duration")[element].style.color = "black";
  $(document).ready(function(){
    $("#plane").animate({left: "69%", marginTop: "3%"}, 2200,'linear');
  });
}

function countryReturn(number){
  setTimeout(function() {
    document.getElementsByClassName("c-destination")[number].style.color = "black";
    document.getElementsByClassName("c-duration")[number].style.color = "rgba(128, 128, 128, 0.35)";
  }, 1000);
}
