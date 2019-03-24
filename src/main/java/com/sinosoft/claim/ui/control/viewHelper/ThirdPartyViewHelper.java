
package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;

/**
 * <p>Title: ThirdPartyViewHelper</p>
 * <p>Description:新增定损调度ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2005</p>
 * @author 车险理赔项目组 wangli
 * @version 1.0
 * <br>
 */
public class ThirdPartyViewHelper  {
	
	
	public ThirdPartyViewHelper(){
		
	}

	
	/**
	    * 保存查勘时查勘页面数据整理.
	    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	    * @param httpServletRequest
	    * @return checkDto 查勘数据传输数据结构
	    * @throws Exception
	    */
	  
	    public CheckDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
	    {
	    	//add by liyanjie 2005-12-17 start 判断双代案件,新增的定损任务分给出险地(被委托方)
	    	String commiFlag = "";//httpServletRequest.getParameter("commiFlag");
	    	System.out.println("----- 新增定损调度保存 ==双代标志:"+commiFlag);
	    	UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
	    	//add by liyanjie 2005-12-17 end
	    	
	    	
	      //继承对check,checkText表的赋值
	       CheckDto checkDto = new CheckDto();
	    	//CheckDto checkDto = super.viewToDto(httpServletRequest);
		    int intCheckLossIndex = 1;//序号
		    ArrayList prpLcheckLossDtoList = null;
		    boolean newScheduleItem=false;
		    
		  httpServletRequest.setAttribute("prpLnodeType","check");
		  String prplregistDamageAddress =httpServletRequest.getParameter("prplregistDamageAddress");
		    
	      ArrayList thirdPartyDtoList = new ArrayList();
	      PrpLthirdPartyDto prpLthirdPartyDto = null ;
	      //从界面得到输入数组
	      String   prpLthirdPartyClaimNo          = httpServletRequest.getParameter("prpLcheckClaimNo");
	      String   prpLthirdPartyRiskCode         = httpServletRequest.getParameter("prpLcheckRiskCode");
	     // String   prpLthirdPartyRiskCode = "DAA";
	      String   prpLthirdPartyRegistNo          = (String)httpServletRequest.getParameter("businessNo");
	      String   prpLcheckLossPolicyNo  = httpServletRequest.getParameter("policyNo");
	      //注意此处保存到checkDto里
	      PrpLcheckDto prpLcheckDto1 = new PrpLcheckDto();
	      prpLcheckDto1.setRegistNo(prpLthirdPartyRegistNo);
	      checkDto.setPrpLcheckDto(prpLcheckDto1);
	      
	        //先取立案号码，很重要，不要从页面上取得。。。
        String claimNo=prpLthirdPartyClaimNo;
        String registNo  = prpLthirdPartyRegistNo;
  
        //add by lixiang start 20051010
     	  //reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
      	if (claimNo==null||claimNo.length()<2){
      	  UICodeAction uiCodeAction = new UICodeAction();
          claimNo=uiCodeAction.translateBusinessCode(registNo,true);
      	}
        //add by lixiang end 20051010
      
	      ////System.out.println("********王立的测试  王立的测试 2222 ************prpLthirdPartyRegistNo is :"+prpLthirdPartyRegistNo);
	      
	  String   prpLthirdPartyClauseType       = httpServletRequest.getParameter      ("prpLcheckClauseType"        );
	  String[] prpLthirdPartySerialNo         = httpServletRequest.getParameterValues("prpLthirdPartySerialNo"          );
	  String[] prpLthirdPartyLicenseNo        = httpServletRequest.getParameterValues("prpLthirdPartyLicenseNo"         );
	  String[] prpLthirdPartyLicenseColorCode = httpServletRequest.getParameterValues("licenseColorCode"  );
	  String[] prpLthirdPartyCarKindCode      = httpServletRequest.getParameterValues("carKindCode"       );
	  String[] prpLthirdPartyInsureCarFlag    = httpServletRequest.getParameterValues("insureCarFlag"     );
	  String[] prpLthirdPartyCarOwner         = httpServletRequest.getParameterValues("prpLthirdPartyCarOwner"          );
	  String[] prpLthirdPartyEngineNo         = httpServletRequest.getParameterValues("prpLthirdPartyEngineNo"          );
	  String[] prpLthirdPartyFrameNo          = httpServletRequest.getParameterValues("prpLthirdPartyFrameNo"           );
	  String[] prpLthirdPartyModelCode        = httpServletRequest.getParameterValues("prpLthirdPartyModelCode"         );
	  String[] prpLthirdPartyBrandName        = httpServletRequest.getParameterValues("prpLthirdPartyBrandName"         );
	  String[] prpLthirdPartyRunDistance      = httpServletRequest.getParameterValues("prpLthirdPartyRunDistance"       );
	  String[] prpLthirdPartyUseYears         = httpServletRequest.getParameterValues("prpLthirdPartyUseYears"          );
	  String[] prpLthirdPartyDutyPercent      = httpServletRequest.getParameterValues("prpLthirdPartyDutyPercent"       );
	  String[] prpLthirdPartyInsuredFlag      = httpServletRequest.getParameterValues("insuredFlag"       );
	  String[] prpLthirdPartyInsureComCode    = httpServletRequest.getParameterValues("prpLthirdPartyInsureComCode"     );
	  String[] prpLthirdPartyInsureComName    = httpServletRequest.getParameterValues("prpLthirdPartyInsureComName"     );
	  String[] prpLthirdPartyFlag             = httpServletRequest.getParameterValues("prpLthirdPartyFlag"              );
	  String[] prpLthirdPartyVINNo            = httpServletRequest.getParameterValues("prpLthirdPartyVINNo"    );
	   //得到隐藏的标志：为new 需要保存到库中 其它为不需要
	  String[] prpLthirdPartyNewAddFlag       = httpServletRequest.getParameterValues("prpLthirdPartyNewAddFlag"        );
      
	  //调度标底用的
	  ArrayList scheduleItemDtoList= new ArrayList();
	  PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
	  //对象赋值
	  if (prpLthirdPartySerialNo==null)
	  {
	  }else
	  {
	    //三者车辆部分开始
	    for(int index=1;index<prpLthirdPartySerialNo.length;index++)
	    {
	      //只增加新添的 以前的不增加 在此处判断
	      //if(prpLthirdPartyNewAddFlag[index].equals("new")){
	      	prpLthirdPartyDto = new PrpLthirdPartyDto();
	        prpLthirdPartyDto.setRegistNo          (prpLthirdPartyRegistNo               );
	        prpLthirdPartyDto.setRiskCode          (prpLthirdPartyRiskCode               );
	        prpLthirdPartyDto.setSerialNo          (Integer.parseInt(DataUtils.nullToZero(prpLthirdPartySerialNo[index])));
	        prpLthirdPartyDto.setClaimNo           (claimNo                );
	        prpLthirdPartyDto.setClauseType        (prpLthirdPartyClauseType             );
	        prpLthirdPartyDto.setLicenseNo         (prpLthirdPartyLicenseNo       [index].trim());
	        if(prpLthirdPartyLicenseColorCode!=null){
	        prpLthirdPartyDto.setLicenseColorCode  (prpLthirdPartyLicenseColorCode[index]);
	        }
	        if(prpLthirdPartyCarKindCode!=null){
	        prpLthirdPartyDto.setCarKindCode       (prpLthirdPartyCarKindCode     [index]);
	        }
	        prpLthirdPartyDto.setInsureCarFlag     (prpLthirdPartyInsureCarFlag   [index]);
	        prpLthirdPartyDto.setEngineNo          (prpLthirdPartyEngineNo        [index]);
	        prpLthirdPartyDto.setFrameNo           (prpLthirdPartyFrameNo         [index]);
	        prpLthirdPartyDto.setBrandName         (prpLthirdPartyBrandName       [index]);
	        prpLthirdPartyDto.setRunDistance       (Double.parseDouble(DataUtils.nullToZero(prpLthirdPartyRunDistance[index])));
	        prpLthirdPartyDto.setUseYears          (Integer.parseInt(DataUtils.nullToZero(prpLthirdPartyUseYears[index])));
	        prpLthirdPartyDto.setDutyPercent       (Double.parseDouble(DataUtils.nullToZero(prpLthirdPartyDutyPercent[index])));
	        prpLthirdPartyDto.setInsuredFlag       (prpLthirdPartyInsuredFlag     [index]);
	        prpLthirdPartyDto.setInsureComCode     (prpLthirdPartyInsureComCode   [index]);
	        prpLthirdPartyDto.setInsureComName     (prpLthirdPartyInsureComName   [index]);
	        prpLthirdPartyDto.setVINNo     (prpLthirdPartyVINNo   [index]);
	        
	        //加入集合
	        thirdPartyDtoList.add(prpLthirdPartyDto);
	        
	      
	        //整理调度情况
	        prpLscheduleItemDto = new PrpLscheduleItemDto();
	        prpLscheduleItemDto.setScheduleID         (1);
	        prpLscheduleItemDto.setRegistNo           (prpLthirdPartyRegistNo);
	        prpLscheduleItemDto.setItemNo             (prpLthirdPartyDto.getSerialNo());
	        prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyDto.getInsureCarFlag() );
	        
	        //modify by liyanjie 2005-12-17 start 如果是双代案件,出险方新增定损调度,新增的定损任务给出险地;
	        System.out.println("------ 增加定损 scheduleitem--- "+prpLthirdPartyDto.getLicenseNo());
	        System.out.println("------ 增加定损 ---commiFlag:"+commiFlag);
	       // if( (!(commiFlag == null )) && "1".equals(commiFlag)){
	      //  	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
	       // 	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
	       // }else{
	       // 	prpLscheduleItemDto.setClaimComCode       (user.getScheduleComCode()  );
	       // }
	        prpLscheduleItemDto.setClaimComCode(user.getComCode() );
	        System.out.println("------ 增加定损 ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
	        
	        //modify by liyanjie 2005-12-17 end
	        //表示是否选中
	        prpLscheduleItemDto.setSelectSend         ("1");
	        //表示没有调度成定损过
	        prpLscheduleItemDto.setSurveyTimes        (0);
	        prpLscheduleItemDto.setSurveyType         ("1");
	       // prpLscheduleItemDto.setCheckSite          (checkDto.getPrpLcheckDto().getCheckSite());
	        prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyDto.getLicenseNo() );
	        prpLscheduleItemDto.setScheduleObjectID   ("_");
	        prpLscheduleItemDto.setScheduleObjectName (" ");
	        prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current() ,DateTime.YEAR_TO_DAY ));
	        prpLscheduleItemDto.setScheduleType       ("schel");
	        prpLscheduleItemDto.setCheckSite( prplregistDamageAddress);
	        if(prpLthirdPartyNewAddFlag[index].equals("new")){			//如果是新增的定损,保存 add if条件 by liyanjie
	          //加入调度标的集合
	          scheduleItemDtoList.add(prpLscheduleItemDto);
	        }
	        //设置调度的标签显示 shcheduleItemNote
	        String strTemp ="标的:";
	        if (prpLscheduleItemDto.getItemNo()!=1) strTemp ="三者:";
	        checkDto.setScheduleItemNote(checkDto.getScheduleItemNote()
	            +strTemp+prpLscheduleItemDto.getLicenseNo()+"/");

	      //}
	    }

	    //查勘集合中加入三者车辆
	    checkDto.setPrpLthirdPartyDtoList(thirdPartyDtoList);
	    //查勘集合中加入调度任务标的
	    checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
	  }
	      

        
	      //Modify by chenrenda add begin 20050408
		     //Reason:损失部位模块信息调整到涉案车辆信息中，相应模块做调整
		     //---------------------损失部位 PrpLthirdCarLoss begin------------------------------------
		     ArrayList thirdCarLossDtoList = new ArrayList();
		     PrpLthirdCarLossDto prpLthirdCarLossDto = null ;
		     //从界面得到输入数组
		     String   prpLthirdCarLossRegistNo         = (String)httpServletRequest.getParameter("businessNo");
		     String   prpLthirdCarLossRiskCode         = httpServletRequest.getParameter("prpLcheckRiskCode");
		    // String   prpLthirdCarLossRiskCode         =  "DAA";
		     String[] prpLthirdCarLossSerialNo         = httpServletRequest.getParameterValues("RelateSerialNo");
		     String[] prpLthirdCarLossItemNo         = httpServletRequest.getParameterValues("prpLthirdCarLossItemNo");
		     String[] prpLthirdCarLossLicenseNo         = httpServletRequest.getParameterValues("prpLthirdCarLossLicenseNo");
		     //Modify by chenrenda update begin 20050407
		     String[] prpLthirdCarLossPartCode        = httpServletRequest.getParameterValues("partCode"); //部件代码
		     String[] prpLthirdCarLossPartName         = httpServletRequest.getParameterValues("partName"); //部件名称
		     String[] prpLthirdCarLossCompCode         = httpServletRequest.getParameterValues("compCode");//零件代码
		     String[] prpLthirdCarLossCompName        = httpServletRequest.getParameterValues("compName");//零件名称
		     String[] prpLthirdCarLossLossGrade         = httpServletRequest.getParameterValues("prpLthirdCarLossLossGrade");
		     String[] prpLthirdCarLossLossDesc         = httpServletRequest.getParameterValues("prpLthirdCarLossLossDesc");
		     String[] prpLthirdCarLossFlag         = httpServletRequest.getParameterValues("prpLthirdCarLossFlag");

		     //对象赋值
		     //损失部位部分开始
		    if (prpLthirdCarLossSerialNo==null)
		     {}
		     else
		     {
		       for(int index2=1;index2<prpLthirdCarLossSerialNo.length;index2++)
		       {

		         prpLthirdCarLossDto = new PrpLthirdCarLossDto();
		         prpLthirdCarLossDto.setRegistNo          (prpLthirdCarLossRegistNo               );
		         prpLthirdCarLossDto.setRiskCode          (prpLthirdCarLossRiskCode               );
		         prpLthirdCarLossDto.setSerialNo          (Integer.parseInt(DataUtils.nullToZero(prpLthirdCarLossSerialNo[index2])));
		         prpLthirdCarLossDto.setItemNo            (Integer.parseInt(DataUtils.nullToZero(prpLthirdCarLossItemNo [index2])));
		         prpLthirdCarLossDto.setLicenseNo         (prpLthirdCarLossLicenseNo       [index2]);
		         prpLthirdCarLossDto.setCompCode          (prpLthirdCarLossCompCode       [index2]);
		         prpLthirdCarLossDto.setCompName          (prpLthirdCarLossCompName       [index2]);
		         prpLthirdCarLossDto.setLossGrade         (prpLthirdCarLossLossGrade       [index2]);
		         prpLthirdCarLossDto.setLossDesc          (prpLthirdCarLossLossDesc       [index2]);
		         prpLthirdCarLossDto.setFlag              (prpLthirdCarLossFlag           [index2]);
		         prpLthirdCarLossDto.setPartCode          (prpLthirdCarLossPartCode       [index2]);
		         prpLthirdCarLossDto.setPartName          (prpLthirdCarLossPartName       [index2]);

		         //加入集合
		         thirdCarLossDtoList.add(prpLthirdCarLossDto);
		       }
		       //查勘集合中加入损失部位
		       checkDto.setPrpLthirdCarLossDtoList(thirdCarLossDtoList);
		     }
		    //Modify by chenrenda add begin 20050407

		    //Reason:页面中增加其它损失模块
		    /*---------------------其它损失部位 PrpLthirdProp begin------------------------------------*/
		    ArrayList thirdPropDtoList = new ArrayList();
		    PrpLthirdPropDto prpLthirdPropDto = null ;

		    //从界面得到输入数组
		  //  String   prpLthirdPropRegistNo         = (String)httpServletRequest.getAttribute("businessNo");
		   // String   prpLthirdPropRiskCode         = httpServletRequest.getParameter      ("prpLcheckRiskCode");
		    String[] prpLthirdPropItemNo           = httpServletRequest.getParameterValues("prpLthirdPropItemNo");
		    String[] prpLthirdPropLicenseNo        = httpServletRequest.getParameterValues("prpLthirdPropLicenseNo");
		    String[] lossItemCode        = httpServletRequest.getParameterValues("prpLthirdLossItemCode");
		    String[] LossItemName         = httpServletRequest.getParameterValues("prpLthirdLossItemName");
		    String[] prpLthirdPropLossDesc         = httpServletRequest.getParameterValues("prpLthirdPropLossDesc");
		    String[] prpLthirdPropFlag         = httpServletRequest.getParameterValues("prpLthirdPropFlag");
		    
		    //Modify by chenrenda add begin 20050418
		    //Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		    String[] prpLthirdPropKindCode    = httpServletRequest.getParameterValues("prpLthirdPropKindCode"     );
		    String[] prpLthirdPropLossFee             = httpServletRequest.getParameterValues("prpLthirdPropLossFee"              );
		    //Modify by chenrenda add end 20050418
		    
		    //对象赋值
		    //损失部位部分开始
		    if (prpLthirdPropItemNo==null)
		    {}
		    else
		    { prpLcheckLossDtoList = new ArrayList();
		      for(int index=1;index<prpLthirdPropItemNo.length;index++)
		      {

		        prpLthirdPropDto = new PrpLthirdPropDto();
		        
		        //Modify by chenrenda update begin 20050418
		        //Reason:预估损失模块合到涉案车辆信息中
		        PrpLcheckLossDto   prpLcheckLossDto  = new PrpLcheckLossDto();
		        prpLcheckLossDto.setRegistNo(prpLthirdPartyRegistNo);
		        prpLcheckLossDto.setClaimNo(claimNo);
		        prpLcheckLossDto.setRiskCode(prpLthirdPartyRiskCode);
		        prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
		        //System.out.println("**********prpLthirdProp****:"+intCheckLossIndex);
		        prpLcheckLossDto.setSerialNo(intCheckLossIndex);
		        prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
		        
		        prpLcheckLossDto.setKindCode(prpLthirdPropKindCode[index]);
		        
		        prpLcheckLossDto.setLossFeeType("3");
		        prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(prpLthirdPropLossFee[index])));
		        prpLcheckLossDto.setFlag("");
		        intCheckLossIndex++;
		        prpLcheckLossDtoList.add(prpLcheckLossDto);
		        //Modify by chenrenda update end 20050418
		        
		        prpLthirdPropDto.setRegistNo          (prpLthirdPartyRegistNo               );
		        prpLthirdPropDto.setRiskCode          (prpLthirdPartyRiskCode               );
		        prpLthirdPropDto.setSerialNo           (Integer.parseInt(DataUtils.nullToZero(prpLthirdPropItemNo      [index])));
		        prpLthirdPropDto.setLicenseNo         (prpLthirdPropLicenseNo       [index]);
		        prpLthirdPropDto.setLossItemCode          (lossItemCode       [index]);
		        prpLthirdPropDto.setLossItemName        (LossItemName       [index]);
		        prpLthirdPropDto.setLossItemDesc          (prpLthirdPropLossDesc       [index]);
		        //prpLthirdPropDto.setlo          (prpLthirdPropLossDesc       [index]);
			       
		        prpLthirdPropDto.setFlag              (prpLthirdPropFlag           [index]);

		        //加入集合
		        thirdPropDtoList.add(prpLthirdPropDto);
		      }

		      
		      //报案集合中加入三者损失
		      checkDto.setPrpLthirdPropDtoList(thirdPropDtoList);
		      checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList);
		      
		      //增加人伤定损调度信息，如果有人，就进行调度

		         if (thirdPropDtoList!=null&&thirdPropDtoList.size() >0){
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(-1);
		         //表示是否选中
		         prpLscheduleItemDto.setSelectSend("1");
		         //表示没有调度成定损过
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("财产损失");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         
		         //modify by liyanjie 2005-12-17 start 如果是双代案件,出险方新增定损调度,新增的定损任务给出险地;
		         
		            System.out.println("------ 增加定损 scheduleitem---财产损失 ");
			        System.out.println("------ 增加定损 ---commiFlag:"+commiFlag);
			        //if( (!(commiFlag == null )) && "1".equals(commiFlag)){
			        //	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			        //	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
			        //}else{
			        //	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			       // }
			        //System.out.println("------ 增加定损 ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
		         prpLscheduleItemDto.setClaimComCode(user.getComCode() );
			     //modify by liyanjie 2005-12-17 end
		         
		         scheduleItemDtoList.add(prpLscheduleItemDto);

		         
		      //显示标的
		         checkDto.setScheduleItemNote(checkDto.getScheduleItemNote()
		                + prpLscheduleItemDto.getLicenseNo() + "/");
		         }
		       
		    }
		    
	       
		    /*---------------------人员伤亡跟踪 PrpLpersonTrace --------begin----------------------------*/
		    
		    
		      ArrayList personTraceDtoList = new ArrayList();
		      PrpLpersonTraceDto prpLpersonTraceDto = null ;
		      //从界面得到输入数组
		  //   String   prpLpersonTraceRegistNo         =(String)httpServletRequest.getAttribute("businessNo"                   );
		  //   String   prpLpersonTraceClaimNo          =httpServletRequest.getParameter      ("prpLcheckRiskCode"            );
		  //   String   prpLpersonTracePolicyNo         =httpServletRequest.getParameter      ("policyNo"            );
		     String[] prpLpersonTracePersonNo         =httpServletRequest.getParameterValues("prpLpersonTracePersonNo"       );
		     String[] prpLpersonTracePersonName       =httpServletRequest.getParameterValues("prpLpersonTracePersonName"     );
		     String[] prpLpersonTracePersonSex        =httpServletRequest.getParameterValues("personSex"      );
		     String[] prpLpersonTracePersonAge        =httpServletRequest.getParameterValues("prpLpersonTracePersonAge"      );
		     String[] prpLpersonTraceIdentifyNumber   =httpServletRequest.getParameterValues("prpLpersonTraceIdentifyNumber" );
		     String[] prpLpersonTraceRelatePersonNo   =httpServletRequest.getParameterValues("prpLpersonTraceRelatePersonNo" );
		     String[] prpLpersonTraceJobCode          =httpServletRequest.getParameterValues("prpLpersonTraceJobCode"        );
		     String[] prpLpersonTraceJobName          =httpServletRequest.getParameterValues("prpLpersonTraceJobName"        );
		     String[] prpLpersonTraceReferKind        =httpServletRequest.getParameterValues("prpLpersonTraceReferKind"      );
		     String[] prpLpersonTracePartDesc         =httpServletRequest.getParameterValues("prpLpersonTracePartDesc"       );
		     String[] prpLpersonTraceHospital         =httpServletRequest.getParameterValues("prpLpersonTraceHospital"       );
		     String[] prpLpersonTraceMotionFlag       =httpServletRequest.getParameterValues("motionFlag"     );
		     String[] prpLpersonTraceWoundRemark      =httpServletRequest.getParameterValues("prpLpersonTraceWoundRemark"    );
		     String[] prpLpersonTraceRemark           =httpServletRequest.getParameterValues("prpLpersonTraceRemark"         );
		     String[] prpLpersonTraceFlag             =httpServletRequest.getParameterValues("prpLpersonTraceFlag"           );

		     //Modify by chenrenda add begin 20050418
		     //Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		     String[] prpLpersonTraceLossFee             = httpServletRequest.getParameterValues("prpLpersonTraceLossFee"              );
		     //Modify by chenrenda add end 20050418

		      //对象赋值
		      //人员伤亡跟踪 部分开始
		      if (prpLpersonTracePersonNo==null)
		      {}
		      else
		      {
		        //System.out.println("人员伤亡跟踪部分开始 ");
		        for(int index=1;index<prpLpersonTracePersonNo.length;index++)
		        {
		          prpLpersonTraceDto = new PrpLpersonTraceDto();
		      	          
		          prpLpersonTraceDto.setRegistNo       (prpLthirdPartyRegistNo         );
		          prpLpersonTraceDto.setClaimNo        (claimNo          );
		          prpLpersonTraceDto.setPolicyNo       (prpLcheckLossPolicyNo         );
		          prpLpersonTraceDto.setPersonNo       (Integer.parseInt(DataUtils.nullToZero(prpLpersonTracePersonNo       [index] )) );
		          prpLpersonTraceDto.setPersonName     (prpLpersonTracePersonName     [index]  );
		          prpLpersonTraceDto.setPersonSex      (prpLpersonTracePersonSex      [index]  );
		          prpLpersonTraceDto.setPersonAge      (Integer.parseInt(DataUtils.nullToZero(prpLpersonTracePersonAge      [index]))  );
		          prpLpersonTraceDto.setIdentifyNumber (prpLpersonTraceIdentifyNumber [index]  );
		          prpLpersonTraceDto.setRelatePersonNo (Integer.parseInt(DataUtils.nullToZero(prpLpersonTraceRelatePersonNo [index]) ) );
		          prpLpersonTraceDto.setJobCode        (prpLpersonTraceJobCode        [index]  );
		          prpLpersonTraceDto.setJobName        (prpLpersonTraceJobName        [index]  );
		      //    prpLpersonTraceDto.setReferKind      (prpLpersonTraceReferKind      [index]  );
		          prpLpersonTraceDto.setPartDesc       (prpLpersonTracePartDesc       [index]  );
		          prpLpersonTraceDto.setHospital       (prpLpersonTraceHospital       [index]  );
		          prpLpersonTraceDto.setMotionFlag     (prpLpersonTraceMotionFlag     [index]  );
		          prpLpersonTraceDto.setWoundRemark    (prpLpersonTraceWoundRemark    [index]  );
		          prpLpersonTraceDto.setRemark         (prpLpersonTraceRemark         [index]  );
		          prpLpersonTraceDto.setFlag           (prpLpersonTraceFlag           [index]  );
		          //加入集合
		          personTraceDtoList.add(prpLpersonTraceDto);
		        }
		        //报案集合中加入损失部位
		        checkDto.setPrpLpersonTraceDtoList(personTraceDtoList);

		        //增加人伤定损调度信息，如果有人，就进行调度

		         if (personTraceDtoList!=null&&personTraceDtoList.size() >0){
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(0);
		         //表示是否选中
		         prpLscheduleItemDto.setSelectSend("1");
		         //表示没有调度成定损过
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("人伤");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         
		         // modify by liyanjie 2005-12-17 start 如果是双代案件,出险方新增定损调度,新增的定损任务给出险地;
		            System.out.println("------ 增加定损 scheduleitem---人伤 ");
			        System.out.println("------ 增加定损 ---commiFlag:"+commiFlag);
			        /*if(!(commiFlag == null) && "1".equals(commiFlag)){
			        	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			        	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
			        }else{
			        	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			        }*/
			        System.out.println("------ 增加定损 ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
			     //modify by liyanjie 2005-12-17 end
		         scheduleItemDtoList.add(prpLscheduleItemDto);
		         //显示标的
		         checkDto.setScheduleItemNote(checkDto.getScheduleItemNote()
		                + prpLscheduleItemDto.getLicenseNo() + "/");
		         
		         }
		      }

		      //整理调度用的标的信息,去掉最后的一个"/"
		        if (checkDto.getScheduleItemNote().length() >1)
		        { String strTemp=checkDto.getScheduleItemNote();
		          strTemp = strTemp.substring(0,strTemp.length()-1) ;
		          checkDto.setScheduleItemNote(strTemp );
		        }
		        
		      //整理数据，整理定损调度的数据，如果当提交的时候。。将新的数据放入prplscheduleItem中，并保留已经调度过的数据
		         //检查定损调度的情况，如果存在定损调度，检查是否已经调度过，如果没有调度过，按照没有调度过处理
		         Collection prpLscheduleItemList = new ArrayList();
		         //查询调度过的
		         String strSql =" registno ='"+checkDto.getPrpLcheckDto().getRegistNo()+"'";
		         ////System.out.println("***********王立王立王立*********policyNo************:"+checkDto.getPrpLcheckDto().getRegistNo());
		         //查询数据
		         UIScheduleAction uiScheduleAction=new UIScheduleAction();
		         prpLscheduleItemList =uiScheduleAction.findItemByConditions(strSql) ;
		         PrpLscheduleItemDto prpLscheduleItemoldDto=new PrpLscheduleItemDto();
		         ArrayList scheduleItemLastList = new ArrayList();
		         if (prpLscheduleItemList ==null || prpLscheduleItemList.size()<1){
		            //不用检查scheduleITem的。。
		            checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList) ;
		         }else
		         { //检查整理好的数据中，是否已经有已经调度过的数据

		       //      //System.out.println("prpLscheduleItemList.size()"+prpLscheduleItemList.size());
		           boolean findit=false;
		         	for (int i =0;i<scheduleItemDtoList.size() ;i++)
		           {
		             prpLscheduleItemDto = new PrpLscheduleItemDto();
		             prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(i);
		             //原则，相同的，以原来的数据为准，没有的已后来的为准
		             findit=false;
		              for (int j =0;j<prpLscheduleItemList.size() ;j++)
		             {
		               prpLscheduleItemoldDto= new PrpLscheduleItemDto();
		               prpLscheduleItemoldDto = (PrpLscheduleItemDto)((ArrayList)prpLscheduleItemList).get(j);
		               if (prpLscheduleItemDto.getItemNo()==prpLscheduleItemoldDto.getItemNo() )
		               { //如果存在旧的数据，就要用旧的数据，不要用新的数据
		                 prpLscheduleItemDto= prpLscheduleItemoldDto;
		                 findit=true;
		                 break;
		               }
		               //原则，相同的，以原来的数据为准，没有的已后来的为准
		              
			             
		             }
		             
		              //有新增的标的
		             if (findit==false)newScheduleItem=true;
		              
		             scheduleItemLastList.add(prpLscheduleItemDto) ;
		           }
		          checkDto.setPrpLscheduleItemDtoList(scheduleItemLastList) ;
		         }
		
		          checkDto.setNewScheduleItem( newScheduleItem);
	    
	     //Modify by chenrenda add end 20050408
	      return checkDto;
	    }
	

	
	    /**
	     * 填写查勘页面及查询查勘request的生成.
	     * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	     * @param httpServletRequest 返回给页面的request
	     * @param proposalIniDto 取出的初始化信息Dto
	     * @throws Exception
	     */
	    public void registDtoToView(HttpServletRequest httpServletRequest,
	                                          String registNo,String editType) throws Exception
	    {
	      //取得当前用户信息，写操作员信息到查勘中
	      HttpSession session = httpServletRequest.getSession();
	      UserDto   user     = (UserDto)session.getAttribute("user");
	      UIRegistAction uiRegistAction = new UIRegistAction();
	      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
	      UICheckAction uiCheckAction = new UICheckAction();
	      	
	      CheckDto checkDtoTemp = uiCheckAction.findByPrimaryKey(registNo);
	   //   UICheckAction uiCheckAction = new UICheckAction();
	   //   UICodeAction uiCodeAction = new UICodeAction();
	    //  String claimNo=uiCodeAction.translateBusinessCode(registNo,true);
	       String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
	       String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
	      String insureCarFlag=httpServletRequest.getParameter("insureCarFlag"); //是否为本保单车辆
	      String lossItemCode=httpServletRequest.getParameter("lossItemCode");   //损失标的
	      String lossItemName=httpServletRequest.getParameter("lossItemName");   //车牌名称
	      
	      

	   //如果有数值的话，重新给界面复制

	      //根据查询出来的数据内容，给PrpLcheckDto赋值
	      PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
	      //设置数值
	      //prpLcheckDto.setInsureCarFlag(insureCarFlag);
	      prpLcheckDto.setReferSerialNo(1);
	      //prpLcheckDto.setLossItemCode(lossItemCode);
	      //prpLcheckDto.setLossItemName(lossItemName);
	      prpLcheckDto.setRegistNo(registNo);
	      prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto() .getDamageStartDate());
	      prpLcheckDto.setDamageStartHour(registDto.getPrpLregistDto() .getDamageStartHour());
		  prpLcheckDto.setRiskCode(registDto.getPrpLregistDto() .getRiskCode()  );   
	      //设置窗体表单中各个多选框中列表信息的内容
	      setSelectionList(httpServletRequest,prpLcheckDto);

	      //设置各个子表信息项到窗体表单
	      CheckDto checkDto = new CheckDto();
	      checkDto.setPrpLcheckLossDtoList(checkDtoTemp.getPrpLcheckLossDtoList() );
	      checkDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
	      checkDto.setPrpLthirdCarLossDtoList(registDto.getPrpLthirdCarLossDtoList());
 checkDto.setPrpLpersonTraceDtoList(checkDtoTemp.getPrpLpersonTraceDtoList());
	      checkDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
	      checkDto.setPrpLcheckDto( prpLcheckDto);
	      
	      
	      //设置各个子表中的信息和显示
	      setSubInfo(httpServletRequest,checkDto);      
	      //保存报案号到页面
	      httpServletRequest.setAttribute("businessNo",registNo);
	      httpServletRequest.setAttribute("prpLregistDto",registDto.getPrpLregistDto() );
	    }
	    
	

	 /**
     * 根据PrpCheckDto中的各子表内的信息填充界面
     * @param httpServletRequest 返回给页面的request
     * @param checkDto    查勘的数据类
     * @throws Exception
     */
   private void setSubInfo(HttpServletRequest httpServletRequest,
                          CheckDto checkDto) throws Exception
   {

       //[涉案车辆]给三者车辆多行列表准备数据
       Collection arrayList = new ArrayList();
       PrpLthirdPartyDto prpLthirdPartyDto  = new PrpLthirdPartyDto();
       arrayList = checkDto.getPrpLthirdPartyDtoList();
       prpLthirdPartyDto.setThirdPartyList(arrayList) ;
       prpLthirdPartyDto.setNodeType("check");
       httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);



      //Modify by chenrenda add begin 20050408
      //Reason:损失部位模块合到涉到车辆信息中后，其它相应模块做调整
      //给损失部位多行多行列表准备数据

      Collection arrayListThirdCarLoss = new ArrayList();
      PrpLthirdCarLossDto prpLthirdCarLossDto  = new PrpLthirdCarLossDto();
      arrayListThirdCarLoss = checkDto.getPrpLthirdCarLossDtoList();
      prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss) ;
      httpServletRequest.setAttribute("prpLthirdCarLossDto", prpLthirdCarLossDto);

      //Reason:损失部位显示改为列表框方式
      httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
      //Modify by chenrenda add end 20050408
      
      
      //事故估损金额多行列表准备数据
      ArrayList arrayList2 = new ArrayList();
      PrpLcheckLossDto prpLcheckLossDto  = new PrpLcheckLossDto();
      arrayList2 = checkDto.getPrpLcheckLossDtoList() ;
      if(arrayList2 != null){
        for(int indexCheck = 0;indexCheck<arrayList2.size();indexCheck++){
          PrpLcheckLossDto prpLcheckLossDto1 = new PrpLcheckLossDto();
          prpLcheckLossDto1 = (PrpLcheckLossDto)arrayList2.get(indexCheck);

         UICodeAction uiCodeAction = new UICodeAction();
         //对险别进行转换
         String  kindCode = prpLcheckLossDto1.getKindCode();
         String  kindName = uiCodeAction.translateKindCode(checkDto.getPrpLcheckDto().getRiskCode()  ,kindCode,true) ;
         prpLcheckLossDto1.setKindName(kindName);
        }
      }
      prpLcheckLossDto.setPrpLcheckLossList(arrayList2) ;
      httpServletRequest.setAttribute("prpLcheckLossDto", prpLcheckLossDto);
    //    Modify by chenrenda 20050409 end

      
      //给人员伤亡跟踪多行多行列表准备数据
      Collection arrayListPersonTrace = new ArrayList();
      PrpLpersonTraceDto prpLpersonTraceDto  = new PrpLpersonTraceDto();
      arrayListPersonTrace = checkDto.getPrpLpersonTraceDtoList();
      prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace) ;
     // prpLpersonTraceDto.setNodeType("check");
      //Modify by chenrenda 20050409 begin
      
      if(checkDto.getPrpLpersonTraceDtoList() != null){
      	
      	//System.out.println("人伤跟踪不为空："+arrayListPersonTrace.size());
       Iterator personTraceDtoList = arrayListPersonTrace.iterator();
       while(personTraceDtoList.hasNext()){
         PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto)personTraceDtoList.next();
         String strReferKind = prplpersonTraceDto.getReferKind();
         prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);
       }
     }
     //Modify by chenrenda 20050409 end
    
      httpServletRequest.setAttribute("prpLpersonTraceDto", prpLpersonTraceDto);
      
      
      //Modify by chenrenda add 20050409 begin
      //Reason:人伤跟踪信息模块中涉及险种以列表框多选形式显示
      //将险别名称改成D1-车上人员责任险的方式,只包括三者险与车上人员责任险
      Collection prpLcheckItemKindNew = new ArrayList();
      ArrayList itemKindList = new ArrayList();
      Collection itemKindListNew = new ArrayList();
      
      String policyNo  = httpServletRequest.getParameter("policyNo");
      //System.out.println("***********王立王立王立*********policyNo************:"+policyNo);
      if(!policyNo.equals("")&&policyNo!=null)
      {
      	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo
				,checkDto.getPrpLcheckDto().getDamageStartDate().toString()
				,checkDto.getPrpLcheckDto().getDamageStartHour()); 
		
        itemKindList = policyDto.getPrpCitemKindDtoList();
      }
      
      for(int i=0;i<itemKindList.size();i++)
      {
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)itemKindList.get(i);
        prpCitemKindDto.setKindName(prpCitemKindDto.getKindCode() + "-" + prpCitemKindDto.getKindName()) ;
        if(prpCitemKindDto.getKindCode().equalsIgnoreCase("B")||prpCitemKindDto.getKindCode().equalsIgnoreCase("BZ")
           ||prpCitemKindDto.getKindCode().equalsIgnoreCase("D1")||prpCitemKindDto.getKindCode().equalsIgnoreCase("001"))
        {
          itemKindListNew.add(prpCitemKindDto) ;
        }
        prpLcheckItemKindNew.add(prpCitemKindDto);
      }
      httpServletRequest.setAttribute("referKindList",itemKindListNew);
      httpServletRequest.setAttribute("prpLcheckItemKindList",prpLcheckItemKindNew);
      //Modify by chenrenda add 20050409 end
      
      
      
      
      
      
      //Modify by chenrenda add begin 20050412
      //Reason:在查勘页面中加上其它损失模块
      Collection arrayListThirdProp = new ArrayList();
      PrpLthirdPropDto prpLthirdPropDto  = new PrpLthirdPropDto();
      arrayListThirdProp = checkDto.getPrpLthirdPropDtoList();
      prpLthirdPropDto.setThirdPropList(arrayListThirdProp) ;
      //prpLthirdPropDto.setPrpLthirdPropKindCode("B");
      httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);

      //Modify by chenrenda add end 20050412
      
      
    }

   /**
     * 获取选择框和列表框中的所有内容
     * @param httpServletRequest 返回给页面的request
     * @param prpLcheckDto    查勘的数据类
     * @throws Exception
     */
   private void setSelectionList(HttpServletRequest httpServletRequest,
                          PrpLcheckDto prpLcheckDto) throws Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();

     //查勘性质列表
     Collection checkNatures = uiCodeAction.getCodeType("CheckNature", prpLcheckDto.getRiskCode() );
     httpServletRequest.setAttribute("checkNatures", checkNatures);
     //赔案类别
     Collection caseCodes = uiCodeAction.getCodeType("CaseCode", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("caseCodes", caseCodes);
     //出险地点分类
     Collection damageAddresss = uiCodeAction.getCodeType("DamageAddress", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("damageAddresss", damageAddresss);
     //事故赔偿责任
     Collection indemnityDutys = uiCodeAction.getCodeType("IndemnityDuty", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("indemnityDutys", indemnityDutys);

     //得到实赔类型列表
     Collection reportTypes = uiCodeAction.getCodeType("ReportType", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("reportTypes", reportTypes);
     //得到案件种类列表列表
     Collection claimTypes = uiCodeAction.getCodeType("CaseCode", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("claimTypes", claimTypes);
     //得到出险地址类型列表
     Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
     //得到车辆种类列表
     Collection carKindCodes = uiCodeAction.getCodeType("CarKind", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("carKindCodes", carKindCodes);
     //得到车牌底色列表
     Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
     //得到赔偿责任列表
     Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("indemnityDutys",indemnityDuty);
     //得到赔案类别列表
     Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("escapeFlags",escapeFlags);
     //得到得到性别
     Collection driverSex = uiCodeAction.getCodeType("SexCode",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("driverSexs",driverSex);
     //得到职业分类
     Collection driverOccupation = uiCodeAction.getCodeType("Occupation",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("driverOccupations",driverOccupation) ;
     //得到文化程度
     Collection education = uiCodeAction.getCodeType("Education",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("educations",education) ;
  }
}
