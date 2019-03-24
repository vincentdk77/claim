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
<%
	String strRecaseFlag = (String)request.getAttribute("recaseFlag");
%>
    <script language='javascript'>
   
      //在下面加入本页自定义的JavaScript方法
      
      
      function setRescueFeeAsRealPay(){  //施救费全部计入赔款，其他不用
	for(i=1;i<fm.all("prpLchargeSerialNo").length;i++){
		
		if ( isNaN(fm.all("prpLchargeChargeCode")[i].value)){
		        fm.all("prpLchargeChargeReport")[i].value = 0.00;
		        fm.all("prpLchargeChargeAmount")[i].value = 0.00;
			fm.all("prpLchargeSumRealPay")[i].value   = 0.00;
		}
		if ( isNaN(fm.all("prpLchargeChargeReport")[i].value)){ 
		    fm.all("prpLchargeChargeReport")[i].value = 0.00;
		}
		if ( isNaN(fm.all("prpLchargeChargeAmount")[i].value)){ 
		    fm.all("prpLchargeChargeAmount")[i].value = 0.00;
		}
		if ( isNaN(fm.all("prpLchargeSumRealPay")[i].value)){ 
		    fm.all("prpLchargeSumRealPay")[i].value = 0.00;
		}
		
		if (fm.all("prpLchargeChargeCode")[i].value=="03"){
		    if(isNaN(parseFloat(fm.all("prpLchargeChargeAmount")[i].value)) ){
                  fm.all("prpLchargeChargeAmount")[i].value = fm.all("prpLchargeChargeReport")[i].value;
            }
			fm.all("prpLchargeSumRealPay")[i].value =  fm.all("prpLchargeChargeAmount")[i].value;
		}else{
		    if(isNaN(parseFloat(fm.all("prpLchargeChargeAmount")[i].value)) ){
		          fm.all("prpLchargeChargeAmount")[i].value = fm.all("prpLchargeChargeReport")[i].value;
		    }			
			fm.all("prpLchargeSumRealPay")[i].value =  0.00;
		}
	}
	//calSumDutyPaid(); //合计一下
     }      
	function checkChange(){
		for(i=1;i<fm.all("prpLchargeSerialNo").length;i++){
			if(fm.all("prpLchargeChargeCode")[i].value == "13"){
				alert("车险不能录入公估费用赔款信息！");
				fm.all("prpLchargeChargeCode")[i].focus;
				return false;
			}
		}
	}
        /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertCharge()
      {
        setPrpLchargeSerialNo();
      // calSumDutyPaid(); //合计一下
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteCharge(field)
      {
        setPrpLchargeSerialNo();
      // calSumDutyPaid(); //合计一下
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
       if(chargeCode=='14'){
         fm.prpLchargeCheckDeptName[serialNo].style.display="";
       }else{
         fm.prpLchargeCheckDeptName[serialNo].style.display="none";
         fm.prpLchargeCheckDeptCode[serialNo].value="";
         fm.prpLchargeCheckDeptName[serialNo].value="";
       }
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
   <table class="common" align="center">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="6" style="text-align:left">
      <input type="hidden" name="preClaimNo" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">
       <input type="hidden" name="strRecaseFlag" value="<%=strRecaseFlag %>">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge);changeCompensateFlag('1');">费用赔款信息<br>
        <span style="display:none">
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="input" style="width:4%">
                  <input type="text"  class="readonly" readonly="readonly" name="prpLlossDtoItemKindNoForCharge" description="标的序号">
                </td>
                <td class="input" style="width:6%">
                  <input type="hidden"  name="prpLchargeFlag">
                  <input type="hidden"  name="prpLchargeSerialNo" description="序号">
                  <input name="prpLchargeKindCode" class="codecode" style="width:100%" maxlength="3"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-3','code','none','post');setPrpLpreChargeAmount(this);"
                    onchange="code_CodeChange(this, 'PolicyKindCode','1,-3','code','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-3','code','none','post');">
                    
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeKindName" class="codename"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');"
			             onchange="code_CodeChange(this, 'PolicyKindCode','-1,-4','name','none','post');setPrpLpreChargeAmount(this);"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');" >
			            
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeCode" class="readonly" style="width:100%"
                    ondblclick="code_CodeSelect(this, 'ChargeCode1');"
                    onchange="code_CodeChange(this, 'ChargeCode1'); setPrpLpreChargeAmount(this);"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode1'); "
                    onblur="setRescueFeeAsRealPay();checkBeyondQuota(); checkChange();checkChargeCode(this)">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeName" class="codename" style="width:100%"
			             ondblclick="code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'ChargeCode1','-1','name','none','post');setPrpLpreChargeAmount(this);"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			             onblur="  setRescueFeeAsRealPay();checkBeyondQuota();checkChange();checkChargeCode(this) ">
                </td>
                
                <td class="input" style="width:10%">
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
                
                <td class="input" style="width:10%">
                  <input name="prpLchargeCurrency" class="readonly" style="width:100%" value="CNY">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeReport" class="input" style="width:100%" onchange="setRescueFeeAsRealPay();calCompelSumPropAndPerson();"  onblur="checkBeyondQuota();calSumDutyPaid() ">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" onchange="setRescueFeeAsRealPay();calCompelSumPropAndPerson();setFlagDanger();" onblur="calSumDutyPaid()">
                  <input name="prpLchargeSumRealPay" type="hidden" style="width:100%" class='readonly' readonly  onchange="setFlagDanger();">
                </td>
                <td class="input" style="width:10%">
                	<input name="prpLpreChargeAmount" style="width:100%" class='readonly' readonly>
                </td>
                <!-- 
                <td class="input" style="width:16%">
                </td>
                -->
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonChargeDelete"  class="smallbutton" onclick="deleteRow(this,'Charge');calSumDutyPaid();setFlagDanger();" value="-" style="cursor: hand">
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
                <td class="centertitle" style="width:6%">险别代码</td>
                <td class="centertitle" style="width:10%">险别名称</td>
                <td class="centertitle"  style="width:10%">费用代码</td>
                <td class="centertitle"  style="width:10%">费用名称</td>
                <td class="centertitle"  style="width:10%">代查勘机构</td>
                <td class="centertitle"  style="width:10%">币别</td>
                <td class="centertitle"  style="width:10%">费用金额</td>
                <td class="centertitle"  style="width:10%">实际费用</td>    <!--Add 20060512 -->
                <td class="centertitle"  style="width:10%">预付费用</td>
                <!--
                <td class="centertitle"  style="width:16%">计入赔款金额</td>
                -->
                
                <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=10 >(按"+"号键增加费用赔款信息，按"-"号键删除信息)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" class=smallbutton onclick="insertRow('Charge');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand"  >
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
                  <input type="text"  class="readonly" readonly="readonly" name="prpLlossDtoItemKindNoForCharge" description="标的序号" value="<bean:write name='chargedtox' property='itemkindno'/>">
                </td>
                <td class="input" style="width:6%">
                  <input type="hidden"  name="prpLchargeFlag" value="<bean:write name='chargedtox' property='flag'/>">
                  <input type="hidden"  name="prpLchargeSerialNo" description="序号" value="<bean:write name='chargedtox' property='serialNo'/>">
                  <input name="prpLchargeKindCode" class="codecode" style="width:100%" maxlength="3"  value="<bean:write name='chargedtox' property='kindCode'/>"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-3','code','none','post');"
                    onchange="code_CodeChange(this, 'PolicyKindCode','1,-3','code','none','post');setFlagDanger();setPrpLpreChargeAmount(this);"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-3','code','none','post');">
                   
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeKindName" class="codename"  value="<bean:write name='chargedtox' property='kindName'/>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');"
			             onchange="code_CodeChange(this, 'PolicyKindCode','-1,-4','name','none','post');setFlagDanger();setPrpLpreChargeAmount(this);"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-4','name','none','post');">
			             
                </td>
                <td class="input" style="width:10%">
                  <input  name="prpLchargeChargeCode" class="readonly" style="width:100%" value="<bean:write name='chargedtox' property='chargeCode'/>"
                    ondblclick="code_CodeSelect(this, 'ChargeCode1');"
                    onchange="code_CodeChange(this, 'ChargeCode1');setPrpLpreChargeAmount(this);"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode1');"
                    onblur=" setRescueFeeAsRealPay();checkBeyondQuota();checkChange();checkChargeCode(this) ">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeName" class="codename" style="width:100%" value="<bean:write name='chargedtox' property='chargeName'/>"
			             ondblclick="code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'ChargeCode1','-1','name','none','post');setPrpLpreChargeAmount(this);"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode1','-1','name','none','post');"
			             onblur=" setRescueFeeAsRealPay();checkBeyondQuota();checkChange();checkChargeCode(this) ">
                </td>
                <td class="input" style="width:10%">
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
                
                <td class="input" style="width:10%">
                  <input name="prpLchargeCurrency" class="readonly" style="width:100%" value="<bean:write name='chargedtox' property='currency'/>">
                </td>
                 <td class="input" style="width:10%">
                  <input name="prpLchargeChargeReport" class="input" style="width:100%" value="<bean:write name='chargedtox' property='chargeReport'/>"  onchange="setRescueFeeAsRealPay(); calCompelSumPropAndPerson();" onblur="checkBeyondQuota();calSumDutyPaid();">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" value="<bean:write name='chargedtox' property='chargeAmount'/>"  onchange="setRescueFeeAsRealPay();" onblur="calSumDutyPaid();">
                  <input name="prpLchargeSumRealPay" type="hidden" class='readonly' readonly style="width:100%" value="<bean:write name='chargedtox' property='sumRealPay'/>">
                </td>
                 <td class="input" style="width:10%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%" value="<bean:write name='chargedtox' property='preChargeAmount'/>">
                </td>
				<!-- 
                <td class="input" style="width:16%"></td>
                -->
                
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonChargeDelete"  class=smallbutton onclick="deleteRow(this,'Charge');calSumDutyPaid();setFlagDanger();" value="-" style="cursor: hand"  >
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








