const SCREEN_WIDTH = window.innerWidth;

if(SCREEN_WIDTH < 1200) {
    $(function(){
        $("#header").load("/header-mobile.html"); 
    });
} 
else {
    $(function(){
        $("#header").load("/header.html"); 
    });
}


