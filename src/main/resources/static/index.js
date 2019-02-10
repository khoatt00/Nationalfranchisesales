//alert("outside jsp");
var name = "name";
var getName = function() {
	return "Nishant";
}
// var cars1 = ["Saab", "Volvo", "BMW"];
var cars2 = new Array("Saab", "Volvo", "BMW");
var colors = new Array("red", "yellow", "blue", "maroon", "black", "white");
// var cars3 = new Array();
// cars3[0] = "BMW";

function getRandomInt(max) {
	return Math.floor(Math.random() * Math.floor(max));
}

window.onload = function() {
	var index = 0;
	window.setInterval(function() {
		if (index > cars2.length) {
			index = 0;
		}

		document.getElementById("username").value = cars2[getRandomInt(3)];
		index++;
	}, 3000);

	// changing background color
	// window.setInterval(function() {
	// document.body.style.backgroundColor = colors[getRandomInt(3)];
	// index++;
	// }, 1000);
	document.getElementById("check").onclick = function() {
		alert("UserName : " + document.getElementById("username").value);
	}
}

$(document).ready(
		function() {
			$("#getResturants").click(
					function() {
						$.ajax({
							url : "http://localhost:8080/api/resturants",
							success : function(resturants) {
								for (var i = 0; i < resturants.length; i++) {
									var resturant = resturants[i];
									$("#resturantsTbl").append(
											"<tr><td>" + resturant.resturantId
													+ "</td>" + "<td>"
													+ resturant.resturantName
													+ "</td></tr>");
								}
							}

						});
					});
		});
