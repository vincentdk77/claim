<%--
****************************************************************************
* DESC       ����ʾ�����Ǽǵ��ձ������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-24
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>

<% 
 
 String  configCode=(String) request.getAttribute("configCode");
 System.out.println("==========555====" +configCode);
 %>	
	
	
<script language="javascript">
	
//modify by lym 20060606 for ǿ��  start ---------	
//---������ ����---������= �ϱ������ * ���α��� *��1- �¹����������ʣ�-------------------------
  function calSumClaim(field){
	    var serialNo=0;
	    var dutyRate = fm.prpLclaimIndemnityDutyRate.value; //���α���
	    var indemnityDuty =fm.indemnityDuty.value;  //����
	    var dutydeductRate = 0.0;                           //�¹�����������
	    var sumClaim =0.00 ;                                //�����Ĺ�����
	    
	    for (var i =0; i<fm.all(field.name).length; i++ ) {
	    	 if ( field == fm.all(field.name)[i]){
	    	     serialNo=i;
	    	     break;	
	    	 }
	    }	
	   var KindRest = fm.all("prpLclaimLossKindRest")[serialNo].value;
	   var kindLoss = fm.all("prpLclaimLossKindLoss")[serialNo].value;
	   var claimlossKindCode = fm.all("prpLclaimLossKindCode")[serialNo].value; 
	   var feeType =fm.all("prpLclaimLossLossFeeType")[serialNo].value;
	   var kindname = claimlossKindCode +indemnityDuty;
	   
	   if(isNaN(kindLoss))kindLoss = 0;
	   if(isNaN(KindRest))KindRest = 0;
	   for (var n=0;n<fm.all("kindCodedutyName").length;n++){
	     var  kindCodedutyName = fm.all("kindCodedutyName")[n].value;
	     if ( kindname == kindCodedutyName ){
	       dutydeductRate = parseFloat(fm.all("deductRate")[n].value);
	       break ;
	     }
	     else {
	      continue;
	     }
	   
	   }
	   var exist_F = false;
	   for(var i = 0 ;i < damageKind.length; i++){
 			if(damageKind[i] == 'M'){
 				exist_F = true;
 				break;
 			}
 	   }
	   
	   if ( feeType=='Z'  || kindCodedutyName.substr(1,2)=='BZ'){ //���ò�����
	   	   sumClaim = parseFloat(kindLoss);
	   }
	   else { //���
	       if( claimlossKindCode =='A' || claimlossKindCode=='B' || claimlossKindCode=='B1' || claimlossKindCode=='D2' || claimlossKindCode=='D3' ||  claimlossKindCode=='D4'  ) {  //A B B1 �����
	               if(exist_F){
	               		 sumClaim = parseFloat(kindLoss-KindRest) * dutyRate/100 ;
	               }
	               else{
	               		 sumClaim = parseFloat(kindLoss-KindRest) * dutyRate/100 * (1-dutydeductRate/100) ;
	               }
	              
	       }
	       else {
	               sumClaim = parseFloat(kindLoss-KindRest);
	       }
       }
                                                                  
          fm.all("prpLclaimLossSumClaim")[serialNo].value=   point(round(sumClaim,2),2) ; 

  }

 function checkBeyondQuota(){//����Ƿ񳬳��޶�
 	   var duty =fm.indemnityDuty.value;
     var quotaBZ_D =0;
     var quotaBZ_M =0;
     var quotaBZ_P =0;
     var quotaB=0;
      
      quotaB = parseFloat( fm.kindAmount.value);
     /*
     for(var i=0;i< fm.all("kindCode").size;i++){
     	
       var  kindCode = fm.all("kindCode")[i].value ;
       
       if (kindCode=='B' ){
       	    
           quotaB = parseFloat( fm.all("kindAmount")[i].value);
           break;
       }
     }  */
     
     
 
<%  
if (configCode!=null &&("RISKCODE_DAZ".equals(configCode )||"RISKCODE_DAY".equals(configCode )||"RISKCODE_DAU".equals(configCode ))){


 %>
    for (var i=0;i<fm.all("limitType").length;i++ ){
       if ( duty!='4'){
          if (fm.all("limitType")[i].value=='90' ) {  
           quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='91' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='92' ){   
            quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
       else  {  //����
          if (fm.all("limitType")[i].value=='93' ) {  
            quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='94' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='95' )   {
             quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
   
    }
    
   
 <%  }%>
   
   var amountB=0.00;  //��ҵ����A��
  
   var amountBZ_P=0.00;  //ǿ��
   var amountBZ_M=0.00;  //ǿ��
   var amountBZ_D=0.00;  //ǿ��
  
   var dutyRate =parseFloat(fm.prpLclaimIndemnityDutyRate.value); //�¹����α���
   var kindNum = fm.all("prpLclaimLossKindCode").length ;
   if (kindNum!='undefined' && kindNum >1){
 	    for (var i=1; i<kindNum;i++) {	
                   var prpLclaimLossKindCode =fm.all("prpLclaimLossKindCode")[i].value;
                   var kindLoss = parseFloat(fm.all("prpLclaimLossKindLoss")[i].value);
                   var feeType = fm.all("prpLclaimLossLossFeeType")[i].value;
                   if ( prpLclaimLossKindCode =='B'  && feeType=='P')  {  //��ҵ����A��
 	                 amountB += kindLoss ;
 	           }
 	         if (prpLclaimLossKindCode=='BZ' && feeType=='P'){ //ǿ��
 	               if ( fm.all("prpLclaimLossFeeCategory")[i].value =='C' ||  fm.all("prpLclaimLossFeeCategory")[i].value =='G') {
 	                   amountBZ_P += parseFloat( fm.all("prpLclaimLossKindLoss")[i].value);
 	                }	
 	                else if ( fm.all("prpLclaimLossFeeCategory")[i].value =='M') {
 	                   amountBZ_M += parseFloat( fm.all("prpLclaimLossKindLoss")[i].value);
 	                }
 	                else if ( fm.all("prpLclaimLossFeeCategory")[i].value =='D') {
 	                   amountBZ_D +=  parseFloat(fm.all("prpLclaimLossKindLoss")[i].value);
 	                }
 	       
 	           
 	         }
 	        
 	     
 	    }
 	  }
 	   
 	   amountB =  amountB * (dutyRate/100 ); 
 	 /*
 	   if ( amountB >quotaB) {
 	     alert ("��ҵ�����ۺϱ��չ�����֮�ͳ����޶�("+quotaB+")Ԫ"); 
 	     return false;
 	   }
 	  */
 	   
 	   if ( amountBZ_P >quotaBZ_P) {
 	       alert ("ǿ�ƹ�����Ʋ�����֮�ͳ����޶"+quotaBZ_P+"Ԫ"); 
 	     return false;
 	   }
 	   if ( amountBZ_M >quotaBZ_M) {
 	       alert ("ǿ�ƹ�����ҽ�Ʋ���֮�ͳ����޶"+quotaBZ_M+"Ԫ"); 
 	     return false;
 	   }
 	 
 	  if ( amountBZ_D >quotaBZ_D) {
 	     alert ("ǿ�ƹ����������˲в���֮�ͳ����޶"+quotaBZ_D+"Ԫ"); 
 	     return false;
 	   }
 	 
   return true;	 
 }
  
  
 //modify by lym 20060606 for ǿ��  end ---------
 
 function changeSumClaim(){
 	 var sumClaimNum = fm.all("prpLclaimLossKindCode").length ;
 	
   if (sumClaimNum!='undefined' && sumClaimNum >1){
 	    for (var i=1 ;i< sumClaimNum ;i++) {
 	      calSumClaim (fm.all("prpLclaimLossKindCode")[i]);
 	    }
   }	
 }
 
 
	
//��ť�����¼��������������ʾ
function buttonOnClick2(fieldObject)
{
	var intIndex = parseInt(getElementOrder(fieldObject)-1);
	var spanId='span_Engage_Context00';
	if(isNaN(fm.button_Engage_Open_Context00.length))
    {
    }
  else{//����
     spanId='span_Engage_Context00'+"["+ intIndex +"]";
  }
  showSubPage3(spanId);
}

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage3(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y

  ex = ex - 520;

  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;

  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
}
function judgeKindCode(Field)
{
     var findFlag = 0;
     var fieldname=Field.name;
     var i = 0;
     var findex=0;
     for(i=1;i<fm.all(fieldname).length;i++)
     {
        if( fm.all(fieldname)[i] == Field )
        {
           findex=i;
           break;
        }
     }  
     var strValue = fm.prpLclaimLossKindCode[findex].value;
     //�ж�ѡ����ձ��Ƿ�Ϊ�������ڵ�ʱ��Ч���ձ�
     for (var j=0;j<damageKind.length;j++)
     {
        if(damageKind[j]==strValue)
        {
            findFlag = 1;
            break;
        }
     }
     if(findFlag==0)
     {
         alert("��ѡ����ձ��ǳ�������ʱ���ձ�,�����½���ѡ��");
         fm.prpLclaimLossKindCode[findex].value = "";
         return false;
     }
  
}

        //Modify by liujianbo modify start 20051107
        //reason:itest:594 ��������������һ���ձ������Ϣʱ��������ʧ���û������.�����������ݲ�һ�� 
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������ 
      */
      function afterDeleteClaimLoss(field)
      {
        collectClaimLoss();
        dutySum();
      }
        //Modify by liujianbo modify end 20051107
        
        
    //add by zhaolu 20060908 start
    /**
     *�����������ӹ���������ڱ������
     */
     function checkBeyondSumAmount(field)
     {
     	  var sumAmount = 0;
     		var kindLoss = 0;
     		var errorMessage = "";
     		sumAmount = parseFloat(fm.prpLclaimSumAmount.value);
     		kindLoss = parseFloat(field.value);
     		if( kindLoss > sumAmount )
     		{
     			errorMessage = "������ܴ��ڱ��� ";
     			alert(errorMessage);
     			field.select();
     			field.focus();
     			return false;
     		}
     		if(isNaN(kindLoss))
     		{
     			fm.prpLclaimLossKindLoss.value = 0;
     		}
     		return true;
     		
     }
    //add by zhaolu 20060908 end
</script>

<!--������ʾ��¼����������������ʾ��-->
<table class="common" cellpadding="5" cellspacing="1">
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="common" colspan="4">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="5">
         <tbody>
         <tr>
<%  
      //modify by lixiang add 20050316 start
      //reason:��������� 
%>            <td class="input" style="width:6%" >
                <select name="prpLclaimLossLossFeeType" style="width:50px" onclick="calSumClaim(this);collectClaimLoss();dutySum();" onblur=" checkBeyondQuota();" onchange="setFlagDanger();">
                   <option value="P">���</option>
                   <option value="Z">����</option>
                </select>
             </td>
                  <td class="input" style="width:4%" style="align:center">
                    <input name="prpLclaimLossItemKindNo" type="text"  title="������" class="readonly" readonly="readonly"> 
                 </td>
              <td class="input" style="width:16%" style="align:center">
                 <input type="text" name="prpLclaimLossKindCode" class="codecode" title="�ձ����"  style="width:20%" 
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1','code','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1','code','none','post');"
                >
                 
                 <input type="input" name="prpLclaimLossKindName" class="codecode" title="�ձ�����"  style="width:70%" 
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','name','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','name','none','post');"
                      onblur ="calSumClaim(this); checkBeyondQuota();">
                               
              </td>    
               
                <%

	         Map mapp =new HashMap();
             Double strDeductRate ;
        	 String strDeductRateName ="";
        	 Set setmapListKey = mapList.keySet();
        	 int kindNum =0;
        	 String kindCode1 ="";
        	 if (setmapListKey !=null&& setmapListKey.size()>0){
        		 kindNum = setmapListKey.size(); 
        		 
        	 for (Iterator mapListIt = setmapListKey.iterator(); mapListIt.hasNext();) {
        		 kindCode1 = (String) mapListIt.next();
        	         mapp =(Map)mapList.get(kindCode1);
        		
        		 Set setmapKey = mapp.keySet();
        		  
        		 for (Iterator mapIt = setmapKey.iterator(); mapIt.hasNext();) {
            		 String zeren = (String) mapIt.next();
            		 strDeductRate =(Double)mapp.get(zeren);
            		 System.out.println();System.out.println(strDeductRate);System.out.println();
            		// strDeductRate =dutyDeductibleRate.toString();
        		     strDeductRateName = kindCode1 + zeren;
        		    
        %>
         <input  name="kindCodedutyName" type="hidden" value ="<%=strDeductRateName%>">
          <input name="deductRate" type="hidden" value ="<%=strDeductRate%>">
        <%	  
        	   }   
               
        	
        	 }   
        }      
	%>
      <input name="kindNum" type="hidden" value ="<%=kindNum%>">     
               
             <td class="input" style="width:10%" align="center">
            
             <select name='prpLclaimLossFeeCategory' style="width:80px" onblur=" checkBeyondQuota();">
                  <option value="C" selected >����</option>
                  <option value="G">����</option>
                  <option value="M" >ҽ��</option>
                  <option value="D">�����˲�</option>
                  <option value="O">����</option>
                  
             </select>  
            </td>
            
         <!---add  by lym 20060606 for ǿ�� start -->   
               
             <td class="input" style="width:15%" align="center">
                 <input name="prpLclaimLossItemCode" type="hidden">
                 <input type="text" name="prpLclaimLossCurrency"  class="codecode" readonly style="width:30%" title="�ұ�" value="CNY">
                 <input type="text" name="prpLclaimLossCurrencyName" class="codecode" readonly="true" style="width:60%" value="�����">
             </td>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossKindLoss" class=common style="text-align:right"  onchange="setFlagDanger();checkBeyondQuota();calSumClaim(this);return checkBeyondSumAmount(this)" onblur=" calSumClaim(this); collectClaimLoss();dutySum();">
             </td>
             
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossSumClaim"  class="readonly" readonly  style="text-align:right" onblur=" collectClaimLoss();dutySum();" onchange="setFlagDanger();">
             </td>
             
         
              <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px" onblur="calSumClaim(this);" onchange="setFlagDanger();">
              </td> 
             <td class="input" style="width:8%">
                 <input name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10"
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
                   
                   
             </td>
             <%--<td class="input" style="width:10%">
                 <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
             </td>--%>        
             
              <td class="centertitle" style="display:none"><input type=button ACCESSKEY="." num=1  value='...' name='button_Engage_Open_Context00'
                      onclick="buttonOnClick2(this);"> 
                 <span id="span_Engage_Context00" style='width:520;display:none;position:absolute;background-color:FFFFFF;'>
                    <table class="common">
                       <tr><td class="prompttitle" colspan="6">����ԭ��</td> </tr>
                      <tr> 
                          <td class="prompt" colspan="6">
                              <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
                          </td>
                      </tr>     
                 
                       <tr>  
                        <td colspan=6 class="common" >
                         <input type=button class=button  name = 'button_Engage_Close_Context00' value='(O)�ر�' ACCESSKEY="O"  onclick="hideSubPage(this,'span_Engage_Context00')">  
                        </td> 
                      </tr>
                    </table> 
                  </span>
            </td>
             
             <td class="input" style='width:4%' colspan="1" align="center">
                 <div>
                   <input type=button name="buttonClaimLossDelete"  class="smallbutton" onclick="deleteRow(this,'ClaimLoss');setFlagDanger();" value="-" style="cursor: hand" >
                 </div>
             </td>
         </tr>
         </tbody>
      </table>
    </span>
    <span  id="spanClaimLoss" style="display:" >
     <%-- ��������չ���� --%>
     <table class="common" cellpadding="5" cellspacing="1" id="ClaimLoss" >
       <thead>
         <tr> 
         	  <td class="centertitle" style="width:6%">�������</td>
         	  <td class="centertitle" style="width:4%">������</td> 
              <td class="centertitle" style="width:16%">�ձ�</td>             
              <td class="centertitle" style="width:10%">��Χ</td>  <!---add  by lym 20060606 for ǿ�� --> 
              <td class="centertitle" style="width:15%">�ұ�</td>
              <td class="centertitle" style="width:10%">�ϱ�������</td>
              <td class="centertitle" style="width:10%">�ձ������</td>
              <td class="centertitle" style="width:8%">��ֵ</td>
              <td class="centertitle" style="width:8%">��������</td>
              <td class="centertitle" style="width:10%" style="display:none">����ԭ��</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectClaimLoss();collectCurrency();dutySum();" type="button" class="button" value="����ϼ�">
              </td>
         </tr>
       </thead>
       <tfoot>
         <tr>
            <td class="title" colspan=9 >(��"+"�ż���������������Ϣ����"-"�ż�ɾ����Ϣ)</td>
            <td class="title" align="right" style="width:4%">
               <div align="center">
                  <input type="button" value="+" class=smallbutton onclick="insertRow('ClaimLoss');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand">
               </div>
            </td>
        </tr>
      </tfoot>
   
    <tbody>
<script language="javascript">    
var damageKind = new Array();
<%
   String kindCode = "";
   PrpCitemKindDto prpCitemKindDto;
   ArrayList damageKindList = (ArrayList)request.getAttribute("damageKindList");  
   for(int k=0;k<damageKindList.size();k++)
   {
       prpCitemKindDto = (PrpCitemKindDto)damageKindList.get(k);
       kindCode = prpCitemKindDto.getKindCode();
%>  
       damageKind[<%=k%>]   ='<%=kindCode%>';
<%
    }
%>       
</script>       
       
 <% int indexClaimLoss=0;%>
 <% String displayType="readonly"; %>
 <% String buttonType="disabled"; %>
 <% String strReadOnly = "readonly";%>
 <% 
  if (editType.equals("ADD")){
  displayType="";
  buttonType="";
  strReadOnly = "common";}
%>  
<% 
  if (editType.equals("EDIT")){
  displayType="";
  buttonType="disabled";}

   //PrpLclaimLossDto prpLclaimLossDto1 = (PrpLclaimLossDto)request.getAttribute("prpLclaimLossDto");  
 
%>  
    <logic:notEmpty  name="prpLclaimLossDto"  property="claimLossList">
    <logic:iterate id="claimLoss" name="prpLclaimLossDto" property="claimLossList">
<% 
    
    if(indexClaimLoss %2== 0)
        out.print("<tr class=oddrow>");
    else
        out.print("<tr class=oddrow>");
%>
        <td class="input" style="width:6%" >
          <select name="prpLclaimLossLossFeeType" style="width:50px" onclick="calSumClaim(this);collectClaimLoss();dutySum();" onblur=" checkBeyondQuota();" onchange="setFlagDanger();">
                 <option value="P" <logic:equal name="claimLoss" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="claimLoss" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
          </select>
        </td>
       <td class="input" style="width:4%" >
         <input type="text" name="prpLclaimLossItemKindNo"   class="readonly" readonly="readonly" value="<bean:write name='claimLoss' property='itemKindNo'/>">
        </td>

       <td class="input" style="width:16%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:20%" title="�ձ�"
                      value="<bean:write name='claimLoss' property='kindCode' />"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,-1','code','none','post');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,-1','code','none','post');"
                       onchange="setFlagDanger();judgeKindCode(this);return checkBeyondSumAmount(this)" 
                        onblur=" calSumClaim(this); checkBeyondQuota();">    
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:70%" title="�ձ�"
                      value="<bean:write name='claimLoss' property='kindName'/>"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','name','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','name','none','post');" 
                       onblur=" calSumClaim(this); checkBeyondQuota();" onchange="setFlagDanger();"
                       >
               
         </td>
        <!---add  by lym 20060606 for ǿ�� start -->              
          <td class="input" style="width:10%" align="center">
          	 <select name='prpLclaimLossFeeCategory' style="width:80px" onblur=" checkBeyondQuota();">
               <option value="C" <logic:equal name="claimLoss" property="feeCategory" value='C'>selected</logic:equal> >����</option>
                <option value="G" <logic:equal name="claimLoss" property="feeCategory" value='G'>selected</logic:equal> >����</option>
               <option value="M" <logic:equal name="claimLoss" property="feeCategory" value='M'>selected</logic:equal> >ҽ��</option>
               <option value="D"  <logic:equal name="claimLoss" property="feeCategory" value='D'>selected</logic:equal> >�����˲�</option>
                <option value="O"  <logic:equal name="claimLoss" property="feeCategory" value='O'>selected</logic:equal> >����</option>
             </select>  
          </td>
        <!---add  by lym 20060606 for ǿ�� end -->              
         
         
         
         <td class="input" style="width:15%" align="center">
              <input type=text name="prpLclaimLossCurrency" class="codecode" readonly style="width:30%" title="�ұ�" value="<bean:write name='claimLoss' property='currency'/>">
              <input type=text name="prpLclaimLossCurrencyName" class="codecode" readonly style="width:60%" title="�ұ�"  value="<bean:write name='claimLoss' property='currencyName'/>">
              <input type="hidden" name="prpLclaimLossItemCode"   value="<bean:write name='claimLoss' property='itemCode'/>">
         </td>
         
         <td class="input" style="width:10%">
             <input name="prpLclaimLossKindLoss" class="<%=strReadOnly %>" style="text-align:right" value="<bean:write name='claimLoss' property='kindLoss' format='0.00' />" onchange="setFlagDanger();checkBeyondQuota();calSumClaim(this);return checkBeyondSumAmount(this)"  onblur=" calSumClaim(this); collectClaimLoss();dutySum(); ">
         </td>
         
         <td class="input" style="width:10%">
             <input name="prpLclaimLossSumClaim" class="readonly" readonly style="text-align:right" value="<bean:write name='claimLoss' property='sumClaim' format='0.00' />"  onblur=" collectClaimLoss();dutySum();"
              onchange="setFlagDanger();"
             >
         </td>
          <td class="input" style="width:8%">
          	      <input name="prpLclaimLossKindRest" class="<%=strReadOnly %>" style="width:50px" value="<bean:write name='claimLoss' property='kindRest' format='0.00' />" onblur="calSumClaim(this)">
                 
          </td> 
          
         <td class="input" style="width:8%">
             <input name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10" value="<bean:write name='claimLoss' property='inputDate' />">
         </td>
          <%-- <td class="input" style="width:10%">
             <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100" value="<bean:write name='claimLoss' property='remarkFlag' />">
         </td>--%>
         
        <td class="centertitle" style="display:none"><input type=button ACCESSKEY="." num=1  value='...' name='button_Engage_Open_Context00'
                      onclick="buttonOnClick2(this);"> 
                 <span id="span_Engage_Context00" style='width:520;display:none;position:absolute;background-color:FFFFFF;'>
                    <table class="common">
                       <tr><td class="prompttitle" colspan="6">����ԭ��</td> </tr>
                      <tr> 
                          <td class="prompt" colspan="6">
                              <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100" value="<bean:write name='claimLoss' property='remarkFlag' />">
                          </td>
                      </tr>              
                 
                       <tr>  
                        <td colspan=6 class="common" >
                         <input type=button class=button  name = 'button_Engage_Close_Context00' value='(O)�ر�' ACCESSKEY="O"  onclick="hideSubPage(this,'span_Engage_Context00')">  
                        </td> 
                      </tr>
                    </table>      
                 </span>
            </td>
 <%//modify by lixiang add 20050316 end%>
          <td class="input" style='width:4%' align="center">
              <div>
                <input type=button name="buttonClaimLossDelete" class=smallbutton onclick="deleteRow(this,'ClaimLoss');setFlagDanger();" <%=buttonType%> value="-" style="cursor: hand" >
              </div>
          </td>
       </tr>
 <%    indexClaimLoss++;%>
       </logic:iterate>
       </logic:notEmpty>
       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>