<%--
****************************************************************************
* DESC       ���Ʋ���ʧ��λ��Ϣҳ��
* AUTHOR     ��������Ŀ��
* CREATEDATE ��2005-4-12
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
   <!--������ʾ��¼����������������ʾ��-->
   <%@page import="java.util.*"%>
   
    <script language='javascript'>
 <!--    
      //��������뱾ҳ�Զ����JavaScript����

      /*
        ����һ���µ�֮��Ĵ�����ѡ������ 
      */
      function afterInsertThirdProp()
      {
        setPrpLThirdPropSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteThirdProp(field)
      {         
        setPrpLThirdPropSerialNo();
      }
     
      /** 
       * ����setPrpLThirdPropSerialNo
       */
      function setPrpLThirdPropSerialNo(){
        var count=getElementCount("prpLthirdPropItemNo");
        for(var i=0;i<count;i++)
        {
          if(count!=1){
              fm.prpLthirdPropItemNo[i].value=i;
              fm.prpLthirdPropNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-17
                    //�Ƿ��������Ĳ����־=new,��Ϊ�Ѿ������˲���ɾ��ԭ����.
          } 
        } 
      }   
      
      //���´򿪴���ҳ��
      function openLossItemCodeWin(PageCode,Field)
      {
        var index = parseInt(getElementOrder(Field))-1;
        var partCode = fm.txtCodeType.value;
        var pageUrl="/claim/DAA/regist/DAARegistGetCompCode.jsp?strIndex="+index+"&partCode="+partCode;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        window.open(pageUrl,"openLossItemCodeWin","resizable=0,scrollbars,dependent,alwaysRaised,width=230,height=450");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
      }  

      

      //-->      
    </script>   
    
   <table class="common" align="center" width="100%" >
    <!--��ʾ��ʾ���е�--> 
    <tr>
      <td class="subformtitle" style="text-align:left" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ThirdPropImg" onclick="showPage(this,spanThirdProp)">
             �Ʋ���ʧ��Ϣ<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="ThirdProp_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="input" style="width:10%"> 
                  <input type="hidden"  name="prpLthirdPropFlag">
                  <input name="prpLthirdPropItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">
                  <input type="hidden" class="readonlyno"  name="prpLthirdPropNewAddFlag" > <!--add by liyanjie 2005-12-17�Ƿ��������ĲƲ���ʧ -->
                </td>
                <td class="input" style="width:15%;display:none">
                  <input name="prpLthirdPropLicenseNo" class="common"  style="width:90%" >
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLthirdLossItemName" class="codename" style="width:90%"  			             
                     ondblclick="return openLossItemCodeWin(ThirdProp,this);">  
                  <input type="hidden" name="prpLthirdLossItemCode">
                </td> 
                <td class="input" style="width:21%">
                  <input name="prpLthirdPropLossDesc" class="input" style="width:90%">
                </td>
             
                <!--Modify by chenrenda add begin 20050417-->
                <!--Reason:������ģ��ϵ��Ʋ���ʧ��Ϣ��-->
               <td class="input" style="display:none">
                    <html:select name="prpLthirdPropDto" property="prpLthirdPropKindCode"  style="width:100px">
                      <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />  
                    </html:select>                    
                </td>
                <td class="input" style="width:20%">
                  <input name="prpLthirdPropLossFee" class="input" style="width:100%;align:right">
                </td>             
               
                <!--Modify by chenrenda add end 20050417-->
                
                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonThirdPropDelete"  onclick="deleteRow(this,'ThirdProp')" value="-" style="cursor: hand">
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </span>
        
        
        <span  id="spanThirdProp" style="display:none" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="ThirdProp" >
          <thead>
            <tr>
                <td class="centertitle" style="width:10%">��ʧ��Ŀ���</td>
                <td class="centertitle" style="width:15%;display:none">���ƺ�</td>
                <td class="centertitle" style="width:15%">��ʧ����</td>
                <td class="centertitle" style="width:21%">��ʧ�̶�����</td>
                
                <!--Modify by chenrenda add begin 20050417-->
                <!--Reason:������ģ��ϵ��Ʋ���ʧ��Ϣ��-->
                <%
                String strThirdPropRows = "4";
                %> 
                <td class="centertitle" style="width:10%;display:none">�ձ����</td>
                <td class="centertitle" style="width:20%">��ʧ���</td>

                
                
                <!--Modify by chenrenda add end 20050417-->
                <td class="title" style="width:4%" >&nbsp;</td> 
                
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=<%=strThirdPropRows%> style="width:96%">(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('ThirdProp')" name="buttonDriverInsert" style="cursor: hand">
                 </div>
                </td>
              </tr>
           </tfoot> 
          </tfoot>
          <tbody id="readonlyThirdPropTable">
      
      <%
      //�õ��б��ձ𼯺�
      Collection prpLThirdPropItemKindColl = (Collection)request.getAttribute("prpLcheckItemKindList"); 
      %>
      <logic:notEmpty  name="prpLthirdPropDto"  property="thirdPropList"> 
        <logic:iterate id="ThirdPropdtox" name="prpLthirdPropDto" property="thirdPropList">
              
              <%
                //Modify by chenrenda update begin 20050418
                
                PrpLcheckLossDto prpLcheckLossDto2 = null; 
               // if(strThirdPropNodeType.equals("check"))
              //  {
                  //Reason:ȡ��������ʧ��Ϣ
                  PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)request.getAttribute("prpLcheckLossDto"); 
                  ArrayList prpLcheckLossList = new ArrayList();
                  prpLcheckLossList = (ArrayList)prpLcheckLossDto.getPrpLcheckLossList();
                  
                  if(prpLcheckLossList==null||prpLcheckLossList.size()==0)
                  {
                    prpLcheckLossDto2 = new PrpLcheckLossDto();
                    //System.out.println("�����ڽ������");
                  }
                  else
                  {
                    //System.out.println("���ڽ������");
                    prpLcheckLossDto2  = (PrpLcheckLossDto)prpLcheckLossList.get(intCheckLossIndex);
                    intCheckLossIndex++;  
                  }
              //  }
                //Modify by chenrenda update end 20050418
              %>
              <tr>
                <input type="hidden"  name="prpLthirdPropFlag" value="<bean:write name='ThirdPropdtox' property='flag'/>">
                <td class="input" style="width:10%"> 
                  <input name="prpLthirdPropItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='ThirdPropdtox' property='serialNo'/>">
                  	<input type="hidden" class="readonlyno"  name="prpLthirdPropNewAddFlag" value="old"> <!--add by liyanjie 2005-12-17�Ƿ��������ĲƲ���ʧ -->
                </td> 
                <td class="input" style="width:15%;display:none">
                  <input name="prpLthirdPropLicenseNo" class="common"   style="width:90%" value="<bean:write name='ThirdPropdtox' property='licenseNo'/>">
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLthirdLossItemName" class="codename" style="width:90%" value="<bean:write name='ThirdPropdtox' property='lossItemName'/>" >  
                  <input type="hidden"  name="prpLthirdLossItemCode"  value="<bean:write name='ThirdPropdtox' property='lossItemCode'/>">
                </td>
                <td class="input" style="width:21%">
                  <input name="prpLthirdPropLossDesc" class="input" style="width:90%" value="<bean:write name='ThirdPropdtox' property='lossItemDesc'/>">
                </td>
                
                <!--Modify by chenrenda add begin 20050417-->
                <!--Reason:������ģ��ϵ��Ʋ���ʧ��Ϣ��-->
                <%
              //  if(strThirdPropNodeType.equals("check")){
                %>
                <td class="input" style="display:none">
                
                 <select name="prpLthirdPropKindCode" styleClass="three" style='width:100px' >
                   <%
                      Iterator prpLcheckItemKind = prpLThirdPropItemKindColl.iterator();
                      while (prpLcheckItemKind.hasNext()){
                        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpLcheckItemKind.next();
                   %>
                      <option value="<%= prpCitemKindDto.getKindCode() %>" <%= ((prpCitemKindDto.getKindCode().trim().equals(prpLcheckLossDto2.getKindCode())) ? "selected" : "") %>><%= prpCitemKindDto.getKindName() %></option>
                    <%
                       }
                   %> 
                   </select>
                </td>
                <td class="input" style="width:20%">
                  <input  name="prpLthirdPropLossFee" class="input" style="width:100%;align:right"  value="<%=prpLcheckLossDto2.getLossFee()%>" >
                </td>
                <%
             //   }
                %>
                <!--Modify by chenrenda add end 20050417-->
                  
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonThirdPropDelete"  onclick="deleteRow(this,'ThirdProp')" value="-" disabled style="cursor: hand">
                </div>
                </td>
              </tr>
 
        </logic:iterate>
      </logic:notEmpty>         
          </tbody>
          <!--������ʧ���붨Ϊ5-->
          <input type="hidden" name="txtCodeType" value="5">
        </table>  
        </span>    
      </td>
    </tr>
  </table>



  
  



