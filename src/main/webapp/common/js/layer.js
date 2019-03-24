function shieldDiv(){
    var me = this;
    var shield;
    var c = 0;
    var ad;
    if(document.getElementById("shield")){
        shield = document.getElementById("shield");
        shield.style.position = "absolute";
        shield.style.display = "block";
        shield.style.filter = "alpha(opacity=0)";
        shield.style.opacity = 0;
    }else{
        shield = document.getElementById("divSpan");
        shield.id = "shield";
        shield.style.position = "absolute";
        shield.style.display = "block";
        shield.style.padding = "10px";
        shield.style.left = "30%";
        shield.style.top = "10%";
        shield.style.width = "40%";
        shield.style.height = "200px";
        shield.style.background = "#666";
        shield.style.textAlign = "center";
        shield.style.zIndex = "10";
        shield.style.filter = "alpha(opacity=0)";
        shield.style.opacity = 0;
    	
        document.body.appendChild(shield);
    }
    me.setOpacity = function(obj,opacity){
	    if(document.all)
	        obj.style.filter="alpha(opacity=\"" + opacity + "\")";
	    else
	        obj.style.opacity=opacity/100;
    }
    me.doAlpha = function(){
        c+=2;
	    if(c>80){clearInterval(ad);return 0;}
	    me.setOpacity(shield,c);
    }
    me.show = function(){
        ad = setInterval(me.doAlpha,1);
    }
    me.hide = function(){
        if(document.getElementById("shield"))
            document.getElementById("shield").style.display = "none";
    }
}
