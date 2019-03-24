package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:����ڵ�״̬ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

 public class DAAClaimStatusViewHelper extends ClaimStatusViewHelper
 {
	 
	private static Log logger = LogFactory.getLog(DAAClaimStatusViewHelper.class);
	
	public DAAClaimStatusViewHelper() {
	}

    /**
	 * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param userCode
	 *            ������Ա����
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */
    public void getClaimStats(HttpServletRequest httpServletRequest,String status,String userCode,String nodeType) throws Exception
    {
      logger.info("���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ���� like �������Ż���");
      //���������״̬���û�ID����SQL where �Ӿ�
      status = StringUtils.rightTrim(status) ;
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode
				+ "' AND NodeType = '" + nodeType + "' order by businessno,operatedate desc";
      //��ѯ����ڵ�״̬��Ϣ
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();

      //�õ����б���������Ϣ
      Collection claimStatusList = new ArrayList();
      claimStatusList  = (Collection)uiClaimStatusAction.findByConditions(conditions) ;
      Iterator iterator = claimStatusList.iterator();
      while(iterator.hasNext()){
        PrpLclaimStatusDto prpLclaimStatusDtoTemp = (PrpLclaimStatusDto)iterator.next();
        if(prpLclaimStatusDtoTemp.getTypeFlag().equals("1")){
          prpLclaimStatusDtoTemp.setTypeFlagName("1-������");
        }else if(prpLclaimStatusDtoTemp.getTypeFlag().equals("0")){
          prpLclaimStatusDtoTemp.setTypeFlagName("0-��Ա����");  
        }else if(prpLclaimStatusDtoTemp.getTypeFlag().equals("3")){
          prpLclaimStatusDtoTemp.setTypeFlagName("3-�Ʋ�����");
        }else if(prpLclaimStatusDtoTemp.getTypeFlag().equals("4")){
          prpLclaimStatusDtoTemp.setTypeFlagName("4-ȫ��/�ƶ�ȫ��");
        }else{
          prpLclaimStatusDtoTemp.setTypeFlagName("����");
        }
      }
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setClaimList(claimStatusList);
      prpLclaimStatusDto.setStatus(status);
      prpLclaimStatusDto.setEditType("SHOW");
      if (status.equals("0")||status.equals("1")||status.equals("2")||status.equals("3")||status.equals("7"))
      {
      	prpLclaimStatusDto.setEditType("EDIT");
      }
      if(status.equals("1")||status.equals("6")){ 
      	prpLclaimStatusDto.setEditType("ADD");
      }
      prpLclaimStatusDto.setNodeType(nodeType);
      prpLclaimStatusDto.setHandlerCode(userCode);
      changeCodeToName(httpServletRequest,prpLclaimStatusDto);
      httpServletRequest.setAttribute("prpLclaimStatusDto",prpLclaimStatusDto) ;
    }

     /**
     * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param status         ����״̬
     * @param userCode       ������Ա����
     * @param nodeType       �ڵ�����
     * @param otherWhere     ������������
     * @throws Exception
     */
    public void getClaimStats(HttpServletRequest httpServletRequest,String status,String userCode,String nodeType,String otherWhere) throws Exception
    {
      logger.info("���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ ��like �������Ż���");
      //���������״̬���û�ID����SQL where �Ӿ�
      status = StringUtils.rightTrim(status) ;
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      if (otherWhere.equals("")) {
			conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode
					+ "' AND NodeType = '" + nodeType + "'";
		} else {
			conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode
					+ "' AND (NodeType = '" + nodeType + "')" + " AND " + otherWhere;
		}
      // ��ѯ����ڵ�״̬��Ϣ
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();

      //�õ����б���������Ϣ
      Collection claimStatusList = new ArrayList();
      claimStatusList  = (Collection)uiClaimStatusAction.findByConditions(conditions) ;
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setClaimList(claimStatusList);
      prpLclaimStatusDto.setEditType((String)httpServletRequest.getAttribute("editType")) ;
      prpLclaimStatusDto.setStatus(status);
      prpLclaimStatusDto.setNodeType(nodeType);
      prpLclaimStatusDto.setHandlerCode(userCode);
      httpServletRequest.setAttribute("prpLclaimStatusDto",prpLclaimStatusDto) ;
    }

    /**
     * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param status         ����״̬
     * @param userCode       ������Ա����
     * @param nodeType       �ڵ�����
     * @throws Exception
     */
    public void getClaimStatsStat(HttpServletRequest httpServletRequest,String userCode,String nodeType) throws Exception
    {
      logger.info("���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ���� LIKE �������Ż�");
      //���������״̬���û�ID����SQL where �Ӿ�
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      conditions = conditions + " PRPLCLAIMSTATUS.handlerCode = '" + userCode
				+ "' AND PRPLCLAIMSTATUS.NODETYPE = '" + nodeType + "'";
      //��ʼʱ��
      String statStartDate = httpServletRequest.getParameter("statStartDate");

      if(statStartDate != null && statStartDate.trim().length()>0){
        conditions = conditions +" AND PRPLCLAIMSTATUS.OperateDate >= '" + statStartDate +"'";
      }
      //����ʱ��
      String statEndDate = httpServletRequest.getParameter("statEndDate");
      if(statEndDate != null && statEndDate.trim().length()>0){
        conditions = conditions +" AND PRPLCLAIMSTATUS.OperateDate <= '" + statEndDate +"'";
      }

      //��ѯ����ڵ�״̬��Ϣ
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();

      //�õ����б���������Ϣ
      Collection claimStatusStatList = new ArrayList();
      claimStatusStatList  = (Collection)uiClaimStatusAction.getStatStatus(conditions) ;
      StatStatusDto statStatusDto = new StatStatusDto();
      statStatusDto.setStatStatusList(claimStatusStatList);
      statStatusDto.setEditType((String)httpServletRequest.getAttribute("editType")) ;
      statStatusDto.setNodeType(nodeType);
      statStatusDto.setUserCode(userCode);
      changeCodeToName(httpServletRequest,statStatusDto);
      httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;

      UICodeAction uiCodeAction = new UICodeAction();
      Collection claimStatusList = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
      httpServletRequest.setAttribute("claimStatusList", claimStatusList);
    }

     /**
      * ����ClaimStatus�е��Ѿ����õĴ������ݣ��Դ����������ת��
      * @param httpServletRequest ���ظ�ҳ���request
      * @param prpClaimDto    ������������
      * @param ClaimDto      ��ѯ����������
      * @throws Exception
      */
    private void changeCodeToName(HttpServletRequest httpServletRequest,
                           StatStatusDto statStatusDto) throws Exception
    {
       UICodeAction uiCodeAction = new UICodeAction();
       Collection collection = statStatusDto.getStatStatusList();
       Iterator iterator = collection.iterator();
       StatStatusDto statStatusDto1 = null;
       while(iterator.hasNext()){
         statStatusDto1 = (StatStatusDto)iterator.next();
         statStatusDto1.setUserName(uiCodeAction.translateUserCode(statStatusDto1.getUserCode(),true));
       }
    }

     /**
      * ����ClaimStatus�е��Ѿ����õĴ������ݣ��Դ����������ת��
      * @param httpServletRequest ���ظ�ҳ���request
      * @param prpClaimDto    ������������
      * @param ClaimDto      ��ѯ����������
      * @throws Exception
      */
    private void changeCodeToName(HttpServletRequest httpServletRequest,
                           PrpLclaimStatusDto prpLclaimStatusDto) throws Exception
    {
       UICodeAction uiCodeAction = new UICodeAction();
       Collection collection = prpLclaimStatusDto.getClaimList();
       Iterator iterator = collection.iterator();
       PrpLclaimStatusDto prpLclaimStatusDto1 = null;
       while(iterator.hasNext()){
         prpLclaimStatusDto1 = (PrpLclaimStatusDto)iterator.next();
         prpLclaimStatusDto1.setHandlerCode(uiCodeAction.translateUserCode(prpLclaimStatusDto1.getHandlerCode(),true));
       }
    }
 }
