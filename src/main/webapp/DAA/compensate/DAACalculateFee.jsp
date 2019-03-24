<%--
****************************************************************************
* DESC       �� �������
* AUTHOR     ��liubvo
* CREATEDATE �� 2005-04-05
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"  %>

<%
    String findex  = request.getParameter("findex");
%>

<html>
<head>
    <!--��title����-->
    <title>���ü���</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/DAA/compensate/js/DAAPersonLossEdit.js"></script>
<script language="javascript">
<!--
  function loadForm(){

    var recordCount = 0 ;  //��¼���
    //���
    recordCount = <%= findex %>;
    LiabDetail.innerHTML = dialogArguments.fm.prpLpersonLossLiabDetailCode[recordCount].value+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+dialogArguments.fm.prpLpersonLossLiabDetailName[recordCount].value;

    fm.prpLpersonLossLiabDetailCode.value=dialogArguments.fm.prpLpersonLossLiabDetailCode[recordCount].value ;
    fm.prpLpersonLossLiabDetailName.value=dialogArguments.fm.prpLpersonLossLiabDetailName[recordCount].value ;
    //15�󹤷ѣ�14����ѣ�34��ʳ�����ѣ�17�в���19������21�����ѣ�12��ҽ�ѣ�18�м��������߷�
    fm.UnitAmount.value = dialogArguments.fm.prpLpersonLossUnitAmount[recordCount].value ;
    fm.LossQuantity.value = dialogArguments.fm.prpLpersonLossLossQuantity[recordCount].value ;
    fm.HospitalDays.value = dialogArguments.fm.prpLpersonLossHospitalDays[recordCount].value ;
    if(fm.prpLpersonLossLiabDetailCode.value==15){
      UnitAmount.innerHTML = '����(Ԫ��30��)';
      LossQuantity.innerHTML = 'סԺ����';
      HospitalDays.innerHTML = '��Ϣ����';
    } else if(fm.prpLpersonLossLiabDetailCode.value==14){
      UnitAmount.innerHTML = '����(Ԫ��30��)';
      LossQuantity.innerHTML = 'סԺ����';
      HospitalDays.innerHTML = '����';
    } else if(fm.prpLpersonLossLiabDetailCode.value==34){
      UnitAmount.innerHTML = '����(Ԫ��30��)';
      LossQuantity.innerHTML = 'סԺ����';
      fm.HospitalDays.readOnly=true;
      fm.HospitalDays.className="readonly";
    } else if(fm.prpLpersonLossLiabDetailCode.value==17){
      UnitAmount.innerHTML = '����(Ԫ����)';
      LossQuantity.innerHTML = '����';
      HospitalDays.innerHTML = '�˲б���';
    } else if(fm.prpLpersonLossLiabDetailCode.value==19){
      UnitAmount.innerHTML = '����(Ԫ����)';
      LossQuantity.innerHTML = '����';
      fm.HospitalDays.readOnly=true;
      fm.HospitalDays.className="readonly";
    } else if(fm.prpLpersonLossLiabDetailCode.value==21){
      UnitAmount.innerHTML = '����(Ԫ����)';
      LossQuantity.innerHTML = '����';
      fm.HospitalDays.readOnly=true;
      fm.HospitalDays.className="readonly";
    } else if(fm.prpLpersonLossLiabDetailCode.value==12){
      UnitAmount.innerHTML = '�˶�ҽҩ�ѽ��';
      LossQuantity.innerHTML = '����';
      fm.HospitalDays.readOnly=true;
      fm.HospitalDays.className="readonly";
    } else if(fm.prpLpersonLossLiabDetailCode.value==18){
      UnitAmount.innerHTML = '����(Ԫ����)';
      LossQuantity.innerHTML = '����';
      fm.HospitalDays.readOnly=true;
      fm.HospitalDays.className="readonly";
    }
  }


/**
 * ��ģʽ�����е����ݱ��浽������
 */
 function saveModelForm()
 {
  var UnitAmount=0;
  var LossQuantity=0;
  var HospitalDays=0;
  UnitAmount = parseFloat(fm.UnitAmount.value);
  LossQuantity = parseInt(fm.LossQuantity.value);
  HospitalDays = parseInt(fm.HospitalDays.value);

  if(isNaN(UnitAmount))UnitAmount = 0;
  if(isNaN(LossQuantity))LossQuantity = 0;
  if(isNaN(HospitalDays))HospitalDays = 0;

  var SumLoss=0;
  if(fm.prpLpersonLossLiabDetailCode.value==15){
    SumLoss = UnitAmount*(LossQuantity+HospitalDays);
  } else if(fm.prpLpersonLossLiabDetailCode.value==14){
    SumLoss = UnitAmount*LossQuantity*HospitalDays;
  } else if(fm.prpLpersonLossLiabDetailCode.value==34){
    SumLoss = UnitAmount*LossQuantity;
  } else if(fm.prpLpersonLossLiabDetailCode.value==17){
    SumLoss = UnitAmount*LossQuantity*HospitalDays;
  } else if(fm.prpLpersonLossLiabDetailCode.value==19){
    SumLoss = UnitAmount*LossQuantity;
  } else if(fm.prpLpersonLossLiabDetailCode.value==21){
    SumLoss = UnitAmount*LossQuantity;
  } else if(fm.prpLpersonLossLiabDetailCode.value==12){
    SumLoss = UnitAmount*LossQuantity;
  } else if(fm.prpLpersonLossLiabDetailCode.value==18){
    SumLoss = UnitAmount*LossQuantity;
  }
  //opener.document.fm.prpLpersonLossUnitAmount[<%=findex %>].value=point(round(UnitAmount,2),2);
  dialogArguments.fm.prpLpersonLossUnitAmount[<%=findex %>].value=point(round(UnitAmount,2),2);
  dialogArguments.fm.prpLpersonLossLossQuantity[<%=findex %>].value=LossQuantity;
  dialogArguments.fm.prpLpersonLossHospitalDays[<%=findex %>].value=HospitalDays;
  dialogArguments.fm.prpLpersonLossSumLoss[<%=findex %>].value=point(round(SumLoss,2),2);
  dialogArguments.fm.prpLpersonLossSumLoss[<%=findex %>].onchange();
  window.close();
 }
//-->
</script>
 </head>

<body class="interface" onload="loadForm();">
  <form name=fm action="" method="post" >

    <table  class=common cellpadding="5" cellspacing="1" >
      <tr class=listtitle> <td colspan=3>���ü���</td></tr>
      <tr>
        <td class="title" style="width:40%">��ʧ��ϸ:</td>
        <td class="input" style="width:60%" colspan="2" id="LiabDetail"></td>
      </tr>

      <tr>
        <td class="title" style="width:40%" id="UnitAmount"></td>
        <td class="title"  style="width:30%" id="LossQuantity"></td>
        <td class="title"  style="width:30%" id="HospitalDays"></td>
      </tr>
        <input type="hidden" name="prpLpersonLossLiabDetailCode" style="width:90%" class="common">
        <input type="hidden" name="prpLpersonLossLiabDetailName" style="width:90%" class="common">
      <tr>
        <td class="input"><input type="text" name="UnitAmount" style="width:90%" class="common"></td>
        <td class="input"><input type="text" name="LossQuantity" style="width:90%" class="common"></td>
        <td class="input"><input type="text" name="HospitalDays" style="width:90%" class="common"></td>
      </tr>
    </table>
    <table cellpadding="10" cellspacing="0" width="100%">
      <tr>
        <td class=button style="width:50%" align="center">
          <!--���水ť-->
          <input type="button" name=buttonSave class='button' value=" ȷ �� " onclick="return saveModelForm();">
        </td>

        <td class=button style="width:50%" align="center">
          <!--ȡ����ť-->
          <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="window.close();" >
        </td>
      </tr>
    </table>
  </form>
</body>
</html>