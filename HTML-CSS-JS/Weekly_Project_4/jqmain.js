$(document).ready(function(){

    $(".hoverarrow").hover(function(){
        $(this).css("background-size","30px 30px");
    }, function(){
        $(this).css("background-size","20px 20px");
    });

    $(".dealoptions > select").hover(function(){
        $(this).css("background-size","25px 25px");
    }, function(){
        $(this).css("background-size","20px 20px");
    });

    $("#room, #checkin, #checkout").hover(function(){
        $(this).css("background-color", "rgb(142, 214, 240)");
    }, function(){
        $(this).css("background-color", "white")
    });
    $("#search").hover(function(){
        $(this).css("background-size", "30px 30px");
    }, function(){
        $(this).css("background-size", "25px 25px")
    });
    $("#recomm > select").hover(function(){
        $(this).css("background-size", "30px 30px");
    }, function(){
        $(this).css("background-size", "25px 25px")
    });

    $("#submit").hover(function(){
        $(this).css("background-color", "rgb(88, 193, 231)");
    }, function(){
        $(this).css("background-color", "rgb(0, 127, 173)")
    });

    $("#mapbutton > button").hover(function(){
        $(this).css("background-color", "rgb(88, 193, 231)");
    }, function(){
        $(this).css("background-color", "rgb(255, 255, 255)")
    });


    $(".buttonclass").hover(function(){
        $(this).css("background-size","30px 30px");
    }, function(){
        $(this).css("background-size","20px 20px");
    });

    $("#heart").hover(function(){
        $(this).attr("width","30px").attr("height","30px");
    }, function(){
        $(this).attr("width","25px").attr("height","25px");
    });

    $("#heart").click(function(){
        if($(this).attr("src")=="/media/eheart.png"){
        $(this).attr("src","/media/fheart.png");
    }   else if($(this).attr("src")=="/media/fheart.png"){
        $(this).attr("src","/media/eheart.png");
    }
    });
    $("#heart2").hover(function(){
        $(this).attr("width","30px").attr("height","30px");
    }, function(){
        $(this).attr("width","25px").attr("height","25px");
    });

    $("#heart2").click(function(){
        if($(this).attr("src")=="/media/eheart.png"){
        $(this).attr("src","/media/fheart.png");
    }   else if($(this).attr("src")=="/media/fheart.png"){
        $(this).attr("src","/media/eheart.png");
    }
    });
    
    $(".choice1, .choice2, .choice3, .choice11, .choice22, .choice33").hover(function(){
        $(this).css("background-color","rgb(193, 214, 253)");   
    }, function(){
        $(this).css("background-color","white");
    });

    /*Sta parakatw, pou einai oi prosfores pou emfanizontai sto 'View Deal'
      kollisa me ta innerHTML kai tis klaseis tous kai to ekana mpakalika */

    $(".choice1").click(function(){
        //$("#inputsite").replaceWith("<h3>Agoda</h3>");
        $("#inputsite").html("<h3>Hotel Website</h3>");
        //$("#inputprice").replaceWith("<h3><b>$575</b></h3>");
        $("#inputprice").html("<h3><b>$706</b></h3>");
    });

    $(".choice2").click(function(){
        //$("#inputsite").replaceWith("<h3>Agoda</h3>");
        $("#inputsite").html("<h3>Agoda</h3>");
        //$("#inputprice").replaceWith("<h3><b>$575</b></h3>");
        $("#inputprice").html("<h3><b>$575</b></h3>");
    });

    $(".choice3").click(function(){
        //$("#inputsite").replaceWith("<h3>Travelocity</h3>");
        $("#inputsite").html("<h3>Travelocity</h3>");
        //$("#inputprice").replaceWith("<h3><b>$708</b></h3>");
        $("#inputprice").html("<h3><b>$708</b></h3>");
    });



    $(".choice11").click(function(){
        //$("#inputsite").replaceWith("<h3>Agoda</h3>");
        $("#inputsite1").html("<h3>Orbitz</h3>");
        //$("#inputprice").replaceWith("<h3><b>$575</b></h3>");
        $("#inputprice1").html("<h3><b>$1.213</b></h3>");
    });

    $(".choice22").click(function(){
        //$("#inputsite").replaceWith("<h3>Agoda</h3>");
        $("#inputsite1").html("<h3>Trip.com</h3>");
        //$("#inputprice").replaceWith("<h3><b>$575</b></h3>");
        $("#inputprice1").html("<h3><b>$1.249</b></h3>");
    });

    $(".choice33").click(function(){
        //$("#inputsite").replaceWith("<h3>Travelocity</h3>");
        $("#inputsite1").html("<h3>Expedia</h3>");
        //$("#inputprice").replaceWith("<h3><b>$708</b></h3>");
        $("#inputprice1").html("<h3><b>$1.215</b></h3>");
    });


 

   
});
