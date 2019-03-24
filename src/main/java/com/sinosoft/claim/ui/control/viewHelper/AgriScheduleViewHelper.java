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
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UserToPrpDuser;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.webservice.UIScheduleDealEditPostInfo;
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
 * <p>Description:�鿱ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 * 
 */
 public class AgriScheduleViewHelper extends ScheduleViewHelper
 {  
   /**
    * Ĭ�Ϲ��췽��
    */
    public AgriScheduleViewHelper()
    {
    }

   /**
    * ����鿱ʱ�鿱ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return scheduleDto �鿱���ݴ������ݽṹ
    * @throws Exception
    */ 
    public ScheduleDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //�̳ж�schedule,scheduleText��ĸ�ֵ
      ScheduleDto scheduleDto = super.viewToDto(httpServletRequest);

      /*---------------------���ȱ��prpLScheduleItem------------------------------------*/
      /*---------------------�鿱���prpLcheckItem------------------------------------*/

      ArrayList scheduleItemDtoList = new ArrayList();
      PrpLscheduleItemDto prpLscheduleItemDto = null ;
      ArrayList checkItemDtoList = new ArrayList();
      PrpLcheckItemDto prpLcheckItemDto = null ;
      String riskCode = httpServletRequest.getParameter("prpLscheduleMainWFRiskCode");
      String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
      //�ӽ���õ��������� ����shceudleid����Ҫ�Զ���1��
      //String prpLscheduleItemScheduleID           =(String)httpServletRequest.getAttribute("scheduleID"           );
      String prpLscheduleItemScheduleID           =(String)httpServletRequest.getParameter("prpLscheduleItemScheduleID"           );
      String prpLscheduleItemRegistNo             =(String)httpServletRequest.getAttribute("registNo"             );
      String[] prpLscheduleItemItemNo             =httpServletRequest.getParameterValues("prpLscheduleItemItemNo"         );
      
      
      String[] prpLscheduleItemSelectSend         =httpServletRequest.getParameterValues("prpLscheduleItemSelectSend"     );
      //add by liyanjie 2005-12-12 start ����˫����־λ,�������Ĵ���
      //δ��˫��ǰ,�鿱�붨����Ŀ�ĵ�������Ϊͬһ��,������˫����,����ÿ������ͬ,����Ҫ��������
      String[] prpLscheduleItemClaimComCode         =httpServletRequest.getParameterValues("prpLscheduleItemClaimComCode"  );
      String[] prpLscheduleItemCommiItemFlag         =httpServletRequest.getParameterValues("prpLscheduleItemCommiItemFlag"     );
      //add by liyanjie 2005-12-12 end
      String[] prpLscheduleItemSurveyTimes        =httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes"    );
      String[] prpLscheduleItemSurveyType         =httpServletRequest.getParameterValues("surveyType"     );
      String[] prpLscheduleItemCheckSite          =httpServletRequest.getParameterValues("prpLscheduleItemCheckSite"      );
      
      String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID"     );
      String[] prpLscheduleItemScheduleObjectName   =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectName"   );

      
      String[] prpLscheduleItemCommendRepairFactoryName   =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryName"   );
	  
      String prpLscheduleMainWFInputDate            =httpServletRequest.getParameter("prpLscheduleMainWFInputDate"            );
      String prpLscheduleMainWFOperatorCode         =httpServletRequest.getParameter("prpLscheduleMainWFOperatorCode"            );

      //Modify by chenrenda add begin 20050415
      //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
      String[] prpLscheduleItemFactoryEstimateLoss          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryEstimateLoss"      );
      String[] prpLscheduleItemFactoryPhone          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryPhone"      );
      String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
      //Modify by chenrenda add end 20050415

      String[] prpLscheduleItemResultInfo         =httpServletRequest.getParameterValues("prpLscheduleItemResultInfo"     );
      String[] prpLscheduleItemBookFlag           =httpServletRequest.getParameterValues("prpLscheduleItemBookFlag"       );
      String[] prpLscheduleItemScheduleType       =httpServletRequest.getParameterValues("prpLscheduleItemScheduleType"   );
      String[] prpLscheduleItemFlag               =httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );
      String[] newHandlerCode=httpServletRequest.getParameterValues("newHandlerCode"           );
      String[] surveyTimes=httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes");//�Ƿ�Ϊ�Ѿ����ȹ��ģ�
      
      String[] prpLscheduleItemInputDate       =httpServletRequest.getParameterValues("prpLscheduleItemInputDate"   );
      String[] prpLscheduleItemOperatorCode         =httpServletRequest.getParameterValues("prpLscheduleItemOperatorCode"            );

      int maxRow = 0;
      //�⽡�ղ���Ҫ���� add by xiatian 
      if(!"Q".equals(riskType)&&!"Y".equals(riskType)&&!"Z".equals(riskType)&&!"E".equals(riskType)){
    	  maxRow =Integer.parseInt((String)httpServletRequest.getParameter("maxrow")) ;
      }

      
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

     
     //String[] nextHandleCode==httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );

    //modify by lixiang add 20050311 start
    //reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����
    String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //ָ����һ���ڵ�����˴���
    String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //ָ����һ���ڵ����������
    String[] strNextNode=httpServletRequest.getParameterValues("nextNodeNo");               //ָ����һ���ڵ���
    //modify by lixiang add 20050311 end
      
     //����ʱ���ͻ���������Ա���Ͷ��� Beign
     //��ʼ������
     ArrayList sMCComCodeInfoDtoList = new ArrayList();
     //SMCComCodeInfoDto sMCComCodeInfoDto = null ;
     ArrayList sMSendSMListDtoList = new ArrayList();
     //SM_Send_SM_ListDto sM_Send_SM_ListDto = null ;
     ArrayList smcResultDtoList = new ArrayList();
     //SmcResultDto smcResultDto  = null;
    
     String editType=StringUtils.rightTrim(httpServletRequest.getParameter("saveType"));//ȡ�༭����
     
     String  strCheckSmcSend  = StringUtils.rightTrim(httpServletRequest.getParameter("txtCheckSmcSend")); //�Ƿ�ѡ�и�ѡ��
     String  prpLscheduleMainWFScheduleFlag=StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag"));//�Ƿ񱻵��ȹ�
     //ȡ��ϵ���ֻ�
     String strMobile = StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLossName")); 	
     String strLicenseNo =  StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLicenseNo"));
     String strLinkerName = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFLinkerName"));
     String strPhoneNumber = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFPhoneNumber"));
     
     // Ϊ�˽�Լ���ͳɱ����������֣������Ž��нش�
     String strRegistNoTemp = "";
 	 if(prpLscheduleItemRegistNo.length()==22){
 		strRegistNoTemp = prpLscheduleItemRegistNo.substring(3,8)+prpLscheduleItemRegistNo.substring(16);
 	 }
 	
      PrpDuserDto prpDuserDto = null;
      for(int index=0;index<maxRow;index++)
      {
          prpLscheduleItemDto = new PrpLscheduleItemDto();
          prpLscheduleItemDto.setScheduleID         (Integer.parseInt(prpLscheduleItemScheduleID) );
          prpLscheduleItemDto.setRegistNo           (prpLscheduleItemRegistNo     );
          prpLscheduleItemDto.setItemNo             (Integer.parseInt(prpLscheduleItemItemNo[index]));
          
          prpLscheduleItemDto.setClaimComCode       (prpLscheduleItemClaimComCode[index]   );
           //��ʾ�Ƿ�ѡ��
          prpLscheduleItemDto.setSelectSend         (prpLscheduleItemSelectSend        [index]);
//        20060807prpLscheduleItemDto.setCommiItemFlag      (prpLscheduleItemCommiItemFlag[index] );  //add by ilyanjie 2005-12-12
          //���ѡ�еĻ���surveyTimes=1
          prpLscheduleItemDto.setSurveyTimes        (0);
          
          //��������Ա���ͻ����Ͷ��� begin
          String strSelectSend = prpLscheduleItemSelectSend [index];           //�Ƿ�ѡ��
          String strSurveyTimes = surveyTimes[index];//�Ƿ񱻵��ȹ�
          String[] strScheduleSmcSend  =httpServletRequest.getParameterValues("prpLCheckSelectSend");
          String txtScheduleSmcSend = strScheduleSmcSend[index];
          
          //��������Ա���Ͷ���  end
          
          //�ж��ǲ��ǽ������µĵ���ѡ���ж�
          //add by lixiang start at 2005-8-17
          //reason:���ȴ�������ǲ�һ���ģ���Ҫ����ԭ������
          prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ));
          //�Ѿ����ȹ������ڴ���
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
          //add by kangzhen  reason ������ϵ������
          prpLscheduleItemDto.setCommendRepairFactoryName(prpLscheduleItemCommendRepairFactoryName[index]);
          
          //Modify by chenrenda add begin 20050415
          //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
          prpLscheduleItemDto.setFactoryEstimateLoss( Double.parseDouble(DataUtils.nullToZero(prpLscheduleItemFactoryEstimateLoss      [index])));
          prpLscheduleItemDto.setFactoryPhone(prpLscheduleItemFactoryPhone[index]);
          prpLscheduleItemDto.setExigenceGree(exigenceGree[index]);
		  //Modify by chenrenda add end 20050415

          if (prpLscheduleItemScheduleObjectID [index].trim().length() <1) prpLscheduleItemScheduleObjectID [index]="_";
          prpLscheduleItemDto.setScheduleObjectID   (prpLscheduleItemScheduleObjectID [index]);
          prpLscheduleItemDto.setScheduleObjectName (prpLscheduleItemScheduleObjectName[index]);

          
          prpLscheduleItemDto.setResultInfo         (prpLscheduleItemResultInfo        [index]);
          prpLscheduleItemDto.setBookFlag           (prpLscheduleItemBookFlag          [index]);
          prpLscheduleItemDto.setScheduleType       (prpLscheduleItemScheduleType      [index]);

          prpLscheduleItemDto.setFlag               (prpLscheduleItemFlag              [index]);
//modify by lixiang add 20050311 start
//reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����,Ŀǰ���
          prpLscheduleItemDto.setNextNodeNo(strNextNode[index]);
          prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode[index]);
          prpLscheduleItemDto.setNextHandlerName(nextHandlerName[index]);
        
          //������ȱ�ļ���
          scheduleItemDtoList.add(prpLscheduleItemDto);
      }
      //���ȼ����мӵ��ȱ��
      scheduleDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
      // ���ȼ����мӲ鿱���
      //scheduleDto.setPrpLcheckItemDtoList(checkItemDtoList);
      
      //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ begin
      
      scheduleDto.setSmSendSMListDtoList(sMSendSMListDtoList);
      scheduleDto.setSmcComCodeInfoDtoList(sMCComCodeInfoDtoList);
      
      httpServletRequest.setAttribute("smcResultDtoList",smcResultDtoList);
      //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ end
    

      /*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
           ArrayList prpLregistExtDtoList = new ArrayList();
           PrpLregistExtDto prpLregistExtDto = null ;
           //�ӽ���õ���������
           String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo");
           String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
           String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
           String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
           String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
           String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
           String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

           //����ֵ
           //������չ��Ϣ ���ֿ�ʼ
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
               //���뼯��
               prpLregistExtDtoList.add(prpLregistExtDto);
             }
             //���������м�����ʧ��λ
             scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
           }

      return scheduleDto;
    }
    
    /**
     * ����鿱ʱ�鿱ҳ����������.
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
     * @param httpServletRequest
     * @return scheduleDto �鿱���ݴ������ݽṹ
     * @throws Exception
     */ 
     public ScheduleDto viewToDtoNew(UserDto user,UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo) throws Exception
     {
         //�̳ж�schedule,scheduleText��ĸ�ֵ
         ScheduleDto scheduleDto = super.viewToDtoNew(user, uIScheduleDealEditPostInfo);

         /*---------------------���ȱ��prpLScheduleItem------------------------------------*/
         /*---------------------�鿱���prpLcheckItem------------------------------------*/

         ArrayList scheduleItemDtoList = new ArrayList();
         PrpLscheduleItemDto prpLscheduleItemDto = null ;
         ArrayList checkItemDtoList = new ArrayList();
         PrpLcheckItemDto prpLcheckItemDto = null ;
         String riskCode = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRiskCode();
         String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
         //�ӽ���õ��������� ����shceudleid����Ҫ�Զ���1��
         String prpLscheduleItemScheduleID           =uIScheduleDealEditPostInfo.getPrpLscheduleItemScheduleID();
         String prpLscheduleItemRegistNo             =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRegistNo();
         String prpLscheduleItemItemNo             =uIScheduleDealEditPostInfo.getPrpLscheduleItemItemNo();
         
         
         String prpLscheduleItemSelectSend         =uIScheduleDealEditPostInfo.getPrpLscheduleItemSelectSend();
         //add by liyanjie 2005-12-12 start ����˫����־λ,�������Ĵ���
         //δ��˫��ǰ,�鿱�붨����Ŀ�ĵ�������Ϊͬһ��,������˫����,����ÿ������ͬ,����Ҫ��������
         String prpLscheduleItemClaimComCode         =uIScheduleDealEditPostInfo.getPrpLscheduleItemClaimComCode();
         String prpLscheduleItemCommiItemFlag         =uIScheduleDealEditPostInfo.getPrpLscheduleItemCommiItemFlag();
         //add by liyanjie 2005-12-12 end
         String prpLscheduleItemSurveyTimes        =uIScheduleDealEditPostInfo.getPrpLscheduleItemSurveyTimes();
         String prpLscheduleItemSurveyType         =uIScheduleDealEditPostInfo.getSurveyType();
         String prpLscheduleItemCheckSite        =uIScheduleDealEditPostInfo.getPrpLscheduleItemCheckSite();//�����ַ;
         
         String prpLscheduleItemScheduleObjectID     =uIScheduleDealEditPostInfo.getPrpLscheduleItemScheduleObjectID();//������λ;
         String prpLscheduleItemScheduleObjectName   =uIScheduleDealEditPostInfo.getPrpLscheduleItemScheduleObjectName();//������λ;
         String prpLscheduleItemCommendRepairFactoryName   =uIScheduleDealEditPostInfo.getPrpLscheduleItemCommendRepairFactoryName();//��ϵ������
   	  
         String prpLscheduleMainWFInputDate            =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFInputDate();
//         String prpLscheduleMainWFOperatorCode         =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFOperatorCode();

         //Modify by chenrenda add begin 20050415
         //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
         //������
         String prpLscheduleItemFactoryEstimateLoss          =uIScheduleDealEditPostInfo.getPrpLscheduleItemFactoryEstimateLoss();
         String prpLscheduleItemFactoryPhone          =uIScheduleDealEditPostInfo.getPrpLscheduleItemFactoryPhone();//��ϵ�˵绰
         String exigenceGree          =uIScheduleDealEditPostInfo.getExigenceGree();
         //Modify by chenrenda add end 20050415

         String prpLscheduleItemResultInfo         =uIScheduleDealEditPostInfo.getPrpLscheduleItemResultInfo();//����Ҫ����ʾ
         String prpLscheduleItemBookFlag           =uIScheduleDealEditPostInfo.getPrpLscheduleItemBookFlag();
         String prpLscheduleItemScheduleType       =uIScheduleDealEditPostInfo.getPrpLscheduleItemScheduleType();
         String prpLscheduleItemFlag               =uIScheduleDealEditPostInfo.getPrpLscheduleItemFlag();
//         String[] newHandlerCode                   =httpServletRequest.getParameterValues("newHandlerCode"           );
         String surveyTimes                        =uIScheduleDealEditPostInfo.getPrpLscheduleItemSurveyTimes();//�Ƿ�Ϊ�Ѿ����ȹ��ģ�
         
         String prpLscheduleItemInputDate       =uIScheduleDealEditPostInfo.getPrpLscheduleItemInputDate();
         String prpLscheduleItemOperatorCode         =uIScheduleDealEditPostInfo.getPrpLscheduleItemOperatorCode();

         int maxRow = 0;
         //�⽡�ղ���Ҫ���� add by xiatian 
         if(!"Q".equals(riskType)&&!"Y".equals(riskType)&&!"Z".equals(riskType)&&!"E".equals(riskType)){
       	  maxRow =1 ;
         }

       //modify by lixiang add 20050311 start
       //reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����
       String nextHandlerCode=uIScheduleDealEditPostInfo.getNextHandlerCode();      //ָ����һ���ڵ�����˴���
       String nextHandlerName=uIScheduleDealEditPostInfo.getNextHandlerName();      //ָ����һ���ڵ����������
       String strNextNode=uIScheduleDealEditPostInfo.getNextNodeNo();               //ָ����һ���ڵ���
       //modify by lixiang add 20050311 end
         
        //����ʱ���ͻ���������Ա���Ͷ��� Beign
        //��ʼ������
        ArrayList sMCComCodeInfoDtoList = new ArrayList();
        //SMCComCodeInfoDto sMCComCodeInfoDto = null ;
        ArrayList sMSendSMListDtoList = new ArrayList();
        //SM_Send_SM_ListDto sM_Send_SM_ListDto = null ;
        ArrayList smcResultDtoList = new ArrayList();
        //SmcResultDto smcResultDto  = null;
       
//        String editType=StringUtils.rightTrim(httpServletRequest.getParameter("saveType"));//ȡ�༭����
        
//        String  strCheckSmcSend  = StringUtils.rightTrim(httpServletRequest.getParameter("txtCheckSmcSend")); //�Ƿ�ѡ�и�ѡ��
//        String  prpLscheduleMainWFScheduleFlag=StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag"));//�Ƿ񱻵��ȹ�
        //ȡ��ϵ���ֻ�
//        String strMobile = StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLossName")); 	
//        String strLicenseNo =  uIScheduleDealEditPostInfo.getLicenseNo();
//        String strLinkerName = uIScheduleDealEditPostInfo.getLinkerName();
//        String strPhoneNumber = uIScheduleDealEditPostInfo.getPhoneNumber();
        
        // Ϊ�˽�Լ���ͳɱ����������֣������Ž��нش�
        String strRegistNoTemp = "";
    	 if(prpLscheduleItemRegistNo.length()==22){
    		strRegistNoTemp = prpLscheduleItemRegistNo.substring(3,8)+prpLscheduleItemRegistNo.substring(16);
    	 }
    	
         PrpDuserDto prpDuserDto = null;
         if(maxRow==1)
         {
             prpLscheduleItemDto = new PrpLscheduleItemDto();
             prpLscheduleItemDto.setScheduleID         (Integer.parseInt(prpLscheduleItemScheduleID) );
             prpLscheduleItemDto.setRegistNo           (prpLscheduleItemRegistNo     );
             prpLscheduleItemDto.setItemNo             (Integer.parseInt(prpLscheduleItemItemNo));
             
             prpLscheduleItemDto.setClaimComCode       (prpLscheduleItemClaimComCode   );
              //��ʾ�Ƿ�ѡ��
             prpLscheduleItemDto.setSelectSend         (prpLscheduleItemSelectSend);
//           20060807prpLscheduleItemDto.setCommiItemFlag      (prpLscheduleItemCommiItemFlag[index] );  //add by ilyanjie 2005-12-12
             //���ѡ�еĻ���surveyTimes=1
             prpLscheduleItemDto.setSurveyTimes        (0);
             
             //��������Ա���ͻ����Ͷ��� begin
//             String strSelectSend = prpLscheduleItemSelectSend;           //�Ƿ�ѡ��
//             String strSurveyTimes = surveyTimes;//�Ƿ񱻵��ȹ�
//             String txtScheduleSmcSend = "0";
             
             //��������Ա���Ͷ���  end
             
             //�ж��ǲ��ǽ������µĵ���ѡ���ж�
             //add by lixiang start at 2005-8-17
             //reason:���ȴ�������ǲ�һ���ģ���Ҫ����ԭ������
             prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ));
             //�Ѿ����ȹ������ڴ���
             if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes.equals("1")  )
             {
             	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
             	 if(prpLscheduleItemInputDate!=null&&prpLscheduleItemInputDate.length()==10){
             	  prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleItemInputDate,DateTime.YEAR_TO_DAY ));
                 	
             	 }
             	prpLscheduleItemDto.setOperatorCode(prpLscheduleItemOperatorCode);
             }
             if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes.equals("0")  )
             {
             	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
             	prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ) );
             	
             }
             
             //add by lixiang end at 2005-8-17
              
             if (prpLscheduleItemDto.getSelectSend().equals("1")){
               prpLscheduleItemDto.setSurveyTimes(1);
             }
          
             prpLscheduleItemDto.setSurveyType         (prpLscheduleItemSurveyType);
             prpLscheduleItemDto.setCheckSite          (prpLscheduleItemCheckSite);
             //add by kangzhen  reason ������ϵ������
             prpLscheduleItemDto.setCommendRepairFactoryName(prpLscheduleItemCommendRepairFactoryName);
             
             //Modify by chenrenda add begin 20050415
             //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
             prpLscheduleItemDto.setFactoryEstimateLoss( Double.parseDouble(DataUtils.nullToZero(prpLscheduleItemFactoryEstimateLoss)));
             prpLscheduleItemDto.setFactoryPhone(prpLscheduleItemFactoryPhone);
             prpLscheduleItemDto.setExigenceGree(exigenceGree);
   		  //Modify by chenrenda add end 20050415

             if (prpLscheduleItemScheduleObjectID.trim().length() <1) prpLscheduleItemScheduleObjectID="_";
             prpLscheduleItemDto.setScheduleObjectID   (prpLscheduleItemScheduleObjectID);
             prpLscheduleItemDto.setScheduleObjectName (prpLscheduleItemScheduleObjectName);

             
             prpLscheduleItemDto.setResultInfo         (prpLscheduleItemResultInfo);
             prpLscheduleItemDto.setBookFlag           (prpLscheduleItemBookFlag);
             prpLscheduleItemDto.setScheduleType       (prpLscheduleItemScheduleType);

             prpLscheduleItemDto.setFlag               (prpLscheduleItemFlag);
   //modify by lixiang add 20050311 start
   //reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����,Ŀǰ���
             prpLscheduleItemDto.setNextNodeNo(strNextNode);
             prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode);
             prpLscheduleItemDto.setNextHandlerName(nextHandlerName);
           
             //������ȱ�ļ���
             scheduleItemDtoList.add(prpLscheduleItemDto);
         }
         //���ȼ����мӵ��ȱ��
         scheduleDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
         // ���ȼ����мӲ鿱���
         //scheduleDto.setPrpLcheckItemDtoList(checkItemDtoList);
         
         //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ begin
         
         scheduleDto.setSmSendSMListDtoList(sMSendSMListDtoList);
         scheduleDto.setSmcComCodeInfoDtoList(sMCComCodeInfoDtoList);
         
         //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ end
       

         /*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
         ArrayList prpLregistExtDtoList = new ArrayList();
         PrpLregistExtDto prpLregistExtDto = null ;
         
         String prpLregistExtRegistNo = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRegistNo();;
         String prpLregistExtRiskCode = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRiskCode();
         String[] prpLregistExtSerialNo = uIScheduleDealEditPostInfo.getPrpLregistExtSerialNo();
         String[] prpLregistExtInputDate = uIScheduleDealEditPostInfo.getPrpLregistExtInputDate();
         String[] prpLregistExtInputHour = uIScheduleDealEditPostInfo.getPrpLregistExtInputHour();
         String[] prpLregistExtOperatorCode = uIScheduleDealEditPostInfo.getPrpLregistExtOperatorCode();
         String[] prpLregistExtContext = uIScheduleDealEditPostInfo.getPrpLregistExtContext();

         //����ֵ
         //������չ��Ϣ ���ֿ�ʼ
         if (prpLregistExtSerialNo==null)
         {}
         else
         {
             for(int index=0;index<prpLregistExtSerialNo.length;index++)
             {
                 prpLregistExtDto = new PrpLregistExtDto();
                 prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
                 prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
                 prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
                 prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
                 prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
                 prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
                 prpLregistExtDto.setContext(prpLregistExtContext[index]);
                 //���뼯��
                 prpLregistExtDtoList.add(prpLregistExtDto);
            }
             //���������м�����ʧ��λ
            scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
        }

         return scheduleDto;
       }

   /**
    * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
    * ��д�鿱��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
    * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
    * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
    * @param httpServletRequest
    * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
    * @throws Exception
    */
   public ScheduleDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
   {
      ScheduleDto scheduleDto = new ScheduleDto();
      return scheduleDto;

   }

   /**
    * ��д�鿱ҳ�漰��ѯ�鿱request������.
    * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public void dtoToView(HttpServletRequest httpServletRequest, ScheduleDto scheduleDto) throws Exception
    {
      //�õ�request��PrpLsheduleForm������ʾ
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();

      httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto);
      //�õ�request��prpscheduleItemForm ������ʾ
      PrpLscheduleItemDto prpLscheduleItemDto =new PrpLscheduleItemDto();
      prpLscheduleItemDto.setScheduleItemList( scheduleDto.getPrpLscheduleItemDtoList())  ;
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
    }

    public void scheduleDtoToView(HttpServletRequest httpServletRequest,String registNo,String editType,String scheduleID) throws Exception
    {
    
   
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      //add by zhaolu 20060816 start
      //reasonȨ���ж�
      UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_SCHEDULE_QUERY);
      //add by zhaolu 20060816 end
      int intscheduleID= Integer.parseInt(scheduleID);

      //Modify by wangwei add start 2006-02-16
      //Reason��������������Ҫ���ݲ�ͬ��������ʾһ�����˰�ť(�Ѱ��������ڴ����Ϊ������)��
      String handlerCode = httpServletRequest.getParameter("handlerCode");
      String flagBit = "false";
      if (!user.getUserCode().equals(handlerCode) && "EDIT".equals(editType)) {
          flagBit = "false";
      } else {
      	  flagBit = "true"; 
      }
      httpServletRequest.setAttribute("schedule.flag", flagBit);
      //Modify by wangwei add end 2006-02-16
      
      UIScheduleAction uiScheduleAction = new UIScheduleAction();
      ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(intscheduleID,registNo);

      //���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto() ;
      UIRegistAction uiRegistAction = new UIRegistAction();
      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
      //modify by wangli add start 20050416
      //��������˴��뼰����
      String policyNo = httpServletRequest.getParameter("policyNo");
      //��ѯ������Ϣ
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      UICodeAction uiCodeAction = new UICodeAction();
      
      //����鲻����ô�죿 д����Ҫע���
      String agentCode="";
      
      if (policyDto.getPrpCmainDto()!=null){
         agentCode = policyDto.getPrpCmainDto().getAgentCode();         //�����˴���
      }

      if (agentCode==null) {
    	  agentCode="";
      }
      if(agentCode!=null&&!"".equals(agentCode)){
          prpLscheduleMainWFDto.setAgentCode(agentCode);
          prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));//�õ�����������
      }
      // modify by wangli add start 20050416
      PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
      prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto.getReportHour()));
      prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(3,5));
      prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,2));
      prpLregistDto.setDamageStartHour(StringConvert.toStandardTime(prpLregistDto.getDamageStartHour()));
      prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour().substring(3,5));
      prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour().substring(0,2));
      httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
      //���Ͷ��� begin
     
      //���Ͷ��� end
      
      //������չ����
      prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName());
      prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber()) ;
      prpLscheduleMainWFDto.setOperatorName(user.getUserName());
      prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto() .getLicenseNo());
      //add by lixiang start at 2005-8-9
      //���ӵ��ȱ�����
      
      prpLscheduleMainWFDto.setEstimateLoss( registDto.getPrpLregistDto() .getEstimateLoss() );
	  //add by lixiang end at 2005-8-9
      if ("_".equals(prpLscheduleMainWFDto.getScheduleObjectID())){
      	prpLscheduleMainWFDto.setScheduleObjectID("");
      }
      //���õ�����ʲô���͵ı���,������ȡ�����͵�
      
      prpLscheduleMainWFDto.setSaveType(editType);

           
       //�������ļ������б�׼������
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
      //���ò鿱������״̬Ϊ �����޸� (����������)
      if (scheduleDto.getPrpLclaimStatusDto()!=null ) {
       if (scheduleDto.getPrpLclaimStatusDto().getStatus().equals("7")) {
           scheduleDto.getPrpLclaimStatusDto().setStatus("3");
       }
       prpLscheduleMainWFDto.setStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
      } else {
        //���ύ���Ѿ�������ϵ�״̬
       prpLscheduleMainWFDto.setStatus("4");
      }
      
      //add by liyanjie 2005-12-10 start �ж�claimcomcode�ǲ��Ǳ����ȹ�˾,���ǵľ���Ȩ���Ȳ鿱����
      //��Ҫ�ж�ClaimComCodeΪ�յ����
      String nodeType = (String)httpServletRequest.getParameter("nodeType");
      
      //��������˫����ʶ: 0 or null:��˫������; 1:˫�������Ȱ���(���շ�)  2:˫������ί���������Ȱ���(�б���) add 2005-12-17
      String commiFlag = httpServletRequest.getParameter("commiFlag"); 
     
      String schedFlag = httpServletRequest.getParameter("schedFlag"); 
      if(schedFlag!=null&&!schedFlag.equals("")){  	  
    	  httpServletRequest.setAttribute("schedFlag", schedFlag);
      }else{
    	  httpServletRequest.setAttribute("schedFlag", "");
      }
      //��Ϊ˫����������ʱ,��ʾ��ϢҲ���ô˺���,��Ҫ����һ��,˫��������û��˫����־��.
      if(!(nodeType == null)){
      	if("commi".equals(nodeType)){
      	} else {
      		prpLscheduleMainWFDto.setCommiFlag(commiFlag);
      	}
      } else {
      	prpLscheduleMainWFDto.setCommiFlag(commiFlag);
      }
     
      //add by liyanjie 2005-12-10 end
      //Add by chenrenda begin 20070716
      //reason,���ڰ���ʵ��ҵ������Ա�����Ϊ����ͻ����鿱����λ�Ͳ鿱��Ա��ҳ����Ĭ��

      //�����õķ����ˣ������Ŀ��զ�죿�������Ķδ���ʵ�����������һ��Ҫ�ڳ�����д���Ļ��������и��б�ά��һ��start
      //prpLscheduleMainWFDto.setScheduleObjectID("31000000");
      //prpLscheduleMainWFDto.setScheduleObjectName("�Ϻ�����ũҵ���չɷ����޹�˾");
      //prpLscheduleMainWFDto.setNextHandlerCode("00042");
      //prpLscheduleMainWFDto.setNextHandlerName("������");
      //�����õķ����ˣ������Ŀ��զ�죿�������Ķδ���ʵ�����������һ��Ҫ�ڳ�����д���Ļ��������и��б�ά��һ��end
      //Add by chenrenda end 20070716
      scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);

      //������ش��������ת��
      changeCodeToName(httpServletRequest,scheduleDto);
     //���ô�����и�����ѡ�����б���Ϣ������
      setSelectionList(httpServletRequest,scheduleDto);
      //�������鿱��Ϣ���ݵ������
      httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
      //���ø����ӱ���Ϣ������
      setSubInfo(httpServletRequest,scheduleDto,editType);
      //���ù�������һ���ڵ��ύ��������Ϣ
      if (!prpLscheduleMainWFDto.getStatus().equals("4"))  {
        getSubmitNodes(httpServletRequest);
      }else
      {
          //�Ѿ���չ����
          httpServletRequest.setAttribute("finishSubmit","");
      }
      setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
   	
      //��������Ϣ����˵�������б�׼������
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
     * ��д�鿱ҳ�漰��ѯ�鿱request������.
     * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */
    public void registDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String editType) throws Exception{
     scheduleDtoToView(httpServletRequest,registNo,editType,"1") ;
    }


    /**
     * ��ѯ��������������ѡ��Ľڵ�����
     * @param modelNo String
     * @param nodeNo String
     * @throws Exception
     */
    private void getSubmitNodes(HttpServletRequest httpServletRequest) throws Exception
    {
      String modelNo= httpServletRequest.getParameter("modelNo"); //ģ���
      String nodeNo= httpServletRequest.getParameter("nodeNo");   //�ڵ��
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
     * ���ݱ����Ų�ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo      ������
     * @param claimNo       ������
     * @throws Exception
     */

   
    /**
      * ����Dto�еĸ��ӱ��ڵ���Ϣ������
      * @param httpServletRequest ���ظ�ҳ���request
      * @param scheduleDto    �鿱��������
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           ScheduleDto scheduleDto,String editType) throws Exception
    {


    	ArrayList scheduleItemListTemp = new ArrayList();
    	ArrayList scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList() ;
    	scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
    	  //Ҫ���˵���ͬ��scheduleType������,ֻ�в鿱����Ź��˵ġ��������������_,���""
    	for (int i =0;i<scheduleItemList.size();i++) {
    		PrpLscheduleItemDto prpLscheduleItemDtoTemp =new PrpLscheduleItemDto();
            prpLscheduleItemDtoTemp =(PrpLscheduleItemDto)((ArrayList)scheduleItemList).get(i)  ;
            if (prpLscheduleItemDtoTemp.getScheduleObjectID().equals("_") ){
	            prpLscheduleItemDtoTemp.setScheduleObjectID   ("");
	            prpLscheduleItemDtoTemp.setScheduleObjectName ("");
            }
            	//���û�е��ȹ���Ĭ�Ͻ�ȥΪ0,����û�б�ѡ��
            if (prpLscheduleItemDtoTemp.getSurveyTimes()==0 )
            {
            	prpLscheduleItemDtoTemp.setSelectSend("0");
            }
            //add by liyanjie 2005-12-11 start �Ƚ�ClaimComCode�Ƿ񱾵��ȹ�˾,���ǵ���Ȩ����
            HttpSession session = httpServletRequest.getSession();
            UserDto   user     = (UserDto)session.getAttribute("user");
            
            if( (!"SHOW".equals(editType)) && prpLscheduleItemDtoTemp.getClaimComCode() != null && 
            		prpLscheduleItemDtoTemp.getClaimComCode().length()>0){
            	//����ʲô�ж��߼�����������
            }else{
            	//reason,���ڰ���ʵ��ҵ������Ա�����Ϊ����ͻ���������λ�Ͷ�����Ա��ҳ����Ĭ��

            	//�޸ģ����ڳ�����д�������ȥ��start
            	//prpLscheduleItemDtoTemp.setScheduleObjectID("31000000");
            	//prpLscheduleItemDtoTemp.setScheduleObjectName("�Ϻ�����ũҵ���չɷ����޹�˾");
            	//prpLscheduleItemDtoTemp.setNextHandlerCode("00042");
            	//prpLscheduleItemDtoTemp.setNextHandlerName("������");

                   scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
            	//end
            }
            
            //add by liyanjie 2005-12-11 end
          
           
    	}

    	PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
    	prpLscheduleItemDto.setScheduleItemList(scheduleItemListTemp);
    	httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
	}

    

    /**
     * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpLscheduleDto    �鿱��������
     * @throws Exception
     */
   private void changeCodeToName(HttpServletRequest httpServletRequest,
                          ScheduleDto scheduleDto) throws Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();

     //(1)��ҵ������ṹ����ת��
     String claimComCode = scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode();
     String claimComName = uiCodeAction.translateComCode(claimComCode,true) ;
     scheduleDto.getPrpLscheduleMainWFDto().setClaimComName(claimComName);
     //(2)�Բ���Ա���д���
     String operatorCode = scheduleDto.getPrpLscheduleMainWFDto().getOperatorCode() ;
     String operatorName = uiCodeAction.translateUserCode(operatorCode,true);
     scheduleDto.getPrpLscheduleMainWFDto().setOperatorName(operatorName);
  }
  public void  getScheuleGetBackQueryList(HttpServletRequest httpServletRequest,
                          String conditions,String scheduleType) throws Exception{
  //��õ���ȡ�ص�������б�
   getScheuleCheckList(httpServletRequest,conditions,"schel");

}



/**
* ��ѯ�鿱���ȵ���Ϣ
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
    
    //ÿҳ��ʾ������
        String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        //
        if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";

      int intRecordPerPage=Integer.parseInt(recordPerPage) ;
      int intPageNo=Integer.parseInt(pageNo) ;
      TurnPageDto turnPageDto = new TurnPageDto();//��ҳ����
      
      int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
      int count=0;
      
    if (scheduleType.equals("sched") ){
        
    	//��������!!!
    	//�ж���������
         	  count= uiScheduleAction.findScheduleMainWFCountByConditon(conditions);
         	  if(maxQueryCount!=0&&count>maxQueryCount){   
                 throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
            }
    	
    	PageRecord pageRecord = (PageRecord)uiScheduleAction.findByConditions(conditions,intPageNo,intRecordPerPage) ;
    	
      scheduleListTemp = (ArrayList)pageRecord.getResult();
      
      
         
      //1.ת������Ա������,�͵���Ա
   Iterator it = scheduleListTemp.iterator() ;

   while (it.hasNext() )
   {
     PrpLscheduleMainWFDto prpLscheduleMainWFDto1 = new PrpLscheduleMainWFDto();
     prpLscheduleMainWFDto1 =(PrpLscheduleMainWFDto) it.next();
     prpLscheduleMainWFDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleMainWFDto1.getOperatorCode(),true)) ;
     scheduleList.add(prpLscheduleMainWFDto1);
   }
   prpLscheduleMainWFDto.setScheduleList(scheduleList);
   
   //��ѯ������һҳ�Ľṹ��
         turnPageDto.setResultList(scheduleList);
          //��ҳ������
      //��ǰҳ��
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //һҳ������
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
         turnPageDto.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //��������
         turnPageDto.setCondition(conditions);
    prpLscheduleMainWFDto.setTurnPageDto(turnPageDto) ;
         
    httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto);
    }else{
    
     //��������
     //�ж���������
         	  count= uiScheduleAction.findScheduleItemCountByConditon(conditions);
         	  if(maxQueryCount!=0&&count>maxQueryCount){   
                 throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
            }
     
    	PageRecord pageRecord = (PageRecord)uiScheduleAction.findItemByConditions(conditions,intPageNo,intRecordPerPage) ;
    	
      scheduleListTemp = (ArrayList)pageRecord.getResult();
      //1.ת������Ա������,�͵���Ա
   Iterator it = scheduleListTemp.iterator() ;

   while (it.hasNext() )
   {
     PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
     prpLscheduleItemDto1 =(PrpLscheduleItemDto) it.next();
     prpLscheduleItemDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleItemDto1.getOperatorCode(),true)) ;
     scheduleList.add(prpLscheduleItemDto1);
   }
      prpLscheduleItemDto.setScheduleItemList(scheduleList);
      //��ѯ������һҳ�Ľṹ��
         turnPageDto.setResultList(scheduleList);
          //��ҳ������
      //��ǰҳ��
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //һҳ������
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
         turnPageDto.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //��������
         turnPageDto.setCondition(conditions);
         prpLscheduleItemDto.setTurnPageDto(turnPageDto) ;
    
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
    }
    
    
   

    

   }

	
	/**
	 * ����Dto�еĸ��ӱ��ڵ���Ϣ������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param scheduleDto    �鿱��������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception
			{
		ArrayList scheduleItemListTemp = new ArrayList();
		ArrayList scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList() ;
		scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
		//Ҫ���˵���ͬ��scheduleType������,ֻ�в鿱����Ź��˵ġ��������������_,���""
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
				//��������ǵ��鿱ȥ�˵Ļ����ڶ�������ﲻ��ѡ�񣬳��ǲ鿱�Ѿ��ύ�ˡ���
			}
//			���û�е��ȹ���Ĭ�Ͻ�ȥΪ0,����û�б�ѡ��
			if (prpLscheduleItemDtoTemp.getSurveyTimes()==0 )
			{
				prpLscheduleItemDtoTemp.setSelectSend("0");
			}
			//���뼯��
			scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
		}
//		System.out .println("scheduleItemListTemp.size()"+scheduleItemListTemp.size()) ;
		PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleItemList(scheduleItemListTemp);
		httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
		 
			}
	
	/**
	 * ��ȡѡ�����б���е���������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLscheduleDto    �鿱��������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception
			{
		UICodeAction uiCodeAction = new UICodeAction();
		
		
		//�õ����������б�
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//�õ����Ƶ�ɫ�б�
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
			}
	

	
	
	
	//add by zhaolu 20060724 start
	//reason:��ѯ������Ϣ��ѯ��ҳ
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
            
			//1.ת������Ա������,�͵���Ա
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
		       //��ѯ������һҳ�Ľṹ�� 
		       turnPageDto.setResultList(scheduleList);
		       //��ǰҳ��
		       turnPageDto.setPageNo(pageRecord.getPageNo());
		       //һҳ������
		       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		       //��ѯ�����Ľ��������
		       turnPageDto.setTotalCount(pageRecord.getCount());
		       //�����ܵ�ҳ��
		       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		       //��������
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
			
			//1.ת������Ա������,�͵���Ա
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
		       //��ѯ������һҳ�Ľṹ�� 
		       turnPageDto.setResultList(scheduleList);
		       //��ǰҳ��
		       turnPageDto.setPageNo(pageRecord.getPageNo());
		       //һҳ������
		       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		       //��ѯ�����Ľ��������
		       turnPageDto.setTotalCount(pageRecord.getCount());
		       //�����ܵ�ҳ��
		       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		       //��������
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
		 * ��ñ���������������Ӧʡ�ݴ���,���� ��ҵ�����󡣣�Ҫ���ڵ���ʱֻ��ѡ��÷ֹ�˾��ص����й�˾���е��ȣ�
		 * ComCode�ĵ�1��2��λ����Ӧ��ʡ�ݴ��룬��"3400000000"�е�"34"����ʡ�ݴ���
		 */
		String provinceCode = comCode.substring(0,2);
		httpServletRequest.setAttribute("provinceCode",provinceCode);
	}	


 }
