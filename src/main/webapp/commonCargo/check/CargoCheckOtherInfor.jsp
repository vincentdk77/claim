<%--
****************************************************************************
* DESC       ����ʾ�����ղ鿱��ϸ��Ϣ
* AUTHOR     :qinyongli
* CREATEDATE ��2005-8-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<table class="common"  align="center"   width="100%" style="display:none" >
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;" >
         <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,DetailText)">�鿱��ϸ��Ϣ
        <br>
      <table class="common" align="center" id="DetailText" style="display:none" cellspacing="1" cellpadding="5">
       <tbody>
      <tr>         
        <td class="title" >��������:</td>
        <td class="input" >
            <input type="text" name="prpLregistReportDate" class="readonly"  readonly="true"  style="width:140px" value="<bean:write name='prpLregistDto' property='reportDate'/>"></td>         
        <td class="title" >����鿱����:</td>
        <td class="input" >
            <input type="text" name="prpLextAppliCheckDate" class="input" value="<bean:write name='prpLextDto' property='appliCheckDate'/>" style="width:140px">     
        </td>
      </tr>
      <tr>         
        <td class="title" >Ͷ���˻�������Ƽ���ϵ�绰/����</td>
        <td class="input" ><input type="text" name="prpLextAppliPhone" class="input" value="<bean:write name='prpLextDto' property='appliPhone'/>" > </td>     
        <td class="title" ></td>
        <td class="input" ></td>    
      </tr>
      <tr>         
        <td class="title" >�������˻�������Ƽ���ϵ�绰/����</td>
        <td class="input" ><input type="text" name="prpLextInsuredPhone" class="input" value="<bean:write name='prpLextDto' property='insuredPhone'/>" > </td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >��������:</td>
        <td class="input" ><input type="text" name="prplextSailStartDate" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='sailStartDate'/>" > </td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
       <tr>         
        <td class="title" >����·��:</td>
        <td class="input" colspan="3">��<bean:write name='prpLcarGoDto' property='startSiteName'/>��<bean:write name='prpLcarGoDto' property='endSiteName'/></td>     
      </tr>
      <tr> 
        <!-- ��ʾ���乤�� ���ڴ˴���������ҵ��ϵͳ����ܱ����ڲ�ͬ���ֶ��У�������������ʱ�˴�����Ҫ���д���modify by wuxiaodong begain 050903-->        
        <td class="title" >���䷽ʽ:</td>
        
          <td class="input" >
          
        <%//add by qinyongli 2005-10-27 
        PrpCmainCargoDto carGo=null;
       if(!riskCode.equals("0908")){
    	   carGo =(PrpCmainCargoDto)request.getAttribute("prpLcarGoDto"); 
	        String  blNo =carGo.getConveyance();
	        if(!blNo.equals("")){
	       int blNoInt = Integer.parseInt(blNo);
		        switch(blNoInt){
		            case 01: out.println("ˮ��");break;
		            case 02: out.println("����");break;
		            case 03: out.println("��·");break;
		            case 04: out.println("��·");break;
		            case 05: out.println("�ʰ�");break;
		            case 06: out.println("����");break;
		            case 07: out.println("�ܵ�");break;
		            default : out.println("����");
		        }
	        }
     }
      
        %>
        </td>
        
        <td class="title" >����/����/�����/����/����:</td>
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
        <td class="title" >����:</td>
        <td class="input" ><bean:write name='prpLextDto' property='sumAmount' format='##0.00'/></td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >����:</td>
        <td class="input" ><bean:write name='prpLextDto' property='limitAmount' format='##0.00'/></td>         
        <td class="title" >����:</td>
        <td class="input" ><input type="text" name="prpLextSumValue" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='cargoValue'/>" ></td>
      </tr>
      <tr>         
        <td class="title" >�б���˾:</td>
        <td class="input" ><bean:write name='prpLextDto' property='prpCompanyName'/></td>         
        <td class="title" >����鿱��˾:</td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >�ᵥ/�˵�:</td>
        <td class="input" ></td>         
        <td class="title" >��Ʊ����NO:</td>
        <td class="input" ><input type="text" name="prpLextInvoiceNo" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='value3'/>" ></td>
      </tr>
      <tr>         
        <td class="title" >�������Ƽ�����:</td>
        <td class="input" ><input type="text" name="prpLextValue11" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='value1'/>" ></td>         
        <td class="title" >ж������:</td>
        <td class="input" ></td>
      </tr>
      <tr>         
        <td class="title" >�ұ�:</td>
        <td class="input" ><input type="text" name="prpLextCurrency" value="<bean:write name='prpLextDto' property='currency'/>" class="codecode" style="width:30%" title="�ұ�"
         ondblclick="code_CodeSelect(this, 'Currency');"
         onkeyup= "code_CodeSelect(this, 'Currency');">
        <input type=text name="prpLregistEstiCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='prpLextDto' property='currencyCname'/>"
           ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
           onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"></td>         
        <td class="title" >������</td>
        <td class="input" ><input type="text" name="prpLextValue2" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='value2' format='##0.00'/>" ></td>
      </tr>
      <tr>         
        <td class="title" >��ֵ����</td>
        <td class="input" ><input type="text" name="prpLextRestQuantity" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='restQuantity'/>" ></td>         
        <td class="title" ></td>
        <td class="input" ></td>
      </tr>
        </tbody>
      </table>
      </td>
    </tr>
  </table>
