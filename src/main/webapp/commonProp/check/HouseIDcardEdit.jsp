<%--
****************************************************************************
* DESC       ：财产损失清单页面
* AUTHOR     ： 张菊卿
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 

   <!--建立显示的录入条，可以收缩显示的-->   
<script language='javascript'>  
 //在下面加入本页自定义的JavaScript方法
   function afterInsertEar()
      {
       //var countEar = getElementCount("prplCompensateHouseIDcard");
       //alert("数量：" + countEar);
       //if(countEar >= 2)
      // {
          //alert("只能添加一条农户信息!");
          //fm.buttonDriverInsert.style.display="none";
       //}

       

        //setPrpLpropSerialNo();
      }   
      
   function afterDeleteEar(field)
   {
      //var countEar = getElementCount("prplCompensateHouseIDcard");
     // alert("数量：" + countEar);
     // if(countEar < 2)
     // {
          //alert("只能添加一条农户信息!");
          //fm.buttonDriverInsert.style.display="";
      //}
       
         
         
      
   }
   
   function showBeforeClaim()
   {
     var policyno = "";
     var count = getElementCount("prplCompensateHouseIDcard");
     if(count < 2)
     {
        alert("请查询一条农户信息!");
     
     }
     else if (count > 2)
     {
        alert("只能查询一条农户!");
     }
     else
     {
        if(fm.prpLregistPolicyNo)
        {
           policyno = fm.prpLregistPolicyNo.value;
        }
        
        var field = document.getElementsByName("prplCompensateHouseIDcard")[1].value;
        window.open('/claim/perilInfoShow0310.do?idcard='+field + '&policyNo=' + policyno);
        //alert(field);
     }
        

     
   }

   function afterquery()
   {
      fm.buttonhouse.disabled = true;
      if(fm.buttontemp != null)
      {
      	fm.buttontemp.disabled = false;
      }
      
   
   }
   
   function afterdelete()
   {
      fm.buttonhouse.disabled = false;
      fm.buttontemp.disabled = true;
   }
   
   
  function formateIdEstimateLoss(field)
 {  
  var fieldname = field.name; 
  var i = 0;
  var findex=0;       
  var prplCompensateIdEstimateLoss;
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
    prplCompensateHouseEstimateLoss= parseFloat(fm.all("prplCompensateHouseEstimateLoss")[findex].value);

    if(isNaN(prplCompensateHouseEstimateLoss)||prplCompensateHouseEstimateLoss.length<1){
      prplCompensateHouseEstimateLoss = 0;
    }
    fm.all("prplCompensateHouseEstimateLoss")[findex].value = point(round(prplCompensateHouseEstimateLoss ,2),2);
    return true;  
}



//校验耳标清单金额数据格式

</script>   
<% String combineEarbackReadOnlyO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String combineEarbackDiasableO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String combineEarbackStyleO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<%      combineEarbackStyleO=";background:#CECECE";
 combineEarbackReadOnlyO="readOnly";
 combineEarbackDiasableO="disabled";
 String nodetypetemp2 = request.getParameter("nodeType");
 String editTypetemp2 = request.getParameter("editType");
 //System.err.println("nodetypetemp:"+nodetypetemp2);
%>    
  <input type="hidden" name= "nodeType"  value="<%= request.getParameter("nodeType")%>">
  <input type="hidden" name="listFlag" value="<%= request.getAttribute("ListFlag")%>">
  <span  id="SpanEar" style="display:" cellspacing="1" cellpadding="0">
  <table class="common" cellpadding="8" cellspacing="1">

  </table> 
      <span style="display:none"> 
          <table class="common" style="display:none" id="Ear_Data" cellpadding="8" cellspacing="1">
            <tbody>
              <tr>
                <td class="input" style="width:8%">          
                  <input name="prplCompensateHouseName" class=readonly readonly style='width:80px'  maxlength=20 >
                </td>
                <td class="input" style="width:17%">  
                  <input name="prplCompensateHouseIDcard" class=readonly readonly style='width:140px'  maxlength=24 >
                  
                </td>      
                <td class="input" style="width:16%">
                  <input name="prplCompensateHousehukoubu" class=readonly readonly style='width:140px'  maxlength=50 >
                </td>
                
                <td class="input" style="width:16%">
                  <input name="prplCompensateHouseAddress" class=readonly readonly style='width:200px'  maxlength=50 >
                </td>
                <td class="input" style="width:14%">
                  <input name="prplCompensateHousePhone" class=readonly readonly style='width:80px'  maxlength=50 >
                </td> 
                <td class="input" style="width:14%">
                  <input name="prplCompensateHouseRemark" class=readonly readonly style='width:200px'  maxlength=24 >
                </td>
                <td class="input" style="width:7%">         
                  <input name="prplCompensateHouseEstimateLoss" value ="0.0" class="common" style='width:70px'  maxlength=17 onBlur="formateIdEstimateLoss(this);setIdEstimateLoss3();">
                </td>  
                
                <td class="input" style="width:2%">  
					<input  name= "prplCompensateHouseInprocess" class=readonly readonly  style="width:20px"  maxlength=1 value="N">
                </td>
                

                <td class="input" style='width:4px'  align="center">
                <div>
                  <input type=button name="buttonEarDelete"  class="smallbutton" onclick="deleteRow(this,'Ear');afterdelete();" value="-" style="cursor: hand">
                </div> 
                  <input type="hidden" name="prplCompensateHousePolicyNo"  value="<%= request.getParameter("policyNo") %>">  
                  <input type="hidden" name="prplCompensateHouseRegistNo"  value="<%= request.getParameter("RegistNo") %>">       
                  <input type="hidden" name="prplCompensateHouseClaimNo">     
                  <input type="hidden" name="prplCompensateHouseCompensateNo">  
                  <input type="hidden" name="prplCompensateHouseCaseNo">       
                  <input type="hidden" name="prplCompensateHouseDamageStartDate">     
                  <input type="hidden" name="prplCompensateHouseDamageCode">          
                  <input type="hidden" name="prplCompensateHouseDamageName">        
                  <input type="hidden" name="prplCompensateHouseNodeNo">
                  <input type="hidden" name="prplCompensateHouseNodeType"  value="<%= request.getParameter("nodeType")%>">
                  <input type="hidden" name="prplCompensateHouseKindCode">
                  <input type="hidden" name="illegalFlag" value="false">
                
                
                
                     
                </td>
              </tr>  
            </tbody>
          </table>
        </span>        
        
        <span  id="spanEar" cellspacing="1" cellspacing="0"  width="100%">
        <%-- 多行输入展现域 --%>
        <table class="common"  id="Ear" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  				身份证：
             	  <input name="prplEarEarNoSearch" class="centertitle" style='width:150px'  maxlength=22   >
             	  农户姓名：
             	  <input name="prplEarNameSearch" class="centertitle" style='width:60px'  maxlength=17   >
             	  <%if("regis".equals(nodetypetemp2) &&(!editTypetemp2.equals("SHOW"))&&(!editTypetemp2.equals("DELETE"))){ %>
             	 <input type="button" value="历次赔案" name="buttontemp" disabled
               onclick="showBeforeClaim();"
             	 >
             	 <%} %>
             	  <input type="button" value="查询" name="buttonhouse"
             	  onclick="code_CodeMultSelect(this, 'prpLRegistHouseIdcardCheck1','-1,1,2,3,4,6,20,21,22,23,24,25','name','multSelect','post','',2,21,'prplCompensateHouseIDcard');afterquery();" 
             	 >

             	 
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:8%">农户姓名</td>
              <td class="centertitle" style="width:17%">身份证</td>
              <td class="centertitle" style="width:17%">户口簿</td>
              <td class="centertitle" style="width:17%">农户地址</td>
              <td class="centertitle" style="width:14%">联系电话</td>
              <td class="centertitle" style="width:15%">备注</td>
              <td class="centertitle" style="width:7%">估损金额</td>
              <td class="centertitle" style="width:2%">处理中</td>
              <td class="title" style="width:3%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            
          </tfoot>
          
          <tbody>
			<logic:notEmpty  name="prplCompensateHouseDtoList"  > 
			<logic:iterate id="prplCompensateHouseDto" name="prplCompensateHouseDtoList">
              <tr>        
               <td class="input" style="width:8%">              
                  <input name="prplCompensateHouseName" class=readonly readonly  style='width:80px'  maxlength=20  value="<bean:write name='prplCompensateHouseDto' property='name'/>">
                </td>      
                <td class="input" style="width:17%">              
                  <input name="prplCompensateHouseIDcard" class=readonly readonly style='width:140px'  maxlength=20 value="<bean:write name='prplCompensateHouseDto' property='idcard'/>">
                 
                </td>
                <td class="input" style="width:16%">         
                  <input name="prplCompensateHousehukoubu" class=readonly readonly style='width:140px'  maxlength=50 value="<bean:write name='prplCompensateHouseDto' property='hukoubu'/>">
                </td>
                <td class="input" style="width:16%">           
                  <input name="prplCompensateHouseAddress" class=readonly readonly style='width:200px'  maxlength=50 value="<bean:write name='prplCompensateHouseDto' property='address'/>">
                </td>
                <td class="input" style="width:14%">           
                  <input name="prplCompensateHousePhone" class=readonly readonly style='width:80px'  maxlength=50 value="<bean:write name='prplCompensateHouseDto' property='phone'/>">
                </td>

                <td class="input" style="width:14%">        
                  <input name="prplCompensateHouseRemark"  class=readonly readonly style='width:200px'  maxlength=24 value="<bean:write name='prplCompensateHouseDto' property='remark'/>">
                </td>
                <td class="input" style="width:7%">         
                  <input name="prplCompensateHouseEstimateLoss" value="<bean:write name='prplCompensateHouseDto' property='estimateloss'/>" class="common" style='width:70px'  maxlength=17 onBlur="formateIdEstimateLoss(this);setIdEstimateLoss3();">
                </td>
                <td class="input" style="width:2%">  
					<input  name= "prplCompensateHouseInprocess" class=readonly readonly  style="width:20px"  maxlength=1 value="N">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type="button" name="buttonEarDelete"  class="smallbutton" onclick="deleteRow(this,'Ear');afterdelete();"    value="-" style="cursor: hand">
                </div>
   				  <input type="hidden" name="prplCompensateHousePolicyNo"           value="<bean:write name='prplCompensateHouseDto' property='policyno'/>">  
                  <input type="hidden" name="prplCompensateHouseRegistNo"           value="<bean:write name='prplCompensateHouseDto' property='registno'/>">       
                  <input type="hidden" name="prplCompensateHouseClaimNo"            value="<bean:write name='prplCompensateHouseDto' property='claimno'/>">     
                  <input type="hidden" name="prplCompensateHouseCompensateNo"       value="<bean:write name='prplCompensateHouseDto' property='compensateno'/>">  
                  <input type="hidden" name="prplCompensateHouseCaseNo"             value="<bean:write name='prplCompensateHouseDto' property='caseno'/>">       
                  <input type="hidden" name="prplCompensateHouseDamageStartDate"    value="<bean:write name='prplCompensateHouseDto' property='damagestartdate'/>">     
                  <input type="hidden" name="prplCompensateHouseDamageCode"         value="<bean:write name='prplCompensateHouseDto' property='damagecode'/>">          
                  <input type="hidden" name="prplCompensateHouseDamageName"         value="<bean:write name='prplCompensateHouseDto' property='damagename'/>">        
                  <input type="hidden" name="prplCompensateHouseNodeNo"             value="">
                  <input type="hidden" name="prplCompensateHouseNodeType"           value="<%= request.getParameter("nodeType")%>">
                  <input type="hidden" name="prplCompensateHouseKindCode"           value="<bean:write name='prplCompensateHouseDto' property='kindcode'/>">
                  <input type="hidden" name="illegalFlag" value="false">
                </td>
              </tr>  
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 

        </span>    
        </table> 
        	<logic:notEmpty  name="prplCompensateHouseDtoList"  > 
			<logic:iterate id="prplCompensateHouseDto" name="prplCompensateHouseDtoList">
        <table class="common" border="0" align="center" cellpadding="6" cellspacing="1">   
        <tr>   
        <td class="title" style="width:13%">楼房层数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseFloor" class="readonly"style="width:20px" title="测试" value="<bean:write name='prplCompensateHouseDto' property='floor'/>">
        </td>
        <td class="title" style="width:13%">楼房间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseBuildingnumber" class="readonly"style="width:20px" title="测试" value="<bean:write name='prplCompensateHouseDto' property='buildingnumber'/>">
        </td>
        <td class="title" style="width:13%">砖墙间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseZhuannumber" class="readonly"style="width:20px" title="测试" value="<bean:write name='prplCompensateHouseDto' property='zhuannumber'/>">
        </td>
        </tr>
        <tr>   
        <td class="title" style="width:13%">土墙间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseWanumber" class="readonly"style="width:20px" title="测试" value="<bean:write name='prplCompensateHouseDto' property='wanumber'/>">
        </td>
        <td class="title" style="width:13%">其他间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseOthernumber" class="readonly"style="width:20px" title="测试" value="<bean:write name='prplCompensateHouseDto' property='othernumber'/>">
        </td>
        <td class="title" style="width:13%">单建厨房间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseKitchennumber" class="readonly"style="width:20px" title="测试" value="<bean:write name='prplCompensateHouseDto' property='kitchennumber'/>">
        </td>
        </tr>
        </table>
      </logic:iterate> 
      </logic:notEmpty>  
      
        <logic:empty  name="prplCompensateHouseDtoList"  > 
        <table class="common" border="0" align="center" cellpadding="6" cellspacing="1">   
        <tr>   
        <td class="title" style="width:13%">楼房层数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseFloor" class="readonly"style="width:25px"  value="">
        </td>
        <td class="title" style="width:13%">楼房间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseBuildingnumber" class="readonly"style="width:25px"  value="">
        </td>
        <td class="title" style="width:13%">砖墙间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseZhuannumber" class="readonly"style="width:25px" value="">
        </td>
        </tr>
        <tr>   
        <td class="title" style="width:13%">土墙间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseWanumber" class="readonly"style="width:25px"  value="">
        </td>
        <td class="title" style="width:13%">其他间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseOthernumber" class="readonly"style="width:25px"  value="">
        </td>
        <td class="title" style="width:13%">单建厨房间数</td>
        <td class="input" style="width:20%" >
           <input type=text readonly=true name="prplCompensateHouseKitchennumber" class="readonly"style="width:25px" value="">
        </td>
        </tr>
        </table>
      </logic:empty>  
</span> 