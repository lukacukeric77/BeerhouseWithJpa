document.getElementsByName("items").oninvalid = function() {
    this.setCustomValidity("Obligated");
};
document.querySelector("form").onsubmit = function() {
  this.querySelector("button").disabled = true;
};
