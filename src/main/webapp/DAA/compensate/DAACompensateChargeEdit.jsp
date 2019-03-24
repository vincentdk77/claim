<%--
****************************************************************************
* DESC       ：添加费用赔款信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
   <!--建立显示的录入条，可以收缩显示的-->
<%@page import="java.util.ArrayList" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLpreChargeDto" %>
<%
	ArrayList prpLpreChargeDtoList = (ArrayList)request.getAttribute("prpLpreChargeDtoList");
	String strRecaseFlag = (String)request.getAttribute("recaseFlag");
%>
    <script language='javascript'>
   
    function  calChargeAmount(field){
      var serialNo =0;
      for ( var i=0 ;i< fm.all(field.name).length ;i++){
        if ( fm.all(field.name)[i] == field )
        {
        	serialNo=i ;
        	break ;
        }
      }
    
     var  chargeReport = fm.all('prpLchargeChargeReport')[serialNo].value ; //费用金额
     var  chargeAmount = 0.0;                                               //实际费用
    // var  kindCode     = fm.all('prpLchargeKindCode')[serialNo].value ;     //险别
     var  chargeCode   = fm.all('prpLchargeChargeCode')[serialNo].value ;   //费用类型
     if(isNaN(chargeReport))   chargeReport = 0;
     if(fm.all('prpLlossDtoKindCodeShow') != null && fm.all('prpLlossDtoKindCodeShow')[1] != null) {
		 var kind = fm.all('prpLlossDtoKindCodeShow')[1].value ;  //标的损失赔款中对应的第一条损失信息的险别
      	 var vPrpLchargeKindCode = fm.all('prpLchargeKindCode')[serialNo].value //险别代码
         if (   kind == 'A' && chargeCode=='03' && vPrpLchargeKindCode != 'B'){
         	  //赔偿比例
           /*	
           if ( !isEmptyField(fm.prpLlossDtoClaimRate) ) {  //防止先录费用后录标的赔款信息，后来控制了必须录入车损信息，才能录施救费，所以这根本用不上，但为防止以后又变，所以先不删除
               var  claimRate  = parseFloat(fm.all('claimRate')[1].value);
            }
            else{  
           	　 var  claimRate  = parseFloat(fm.all('prpLlossDtoClaimRate')[1].value);
            }
          	if (isNaN(claimRate))	{ claimRate = 1 ;     	}else { claimRate =  claimRate/100 ;}
           */
          // 责任比例
            if ( !isEmptyField(fm.prpLlossDtoIndemnityDutyRate) ) {  //防止先录费用后录标的赔款信息，同赔偿比例
             　 var  indemnityDutyRate  = parseFloat(fm.all('indemnityDutyRate')[1].value);
            }
            else{  
            	　 var  indemnityDutyRate  = parseFloat(fm.all('prpLlossDtoIndemnityDutyRate')[1].value);
            }
           	if (isNaN(indemnityDutyRate)){ indemnityDutyRate= 1 ;}else { indemnityDutyRate =indemnityDutyRate/100 }
            
            //绝对免赔率
          	var  deductibleRate  = parseFloat(fm.all('prpLlossDtoDeductibleRate')[1].value);
          	if (isNaN(deductibleRate)){  deductibleRate =0 ;}else { deductibleRate =deductibleRate/100;}
            
            //责任免赔率
          	var  DutyDeductibleRate  = parseFloat(fm.all('prpLlossDtoDutyDeductibleRate')[1].value);
          	if (isNaN(DutyDeductibleRate)){DutyDeductibleRate=0 ; }else {  DutyDeductibleRate =DutyDeductibleRate/100;}
          	var claimRate;      //赔偿比例
          	claimRate =  parseFloat(fm.all('prpLlossDtoClaimRate')[1].value);          	
          	if(isNaN(claimRate)){ claimRate = 1 }else{claimRate = claimRate /100 ;};
          	chargeAmount = chargeReport * claimRate * indemnityDutyRate * (1-deductibleRate) *(1-DutyDeductibleRate );
          	
          	fm.all("prpLchargeChargeAmount")[serialNo].value = point(round(chargeAmount,2),2) ;
        	  fm.all("prpLchargeSumRealPay")[serialNo].value =  point(round(chargeAmount,2),2) ;
        }
       // else  if (chargeCode=='03' && kindCode !='A') {
        	
        	//fm.all("prpLchargeChargeAmount")[serialNo].value = point(round(chargeReport,2),2) ;
        	//fm.all("prpLchargeSumRealPay")[serialNo].value =   point(round(chargeReport,2),2) ;
        	
        //}
        else {  //第一条损失信息不是标的车的情况，或不是施救费
        	fm.all("prpLchargeChargeAmount")[serialNo].value = point(round(chargeReport,2),2) ;
          fm.all("prpLchargeSumRealPay")[serialNo].value = 0.00 ;
        }
      }
  }
  
  /*
    车损险责任比例、责任免赔率、绝对免赔率改变时，重新计算赔款费用的值
  */
  function calChargeAmountAll(){
  	var codeShows = document.getElementsByName("prpLlossDtoKindCodeShow");
  	var reports = document.getElementsByName("prpLchargeChargeReport");
  	var chargeCodes = document.getElementsByName("prpLchargeChargeCode");
  	var dutyRates = document.getElementsByName("indemnityDutyRate");
  	var lossDutyRates = document.getElementsByName("prpLlossDtoIndemnityDutyRate");
  	var deductRates = document.getElementsByName("prpLlossDtoDeductibleRate");
  	var dutyDeductRates = document.getElementsByName("prpLlossDtoDutyDeductibleRate");
  	var amounts = document.getElementsByName("prpLchargeChargeAmount");
  	var realPays = document.getElementsByName("prpLchargeSumRealPay");
  	var claimRates = document.getElementsByName("prpLlossDtoClaimRate");
    if(codeShows != null && codeShows[1] != null) {
        var i ;
        var  chargeReport ; //费用金额
        var  chargeAmount = 0.0;                                               //实际费用    
        var  chargeCode    ;   //费用类型    
        for(i = 0;i < reports.length;i++){
            chargeReport = reports[i].value ; 
            chargeAmount = 0.0; 
            chargeCode   = chargeCodes[i].value ;   
            if(isNaN(chargeReport))   
                chargeReport = 0;
            var kind = codeShows[1].value ;  //标的损失赔款中对应的第一条损失信息的险别
      
         if (   kind == 'A'   && chargeCode=='03'){
            
          // 责任比例
            if ( !isEmptyField(fm.prpLlossDtoIndemnityDutyRate) ) {  //防止先录费用后录标的赔款信息，同赔偿比例
             　 var  indemnityDutyRate  = parseFloat(dutyRates[1].value);
            }
            else{  
                　 var  indemnityDutyRate  = parseFloat(lossDutyRates[1].value);
            }
            if (isNaN(indemnityDutyRate)){ indemnityDutyRate= 1 ;}else { indemnityDutyRate =indemnityDutyRate/100 }
            
            //绝对免赔率
            var  deductibleRate  = parseFloat(deductRates[1].value);
            if (isNaN(deductibleRate)){  deductibleRate =0 ;}else { deductibleRate =deductibleRate/100;}
            
            //责任免赔率
            var  DutyDeductibleRate  = parseFloat(dutyDeductRates[1].value);
            if (isNaN(DutyDeductibleRate)){DutyDeductibleRate=0 ; }else {  DutyDeductibleRate =DutyDeductibleRate/100;}
            //赔偿比例
            var claimRate;     
            claimRate =  parseFloat(claimRates[1].value);           
            if(isNaN(claimRate)){ claimRate = 1 }else{claimRate = claimRate /100 ;};
            //施救费计算
            chargeAmount = chargeReport * claimRate * indemnityDutyRate * (1-deductibleRate) *(1-DutyDeductibleRate );
            
            amounts[i].value = point(round(chargeAmount,2),2) ;
            realPays[i].value =  point(round(chargeAmount,2),2) ;
        }       
        
        }
    }
  }
  
  function  changeChargeAmount(){
    	
        	  if ( fm.all('prpLlossDtoKindCode')[1].value =='A') {
        	      var  chargeNumber = fm.all("prpLchargeChargeReport").length;
        	      //赔偿比例
        	      var  claimRate  = parseFloat(fm.all('prpLlossDtoClaimRate')[1].value);
        	      if (isNaN(claimRate))	{ claimRate = 1 ;     	}else { claimRate =  claimRate/100 ;}
        	      //责任比例	
        	      var  indemnityDutyRate  = parseFloat(fm.all('prpLlossDtoIndemnityDutyRate')[1].value);
        	      if (isNaN(indemnityDutyRate)){ indemnityDutyRate= 1 ;}else { indemnityDutyRate =indemnityDutyRate/100 }
        	      //绝对免赔率
        	      var  deductibleRate  = parseFloat(fm.all('prpLlossDtoDeductibleRate')[1].value);
        	      if (isNaN(deductibleRate)){  deductibleRate =0 ;}else { deductibleRate =deductibleRate/100;}
                //责任免赔率
        	      var  DutyDeductibleRate  = parseFloat(fm.all('prpLlossDtoDutyDeductibleRate')[1].value);
        	      if (isNaN(DutyDeductibleRate)){DutyDeductibleRate=0 ; }else {  DutyDeductibleRate =DutyDeductibleRate/100;}
        	  
        	     if( chargeNumber != 'undefined' && chargeNumber >1){
        	       for (var i=0; i< chargeNumber ;i++ ){
        	     	  var  chargeReport = fm.all('prpLchargeChargeReport')[i].value ; //费用金额        
                      var  chargeAmount = 0.0;        //实际费用 
                      var  chargeCode   = fm.all('prpLchargeChargeCode')[i].value ;   //费用类型 
                      if ( '03'==chargeCode && fm.all("prpLchargeKindCode")[i].value != "B")  {
                      	  chargeAmount = chargeReport * ( claimRate ) * indemnityDutyRate * (1-deductibleRate) *(1-DutyDeductibleRate );
                          fm.all("prpLchargeChargeAmount")[i].value = point(round(chargeAmount,2),2) ;
      	                  fm.all("prpLchargeSumRealPay")[i].value =  point(round(chargeAmount,2),2) ; 	 
                      }      
                  }                                          
       	  	   }
        	  } 
     }
     
        
     
    function  checkChargeCode(field){
	  var serialNo =0;
	  //定位
      for ( var i=0 ;i< fm.all(field.name).length ;i++){
        if ( fm.all(field.name)[i] == field )
        {
        	serialNo=i ;
        	break ;
        }
      }
      var chargeCode = fm.prpLchargeChargeCode[serialNo].value; //费用类别
      var vPrpLchargeKindCode = fm.prpLchargeKindCode[serialNo].value; //险别代码
      //如果为第三者责任保险的施救费，则计入赔款金额不由实际费用连带出来，而是让用户输入,由只读设为可输入
      if(chargeCode == '03' && vPrpLchargeKindCode == 'B' )
      {
      	fm.prpLchargeSumRealPay[serialNo].readOnly = false;
      	fm.prpLchargeSumRealPay[serialNo].className = "input";
      }else
      {
        fm.prpLchargeSumRealPay[serialNo].readOnly = true;
      	fm.prpLchargeSumRealPay[serialNo].className = "readonly";
      }
      if(fm.all("prpLlossDtoKindCode") != null && fm.all("prpLlossDtoKindCode").length != null) {
     	  var  kindCodeNum = fm.all("prpLlossDtoKindCode").length;
     	  if( kindCodeNum!='undefined' && kindCodeNum >1 ) {
     	  	  var  kindCode = fm.all("prpLlossDtoKindCode")[1].value; 
     	  	  if (kindCode !='A' && field.value=='施救费' ) {
     	  	  	 alert ( " 没有录入车损信息，不能录入施救费用");
     	  	  	 field.value = "";
     	  	  	 field.focus();
     	  	  	 return false;
     	  	  } 
     	  	  
     	  }else {
     	  	 if ( field.value=='施救费')  {
     	  	   alert ( " 没有录入车损信息，不能录入施救费用");
     	  	   field.value = "";
     	  	   field.focus();
     	  	   return false;
     	  	 }
     	  }
      }
      
      if(chargeCode=='14'){
        fm.prpLchargeCheckDeptName[serialNo].style.display="";
      }else{
        fm.prpLchargeCheckDeptName[serialNo].style.display="none";
        fm.prpLchargeCheckDeptCode[serialNo].value="";
        fm.prpLchargeCheckDeptName[serialNo].value="";
      }

      if(fm.all("prpLchargeKindCode") != null && fm.all("prpLchargeKindCode").length != null) {
     	  var  kindCodeNum = fm.all("prpLchargeKindCode").length;
     	  if( kindCodeNum!='undefined' && kindCodeNum >1 ) {         	  
     	  	  var i = 0;
     	  	  for(i = 0 ; i < fm.all("prpLchargeKindCode").length;i++){
     	  	       if(fm.all("prpLchargeChargeCode")[i] != null 
     	  	                 && fm.all("prpLchargeChargeName")[i].value == "施救费"
     	  	                 && fm.all("prpLchargeKindCode")[i].value != "A"
     	  	                 && fm.all("prpLchargeKindCode")[i].value != "B"){
     	  	           alert ( "只有车辆损失险和第三者责任保险才能录入施救费" );
     	  	           fm.all("prpLchargeChargeCode")[i].value = "";
     	  	           fm.all("prpLchargeChargeName")[i].value = "";
     	  	           field.focus();
                       return false;
     	  	       }
     	  	  }
     	  }    	      	      	 
      }
      if(fm.prpLregistExtRiskCode.value=='0506'||fm.prpLregistExtRiskCode.value=='0507'
      ||fm.prpLregistExtRiskCode.value=='0576'||fm.prpLregistExtRiskCode.value=='0577'
      ||fm.prpLregistExtRiskCode.value=='0586'||fm.prpLregistExtRiskCode.value=='0587')
      {
         
             for(i = 0 ; i < fm.all("prpLchargeKindCode").length;i++){
             if(fm.all("prpLchargeChargeCode")[i] != null 
     	  	                 && fm.all("prpLchargeChargeName")[i].value == "公估费")
     	  	                 {
     	  	                     alert ( "车险不能录入公估费！" );
     	  	                     fm.all("prpLchargeChargeCode")[i].value = "";
     	  	                     fm.all("prpLchargeChargeName")[i].value = "";
     	  	                     field.focus();
                                 return false;
     	  	                 }
             }
      }
      
   }
    
     
      //在下面加入本页自定义的JavaScript方法

        /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertCharge()
      {
        setPrpLchargeSerialNo();
        calFund();
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteCharge(field)
      {
        setPrpLchargeSerialNo();
        calFund();
      }

        /**
         * 设置setPrpLchargeSerialNo
         */
        function setPrpLchargeSerialNo(){
            var count=getElementCount("prpLchargeSerialNo");
            for(var i=0;i<count;i++)
            {
                //alert("看看什么时候运行?count="+count+"  i="+i);
                if(count!=1){
                    fm.prpLchargeSerialNo[i].value=i;
                }
            }
        }
		//使用xmlhttp访问页面，并获取xml数据
		function getResponseXml(strURL)
		{
		  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		  objXmlHttp.Open("POST",strURL,false);
		  objXmlHttp.setRequestHeader("Content-type","text/xml");
		  objXmlHttp.Send("");
		  if(objXmlHttp.status==200)
		  {    
		    return objXmlHttp.responseXML;
		  }
		  else if(objXmlHttp.status==404)
		  {
		    alert("找不到页面："+ strURL);
		    return "";
		  }
		  else
		  {
		    alert("访问"+ strURL +"出错，错误号："+objXmlHttp.status);
		    return "";
		  }
		}
        function setPrpLpreChargeAmount(field){
        	var serialNo =0;
	        for ( var i=0 ;i< fm.all(field.name).length ;i++){
	          if ( fm.all(field.name)[i] == field )
	          {
	        	  serialNo=i ;
	        	  break ;
	          }
	        }
        	var kindCode = fm.prpLchargeKindCode[serialNo].value;
        	var chargeCode = fm.prpLchargeChargeCode[serialNo].value;
        	var preClaimNo = fm.preClaimNo.value;
        	var strRecaseFlag = fm.strRecaseFlag.value;
        	var vURL = "/claim/common/prepay/queryPreCharge.jsp?kindCode="+kindCode+"&chargeCode="+chargeCode+"&preClaimNo="+preClaimNo+"&strRecaseFlag="+strRecaseFlag;;
        	var strXml = getResponseXml(vURL);
        	var sumPreChargeAmount     = (strXml.documentElement).getElementsByTagName('sumPreChargeAmount')[0].text;
        	fm.prpLpreChargeAmount[serialNo].value=sumPreChargeAmount;
        	
        }
   </script>

   <table class="common" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="5" style="text-align:left">
      <input type="hidden" name="preClaimNo" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">
       <input type="hidden" name="strRecaseFlag" value="<%=strRecaseFlag %>">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge);changeCompensateFlag('1');">费用赔款信息<br>
        <span style="display:none">
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="input" style="width:4%">
                  <input type="text" class="readonly" readonly="readonly" style="width: 100%" name="prpLlossDtoItemKindNoForCharge">
                </td>
                <td class="input" style="width:4%">
                  <input type="hidden"  name="prpLchargeFlag">
                  <input type="hidden"  name="prpLchargeSerialNo" description="序号">
                  <input name="prpLchargeKindCode" class="codecode" style="width:100%" maxlength="3"
                         ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-3','code');"
                         onchange="code_CodeChange(this, 'PolicyKindCode','1,-3','code');setSumDutyDeductibleFlag('0');setFlagDanger();setPrpLpreChargeAmount(this);"
                         onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-3','code');"
                         onblur="checkChargeCode(this);">
                </td>
                
                <td class="input" style="width:8%">
                  <input name="prpLchargeKindName" class="codename" style="width:100%"
			                   ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');"
			                   onchange="code_CodeChange(this, 'PolicyKindCode','-1,-4','name','none','post');setSumDutyDeductibleFlag('0');setFlagDanger();setPrpLpreChargeAmount(this);"
			                   onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');" 
			                   onblur="checkChargeCode(this);">
                </td>
                
                <td class="input" style="width:6%">
                  <input name="prpLchargeChargeCode" class="codecode" style="width:100%"
                         ondblclick="code_CodeSelect(this, 'ChargeCode1');"
                         onchange="code_CodeChange(this, 'ChargeCode1');setPrpLpreChargeAmount(this); "
                         onkeyup= "code_CodeSelect(this, 'ChargeCode1'); "
                         onblur="checkChargeCode(this);calChargeAmount(this);setRealPay();">
                </td>
                
                <td class="input" style="width:8%" >
                  <input name="prpLchargeChargeName" class="codename" style="width:100%"
			                   ondblclick="code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			                   onchange="code_CodeChange(this, 'ChargeCode1','-1','name','none','post');setSumDutyDeductibleFlag('0');setFlagDanger();setPrpLpreChargeAmount(this);"
			                   onkeyup= "code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			                   onblur=" checkChargeCode(this); calChargeAmount(this); setRealPay();">
                </td>
                
                <td class="input" style="width:9%" >
                   <input type=hidden class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="具体单位" value=""
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                   >
                  <input type=text class="codecode" name="prpLchargeCheckDeptName"  title="具体单位" style="display:none;width:100%" maxLength="50" description="查勘处理单位" value=""
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    >
                </td>
                
                <td class="input" style="width:5%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" selected>外部</option>
                    <option value="A">内部</option>
                  </select>
                </td>
                
                <td class="input" style="width:8%">
                  <input name="prpLchargePayObjectCode" class="readonly" readonly  style="width:80%" value="">
                </td>
                
                <td class="input" style="width:8%" >
                  <input name="prpLchargePayObjectName" class="codename" style="width:100%" value="" 
                         ondblclick="code_CodeSelect(this, 'PayObject','-1','name','none','post');"
			                   onchange="code_CodeChange(this, 'PayObject','-1','name','none','post');"
			                   onkeyup= "code_CodeSelect(this, 'PayObject','-1','name','none','post');"
			                   onblur="">
                </td>
                
                <td class="input" style="width:6%">
                  <input name="prpLchargeCurrency" class="readonly" style="width:100%" value="CNY">
                </td>
                
                <td class="input" style="width:8%">
                  <input name="prpLchargeChargeReport" class="input" style="width:100%" 
                         onchange="calChargeAmount(this);setSumDutyDeductibleFlag('0');setFlagDanger(); " 
                         onblur=" checkChargeAmount(this);  calChargeAmount(this); ">
                </td>
                 <td class="input" style="width:8%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" 
                         onchange="calFund();setFlagDanger();" 
                         onblur="checkChargeAmount(this);">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLchargeSumRealPay" type="text" style="width:100%" class='readonly' readonly
						 onchange="calFund();setFlagDanger();" 
                         onblur="checkChargeAmount(this);">
                </td>
                
                <td class="input" style='width:4%'  align="center">
                    <div>
                         <input type=button name="buttonChargeDelete"  class="smallbutton" 
                                onclick="deleteRow(this,'Charge');setFlagDanger();" value="-" style="cursor: hand">
                         <input type="hidden" name="prpLchargeFlag">
                    </div>
                </td>
              </tr>

            </tbody>
          </table>
        </span>


        <span  id="spanCharge" style="display:none" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Charge" >
          <thead>
            <tr>
                <td class="centertitle" style="width:4%">标的序号</td>
                <td class="centertitle" style="width:4%">险别代码</td>
                <td class="centertitle" style="width:8%">险别名称</td>
                <td class="centertitle"  style="width:6%">费用代码</td>
                <td class="centertitle"  style="width:8%">费用名称</td>
                <td class="centertitle"  style="width:9%">代查勘机构</td>
                <td class="centertitle"  style="width:5%">支付类别</td>
                <td class="centertitle"  style="width:8%">支付对象编码</td>
                <td class="centertitle"  style="width:8%">支付对象名称</td>
                <td class="centertitle"  style="width:6%">币别</td>
                <td class="centertitle"  style="width:8%">费用金额</td>
                <td class="centertitle"  style="width:8%">预付费用</td>
                <td class="centertitle"  style="width:8%">实际费用</td>   
                <td class="centertitle"  style="width:8%">计入赔款金额</td>
                <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=14 >(按"+"号键增加费用赔款信息，按"-"号键删除信息)</td>
                 <td class="title" align="right" style="width:4%">
                     <div align="center">
                          <input type="button" value="+" class=smallbutton name="buttonDriverInsert" style="cursor: hand"
                                 onclick="insertRow('Charge');setFlagDanger();">
                     </div>
                 </td>
              </tr>
           </tfoot>
          </tfoot>
          <tbody>
 <% int indexCharge=0;%>
<logic:notEmpty  name="prpLchargeDto"  property="prpLchargeList">
<logic:iterate id="chargedtox" name="prpLchargeDto" property="prpLchargeList">
              <tr>
                 <td class="input" style="width:4%">
                  <input type="text" class="readonly" readonly="readonly" style="width: 100%" name="prpLlossDtoItemKindNoForCharge" value="<bean:write name='chargedtox' property='itemkindno'/>">
                </td>
                <td class="input" style="width:4%">
                  <input type="hidden"  name="prpLchargeFlag" value="<bean:write name='chargedtox' property='flag'/>">
                  <input type="hidden"  name="prpLchargeSerialNo" description="序号" value="<bean:write name='chargedtox' property='serialNo'/>">
                  <input name="prpLchargeKindCode" class="codecode" style="width:100%" maxlength="3"  value="<bean:write name='chargedtox' property='kindCode'/>"
                         ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-3','code');"
                         onchange="code_CodeChange(this, 'PolicyKindCode','1,-3','code');setSumDutyDeductibleFlag('0');setFlagDanger();setPrpLpreChargeAmount(this);"
                         onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-3','code');"
                         onblur="checkChargeCode(this);">
                    
                </td>
                
                <td class="input" style="width:8%">
                  <input name="prpLchargeKindName" class="codename" style="width:100%"  value="<bean:write name='chargedtox' property='kindName'/>"
			                   ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');"
			                   onchange="code_CodeChange(this, 'PolicyKindCode','-1,-4','name','none','post');setSumDutyDeductibleFlag('0');setFlagDanger();setPrpLpreChargeAmount(this);"
			                   onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');"
			                   onblur="checkChargeCode(this);">
			             
                </td>
                
                <td class="input" style="width:6%">
                  <input  name="prpLchargeChargeCode" class="codecode" style="width:100%" value="<bean:write name='chargedtox' property='chargeCode'/>"
                          ondblclick="code_CodeSelect(this, 'ChargeCode1');"
                          onchange="code_CodeChange(this, 'ChargeCode1');setPrpLpreChargeAmount(this);"
                          onkeyup= "code_CodeSelect(this, 'ChargeCode1');"
                          onblur="checkChargeCode(this);calChargeAmount(this); setRealPay();">
                </td>
                
                <td class="input" style="width:8%">
                  <input name="prpLchargeChargeName" class="codename" style="width:100%" value="<bean:write name='chargedtox' property='chargeName'/>"
			                   ondblclick="code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			                   onchange="code_CodeChange(this, 'ChargeCode1','-1','name','none','post');setFlagDanger();setPrpLpreChargeAmount(this);"
			                   onkeyup= "code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			                   onblur=" checkChargeCode(this);calChargeAmount(this); setRealPay();setSumDutyDeductibleFlag('0');" >
                </td>
                <td class="input" style="width:9%">
			      <input type=hidden class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="具体单位" value="<bean:write name='chargedtox' property='checkDeptCode' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                   >
                <logic:equal name='chargedtox' property="chargeCode" value="14">
                 <input type=text class="codecode" name="prpLchargeCheckDeptName"  title="具体单位" style="width:100%" maxLength="50" description="查勘处理单位" value="<bean:write name='chargedtox' property='checkDeptName' filter='true' />"
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    >
                </logic:equal>
                <logic:notEqual name='chargedtox' property="chargeCode" value="14">
                 <input type=hidden class="codecode" name="prpLchargeCheckDeptName"  title="具体单位" style="width:100%" maxLength="50" description="查勘处理单位" value="<bean:write name='chargedtox' property='checkDeptName' filter='true' />"
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    >
                </logic:notEqual>
                </td>
                
                <td class="input" style="width:5%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" <logic:equal name='chargedtox' property='payObjectType' value="B">selected</logic:equal>>外部</option>
                    <option value="A" <logic:equal name='chargedtox' property='payObjectType' value="A">selected</logic:equal>>内部</option>
                   </select>
                </td>
                
                <td class="input" style="width:8%">
                  <input name="prpLchargePayObjectCode" class="readonly" readonly style="width:80%" value="<bean:write name='chargedtox' property='payObjectCode'/>">
                </td>
                
                <td class="input" style="width:8%" >
                  <input name="prpLchargePayObjectName" class="codename" style="width:100%" value="<bean:write name='chargedtox' property='payObjectName'/>"
                         ondblclick="code_CodeSelect(this, 'PayObject','-1','name','none','post');"
			                   onchange="code_CodeChange(this, 'PayObject','-1','name','none','post');"
			                   onkeyup= "code_CodeSelect(this, 'PayObject','-1','name','none','post');"
			                   onblur="">
                </td>
                
                <td class="input" style="width:6%">
                  <input name="prpLchargeCurrency" class="readonly" style="width:100%" value="<bean:write name='chargedtox' property='currency'/>">
                </td>
                
                 <td class="input" style="width:8%" >
                  <input name="prpLchargeChargeReport" class="input" style="width:100%" value="<bean:write name='chargedtox' property='chargeReport'/>"  
                         onchange="calChargeAmount(this); setFlagDanger();" 
                         onblur=" calChargeAmount(this); calFund();setSumDutyDeductibleFlag('0');">
                </td>
                 <td class="input" style="width:8%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%" value="<bean:write name='chargedtox' property='preChargeAmount'/>">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" value="<bean:write name='chargedtox' property='chargeAmount'/>"  
                         onchange="calFund();setFlagDanger();" 
                         onblur="checkChargeAmount(this);setSumDutyDeductibleFlag('0');">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLchargeSumRealPay" type="text" class='readonly' readonly style="width:100%" value="<bean:write name='chargedtox' property='sumRealPay'/>"
                  		 onchange="calFund();setFlagDanger();" 
                         onblur="checkChargeAmount(this);">
                </td>
                
                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonChargeDelete"  class=smallbutton onclick="deleteRow(this,'Charge');setFlagDanger();" value="-" style="cursor: hand">
                    <input type="hidden" name="prpLchargeFlag">
                  </div>
                </td>
              </tr>
 <%    indexCharge++;%>
      </logic:iterate>
      </logic:notEmpty>
          </tbody>
        </table>
        </span>
      </td>
    </tr>
  </table>








