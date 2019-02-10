/*=================== CHECKIN CHECKOUT DATE CORELLATION =============*/

window.addEventListener("load", function () {

    let price = document.getElementById("maxprice-input"),
        spanaki = document.getElementById("maximumpr");
    let datein = document.getElementById('checkin'),
        dateout = document.getElementById('checkout');
        
    let today = new Date().toISOString().split('T')[0];


    document.getElementsByName("checkin")[0].setAttribute('min', today);
    document.getElementsByName("checkout")[0].setAttribute('min', today);    
    price.addEventListener("input", function () {
        spanaki.innerHTML = "Max Price: $" + price.value;
    }, false);

    datein.addEventListener("input", function () {
        dateout.min = datein.value;
        
    });
    dateout.addEventListener("input", function(){
        
        datein.max = dateout.value;
    })
    

});


/*============ MODAL MAP ======================================*/

$(document).ready(function() {
    let map = null;
    let myMarker;
    let myLatlng;
  
    function initializeGMap(lat, lng) {
      myLatlng = new google.maps.LatLng(lat, lng);
  
      let myOptions = {
        zoom: 12,
        zoomControl: true,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
      };
  
      map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
  
      myMarker = new google.maps.Marker({
        position: myLatlng
      });
      myMarker.setMap(map);
    }
  
    // Re-init map before show modal
    $('#myModal').on('show.bs.modal', function(event) {
      let button = $(event.relatedTarget);
      initializeGMap(button.data('lat'), button.data('lng'));
      $("#location-map").css("width", "100%");
      $("#map_canvas").css("width", "100%");
    });
  
    // Trigger map resize event after modal shown
    $('#myModal').on('shown.bs.modal', function() {
      google.maps.event.trigger(map, "resize");
      map.setCenter(myLatlng);
    });
  });