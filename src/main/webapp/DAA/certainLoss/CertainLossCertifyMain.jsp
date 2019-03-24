<%--
****************************************************************************
* DESC       ���ļ��ϴ�����
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-08
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>

<html:html>
<head>
    <!--��title����-->
    <title>Ԥ��Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script language='javascript'>
    //��������뱾ҳ�Զ����JavaScript����

      /*
      ����һ���µ�֮��Ĵ�����ѡ������
    */
    function afterInsertCertify()
    {
      setPrpLcertifyImgSerialNo();
    }

    /*
      ɾ������WarnRegion֮��Ĵ�����ѡ������
    */
    function afterDeleteCertify(field)
    {

      setPrpLcertifyImgSerialNo();
    }

    /**
     * ����setPrpLcertifyImgSerialNo
     */
    function setPrpLcertifyImgSerialNo(){
      var count=getElementCount("prpLcertifyImgSerialNo");
      for(var i=0;i<count;i++)
      {
        //alert("����ʲôʱ������?count="+count+"  i="+i);
        if(count!=1){
          fm.prpLcertifyImgSerialNo[i].value=i;
        }
      }
    }
  </script>
</head>
<body  onload="initPage();" >
    <form name=fm action="/claim/certainLossCertify.do" method="post" encType="multipart/form-data" onsubmit="return validateForm(this);">


<!--������ʾ��¼����������������ʾ��-->
<table class="common" align="center" cellpadding="5" cellspacing="1" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="subformtitle" colspan="4">����֤�ռ�<br>
     <span style="display:none">
       <table class="common" style="display:none" id="Certify_Data" cellspacing="1" cellpadding="0">
         <tbody>
            <tr>

              <td class="input">
                <input type="hidden" name="prpLcertifyImgSerialNo">
                <input type="hidden" name="prpLcertifyImgBusinessNo" value="<bean:write name='prpLcertifyImgDto' property='businessNo'/>">
                <input type="hidden" name="prpLcertifyImgSignInDate" value="<bean:write name='prpLcertifyImgDto' property='signInDate'/>">
                <input type="hidden" name="prpLcertifyImgThirdPartyCode" value="<bean:write name='prpLcertifyImgDto' property='thirdPartyCode'/>">
                <input type="hidden" name="prpLcertifyImgImgFileName">
                <input type="hidden" name="prpLcertifyImgPicPath">
                <input type="hidden" name="prpLcertifyImgCollectorName" value="<bean:write name='prpLcertifyImgDto' property='collectorName'/>">
                <input type="hidden" name="prpLcertifyImgReceiveStatus" value="1">
                <input type="hidden" name="prpLcertifyImgImgSize">
                <input type="hidden" name="prpLcertifyImgLossItemName">
                <input type="hidden" name="prpLcertifyImgPicName">
                <input type="hidden" name="prpLcertifyImgUploadNodeFlag"  value="<bean:write name='prpLcertifyImgDto' property='uploadNodeFlag'/>">
                <input type="hidden" name="prpLcertifyImgFlag" value="<bean:write name='prpLcertifyImgDto' property='flag'/>">
                <html:select name="prpLcertifyImgDto" property="lossItemCode" >
                  <html:options collection="lossItemList"  property="value" labelProperty="label"/>
                </html:select>
              </td>
              <td class="input">
                <html:select name="prpLcertifyImgDto" property="typeCode" >
                  <html:options collection="typeCodeList"  property="value" labelProperty="label"/>
                </html:select>
              </td>
              <td class="input">
                 <input class="input" name="prpLcertifyImgUploadFileName" readonly="true">
              </td>
              <td class="input">
                <input name="fileUploadField" type="file" >
              </td>
              <td class="input">
                <input type="button" name=buttonSave class=button value="�� ��" onclick="alert('�鿱�ļ�');return false;">
              </td>
              <td class="input" style='width:4%'  align="center">
              <div>
                <input type=button name="buttonCertifyDelete"  class=smallbutton onclick="deleteRow(this,'Certify')" value="-" style="cursor: hand">
              </div>
              </td>
            </tr>
        </tbody>
     </table>
  </span>
  <span  id="spanCertify" style="display:">
     <%-- ��������չ���� --%>
     <table class="common" cellpadding="5" cellspacing="1" id="Certify" >
       <thead>
         <tr>
           <td class="centertitle" style="width:10%">������ϵ</td>
           <td class="centertitle" style="width:20%">��֤����</td>
           <td class="centertitle" style="width:20%">��ص�֤˵��</td>
           <td class="centertitle" style="width:36%">�ļ�������</td>
           <td class="centertitle" style="width:10%">�鿴</td>
           <td class="centertitle" style="width:4%" >&nbsp;</td>
         </tr>
       </thead>
       <tfoot>
         <tr>

            <td class="title" align="right" colspan=6 >
               <div align="center">
                  <input type="button" value="+" onclick="insertRow('Certify')" class=smallbutton name="buttonCertifyInsert" style="cursor: hand">
               </div>
            </td>
        </tr>
      </tfoot>
    </tfoot>
    <tbody>

<logic:notEmpty  name="prpLcertifyImgDto"  property="certifyImgList">
<logic:iterate id="ciList" name="prpLcertifyImgDto" property="certifyImgList">

              <logic:equal name="ciList" property="uploadNodeFlag" value="certa">
            <tr>
              <td class="input">
                <html:select name="ciList" property="lossItemCode" >
                  <html:options collection="lossItemList"  property="value" labelProperty="label"/>
                </html:select>
              </td>
              <td class="input">
                <html:select name="ciList" property="typeCode" >
                  <html:options collection="typeCodeList"  property="value" labelProperty="label"/>
                </html:select>
              </td>
              <td class="input">
                 <input class="input" name="prpLcertifyImgUploadFileName" readonly="true" value="<bean:write name='ciList' property='uploadFileName' filter='true' />">
              </td>
              <td class="input">
                <input name="fileUploadField" type="file" style="width:240px">
              </td>
              <td class="input">
                <input type="button" name=buttonSave value="�鿴" class="button" onclick="viewFile('<bean:write name="ciList" property="imgFileName"/>','<bean:write name="ciList" property="businessNo"/>');return false;">
              </td>
              <td class="input" style='width:4%'  align="center">
              <div>
                <input type=button name="buttonCertifyDelete"  class="smallbutton" onclick="deleteRow(this,'Certify')" value="-" style="cursor: hand">
              </div>
              </td>
            </tr>
            <input type="hidden" name="prpLcertifyImgSerialNo" value="<bean:write name='ciList' property='serialNo'/>">
            <input type="hidden" name="prpLcertifyImgBusinessNo" value="<bean:write name='ciList' property='businessNo'/>">
            <input type="hidden" name="prpLcertifyImgSignInDate" value="<bean:write name='ciList' property='signInDate'/>">
            <input type="hidden" name="prpLcertifyImgThirdPartyCode" value="<bean:write name='ciList' property='thirdPartyCode'/>">
            <input type="hidden" name="prpLcertifyImgImgFileName" value="<bean:write name='ciList' property='imgFileName'/>">
            <input type="hidden" name="prpLcertifyImgPicPath" value="<bean:write name='ciList' property='picPath'/>">
            <input type="hidden" name="prpLcertifyImgCollectorName" value="<bean:write name='ciList' property='collectorName'/>">
            <input type="hidden" name="prpLcertifyImgReceiveStatus" value="<bean:write name='ciList' property='receiveStatus'/>">
            <input type="hidden" name="prpLcertifyImgImgSize" value="<bean:write name='ciList' property='imgSize'/>">
            <input type="hidden" name="prpLcertifyImgLossItemName" value="<bean:write name='ciList' property='lossItemName'/>">
            <input type="hidden" name="prpLcertifyImgPicName" value="<bean:write name='ciList' property='picName'/>">
            <input type="hidden" name="prpLcertifyImgUploadNodeFlag" value="<bean:write name='ciList' property='uploadNodeFlag'/>">
            <input type="hidden" name="prpLcertifyImgFlag" value="<bean:write name='ciList' property='flag'/>">

            </logic:equal>
</logic:iterate>
</logic:notEmpty>

       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>



<table class="common" align="center"  cellpadding="5" cellspacing="1">
 <!--��ʾ��ʾ���е�-->
  <tr>
  <td  class="centertitle">�鿱�ڵ��ϴ��ĵ�֤</td>
  </tr>
 <tr>
   <td class="common">
       <table class="common" cellpadding="5" cellspacing="1">
         <thead>
           <tr>
             <td class="centertitle" style="width:10%">������ϵ</td>
             <td class="centertitle" style="width:20%">��֤����</td>
              <td class="centertitle" style="width:20%">��ص�֤˵��</td>
             <td class="centertitle" style="width:36%">�ļ�������</td>
             <td class="centertitle" style="width:10%">�鿴</td>
             <td class="centertitle" style="width:4%" >&nbsp;</td>
           </tr>
         </thead>
         <tfoot>
         </tfoot>
          <tbody>

<logic:notEmpty  name="prpLcertifyImgDto"  property="certifyImgList">
<logic:iterate id="ciList" name="prpLcertifyImgDto" property="certifyImgList">

              <logic:equal name="ciList" property="uploadNodeFlag" value="check">
            <tr>
              <td class="input">
                <html:select name="ciList" property="lossItemCode" >
                  <html:options collection="lossItemList"  property="value" labelProperty="label"/>
                </html:select>
              </td>
              <td class="input">
                <html:select name="ciList" property="typeCode" >
                  <html:options collection="typeCodeList"  property="value" labelProperty="label"/>
                </html:select>
              </td>
              <td class="input">
                 <input class="input" name="prpLcertifyImgUploadFileName" readonly="true" value="<bean:write name='ciList' property='uploadFileName' filter='true' />">
              </td>
              <td class="input">
                <input name="fileUploadField" type="hidden" style="width:240px">
              </td>
              <td class="input">
                <input type="button" name=buttonSave class=button value="�鿴" onclick="viewFile('<bean:write name="ciList" property="imgFileName"/>','<bean:write name="ciList" property="businessNo"/>');return false;">
              </td>
              <td class="input" style='width:4%'  align="center">&nbsp;</td>
            </tr>
            <input type="hidden" name="prpLcertifyImgSerialNo" value="<bean:write name='ciList' property='serialNo'/>">
            <input type="hidden" name="prpLcertifyImgBusinessNo" value="<bean:write name='ciList' property='businessNo'/>">
            <input type="hidden" name="prpLcertifyImgSignInDate" value="<bean:write name='ciList' property='signInDate'/>">
            <input type="hidden" name="prpLcertifyImgThirdPartyCode" value="<bean:write name='ciList' property='thirdPartyCode'/>">
            <input type="hidden" name="prpLcertifyImgImgFileName" value="<bean:write name='ciList' property='imgFileName'/>">
            <input type="hidden" name="prpLcertifyImgPicPath" value="<bean:write name='ciList' property='picPath'/>">
            <input type="hidden" name="prpLcertifyImgCollectorName" value="<bean:write name='ciList' property='collectorName'/>">
            <input type="hidden" name="prpLcertifyImgReceiveStatus" value="<bean:write name='ciList' property='receiveStatus'/>">
            <input type="hidden" name="prpLcertifyImgImgSize" value="<bean:write name='ciList' property='imgSize'/>">
            <input type="hidden" name="prpLcertifyImgLossItemName" value="<bean:write name='ciList' property='lossItemName'/>">
            <input type="hidden" name="prpLcertifyImgPicName" value="<bean:write name='ciList' property='picName'/>">
            <input type="hidden" name="prpLcertifyImgUploadNodeFlag" value="<bean:write name='ciList' property='uploadNodeFlag'/>">
            <input type="hidden" name="prpLcertifyImgFlag" value="<bean:write name='ciList' property='flag'/>">

            </logic:equal>
</logic:iterate>
</logic:notEmpty>

       </tbody>
     </table>

   </td>
  </tr>
</table>
<%
  String str1 = request.getParameter("openFlag");
  if(str1!=null){
%>
<%-- ����ͨ�ð�ť --%>
  <table cellpadding="0" cellspacing="0"class="common">
    <tr>
      <td class=button  align="center">
        <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="����" onclick="return fileSavePop(this,'3');">
      </td>
      <td class=button  align="center">
        <!--ȡ����ť-->
        <input type=button name=buttonCancel class='button' value="�ر�" onclick="top.close();return false;" >
      </td>
    </tr>
  </table>
<%
  }else{
%>
  <%-- ����ͨ�ð�ť --%>
  <table cellpadding="0" cellspacing="0"class="common">
    <tr>
      <td class=button align="center">
        <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="����" onclick="return fileSave(this,'3');">
      </td>
      <td class=button  align="center">
        <!--ȡ����ť-->
        <input type=button name=buttonCancel class='button' value="ȡ��" onclick="history.back();return false;" >
      </td>
    </tr>
  </table>
<%
  }
%>
  <input type="hidden" name="editType" value="fileUpload">
   <input type="hidden" name="nodeType" value="certa">
  <input type="hidden" name="prpLcertifyCollectBusinessNo" value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
  <input type="hidden" name="prpLcertifyCollectLossItemCode" value="<bean:write name='prpLcertifyCollectDto' property='lossItemCode'/>">
  <input type="hidden" name="prpLcertifyCollectLossItemName" value="<bean:write name='prpLcertifyCollectDto' property='lossItemName'/>">
  <input type="hidden" name="prpLcertifyCollectPicCount" value="<bean:write name='prpLcertifyCollectDto' property='picCount'/>">
  <input type="hidden" name="prpLcertifyCollectStartDate" value="<bean:write name='prpLcertifyCollectDto' property='startDate'/>">
  <input type="hidden" name="prpLcertifyCollectStartHour" value="<bean:write name='prpLcertifyCollectDto' property='startHour'/>">
  <input type="hidden" name="prpLcertifyCollectEndDate" value="<bean:write name='prpLcertifyCollectDto' property='endDate'/>">
  <input type="hidden" name="prpLcertifyCollectEndHour" value="<bean:write name='prpLcertifyCollectDto' property='endHour'/>">
  <input type="hidden" name="prpLcertifyCollectOperatorCode" value="<bean:write name='prpLcertifyCollectDto' property='operatorCode'/>">
  <input type="hidden" name="prpLcertifyCollectCaseFlag" value="<bean:write name='prpLcertifyCollectDto' property='caseFlag'/>">
  <input type="hidden" name="prpLcertifyCollectFlag" value="<bean:write name='prpLcertifyCollectDto' property='flag'/>">
  <input type="hidden" name="collectFlag" value="<bean:write name='prpLcertifyCollectDto' property='collectFlag'/>">
  <input type="hidden" name="prpLcertifyCollectContent" value="<bean:write name='prpLcertifyCollectDto' property='content'/>">


     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
