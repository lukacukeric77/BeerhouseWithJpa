document.getElementsByName("aantal").oninvalid = function() {
    this.setCustomValidity("Verplicht");
};
document.querySelector("form").onsubmit = function() {
  this.querySelector("button").disabled = true;
};
