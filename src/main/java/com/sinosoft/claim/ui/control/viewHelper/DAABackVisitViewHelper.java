package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIBackVisitAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;


/**
 * <p>Title: DAABackVisitViewHelper</p>
 * <p>Description:�ط�ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2005</p>
 * @author ����������Ŀ��
 * @version 1.0
 * <br>
 */

 public class DAABackVisitViewHelper extends BackVisitViewHelper
 {
    public static final int  Context_LENGTH = 80; //context�ֶεĳ���
    /**
    * Ĭ�Ϲ��췽��
    */
    public DAABackVisitViewHelper()
    {
    }

    /**
     * ����ط�ҳ����������
     * @param httpServletRequest
     * @return BackVisitDto
     * @throws Exception
     */
     public BackVisitDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       //����BackVisitDto����
        BackVisitDto backVisitDto = super.viewToDto(httpServletRequest);

       //����ط���ѯ��Ϣ��ʼ
       ArrayList prpLbackVisitQueDtoList = new ArrayList();
       PrpLbackVisitQueDto prpLbackVisitQueDto = null;
       String strCount = httpServletRequest.getParameter("txtRecordNum");
       int intCount = Integer.parseInt(strCount);
       int j=0;
       String strQuestionCode = "";
       String strQuestionName = "";
       String strQuestionRemark = "";
       String strVisitBackQueRes = "";
       for(int i=0;i<intCount;i++)
       {
         j = i+1;

         strQuestionCode = "txtQuestionCode"+j;
         strQuestionName = "txtQuestionName"+j;
         strQuestionRemark = "txtQuestionRemark"+j;
         strVisitBackQueRes = "VisitBackQue"+j;
         prpLbackVisitQueDto = new PrpLbackVisitQueDto();
         prpLbackVisitQueDto.setBackVisitID(backVisitDto.getPrpLbackVisitDto().getBackVisitID());
         prpLbackVisitQueDto.setRegistNo(httpServletRequest.getParameter("prpLbackVisitRegistNo"));
         prpLbackVisitQueDto.setBackVisitType(httpServletRequest.getParameter("backVisitType"));
         prpLbackVisitQueDto.setQuestionCode(httpServletRequest.getParameter(strQuestionCode));
         prpLbackVisitQueDto.setQuestionName(httpServletRequest.getParameter(strQuestionName));
         prpLbackVisitQueDto.setQuestionResult(httpServletRequest.getParameter(strVisitBackQueRes));
         prpLbackVisitQueDto.setQuestionRemark(httpServletRequest.getParameter(strQuestionRemark));
         prpLbackVisitQueDto.setQuestionType("0");//�ݶ�Ϊȱʡ����
         prpLbackVisitQueDto.setFlag("");
         prpLbackVisitQueDtoList.add(prpLbackVisitQueDto);
System.out.println("----j----"+j+"|"+strVisitBackQueRes+"|"+strQuestionRemark);
       }
       //�ӵ�ArrayList��
       backVisitDto.setPrpLbackVisitQueDtoList(prpLbackVisitQueDtoList);
       //����ط���ѯ��Ϣ����

       //����طÿͻ������Ϣ��ʼ
       ArrayList prpLbackVisitTextDtoList = new ArrayList();
       //ȡ�ÿͻ����
       String strContext = httpServletRequest.getParameter("prpLbackVisitTextContent");
       String[] contexts = StringUtils.split(strContext,Context_LENGTH);
       PrpLbackVisitTextDto prpLbackVisitTextDto = null;
       String context = "";
       for (int i = 0; i < contexts.length; i++) {
           context = contexts[i];
           prpLbackVisitTextDto = new PrpLbackVisitTextDto();
           prpLbackVisitTextDto.setBackVisitID(backVisitDto.getPrpLbackVisitDto().getBackVisitID());
           prpLbackVisitTextDto.setRegistNo(httpServletRequest.getParameter("prpLbackVisitRegistNo"));
           prpLbackVisitTextDto.setBackVisitType(httpServletRequest.getParameter("backVisitType"));
           prpLbackVisitTextDto.setLineNo(i+1);
           prpLbackVisitTextDto.setOperatorCode(backVisitDto.getPrpLbackVisitDto().getHandlerCode());
           prpLbackVisitTextDto.setContent(context);
           prpLbackVisitTextDto.setFlag("");
           prpLbackVisitTextDtoList.add(prpLbackVisitTextDto);
System.out.println("----jText----"+i);
       }
       //�ӵ�ArrayList��
       backVisitDto.setPrpLbackVisitTextDtoList(prpLbackVisitTextDtoList);
       //����طÿͻ������Ϣ����
       return backVisitDto;
    }
    /**
     * ��ʼ��ҳ����Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param editType ��������
     * @throws Exception
     */
    public void registDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String editType) throws Exception
    {
      //������ر���
      UICodeAction uiCodeAction = new UICodeAction();

      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���ط���
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

      //���ݱ�����õ���������
      UIRegistAction uiRegistAction = new UIRegistAction();
      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);

      //Ҫ��ȡҵ������,�ݶ�Ϊ�鿱����
      String strBackVisitType = httpServletRequest.getParameter("lossTypeFlag");

      //editType��û���õ�

     //���ݲ�ѯ�������������ݣ���prpLbackVisitDto��ֵ
      PrpLbackVisitDto prpLbackVisitDto = new PrpLbackVisitDto();
      PrpLbackVisitQueDto prpLbackVisitQueDto = new PrpLbackVisitQueDto();
      PrpLbackVisitTextDto prpLbackVisitTextDto = new PrpLbackVisitTextDto();
      BackVisitDto backVisitDto = new BackVisitDto();

      //���ûط���Ϣ��ʼ
      prpLbackVisitDto.setRegistNo(registNo);
      prpLbackVisitDto.setBackVisitType(strBackVisitType);
      prpLbackVisitDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
      prpLbackVisitDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
      prpLbackVisitDto.setInsuredCode(registDto.getPrpLregistDto().getInsuredCode());
      prpLbackVisitDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
      prpLbackVisitDto.setCustomType("1");//��ʱ����Ĭ��Ϊ�����û�
      prpLbackVisitDto.setPhone(registDto.getPrpLregistDto().getPhoneNumber());

      prpLbackVisitDto.setAddress(registDto.getPrpLregistDto().getInsuredAddress());
      prpLbackVisitDto.setBackVisitTime((new DateTime(DateTime.current(),DateTime.YEAR_TO_MINUTE)).toString());
      prpLbackVisitDto.setCustomOpinion("4");//�a��Ϊ����
      //���ûط���Ϣ����

      //��ѯ�ط���ѯ���뿪ʼ
      String strFlag = ""; //ҵ�����ͱ�־
      if(strBackVisitType.equals("1"))
      {
        strFlag = "1";
      }else if(strBackVisitType.equals("2"))
      {
        strFlag = "2";
      }
      String strQueryCondition = " codecode in (select codecode from prpdcoderisk where substr(codecode,1,1) = '"+strFlag+"' and riskcode = '0000' and codetype = 'BackVisitCode' ) and ValidStatus='1' and codetype = 'BackVisitCode'";
      String strCodeType = "BackVisitCode";
      List prpdCodeList = (ArrayList)uiCodeAction.findByConditions(strCodeType,strQueryCondition,0,0);
      //��ѯ�ط���ѯ�������

      //��request��ѹ�����
      httpServletRequest.setAttribute("prpdCodeList", prpdCodeList);
      httpServletRequest.setAttribute("prpLbackVisitDto", prpLbackVisitDto);
      //httpServletRequest.setAttribute("prpLbackVisitQueDto", prpLbackVisitQueDto);
      //httpServletRequest.setAttribute("prpLbackVisitTextDto", prpLbackVisitTextDto);
      httpServletRequest.setAttribute("backVisitTypeList", ICollections.getBackVisitTypeList());
      httpServletRequest.setAttribute("customOpinionList", ICollections.getCustomOpinionList());
      httpServletRequest.setAttribute("backVisitDto", backVisitDto);
      //�����ӱ�����ݵ�����
      setSubInfo(httpServletRequest,backVisitDto);

    }

    /**
     * ��ʼ��ҳ����Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param editType ��������
     * @throws Exception
     */
    public void backVisitDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String backVisitType,String editType) throws Exception
    {
      //������ر���
      UICodeAction uiCodeAction = new UICodeAction();
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���ط���
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

      //���ݱ�����õ���������
      UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();
      BackVisitDto backVisitDto = uiBackVisitAction.findByPrimaryKey(1,registNo,backVisitType);

      //Ҫ��ȡҵ������,�ݶ�Ϊ�鿱����
      String strBackVisitType = "1";

      //editType��û���õ�

     //���ݲ�ѯ�������������ݣ���prpLbackVisitDto��ֵ
      PrpLbackVisitDto prpLbackVisitDto = backVisitDto.getPrpLbackVisitDto();
      PrpLbackVisitQueDto prpLbackVisitQueDto = new PrpLbackVisitQueDto();
      PrpLbackVisitTextDto prpLbackVisitTextDto = new PrpLbackVisitTextDto();

      //��ѯ�ط���ѯ���뿪ʼ
      String strFlag = ""; //ҵ�����ͱ�־
      if(strBackVisitType.equals("1"))
      {
        strFlag = "1";
      }else if(strBackVisitType.equals("2"))
      {
        strFlag = "2";
      }
      String strQueryCondition = " codecode in (select codecode from prpdcoderisk where substr(codecode,1,1) = '"+strFlag+"' and riskcode = '0000' and codetype = 'BackVisitCode' ) and ValidStatus='1' and codetype = 'BackVisitCode'";
      String strCodeType = "BackVisitCode";
      List prpdCodeList = (ArrayList)uiCodeAction.findByConditions(strCodeType,strQueryCondition,0,0);
      //��ѯ�ط���ѯ�������

      //��request��ѹ�����
      httpServletRequest.setAttribute("prpdCodeList", prpdCodeList);
      httpServletRequest.setAttribute("prpLbackVisitDto", prpLbackVisitDto);
      //httpServletRequest.setAttribute("prpLbackVisitQueDto", prpLbackVisitQueDto);
      //httpServletRequest.setAttribute("prpLbackVisitTextDto", prpLbackVisitTextDto);
      httpServletRequest.setAttribute("backVisitTypeList", ICollections.getBackVisitTypeList());
      httpServletRequest.setAttribute("customOpinionList", ICollections.getCustomOpinionList());
      httpServletRequest.setAttribute("backVisitDto", backVisitDto);
      //�����ӱ�����ݵ�����
      setSubInfo(httpServletRequest,backVisitDto);
    }

    /**
      * ����backVisitDto�еĸ��ӱ��ڵ���Ϣ������
      * @param httpServletRequest ���ظ�ҳ���request
      * @param certainLossDto    �����������
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           BackVisitDto backVisitDto) throws Exception
    {
      /*
       //��������嵥�����б�׼������
       ArrayList prpLbackVisitQueList = new ArrayList();
       PrpLrepairFeeDto prpLrepairFeeDto  = new PrpLrepairFeeDto();
       arrayList1 = certainLossDto.getPrpLrepairFeeDtoList();
       prpLrepairFeeDto.setRepairFeeList(arrayList1);
       httpServletRequest.setAttribute("prpLrepairFeeDto", prpLrepairFeeDto);
      */
       //�ط��ı������б�׼������
       List prpLbackVisitQueList = new ArrayList();
       prpLbackVisitQueList = (ArrayList)backVisitDto.getPrpLbackVisitTextDtoList();
       PrpLbackVisitTextDto prpLbackVisitTextDto = new PrpLbackVisitTextDto();
       String tempContext = "";
       if(prpLbackVisitQueList!=null&&prpLbackVisitQueList.size()>0){
         for (int i = 0; i < prpLbackVisitQueList.size(); i++) {
           PrpLbackVisitTextDto prpLbackVisitTextDtoTemp = (PrpLbackVisitTextDto)prpLbackVisitQueList.get(i);
           tempContext = tempContext+prpLbackVisitTextDtoTemp.getContent();
         }
       }
       prpLbackVisitTextDto.setContent(tempContext);
       httpServletRequest.setAttribute("prpLbackVisitTextDto", prpLbackVisitTextDto);
    }

      /**
       * ���ݱ�����,������,����״̬�����ƺ��룬����ʱ���ѯ������Ϣ
       * @param httpServletRequest ���ظ�ҳ���request
       * @param registNo       ������
       * @param policyNo       ������
       * @throws Exception
       */
      public void getBackVisitList(HttpServletRequest httpServletRequest,
                                               String registNo,
                                               String policyNo,
                                               String statusCollect,
                                               String operateDate) throws Exception
      {
         //��������ı����ţ��ⰸ������SQL where �Ӿ�
         registNo = StringUtils.rightTrim(registNo) ;
         policyNo = StringUtils.rightTrim(policyNo) ;
         statusCollect = StringUtils.rightTrim(statusCollect);
         operateDate = StringUtils.rightTrim(operateDate);
         String strSign = httpServletRequest.getParameter("OperateDateSign");

         //Reason:�ڲ�ѯ��������������"������"��ѯ����
         String conditions = " 1=1 ";
         conditions = conditions + StringConvert.convertString("businessNo",registNo,httpServletRequest.getParameter("RegistNoSign"));
         conditions = conditions + StringConvert.convertString("policyNo",policyNo,httpServletRequest.getParameter("PolicyNoSign"));

         if(statusCollect.trim().length()>0){
            conditions = conditions + " AND (nodeStatus in (" +statusCollect+ ")) ";
          }
         if(operateDate != null && !operateDate.trim().equals("")){
           conditions = conditions+ " and handleTime  "+ strSign +"'"+ operateDate +"'";

           // " and "+ strName + strSign +"to_date('"+ strValue +"') "
         }
          conditions = conditions+" and nodeType='backv' ";
         //��ѯ������Ϣ
         UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();
         //�õ����б���������Ϣ
         Collection backVisitList = new ArrayList();
         System.out.println("start to search,please waiting ..."+conditions);
         backVisitList  = (Collection)uiBackVisitAction.findByConditions(conditions) ;
         System.out.println("end search,please waiting for result...");
         SwfLogDto swfLogDto = new SwfLogDto();
         swfLogDto.setSwfLogList(backVisitList);
         System.out.println("finish add list");
         System.out.println("editType="+httpServletRequest.getParameter("editType"));
         swfLogDto.setEditType(httpServletRequest.getParameter("editType")) ;
         swfLogDto.setWhereString(conditions);
         httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
      }

       /**
        * ��ѯ���Խ��д���Ĳ鿱������Ϣ������ӹ������ϻ���ˣ�
        * @param httpServletRequest HttpServletRequest
        * @param conditions String
        * @throws Exception
        */
       public void getBeforeTaskList(HttpServletRequest httpServletRequest,String conditions,String nodeType) throws Exception
       {
         UIWorkFlowAction UIWorkFlowAction= new UIWorkFlowAction();
         SwfLogDto swfLogDto = new SwfLogDto();
         Collection swfLogList = new ArrayList();
         UICodeAction uiCodeAction = new UICodeAction();

         swfLogList=UIWorkFlowAction.findNodesByConditions(conditions);
         System.out.println(conditions);
         swfLogDto.setSwfLogList(swfLogList);
         swfLogDto.setNodeType(nodeType);
         swfLogDto.setNodeName(uiCodeAction.translateCodeCode("ClaimNodeType",nodeType,true) );
         httpServletRequest.setAttribute("swfLogDto",swfLogDto);

       }

 }

