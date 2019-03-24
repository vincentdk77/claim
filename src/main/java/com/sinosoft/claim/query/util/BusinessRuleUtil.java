package com.sinosoft.claim.query.util;
/****************************************************************************
 * DESC       ：业务处理工具类
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2005-03-22
 * MODIFYLIST ：  Name       Date            Reason/Contents
 ****************************************************************************/



import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.query.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.query.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIUtiCodeTransferAction;
import com.sinosoft.claim.query.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 *  数据类型相关处理工具类 
 */
public class BusinessRuleUtil
{

  /**
   * 取得险种的代码
   * @param    policyNo   字段名
   * @return   riskCode   险种
   */
  public static String getRiskCode(String businessNo,String businessType)throws Exception
  {
    String riskCode  = "";
    String condition = "";
    if(businessType.equals("PolicyNo")){//-----------------------保单号
        EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
        PolicyDto policyDto = null;
        policyDto = endorseViewHelper.findForEndorBefore(businessNo);
        riskCode = policyDto.getPrpCmainDto().getRiskCode();
        //System.out.println("----------------------------"+riskCode);
        return riskCode;
    }else if(businessType.equals("RegistNo")){//-------------------报案号
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("ClaimNo")){//------------------立案号
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(businessNo);
        riskCode = prpLclaimDto.getRiskCode(); 
        return riskCode;   
    }else if(businessType.equals("CompensateNo")){//----------------计算书号
        BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
        PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
        ArrayList compensateList = new ArrayList();
        condition = "compensateno = '"+businessNo+"'" ;
        compensateList = (ArrayList)blPrpLcompensateFacade.findByConditions(condition);
        prpLcompensateDto = (PrpLcompensateDto)compensateList.get(0);
        riskCode = prpLcompensateDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("CaseNo")){//-------------------结案号
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        ArrayList claimList = new ArrayList(); 
        condition = "caseno = '"+businessNo+"'" ;
        claimList = (ArrayList)blPrpLclaimFacade.findByConditions(condition);
        prpLclaimDto = (PrpLclaimDto)claimList.get(0);
        riskCode = prpLclaimDto.getRiskCode(); 
        return riskCode;
    }else if(businessType.equals("ScheduleNo")){//-----------------调度号
        //目前，系统没有调度号，调度主表中没有调度号，报案号和调度序号为主键
        //所以，调度号即为报案号
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("CheckNo")){//--------------------查勘号
        //目前，系统没有查勘号，查勘主表中没有查勘号，主键为报案号和关联理赔车辆序号
        //所以，查勘号即为报案号
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("CertifyNo")){//--------------------单证号
        //目前系统没有单独的单证号，采用的是报案号
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("PrepayNo")){//--------------------预赔号
        //目前系统没有预赔，估计，以后会有，这里预留接口
        UIPrepayAction uiPrepayAction = new UIPrepayAction();
        PrepayDto prepayDto = new PrepayDto(); 
        prepayDto = uiPrepayAction.findByPrimaryKey(businessNo);
        riskCode = prepayDto.getPrpLprepayDto().getRiskCode();
        return riskCode;
    }
    if(riskCode.equals("")){
        throw new UserException(-6,-109,"getRiskCode","获取险种代码失败,请联系系统管理员。");
    }
    return riskCode;
    }

  /**
   * 取得UI的forward
   * @param    httpServletRequest   httpServletRequest
   * @param    riskCode             险种
   * @param    nodeType             节点代码(regis,check等)
   * @param    editType             编辑类型(SHOW,EDIT,ADD,DELETE等)
   * @param    lossItemCode         标的号(0为人伤，－1为物损，车辆为1，2，3...等，不知道的时候填1)
   * @return   forward              向前
   */
  public static String getForward(HttpServletRequest httpServletRequest,String riskCode,String nodeType,String editType,int lossItemCode) throws Exception
  {  
    String forward = ""; //向前
    String originalRisk = riskCode;
    //System.err.println("originalRisk:" + originalRisk);
   //用于区分是否从核心业务系统的调用
    //System.err.println("paramPrpallRegist:" + httpServletRequest.getParameter("paramPrpallRegist"));
    //System.err.println("paramUndwrtCompe:" + httpServletRequest.getParameter("paramUndwrtCompe"));
    if (httpServletRequest.getParameter("paramPrpallRegist") != null && httpServletRequest.getParameter("paramPrpallRegist").equals("DAA")) {
    	riskCode = "DAA";
    } else if (httpServletRequest.getParameter("paramUndwrtCompe") != null && httpServletRequest.getParameter("paramUndwrtCompe").equals("DAA")) {
    	riskCode = "DAA";
    } else {          //测试险种代码转换 
	  ArrayList transferList =(ArrayList)httpServletRequest.getSession().getAttribute("transferList");
	  
	  if (transferList == null) {  //考虑理赔系统被其他系统调用，需要初始化一些信息。
	  	UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
	  	transferList = (ArrayList)uiUtiCodeTransferAction.findByConditions(" 1=1");	  	
	  }
	  //System.out.println("transferList.size()"+transferList.size());
	  //add by lixiang start at 2006-7-20
	  //reason:如果没有在转换表中查询到的险种，是不允许继续理算的，应该只能在增加了uitocodetransfer的表数据，再能进行操作。
	  boolean findTheRiskCode=false;//默认为false的。
      //add by lixiang end at 2006-7-20
	  
	  for(int i = 0;i<transferList.size();i++){
	  	UtiCodeTransferDto utiCodeTransferDto = (UtiCodeTransferDto)transferList.get(i);
	  	//System.out.println("utiCodeTransferDto.getOuterCode()"+utiCodeTransferDto.getOuterCode());
	  	if(riskCode.equals(utiCodeTransferDto.getOuterCode())){
	  		riskCode = utiCodeTransferDto.getInnerCode();
	  		findTheRiskCode=true;
	  		break;
	  	}
	  }
	  //System.out.println("findTheRiskCode:" + findTheRiskCode);
	  
	  //System.out.println("InnerCode:" + riskCode);
	  
      //add by lixiang start at 2006-7-20
	  //reason:如果没有在转换表中查询到的险种，是不允许继续理算的，应该只能在增加了uitocodetransfer的表数据，再能进行操作。
      if (!findTheRiskCode){
       	throw new UserException(1,3,"claim","" +
    			"请联系系统管理员，进行险种'"+riskCode+"'在UICODETRANSFER表的初始化！");
       }
      //add by lixiang end at 2006-7-20
	 
    }
        System.out.println("nodeType:" + nodeType);
        System.out.println("lossItemCode:" + lossItemCode);
	    String riskCodeForward = "";//从配置文件里面取得系统处理的险类的信息
	    try{
	      riskCodeForward = AppConfig.get("sysconst.RiskCodeForward");
	    }catch(Exception ex){
	      ex.printStackTrace(); 
	    }
	    if(nodeType.equals("commo")){
	
	    }if(nodeType.equals("certa")||nodeType.equals("verip")||nodeType.equals("verpo")||nodeType.equals("verif")){
	      if (lossItemCode > 1) {
	        lossItemCode = 1;
	      }
	      //3。如果是SHOW类型的，目前和EDIT用同一个目的jsp所以
	      if (editType.equals("SHOW") || editType.equals("DELETE")||editType.equals("TimeOut")) {
	        editType = "EDIT";
	      }
	      //4。如果不是DAA类别的，目前都归到"Prop"类型里，主要是财产险
	      if ((riskCode==null)||(riskCode.length() <1) ) riskCode="DAA";
	      String subRiskCode = riskCode.substring(0, 1);
	      if ( (riskCodeForward.indexOf(subRiskCode)) >= 0) {
	        forward = editType + lossItemCode+subRiskCode + "AA";
	      }
	      else {
	    	  //modify by miaowenjun 20060921 农险走不同的forward start
	    	if("I".equals(subRiskCode)||"H".equals(subRiskCode)){
	    		forward = editType + "Agri";
	    	}else{
	    		if(("0310".equals(originalRisk)||"0312".equals(originalRisk)) && nodeType.equals("verif"))
	    		{
	    			forward = editType + "-1DAA";
	    		}
	    		else
	    		{
	    			forward = editType + "Prop";
	    		}
	    	}
	    	//modify by miaowenjun 20060921 农险走不同的forward end
	      }
	    } else {
	      //3。如果是SHOW类型的，目前和EDIT用同一个目的jsp所以
	      if (editType.equals("SHOW") || editType.equals("DELETE")||editType.equals("TimeOut")) {
	        editType = "EDIT";
	      }
	      //4。如果不是DAA类别的，目前都归到"Prop"类型里，主要是财产险
	      if ((riskCode==null)||(riskCode.length() <1) ) riskCode="DAA";
	      String subRiskCode = riskCode.substring(0,1);
	
	          System.out.println("--riskCodeForward---="+riskCodeForward+"-subRiskCode--="+subRiskCode+"--是否存在的标志，如果大于等于0则存在--="+riskCodeForward.indexOf(subRiskCode));
	      if ((riskCodeForward.indexOf(subRiskCode))>=0) {
	        forward = editType + subRiskCode+"AA";
	        //System.out.println("forword=="+forward);
	      }else {
	    	  	//modify by miaowenjun 20060921 农险走不同的forward start
		    	if("I".equals(subRiskCode)||"H".equals(subRiskCode)){
		    		forward = editType + "Agri";
		    	}else{


		    			forward = editType + "Prop";

		    		
		    	}
		    	//modify by miaowenjun 20060921 农险走不同的forward end
	      }
	    }
   
    System.out.println("-产生的-getForward----=" + forward);
    return forward;
  }

  /**
   * 取得UI的forward
   * @param    nodeType         节点类型 
   * @return   iTaskCode        taskCode
   */  
  public static String transTaskCode(String nodeType){
  	String iTaskCode=""; 
	if("regis".equals(nodeType)){
		iTaskCode="lpba";
	} else if("sched".equals(nodeType)){
		iTaskCode="lpdd";
	} else if("check".equals(nodeType)){
		iTaskCode="lpck";
	} else if("certa".equals(nodeType)){
		iTaskCode="lpds";
	} else if("claim".equals(nodeType)){
		iTaskCode="lpla";
	} else if("quote".equals(nodeType)){ 
		iTaskCode="lpbj";
	} else if("verip".equals(nodeType) || "verpo".equals(nodeType)){
		iTaskCode="lphj";
	} else if("verif".equals(nodeType)){
		iTaskCode="lphs";
	} else if("wound".equals(nodeType)){
		iTaskCode="lprd";
	} else if("veriw".equals(nodeType)){
		iTaskCode="lprh";
	} else if("certi".equals(nodeType)){
		iTaskCode="lpdz";
	} else if("prepa".equals(nodeType)){
		iTaskCode="lppa";
	} else if("compe".equals(nodeType)){
		iTaskCode="lppa"; 
	}else if("compp".equals(nodeType)){
		iTaskCode="lppa"; 
	} else if("speci".equals(nodeType)){
		iTaskCode="lpts"; 
	} else if("right".equals(nodeType)){
		iTaskCode="lpzc"; 
	} else if("endca".equals(nodeType)){
		iTaskCode="lpja"; 
	} else if("cance".equals(nodeType)){
		iTaskCode="lpzx"; 
	} else if("veric".equals(nodeType)){
		iTaskCode="lphp"; 
	} else if("veric".equals(nodeType)){
		iTaskCode="lphp"; 
	} else if("propc".equals(nodeType)){
		iTaskCode="lpcd"; 
	} else if("propv".equals(nodeType)){
		iTaskCode="lpch"; 
	} else if("backc".equals(nodeType)){
		iTaskCode="lpxy"; 
	} else if("backv".equals(nodeType)){
		iTaskCode="lphf"; 
	}
	return iTaskCode;
  }

  /**
   * 根据ConfigCode从险种对照表取得外码
   * @param    configCode   字段名    
   * @return   riskCode   险种
   */
  public static String getOuterCode(HttpServletRequest httpServletRequest,String configCode) throws Exception
  {
  	  String riskCode=""; 
	  //测试险种代码转换
	  ArrayList transferList =(ArrayList)httpServletRequest.getSession().getAttribute("transferList");
	  
	  if (transferList == null) {  //考虑理赔系统被其他系统调用，需要初始化一些信息。
	  	UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
	  	transferList = (ArrayList)uiUtiCodeTransferAction.findByConditions(" 1=1");
	  	//httpServletRequest.getSession().setAttribute("transferList", transferList); 
	  }
	  
	  for(int i = 0;i<transferList.size();i++){
	  	UtiCodeTransferDto utiCodeTransferDto = (UtiCodeTransferDto)transferList.get(i);
	  	if(configCode.equals(utiCodeTransferDto.getConfigCode())){
	  		riskCode = utiCodeTransferDto.getOuterCode();
	  		break;
	  	} 
	  }  
	  
	  return riskCode;
  } 
  
  
  /**
   * 根据kindCode从判断是不是这个类别的险别
   * @param kindType   险别类型 （可用参数 MainCarLoss:主标的车辆损失，
   *                                       ThirdLoss(包括人车物)，
   *                                       ThirdCarLoss:三者车
   *                                       ThirdPropLoss:三者物
   *                                       ThirdPersonLoss:三者人）
   * @param kindCode   险别
   * @return boolean
   */
  public static boolean checkKindType(String kindType,String kindCode) throws Exception
  {
  	  boolean blReturn= false; 
	  //测试险种代码转换
  	  //MainCarLoss:主标的车辆损失，
  	  
  	  if (kindType==null) return false;
  	  
  	  if (kindCode==null) return false;
  	  
  	  if (kindType.equals("MainCarLoss")){//:主标的车辆损失，
  	  	 if (kindCode.equalsIgnoreCase( "A")
  	  			||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("002")){
  	     	blReturn= true; 
  	  	 }
  	  }
  	  if (kindType.equals("ThirdLoss")){//:(包括人车物)，
  		if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
 	  			||kindCode.equalsIgnoreCase( "D3")||kindCode.equalsIgnoreCase( "D4")
				||kindCode.equalsIgnoreCase( "D2")||kindCode.equalsIgnoreCase( "H")
				||kindCode.equalsIgnoreCase( "D1")
				||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")
				||kindCode.equalsIgnoreCase("004")){
 	  		blReturn= true; 
 	       }
	  }
  	  
  	  if (kindType.equals("ThirdCarLoss")){//:三者车
  	     if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
  	    		||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")){
     	    blReturn= true; 
  	    }
  	  }
  	 
 	  if (kindType.equals("ThirdPropLoss")){//:三者物，
 	  	if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
 	  			||kindCode.equalsIgnoreCase( "D2")||kindCode.equalsIgnoreCase( "H")
 	  			||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")){
 	  		blReturn= true; 
 	       }
	  }
 	  if (kindType.equals("ThirdPersonLoss")){//:三者人，
 	  	if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
 	  			||kindCode.equalsIgnoreCase( "D3")||kindCode.equalsIgnoreCase( "D4")
				||kindCode.equalsIgnoreCase( "R")
				||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")){
 	  		blReturn= true; 
 	       }
 	  }
 	  	
 	  
	  return blReturn;
  } 
  
  /**
   * 根据kindType整理kindItem列表
   * @param kindType   险别类型 （可用参数 MainCarLoss:主标的车辆损失，
   *                                       ThirdLoss(包括人车物)，
   *                                       ThirdCarLoss:三者车
   *                                       ThirdPropLoss:三者物
   *                                       ThirdPersonLoss:三者人）
   * @param kindCode   险别
   * @return boolean
   */
  public static Collection getReferItemKindListByKindType(String kindType,ArrayList itemKindList) throws Exception
  {
  	Collection itemKindListNew = new ArrayList();
	  //测试险种代码转换
  	  //MainCarLoss:主标的车辆损失，
  	  if (kindType==null) return itemKindListNew;
  	  if (itemKindList==null) return itemKindListNew;
  	  
  	  for (int i = 0; i < itemKindList.size(); i++) {
		PrpCitemKindDto prpCitemKindDto1 = new PrpCitemKindDto();  //原来的写法出现：A-A-A-车损险  这种情况
		PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) itemKindList.get(i);
		prpCitemKindDto1.setPolicyNo(prpCitemKindDto.getPolicyNo());
		prpCitemKindDto1.setRiskCode(prpCitemKindDto.getRiskCode());
		prpCitemKindDto1.setKindCode(prpCitemKindDto.getKindCode());
		prpCitemKindDto1.setKindName(prpCitemKindDto.getKindCode() + "-"
				+ prpCitemKindDto.getKindName());
		
		if (checkKindType(kindType,prpCitemKindDto1.getKindCode())){
			itemKindListNew.add(prpCitemKindDto1);
		}
  	 
 	  }
 	  return itemKindListNew;
  } 
  
}
