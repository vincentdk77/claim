<%--
****************************************************************************
* DESC       ：农险事故者信息页面
* AUTHOR     ：chenrenda
* CREATEDATE ：2006-06-27
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>


<script language='javascript'>

    function afterInsertAcciPerson()
    {
        setPrpLAcciPersonSerialNo();
    }
    
    /**
     * 删除本条AcciPerson之后的处理（可选方法）
     */
    function afterDeleteAcciPerson(field)
    {
        setPrpLAcciPersonSerialNo();
    }

    /**
     * 设置setPrpLAcciPersonSerialNo
     */
    function setPrpLAcciPersonSerialNo(){
        var count=getElementCount("prpLacciBenPersonSerialNo");
        for(var i=0;i<count;i++)
        {
            if(count!=1){
            	fm.prpLacciBenPersonSerialNo[i].value=i;
            }
        }
    }
    function checkInteger(field)
    {
      field.value = trim(field.value);
      var strValue=field.value;
      if(strValue=="")
        strValue = "0";
      var desc   = field.description;
      
      //如果description属性不存在，则用name属性
      if(desc==null)
        desc = field.name;
      
      if(isNaN(strValue)||!isInteger(strValue))
      {
        errorMessage("请输入合法的" + desc +"\n类型为数字");
        field.focus();
        field.select();
        return false;
      }
      return true;
    }    
</script>


 
   <!--表示显示多行的-->
<tr>
  <td class="common" colspan="4" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="prpLacciPersonImg" onclick="showPage(this,spanAcciPerson)">
        出险标的<br>
     <table cellpadding="5" cellspacing="1" class="common"  id="AcciPerson_Data" style="display:none">
       <tbody>
        <tr>
          <td style="width:3%" class=common>
             <div align="left">
               <input class="readonlyNo" readonly name="prpLacciBenPersonSerialNo" description="序号">
             </div>
          </td>
          <td  class=common colspan=4 style="width:93%">
            <table  cellpadding="2" cellspacing="1" class="common">
              <tr>
                <td class="input" align=left style='width:24%'>
                   <input type=text name="prpLacciPersonAddress" description="牛号" onblur="checkInteger(this)"  title="牛号" class="input">
                </td>
                <td class="input" align=left style="width:24%">
                   <input type="hidden" name="prpLacciPersonAcciCode" 
                    title="被保险人代码">
                  <input type=text name="prpLacciPersonAcciName" title="被保险人名称" 
                   class="codecode"  
                   ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                <input type=hidden name="prpLacciPersonSex"  class="input" />
                <input type=hidden name="prpLacciPersonAge"  class="input" / value="0"> 
                </td>
                
                <td class="input" align=left style="width:28%">
                  <input type=text name="prpLacciPersonIdentifyNumber"  readonly="true"  title="身份证号" class="input">
                  <%-- 隐藏被保险人序号 --%>
                  <input type=hidden name="prpLacciPersonFamilyNo"  class="input" />
                
                 
               </td>
               <td class="input" align=center style="width:16%">
                   <%@include file="/common/regist/3202Benerisk.jsp"%>
               </td>  
              </tr>
            </table>
          </td>
          <td class="input" style='width:4%'>
          <div align="right">
            <input type=button name="buttonAcciPersonDelete"  class=smallbutton onclick="deleteRow(this,'AcciPerson')" value="-" style="cursor: hand">
          </div>
          </td>
       </tr>
     </tbody>
  </table>

  <span  id="spanAcciPerson" style="display:">
     <%-- 多行输入展现域 --%>
    <table class=common id="AcciPerson" cellpadding="5" cellspacing="1">
            <thead>
              <tr class=listtitle>
                <td  style="width:8%">序号</td>
                <td  style="width:24%">牛号</td>
                <td  style="width:24%">被保险人名称</td>
                <td  style="width:28%">身份证号码</td>
                <td  style="width:16%">保益信息</td>
              </tr>
            </thead>
           <tfoot>
              <tr>
                <td colspan=6  align="center" class="title" >(按"+"号键增加事故者信息，按"-"号键删除信息)</td>
                <td class="title"  colspan=1 align="right" >
                   <input type="button" value="+" class=smallbutton onclick="insertRow('AcciPerson')" name="buttonAcciPersonInsert" style="cursor: hand">
                </td>
              </tr>
           </tfoot>
           <tbody>
            <% int  benIndex=0;   %>
       <logic:notEmpty  name="prpLacciPersonDto"  property="prpLacciBenPersonList">
          <logic:iterate id="prpLacciBenPerson" name="prpLacciPersonDto" property="prpLacciBenPersonList">

<%
   if(benIndex %2== 0){
        out.print("<tr class=oddrow>");
    }
    else{
        out.print("<tr class=oddrow>");
    }
%>

              <td class="input" style="width:3%">
                <div align="center">
                  <input  name="prpLacciBenPersonSerialNo"  class="readonlyno" readonly="true"  value="<bean:write name='prpLacciBenPerson' property='serialNo'/>">
                </div>
              </td>
              <td class="common"  colspan=4 style="width:93%">
                <table  cellpadding="5" cellspacing="1" class="common">
                  <tr>
                     <td class="input" align=left style="width:24%">
                       <input type=text name="prpLacciPersonAddress" description="牛号"  value="<bean:write name='prpLacciBenPerson' property='address' filter='true' />"  title="牛号" class="input">
                     </td>
                     <td class="input" align=left style="width:24%">
                       <input type="hidden" name="prpLacciPersonAcciCode" value="<bean:write name='prpLacciBenPerson' property='acciCode' filter='true' />"
                        title="被保险人代码"  class="codecode"  >
                        <input type=text name="prpLacciPersonAcciName" title="被保险人名称" value="<bean:write name='prpLacciBenPerson' property='acciName' filter='true' />"
                           class="codecode" 
                           ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
                           onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                     <input type=hidden name="prpLacciPersonSex"  class="input" />
                     <input type=hidden name="prpLacciPersonAge"  class="input" / value="0"> 
                     </td>
                     <td class="input" align=left style="width:28%">
                          <input type=text name="prpLacciPersonIdentifyNumber"  readonly="true"  title="身份证号" class="input"  value="<bean:write name='prpLacciBenPerson' property='identifyNumber' filter='true' />">
                          <%-- 隐藏被保险人序号 --%>
                          <input type=hidden name="prpLacciPersonFamilyNo"  value="<bean:write name='prpLacciBenPerson' property='familyNo' filter='true' />" class="input" />
                      </td>
                      <td class="input" align=center style="width:16%">
                          <%@include file="/common/regist/3202Benerisk.jsp"%>
                      </td>   
                  </tr>
                </table> 
              </td>
              <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonAcciPersonDelete" class=smallbutton  onclick="deleteRow(this,'AcciPerson')" value="-" style="cursor: hand">
                  </div>
              </td>  
             </tr>   
             <% benIndex++;%>
  </logic:iterate>
</logic:notEmpty>
          </tbody>
        </table>
       </span>
  </td>
</tr>
 
