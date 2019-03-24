<%--
****************************************************************************
* DESC       ：显示货运险查勘详细信息
* AUTHOR     :qinyongli
* CREATEDATE ：2005-8-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<table class="common"  align="center"   width="100%" style="display:none" >
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;" >
         <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,DetailText)">查勘详细信息
        <br>
      <table class="common" align="center" id="DetailText" style="display:none" cellspacing="1" cellpadding="5">
       <tbody>
      <tr>         
        <td class="title" >报案日期:</td>
        <td class="input" >
            <input type="text" name="prpLregistReportDate" class="readonly"  readonly="true"  style="width:140px" value="<bean:write name='prpLregistDto' property='reportDate'/>"></td>         
        <td class="title" >申请查勘日期:</td>
        <td class="input" >
            <input type="text" name="prpLextAppliCheckDate" class="input" value="<bean:write name='prpLextDto' property='appliCheckDate'/>" style="width:140px">     
        </td>
      </tr>
      <tr>         
        <td class="title" >投保人或代表名称及联系电话/传真</td>
        <td class="input" ><input type="text" name="prpLextAppliPhone" class="input" value="<bean:write name='prpLextDto' property='appliPhone'/>" > </td>     
        <td class="title" ></td>
        <td class="input" ></td>    
      </tr>
      <tr>         
        <td class="title" >被保险人或代表名称及联系电话/传真</td>
        <td class="input" ><input type="text" name="prpLextInsuredPhone" class="input" value="<bean:write name='prpLextDto' property='insuredPhone'/>" > </td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >起运日期:</td>
        <td class="input" ><input type="text" name="prplextSailStartDate" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='sailStartDate'/>" > </td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
       <tr>         
        <td class="title" >运输路线:</td>
        <td class="input" colspan="3">从<bean:write name='prpLcarGoDto' property='startSiteName'/>到<bean:write name='prpLcarGoDto' property='endSiteName'/></td>     
      </tr>
      <tr> 
        <!-- 显示运输工具 由于此处的名称在业务系统里可能保存在不同的字段中，所以遇到问题时此处还需要进行处理modify by wuxiaodong begain 050903-->        
        <td class="title" >运输方式:</td>
        
          <td class="input" >
          
        <%//add by qinyongli 2005-10-27 
        PrpCmainCargoDto carGo=null;
       if(!riskCode.equals("0908")){
    	   carGo =(PrpCmainCargoDto)request.getAttribute("prpLcarGoDto"); 
	        String  blNo =carGo.getConveyance();
	        if(!blNo.equals("")){
	       int blNoInt = Integer.parseInt(blNo);
		        switch(blNoInt){
		            case 01: out.println("水运");break;
		            case 02: out.println("航空");break;
		            case 03: out.println("公路");break;
		            case 04: out.println("铁路");break;
		            case 05: out.println("邮包");break;
		            case 06: out.println("联运");break;
		            case 07: out.println("管道");break;
		            default : out.println("其它");
		        }
	        }
     }
      
        %>
        </td>
        
        <td class="title" >车次/航次/航班号/车号/船名:</td>
        <logic:notEmpty name="prpLcarGoDto" property="voyageNo">
        <td class="input" ><bean:write name='prpLcarGoDto' property='voyageNo'/></td>
         </logic:notEmpty>
        <logic:empty name="prpLcarGoDto" property="voyageNo">
        <td class="input" >
         <%
         if(!riskCode.equals("0908")){
           out.print(carGo.getBLName());
         }
         %>  
        <%--bean:write name='prpLcarGoDto' property='BLNo'/--%>
        </td>
        </logic:empty>
      </tr>
      <tr>         
        <td class="title" >保额:</td>
        <td class="input" ><bean:write name='prpLextDto' property='sumAmount' format='##0.00'/></td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >免赔:</td>
        <td class="input" ><bean:write name='prpLextDto' property='limitAmount' format='##0.00'/></td>         
        <td class="title" >货价:</td>
        <td class="input" ><input type="text" name="prpLextSumValue" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='cargoValue'/>" ></td>
      </tr>
      <tr>         
        <td class="title" >承保公司:</td>
        <td class="input" ><bean:write name='prpLextDto' property='prpCompanyName'/></td>         
        <td class="title" >货损查勘公司:</td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >提单/运单:</td>
        <td class="input" ></td>         
        <td class="title" >发票号码NO:</td>
        <td class="input" ><input type="text" name="prpLextInvoiceNo" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='value3'/>" ></td>
      </tr>
      <tr>         
        <td class="title" >货物名称及数量:</td>
        <td class="input" ><input type="text" name="prpLextValue11" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='value1'/>" ></td>         
        <td class="title" >卸货日期:</td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >币别:</td>
        <td class="input" ><input type="text" name="prpLextCurrency" value="<bean:write name='prpLextDto' property='currency'/>" class="codecode" style="width:30%" title="币别"
         ondblclick="code_CodeSelect(this, 'Currency');"
         onkeyup= "code_CodeSelect(this, 'Currency');">
        <input type=text name="prpLregistEstiCurrencyName" class="codecode" style="width:60%" title="币别"  value="<bean:write name='prpLextDto' property='currencyCname'/>"
           ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
           onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"></td>         
        <td class="title" >估损金额</td>
        <td class="input" ><input type="text" name="prpLextValue2" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='value2' format='##0.00'/>" ></td>
      </tr>
      <tr>         
        <td class="title" >残值数量</td>
        <td class="input" ><input type="text" name="prpLextRestQuantity" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='restQuantity'/>" ></td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
        </tbody>
      </table>
      </td>
    </tr>
  </table>
