var transparentDemo = true;
var fixedTop = false;

$(window).scroll(function(e) {
    oVal = ($(window).scrollTop() / 400);
    $(".blur").css("opacity", oVal);
    
});

$(window).scroll(function(){
    $(".myheading").css("opacity", 1 - $(window).scrollTop() / 250);
});

$(window).scroll(function(){
    $(".myheadingpart").css("opacity", 1 - $(window).scrollTop() / 250);
});