 $(function(){
	 $("#bankAccount").focus(function(evt){
		$(this).addClass("a");
		if(this.value.length>0){
			a(this);
			d(this);
		}
	 })
	 $("#bankAccount").keyup(function(evt){
			if(this.value.length==0){
				e();
			}else{
				a(this);
			}
			d(this);
	 })
	 $("#bankAccount").blur(function(evt){
			$(this).removeClass("a");
			e();
			this.value=this.value
	 })
	 $("#bankAccount2").focus(function(evt){
		$(this).addClass("a");
		if(this.value.length>0){
			a(this);
			d(this);
		}
	 })
	 $("#bankAccount2").keyup(function(evt){
			if(this.value.length==0){
				e();
			}else{
				a(this);
			}
			d(this);
	 })
	 $("#bankAccount2").blur(function(evt){
			$(this).removeClass("a");
			e();
			this.value=this.value
	 })
 })
//����div��left��top����ʾdiv
function a(evt){
	var y = 20;
	y = $(evt).outerHeight();
	$("#textMag").removeClass("fn-hide");
	var t = $(evt).offset().top;
	var l = $(evt).offset().left;
	$("#textMag").css({
				"top": (t+y) + "px",
				"left":l + "px"
			});	
}
//����div
function e(){
	$("#textMag").addClass("fn-hide")
}
//����div����ʾ������
function d(e){
	var i = e.value;
	i=$.trim(i);
	var h=i.substring(0,4);
	i=i.substring(4);
	while(i&&i.length>0){
		h+="-"+i.substring(0,4);
		i=i.substring(4)
	}
	$("#mag-text").html(h);
}