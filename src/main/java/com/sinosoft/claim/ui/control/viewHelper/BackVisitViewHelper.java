package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.ui.control.action.UIBackVisitAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
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

 public abstract class BackVisitViewHelper
 {
    /**
    * Ĭ�Ϲ��췽��
    */
    public BackVisitViewHelper()
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
      BackVisitDto backVisitDto = new BackVisitDto();
      
      //��ҳ���ȡҵ������
      String strBackVisitType =  StringUtils.rightTrim(httpServletRequest.getParameter("backVisitType"));
      
      //ȡ�ûطõǼǺ�
      //1Ϊ�鿱�طã�2Ϊ����ط�
      String strConditions  = "";
      strConditions = "BackVisitType = '"+strBackVisitType+"'";
      UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();
      
      //int intBackVisitID = uiBackVisitAction.getMaxNo(strConditions);
      int intBackVisitID = 1;//Ӧ���Ƕ�ÿ�������������ӵ�(��ʱ�Ĵ���ʽ)
      
      //ȡ�û���Ϣ
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String strComCode  = user.getComCode() ;
      String strUserCode = user.getUserCode();
      String strUserName = user.getUserName();
      
      //����ط�������Ϣ��ʼ
      PrpLbackVisitDto prpLbackVisitDto = new PrpLbackVisitDto();
      prpLbackVisitDto.setBackVisitID(intBackVisitID);
      prpLbackVisitDto.setRegistNo(httpServletRequest.getParameter("prpLbackVisitRegistNo"));
      prpLbackVisitDto.setPolicyNo(httpServletRequest.getParameter("prpLbackVisitPolicyNo"));
      prpLbackVisitDto.setLicenseNo(httpServletRequest.getParameter("prpLbackVisitLicenseNo"));
      prpLbackVisitDto.setInsuredCode(httpServletRequest.getParameter("prpLbackVisitInsuredCode"));
      prpLbackVisitDto.setInsuredName(httpServletRequest.getParameter("prpLbackVisitInsuredName"));
      prpLbackVisitDto.setCustomType("");//��ʱ��ʵ��
      prpLbackVisitDto.setPhone(httpServletRequest.getParameter("prpLbackVisitPhone"));
      prpLbackVisitDto.setFax(httpServletRequest.getParameter("prpLbackVisitFax"));
      prpLbackVisitDto.setPostCode(httpServletRequest.getParameter("prpLbackVisitPostCode"));
      prpLbackVisitDto.setEmail(httpServletRequest.getParameter("prpLbackVisitEmail"));
      prpLbackVisitDto.setAddress(httpServletRequest.getParameter("prpLbackVisitAddress"));
      prpLbackVisitDto.setBackVisitType(httpServletRequest.getParameter("backVisitType"));
      prpLbackVisitDto.setHandlerCode(httpServletRequest.getParameter("strUserCode"));
      prpLbackVisitDto.setHandlerName(httpServletRequest.getParameter("strUserName"));
      prpLbackVisitDto.setHandleDept(httpServletRequest.getParameter("strComCode"));
      prpLbackVisitDto.setBackVisitTime(httpServletRequest.getParameter("prpLbackVisitBackVisitTime"));
      prpLbackVisitDto.setCustomOpinion(httpServletRequest.getParameter("customOpinion"));
      prpLbackVisitDto.setDeliverDepart("");//��ʱ��ʵ��
      prpLbackVisitDto.setDeliverTime("");//��ʱ��ʵ��
      prpLbackVisitDto.setDeliverPerson("");//��ʱ��ʵ��
      prpLbackVisitDto.setDeliverBackTime("");//��ʱ��ʵ��
      prpLbackVisitDto.setBackCustomTime("");//��ʱ��ʵ��
      prpLbackVisitDto.setHurryFlag("");  //��ʱ��ʵ��
      prpLbackVisitDto.setStatus("1"); //1�ݶ�Ϊ�»طã�Ӧ��ҳ��ȡֵ
      prpLbackVisitDto.setFlag("");
      prpLbackVisitDto.setLinkerName(httpServletRequest.getParameter("prpLbackLinkerName"));
      
      //�ӵ�ArrayList��
      backVisitDto.setPrpLbackVisitDto(prpLbackVisitDto);
      //����ط�������Ϣ����
      
      /*---------------------�طò���״̬����prpLclaimStatus----��ʼ-------*/
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      prpLclaimStatusDto.setBusinessNo(prpLbackVisitDto.getRegistNo() );
      prpLclaimStatusDto.setPolicyNo(prpLbackVisitDto.getPolicyNo());
      prpLclaimStatusDto.setNodeType("backv");
      prpLclaimStatusDto.setSerialNo(Integer.parseInt(prpLbackVisitDto.getBackVisitType()) );
      prpLclaimStatusDto.setRiskCode(BusinessRuleUtil.getRiskCode(prpLbackVisitDto.getRegistNo(),"RegistNo"));
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��ʵ����
      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      //prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getOperatorCode() );
      prpLclaimStatusDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      backVisitDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      /*---------------------�طò���״̬����prpLclaimStatus----����-------*/
      
      return backVisitDto;
    }
 }
