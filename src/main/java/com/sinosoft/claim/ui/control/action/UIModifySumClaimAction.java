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
 * 估损金额调整，阳光财产项目组
 * <p>Title: 对系统中的估损金额进行处理  </p>
 * <p>Description: 调整估损金额信息</p>
 * <p>Copyright: Copyright (c) 200５５5</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIModifySumClaimAction
{
    public UIModifySumClaimAction(){}//默认构造函数
    
    /**
     * 查询立案信息
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
        if(request.getParameter("editType").equals("RegistBeforeQuery") || request.getParameter("editType").equals("modifyBeforeQuery")){  	//换页处理
        	if (user.getQueryCondition().getQueryKey().equals("modifySumClaim")) {
                conditions = user.getQueryCondition().getConditions();
            }
        	pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
            rowsPerPage = paramUtils.getIntParameter("rowsPerPage", user.getQueryCondition().getRowsPerPage());
        }else{ //第一次查询
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
     * 查询立案估损详细信息
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
   	    	throw new UserException(1,2,"claim","查询立案估损详细信息错误,赔案号不存在");
   	    }
   	    BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		
		String isShow = request.getParameter("isShow");//双核系统调用时不显示操作按钮的控制
		if (isShow==null) {
			String conditions=" nodeType='compp' and registno in (select claim.registno from prplclaim claim where claim.claimno='"+claimNo+"')";
			Collection comppSwflogList=blSwfLogFacade.findByConditions(conditions);
			if (comppSwflogList.size()>0) {
				throw new Exception( "理算已通过不能进行立案估损调整!");
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
   	    	//查询险别和币别中文名称
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
   	    
   	    //当前状态
        request.setAttribute("editType", "modifyDetail");
		request.setAttribute("riskcode", claimDto.getPrpLclaimDto().getRiskCode());
   	    
   	    UIPolicyAction uiPolicyAction = new UIPolicyAction();
   	    PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
   	    request.setAttribute("policyInputDate", policyDto.getPrpCmainDto().getInputDate().toString());

   	    PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyDto.getPrpCmainDto().getInputDate().toString(),"2011-02-27");
	    //用旧的获取危险单位信息方法
	    if(time<0){
	    	//add by qinyongli start 2005-8-16
		    //reason:获取危险单位信息
			UIRiskUnitAction uiRiskUnitAction = new UIRiskUnitAction();
		    PrpLdangerUnitDto prpLdangerUnitDto = uiRiskUnitAction.findByPrimaryKeyFromPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo(),1,request,claimDto.getPrpLclaimDto().getRiskCode(),0);
		    
		    if(prpLdangerUnitDto!=null&&prpLdangerUnitDto.getCurrency()!=null&&!prpLdangerUnitDto.getCurrency().equals("")){
	            prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLdangerUnitDto.getCurrency(), true)); //用此字段表示币别中文信息
		    }
	        if(prpLdangerUnitDto==null){
	        	prpLdangerUnitDto = new PrpLdangerUnitDto();
	        }
		    
	        //双核调用显示
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
		    //双核调用显示
		    if(isShow!=null&&"true".equals(isShow)){
		    	//用新的获取危险单位信息方法
		        BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
		        List prpLdangerUnitList = new ArrayList();
		        prpLdangerUnitList=blDangerFacade.getPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo());
		        request.setAttribute("prpLdangerUnitList", prpLdangerUnitList);
	         }
	    }
   }
   /**
    * 保存估损金额信息
    * @param request
    * @param response
    * @throws Exception
    */
   public void saveClaimLoss(HttpServletRequest request,
        HttpServletResponse response)throws Exception{
    ///*---------------------险别估损金额PrpLclaimloss------------------------------------*/
    ArrayList claimLossList = new ArrayList();
    PrpLclaimLossDto prpLclaimLossDto = null;
    //从界面得到输入数组
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
    //修改估损金额信息
    if(prpLclaimLossClaimNo.length()==21){
        BLPrpLclaimLossFacade  blPrpLclaimLossFacade = new BLPrpLclaimLossFacade();  
        String conditions1= "1=1";
        conditions1 = conditions1 + " and claimNo ='"+prpLclaimLossClaimNo+"' ";
        blPrpLclaimLossFacade.updateClaimLoss(conditions1,claimLossList);    
    }

   }  
}
