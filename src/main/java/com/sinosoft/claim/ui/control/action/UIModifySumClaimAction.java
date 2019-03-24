package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimLossFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.Str;

/**
 * ���������������Ʋ���Ŀ��
 * <p>Title: ��ϵͳ�еĹ�������д���  </p>
 * <p>Description: ������������Ϣ</p>
 * <p>Copyright: Copyright (c) 200����5</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIModifySumClaimAction
{
    public UIModifySumClaimAction(){}//Ĭ�Ϲ��캯��
    
    /**
     * ��ѯ������Ϣ
     * @param request
     * @param response
     * @throws SQLException
     * @throws Exception
     */
    public void findClaimInforByCondition(HttpServletRequest request,
                               HttpServletResponse response)throws SQLException,Exception{
    	Collection claimList = null;
    	ParamUtils paramUtils = new ParamUtils(request);
    	HttpSession session = request.getSession();
    	UserDto user = (UserDto) (session.getAttribute("user"));
    	String userCode = user.getUserCode();
        userCode = userCode.substring(0,2);
        String riskType 	   = request.getParameter("riskType");
    	String claimNo         = request.getParameter("ClaimNo");
    	String claimNoSign     = request.getParameter("ClaimNoSign");
    	String policyNo        = request.getParameter("PolicyNo");
    	String policyNoSign    = request.getParameter("PolicyNoSign");
    	String insuredName     = request.getParameter("InsuredName");
    	String insuredNameSign = request.getParameter("InsuredNameSign");
    	String riskCode        = request.getParameter("RiskCode");
    	String riskCodeSign    = request.getParameter("RiskCodeSign");
    	String conditions      = " 1=1 ";
        conditions = conditions + StringConvert.convertString("claimNo", claimNo, claimNoSign);
        conditions = conditions + StringConvert.convertString("policyNo", policyNo, policyNoSign);
        conditions = conditions + StringConvert.convertString("insuredName", insuredName, insuredNameSign);
        conditions = conditions + StringConvert.convertString("riskCode", riskCode, riskCodeSign);
        
        /*if(!userCode.equals("00")){
           conditions = conditions + " and comCode like '"+userCode+"%'";
           conditions = conditions + " AND (HANDLERCODE = '" + userCode + "' OR OPERATORCODE = '" + userCode + "')";
        }*/
        if("ND".equals(riskType)){
			conditions = conditions +" and riskCode not in ('0506','0507','0576','0577','0586','0587')";
			conditions = conditions +" and (caseno is null or caseno='') ";
		}
        conditions = conditions + "order by inputdate desc";
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();  
        int pageNo = 1;
        int rowsPerPage = 20;     
        if(request.getParameter("editType").equals("RegistBeforeQuery") || request.getParameter("editType").equals("modifyBeforeQuery")){  	//��ҳ����
        	if (user.getQueryCondition().getQueryKey().equals("modifySumClaim")) {
                conditions = user.getQueryCondition().getConditions();
            }
        	pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
            rowsPerPage = paramUtils.getIntParameter("rowsPerPage", user.getQueryCondition().getRowsPerPage());
        }else{ //��һ�β�ѯ
        	pageNo = 1;
            rowsPerPage = 20;
        	user.setQueryCondition("modifySumClaim", conditions, pageNo, rowsPerPage);
        }
        PageRecord pageRecord = blPrpLclaimFacade.findByConditions(conditions,pageNo,rowsPerPage);
        TurnPageDto turnPageDto= new TurnPageDto();
        turnPageDto.setResultList((List)pageRecord.getResult());
        turnPageDto.setPageNo(pageRecord.getPageNo());
        turnPageDto.setRecordPerPage(20);
        turnPageDto.setTotalCount(pageRecord.getCount());
        turnPageDto.setCondition(conditions);
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
        request.setAttribute("pageview", turnPageDto);
        
        claimList = blPrpLclaimFacade.findByConditions(conditions,pageNo,rowsPerPage).getResult();       
        request.setAttribute("claimList",claimList);   	
    }
    /**
     * ��ѯ����������ϸ��Ϣ
     * @param request
     * @param response
     * @throws SQLException
     * @throws Exception
     */
   public void findDetailByClaimNo(HttpServletRequest request,
        HttpServletResponse response)throws UserException,Exception{
   	    String claimNo   = request.getParameter("claimNo");
   	    UIClaimAction uiClaimAction = new UIClaimAction();
   	    ClaimDto claimDto = null;
   	    if(claimNo==null){
   	    	throw new UserException(1,2,"claim","��ѯ����������ϸ��Ϣ����,�ⰸ�Ų�����");
   	    }
   	    BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		
		String isShow = request.getParameter("isShow");//˫��ϵͳ����ʱ����ʾ������ť�Ŀ���
		if (isShow==null) {
			String conditions=" nodeType='compp' and registno in (select claim.registno from prplclaim claim where claim.claimno='"+claimNo+"')";
			Collection comppSwflogList=blSwfLogFacade.findByConditions(conditions);
			if (comppSwflogList.size()>0) {
				throw new Exception( "������ͨ�����ܽ��������������!");
			}
		}
		
   	    claimDto =  uiClaimAction.findByPrimaryKey(claimNo);
   	    PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
   	    ArrayList claimLossList = claimDto.getPrpLclaimLossDtoList();
   	    ArrayList claimLossListNew = new ArrayList();
   	    Iterator lossIterator = claimLossList.iterator();
   	    UICodeAction uiCodeAction = new UICodeAction();
   	    while(lossIterator.hasNext()){
   	    	prpLclaimLossDto = (PrpLclaimLossDto)lossIterator.next();
   	    	//��ѯ�ձ�ͱұ���������
   	    	String kindCode = prpLclaimLossDto.getKindCode();
   	    	String kindName = uiCodeAction.translateKindCode(prpLclaimLossDto.getRiskCode(),kindCode,true);
   	    	prpLclaimLossDto.setKindName(kindName);
   	    	String currencyCode = prpLclaimLossDto.getCurrency();
   	    	String currencyName = uiCodeAction.translateCurrencyCode(currencyCode,true);
   	    	prpLclaimLossDto.setCurrencyName(currencyName);
   	    	claimLossListNew.add(prpLclaimLossDto);
   	    }
   	    claimDto.setPrpLclaimLossDtoList(claimLossListNew);  
   	    request.setAttribute("claimDto",claimDto);  
   	    request.setAttribute("prpLclaimDto",claimDto.getPrpLclaimDto());
   	    
   	    //��ǰ״̬
        request.setAttribute("editType", "modifyDetail");
		request.setAttribute("riskcode", claimDto.getPrpLclaimDto().getRiskCode());
   	    
   	    UIPolicyAction uiPolicyAction = new UIPolicyAction();
   	    PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
   	    request.setAttribute("policyInputDate", policyDto.getPrpCmainDto().getInputDate().toString());

   	    PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyDto.getPrpCmainDto().getInputDate().toString(),"2011-02-27");
	    //�þɵĻ�ȡΣ�յ�λ��Ϣ����
	    if(time<0){
	    	//add by qinyongli start 2005-8-16
		    //reason:��ȡΣ�յ�λ��Ϣ
			UIRiskUnitAction uiRiskUnitAction = new UIRiskUnitAction();
		    PrpLdangerUnitDto prpLdangerUnitDto = uiRiskUnitAction.findByPrimaryKeyFromPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo(),1,request,claimDto.getPrpLclaimDto().getRiskCode(),0);
		    
		    if(prpLdangerUnitDto!=null&&prpLdangerUnitDto.getCurrency()!=null&&!prpLdangerUnitDto.getCurrency().equals("")){
	            prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLdangerUnitDto.getCurrency(), true)); //�ô��ֶα�ʾ�ұ�������Ϣ
		    }
	        if(prpLdangerUnitDto==null){
	        	prpLdangerUnitDto = new PrpLdangerUnitDto();
	        }
		    
	        //˫�˵�����ʾ
	        if(isShow!=null&&"true".equals(isShow)){
	        	BLPrpLdangerUnitFacade blPrpLdangerUnitFacade=new BLPrpLdangerUnitFacade();
	        	ArrayList prpLdangerUnitList = (ArrayList) blPrpLdangerUnitFacade.findByConditions(" certino='"+claimDto.getPrpLclaimDto().getClaimNo()+"'");
	        	double sumloss=0;
	        	for (int i = 0; i < prpLdangerUnitList.size(); i++) {
	        		prpLdangerUnitDto=(PrpLdangerUnitDto)prpLdangerUnitList.get(i);
	        		sumloss+=prpLdangerUnitDto.getSumLoss();
	        	}
	        	request.setAttribute("sumloss", Str.round(sumloss, 2));
	        }
	        request.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);
	        //add by qinyongli end 2005-8-16
	    }else{
		    //˫�˵�����ʾ
		    if(isShow!=null&&"true".equals(isShow)){
		    	//���µĻ�ȡΣ�յ�λ��Ϣ����
		        BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
		        List prpLdangerUnitList = new ArrayList();
		        prpLdangerUnitList=blDangerFacade.getPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo());
		        request.setAttribute("prpLdangerUnitList", prpLdangerUnitList);
	         }
	    }
   }
   /**
    * �����������Ϣ
    * @param request
    * @param response
    * @throws Exception
    */
   public void saveClaimLoss(HttpServletRequest request,
        HttpServletResponse response)throws Exception{
    ///*---------------------�ձ������PrpLclaimloss------------------------------------*/
    ArrayList claimLossList = new ArrayList();
    PrpLclaimLossDto prpLclaimLossDto = null;
    //�ӽ���õ���������
    String prpLclaimLossClaimNo      = request.getParameter("prpLclaimClaimNo");
    String prpLclaimLossRiskCode     = request.getParameter("prpLclaimRiskCode");
    String[] prpLclaimLossSerialNo   = request.getParameterValues("prpLclaimLossSerialNo");
    String[] prpLclaimLossItemKindNo = request.getParameterValues("prpLclaimLossItemKindNo");
    String[] prpLclaimLossKindCode   = request.getParameterValues("prpLclaimLossKindCode");
    String[] prpLclaimLossItemCode   = request.getParameterValues("prpLclaimLossItemCode");
    String[] prpLclaimLossCurrency   = request.getParameterValues("prpLclaimLossCurrency");
    String[] prpLclaimLossSumClaim   = request.getParameterValues("prpLclaimLossSumClaim");
    String[] prpLclaimLossInputDate  = request.getParameterValues("prpLclaimLossInputDate");
    String[] prpLclaimLossRemarkFlag = request.getParameterValues("prpLclaimLossRemarkFlag");
    String[] prpLclaimLossFlag       = request.getParameterValues("prpLclaimLossFlag");
    String[] prpLregsitLossFeeType = request.getParameterValues("prpLclaimLossLossFeeType");
    if (prpLclaimLossCurrency == null) {
    } else {
        for (int index = 1; index < prpLclaimLossCurrency.length; index++) {
            prpLclaimLossDto = new PrpLclaimLossDto();
            prpLclaimLossDto.setClaimNo(prpLclaimLossClaimNo);
            prpLclaimLossDto.setRiskCode(prpLclaimLossRiskCode);
            prpLclaimLossDto.setSerialNo(index);
            prpLclaimLossDto.setItemKindNo(Integer.parseInt(prpLclaimLossItemKindNo[index]));
            prpLclaimLossDto.setKindCode(prpLclaimLossKindCode[index]);
            prpLclaimLossDto.setItemCode(prpLclaimLossItemCode[index]);
            prpLclaimLossDto.setCurrency(prpLclaimLossCurrency[index]);
            prpLclaimLossDto.setSumClaim(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossSumClaim[index])));
            prpLclaimLossDto.setInputDate(new DateTime(prpLclaimLossInputDate[index]));
            prpLclaimLossDto.setRemarkFlag(prpLclaimLossRemarkFlag[index]);
            if(prpLclaimLossFlag != null){
            	prpLclaimLossDto.setFlag(prpLclaimLossFlag[index]);
            }           
            if (prpLregsitLossFeeType != null) {
                prpLclaimLossDto.setLossFeeType(prpLregsitLossFeeType[index]);
            }
            claimLossList.add(prpLclaimLossDto);
        }
    } 
    //�޸Ĺ�������Ϣ
    if(prpLclaimLossClaimNo.length()==21){
        BLPrpLclaimLossFacade  blPrpLclaimLossFacade = new BLPrpLclaimLossFacade();  
        String conditions1= "1=1";
        conditions1 = conditions1 + " and claimNo ='"+prpLclaimLossClaimNo+"' ";
        blPrpLclaimLossFacade.updateClaimLoss(conditions1,claimLossList);    
    }

   }  
}
