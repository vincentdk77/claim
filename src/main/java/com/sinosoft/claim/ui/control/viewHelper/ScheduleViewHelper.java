package com.sinosoft.claim.ui.control.viewHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.webservice.UIScheduleDealEditPostInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * <p>Title: ScheduleViewHelper</p>
 * <p>Description:调度ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 lixiang
 * @version 1.0
 * <br>
 */

 public abstract class ScheduleViewHelper
 {
   /**
    * 默认构造方法
    */
   public ScheduleViewHelper()
   {
   }

   /**
    * 保存调度时调度页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return scheduleDto 调度数据传输数据结构
    * @throws Exception
    */
    public ScheduleDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //取得当前用户信息，写操作员信息到Dto中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");


      ScheduleDto scheduleDto = new ScheduleDto();
      /*---------------------调度主表prpLscheduleMainWF------------------------------------*/
      String prpLscheduleMainWFScheduleID   ="";
      String prpLscheduleMainWFRegistNo     ="";
      String prpLscheduleMainWFSurveyNo     ="1";
      String prpLscheduleMainWFClaimComCode ="";
      String prpLscheduleMainWFRiskCode     ="";
      String prpLscheduleMainWFPolicyNo     ="";
      String prpLscheduleMainWFOperatorCode ="";
      String prpLscheduleMainWFInputDate    ="";
      String prpLscheduleMainWFInputHour    ="";
      String prpLscheduleMainWFScheduleArea ="";
      String prpLscheduleMainWFScheduleObjectID ="";
      String prpLscheduleMainWFScheduleObjectName  ="";
      String prpLscheduleMainWFScheduleType  ="";
      String prpLscheduleMainWFCheckInputDate="";
      String prpLscheduleMainWFCheckOperatorCode  ="";
      String prpLscheduleMainWFCheckFlag ="4";
      String prpLscheduleMainWFCheckInfo ="";
      String prpLscheduleMainWFSaveType ="";
      String prpLscheduleMainWFCheckSite="";
      String prpLscheduleMainWFScheduleFlag=""; //是否已经调度，如果调度了就是1
      String prpLscheduleMainWFNextHandlerCode="";
      String prpLscheduleMainWFNextHandlerName="";
      String prpLscheduleMainWFNextNodeNo="";
      String flag         ="";
      String prpLscheduleMainWFCommiItemFlag         ="";   //查勘项目双代标志 add by liyanjie 2005-12-12
      String prpLscheduleMainWFDtoCommiFlag ="";        //案件双代标志 add by liyanjie 2005-12-12
      
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();

      //加到Dto中
      prpLscheduleMainWFScheduleID   = httpServletRequest.getParameter("prpLscheduleMainWFScheduleID");
      prpLscheduleMainWFRegistNo     = httpServletRequest.getParameter("prpLscheduleMainWFRegistNo");
      //    modify by liyanjie start因为双代的关系,查勘和定损项目都可能为不同的调度中心代码,所以要单独区分
      // change prpLscheduleMainWFClaimComCode to prpLscheduleMainWFCheckClaimComCode
      prpLscheduleMainWFClaimComCode = httpServletRequest.getParameter("prpLscheduleMainWFCheckClaimComCode");   
      System.out.println("-----prpLscheduleMainWFClaimComCode="+prpLscheduleMainWFClaimComCode);
      //    modify by liyanjie end
      prpLscheduleMainWFRiskCode = httpServletRequest.getParameter("prpLscheduleMainWFRiskCode");
      flag         = httpServletRequest.getParameter("flag");
      prpLscheduleMainWFPolicyNo     = httpServletRequest.getParameter("prpLscheduleMainWFPolicyNo");
      prpLscheduleMainWFOperatorCode =user.getUserCode();
      prpLscheduleMainWFScheduleObjectID   =httpServletRequest.getParameter("prpLscheduleMainWFScheduleObjectID"     );
      prpLscheduleMainWFCheckSite=httpServletRequest.getParameter("prpLscheduleMainWFCheckSite"     );
      prpLscheduleMainWFScheduleObjectName=httpServletRequest.getParameter("prpLscheduleMainWFScheduleObjectName"     );
      prpLscheduleMainWFSaveType =httpServletRequest.getParameter("saveType" );
      prpLscheduleMainWFCheckInfo= httpServletRequest.getParameter("prpLscheduleMainWFCheckInfo");
      prpLscheduleMainWFScheduleFlag=httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag");
      prpLscheduleMainWFNextHandlerCode=httpServletRequest.getParameter("nextHandlerCode1");
      prpLscheduleMainWFNextHandlerName=httpServletRequest.getParameter("nextHandlerName1");
      prpLscheduleMainWFNextNodeNo=httpServletRequest.getParameter("nextNodeNo1");
      prpLscheduleMainWFScheduleType =httpServletRequest.getParameter("prpLscheduleMainWFScheduleType");
      prpLscheduleMainWFScheduleFlag=httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag");
      prpLscheduleMainWFCommiItemFlag = httpServletRequest.getParameter("checkCommiItemFlag");  //查勘项目双代标志 add by liyanjie 2005-12-12
      prpLscheduleMainWFDtoCommiFlag = httpServletRequest.getParameter("prpLscheduleMainWFDtoCommiFlag");  //案件双代标志 add by liyanjie 2005-12-12
      //从数据库里查询是否已经查勘操作过了，如果操作过，则不再重复更新了
      //add by lixiang start at 2005-8-17
      //不能每次都覆盖查勘调度
      
      UIScheduleAction uiScheduleAction = new UIScheduleAction();
      ScheduleDto scheduleDtoTemp = uiScheduleAction.findByPrimaryKey(1,(String)prpLscheduleMainWFRegistNo);
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      
      if (scheduleDtoTemp.getPrpLscheduleMainWFDto()!=null&& scheduleDtoTemp.getPrpLscheduleMainWFDto().getScheduleFlag().equals( "1")){
      	prpLscheduleMainWFDto=scheduleDtoTemp.getPrpLscheduleMainWFDto();
      	prpLclaimStatusDto =scheduleDtoTemp.getPrpLclaimStatusDto();
      }else{

      prpLscheduleMainWFDto.setScheduleID          (Integer.parseInt(prpLscheduleMainWFScheduleID));
      prpLscheduleMainWFDto.setRegistNo            ((String)prpLscheduleMainWFRegistNo);
      prpLscheduleMainWFDto.setSurveyNo  (Integer.parseInt(prpLscheduleMainWFSurveyNo));

      prpLscheduleMainWFDto.setClaimComCode        (prpLscheduleMainWFClaimComCode);
      prpLscheduleMainWFDto.setRiskCode            (prpLscheduleMainWFRiskCode);
      prpLscheduleMainWFDto.setPolicyNo            (prpLscheduleMainWFPolicyNo);
      prpLscheduleMainWFDto.setOperatorCode        (prpLscheduleMainWFOperatorCode);
      prpLscheduleMainWFDto.setInputDate           (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLscheduleMainWFDto.setInputHour           (DateTime.current().getHour() );
//    20060807    prpLscheduleMainWFDto.setInputMinute           (DateTime.current().getMinute() );	  
      prpLscheduleMainWFDto.setScheduleType      ( prpLscheduleMainWFScheduleType       );
      //prpLscheduleMainWFDto.setCheckInputDate    ( new DateTime(prpLscheduleMainWFCheckInputDate)     );
      prpLscheduleMainWFDto.setCheckOperatorCode ( prpLscheduleMainWFCheckOperatorCode  );
      prpLscheduleMainWFDto.setCheckFlag         ( prpLscheduleMainWFCheckFlag          );
      prpLscheduleMainWFDto.setScheduleArea        (0);
      prpLscheduleMainWFDto.setFlag                (flag );
      prpLscheduleMainWFDto.setSaveType(prpLscheduleMainWFSaveType);
//    20060807    prpLscheduleMainWFDto.setCommiItemFlag(prpLscheduleMainWFCommiItemFlag);    //查勘项目双代标志 add by liyanjie 2005-12-12
      prpLscheduleMainWFDto.setCommiFlag(prpLscheduleMainWFDtoCommiFlag);         //案件双代标志 add by liyanjie 2005-12-12
      prpLscheduleMainWFDto.setNextNodeNo( prpLscheduleMainWFNextNodeNo);
      
      //判断查勘是否被选中
      String  checkSelectSend=httpServletRequest.getParameter("checkSelectSend");
      if ("1".equals(checkSelectSend)){
      	prpLscheduleMainWFScheduleFlag="1";
      }
      prpLscheduleMainWFDto.setScheduleFlag(prpLscheduleMainWFScheduleFlag); //如果查勘调度过了，就是1
      
     
	  
      /*---------------------文本表------------------------------------*/
      //目前还没有
      /*---------------------调度操作状态内容prpLclaimStatus------------------------------------*/

      prpLclaimStatusDto.setStatus("4");
      prpLclaimStatusDto.setBusinessNo(prpLscheduleMainWFDto.getRegistNo() );
      prpLclaimStatusDto.setPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
      prpLclaimStatusDto.setNodeType("sched");

      prpLclaimStatusDto.setInputDate(prpLscheduleMainWFDto.getInputDate() );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      prpLclaimStatusDto.setRiskCode( prpLscheduleMainWFDto.getRiskCode());
    //把scheduleid暂时放在serialNo中了。。。
//    如果先做的是三者什么的调度，那么,不做查勘调度
      if ("0".equals(checkSelectSend)){
      	prpLscheduleMainWFDto.setSaveType("schel"); //只保存定损
      }
     
      prpLclaimStatusDto.setSerialNo(1);
      }
      
      
      prpLscheduleMainWFDto.setScheduleObjectID  (prpLscheduleMainWFScheduleObjectID   );
      prpLscheduleMainWFDto.setScheduleObjectName( prpLscheduleMainWFScheduleObjectName );
      prpLscheduleMainWFDto.setCheckInfo         ( prpLscheduleMainWFCheckInfo          );
      prpLscheduleMainWFDto.setNextHandlerCode( prpLscheduleMainWFNextHandlerCode);
      prpLscheduleMainWFDto.setNextHandlerName( prpLscheduleMainWFNextHandlerName);
      prpLscheduleMainWFDto.setCheckSite(prpLscheduleMainWFCheckSite);
      
      
      if (prpLscheduleMainWFRegistNo==null&&prpLscheduleMainWFScheduleObjectID==null){
      	prpLscheduleMainWFDto.setSaveType("schel"); //只保存定损
      }
      
      if ("NOCK".equals(prpLscheduleMainWFScheduleType)) //设置没有查勘
      {
      	prpLscheduleMainWFDto.setSaveType("schel"); //只保存定损
      }
      
      //加到ArrayList中
      scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
      scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

      return scheduleDto;

    }
    /**
     * 保存调度时调度页面数据整理.
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * @param httpServletRequest
     * @return scheduleDto 调度数据传输数据结构
     * @throws Exception
     */
     public ScheduleDto viewToDtoNew(UserDto user,UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo) throws Exception
     {
         ScheduleDto scheduleDto = new ScheduleDto();
         /*---------------------调度主表prpLscheduleMainWF------------------------------------*/
         String prpLscheduleMainWFSurveyNo     ="1";
         String prpLscheduleMainWFCheckFlag ="4";
         String prpLscheduleMainWFOperatorCode =user.getUserCode();
         String prpLscheduleMainWFCheckOperatorCode  ="";
         
         String prpLscheduleMainWFScheduleID   = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleID();
         String prpLscheduleMainWFRegistNo     = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRegistNo();
         String prpLscheduleMainWFClaimComCode = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFCheckClaimComCode();
         String prpLscheduleMainWFRiskCode     = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRiskCode();
         String prpLscheduleMainWFPolicyNo     = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFPolicyNo();
         String prpLscheduleMainWFScheduleObjectID = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleObjectID();
         String prpLscheduleMainWFScheduleObjectName = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleObjectName();
         String prpLscheduleMainWFScheduleType  = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleType();
         String prpLscheduleMainWFCheckInfo = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFCheckInfo();
         String prpLscheduleMainWFSaveType = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFSaveType();
         String prpLscheduleMainWFCheckSite= uIScheduleDealEditPostInfo.getPrpLscheduleMainWFCheckSite();
         String prpLscheduleMainWFScheduleFlag= uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleFlag(); //是否已经调度，如果调度了就是1
         
         String prpLscheduleMainWFNextHandlerCode=uIScheduleDealEditPostInfo.getNextHandlerCode1();
         String prpLscheduleMainWFNextHandlerName=uIScheduleDealEditPostInfo.getNextHandlerName1();
         String prpLscheduleMainWFNextNodeNo=uIScheduleDealEditPostInfo.getNextNodeNo1();
         
         String flag         ="";
         String prpLscheduleMainWFDtoCommiFlag =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFDtoCommiFlag();        //案件双代标志 add by liyanjie 2005-12-12
         
         PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();

         //加到Dto中
         //    modify by liyanjie start因为双代的关系,查勘和定损项目都可能为不同的调度中心代码,所以要单独区分
         //    modify by liyanjie end
         flag         = uIScheduleDealEditPostInfo.getFlag();
         prpLscheduleMainWFOperatorCode =user.getUserCode();
         //从数据库里查询是否已经查勘操作过了，如果操作过，则不再重复更新了
         //add by lixiang start at 2005-8-17
         //不能每次都覆盖查勘调度
         
         UIScheduleAction uiScheduleAction = new UIScheduleAction();
         ScheduleDto scheduleDtoTemp = uiScheduleAction.findByPrimaryKey(1,(String)prpLscheduleMainWFRegistNo);
         PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
         
         if (scheduleDtoTemp.getPrpLscheduleMainWFDto()!=null&& scheduleDtoTemp.getPrpLscheduleMainWFDto().getScheduleFlag().equals( "1")){
         	prpLscheduleMainWFDto=scheduleDtoTemp.getPrpLscheduleMainWFDto();
         	prpLclaimStatusDto =scheduleDtoTemp.getPrpLclaimStatusDto();
         }else{

         prpLscheduleMainWFDto.setScheduleID          (Integer.parseInt(prpLscheduleMainWFScheduleID));
         prpLscheduleMainWFDto.setRegistNo            ((String)prpLscheduleMainWFRegistNo);
         prpLscheduleMainWFDto.setSurveyNo  (Integer.parseInt(prpLscheduleMainWFSurveyNo));

         prpLscheduleMainWFDto.setClaimComCode        (prpLscheduleMainWFClaimComCode);
         prpLscheduleMainWFDto.setRiskCode            (prpLscheduleMainWFRiskCode);
         prpLscheduleMainWFDto.setPolicyNo            (prpLscheduleMainWFPolicyNo);
         prpLscheduleMainWFDto.setOperatorCode        (prpLscheduleMainWFOperatorCode);
         prpLscheduleMainWFDto.setInputDate           (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
         prpLscheduleMainWFDto.setInputHour           (DateTime.current().getHour() );
         prpLscheduleMainWFDto.setScheduleType      ( prpLscheduleMainWFScheduleType       );
         prpLscheduleMainWFDto.setCheckOperatorCode ( prpLscheduleMainWFCheckOperatorCode  );
         prpLscheduleMainWFDto.setCheckFlag         ( prpLscheduleMainWFCheckFlag          );
         prpLscheduleMainWFDto.setScheduleArea        (0);
         prpLscheduleMainWFDto.setFlag                (flag );
         prpLscheduleMainWFDto.setSaveType(prpLscheduleMainWFSaveType);
         prpLscheduleMainWFDto.setCommiFlag(prpLscheduleMainWFDtoCommiFlag);         //案件双代标志 add by liyanjie 2005-12-12
         prpLscheduleMainWFDto.setNextNodeNo( prpLscheduleMainWFNextNodeNo);
         
         //判断查勘是否被选中
         String  checkSelectSend=uIScheduleDealEditPostInfo.getCheckSelectSend();
         if ("1".equals(checkSelectSend)){
         	prpLscheduleMainWFScheduleFlag="1";
         }
         prpLscheduleMainWFDto.setScheduleFlag(prpLscheduleMainWFScheduleFlag); //如果查勘调度过了，就是1
         
        
   	  
         /*---------------------文本表------------------------------------*/
         //目前还没有
         /*---------------------调度操作状态内容prpLclaimStatus------------------------------------*/

         prpLclaimStatusDto.setStatus("4");
         prpLclaimStatusDto.setBusinessNo(prpLscheduleMainWFDto.getRegistNo() );
         prpLclaimStatusDto.setPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
         prpLclaimStatusDto.setNodeType("sched");

         prpLclaimStatusDto.setInputDate(prpLscheduleMainWFDto.getInputDate() );
         prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
         prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
         prpLclaimStatusDto.setRiskCode( prpLscheduleMainWFDto.getRiskCode());
       //把scheduleid暂时放在serialNo中了。。。
//       如果先做的是三者什么的调度，那么,不做查勘调度
         if ("0".equals(checkSelectSend)){
         	prpLscheduleMainWFDto.setSaveType("schel"); //只保存定损
         }
        
         prpLclaimStatusDto.setSerialNo(1);
         }
         
         
         prpLscheduleMainWFDto.setScheduleObjectID  (prpLscheduleMainWFScheduleObjectID   );
         prpLscheduleMainWFDto.setScheduleObjectName( prpLscheduleMainWFScheduleObjectName );
         prpLscheduleMainWFDto.setCheckInfo         ( prpLscheduleMainWFCheckInfo          );
         prpLscheduleMainWFDto.setNextHandlerCode( prpLscheduleMainWFNextHandlerCode);
         prpLscheduleMainWFDto.setNextHandlerName( prpLscheduleMainWFNextHandlerName);
         prpLscheduleMainWFDto.setCheckSite(prpLscheduleMainWFCheckSite);
         
         
         if (prpLscheduleMainWFRegistNo==null&&prpLscheduleMainWFScheduleObjectID==null){
         	prpLscheduleMainWFDto.setSaveType("schel"); //只保存定损
         }
         
         if ("NOCK".equals(prpLscheduleMainWFScheduleType)) //设置没有查勘
         {
         	prpLscheduleMainWFDto.setSaveType("schel"); //只保存定损
         }
         
         //加到ArrayList中
         scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
         scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

         return scheduleDto;

       }

   /**
    * 取初始化信息需要的数据的整理.
    * 填写调度单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
    * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
    * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
    * @param httpServletRequest
    * @return RequestDto 取初始化信息需要的数据
    * @throws Exception
    */
   public abstract ScheduleDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * 填写调度页面及查询调度request的生成.
    * 填写调度时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
    * @param httpServletRequest 返回给页面的request
    * @param claimDto 取出的初始化信息Dto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, ScheduleDto scheduleDto) throws Exception;

 }
