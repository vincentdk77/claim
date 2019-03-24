package com.sinosoft.claim.ui.control.facade;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;

public class UIClaimRelateListNoFacade extends Action
{

  /**
   * �����嵥����ҳ���в�ѯ�����Ϣ
   * @param actionMapping ActionMapping
   * @param actionForm ActionForm
   * @param httpServletRequest HttpServletRequest
   * @param httpServletResponse HttpServletResponse
   * @throws Exception
   * @return ActionForward
   */
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
	  String strRelationListNo  = httpServletRequest.getParameter("RelationListNo");
	  String strRiskCode= httpServletRequest.getParameter("vStrRiskCode");
	 
	    ServletOutputStream os = httpServletResponse.getOutputStream();
	    String xmlText="";
		try{
			String conditions = "";
			//���������嵥���ܻ���
			if(null==strRiskCode||"".equals(strRiskCode)){
				conditions = " settlelistcode ='" + strRelationListNo + "' and validity='1' and ABS(SETTLEAREA)>0  ";
			}else{
				conditions = " settlelistcode ='" + strRelationListNo + "' and INSURECATEGORY = '"+strRiskCode+"' and validity='1' and ABS(SETTLEAREA)>0  ";
			}
			int sumSettleCount = new BLPrpLcompensateFacade().getCountForNXDA(conditions);
			//���������嵥����Ķ��
			if(null==strRiskCode||"".equals(strRiskCode)){
				conditions = " settlelistcode ='" + strRelationListNo + "'  and validity='1' ";
			}else{
				conditions = " settlelistcode ='" + strRelationListNo + "' and INSURECATEGORY = '"+strRiskCode+"' and validity='1' ";
			}
			double sumSettleArea = new BLPrpLcompensateFacade().getSumSettleAreaForNXDA(conditions);
		    xmlText = sumSettleCount+"|"+sumSettleArea;
			os.write(xmlText.getBytes("UTF-8"));
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	    	os.close();
	    }
		return null;
  }

}