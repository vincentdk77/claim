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
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� lixiang
 * @version 1.0
 * <br>
 */

 public abstract class ScheduleViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
   public ScheduleViewHelper()
   {
   }

   /**
    * �������ʱ����ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return scheduleDto �������ݴ������ݽṹ
    * @throws Exception
    */
    public ScheduleDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");


      ScheduleDto scheduleDto = new ScheduleDto();
      /*---------------------��������prpLscheduleMainWF------------------------------------*/
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
      String prpLscheduleMainWFScheduleFlag=""; //�Ƿ��Ѿ����ȣ���������˾���1
      String prpLscheduleMainWFNextHandlerCode="";
      String prpLscheduleMainWFNextHandlerName="";
      String prpLscheduleMainWFNextNodeNo="";
      String flag         ="";
      String prpLscheduleMainWFCommiItemFlag         ="";   //�鿱��Ŀ˫����־ add by liyanjie 2005-12-12
      String prpLscheduleMainWFDtoCommiFlag ="";        //����˫����־ add by liyanjie 2005-12-12
      
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();

      //�ӵ�Dto��
      prpLscheduleMainWFScheduleID   = httpServletRequest.getParameter("prpLscheduleMainWFScheduleID");
      prpLscheduleMainWFRegistNo     = httpServletRequest.getParameter("prpLscheduleMainWFRegistNo");
      //    modify by liyanjie start��Ϊ˫���Ĺ�ϵ,�鿱�Ͷ�����Ŀ������Ϊ��ͬ�ĵ������Ĵ���,����Ҫ��������
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
      prpLscheduleMainWFCommiItemFlag = httpServletRequest.getParameter("checkCommiItemFlag");  //�鿱��Ŀ˫����־ add by liyanjie 2005-12-12
      prpLscheduleMainWFDtoCommiFlag = httpServletRequest.getParameter("prpLscheduleMainWFDtoCommiFlag");  //����˫����־ add by liyanjie 2005-12-12
      //�����ݿ����ѯ�Ƿ��Ѿ��鿱�������ˣ�����������������ظ�������
      //add by lixiang start at 2005-8-17
      //����ÿ�ζ����ǲ鿱����
      
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
//    20060807    prpLscheduleMainWFDto.setCommiItemFlag(prpLscheduleMainWFCommiItemFlag);    //�鿱��Ŀ˫����־ add by liyanjie 2005-12-12
      prpLscheduleMainWFDto.setCommiFlag(prpLscheduleMainWFDtoCommiFlag);         //����˫����־ add by liyanjie 2005-12-12
      prpLscheduleMainWFDto.setNextNodeNo( prpLscheduleMainWFNextNodeNo);
      
      //�жϲ鿱�Ƿ�ѡ��
      String  checkSelectSend=httpServletRequest.getParameter("checkSelectSend");
      if ("1".equals(checkSelectSend)){
      	prpLscheduleMainWFScheduleFlag="1";
      }
      prpLscheduleMainWFDto.setScheduleFlag(prpLscheduleMainWFScheduleFlag); //����鿱���ȹ��ˣ�����1
      
     
	  
      /*---------------------�ı���------------------------------------*/
      //Ŀǰ��û��
      /*---------------------���Ȳ���״̬����prpLclaimStatus------------------------------------*/

      prpLclaimStatusDto.setStatus("4");
      prpLclaimStatusDto.setBusinessNo(prpLscheduleMainWFDto.getRegistNo() );
      prpLclaimStatusDto.setPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
      prpLclaimStatusDto.setNodeType("sched");

      prpLclaimStatusDto.setInputDate(prpLscheduleMainWFDto.getInputDate() );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      prpLclaimStatusDto.setRiskCode( prpLscheduleMainWFDto.getRiskCode());
    //��scheduleid��ʱ����serialNo���ˡ�����
//    ���������������ʲô�ĵ��ȣ���ô,�����鿱����
      if ("0".equals(checkSelectSend)){
      	prpLscheduleMainWFDto.setSaveType("schel"); //ֻ���涨��
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
      	prpLscheduleMainWFDto.setSaveType("schel"); //ֻ���涨��
      }
      
      if ("NOCK".equals(prpLscheduleMainWFScheduleType)) //����û�в鿱
      {
      	prpLscheduleMainWFDto.setSaveType("schel"); //ֻ���涨��
      }
      
      //�ӵ�ArrayList��
      scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
      scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

      return scheduleDto;

    }
    /**
     * �������ʱ����ҳ����������.
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
     * @param httpServletRequest
     * @return scheduleDto �������ݴ������ݽṹ
     * @throws Exception
     */
     public ScheduleDto viewToDtoNew(UserDto user,UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo) throws Exception
     {
         ScheduleDto scheduleDto = new ScheduleDto();
         /*---------------------��������prpLscheduleMainWF------------------------------------*/
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
         String prpLscheduleMainWFScheduleFlag= uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleFlag(); //�Ƿ��Ѿ����ȣ���������˾���1
         
         String prpLscheduleMainWFNextHandlerCode=uIScheduleDealEditPostInfo.getNextHandlerCode1();
         String prpLscheduleMainWFNextHandlerName=uIScheduleDealEditPostInfo.getNextHandlerName1();
         String prpLscheduleMainWFNextNodeNo=uIScheduleDealEditPostInfo.getNextNodeNo1();
         
         String flag         ="";
         String prpLscheduleMainWFDtoCommiFlag =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFDtoCommiFlag();        //����˫����־ add by liyanjie 2005-12-12
         
         PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();

         //�ӵ�Dto��
         //    modify by liyanjie start��Ϊ˫���Ĺ�ϵ,�鿱�Ͷ�����Ŀ������Ϊ��ͬ�ĵ������Ĵ���,����Ҫ��������
         //    modify by liyanjie end
         flag         = uIScheduleDealEditPostInfo.getFlag();
         prpLscheduleMainWFOperatorCode =user.getUserCode();
         //�����ݿ����ѯ�Ƿ��Ѿ��鿱�������ˣ�����������������ظ�������
         //add by lixiang start at 2005-8-17
         //����ÿ�ζ����ǲ鿱����
         
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
         prpLscheduleMainWFDto.setCommiFlag(prpLscheduleMainWFDtoCommiFlag);         //����˫����־ add by liyanjie 2005-12-12
         prpLscheduleMainWFDto.setNextNodeNo( prpLscheduleMainWFNextNodeNo);
         
         //�жϲ鿱�Ƿ�ѡ��
         String  checkSelectSend=uIScheduleDealEditPostInfo.getCheckSelectSend();
         if ("1".equals(checkSelectSend)){
         	prpLscheduleMainWFScheduleFlag="1";
         }
         prpLscheduleMainWFDto.setScheduleFlag(prpLscheduleMainWFScheduleFlag); //����鿱���ȹ��ˣ�����1
         
        
   	  
         /*---------------------�ı���------------------------------------*/
         //Ŀǰ��û��
         /*---------------------���Ȳ���״̬����prpLclaimStatus------------------------------------*/

         prpLclaimStatusDto.setStatus("4");
         prpLclaimStatusDto.setBusinessNo(prpLscheduleMainWFDto.getRegistNo() );
         prpLclaimStatusDto.setPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
         prpLclaimStatusDto.setNodeType("sched");

         prpLclaimStatusDto.setInputDate(prpLscheduleMainWFDto.getInputDate() );
         prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
         prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
         prpLclaimStatusDto.setRiskCode( prpLscheduleMainWFDto.getRiskCode());
       //��scheduleid��ʱ����serialNo���ˡ�����
//       ���������������ʲô�ĵ��ȣ���ô,�����鿱����
         if ("0".equals(checkSelectSend)){
         	prpLscheduleMainWFDto.setSaveType("schel"); //ֻ���涨��
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
         	prpLscheduleMainWFDto.setSaveType("schel"); //ֻ���涨��
         }
         
         if ("NOCK".equals(prpLscheduleMainWFScheduleType)) //����û�в鿱
         {
         	prpLscheduleMainWFDto.setSaveType("schel"); //ֻ���涨��
         }
         
         //�ӵ�ArrayList��
         scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
         scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

         return scheduleDto;

       }

   /**
    * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
    * ��д���ȵ�ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
    * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
    * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
    * @param httpServletRequest
    * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
    * @throws Exception
    */
   public abstract ScheduleDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * ��д����ҳ�漰��ѯ����request������.
    * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param claimDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, ScheduleDto scheduleDto) throws Exception;

 }
