<%--
****************************************************************************
* DESC       ：报案登记录入/修改页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-02-29
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法

     /**
      * 插入一条新的lLoss之后的处理（可选方法）
      */
      function afterInsertpersonloss()
      {
        setPrpLpersonLossSerialNo();
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeletepersonloss(field)
      {

        setPrpLpersonLossSerialNo();
      }

        /**
         * 设置setPrpLpersonlossSerialNo
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
         * 加入打开模式窗体
         *
         */
         function modifyPerson(field,pageCode)
         {
           //设置序号
           setCurrentRecord(field);
           win=window.showModalDialog("/claim/test/DAAModelPersonEdit.jsp",window,'status:no;resizable:yes');
         }
         /**
          * 设置序号
          */
          function setCurrentRecord(field)
          {
            var i = 0;
            i = getElementOrder(field);
            fm.recordCount.value = i;
            return true;
          }


 /**
  在表格下方添加一组数据，禁止非本模块调用
  参数为页代码名称和页原始数据代码名称
  例:insertRow("Engage","Engage_Data");
  返回插入行的序号（从1开始）
  */
function insertRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //当前table索引
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
  删除控制按钮控制的行，禁止非本模块调用
  字段，页名称，数据页中控制按钮的个数，数据页中每个控制按钮的控制的TR的个数
  返回删除行的序号（从1开始）
 */
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentDeletedRowNo).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //去掉隐含域中的控制按钮的个数
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}

//得到当前的行所在当前页位置
function getRowCurrPage(field,DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //人员费用的记录数
  var firstIndexLoss = 0 ;   //本人员的费用的起始index
  var recentRowNo =  0;
  var orderCurrent = 0  ;    //当前行所在当前面的位置
  recentRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentRowNo).value);
  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getTableElements("PersonLoss");

  for(i=0;i<elements.length;i++)
  {
  	//得到人员费用索引起始位置及人员费用的记录数
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
   <!--建立显示的录入条，可以收缩显示的-->
      <!--建立显示的录入条，可以收缩显示的-->
      <span style="display:none">
          <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0">
           <tbody>
           <tr>
          <td class='inputsubsub'>
             <input type="hidden" name="personSerialNo" style="width:20px">
             <input name=prpLpersonLossFeeTypeCode class="codecode" style='width:95%' title="费用代码"
                 coderelation="1" codelimit="must"
              ondblclick= " code_CodeSelect(this,'KindCode');"
              onkeyup= " code_CodeSelect(this,'KindCode');">
          </td>
          <td class='inputsubsub'>
             <input name=prpLpersonLossFeeTypeName class="codename" style="width:95%" title="费用名称"

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
    <!--表示显示多行的-->
    <tr >
      <td class="subformtitle" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="PersonLossImg" onclick="showPage(this,spanPersonLoss)">赔付人员信息<br>
        <span style="display:none">
          <table class="common" style="display:none" id="PersonLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
           <tr>
          <td class="input" style="width:4%">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLpersonLossSerialNo" description="序号">
             </div>
         </td>
         <td class="subformtitle" style="width:92%">
         <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
            <tbody>
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo">
                  <input type="hidden" name="prpLpersonLossIdentifyNumber">
                  <!--是否超过保单中的限额标志域-->
                  <input type="hidden" name="prpLpersonLossPersonLossOverAmount">
                  <input type="hidden" name="prpLpersonLossJobCode">
                  <input type="hidden" name="prpLpersonLossJobName">
                  <td class="title"  style="width:15%">人员姓名：</td>
                  <td class="input" style="width:35%">
                    <input class='common' style="width:110" name="prpLpersonLossPersonName"
                    maxlength=20 description="人员姓名">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title" style="width:15%">性别：</td>
                  <td class="input" style="width:35%">
                    <select name="prpLpersonLossSex" class='common' style="wdith:110">
                       <option value="1" checked >男</option>
                       <option value="2">女</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                </tr>
                <tr>
                  <td class="title">年龄：</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:110"
                      maxlength="3" description="年龄">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title">币别：</td>
                  <td class="input">
                    <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                    <input class='readonly' readonly name="prpLpersonLossCurrencyName3">
                  </td>
                </tr>
                <tr>
                  <td class="title">险别：</td>
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
                  <td class='title'>号牌号码：</td>
                  <td class="input">
                    <select class='common' style="width:110" name="prpLpersonLossLicenseNo">
                       <option value="1">京A0001</option>
                       <option value="2">京A0002</option>
                       <option value="3">京A0003</option>
                       <option value="4">京A0004</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class='title'>责任比例：</td>
                  <td class='input'>
                    <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:130">%
                  </td>
                </tr>
                <tr>
                  <td class='title'>免赔率：</td>
                  <td class='input'>
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossDeductibleRate">%
                  </td>
                  <td class="title">赔付合计：</td>
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
              <%//人员赔付信息%>




        <span  id="spanPersonFeeLoss" >
        <%-- 多行输入展现域 --%>
        <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="subsubformtitle" colspan=11>
                 费用信息 <font color="#FF0000">*</font>
                </td>
             </tr>
             <tr>
         <td class="titlesubsub" style="width:11%">费用代码</td>
         <td class="titlesubsub" style="width:15%">费用名称</td>
         <td class="titlesubsub" style="width:15%">单价</td>
         <td class="titlesubsub" style="width:15%">数目</td>
         <td class="titlesubsub" style="width:15%">核损金额</td>
         <td class="titlesubsub" style="width:11%">赔偿比例%</td>
         <td class="titlesubsub" style="width:15%">赔付金额</td>
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
            <input type=button name=btnModify value="修改" onclick="return modifyPerson(this,'PersonLoss');" style="cursor: hand"> <br>
            <input type=button name="buttonPersonLossDelete"  onclick="deleteRow(this,'PersonLoss')" value="-" style="cursor: hand">
          </div>
          </td>

       </tr>



            </tbody>
          </table>
        </span>
        <span  id="spanPersonLoss" style="display:none">
        <%-- 多行输入展现域 --%>
        <table id="personloss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="title" style="width:4%">序号</td>
                <td class="title" style="width:96%" colspan=2 >内容</td>
             </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=2 style="width:96%">(按"+"号键增加赔付人员信息，按"-"号键删除赔付人员信息)</td>
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
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>