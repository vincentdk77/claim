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
 
</script>


   <!--表示显示多行的-->
<tr>
  <td class="subformtitle" colspan="4" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="prpLacciPersonImg" onclick="showPage(this,spanAcciPerson)">
        事故者信息<br>
     <table cellpadding="5" cellspacing="1" class="common"  id="AcciPerson_Data" style="display:none">
       <tbody>
        <tr>
          <td style="width:3%" class=common>
             <div align="center">
               <input class="readonlyNo" readonly name="prpLacciBenPersonSerialNo" description="序号">
             </div>
          </td>
                <td class="input" align=left  style="display:none">
                  <input type="hidden" name="prpLacciPersonAddress"  title="牛号" class="input">
                  <input type="text" name="prpLacciPersonAcciCode" 
                    title="事故者代码"  class="codecode" maxLength="16" onblur="checkLength1(this);"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');"
                    onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');">
                </td>
                <td class="input" align=left style="width:30%">
                  <%-- 隐藏被保险人序号 --%>
                  <input type=hidden name="prpLacciPersonFamilyNo"  class="input" />
                  <input type=text name="prpLacciPersonAcciName" title="事故者姓名" 
                   class="codecode"  title="事故者姓名"  maxLength="120" onblur="checkLength1(this);"
                   ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type=hidden name="prpLacciPersonSex"  class="input" />
                <input type=hidden name="prpLacciPersonAge"  class="input" / value="0"> 
                </td>
                
                <td class="input" align=left style="width:30%">
                  <input type=text name="prpLacciPersonIdentifyNumber"  readonly="true"  title="身份证号" class="input">
               </td>
               <td class="input" align=center style="width:20%">
                   <%@include file="/common/regist/Benerisk.jsp"%>
               </td>  
          <td class="input" style='width:4%'>
          <div align="center">
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
                <td  style="display:none">事故者代码</td>
                <td  style="width:30%">事故者名称</td>
                <td  style="width:30%">身份证号码</td>
                <td  style="width:20%">保益信息</td>
                <td  style="width:12%">&nbsp;</td>
              </tr>
            </thead>
           <tfoot>
              <tr>
                <td colspan=4  align="center" class="title" >(按"+"号键增加事故者信息，按"-"号键删除信息)</td>
                <td class="title"  colspan=1 align="center" >
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
                     <td class="input" align=left  style="display:none">
                       <input type="hidden" name="prpLacciPersonAddress"  title="牛号" class="input" value="<bean:write name='prpLacciBenPerson' property='address' filter='true' />">
                       <input type="text" name="prpLacciPersonAcciCode" value="<bean:write name='prpLacciBenPerson' property='acciCode' filter='true' />"
                       title="事故者代码"  class="codecode"    maxLength="16" onblur="checkLength1(this);"
                       ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');"
                       onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');">
                     </td>
                     <td class="input" align=left style="width:30%">
                        <%-- 隐藏被保险人序号 --%>
                        <input type=hidden name="prpLacciPersonFamilyNo"  value="<bean:write name='prpLacciBenPerson' property='familyNo' filter='true' />" class="input" />
                        <input type=text name="prpLacciPersonAcciName" title="事故者姓名" value="<bean:write name='prpLacciBenPerson' property='acciName' filter='true' />"
                           class="codecode"  title="事故者姓名" maxLength="120" onblur="checkLength1(this);"
                           ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                           onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                     <input type=hidden name="prpLacciPersonSex"  class="input" />
                     <input type=hidden name="prpLacciPersonAge"  class="input" / value="0"> 
                     </td>
                     <td class="input" align=left style="width:30%">
                          <input type=text name="prpLacciPersonIdentifyNumber"  readonly="true"  title="身份证号" class="input"  value="<bean:write name='prpLacciBenPerson' property='identifyNumber' filter='true' />">
                       
                      </td>
                      <td class="input" align=center style="width:20%">
                          <%@include file="/common/regist/Benerisk.jsp"%>
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
 
