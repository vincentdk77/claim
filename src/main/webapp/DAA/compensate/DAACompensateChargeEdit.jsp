<%--
****************************************************************************
* DESC       ����ӷ��������Ϣҳ��
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>
   <!--������ʾ��¼����������������ʾ��-->
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
    
     var  chargeReport = fm.all('prpLchargeChargeReport')[serialNo].value ; //���ý��
     var  chargeAmount = 0.0;                                               //ʵ�ʷ���
    // var  kindCode     = fm.all('prpLchargeKindCode')[serialNo].value ;     //�ձ�
     var  chargeCode   = fm.all('prpLchargeChargeCode')[serialNo].value ;   //��������
     if(isNaN(chargeReport))   chargeReport = 0;
     if(fm.all('prpLlossDtoKindCodeShow') != null && fm.all('prpLlossDtoKindCodeShow')[1] != null) {
		 var kind = fm.all('prpLlossDtoKindCodeShow')[1].value ;  //�����ʧ����ж�Ӧ�ĵ�һ����ʧ��Ϣ���ձ�
      	 var vPrpLchargeKindCode = fm.all('prpLchargeKindCode')[serialNo].value //�ձ����
         if (   kind == 'A' && chargeCode=='03' && vPrpLchargeKindCode != 'B'){
         	  //�⳥����
           /*	
           if ( !isEmptyField(fm.prpLlossDtoClaimRate) ) {  //��ֹ��¼���ú�¼��������Ϣ�����������˱���¼�복����Ϣ������¼ʩ�ȷѣ�����������ò��ϣ���Ϊ��ֹ�Ժ��ֱ䣬�����Ȳ�ɾ��
               var  claimRate  = parseFloat(fm.all('claimRate')[1].value);
            }
            else{  
           	�� var  claimRate  = parseFloat(fm.all('prpLlossDtoClaimRate')[1].value);
            }
          	if (isNaN(claimRate))	{ claimRate = 1 ;     	}else { claimRate =  claimRate/100 ;}
           */
          // ���α���
            if ( !isEmptyField(fm.prpLlossDtoIndemnityDutyRate) ) {  //��ֹ��¼���ú�¼��������Ϣ��ͬ�⳥����
             �� var  indemnityDutyRate  = parseFloat(fm.all('indemnityDutyRate')[1].value);
            }
            else{  
            	�� var  indemnityDutyRate  = parseFloat(fm.all('prpLlossDtoIndemnityDutyRate')[1].value);
            }
           	if (isNaN(indemnityDutyRate)){ indemnityDutyRate= 1 ;}else { indemnityDutyRate =indemnityDutyRate/100 }
            
            //����������
          	var  deductibleRate  = parseFloat(fm.all('prpLlossDtoDeductibleRate')[1].value);
          	if (isNaN(deductibleRate)){  deductibleRate =0 ;}else { deductibleRate =deductibleRate/100;}
            
            //����������
          	var  DutyDeductibleRate  = parseFloat(fm.all('prpLlossDtoDutyDeductibleRate')[1].value);
          	if (isNaN(DutyDeductibleRate)){DutyDeductibleRate=0 ; }else {  DutyDeductibleRate =DutyDeductibleRate/100;}
          	var claimRate;      //�⳥����
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
        else {  //��һ����ʧ��Ϣ���Ǳ�ĳ������������ʩ�ȷ�
        	fm.all("prpLchargeChargeAmount")[serialNo].value = point(round(chargeReport,2),2) ;
          fm.all("prpLchargeSumRealPay")[serialNo].value = 0.00 ;
        }
      }
  }
  
  /*
    ���������α��������������ʡ����������ʸı�ʱ�����¼��������õ�ֵ
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
        var  chargeReport ; //���ý��
        var  chargeAmount = 0.0;                                               //ʵ�ʷ���    
        var  chargeCode    ;   //��������    
        for(i = 0;i < reports.length;i++){
            chargeReport = reports[i].value ; 
            chargeAmount = 0.0; 
            chargeCode   = chargeCodes[i].value ;   
            if(isNaN(chargeReport))   
                chargeReport = 0;
            var kind = codeShows[1].value ;  //�����ʧ����ж�Ӧ�ĵ�һ����ʧ��Ϣ���ձ�
      
         if (   kind == 'A'   && chargeCode=='03'){
            
          // ���α���
            if ( !isEmptyField(fm.prpLlossDtoIndemnityDutyRate) ) {  //��ֹ��¼���ú�¼��������Ϣ��ͬ�⳥����
             �� var  indemnityDutyRate  = parseFloat(dutyRates[1].value);
            }
            else{  
                �� var  indemnityDutyRate  = parseFloat(lossDutyRates[1].value);
            }
            if (isNaN(indemnityDutyRate)){ indemnityDutyRate= 1 ;}else { indemnityDutyRate =indemnityDutyRate/100 }
            
            //����������
            var  deductibleRate  = parseFloat(deductRates[1].value);
            if (isNaN(deductibleRate)){  deductibleRate =0 ;}else { deductibleRate =deductibleRate/100;}
            
            //����������
            var  DutyDeductibleRate  = parseFloat(dutyDeductRates[1].value);
            if (isNaN(DutyDeductibleRate)){DutyDeductibleRate=0 ; }else {  DutyDeductibleRate =DutyDeductibleRate/100;}
            //�⳥����
            var claimRate;     
            claimRate =  parseFloat(claimRates[1].value);           
            if(isNaN(claimRate)){ claimRate = 1 }else{claimRate = claimRate /100 ;};
            //ʩ�ȷѼ���
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
        	      //�⳥����
        	      var  claimRate  = parseFloat(fm.all('prpLlossDtoClaimRate')[1].value);
        	      if (isNaN(claimRate))	{ claimRate = 1 ;     	}else { claimRate =  claimRate/100 ;}
        	      //���α���	
        	      var  indemnityDutyRate  = parseFloat(fm.all('prpLlossDtoIndemnityDutyRate')[1].value);
        	      if (isNaN(indemnityDutyRate)){ indemnityDutyRate= 1 ;}else { indemnityDutyRate =indemnityDutyRate/100 }
        	      //����������
        	      var  deductibleRate  = parseFloat(fm.all('prpLlossDtoDeductibleRate')[1].value);
        	      if (isNaN(deductibleRate)){  deductibleRate =0 ;}else { deductibleRate =deductibleRate/100;}
                //����������
        	      var  DutyDeductibleRate  = parseFloat(fm.all('prpLlossDtoDutyDeductibleRate')[1].value);
        	      if (isNaN(DutyDeductibleRate)){DutyDeductibleRate=0 ; }else {  DutyDeductibleRate =DutyDeductibleRate/100;}
        	  
        	     if( chargeNumber != 'undefined' && chargeNumber >1){
        	       for (var i=0; i< chargeNumber ;i++ ){
        	     	  var  chargeReport = fm.all('prpLchargeChargeReport')[i].value ; //���ý��        
                      var  chargeAmount = 0.0;        //ʵ�ʷ��� 
                      var  chargeCode   = fm.all('prpLchargeChargeCode')[i].value ;   //�������� 
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
	  //��λ
      for ( var i=0 ;i< fm.all(field.name).length ;i++){
        if ( fm.all(field.name)[i] == field )
        {
        	serialNo=i ;
        	break ;
        }
      }
      var chargeCode = fm.prpLchargeChargeCode[serialNo].value; //�������
      var vPrpLchargeKindCode = fm.prpLchargeKindCode[serialNo].value; //�ձ����
      //���Ϊ���������α��յ�ʩ�ȷѣ������������ʵ�ʷ��������������������û�����,��ֻ����Ϊ������
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
     	  	  if (kindCode !='A' && field.value=='ʩ�ȷ�' ) {
     	  	  	 alert ( " û��¼�복����Ϣ������¼��ʩ�ȷ���");
     	  	  	 field.value = "";
     	  	  	 field.focus();
     	  	  	 return false;
     	  	  } 
     	  	  
     	  }else {
     	  	 if ( field.value=='ʩ�ȷ�')  {
     	  	   alert ( " û��¼�복����Ϣ������¼��ʩ�ȷ���");
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
     	  	                 && fm.all("prpLchargeChargeName")[i].value == "ʩ�ȷ�"
     	  	                 && fm.all("prpLchargeKindCode")[i].value != "A"
     	  	                 && fm.all("prpLchargeKindCode")[i].value != "B"){
     	  	           alert ( "ֻ�г�����ʧ�պ͵��������α��ղ���¼��ʩ�ȷ�" );
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
     	  	                 && fm.all("prpLchargeChargeName")[i].value == "������")
     	  	                 {
     	  	                     alert ( "���ղ���¼�빫���ѣ�" );
     	  	                     fm.all("prpLchargeChargeCode")[i].value = "";
     	  	                     fm.all("prpLchargeChargeName")[i].value = "";
     	  	                     field.focus();
                                 return false;
     	  	                 }
             }
      }
      
   }
    
     
      //��������뱾ҳ�Զ����JavaScript����

        /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertCharge()
      {
        setPrpLchargeSerialNo();
        calFund();
      }

      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteCharge(field)
      {
        setPrpLchargeSerialNo();
        calFund();
      }

        /**
         * ����setPrpLchargeSerialNo
         */
        function setPrpLchargeSerialNo(){
            var count=getElementCount("prpLchargeSerialNo");
            for(var i=0;i<count;i++)
            {
                //alert("����ʲôʱ������?count="+count+"  i="+i);
                if(count!=1){
                    fm.prpLchargeSerialNo[i].value=i;
                }
            }
        }
		//ʹ��xmlhttp����ҳ�棬����ȡxml����
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
		    alert("�Ҳ���ҳ�棺"+ strURL);
		    return "";
		  }
		  else
		  {
		    alert("����"+ strURL +"��������ţ�"+objXmlHttp.status);
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
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="common" colspan="5" style="text-align:left">
      <input type="hidden" name="preClaimNo" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">
       <input type="hidden" name="strRecaseFlag" value="<%=strRecaseFlag %>">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge);changeCompensateFlag('1');">���������Ϣ<br>
        <span style="display:none">
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="input" style="width:4%">
                  <input type="text" class="readonly" readonly="readonly" style="width: 100%" name="prpLlossDtoItemKindNoForCharge">
                </td>
                <td class="input" style="width:4%">
                  <input type="hidden"  name="prpLchargeFlag">
                  <input type="hidden"  name="prpLchargeSerialNo" description="���">
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
                   <input type=hidden class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="���嵥λ" value=""
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                   >
                  <input type=text class="codecode" name="prpLchargeCheckDeptName"  title="���嵥λ" style="display:none;width:100%" maxLength="50" description="�鿱����λ" value=""
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    >
                </td>
                
                <td class="input" style="width:5%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" selected>�ⲿ</option>
                    <option value="A">�ڲ�</option>
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
        <%-- ��������չ���� --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Charge" >
          <thead>
            <tr>
                <td class="centertitle" style="width:4%">������</td>
                <td class="centertitle" style="width:4%">�ձ����</td>
                <td class="centertitle" style="width:8%">�ձ�����</td>
                <td class="centertitle"  style="width:6%">���ô���</td>
                <td class="centertitle"  style="width:8%">��������</td>
                <td class="centertitle"  style="width:9%">���鿱����</td>
                <td class="centertitle"  style="width:5%">֧�����</td>
                <td class="centertitle"  style="width:8%">֧���������</td>
                <td class="centertitle"  style="width:8%">֧����������</td>
                <td class="centertitle"  style="width:6%">�ұ�</td>
                <td class="centertitle"  style="width:8%">���ý��</td>
                <td class="centertitle"  style="width:8%">Ԥ������</td>
                <td class="centertitle"  style="width:8%">ʵ�ʷ���</td>   
                <td class="centertitle"  style="width:8%">���������</td>
                <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=14 >(��"+"�ż����ӷ��������Ϣ����"-"�ż�ɾ����Ϣ)</td>
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
                  <input type="hidden"  name="prpLchargeSerialNo" description="���" value="<bean:write name='chargedtox' property='serialNo'/>">
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
			      <input type=hidden class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="���嵥λ" value="<bean:write name='chargedtox' property='checkDeptCode' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                   >
                <logic:equal name='chargedtox' property="chargeCode" value="14">
                 <input type=text class="codecode" name="prpLchargeCheckDeptName"  title="���嵥λ" style="width:100%" maxLength="50" description="�鿱����λ" value="<bean:write name='chargedtox' property='checkDeptName' filter='true' />"
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    >
                </logic:equal>
                <logic:notEqual name='chargedtox' property="chargeCode" value="14">
                 <input type=hidden class="codecode" name="prpLchargeCheckDeptName"  title="���嵥λ" style="width:100%" maxLength="50" description="�鿱����λ" value="<bean:write name='chargedtox' property='checkDeptName' filter='true' />"
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    >
                </logic:notEqual>
                </td>
                
                <td class="input" style="width:5%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" <logic:equal name='chargedtox' property='payObjectType' value="B">selected</logic:equal>>�ⲿ</option>
                    <option value="A" <logic:equal name='chargedtox' property='payObjectType' value="A">selected</logic:equal>>�ڲ�</option>
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








