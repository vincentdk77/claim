<%--
****************************************************************************
* DESC       �� ��ʾ������Ϣ
* AUTHOR     �� sunchenggang
* CREATEDATE �� 2005-12-10
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html;charset=gb2312"%>                    

<%-- ����bean�ಿ�� --%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLclaimFittingsFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto"%>

<script>

<%
               
  String registNo     = request.getParameter("registNo");
  String lossItemCode = request.getParameter("lossItemCode");
  
  String conditiong = "";
      
  try
  {
    BLPrpLclaimFittingsFacade blPrpLclaimFittingsFacade = new BLPrpLclaimFittingsFacade();
    PrpLclaimFittingsDto prpLclaimFittingsDto = null;
    Collection fittinsList = null;
    
    conditiong = " registNo='"+registNo+"' AND lossItemCode='"+lossItemCode+"'";
    fittinsList = blPrpLclaimFittingsFacade.findByConditions(conditiong);
        
    Iterator it = fittinsList.iterator(); 
    while(it.hasNext()){      
      prpLclaimFittingsDto = (PrpLclaimFittingsDto)it.next();  
      if(!"D".equals(prpLclaimFittingsDto.getStatus())){
%>
      parent.fraInterface.insertRowTableComponent('Component','Component_Data',parent.fraInterface.fm.buttonComponentInsert);

      var count = parent.fraInterface.getElementCount("prpLcomponentCompName");  


	//parent.fraInterface.fm.prpLcomponentKindCode[count-1].value = '<%=prpLclaimFittingsDto.getKindCode()%>';
	//parent.fraInterface.fm.prpLcomponentKindName[count-1].value = '<%=prpLclaimFittingsDto.getKindName()%>';
	parent.fraInterface.fm.prpLcomponentCompCode[count-1].value = '<%="".equals(prpLclaimFittingsDto.getFittingCode())? "9999":prpLclaimFittingsDto.getFittingCode()%>';	
	parent.fraInterface.fm.prpLcomponentCompName[count-1].value = '<%=prpLclaimFittingsDto.getFittingName()%>';
	parent.fraInterface.fm.prpLcomponentMaterialFee[count-1].value = '<%=prpLclaimFittingsDto.getCertaPrice()%>';
	parent.fraInterface.fm.prpLcomponentQuantity[count-1].value = '<%=prpLclaimFittingsDto.getCertaQuantity()%>';
	parent.fraInterface.fm.prpLcomponentOriginalId[count-1].value = '<%=prpLclaimFittingsDto.getOriginalID()%>';
	parent.fraInterface.fm.prpLcomponentIndId[count-1].value = '<%=prpLclaimFittingsDto.getIndId()%>';
	parent.fraInterface.fm.prpLcomponentSys4SPrice[count-1].value = '<%=prpLclaimFittingsDto.getChgRefPrice()%>';
	
	parent.fraInterface.fm.prpLcomponentSysMarketPrice[count-1].value = '<%=prpLclaimFittingsDto.getSysMarketPrice()%>';
	parent.fraInterface.fm.prpLcomponentSysMatchPrice[count-1].value = '<%=prpLclaimFittingsDto.getSysmatchPrice()%>';
	parent.fraInterface.fm.prpLcomponentNative4SPrice[count-1].value = '<%=prpLclaimFittingsDto.getNative4SPrice()%>';
	parent.fraInterface.fm.prpLcomponentNativeMarketPrice[count-1].value = '<%=prpLclaimFittingsDto.getNativeMarketPrice()%>';
	parent.fraInterface.fm.prpLcomponentNativeMatchPrice[count-1].value = '<%=prpLclaimFittingsDto.getNativeMatchPrice()%>';
	parent.fraInterface.fm.prpLcomponentVerpCompPrice[count-1].value = '<%=prpLclaimFittingsDto.getVerifyPrice()%>';
	parent.fraInterface.fm.prpLcomponentRemark[count-1].value = '<%=prpLclaimFittingsDto.getRemark()%>';
	parent.fraInterface.fm.prpLcomponentFlag[count-1].value = '1';


                         
<%      
    }
    }
  }
  catch(Exception e)
  {
    e.printStackTrace();
    out.println("window.status='û�в�ѯ����Ӧ�Ĳ�����Ϣ';");
  }
  
%>                                                     

</script>
