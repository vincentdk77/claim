<%--
****************************************************************************
* DESC       �����������ֻ���Ϣ����
* AUTHOR     �� Sinosoft 
* CREATEDATE �� 2005-09-01
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page import="java.util.*"%>

 
   <!--������ʾ��¼����������������ʾ��-->
   
    <script language='javascript'>
    <!--    
      //��������뱾ҳ�Զ����JavaScript����

      /*
        ����һ���µ�֮��Ĵ�����ѡ������ 
      */ 
      function afterInsertCompanyMobile()
      {
        setPrpLregistExtSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteCompanyMobile(field)
      {         
        setPrpLregistExtSerialNo();
      }
     
      /** 
       * ����setPrpLregistExtSerialNo
       */
      function setPrpLregistExtSerialNo(){
        var count=getElementCount("prpLscheduleCompanyMobileSerialNo");
        for(var i=0;i<count;i++)
        {
        
          if(count!=1){
              fm.prpLscheduleCompanyMobileSerialNo[i].value=i;
          } 
        } 
      }   
		   //-->      
    </script>    
 <%

          		     Collection collection = (Collection)request.getAttribute("dayList"); 
%>
   <table class="common" align="center" width="100%"> 
    <!--��ʾ��ʾ���е�-->   
    <tr> 
      <td class="subformtitle" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
             name="CompanyMobileImg" onclick="showPage(this,spanCompanyMobile)">
             ��ϵ�ֻ���Ϣ<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="CompanyMobile_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
              
                
                <td class="input"> 
                  <input type="hidden"  name="prpLscheduleCompanyMobileFlag">
                  <input type="text" class="readonly" readonly  name="prpLscheduleCompanyMobileSerialNo" description="���">
                </td> 
                
                <td class="input"> 
                 <input type="text" class="input" name="prpLscheduleCompanyMobileLinkerName" description="��ϵ��" class="input" maxlength="20" style="width:90%" value="">
                </td> 
                
                <td class="input">
                  <input type="text" name="prpLscheduleCompanyMobileMobileNo" class="input" maxlength="40" style="width:95%" value="">    
                </td>
                <td class="input">
                  <input type="text"  name="prpLscheduleCompanyMobileRemark" class="input" maxlength="35" style="width:90%" value="">    
                </td>
                <td class="input">           		 
                  <select name="onDutyDay" styleClass="three">
                   <%
                      Iterator prpLPartCodeNameList = collection.iterator();
                      while (prpLPartCodeNameList.hasNext()){
                      LabelValueBean labelValueBean = (LabelValueBean)prpLPartCodeNameList.next();
                   %>
                      <option value="<%= labelValueBean.getValue() %>"><%= labelValueBean.getLabel() %></option>
                   <%
                       }
                   %> 
                    </select>    
            
                </td>
               
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonCompanyMobileDelete"  onclick="deleteRow(this,'CompanyMobile')" value="-" style="cursor: hand">
                </div>
                </td> 
              </tr>              
            </tbody>
          </table>
        </span>        
        
        <span  id="spanCompanyMobile" style="display:" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="CompanyMobile" >
          <thead>
            <tr>
                <td class="centertitle" style="width:6%">���</td>
                <td class="centertitle" style="width:10%">��ϵ��</td>
                <td class="centertitle" style="width:30%">�ֻ���</td>
                <td class="centertitle" style="width:40%">��ע</td>
                <td class="centertitle" style="width:10%">ֵ��</td>
              <td class="title" style="width:4%" >&nbsp;</td> 
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=5 style="width:96%">(��"+"�ż����Ӱ�������˵������"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('CompanyMobile')" name="buttonDriverInsert" style="cursor: hand">
                 </div> 
                 </td> 
              </tr>
          </tfoot>
          <tbody>
 <% int indexCompanyMobile=0;%>
<logic:notEmpty  name="scheduleCompanyDto"  property="prpLschecduleCompanyMobileDtoList"> 
<logic:iterate id="MobileList1" name="scheduleCompanyDto" property="prpLschecduleCompanyMobileDtoList">
              
            
              <tr>
                <td class="input"> 
                  <input type="hidden"  name="prpLscheduleCompanyMobileFlag" value="">
                  <input  type="text"  name="prpLscheduleCompanyMobileSerialNo" class="readonly" readonly value="<bean:write name='MobileList1' property='serialNo'/>">
                </td> 
                
                 <td class="input"> 
                 <input type="text" class="input" name="prpLscheduleCompanyMobileLinkerName" description="��ϵ��" class="input" maxlength="20" style="width:90%" value="<bean:write name='MobileList1' property='linkerName'/>">
                </td>
                
                <td class="input"> 
                  <input  type="text" name="prpLscheduleCompanyMobileMobileNo" class="input" maxlength="40" style="width:95%" value="<bean:write name='MobileList1' property='mobileNo'/>">    
                </td>
                <td class="input">
                  <input  type="text" name="prpLscheduleCompanyMobileRemark"  class="input" maxlength="35"  style="width:90%" value="<bean:write name='MobileList1' property='remark'/>">
                </td>

                <td class="input">
                  <html:select name="MobileList1" property="onDutyDay" styleClass="three">
                    <html:options  collection="dayList" property="value" labelProperty="label"/>
                  </html:select>
                <td class="input" style='width:4%'  align="center">
                <div>
                    <input type=button name="buttonCompanyMobileDelete"  onclick="deleteRow(this,'CompanyMobile')" value="-" style="cursor: hand">
              </div>
                </td>
              </tr>
 <%    indexCompanyMobile++;%>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td> 
    </tr>
  </table>
