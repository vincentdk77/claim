function submit1(){
	var policyNo = document.getElementById("policyNo").value.trim();
	var registNo = document.getElementById("registNo").value.trim();
	var claimNo = document.getElementById("claimNo").value.trim();
	var compensateNo = document.getElementById("compensateNo").value.trim();
	var caseNo = document.getElementById("caseNo").value.trim();
	var noList = document.getElementById("noList").value.trim();
	var nolists = noList.split("\n");
	var flag = true;
	for(var i =0;i<nolists.length;i++){
		if(""!=nolists[i].trim()){
			flag = false;
		}
	}
	var fm = document.getElementById("fm");
	if(flag&&policyNo==""&&registNo==""&&claimNo==""&&compensateNo==""&&caseNo==""){
		alert("请至少输入一个查询条件");
		return false;
	}
	fm.backButton.disabled=true;
	fm.submit();
	setTimeout('fm.backButton.disabled=false',5000);
}