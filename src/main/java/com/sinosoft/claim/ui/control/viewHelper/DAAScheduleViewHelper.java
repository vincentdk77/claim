package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.action.UserToPrpDuser;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * <p>Title: ScheduleViewHelper</p>
 * <p>Description:查勘ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 * 
 */
 public class DAAScheduleViewHelper extends ScheduleViewHelper
 {  
   /**
    * 默认构造方法
    */
    public DAAScheduleViewHelper()
    {
    }

   /**
    * 保存查勘时查勘页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return scheduleDto 查勘数据传输数据结构
    * @throws Exception
    */ 
    public ScheduleDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //继承对schedule,scheduleText表的赋值
      ScheduleDto scheduleDto = super.viewToDto(httpServletRequest);

      /*---------------------调度标底prpLScheduleItem------------------------------------*/
      /*---------------------查勘标底prpLcheckItem------------------------------------*/

      ArrayList scheduleItemDtoList = new ArrayList();
      PrpLscheduleItemDto prpLscheduleItemDto = null ;
      ArrayList checkItemDtoList = new ArrayList();
      PrpLcheckItemDto prpLcheckItemDto = null ;
      //从界面得到输入数组 后来shceudleid不需要自动加1了
      //String prpLscheduleItemScheduleID           =(String)httpServletRequest.getAttribute("scheduleID"           );
      String prpLscheduleItemScheduleID           =(String)httpServletRequest.getParameter("prpLscheduleItemScheduleID"           );
      String prpLscheduleItemRegistNo             =(String)httpServletRequest.getAttribute("registNo"             );
      String[] prpLscheduleItemItemNo             =httpServletRequest.getParameterValues("prpLscheduleItemItemNo"         );
      String[] prpLscheduleItemInsureCarFlag      =httpServletRequest.getParameterValues("prpLscheduleItemInsureCarFlag"                  );
      
      String[] prpLscheduleItemSelectSend         =httpServletRequest.getParameterValues("prpLscheduleItemSelectSend"     );
      //add by liyanjie 2005-12-12 start 保存双代标志位,调度中心代码
      //未加双代前,查勘与定损项目的调度中心为同一个,但加上双代后,可能每个都不同,所以要单独区分
      String[] prpLscheduleItemClaimComCode         =httpServletRequest.getParameterValues("prpLscheduleItemClaimComCode"  );
      String[] prpLscheduleItemCommiItemFlag         =httpServletRequest.getParameterValues("prpLscheduleItemCommiItemFlag"     );
      //add by liyanjie 2005-12-12 end
      String[] prpLscheduleItemSurveyTimes        =httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes"    );
      String[] prpLscheduleItemSurveyType         =httpServletRequest.getParameterValues("surveyType"     );
      String[] prpLscheduleItemCheckSite          =httpServletRequest.getParameterValues("prpLscheduleItemCheckSite"      );
      String[] prpLscheduleItemLicenseNo          =httpServletRequest.getParameterValues("prpLscheduleItemLicenseNo"      );
      String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID"     );
      String[] prpLscheduleItemScheduleObjectName   =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectName"   );

      String[] prpLscheduleItemCommendRepairFactoryCode     =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryCode"     );
      String[] prpLscheduleItemCommendRepairFactoryName   =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryName"   );
	  
      String prpLscheduleMainWFInputDate            =httpServletRequest.getParameter("prpLscheduleMainWFInputDate"            );
      String prpLscheduleMainWFOperatorCode         =httpServletRequest.getParameter("prpLscheduleMainWFOperatorCode"            );

      //Modify by chenrenda add begin 20050415
      //Reason:在定损调度页面中增加修理厂报损金额、修理厂联系电话、紧急位标志位
      String[] prpLscheduleItemFactoryEstimateLoss          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryEstimateLoss"      );
      String[] prpLscheduleItemFactoryPhone          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryPhone"      );
      String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
      //Modify by chenrenda add end 20050415

      String[] prpLscheduleItemResultInfo         =httpServletRequest.getParameterValues("prpLscheduleItemResultInfo"     );
      String[] prpLscheduleItemBookFlag           =httpServletRequest.getParameterValues("prpLscheduleItemBookFlag"       );
      String[] prpLscheduleItemScheduleType       =httpServletRequest.getParameterValues("prpLscheduleItemScheduleType"   );
      String[] prpLscheduleItemFlag               =httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );
      String[] newHandlerCode=httpServletRequest.getParameterValues("newHandlerCode"           );
      String[] surveyTimes=httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes");//是否为已经调度过的？
      
      String[] prpLscheduleItemInputDate       =httpServletRequest.getParameterValues("prpLscheduleItemInputDate"   );
      String[] prpLscheduleItemOperatorCode         =httpServletRequest.getParameterValues("prpLscheduleItemOperatorCode"            );

      
      int maxRow =Integer.parseInt((String)httpServletRequest.getParameter("maxrow")) ;
      
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

     
     //String[] nextHandleCode==httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );

    //modify by lixiang add 20050311 start
    //reason:调度保存提交的下一个节点的人员和节点名称
    String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //指定下一个节点操作人代码
    String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //指定下一个节点操作人姓名
    String[] strNextNode=httpServletRequest.getParameterValues("nextNodeNo");               //指定下一个节点名
    //modify by lixiang add 20050311 end
      
     //调度时往客户、调度人员发送短信 Beign
     //初始化变量
     ArrayList sMCComCodeInfoDtoList = new ArrayList();
     //SMCComCodeInfoDto sMCComCodeInfoDto = null ;
     ArrayList sMSendSMListDtoList = new ArrayList();
     //SM_Send_SM_ListDto sM_Send_SM_ListDto = null ;
     ArrayList smcResultDtoList = new ArrayList();
     //SmcResultDto smcResultDto  = null;
    
     String editType=StringUtils.rightTrim(httpServletRequest.getParameter("saveType"));//取编辑类型
     
     String  strCheckSmcSend  = StringUtils.rightTrim(httpServletRequest.getParameter("txtCheckSmcSend")); //是否选中复选框
     String  prpLscheduleMainWFScheduleFlag=StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag"));//是否被调度过
     //取联系人手机
     String strMobile = StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLossName")); 	
     String strLicenseNo =  StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLicenseNo"));
     String strLinkerName = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFLinkerName"));
     String strPhoneNumber = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFPhoneNumber"));
     
     // 为了节约发送成本，精简文字，报案号进行截串
     String strRegistNoTemp = "";
 	 if(prpLscheduleItemRegistNo.length()==22){
 		strRegistNoTemp = prpLscheduleItemRegistNo.substring(3,8)+prpLscheduleItemRegistNo.substring(16);
 	 }
 	/*
      if (("on".equals(strCheckSmcSend)&&"0".equals(prpLscheduleMainWFScheduleFlag))||("GETBACKEDIT".equals(editType)&&"on".equals(strCheckSmcSend))){
      	
      	String prpLscheduleMainWFNextHandlerName=StringUtils.rightTrim(httpServletRequest.getParameter("nextHandlerName1"));
        String prpLscheduleMainWFNextHandlerCode=StringUtils.rightTrim(httpServletRequest.getParameter("nextHandlerCode1"));
      
        //BLEdaUserFacade blEdaUserFacade = new BLEdaUserFacade();
        //解决呼叫中心的用户问题
        //PrpDuserDto prpDuserDto = blEdaUserFacade.findPrpDUserByPrimaryKey(prpLscheduleMainWFNextHandlerCode);
        
        //取查勘人员手机
        String strCheckMobile = "";
        if(prpDuserDto!=null){
          strCheckMobile = StringUtils.rightTrim(prpDuserDto.getMobile());
        }
        if(!strCheckMobile.equals("")){
        	//取查勘地点和调度信息
            String strCheckSite = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFCheckSite"));
            String strCheckInfo =  StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFCheckInfo"));
        	
        	String strContent = "查勘"+strRegistNoTemp+","+strLicenseNo+","
			                    +strLinkerName+strPhoneNumber+" "+strMobile+","+strCheckSite;
        	
        	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
     		sM_Send_SM_ListDto.setServiceID("claim");
         	sM_Send_SM_ListDto.setSMContent(strContent);
         	sM_Send_SM_ListDto.setSendTarget(strCheckMobile);//目标手机号
         	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
         	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
         	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
         	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
         	sM_Send_SM_ListDto.setFeeValue(0);
         	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
         	
//         	往业务表发送信息
         	sMCComCodeInfoDto = new SMCComCodeInfoDto();
         	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
         	sMCComCodeInfoDto.setComCode(user.getComCode());
         	sMCComCodeInfoDto.setFlag("");
         	//sMCComCodeInfoDto.setLineNo("");
         	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
         	sMCComCodeInfoDto.setRemark("");
         	//sMCComCodeInfoDto.setReplyDate();
         	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
         	sMCComCodeInfoDto.setTextType("1");
         	sMCComCodeInfoDto.setValidStatus("1");
         	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto); 	
         	
         	
         	if(!strMobile.equals("")){
         		
         		String strCheckContent = "尊敬的客户，您的报案号码为"+strRegistNoTemp+";我们的查勘人员"+prpLscheduleMainWFNextHandlerName+"("+strCheckMobile+")正在赶来，请您稍候;"
        		                        +"大地保险95590";
         		sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
         		sM_Send_SM_ListDto.setServiceID("claim");
             	sM_Send_SM_ListDto.setSMContent(strCheckContent);
             	sM_Send_SM_ListDto.setSendTarget(strMobile);//目标手机号
             	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
             	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
             	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
             	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
             	sM_Send_SM_ListDto.setFeeValue(0);
             	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
             	
                //往业务表发送信息
             	sMCComCodeInfoDto = new SMCComCodeInfoDto();
             	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
             	sMCComCodeInfoDto.setComCode(user.getComCode());
             	sMCComCodeInfoDto.setFlag("");
             	//sMCComCodeInfoDto.setLineNo("");
             	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
             	sMCComCodeInfoDto.setRemark("");
             	//sMCComCodeInfoDto.setReplyDate();
             	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
             	sMCComCodeInfoDto.setTextType("0");
             	sMCComCodeInfoDto.setValidStatus("1");
             	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);
         	}

         	
        }else{
         smcResultDto = new SmcResultDto();
         smcResultDto.setUserCode(prpLscheduleMainWFNextHandlerCode);
         smcResultDto.setUserName(prpLscheduleMainWFNextHandlerName);
         smcResultDto.setSmcType("查勘人员");
         smcResultDtoList.add(smcResultDto);
        }
      }
      */
      
      
      //调度时往客户、调度人员发送短信 end
      //对象赋值
      //调度标的部分开始
      //整理定损调度部分的标的内容
      //BLEdaUserFacade blEdaUserFacade = new BLEdaUserFacade();
      PrpDuserDto prpDuserDto = null;
      for(int index=0;index<maxRow;index++)
      {
          prpLscheduleItemDto = new PrpLscheduleItemDto();
          prpLscheduleItemDto.setScheduleID         (Integer.parseInt(prpLscheduleItemScheduleID) );
          prpLscheduleItemDto.setRegistNo           (prpLscheduleItemRegistNo     );
          prpLscheduleItemDto.setItemNo             (Integer.parseInt(prpLscheduleItemItemNo[index]));
          prpLscheduleItemDto.setInsureCarFlag      (prpLscheduleItemInsureCarFlag     [index]);
          
          prpLscheduleItemDto.setClaimComCode       (prpLscheduleItemClaimComCode[index]   );
           //表示是否选中
          prpLscheduleItemDto.setSelectSend         (prpLscheduleItemSelectSend        [index]);
//        20060807prpLscheduleItemDto.setCommiItemFlag      (prpLscheduleItemCommiItemFlag[index] );  //add by ilyanjie 2005-12-12
          //如果选中的话，surveyTimes=1
          prpLscheduleItemDto.setSurveyTimes        (0);
          
          //往定损人员、客户发送短信 begin
          String strSelectSend = prpLscheduleItemSelectSend [index];           //是否被选中
          String strInsureCarFlag = prpLscheduleItemInsureCarFlag     [index]; //是否本保单车辆
          String strSurveyTimes = surveyTimes[index];//是否被调度过
          String[] strScheduleSmcSend  =httpServletRequest.getParameterValues("prpLCheckSelectSend");
          String txtScheduleSmcSend = strScheduleSmcSend[index];
          /*
          if(("1".equals(txtScheduleSmcSend)&&"0".equals(strSurveyTimes))||( "GETBACKEDIT".equals(editType)&&"1".equals(txtScheduleSmcSend))){
          	 
          	 //标的车，往客户、定损人员发送短信
          	 if("1".equals(strInsureCarFlag)){
          	 	String strHandlerName=StringUtils.rightTrim(nextHandlerName[index]);
                String strHandlerCode=StringUtils.rightTrim(nextHandlerCode[index]);
               
            	prpDuserDto = blEdaUserFacade.findPrpDUserByPrimaryKey(strHandlerCode);
                //取定损人员手机
                String strCertaMobile = "";
                if(prpDuserDto!=null){
                  strCertaMobile = StringUtils.rightTrim(prpDuserDto.getMobile());
                }
                if(!strCertaMobile.equals("")){
                    strLicenseNo =  prpLscheduleItemLicenseNo [index];
                	String strCheckSite = prpLscheduleItemCheckSite [index];
                	
                	String strContent = "定损主车"+strRegistNoTemp+","+strLicenseNo+","
                    +strLinkerName+strPhoneNumber+" "+strMobile+","+strCheckSite;
                	
                	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
             		sM_Send_SM_ListDto.setServiceID("claim");
                 	sM_Send_SM_ListDto.setSMContent(strContent);
                 	sM_Send_SM_ListDto.setSendTarget(strCertaMobile);//目标手机号
                 	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
                 	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
                 	sM_Send_SM_ListDto.setFeeValue(0);
                 	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
                    
                 	//往业务表发送信息
                 	sMCComCodeInfoDto = new SMCComCodeInfoDto();
                 	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
                 	sMCComCodeInfoDto.setComCode(user.getComCode());
                 	sMCComCodeInfoDto.setFlag("");
                 	//sMCComCodeInfoDto.setLineNo("");
                 	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
                 	sMCComCodeInfoDto.setRemark("");
                 	//sMCComCodeInfoDto.setReplyDate();
                 	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
                 	sMCComCodeInfoDto.setTextType("1");
                 	sMCComCodeInfoDto.setValidStatus("1");
                 	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);  	
                 	
                 	
                 	 //标的车需要往客户发送短信
                    if(!strMobile.equals("")){
                 		
                 		String strCustomContent = "尊敬的客户，您的报案号码为"+strRegistNoTemp+";我们的定损人员"+strHandlerName+"("+strCertaMobile+")正在赶来，请您稍候;"
                        +"大地保险95590";
                    	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
                 		sM_Send_SM_ListDto.setServiceID("claim");
                     	sM_Send_SM_ListDto.setSMContent(strCustomContent);
                     	sM_Send_SM_ListDto.setSendTarget(strMobile);//目标手机号
                     	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
                     	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
                     	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
                     	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
                     	sM_Send_SM_ListDto.setFeeValue(0);
                     	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
                        
                     	//往业务表发送信息
                     	sMCComCodeInfoDto = new SMCComCodeInfoDto();
                     	
                     	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
                     	sMCComCodeInfoDto.setComCode(user.getComCode());
                     	sMCComCodeInfoDto.setFlag("");
                     	//sMCComCodeInfoDto.setLineNo("");
                     	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
                     	sMCComCodeInfoDto.setRemark("");
                     	//sMCComCodeInfoDto.setReplyDate();
                     	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
                     	sMCComCodeInfoDto.setTextType("0");
                     	sMCComCodeInfoDto.setValidStatus("1");
                     	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);
                 	}
                    
                    
                }else{
                    smcResultDto = new SmcResultDto();
                    smcResultDto.setUserCode(strHandlerCode);
                    smcResultDto.setUserName(strHandlerName);
                    smcResultDto.setSmcType("标的车定损人员");
                    smcResultDtoList.add(smcResultDto);
                   }
             }else{
             	
                //三者车、人伤、财产时只发送定损人员
              	String strHandlerName=StringUtils.rightTrim(nextHandlerName[index]);
                String strHandlerCode=StringUtils.rightTrim(nextHandlerCode[index]);
                String strItemNo = StringUtils.rightTrim(prpLscheduleItemItemNo[index]);
                prpDuserDto = blEdaUserFacade.findPrpDUserByPrimaryKey(strHandlerCode);
                String strCertaMobile = "";
                String strType = "";
                if(prpDuserDto!=null){
                	strCertaMobile = StringUtils.rightTrim(prpDuserDto.getMobile());
                }
            	int intItemNo = Integer.parseInt(strItemNo);
            	if(intItemNo>1){
            		strType = "三者车定损";	
            		strLicenseNo =  prpLscheduleItemLicenseNo [index];
            	}else if(intItemNo==0){
            		strType = "人伤定损";	
            	}else{
            		strType = "财产定损";	
            	}
                if(!strCertaMobile.equals("")){
                 
                	String strCheckSite = prpLscheduleItemCheckSite [index];
                	
                     
                	String strContent = strType+strRegistNoTemp+","+strLicenseNo+","
                    +strLinkerName+strPhoneNumber+" "+strMobile+","+strCheckSite;
                	
                    
                	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
             		sM_Send_SM_ListDto.setServiceID("claim");
                 	sM_Send_SM_ListDto.setSMContent(strContent);
                 	sM_Send_SM_ListDto.setSendTarget(strCertaMobile);//目标手机号
                 	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
                 	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
                 	sM_Send_SM_ListDto.setFeeValue(0);
                 	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
                    
                 	//往业务表发送信息
                 	sMCComCodeInfoDto = new SMCComCodeInfoDto();
                 	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
                 	sMCComCodeInfoDto.setComCode(user.getComCode());
                 	sMCComCodeInfoDto.setFlag("");
                 	//sMCComCodeInfoDto.setLineNo("");
                 	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
                 	sMCComCodeInfoDto.setRemark("");
                 	//sMCComCodeInfoDto.setReplyDate();
                 	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
                 	sMCComCodeInfoDto.setTextType("1");
                 	sMCComCodeInfoDto.setValidStatus("1");
                 	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);  	
                }else{
                    smcResultDto = new SmcResultDto();
                    smcResultDto.setUserCode(strHandlerCode);
                    smcResultDto.setUserName(strHandlerName);
                    smcResultDto.setSmcType(strType);
                    smcResultDtoList.add(smcResultDto);
                   }
             } 
          }
          
        */
          //往定损人员发送短信  end
          
          //判断是不是进行了新的调度选择判断
          //add by lixiang start at 2005-8-17
          //reason:调度处理的人是不一样的，需要保留原来的人
          prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ));
          //已经调度过的日期处理
          if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("1")  )
          {
          	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
          	 if(prpLscheduleItemInputDate[index]!=null&&prpLscheduleItemInputDate[index].length()==10){
          	  prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleItemInputDate[index],DateTime.YEAR_TO_DAY ));
              	
          	 }
          	prpLscheduleItemDto.setOperatorCode(prpLscheduleItemOperatorCode[index]);
          }
          if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("0")  )
          {
          	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
          	prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ) );
          	
          }
          
          //add by lixiang end at 2005-8-17
           
          if (prpLscheduleItemDto.getSelectSend().equals("1")){
            prpLscheduleItemDto.setSurveyTimes(1);
          }
       
          prpLscheduleItemDto.setSurveyType         (prpLscheduleItemSurveyType        [index]);
          prpLscheduleItemDto.setCheckSite          (prpLscheduleItemCheckSite         [index]);

          //Modify by chenrenda add begin 20050415
          //Reason:在定损调度页面中增加修理厂报损金额、修理厂联系电话、紧急位标志位
          prpLscheduleItemDto.setFactoryEstimateLoss( Double.parseDouble(DataUtils.nullToZero(prpLscheduleItemFactoryEstimateLoss      [index])));
          prpLscheduleItemDto.setFactoryPhone(prpLscheduleItemFactoryPhone[index]);
          prpLscheduleItemDto.setExigenceGree(exigenceGree[index]);
		  //Modify by chenrenda add end 20050415
          prpLscheduleItemDto.setLicenseNo          (prpLscheduleItemLicenseNo         [index]);

          if (prpLscheduleItemScheduleObjectID [index].trim().length() <1) prpLscheduleItemScheduleObjectID [index]="_";
          prpLscheduleItemDto.setScheduleObjectID   (prpLscheduleItemScheduleObjectID [index]);
          prpLscheduleItemDto.setScheduleObjectName (prpLscheduleItemScheduleObjectName[index]);

          
          prpLscheduleItemDto.setResultInfo         (prpLscheduleItemResultInfo        [index]);
          prpLscheduleItemDto.setBookFlag           (prpLscheduleItemBookFlag          [index]);
          prpLscheduleItemDto.setScheduleType       (prpLscheduleItemScheduleType      [index]);

          prpLscheduleItemDto.setFlag               (prpLscheduleItemFlag              [index]);
//modify by lixiang add 20050311 start
//reason:调度保存提交的下一个节点的人员和节点名称,目前情况
          prpLscheduleItemDto.setNextNodeNo(strNextNode[index]);
          prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode[index]);
          prpLscheduleItemDto.setNextHandlerName(nextHandlerName[index]);
          
          prpLscheduleItemDto.setCommendRepairFactoryName(prpLscheduleItemCommendRepairFactoryName [index]);
         // if (!newHandlerCode[index].equals("")&&newHandlerCode[index].length() >0 ){
            //设置最新修改的内容
         //   scheduleDto.getPrpLscheduleMainWFDto().setNewHandlerCode(newHandlerCode[index]) ;
       //   };
//modify by lixiang add 20050311 end
          
         /* if (!"".equals( scheduleDto.getPrpLscheduleMainWFDto().getCheckFlag()) ){
          	prpLscheduleItemDto.setScheduleStatus( scheduleDto.getPrpLscheduleMainWFDto().getCheckFlag());
          }*/
          //加入调度标的集合
          scheduleItemDtoList.add(prpLscheduleItemDto);
      }
      //调度集合中加调度标的
      scheduleDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
      // 调度集合中加查勘标的
      //scheduleDto.setPrpLcheckItemDtoList(checkItemDtoList);
      
      //发送短信时查勘或者定损人员没有手机号码时，给出提示 begin
      
      scheduleDto.setSmSendSMListDtoList(sMSendSMListDtoList);
      scheduleDto.setSmcComCodeInfoDtoList(sMCComCodeInfoDtoList);
      
      httpServletRequest.setAttribute("smcResultDtoList",smcResultDtoList);
      //发送短信时查勘或者定损人员没有手机号码时，给出提示 end
    

      /*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
           ArrayList prpLregistExtDtoList = new ArrayList();
           PrpLregistExtDto prpLregistExtDto = null ;
           //从界面得到输入数组
           String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo");
           String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
           String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
           String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
           String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
           String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
           String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

           //对象赋值
           //报案扩展信息 部分开始
           if (prpLregistExtSerialNo==null)
           {}
           else
           {
           
             for(int index=1;index<prpLregistExtSerialNo.length;index++)
             {
                prpLregistExtDto = new PrpLregistExtDto();
               prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
               prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
               prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
               prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
               prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
               prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
               prpLregistExtDto.setContext(prpLregistExtContext[index]);
               //加入集合
               prpLregistExtDtoList.add(prpLregistExtDto);
             }
             //报案集合中加入损失部位
             scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
           }

      return scheduleDto;
    }
    /**
     * 保存查勘时查勘页面数据整理.
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * @param httpServletRequest
     * @return scheduleDto 查勘数据传输数据结构
     * @throws Exception
     */ 
     public ScheduleDto viewToDtoNew_One(
    		  String prpLscheduleItemScheduleID
    		 ,String registNo
    		 ,String []prpLscheduleItemItemNo
    		 ,String []prpLscheduleItemSelectSend
    		 ,String []prpLscheduleItemClaimComCode
    		 ,String []prpLscheduleItemCommiItemFlag
    		 ,String []prpLscheduleItemSurveyTimes
    		 ,String []surveyType
    		 ,String []prpLscheduleItemCheckSite
    		 ,String []prpLscheduleItemScheduleObjectID
    		 ,String []prpLscheduleItemScheduleObjectName
    		 ,String []prpLscheduleItemCommendRepairFactoryName
    		 ,String prpLscheduleMainWFInputDate
    		 ,String prpLscheduleMainWFOperatorCode
    		 ,String []prpLscheduleItemFactoryEstimateLoss
    		 ,String []prpLscheduleItemFactoryPhone
    		 ,String []exigenceGree
    		 ,String []prpLscheduleItemResultInfo
    		 ,String []prpLscheduleItemBookFlag
    		 ,String []prpLscheduleItemScheduleType
    		 ,String []prpLscheduleItemFlag
    		 ,String []newHandlerCode
    		 ,String []prpLscheduleItemInputDate
    		 ,String []prpLscheduleItemOperatorCode
    		 ,String  maxrow
    		 ,String []nextHandlerCode      //指定下一个节点操作人代码
    	     ,String []nextHandlerName     	//指定下一个节点操作人姓名
    	     ,String []nextNodeNo           //指定下一个节点名 
    	     ,UserDto   user
    	     ,String saveType
    	     ,String txtCheckSmcSend
    	     ,String prpLscheduleMainWFScheduleFlag
    	     ,String prpLregistLossName	
    	     ,String prpLregistLicenseNo
    	     ,String prpLscheduleMainWFLinkerName
    	     ,String prpLscheduleMainWFPhoneNumber
    	     ,String []prpLCheckSelectSend
    	     ,String prpLregistExtRegistNo
             ,String prpLregistExtRiskCode
             ,String []prpLregistExtSerialNo
             ,String []prpLregistExtInputDate
             ,String []prpLregistExtInputHour
             ,String []prpLregistExtOperatorCode
             ,String []prpLregistExtContext

     		,String prpLscheduleMainWFScheduleID
     		,String prpLscheduleMainWFRegistNo
     		,String prpLscheduleMainWFCheckClaimComCode
     		,String prpLscheduleMainWFRiskCode
     		,String flag
     		,String prpLscheduleMainWFPolicyNo
     		,String prpLscheduleMainWFScheduleObjectID
     		,String prpLscheduleMainWFCheckSite
     		,String prpLscheduleMainWFScheduleObjectName
     		,String prpLscheduleMainWFCheckInfo
     		,String nextHandlerCode1
     		,String nextHandlerName1
     		,String nextNodeNo1
     		,String prpLscheduleMainWFScheduleType
     		,String checkCommiItemFlag
     		,String prpLscheduleMainWFDtoCommiFlag
     		,String checkSelectSend
    		 ) throws Exception
     {
       //继承对schedule,scheduleText表的赋值1

       ScheduleDto scheduleDto = null;

       /*---------------------调度标底prpLScheduleItem------------------------------------*/
       /*---------------------查勘标底prpLcheckItem------------------------------------*/

       ArrayList scheduleItemDtoList = new ArrayList();
       PrpLscheduleItemDto prpLscheduleItemDto = null ;
       ArrayList checkItemDtoList = new ArrayList();
       PrpLcheckItemDto prpLcheckItemDto = null ;
       //从界面得到输入数组 后来shceudleid不需要自动加1了
       //String prpLscheduleItemScheduleID         =(String)httpServletRequest.getAttribute("scheduleID"           );
       //String prpLscheduleItemScheduleID           =prpLscheduleItemScheduleID
       	 String prpLscheduleItemRegistNo             =registNo;
       //String[] prpLscheduleItemItemNo             =httpServletRequest.getParameterValues("prpLscheduleItemItemNo"         );
       //String[] prpLscheduleItemInsureCarFlag      =httpServletRequest.getParameterValues("prpLscheduleItemInsureCarFlag"                  );
       
       //String[] prpLscheduleItemSelectSend         =httpServletRequest.getParameterValues("prpLscheduleItemSelectSend"     );
       //add by liyanjie 2005-12-12 start 保存双代标志位,调度中心代码
       //未加双代前,查勘与定损项目的调度中心为同一个,但加上双代后,可能每个都不同,所以要单独区分
       //String[] prpLscheduleItemClaimComCode         =httpServletRequest.getParameterValues("prpLscheduleItemClaimComCode"  );
       //String[] prpLscheduleItemCommiItemFlag         =httpServletRequest.getParameterValues("prpLscheduleItemCommiItemFlag"     );
       //add by liyanjie 2005-12-12 end
       //String[] prpLscheduleItemSurveyTimes        =httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes"    );
       String[] prpLscheduleItemSurveyType         =surveyType;
       //String[] prpLscheduleItemCheckSite          =httpServletRequest.getParameterValues("prpLscheduleItemCheckSite"      );
       //String[] prpLscheduleItemLicenseNo          =httpServletRequest.getParameterValues("prpLscheduleItemLicenseNo"      );
       //String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID"     );
       //String[] prpLscheduleItemScheduleObjectName   =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectName"   );

       //String[] prpLscheduleItemCommendRepairFactoryCode     =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryCode"     );
       //String[] prpLscheduleItemCommendRepairFactoryName   =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryName"   );
 	  
       //String prpLscheduleMainWFInputDate            =httpServletRequest.getParameter("prpLscheduleMainWFInputDate"            );
       //String prpLscheduleMainWFOperatorCode         =httpServletRequest.getParameter("prpLscheduleMainWFOperatorCode"            );

       //Modify by chenrenda add begin 20050415
       //Reason:在定损调度页面中增加修理厂报损金额、修理厂联系电话、紧急位标志位
       //String[] prpLscheduleItemFactoryEstimateLoss          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryEstimateLoss"      );
       //String[] prpLscheduleItemFactoryPhone          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryPhone"      );
       //String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
       //Modify by chenrenda add end 20050415

       //String[] prpLscheduleItemResultInfo         =httpServletRequest.getParameterValues("prpLscheduleItemResultInfo"     );
       //String[] prpLscheduleItemBookFlag           =httpServletRequest.getParameterValues("prpLscheduleItemBookFlag"       );
       //String[] prpLscheduleItemScheduleType       =httpServletRequest.getParameterValues("prpLscheduleItemScheduleType"   );
       //String[] prpLscheduleItemFlag               =httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );
       //String[] newHandlerCode=httpServletRequest.getParameterValues("newHandlerCode"           );
         String[] surveyTimes=prpLscheduleItemSurveyTimes;//是否为已经调度过的？
       
       //String[] prpLscheduleItemInputDate       =httpServletRequest.getParameterValues("prpLscheduleItemInputDate"   );
       //String[] prpLscheduleItemOperatorCode    =httpServletRequest.getParameterValues("prpLscheduleItemOperatorCode"            );

       
       int maxRow =Integer.parseInt(maxrow) ;
       
//       HttpSession session = httpServletRequest.getSession();
//       UserDto   user     = (UserDto)session.getAttribute("user");

      

     //modify by lixiang add 20050311 start
     //reason:调度保存提交的下一个节点的人员和节点名称
//     String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //指定下一个节点操作人代码
//     String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //指定下一个节点操作人姓名
       String[] strNextNode=nextNodeNo;               //指定下一个节点名
     //modify by lixiang add 20050311 end
       
      //调度时往客户、调度人员发送短信 Beign
      //初始化变量
      ArrayList sMCComCodeInfoDtoList = new ArrayList();
      ArrayList sMSendSMListDtoList = new ArrayList();
      ArrayList smcResultDtoList = new ArrayList();
     
      //String editType=StringUtils.rightTrim(httpServletRequest.getParameter("saveType"));//取编辑类型
      
      //String  strCheckSmcSend  = StringUtils.rightTrim(httpServletRequest.getParameter("txtCheckSmcSend")); //是否选中复选框
      //String  prpLscheduleMainWFScheduleFlag=StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag"));//是否被调度过
      //取联系人手机
      String strMobile = StringUtils.rightTrim(prpLregistLossName); 	
      String strLicenseNo =  StringUtils.rightTrim(prpLregistLicenseNo);
      String strLinkerName = StringUtils.rightTrim(prpLscheduleMainWFLinkerName);
      String strPhoneNumber = StringUtils.rightTrim(prpLscheduleMainWFPhoneNumber);
      
      // 为了节约发送成本，精简文字，报案号进行截串
      String strRegistNoTemp = "";
  	 if(prpLscheduleItemRegistNo.length()==22){
  		strRegistNoTemp = prpLscheduleItemRegistNo.substring(3,8)+prpLscheduleItemRegistNo.substring(16);
  	 }
                
       //调度时往客户、调度人员发送短信 end
       //对象赋值
       //调度标的部分开始
       //整理定损调度部分的标的内容
       PrpDuserDto prpDuserDto = null;
       for(int index=0;index<maxRow;index++)
       {
           prpLscheduleItemDto = new PrpLscheduleItemDto();
           prpLscheduleItemDto.setScheduleID         (Integer.parseInt(prpLscheduleItemScheduleID) );
           prpLscheduleItemDto.setRegistNo           (prpLscheduleItemRegistNo     );
           prpLscheduleItemDto.setItemNo             (Integer.parseInt(prpLscheduleItemItemNo[index]));
          // prpLscheduleItemDto.setInsureCarFlag      (prpLscheduleItemInsureCarFlag     [index]);
           
           prpLscheduleItemDto.setClaimComCode       (prpLscheduleItemClaimComCode[index]   );
            //表示是否选中
           prpLscheduleItemDto.setSelectSend         (prpLscheduleItemSelectSend        [index]);
//         20060807prpLscheduleItemDto.setCommiItemFlag      (prpLscheduleItemCommiItemFlag[index] );  //add by ilyanjie 2005-12-12
           //如果选中的话，surveyTimes=1
           prpLscheduleItemDto.setSurveyTimes        (0);
           
           //往定损人员、客户发送短信 begin
           String strSelectSend = prpLscheduleItemSelectSend [index];           //是否被选中
           //String strInsureCarFlag = prpLscheduleItemInsureCarFlag     [index]; //是否本保单车辆
           String strSurveyTimes = surveyTimes[index];//是否被调度过
           String[] strScheduleSmcSend  =prpLCheckSelectSend;
           String txtScheduleSmcSend = strScheduleSmcSend[index];
           
           //判断是不是进行了新的调度选择判断
           //add by lixiang start at 2005-8-17
           //reason:调度处理的人是不一样的，需要保留原来的人
           prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ));
           //已经调度过的日期处理
           if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("1")  )
           {
           	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
           	 if(prpLscheduleItemInputDate[index]!=null&&prpLscheduleItemInputDate[index].length()==10){
           	  prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleItemInputDate[index],DateTime.YEAR_TO_DAY ));
               	
           	 }
           	prpLscheduleItemDto.setOperatorCode(prpLscheduleItemOperatorCode[index]);
           }
           if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("0")  )
           {
           	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
           	prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ) );
           	
           }
           
           //add by lixiang end at 2005-8-17
            
           if (prpLscheduleItemDto.getSelectSend().equals("1")){
             prpLscheduleItemDto.setSurveyTimes(1);
           }
        
           prpLscheduleItemDto.setSurveyType         (prpLscheduleItemSurveyType        [index]);
           prpLscheduleItemDto.setCheckSite          (prpLscheduleItemCheckSite         [index]);

           //Modify by chenrenda add begin 20050415
           //Reason:在定损调度页面中增加修理厂报损金额、修理厂联系电话、紧急位标志位
           prpLscheduleItemDto.setFactoryEstimateLoss( Double.parseDouble(DataUtils.nullToZero(prpLscheduleItemFactoryEstimateLoss      [index])));
           prpLscheduleItemDto.setFactoryPhone(prpLscheduleItemFactoryPhone[index]);
           prpLscheduleItemDto.setExigenceGree(exigenceGree[index]);
 		  //Modify by chenrenda add end 20050415
          // prpLscheduleItemDto.setLicenseNo          (prpLscheduleItemLicenseNo         [index]);

           if (prpLscheduleItemScheduleObjectID [index].trim().length() <1) prpLscheduleItemScheduleObjectID [index]="_";
           prpLscheduleItemDto.setScheduleObjectID   (prpLscheduleItemScheduleObjectID [index]);
           prpLscheduleItemDto.setScheduleObjectName (prpLscheduleItemScheduleObjectName[index]);

           
           prpLscheduleItemDto.setResultInfo         (prpLscheduleItemResultInfo        [index]);
           prpLscheduleItemDto.setBookFlag           (prpLscheduleItemBookFlag          [index]);
           prpLscheduleItemDto.setScheduleType       (prpLscheduleItemScheduleType      [index]);

           prpLscheduleItemDto.setFlag               (prpLscheduleItemFlag              [index]);
 //modify by lixiang add 20050311 start
 //reason:调度保存提交的下一个节点的人员和节点名称,目前情况
           prpLscheduleItemDto.setNextNodeNo(strNextNode[index]);
           prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode[index]);
           prpLscheduleItemDto.setNextHandlerName(nextHandlerName[index]);
           
           prpLscheduleItemDto.setCommendRepairFactoryName(prpLscheduleItemCommendRepairFactoryName [index]);
           //加入调度标的集合
           scheduleItemDtoList.add(prpLscheduleItemDto);
       }
       //调度集合中加调度标的
       	   scheduleDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
       // 调度集合中加查勘标的
       //scheduleDto.setPrpLcheckItemDtoList(checkItemDtoList);
       
       //发送短信时查勘或者定损人员没有手机号码时，给出提示 begin
       
       	   scheduleDto.setSmSendSMListDtoList(sMSendSMListDtoList);
       	   scheduleDto.setSmcComCodeInfoDtoList(sMCComCodeInfoDtoList);
       
       //httpServletRequest.setAttribute("smcResultDtoList",smcResultDtoList);
       //发送短信时查勘或者定损人员没有手机号码时，给出提示 end
     

       /*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
            ArrayList prpLregistExtDtoList = new ArrayList();
            PrpLregistExtDto prpLregistExtDto = null ;
            //从界面得到输入数组
//            String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo");
//            String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
//            String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
//            String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
//            String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
//            String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
//            String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

            //对象赋值
            //报案扩展信息 部分开始
            if (prpLregistExtSerialNo==null)
            {}
            else
            {
              for(int index=1;index<prpLregistExtSerialNo.length;index++)
              {
                 prpLregistExtDto = new PrpLregistExtDto();
                prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
                prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
                prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
                prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
                prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
                prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
                prpLregistExtDto.setContext(prpLregistExtContext[index]);
                //加入集合
                prpLregistExtDtoList.add(prpLregistExtDto);
              }
              //报案集合中加入损失部位
              scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
            }

       return scheduleDto;
     }
     
   /**
    * 取初始化信息需要的数据的整理.
    * 填写查勘单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
    * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
    * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
    * @param httpServletRequest
    * @return RequestDto 取初始化信息需要的数据
    * @throws Exception
    */
   public ScheduleDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
   {
      ScheduleDto scheduleDto = new ScheduleDto();
      return scheduleDto;

   }

   /**
    * 填写查勘页面及查询查勘request的生成.
    * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
    * @param httpServletRequest 返回给页面的request
    * @param proposalIniDto 取出的初始化信息Dto
    * @throws Exception
    */
    public void dtoToView(HttpServletRequest httpServletRequest, ScheduleDto scheduleDto) throws Exception
    {
      //得到request的PrpLsheduleForm用于显示
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();

      httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto);
      //得到request的prpscheduleItemForm 用于显示
      PrpLscheduleItemDto prpLscheduleItemDto =new PrpLscheduleItemDto();
      prpLscheduleItemDto.setScheduleItemList( scheduleDto.getPrpLscheduleItemDtoList())  ;
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
    }

    public void scheduleDtoToView(HttpServletRequest httpServletRequest,String registNo,String editType,String scheduleID) throws Exception
    {
    
   
      //取得当前用户信息，写操作员信息到查勘中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      //add by zhaolu 20060816 start
      //reason权限判断
      if(!"SHOW".equals(editType)){
    	  UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_SCHEDULE_QUERY);
      }
      //add by zhaolu 20060816 end
      int intscheduleID= Integer.parseInt(scheduleID);

      //Modify by wangwei add start 2006-02-16
      //Reason：调度正处理需要根据不同的条件显示一个回退按钮(把案件由正在处理改为待处理)。
      String handlerCode = httpServletRequest.getParameter("handlerCode");
      String flagBit = "false";
      if ("EDIT".equals(editType) && !user.getUserCode().equals(handlerCode)) {
          flagBit = "false";
      } else {
      	  flagBit = "true"; 
      }
      httpServletRequest.setAttribute("schedule.flag", flagBit);
      //Modify by wangwei add end 2006-02-16
      
      UIScheduleAction uiScheduleAction = new UIScheduleAction();
      ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(intscheduleID,registNo);

      //根据查询出来的数据内容，给PrpLscheduleDto赋值
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto() ;

      UIRegistAction uiRegistAction = new UIRegistAction();
      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
	  //reason 强制保单关联信息写到调度中
      httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
      //add by zhaolu end at 2006-06-10
		
      //modify by wangli add start 20050416
      //保存代理人代码及名称
      String policyNo = httpServletRequest.getParameter("policyNo");
      //查询保单信息
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      UICodeAction uiCodeAction = new UICodeAction();
      
      //如果查不到怎么办？ 写程序要注意的
      String agentCode="";
      
      if (policyDto.getPrpCmainDto()!=null){
         agentCode = policyDto.getPrpCmainDto().getAgentCode();         //代理人代码
      }

      if (agentCode==null) agentCode="";
      
      prpLscheduleMainWFDto.setAgentCode(agentCode);
      prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));//得到代理人名称
    
      // modify by wangli add start 20050416
      PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
      prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto.getReportHour()));
      prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(3,5));
      prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,2));
      prpLregistDto.setDamageStartHour(StringConvert.toStandardTime(prpLregistDto.getDamageStartHour()));
      prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour().substring(3,5));
      prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour().substring(0,2));
      httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
      //发送短信 begin
     
      //发送短信 end
      
      //设置扩展属性
      prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName()  ) ;
      prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber()  ) ;
      if(user != null){
    	  prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
      }
      prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto() .getLicenseNo() );
      //add by lixiang start at 2005-8-9
      //增加调度报损金额
      
      prpLscheduleMainWFDto.setEstimateLoss( registDto.getPrpLregistDto() .getEstimateLoss() );
	  //add by lixiang end at 2005-8-9
      if ("_".equals(prpLscheduleMainWFDto.getScheduleObjectID())){
      	prpLscheduleMainWFDto.setScheduleObjectID("");
      }
      //设置到底是什么类型的保存,可能是取回类型的
      
      prpLscheduleMainWFDto.setSaveType(editType);

           
       //给报案文件多行列表准备数据
      PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
      String tempContext = "";
      if(registDto.getPrpLregistTextDtoList() != null){
        Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
        while(iterator.hasNext()){
          PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
          if(StringUtils.rightTrim(prpLregistTextDtoTemp.getTextType()).equals("1"))
          {
    				prpLscheduleMainWFDto.setRegistText(prpLscheduleMainWFDto.getRegistText()+prpLregistTextDtoTemp.getContext() );
    		}
        }
      } 
       //prpLscheduleMainWFDto.setRegistText(tempContext);
    
    

      //设置查勘操作的状态为 案件修改 (正处理任务)
      if (scheduleDto.getPrpLclaimStatusDto()!=null ) {
       if (scheduleDto.getPrpLclaimStatusDto().getStatus().equals("7")) {
           scheduleDto.getPrpLclaimStatusDto().setStatus("3");
       }
       prpLscheduleMainWFDto.setStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
      } else {
        //已提交，已经处理完毕的状态
       prpLscheduleMainWFDto.setStatus("4");
      }
      
      //add by liyanjie 2005-12-10 start 判断claimcomcode是不是本调度公司,不是的就无权调度查勘任务
      //还要判断ClaimComCode为空的情况
      String nodeType = (String)httpServletRequest.getParameter("nodeType");
	  String riskCode = httpServletRequest.getParameter("riskCode");
	  String riskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);

      if(!"SHOW".equals(editType)){
    	  if("D".equals(riskType)){
    	    	//判断保单中是否含有人伤、财产、标的的险别。调度时根据一下几个标识提示信息
    	    	PrpCitemKindDto prpCitemKindDto = null;
    	    	String havePersonKind = "false";	//是否有人伤险别的标识
    	    	String havePropKind = "false";		//是否有财产险别的标识
    	    	String haveCarKind = "false";		//是否有标的险别的标识
    	    	String haveThirdCarKind = "false";  //是否有三者车险别的标识
    	    	for(int i = 0;i < policyDto.getPrpCitemKindDtoList().size();i++){
    	    		prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(i);    	
    	    		//判断是否包含人伤的险别
    	    		if("false".equals(havePersonKind) &&
    	    		    ( "D3".equals(prpCitemKindDto.getKindCode())
    	    		   || "D4".equals(prpCitemKindDto.getKindCode())
    	    		   || "B".equals(prpCitemKindDto.getKindCode())
    	    		   || "BZ".equals(prpCitemKindDto.getKindCode())
    	    		   )){
    	    			havePersonKind = "true";    	    			
    	    		}
    	    		//判断是否含有三者车的险别
    	    		if("false".equals(haveThirdCarKind) &&
    	    		    ( "B".equals(prpCitemKindDto.getKindCode())
    	    		   || "BZ".equals(prpCitemKindDto.getKindCode())
    	    		   )){
    	    			haveThirdCarKind = "true";    	    			
    	    		}
    	    		//判断是否含有财产的险别
    	    		if("false".equals(havePropKind) && 
    	    		    ( "BZ".equals(prpCitemKindDto.getKindCode())
    	    		   || "B".equals(prpCitemKindDto.getKindCode())
    	    		   || "G0".equals(prpCitemKindDto.getKindCode())
    	    		   || "NZ".equals(prpCitemKindDto.getKindCode())
    	    		   || "K10".equals(prpCitemKindDto.getKindCode())
    	    		    )){
    	    			havePropKind = "true";
    	    		}
    	    		//判断是否含有标的的险别
    	    		if("false".equals(haveCarKind) &&
    	    		    ("A".equals(prpCitemKindDto.getKindCode())
    	    		   || "G".equals(prpCitemKindDto.getKindCode()))
    	    		    ){
    	    			 haveCarKind = "true";
    	    		}
    	    	}
    		  httpServletRequest.setAttribute("havePersonKind", havePersonKind);
    		  httpServletRequest.setAttribute("haveThirdCarKind", haveThirdCarKind);
    		  httpServletRequest.setAttribute("havePropKind", havePropKind);
    		  httpServletRequest.setAttribute("haveCarKind", haveCarKind);
    		  
    	  }
        if(prpLscheduleMainWFDto.getClaimComCode().trim().length()>0){
      	 
//        	20060807	if(!user.getScheduleComCode().equals(prpLscheduleMainWFDto.getClaimComCode())){
//        	20060807 prpLscheduleMainWFDto.setScheduleType("NOCK");
//        	20060807}
        }
      }
      
      //调度任务双代标识: 0 or null:非双代案件; 1:双代代调度案件(出险方)  2:双代部分委托他方调度案件(承保方) add 2005-12-17
      String commiFlag = httpServletRequest.getParameter("commiFlag"); 
     
      //因为双代处理任务时,显示信息也借用此函数,故要区分一下,双代任务是没有双代标志的.
      if(!(nodeType == null)){
      	if("commi".equals(nodeType)){
      	} else {
      		prpLscheduleMainWFDto.setCommiFlag(commiFlag);
      	}
      } else {
      	prpLscheduleMainWFDto.setCommiFlag(commiFlag);
      }
     
      //add by liyanjie 2005-12-10 end
      
      scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);

      //设置相关代码的中文转换
      changeCodeToName(httpServletRequest,scheduleDto);
     //设置窗体表单中各个多选框中列表信息的内容
      setSelectionList(httpServletRequest,scheduleDto);
      //设置主查勘信息内容到窗体表单
      httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
      //设置各个子表信息项到窗体表单
      setSubInfo(httpServletRequest,scheduleDto,editType);
      //设置工作流下一个节点提交的配置信息
      if (!prpLscheduleMainWFDto.getStatus().equals("4"))  {
        getSubmitNodes(httpServletRequest);
      }else
      {
          //已经是展现了
          httpServletRequest.setAttribute("finishSubmit","");
      }
      setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
   	
      //给报案信息补充说明多行列表准备数据
      Collection arrayListRegistExt = new ArrayList();
      PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
      prpLregistExtDto.setRegistNo(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
      prpLregistExtDto.setRiskCode(scheduleDto.getPrpLscheduleMainWFDto().getRiskCode());
      arrayListRegistExt = scheduleDto.getPrpLregistExtDtoList();
      prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
      httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
      setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
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
                                          String registNo,String editType) throws Exception{
     scheduleDtoToView(httpServletRequest,registNo,editType,"1") ;
    }

/*
    public void registDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String editType,String surveyNo) throws Exception
    {
        //取得当前用户信息，写操作员信息到查勘中
        HttpSession session = httpServletRequest.getSession();
        UserDto   user     = (UserDto)session.getAttribute("user");
        UIRegistAction uiRegistAction = new UIRegistAction();
        RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
        //根据查询出来的数据内容，给PrpLscheduleDto赋值
        PrpLscheduleMainWFDto prpLscheduleMainWFDto= new PrpLscheduleMainWFDto ();
        user.getComCode();
        int inputHour=0;
        DateTime dtnow = new DateTime(DateTime.current());

       //prpLscheduleMainWFDto.setScheduleID    (registDto.getPrpLregistDto().getScheduleID  ());
        prpLscheduleMainWFDto.setRegistNo      (registDto.getPrpLregistDto().getRegistNo    ());
        prpLscheduleMainWFDto.setSurveyNo  (Integer.parseInt(surveyNo));

        prpLscheduleMainWFDto.setClaimComCode  (registDto.getPrpLregistDto().getComCode());
        prpLscheduleMainWFDto.setRiskCode      (registDto.getPrpLregistDto().getRiskCode    ());
        prpLscheduleMainWFDto.setPolicyNo      (registDto.getPrpLregistDto().getPolicyNo    ());
        prpLscheduleMainWFDto.setOperatorCode  (user.getUserCode() );
        prpLscheduleMainWFDto.setInputDate     (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        inputHour = dtnow.HOUR_TO_HOUR ;
        prpLscheduleMainWFDto.setInputHour     (DateTime.current().getHour());
       // prpLscheduleMainWFDto.setScheduleArea  (registDto.getPrpLregistDto().getScheduleArea());
        prpLscheduleMainWFDto.setFlag          (registDto.getPrpLregistDto().getFlag        ());

        //prpLscheduleMainWFDto.setInputHour(dtnow.getHour() );
        prpLscheduleMainWFDto.setStatus("0");
        //设置扩展属性
        prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName()  ) ;
        prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber()  ) ;
        prpLscheduleMainWFDto.setOperatorName(user.getUserName() );

       if  (registDto.getPrpLregistTextDtoList().size() > 0)
        {
            PrpLregistTextDto prpLregistTextDto= new PrpLregistTextDto();
            prpLregistTextDto=(PrpLregistTextDto)registDto.getPrpLregistTextDtoList().iterator().next()  ;
            prpLscheduleMainWFDto.setRegistText(prpLregistTextDto.getContext() );
        }
        //设置查勘操作的状态为 新案件登记 (未处理任务)
        //prpLscheduleMainWFDto.setStatus("1");
        //设置相关代码的中文转换
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
        changeCodeToName(httpServletRequest,scheduleDto);
        //设置窗体表单中各个多选框中列表信息的内容
        setSelectionList(httpServletRequest,scheduleDto);
        //设置主查勘信息内容到窗体表单
        httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
        //设置各个子表信息项到窗体表单
        //(1).[涉案车辆]给三者车辆多行列表准备数据
        ArrayList arrayList = new ArrayList();
        PrpLthirdPartyDto prpLthirdPartyDto  = new PrpLthirdPartyDto();
        arrayList = registDto.getPrpLthirdPartyDtoList();
        prpLthirdPartyDto.setThirdPartyList(arrayList) ;
        scheduleDto.setPrpLthirdPartyDtoList(arrayList);

        // 考虑如何转换三者车和调度的标的内容
        httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

        ArrayList scheduleItemList = new ArrayList();

        Iterator it = arrayList.iterator() ;
        int i =1;
        PrpLthirdPartyDto prpLthirdPartyTempDto  = new PrpLthirdPartyDto();
        arrayList.contains(it);

        while (it.hasNext() )
        {
           PrpLscheduleItemDto prpLscheduleItemDto =new PrpLscheduleItemDto();
           prpLthirdPartyTempDto =(PrpLthirdPartyDto)it.next() ;
           prpLscheduleItemDto.setScheduleID         (scheduleDto.getPrpLscheduleMainWFDto().getScheduleID()  );
           prpLscheduleItemDto.setRegistNo           (scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
           prpLscheduleItemDto.setItemNo             (prpLthirdPartyTempDto.getSerialNo    ());
           prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyTempDto.getInsureCarFlag     ()  );
           prpLscheduleItemDto.setClaimComCode       (scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode ());
           prpLscheduleItemDto.setSelectSend         ("0");
           prpLscheduleItemDto.setSurveyTimes        (1);
           prpLscheduleItemDto.setSurveyType         (registDto.getPrpLregistDto () .getFirstSiteFlag() );
       //modify by lixiang add 20050309 start
       //reason:查勘地址默认为出险地址，自动带出
           if (i==1){ //只有第一条显示查勘地址
          prpLscheduleItemDto.setCheckSite          (registDto.getPrpLregistDto () .getDamageAddress() );

        }
       //modify by lixiang add 20050309 end

           //查勘地址
           //prpLscheduleItemDto.setCheckSite          ( );
           prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyTempDto.getLicenseNo         ());
           //prpLscheduleItemDto.setScheduleObjectID   (0d);
           //prpLscheduleItemDto.setScheduleObjectName (prpLthirdPartyTempDto.getScheduleObjectName());
           prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
           // prpLscheduleItemDto.setResultInfo         (prpLthirdPartyTempDto.getResultInfo        ());
           // prpLscheduleItemDto.setBookFlag           (prpLthirdPartyTempDto.getBookFlag          ());
           // prpLscheduleItemDto.setScheduleType       (prpLthirdPartyTempDto.getScheduleType      ());
           //加入集合
           scheduleItemList.add(prpLscheduleItemDto);
           i++;
         }

         scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
         PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
         prpLscheduleItemDto.setScheduleItemList(scheduleItemList);
         httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);

         //设置工作流下一个节点提交的配置信息
         getSubmitNodes(httpServletRequest);
    }
 */
    /**
     * 查询工作流可以用来选择的节点内容
     * @param modelNo String
     * @param nodeNo String
     * @throws Exception
     */
    private void getSubmitNodes(HttpServletRequest httpServletRequest) throws Exception
    {
      String modelNo= httpServletRequest.getParameter("modelNo"); //模板号
      String nodeNo= httpServletRequest.getParameter("nodeNo");   //节点号
      int nextNodeNo=0;
      Collection pathList = new ArrayList();
      SwfPathDto swfPathDto  = new SwfPathDto() ;
      WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
      if (modelNo!=null&& nodeNo!=null)
      {
      pathList = workFlowViewHelper.getNextSumbitNodes(modelNo,nodeNo);
         if (pathList.iterator() .hasNext() )
          {
            SwfPathDto swfPathDtoTemp = new SwfPathDto();
            swfPathDtoTemp=(SwfPathDto)pathList.iterator().next();
            nextNodeNo = swfPathDtoTemp.getEndNodeNo();
            swfPathDto.setNextNodeNo(nextNodeNo);
          }
      }
      swfPathDto.setPathList(pathList);
      httpServletRequest.setAttribute("pathList",pathList);
      httpServletRequest.setAttribute("swfPathDto",swfPathDto);
    }

    /**
     * 根据报案号查询查勘信息
     * @param httpServletRequest 返回给页面的request
     * @param registNo      立案号
     * @param claimNo       报案号
     * @throws Exception
     */

   
    /**
      * 根据Dto中的各子表内的信息填充界面
      * @param httpServletRequest 返回给页面的request
      * @param scheduleDto    查勘的数据类
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           ScheduleDto scheduleDto,String editType) throws Exception
    {


    	ArrayList scheduleItemListTemp = new ArrayList();
    	ArrayList scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList() ;
    	scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
    	  //要过滤掉不同的scheduleType的内容,只有查勘定损才过滤的。。报案保存的是_,变成""
    	for (int i =0;i<scheduleItemList.size();i++) {
    		PrpLscheduleItemDto prpLscheduleItemDtoTemp =new PrpLscheduleItemDto();
            prpLscheduleItemDtoTemp =(PrpLscheduleItemDto)((ArrayList)scheduleItemList).get(i)  ;
            if (prpLscheduleItemDtoTemp.getScheduleObjectID().equals("_") ){
	            prpLscheduleItemDtoTemp.setScheduleObjectID   ("");
	            prpLscheduleItemDtoTemp.setScheduleObjectName ("");
            }
            	/*
	          if (prpLscheduleItemDtoTemp.getScheduleType().equals("sched")  ){
	            prpLscheduleItemDtoTemp.setSelectSend("0");
	            prpLscheduleItemDtoTemp.setSurveyTimes(0);
	            //如果主车是到查勘去了的话，在定损调度里不能选择，除非查勘已经提交了。。
	             }*/
            	//如果没有调度过，默认进去为0,就是没有被选中
            if (prpLscheduleItemDtoTemp.getSurveyTimes()==0 )
            {
            	prpLscheduleItemDtoTemp.setSelectSend("0");
            }
            //add by liyanjie 2005-12-11 start 比较ClaimComCode是否本调度公司,不是的无权处理
            HttpSession session = httpServletRequest.getSession();
            UserDto   user     = (UserDto)session.getAttribute("user");
            
            if( (!"SHOW".equals(editType)) && prpLscheduleItemDtoTemp.getClaimComCode() != null && prpLscheduleItemDtoTemp.getClaimComCode().length()>0){
//            	20060807if(user.getScheduleComCode().equals(prpLscheduleItemDtoTemp.getClaimComCode())){
            	 //加入集合
//            	20060807           	scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
//            	20060807             }
//            	add by lixiang start at 2006-08-09
                //reason:由于这边目前不做双代，所以先不考虑这个问题。不做任何过滤数据
                	scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
                //add by lixiang start at 2006-08-09
            }else{
            	scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
            }
            
            //add by liyanjie 2005-12-11 end
          
           
    	}

    	PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
    	prpLscheduleItemDto.setScheduleItemList(scheduleItemListTemp);
    	httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
	}

    

    /**
     * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
     * @param httpServletRequest 返回给页面的request
     * @param prpLscheduleDto    查勘的数据类
     * @throws Exception
     */
   private void changeCodeToName(HttpServletRequest httpServletRequest,
                          ScheduleDto scheduleDto) throws Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();

     //(1)对业务归属结构进行转换
     String claimComCode = scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode();
     String claimComName = uiCodeAction.translateComCode(claimComCode,true) ;
     scheduleDto.getPrpLscheduleMainWFDto().setClaimComName(claimComName);
     //(2)对操作员进行处理
     String operatorCode = scheduleDto.getPrpLscheduleMainWFDto().getOperatorCode() ;
     String operatorName = uiCodeAction.translateUserCode(operatorCode,true);
     scheduleDto.getPrpLscheduleMainWFDto().setOperatorName(operatorName);
  }
  public void  getScheuleGetBackQueryList(HttpServletRequest httpServletRequest,
                          String conditions,String scheduleType) throws Exception{
  //获得调度取回的任务的列表
   getScheuleCheckList(httpServletRequest,conditions,"schel");

}



/**
* 查询查勘调度的信息
* @param httpServletRequest HttpServletRequest
* @param conditions String
* @throws Exception
*/

 public void getScheuleCheckList(HttpServletRequest httpServletRequest,
                          String conditions,String scheduleType) throws Exception
  {
    UIScheduleAction uiScheduleAction  = new UIScheduleAction ();
    PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
    PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
    ArrayList scheduleList = new ArrayList();
    Collection scheduleListTemp = new ArrayList();
    UICodeAction uiCodeAction = new UICodeAction();
    
    //每页显示的行数
        String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        //
        if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";

      int intRecordPerPage=Integer.parseInt(recordPerPage) ;
      int intPageNo=Integer.parseInt(pageNo) ;
      TurnPageDto turnPageDto = new TurnPageDto();//翻页内容
      
      int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
      int count=0;
      
    if (scheduleType.equals("sched") ){
        
    	//限制条件!!!
    	//判断条件限制
         	  count= uiScheduleAction.findScheduleMainWFCountByConditon(conditions);
         	  if(maxQueryCount!=0&&count>maxQueryCount){   
                 throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
            }
    	
    	PageRecord pageRecord = (PageRecord)uiScheduleAction.findByConditions(conditions,intPageNo,intRecordPerPage) ;
    	
      scheduleListTemp = (ArrayList)pageRecord.getResult();
      
      
         
      //1.转换操作员的姓名,和调度员
   Iterator it = scheduleListTemp.iterator() ;

   while (it.hasNext() )
   {
     PrpLscheduleMainWFDto prpLscheduleMainWFDto1 = new PrpLscheduleMainWFDto();
     prpLscheduleMainWFDto1 =(PrpLscheduleMainWFDto) it.next();
     prpLscheduleMainWFDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleMainWFDto1.getOperatorCode(),true)) ;
     scheduleList.add(prpLscheduleMainWFDto1);
   }
   prpLscheduleMainWFDto.setScheduleList(scheduleList);
   
   //查询出来的一页的结构集
         turnPageDto.setResultList(scheduleList);
          //分页的增加
      //当前页号
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //一页的条数
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //查询出来的结果的总数
         turnPageDto.setTotalCount(pageRecord.getCount());
         //返回总的页数
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //搜索条件
         turnPageDto.setCondition(conditions);
    prpLscheduleMainWFDto.setTurnPageDto(turnPageDto) ;
         
    httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto);
    }else{
    
     //限制条件
     //判断条件限制
         	  count= uiScheduleAction.findScheduleItemCountByConditon(conditions);
         	  if(maxQueryCount!=0&&count>maxQueryCount){   
                 throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
            }
     
    	PageRecord pageRecord = (PageRecord)uiScheduleAction.findItemByConditions(conditions,intPageNo,intRecordPerPage) ;
    	
      scheduleListTemp = (ArrayList)pageRecord.getResult();
      //1.转换操作员的姓名,和调度员
   Iterator it = scheduleListTemp.iterator() ;

   while (it.hasNext() )
   {
     PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
     prpLscheduleItemDto1 =(PrpLscheduleItemDto) it.next();
     prpLscheduleItemDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleItemDto1.getOperatorCode(),true)) ;
     scheduleList.add(prpLscheduleItemDto1);
   }
      prpLscheduleItemDto.setScheduleItemList(scheduleList);
      //查询出来的一页的结构集
         turnPageDto.setResultList(scheduleList);
          //分页的增加
      //当前页号
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //一页的条数
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //查询出来的结果的总数
         turnPageDto.setTotalCount(pageRecord.getCount());
         //返回总的页数
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //搜索条件
         turnPageDto.setCondition(conditions);
         prpLscheduleItemDto.setTurnPageDto(turnPageDto) ;
    
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
    }
    
    
   

    

   }

      /**
     * 查询定损调度的信息
     * @param httpServletRequest HttpServletRequest
     * @param conditions String
     * @throws Exception
     */
    public void getScheuleCertainLossList(HttpServletRequest httpServletRequest,
                            String conditions) throws Exception
    {
      UIScheduleAction uiScheduleAction  = new UIScheduleAction ();
      PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
      Collection scheduleList = new ArrayList();
      Collection scheduleListTemp = new ArrayList();
      UICodeAction uiCodeAction = new UICodeAction();
      scheduleListTemp=uiScheduleAction.findItemByConditions(conditions);
      //1.转换操作员的姓名,和调度员
      Iterator it = scheduleListTemp.iterator() ;

      while (it.hasNext() )
      {
        PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
        prpLscheduleItemDto1 =(PrpLscheduleItemDto) it.next();
        prpLscheduleItemDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleItemDto1.getOperatorCode() ,true)) ;

        scheduleList.add(prpLscheduleItemDto1);
      }

      prpLscheduleItemDto.setScheduleItemList(scheduleList);
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
      httpServletRequest.setAttribute("scheduleType","schel") ;
     	
     }

     /**
        * 查询已经调度出去的，可以进行处理的信息（打算从工作流上获得了）
        * @param httpServletRequest HttpServletRequest
        * @param conditions String
        * @throws Exception
        */
       public void getNextTaskList(HttpServletRequest httpServletRequest,String conditions,String nodeType) throws Exception
       {
         UIWorkFlowAction uiWorkFlowAction= new UIWorkFlowAction();
         SwfLogDto swfLogDto = new SwfLogDto();
         ArrayList swfLogList = new ArrayList();
         UICodeAction uiCodeAction = new UICodeAction();
//       每页显示的行数
         String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
         String pageNo     = httpServletRequest.getParameter("pageNo");
         //
         if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";

       int intRecordPerPage=Integer.parseInt(recordPerPage) ;
       int intPageNo=Integer.parseInt(pageNo) ;
       TurnPageDto turnPageDto = new TurnPageDto();//翻页内容
       
       
       PageRecord pageRecord = (PageRecord)uiWorkFlowAction.findNodesByConditions(conditions,intPageNo,intRecordPerPage) ;
       
         swfLogList=(ArrayList)pageRecord.getResult();
         String editType     = httpServletRequest.getParameter("editType");
         
      
         swfLogDto.setSwfLogList(swfLogList);
         swfLogDto.setNodeType(nodeType);
         swfLogDto.setEditType(editType);
         swfLogDto.setNodeName(uiCodeAction.translateCodeCode("ClaimNodeType",nodeType,true) );
         //查询出来的一页的结构集
         turnPageDto.setResultList(swfLogList);
         //当前页号
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //一页的条数
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //查询出来的结果的总数
         turnPageDto.setTotalCount(pageRecord.getCount());
         //返回总的页数
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //搜索条件
         turnPageDto.setCondition(conditions);
         swfLogDto.setTurnPageDto(turnPageDto );
         
         httpServletRequest.setAttribute("swfLogDto",swfLogDto);
        
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
   			String scheduleType,String registNo,String editType) throws Exception{
   		//按照类型进行节点的查询，因为所有数据都已经在报案中保存了。
   		//取得当前用户信息，写操作员信息到查勘中
   		HttpSession session = httpServletRequest.getSession();
   		UserDto   user     = (UserDto)session.getAttribute("user");
   		UIScheduleAction uiScheduleAction = new UIScheduleAction();
   		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(1,registNo);
   		//System.out.println("@@@@@@@@@@@@@@王立的测试 ：registNo 流到："+registNo);
   		String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
   		String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
   		String riskCode = httpServletRequest.getParameter("riskCode"); //工作流logno
   		
   		
   		//modify by luqin update 2005-05-16 start
   		//reason: 为非车险加入查勘调度节点
   		UIRegistAction uiRegistAction = new UIRegistAction();
   		System.out.println("registNo"+registNo);
   		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
   		
   	     //add by zhaolu start at 2006-06-10
   		  //reason 强制保单关联信息写到调度中
   			System.out.println("强制保单关联信息写到调度中----------440");
   			System.out.println(registDto.getPrpLRegistRPolicyList().size());
   			System.out.println(registDto.getPrpLRegistRPolicyDtoOfCompel());
   			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
   			//add by zhaolu end at 2006-06-10
   		
   		String policyNo = httpServletRequest.getParameter("policyNo");
   		
   		//根据查询出来的数据内容，给PrpLscheduleDto赋值
   		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
   		if(scheduleDto.getPrpLscheduleMainWFDto()==null){
   			prpLscheduleMainWFDto.setRegistNo(registNo);
   			prpLscheduleMainWFDto.setPolicyNo(policyNo);
   			prpLscheduleMainWFDto.setClaimComCode(registDto.getPrpLregistDto().getComCode());
   			prpLscheduleMainWFDto.setClaimComName(registDto.getPrpLregistDto().getComName());
   			
   		}
   		else{
   			prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
   		}
   		//modify by luqin update 2005-05-16 end
   		
   		
   		//设置扩展属性
   		prpLscheduleMainWFDto.setRiskCode(riskCode);
   		prpLscheduleMainWFDto.setLinkerName(DataUtils.nullToEmpty(registDto.getPrpLregistDto().getLinkerName() ) ) ;
   		prpLscheduleMainWFDto.setPhoneNumber(DataUtils.nullToEmpty(registDto.getPrpLregistDto().getPhoneNumber() ) ) ;;
   		prpLscheduleMainWFDto.setOperatorCode(user.getUserCode() );
   		prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
   		prpLscheduleMainWFDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
   		prpLscheduleMainWFDto.setInputHour(DateTime.current().getHour());
   		prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo() );
   		prpLscheduleMainWFDto.setScheduleObjectID("");
   		prpLscheduleMainWFDto.setEstimateLoss(registDto.getPrpLregistDto().getEstimateLoss());
   		
   		//得到部门列表
   		PrpDcompanyDto prpDcompanyDto = new 	PrpDcompanyDto ();
   	 //20060807  		prpDcompanyDto = (PrpDcompanyDto)new UICompanyAction().findByPrimaryKey(user .getComCode()) ;
   		if (prpDcompanyDto!=null){
   			prpLscheduleMainWFDto.setScheduleObjectID(prpDcompanyDto.getComCode());
   			prpLscheduleMainWFDto.setScheduleObjectName(prpDcompanyDto.getComCName());
   		}
   		
   		//modify by wangwei add start 205-6-13
   		//原因：增加估损费用信息
   		//modify by wangwei add end 2005-6-13
 //20060807  		prpLscheduleMainWFDto.setEstimateFee(registDto.getPrpLregistDto().getEstimateFee());
   		
   		//modify by wangli add start 20050416
   		//保存代理人代码及名称
   		//System.out.println("王立的测试：：：：shedule policyNo ＝ "+policyNo+"policyNo ");
   		//查询保单信息
   		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
   		
   		if(policyNo!=null&&policyNo.length()>0)
   		{
   			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo
   					,registDto.getPrpLregistDto().getDamageStartDate().toString()
   					,registDto.getPrpLregistDto().getDamageStartHour()); 
   			
   			UICodeAction uiCodeAction = new UICodeAction();
   			String agentCode="";
   			if (policyDto.getPrpCmainDto()!=null){
   				agentCode = policyDto.getPrpCmainDto().getAgentCode();         //代理人代码
   			}
   			prpLscheduleMainWFDto.setAgentCode(agentCode);
   			prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));//得到代理人名称
   			//  System.out.println("王立的测试：：：：shedule agentCode ＝ "+agentCode+"shedule ");
   			
   		}
   		// modify by wangli add start 20050416
   		//默认调度地址为出险地址
   		prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto() .getDamageAddress() );
   		
   		//设置到底是什么类型的保存
   		prpLscheduleMainWFDto.setSaveType(editType);
   		
   		if  (registDto.getPrpLregistTextDtoList().size() > 0)
   		{
   			for(int i = 0;i<registDto.getPrpLregistTextDtoList().size();i++){
   				PrpLregistTextDto prpLregistTextDto= new PrpLregistTextDto();
   				prpLregistTextDto=(PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i)  ;
   				prpLscheduleMainWFDto.setRegistText(prpLscheduleMainWFDto.getRegistText()+prpLregistTextDto.getContext() );
   			}
   		}
   		
   		//已经处理完毕的状态
   		prpLscheduleMainWFDto.setStatus("2");
   		
   		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
   		
   		//设置相关代码的中文转换
   		changeCodeToName(httpServletRequest,scheduleDto);
   		//设置窗体表单中各个多选框中列表信息的内容
   		setSelectionList(httpServletRequest,scheduleDto);
   		//设置主查勘信息内容到窗体表单
   		httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
   		//只有定损调度才和标的有关系，查勘调度，只要保存主表信息，就可以了。
   		//设置各个子表信息项到窗体表单
   		setSubInfo(httpServletRequest,scheduleDto);
   			//检查节点是不是可以提交
   			WorkFlowViewHelper workFlowViewHelper= new WorkFlowViewHelper();
   			String msg=workFlowViewHelper.checkNodeSubmit(swfLogFlowID,swfLogLogNo);
   			httpServletRequest.setAttribute("finishSubmit",msg);
   			//httpServletRequest.setAttribute("prpLscheduleItemDto",scheduleDto.getPrpLscheduleMainWFDto());
   			
   		
   		//根据类型整理scheduleItem
   		//设置工作流下一个节点提交的配置信息
   		getSubmitNodes(httpServletRequest);
   		
   		//给报案信息补充说明多行列表准备数据
   		Collection arrayListRegistExt = new ArrayList();
   		PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
   		prpLregistExtDto.setRegistNo(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
   		prpLregistExtDto.setRiskCode(scheduleDto.getPrpLscheduleMainWFDto().getRiskCode());
   		arrayListRegistExt = scheduleDto.getPrpLregistExtDtoList();
   		prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
   		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
   		
   		setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
   		
   		//scheduleDtoToView(httpServletRequest,registNo,editType,"1") ;
   		
   	}
	
	/**
	 * 根据Dto中的各子表内的信息填充界面
	 * @param httpServletRequest 返回给页面的request
	 * @param scheduleDto    查勘的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception
			{
		
		
		ArrayList scheduleItemListTemp = new ArrayList();
		ArrayList scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList() ;
		scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
		//要过滤掉不同的scheduleType的内容,只有查勘定损才过滤的。。报案保存的是_,变成""
		for (int i =0;i<scheduleItemList.size();i++) {
			PrpLscheduleItemDto prpLscheduleItemDtoTemp =new PrpLscheduleItemDto();
			prpLscheduleItemDtoTemp =(PrpLscheduleItemDto)((ArrayList)scheduleItemList).get(i)  ;
			if (prpLscheduleItemDtoTemp.getScheduleObjectID().equals("_") ){
				prpLscheduleItemDtoTemp.setScheduleObjectID   ("");
				prpLscheduleItemDtoTemp.setScheduleObjectName ("");
				
			}
			if (prpLscheduleItemDtoTemp.getScheduleType().equals("sched")  ){
				prpLscheduleItemDtoTemp.setSelectSend("0");
				prpLscheduleItemDtoTemp.setSurveyTimes(0);
				//如果主车是到查勘去了的话，在定损调度里不能选择，除非查勘已经提交了。。
			}
//			如果没有调度过，默认进去为0,就是没有被选中
			if (prpLscheduleItemDtoTemp.getSurveyTimes()==0 )
			{
				prpLscheduleItemDtoTemp.setSelectSend("0");
			}
			//加入集合
			scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
		}
//		System.out .println("scheduleItemListTemp.size()"+scheduleItemListTemp.size()) ;
		PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleItemList(scheduleItemListTemp);
		httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
		 
			}
	
	/**
	 * 获取选择框和列表框中的所有内容
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLscheduleDto    查勘的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception
			{
		UICodeAction uiCodeAction = new UICodeAction();
		
		
		//得到车辆种类列表
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//得到车牌底色列表
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
			}
	

	
	
	
	//add by zhaolu 20060724 start
	//reason:查询调度信息查询分页
	public void getScheuleCheckList(HttpServletRequest httpServletRequest,
			String conditions, String scheduleType,int pageNo,int recordPerPage) throws Exception {
		
		
		PageRecord pageRecord = null;
		
		
		String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	        }
	       
	     
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
		ArrayList scheduleList = new ArrayList();
		ArrayList scheduleListTemp = new ArrayList();
		UICodeAction uiCodeAction = new UICodeAction();
		
		if (scheduleType.equals("sched")) {
			
			
			
			//scheduleListTemp = uiScheduleAction.findByConditions(conditions);
            pageRecord = (PageRecord)uiScheduleAction.findForRegistConditions(conditions,pageNo,recordPerPage);
            scheduleListTemp = (ArrayList)pageRecord.getResult();
            
          PrpLscheduleMainWFDto prpLscheduleMainWFDtoTemp = new PrpLscheduleMainWFDto();
            
          
          httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDtoTemp);
            
			//1.转换操作员的姓名,和调度员
			Iterator it = scheduleListTemp.iterator();

			while (it.hasNext()) {
				PrpLscheduleMainWFDto prpLscheduleMainWFDto1 = new PrpLscheduleMainWFDto();
				prpLscheduleMainWFDto1 = (PrpLscheduleMainWFDto) it.next();
				prpLscheduleMainWFDto1.setOperatorName(uiCodeAction
						.translateUserCode(prpLscheduleMainWFDto1
								.getOperatorCode(), true));
				scheduleList.add(prpLscheduleMainWFDto1);
			}
			  TurnPageDto turnPageDto = new TurnPageDto();
		       //查询出来的一页的结构集 
		       turnPageDto.setResultList(scheduleList);
		       //当前页号
		       turnPageDto.setPageNo(pageRecord.getPageNo());
		       //一页的条数
		       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		       //查询出来的结果的总数
		       turnPageDto.setTotalCount(pageRecord.getCount());
		       //返回总的页数
		       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		       //搜索条件
		       turnPageDto.setCondition(conditions); 
			prpLscheduleMainWFDto.setScheduleList(scheduleList);
			prpLscheduleMainWFDto.setTurnPageDto(turnPageDto);
			httpServletRequest.setAttribute("prpLscheduleMainWFDto",
					prpLscheduleMainWFDto);
		} else {
			//scheduleListTemp = uiScheduleAction
					//.findItemByConditions(conditions);
			
			pageRecord = (PageRecord)uiScheduleAction.findItemByConditions(conditions,pageNo,recordPerPage);
			scheduleListTemp = (ArrayList)pageRecord.getResult();
			
			
          
            PrpLscheduleMainWFDto prpLscheduleMainWFDtoTemp = new PrpLscheduleMainWFDto();
            
           
           
            httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDtoTemp);
			
			//1.转换操作员的姓名,和调度员
			Iterator it = scheduleListTemp.iterator();

			while (it.hasNext()) {
				PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
				prpLscheduleItemDto1 = (PrpLscheduleItemDto) it.next();
				prpLscheduleItemDto1.setOperatorName(uiCodeAction
						.translateUserCode(prpLscheduleItemDto1
								.getOperatorCode(), true));
				scheduleList.add(prpLscheduleItemDto1);
			}
			TurnPageDto turnPageDto = new TurnPageDto();
		       //查询出来的一页的结构集 
		       turnPageDto.setResultList(scheduleList);
		       //当前页号
		       turnPageDto.setPageNo(pageRecord.getPageNo());
		       //一页的条数
		       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		       //查询出来的结果的总数
		       turnPageDto.setTotalCount(pageRecord.getCount());
		       //返回总的页数
		       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		       //搜索条件
		       turnPageDto.setCondition(conditions); 
			prpLscheduleItemDto.setScheduleItemList(scheduleList);
			prpLscheduleItemDto.setTurnPageDto(turnPageDto);
			httpServletRequest.setAttribute("prpLscheduleItemDto",
					prpLscheduleItemDto);
		}
		

	}
	
  //add by zhaolu 20060724 end
	
	
	
	private void setProvinceCode(HttpServletRequest httpServletRequest,String comCode){
		/**
		 * 获得保单归属机构的相应省份代码,用以 的业务需求。（要求在调度时只能选择该分公司相关的所有公司进行调度）
		 * ComCode的第1、2两位是相应的省份代码，如"3400000000"中的"34"就是省份代码
		 */
		String provinceCode = comCode.substring(0,2);
		httpServletRequest.setAttribute("provinceCode",provinceCode);
	}	


 }
