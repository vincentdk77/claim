<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��weishixin
* CREATEDATE ��2004-02-29
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����

     /**
      * ����һ���µ�lLoss֮��Ĵ�����ѡ������
      */
      function afterInsertpersonloss()
      {
        setPrpLpersonLossSerialNo();
      }

      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeletepersonloss(field)
      {

        setPrpLpersonLossSerialNo();
      }

        /**
         * ����setPrpLpersonlossSerialNo
         */
        function setPrpLpersonLossSerialNo(){
            var count=getElementCount("prpLpersonLossSerialNo");
            for(var i=0;i<count;i++)
            {
                if(count!=1){
                    fm.prpLpersonLossSerialNo[i].value=i;
                }
            }
        }

        /**
         * �����ģʽ����
         *
         */
         function modifyPerson(field,pageCode)
         {
           //�������
           setCurrentRecord(field);
           win=window.showModalDialog("/claim/test/DAAModelPersonEdit.jsp",window,'status:no;resizable:yes');
         }
         /**
          * �������
          */
          function setCurrentRecord(field)
          {
            var i = 0;
            i = getElementOrder(field);
            fm.recordCount.value = i;
            return true;
          }


 /**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //��ǰtable����
  index = getElementOrder(field)-1;
  var oTBODY     = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }

  return true;
}

/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentDeletedRowNo).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}

//�õ���ǰ�������ڵ�ǰҳλ��
function getRowCurrPage(field,DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //��Ա���õļ�¼��
  var firstIndexLoss = 0 ;   //����Ա�ķ��õ���ʼindex
  var recentRowNo =  0;
  var orderCurrent = 0  ;    //��ǰ�����ڵ�ǰ���λ��
  recentRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentRowNo).value);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("PersonLoss");

  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
  	if(elements[i].name  == "personSerialNo")
  	{

  		if(parseInt(elements[i].value)==pageSerialNo)
  		{
  			countLoss = countLoss + 1;
  			if(firstIndexLoss==0)
  			{
  				firstIndexLoss = getElementOrder(elements[i]);
  			}
  		}
  	}
  }

  orderCurrent = recentRowNo - firstIndexLoss;
  return orderCurrent;
}

    </script>
 </head>
<body class="interface" >
    <form name=fm action="" method="post" >
   <!--������ʾ��¼����������������ʾ��-->
      <!--������ʾ��¼����������������ʾ��-->
      <span style="display:none">
          <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0">
           <tbody>
           <tr>
          <td class='inputsubsub'>
             <input type="hidden" name="personSerialNo" style="width:20px">
             <input name=prpLpersonLossFeeTypeCode class="codecode" style='width:95%' title="���ô���"
                 coderelation="1" codelimit="must"
              ondblclick= " code_CodeSelect(this,'KindCode');"
              onkeyup= " code_CodeSelect(this,'KindCode');">
          </td>
          <td class='inputsubsub'>
             <input name=prpLpersonLossFeeTypeName class="codename" style="width:95%" title="��������"

              ondblclick= "code_CodeSelect(this, 'KindCode','-1','always','none','post');"
              onkeyup= " code_CodeSelect(this, 'KindCode','-1','always','none','post');">
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossUnitPrice class="common" style="width:95%">
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossQuantity class="common" style="width:95%">
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossSumLoss class="common" style="width:95%">
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossClaimRate class="common" style="width:95%">
           </td>
           <td class='inputsubsub'>
              <input name=prpLpersonLossRealpay class="readonly" readonly=true style="width:90%">
           </td>
           <td class='inputsubsub'>
              <div align="center">
                <input type=button name="buttonPersonFeeLossDelete"  onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
              </div>

           </td>

         </tr>
       </tbody>

    </table>
    </span>
   <table class="common" align="center">
    <!--��ʾ��ʾ���е�-->
    <tr >
      <td class="subformtitle" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="PersonLossImg" onclick="showPage(this,spanPersonLoss)">�⸶��Ա��Ϣ<br>
        <span style="display:none">
          <table class="common" style="display:none" id="PersonLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
           <tr>
          <td class="input" style="width:4%">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLpersonLossSerialNo" description="���">
             </div>
         </td>
         <td class="subformtitle" style="width:92%">
         <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
            <tbody>
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo">
                  <input type="hidden" name="prpLpersonLossIdentifyNumber">
                  <!--�Ƿ񳬹������е��޶��־��-->
                  <input type="hidden" name="prpLpersonLossPersonLossOverAmount">
                  <input type="hidden" name="prpLpersonLossJobCode">
                  <input type="hidden" name="prpLpersonLossJobName">
                  <td class="title"  style="width:15%">��Ա������</td>
                  <td class="input" style="width:35%">
                    <input class='common' style="width:110" name="prpLpersonLossPersonName"
                    maxlength=20 description="��Ա����">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title" style="width:15%">�Ա�</td>
                  <td class="input" style="width:35%">
                    <select name="prpLpersonLossSex" class='common' style="wdith:110">
                       <option value="1" checked >��</option>
                       <option value="2">Ů</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                </tr>
                <tr>
                  <td class="title">���䣺</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:110"
                      maxlength="3" description="����">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title">�ұ�</td>
                  <td class="input">
                    <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                    <input class='readonly' readonly name="prpLpersonLossCurrencyName3">
                  </td>
                </tr>
                <tr>
                  <td class="title">�ձ�</td>
                  <td class="input">
                    <input type='hidden' name="prpLpersonLossAmount">
                    <input type='hidden' name='prpLpersonLossDeductible'>
                    <!-- input type='hidden' name='TempName' -->
                    <input type='hidden' name='prpLpersonLossItemKindNo'>
                    <input type="input" name='prpLpersonLossKindCode' class="codecode"  style="width:40"
                      querytype="always" codetype="KindCode3" coderelation="1,-1,-2,-4,-2,-2,-3" codelimit="must"
                      ondblclick="code_CodeSelect(this);"
                      onkeyup="code_CodeSelect(this);"
                    >
                    <input type="input" name=prpLpersonLossKindName class="codename" style="width:110"
                      querytype="always" codetype="KindCode3" coderelation="-1,-2,-3,-5,-3,-3,-4" codelimit="must"
                      ondblclick="code_CodeSelect(this);"
                      onkeyup="code_CodeSelect(this);"
                    >
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td  class="title">
                  </td>
                  <td class="input">
                  </td>


                </tr>
                <tr>
                  <td class='title'>���ƺ��룺</td>
                  <td class="input">
                    <select class='common' style="width:110" name="prpLpersonLossLicenseNo">
                       <option value="1">��A0001</option>
                       <option value="2">��A0002</option>
                       <option value="3">��A0003</option>
                       <option value="4">��A0004</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class='title'>���α�����</td>
                  <td class='input'>
                    <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:130">%
                  </td>
                </tr>
                <tr>
                  <td class='title'>�����ʣ�</td>
                  <td class='input'>
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossDeductibleRate">%
                  </td>
                  <td class="title">�⸶�ϼƣ�</td>
                  <td class="input">
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossSumRealpay">
                  </td>
                </tr>

              <input type='hidden' name='prpLpersonLossFamilyNo'>
              <input type='hidden' name='prpLpersonLossFamilyName'>
              <input type='hidden' name='prpLpersonLossLiabCode'>
              <input type='hidden' name='prpLpersonLossLiabName'>
              <input type='hidden' name='prpLpersonLossLiabDetailCode'>
              <input type='hidden' name='prpLpersonLossLiabDetailName'>
              <input type='hidden' name='prpLpersonLossItemAddress'>
              <input type='hidden' name='prpLpersonLossLossQuantity'>
              <input type='hidden' name='prpLpersonLossUnit'>
              <input type='hidden' name='prpLpersonLossUnitAmount'>
              <input type='hidden' name='prpLpersonLossCurrency'  value="CNY">
              <input type='hidden' name='prpLpersonLossCurrency1' value="CNY">
              <input type='hidden' name='prpLpersonLossItemValue'>
              <input type='hidden' name='prpLpersonLossCurrency2' value="CNY">
              <input type='hidden' name='prpLpersonLossSumLoss'>
              <input type='hidden' name='prpLpersonLossSumRest'>
              <input type='hidden' name='prpLpersonLossClaimRate'>
              <input type='hidden' name='prpLpersonLossCurrency4' value="CNY">
              <input type='hidden' name='prpLpersonLossSumRealPay'>
              <input type='hidden' name='prpLpersonLossFlag'>

              <tr>
              <td colspan="4">
              <%//��Ա�⸶��Ϣ%>




        <span  id="spanPersonFeeLoss" >
        <%-- ��������չ���� --%>
        <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="subsubformtitle" colspan=11>
                 ������Ϣ <font color="#FF0000">*</font>
                </td>
             </tr>
             <tr>
         <td class="titlesubsub" style="width:11%">���ô���</td>
         <td class="titlesubsub" style="width:15%">��������</td>
         <td class="titlesubsub" style="width:15%">����</td>
         <td class="titlesubsub" style="width:15%">��Ŀ</td>
         <td class="titlesubsub" style="width:15%">������</td>
         <td class="titlesubsub" style="width:11%">�⳥����%</td>
         <td class="titlesubsub" style="width:15%">�⸶���</td>
         <td class="titlesubsub" style="width:3%">  </td>
       </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="titlesubsub" colspan="7" style="width:97%"></td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot>

          <tbody>

          </tbody>
        </table>
        </span>





              </td>
              </tr>


            </tbody>
           </table>
           </td>
          <td class="input" style='width:4%'>
          <div align="center">
            <input type=button name=btnModify value="�޸�" onclick="return modifyPerson(this,'PersonLoss');" style="cursor: hand"> <br>
            <input type=button name="buttonPersonLossDelete"  onclick="deleteRow(this,'PersonLoss')" value="-" style="cursor: hand">
          </div>
          </td>

       </tr>



            </tbody>
          </table>
        </span>
        <span  id="spanPersonLoss" style="display:none">
        <%-- ��������չ���� --%>
        <table id="personloss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="title" style="width:4%">���</td>
                <td class="title" style="width:96%" colspan=2 >����</td>
             </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=2 style="width:96%">(��"+"�ż������⸶��Ա��Ϣ����"-"�ż�ɾ���⸶��Ա��Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('personloss')" name="buttonPersonLossInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot>
          <tbody>

          </tbody>
        </table>
        </span>
      </td>
    </tr>
  </table>

   <input type='hidden' name='pageCode' value="PersonLoss">
   <input type='hidden' name='recordCount'>
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>