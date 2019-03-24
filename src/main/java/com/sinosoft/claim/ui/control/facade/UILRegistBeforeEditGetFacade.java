package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLearFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriRegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.prpall.bl.facade.BLPrpCmainFacade;
import com.sinosoft.prpall.dbsvr.cb.DBPrpCitemCarExt;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.ChgDate;
import com.sinosoft.utility.string.Str;

/**
 * 分发HTTP GET 车险理赔报案前查询保单请求
 * <p>Title: 车险理赔报案前查询保单信息</p>
 * <p>Description: 车险理赔报案前查询保单信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILRegistBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception {
	  
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType     = httpServletRequest.getParameter("editType");
    String policyNo     = httpServletRequest.getParameter("prpCmainPolicyNo");   //保单号
    String registNo     = httpServletRequest.getParameter("prpLregistRegistNo"); //报案号
    String damageDate   = httpServletRequest.getParameter("damageDate");//出险日期
    String damageHour   = httpServletRequest.getParameter("damageHour");//出险小时
    String damageMinute = httpServletRequest.getParameter("damageMinute");//出险分钟
    String flashPage    = httpServletRequest.getParameter("FlashPage");//是否是ajax刷新页面
    String editForward  = editType;                 //最后做跳转的标志
    String riskCode = "";                           //险种
    String forward  = "";                           //向前
    String licenseNo    = httpServletRequest.getParameter("prpCmainLicenseNo");   //车辆号码
    HttpSession session = httpServletRequest.getSession();
    UserDto   user     = (UserDto)session.getAttribute("user");
  /*
   * 国元新的需求,这个标志位时为了识别是否是种植险的二次报案
   * editRegistFlag=ADD 新增报案
   * editRegistFlag=editH 种植险二次报案
   */
    String editRegistFlag = httpServletRequest.getParameter("editRegistFlag");
    

    try
    { 
    	//add by lym 20060604 for 强三 -----start>>>>>
      	//如果以商业保单查询-----------------
      	//注： 1。获取是否保强三标志qsflag 
      	//    2。获取强三保单 mainPolicyNo  
      	String  mainPolicyNo =""; 
      	String  quaryPolicyNo=policyNo;
      	String  relateMainPolicyNo =""; //关联强三保单
      	String  relatePolicyNo="";  //关联商业保单
      	String  flag =""; 
      	String  qsFlag ="N";  //N：没有关联  Y：有关联
      	
        int intPayFee  =0;
      	
      	 boolean qs_valid=false;
      	 boolean sy_valid=false;
      	 PrpCmainDto qs_prpCmainDto  = new  PrpCmainDto();
      	//取得强制保险的险种代码
        
        	//System.out.println("RISKCODE_DAZ:"+compelRiskCode);	
        if(policyNo == null){
        	riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        }
        if(registNo == null||registNo.equals("")){
        	riskCode = BusinessRuleUtil.getRiskCode(policyNo,"PolicyNo");
        }
        if(!"Y".equals(flashPage)){//如果不是更改页面出险时间时触发的刷新页面请求，出险时间为当前时间
        	ChgDate chg = new ChgDate();
        	String currentTime = chg.getCurrentTime("yyyy-MM-dd HH:mm:ss");
        	damageDate = currentTime.substring(0,10);
        	damageHour = currentTime.substring(11,13);
        	damageMinute = currentTime.substring(14,16);
        }
        damageMinute = Str.chgStrZero(damageMinute);
        //转成对应的交强险险种号
        TransCodeCI transCodeCI = new TransCodeCI();
        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode);
        
        String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
    	if("TimeOut".equals(editType))editType="SHOW";
    	/**
    	 * 种植险符合条件的报案号查询000
    	 * 国元 冯雷 开始
    	 */
    	if("H".equals(riskType)&& "ADDFLAG".equals(editRegistFlag)){
    		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
    		Collection collection = null;
    		collection = dAARegistViewHelper.registNoListToView(httpServletRequest);
    		if(collection.size()!=0){
	    		httpServletRequest.setAttribute("policyNo",policyNo);
	    		httpServletRequest.setAttribute("registNoList",collection);
				forward="CheckAgri";
				return actionMapping.findForward(forward);
    		}
    	}
    	/**
    	 * 种植险符合条件的报案号查询
    	 * 国元 冯雷 结束
    	 */
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      //1。查询保单信息,整理输入，用于初始界面显示
      if (editType.equals("ADD")) {
       	 PolicyDto  policySubDto = new PolicyDto();
      	 PrpCmainSubDto prpCmainSubDto  = new  PrpCmainSubDto();
      	 PrpCmainDto qs_prpCmainDtoTemp  = new  PrpCmainDto();
       
      	EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
      	UIPolicyAction  uiPolicyAction = new UIPolicyAction();
      	DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
      	PolicyDto  policyDto  =  uiPolicyAction.findByPrimaryKey(policyNo);
		String strFlag = policyDto.getPrpCmainDto().getFlag();
		String propssalNo = policyDto.getPrpCmainDto().getProposalNo();
		httpServletRequest.setAttribute("acciFlag", strFlag);
		httpServletRequest.setAttribute("propssalNo", propssalNo);
		//上海组合险页面显示判断，如果为上海机构的组合险单号，则显示出险人信息;
		String comcode = policyDto.getPrpCmainDto().getComCode().substring(0,2);
		httpServletRequest.setAttribute("comCode", comcode);
		ArrayList  prpCmainSubDtoList = policyDto.getPrpCmainSubDtoList();       	
       	String isStoppingCI = "N";//交强险在停驶期间的标志
       	String isStoppingBusiness = "N";//商业险在停驶期间的标志
       	String isValidRelatedFlag = "N";//交强险、商业险有效关联理赔得标志
       	if((policyDto.getPrpCmainDto().getRiskCode().equals("0507")||policyDto.getPrpCmainDto().getRiskCode().equals("0577")
       			||policyDto.getPrpCmainDto().getRiskCode().equals("0587")) && dAARegistViewHelper.checkIsStopping(policyNo, damageDate,damageHour)){
       		isStoppingCI = "Y";
       	}
       	if((policyDto.getPrpCmainDto().getRiskCode().equals("0506")||policyDto.getPrpCmainDto().getRiskCode().equals("0576")
       			||policyDto.getPrpCmainDto().getRiskCode().equals("0586")) && dAARegistViewHelper.checkIsStopping(policyNo, damageDate,damageHour)){
       		isStoppingBusiness = "Y";
       	}
      	 if (prpCmainSubDtoList !=null && prpCmainSubDtoList.size()>0) {
      		 for ( int i=0;i < prpCmainSubDtoList.size();i++){
      		  //出险时间在保险期限内  && flag[2]=1 
      		  prpCmainSubDto  = (PrpCmainSubDto) prpCmainSubDtoList.get(i);
      		  relateMainPolicyNo = prpCmainSubDto.getMainPolicyNo();
      		  relatePolicyNo = prpCmainSubDto.getPolicyNo();
      		  flag = prpCmainSubDto.getFlag();
      		  //add by lixiang start at 2006-6-18
      		  //reason:如果强制保单号码是错误的，则不加理会。
      		   if (!uiPolicyAction.isExist(relateMainPolicyNo) ) continue; 
      		  //add by lixiang end at 2006-6-18
      		  //System.out.println("判断强三关联标记::" +flag.substring(1,2) );
      		  if(flag !=null&&flag.length()>=3){
      		   if (flag.substring(0,1).equals("1") ) {
      		     if (relatePolicyNo.equals(policyNo)){  //以商业保单查询      		    	 
      		    	  policySubDto = endorseViewHelper.findForEndorBefore(relateMainPolicyNo,damageDate, damageHour);    		       
      		    	  
      		    	  if (policySubDto !=null){
      		    		  qs_prpCmainDtoTemp= policySubDto.getPrpCmainDto();
      		    		  sy_valid = dAARegistViewHelper.checkDate(httpServletRequest,relatePolicyNo, damageDate, Integer.parseInt(damageHour),Integer.parseInt(damageMinute));
      		    		  qs_valid = dAARegistViewHelper.checkDate(httpServletRequest,relateMainPolicyNo, damageDate, Integer.parseInt(damageHour),Integer.parseInt(damageMinute) );
      		    		  PolicyDto mainPolicyDto = uiPolicyAction.findByPrimaryKey(relateMainPolicyNo);
      		    		  if ( mainPolicyDto != null 
      		    			&& qs_valid && sy_valid
      		    			&& ("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
      		    			|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))) {  //查询到关联的有效强三保单,有效保单＝出险时间在保险期间内＋已缴费
      		    			isValidRelatedFlag = "Y";
      		    			  //交强险是否在停驶期间内
            		    	  if(dAARegistViewHelper.checkIsStopping(relateMainPolicyNo, damageDate,damageHour)){
               		       		  isStoppingCI = "Y";
               		       		  if("Y".equals(isStoppingBusiness)){
               		       			  //程序到此时，说明关联的两张保单均在停驶期间，此时显示两张保单的信息，在页面上去控制不能提交报案
               		       			  policyNo= relatePolicyNo;
               		       			  mainPolicyNo  =  relateMainPolicyNo ;
               		       			  qs_prpCmainDto=qs_prpCmainDtoTemp;
               		       			  intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
               		       			  dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
               		       		  }
               		       		  break;
               		       	  }
            		    	  if("Y".equals(isStoppingBusiness)){
            		    		  //程序到此时，说明是有效得关联理赔，但商业险在停驶期间，关联得交强险不在停驶期间，只能让交强险报案
            		    		  policyNo = relateMainPolicyNo;
            		    		  qs_prpCmainDto=qs_prpCmainDtoTemp;
              		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
                 		    	  dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
            		    		  break;
            		    	  }
      		    			  policyNo= relatePolicyNo;
          		    	      mainPolicyNo  =  relateMainPolicyNo ;
          		    	      qsFlag ="Y";
          		    	      qs_prpCmainDto=qs_prpCmainDtoTemp;
          		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
             		    	      dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
      		    			  break;
      		    		  }
      		    		  if(!sy_valid){
      		    			qsFlag ="OutInsureDate";	//出险时间不在保险期间内
      		    			break;
      		    		  }
      		    		  if(  !("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
      		    			|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))){
      		    			  	qsFlag ="NotCheckin";  //关联的保单未交费
      		    			  	break;
      		    		  }
      		    		  
      		    	  }
      		    	  
      		    	  
      		     }else {  //以强三保单查询
      		    	  policySubDto = endorseViewHelper.findForEndorBefore(relatePolicyNo,damageDate, damageHour);    		    	 
      		    	  
      		    	 if ( policySubDto !=null) {
      		    		// qs_prpCmainDtoTemp= policySubDto.getPrpCmainDto();
      		    		 qs_prpCmainDtoTemp = policyDto.getPrpCmainDto();
      		    		 qs_valid = dAARegistViewHelper.checkDate(httpServletRequest,relateMainPolicyNo, damageDate, Integer.parseInt(damageHour),Integer.parseInt(damageMinute) );
      		    		 sy_valid = dAARegistViewHelper.checkDate(httpServletRequest,relatePolicyNo, damageDate, Integer.parseInt(damageHour) ,Integer.parseInt(damageMinute));
      		    		PolicyDto mainPolicyDto = uiPolicyAction.findByPrimaryKey(relatePolicyNo);
      		    	    if (   mainPolicyDto != null 
          		    		&& qs_valid && sy_valid 
          		    		&& ("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
          		    		|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))
          		    	  ) {  //查询到关联的有效商业保单,有效保单＝出险时间在保险期间内＋已缴费
      		    	    	isValidRelatedFlag = "Y";
      		    	      //商业险是否在停驶期间内
        		    		 if(dAARegistViewHelper.checkIsStopping(relatePolicyNo, damageDate,damageHour)){
           		       		  isStoppingBusiness = "Y";
           		       		  if("Y".equals(isStoppingCI)){
           		       			  //程序到此时，说明关联的两张保单均在停驶期间，此时显示两张保单的信息，在页面上去控制不能提交报案
           		       			  policyNo= relatePolicyNo;
           		       			  mainPolicyNo  =  relateMainPolicyNo ;
           		       			  qs_prpCmainDto=qs_prpCmainDtoTemp;
           		       			  intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
           		       			  dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
           		       		  }
           		       		  break;
           		       	  }
        		    	  if("Y".equals(isStoppingCI)){
           		    		  //程序到此时，说明是有效得关联理赔，但交强险在停驶期间，关联得商业险不在停驶期间，只能让商业险报案
           		    		  policyNo = relatePolicyNo;
           		    		  qs_prpCmainDto=qs_prpCmainDtoTemp;
        		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
           		    	      dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ;
           		    		  break;
           		    	  }
      		    	      policyNo= relatePolicyNo;
      		    	      mainPolicyNo  =  relateMainPolicyNo ;
      		    	      qsFlag ="Y";
      		    	      qs_prpCmainDto=qs_prpCmainDtoTemp;
      		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
         		    	      dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ;
         		    	  
         		    	      break;
         		    	      
      		    	    }
      		    	   if(!sy_valid){
    		    			qsFlag ="OutInsureDate";	//出险时间不在保险期间内
    		    			break;
    		    		  }
    		    	   if(  !("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
    		    			|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))){
    		    			  	qsFlag ="NotCheckin";  //关联的保单未交费
    		    			  	break;
    		    		  }
    		    	   
      		    	 }
      		     }
      		  }//end flag 
      		  }
      		 }//end for 
      	 }  //end fi
      	if("Y".equals(isStoppingCI) || "Y".equals(isStoppingBusiness)){
     		 qsFlag = "inStopping";
     	 }
      	if("Y".equals(isStoppingCI) && "Y".equals(isStoppingBusiness)){
      		qsFlag = "Y";
      	}
      	 httpServletRequest.setAttribute("isValidRelatedFlag", isValidRelatedFlag);
      	 httpServletRequest.setAttribute("isStoppingCI", isStoppingCI);
      	 httpServletRequest.setAttribute("isStoppingBusiness", isStoppingBusiness);
       	 httpServletRequest.setAttribute("quaryPolicyNo", quaryPolicyNo);
      	 httpServletRequest.setAttribute("intPayFee", String.valueOf(intPayFee));
      	 httpServletRequest.setAttribute("qs_prpCmainDto", qs_prpCmainDto );
      	 if(!"".equals(mainPolicyNo) && !"".equals(relatePolicyNo)){
	      	 if(quaryPolicyNo.substring(1,5).equals("0506") || quaryPolicyNo.substring(1,5).equals("0586")||quaryPolicyNo.substring(1,5).equals("0576")){
	      		httpServletRequest.setAttribute("mainPolicyNo", mainPolicyNo);
	      	 }else{
	      		httpServletRequest.setAttribute("mainPolicyNo", relatePolicyNo);
	      	 }
      	 }else{
      		httpServletRequest.setAttribute("mainPolicyNo", mainPolicyNo);
      	 }
      	 httpServletRequest.setAttribute("qsFlag", qsFlag);
      	 //即时生效的保单通过prpcitemcarExt中保险期限来判断
      	 String immediateValidPeriod = "";
      	 if("05".equals(policyDto.getPrpCmainDto().getClassCode())){
      	   DBPrpCitemCarExt dbPrpCitemCarExt = new DBPrpCitemCarExt();
      	   dbPrpCitemCarExt.getInfo(policyNo);
      	   //即时生效的保单，保险期限用prpcitemCarExt中的保险期限进行判断      	   
      	   if("1".equals(dbPrpCitemCarExt.getImmediateValidFlag())){
      		   String strWhere = " policyno='" + policyNo + "' And to_date('" + damageDate + " " + damageHour + 
      		        ":" + damageMinute + ":00','yyyy-MM-dd HH24:MI:SS') " +
      		   		"  Between startdate And enddate";
      		   if(dbPrpCitemCarExt.getCount(strWhere) > 0){
      			   immediateValidPeriod = "Y";	//Y-表示在即时生效的保险期限内，N反之
      		   }else{
      			   immediateValidPeriod = "N"; 
      		   }
      	   }
      	 }
      	httpServletRequest.setAttribute("immediateValidPeriod", immediateValidPeriod); 
//      	add by zhaolu start at 2006-06-09
 		//reason 强制保单关联信息写到报案中      	 
      	PrpLRegistRPolicyDto prpLRegistRPolicyDtoOfCompel=null; 
      	 if ("Y".equals(qsFlag)){
      	 	prpLRegistRPolicyDtoOfCompel=new PrpLRegistRPolicyDto(); 
      	 	prpLRegistRPolicyDtoOfCompel.setPolicyNo(mainPolicyNo);  
      	 	prpLRegistRPolicyDtoOfCompel.setRiskCode(compelRiskCode ); //先暂时写定。。以后修改
 		 }
 		httpServletRequest.setAttribute("prpLregistRPolicyNo", prpLRegistRPolicyDtoOfCompel); 
 		
 		//刷新报案页面
 		if(flashPage != null && flashPage.equals("Y")){ 
 	 	    
 			// 查询出现时保单信息 			
 			PolicyDto DamagePolicyDto = endorseViewHelper.findForEndorBefore(quaryPolicyNo,
 					damageDate, damageHour);
 			httpServletRequest.setAttribute("prpCmainDto", DamagePolicyDto.getPrpCmainDto());
 			forward = "DAARegistFlashPage";
 			return actionMapping.findForward(forward);
 		}
 		//add by zhaolu end at 2006-06-09
          	//add by lym 20060604 for 强三 -----end>>>>>
 		//add by miaowenjun 20060925 农险走自己的viewhelper
 		AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
 		
 		if("I".equals(riskType)||"H".equals(riskType)){
 			agriRegistViewHelper.policyDtoToView(httpServletRequest, policyNo, damageDate, damageHour);
 		}else{
 			dAARegistViewHelper.policyDtoToView(httpServletRequest,quaryPolicyNo,damageDate,damageHour);
 		}
        policyNo = policyNo.trim() ;
        
        //add by wunier 20071228
        //reason：增加与赔付数量对应的单位信息
        riskCode = policyNo.substring(1,5);
        String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
        UICodeAction uiCodeAction = new UICodeAction();
        Collection collection = uiCodeAction.findByConditions(conditions);
        httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
        //end by wunier 20071228
        
        
        //2012-12-17能否直接调度   权限校验   start
		PrpDuserDto platformPrpDuserDto = new PrpDuserDto();
		platformPrpDuserDto.setUserCode(user.getUserCode());
		platformPrpDuserDto.setLoginComCode(user.getComCode());
		String checkPower = "false" ; //是否通过校验
		if("Y".equals(riskType)||"Q".equals(riskType)||"I".equals(riskType)|| "Z".equals(riskType)){
			checkPower = String.valueOf(UIPowerAction.checkPowerReturn(platformPrpDuserDto, "claim.schedule"));
		}
		
		httpServletRequest.setAttribute("checkPower", checkPower);
        //2012-12-17能否直接调度   权限校验   end
      }
      //2。查询保单信息,整理输入，用于初始界面显示
      if(editType.equals("EDIT")||editType.equals("SHOW")||editType.equals("DELETE")||editType.equals("TimeOut"))
      {
    	  AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
//      ------------------------------------
    	PrpLRegistRPolicyDto  prpLRegistRPolicyDto=new PrpLRegistRPolicyDto();
        UIPrpLregistRPolicyAction  uiPrpLrgistRPolicyAction =new UIPrpLregistRPolicyAction();
        Collection collection=   uiPrpLrgistRPolicyAction.findByConditions(" registno= '" + registNo+"'");
        if (collection !=null &&collection.size()>1){
        	   qsFlag ="Y";
        	   Iterator it= collection.iterator();
        	   while ( it.hasNext()){
        	    prpLRegistRPolicyDto=(PrpLRegistRPolicyDto) it.next();
        		if( prpLRegistRPolicyDto.getRegistFlag().equals("0")){
        			mainPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
           	       	policyNo = mainPolicyNo;
        			UIPolicyAction  uiPolicyAction = new UIPolicyAction();
        	       	PolicyDto  policyDto  =  uiPolicyAction.findByPrimaryKey(mainPolicyNo);
        	       	qs_prpCmainDto = policyDto.getPrpCmainDto();
        	        intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
        	        //dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ;
        	        
        		}
        		if ( prpLRegistRPolicyDto.getRegistFlag().equals("1")){
        			quaryPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
        			
        		}
        		
        	}
        	
        }else if (collection !=null && collection.size()==1){
         	 Iterator it= collection.iterator();
      	   while ( it.hasNext()){
      	    prpLRegistRPolicyDto=(PrpLRegistRPolicyDto) it.next();
        	quaryPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
        	policyNo = prpLRegistRPolicyDto.getPolicyNo();
      	   }
        }else {
        	//历史数据？
        }
         //
         httpServletRequest.setAttribute("quaryPolicyNo", quaryPolicyNo);
     	 httpServletRequest.setAttribute("intPayFee", String.valueOf(intPayFee));
     	 httpServletRequest.setAttribute("qs_prpCmainDto", qs_prpCmainDto );
     	 httpServletRequest.setAttribute("mainPolicyNo", mainPolicyNo);
     	 httpServletRequest.setAttribute("qsFlag", qsFlag);
        
//   	add by zhaolu start at 2006-06-09
  		//reason 强制保单关联信息写到报案中
       	PrpLRegistRPolicyDto prpLRegistRPolicyDtoOfCompel=null; 
       	 if ("Y".equals(qsFlag)){
       	 	prpLRegistRPolicyDtoOfCompel=new PrpLRegistRPolicyDto(); 
       	 	prpLRegistRPolicyDtoOfCompel.setPolicyNo(mainPolicyNo);  
       	 	prpLRegistRPolicyDtoOfCompel.setRiskCode(compelRiskCode); //先暂时写定。。以后修改
  		 }
  		httpServletRequest.setAttribute("prpLregistRPolicyNo", prpLRegistRPolicyDtoOfCompel);
  		//modify by miaowenjun 20060928 农险走自己的viewhelper
  		if("I".equals(riskType)||"H".equals(riskType)){
  			agriRegistViewHelper.setRegistDtoView(httpServletRequest, registNo);
  		}
  		else{
            dAARegistViewHelper.setRegistDtoView(httpServletRequest,registNo);
  		}
        registNo = registNo.trim() ;
        riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        //add by wunier 20071228
        //reason：增加与赔付数量对应的单位信息
        String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
        UICodeAction uiCodeAction = new UICodeAction();
        Collection collection1 = uiCodeAction.findByConditions(conditions);
        httpServletRequest.setAttribute("lossesUnitCodeCollection",collection1);
        //end by wunier 20071228
        
      }
     
      if (registNo != null && (!"".equals(registNo))) {
				riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
			}
      //检查是否有批改
      UIEndorseAction uiEndorseAction = new UIEndorseAction();
       int checkFlag =0;
       checkFlag = uiEndorseAction.checkStatus(policyNo);
       httpServletRequest.setAttribute("checkFlag", checkFlag+"");
       
    
      //取得forward
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"regis",editType,1);
      httpServletRequest.setAttribute("com.sinosoft.forward", forward);
     
      saveToken(httpServletRequest);
      
      
      //start分入标志
      String businessFlag = "0";
      BLPrpCmainFacade  blPrpCmainFacade = new BLPrpCmainFacade();
      com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtoTem = blPrpCmainFacade.findByPrimaryKey(policyNo);
      if(prpCmainDtoTem!=null){
    	  businessFlag = prpCmainDtoTem.getBusinessFlag();
      }
	  httpServletRequest.setAttribute("businessFlag", businessFlag);
      //end分入标志
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
      //throw usee;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {
    }
    return actionMapping.findForward(forward);
  }
}
