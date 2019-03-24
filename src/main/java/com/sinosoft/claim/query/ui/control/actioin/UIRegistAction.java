package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.model.PolicyForRegistQueryCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindforWorkFlowCommand;
import com.sinosoft.claim.ui.model.RegistCancelSaveCommand;
import com.sinosoft.claim.ui.model.RegistDeleteCommand;
import com.sinosoft.claim.query.ui.model.RegistFindByConCommand;
import com.sinosoft.claim.ui.model.RegistIsExistCommand;
import com.sinosoft.claim.ui.model.RegistQueryCommand;
import com.sinosoft.claim.ui.model.RegistSaveCommand;
import com.sinosoft.claim.ui.model.RelateNodeFindByConCommand;
import com.sinosoft.claim.ui.model.SamePolicyRegistFindByConCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * ��������Regist
 * <p>Title: ����������������action  </p>
 * <p>Description: ����������������action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIRegistAction
{
  /**
   * ���汨��
   * @param RegistDto����������DTO
   * @throws Exception
   */
  public void save(RegistDto registDto) throws SQLException,Exception
  {
  	RegistSaveCommand registSaveCommand = new RegistSaveCommand(registDto);
  	registSaveCommand.execute();
  }


   /**
   * ���汨����������
   * @param RegistDto����������DTO
   * @throws Exception
   */
  public void save(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	RegistSaveCommand registSaveCommand = new RegistSaveCommand(registDto,workFlowDto);
  	registSaveCommand.execute();
  }
  /**
   * ɾ������
   * @param registNo��������
   * @throws Exception
   */
  public void delete(String registNo) throws SQLException,Exception
  {
    RegistDeleteCommand registDeleteCommand = new RegistDeleteCommand(registNo);
  	registDeleteCommand.execute();
  }

  /**
   * ��ñ�����Ϣ
   * @param  registNo��������
   * @return ��������
   * @throws Exception
   */
  public RegistDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	RegistFindByConCommand registFindByConCommand = new RegistFindByConCommand(registNo);
  	RegistDto registDto = (RegistDto)registFindByConCommand.execute();

    if (registDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return registDto;
  }

  /**
   * �жϱ������Ƿ����
   * @param registNo:������
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String registNo) throws SQLException,Exception
  {
  	RegistIsExistCommand registIsExistCommand = new RegistIsExistCommand(registNo);
  	return ((Boolean)registIsExistCommand.execute()).booleanValue();
  }
  /**
  * ��ñ�����Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLregistFindByConCommand prpLregistFindByConCommand = new PrpLregistFindByConCommand(conditions);

     return (Collection)prpLregistFindByConCommand.execute();
  }

  /**
   * ��ñ�����Ϣ
   * @param  policyno ������
   * @return �������󼯺�
   * @throws Exception
   */

  public Collection findRegistsByPolicyno(String policyno) throws SQLException,Exception
  {
//	  //��һ�ַ���
//	  return new BLRegistFacade().findByPolicyno(policyno);
	  
	  //�ڶ��ַ���(����ʹ�õ�һ�ַ���,��DB����ֶ�����װ��BL��)
	  String conditions = "policyno = '"+policyno+"' order by reportDate,reportHour";
	  PrpLregistFindByConCommand prpLregistFindByConCommand = new PrpLregistFindByConCommand(conditions);	  
	  return (Collection)prpLregistFindByConCommand.execute();
  }
  
  /**
   * ���ݱ����Ż�øñ������Ѿ�δ�����
   * @param registNo
   * @return
 * @throws Exception 
   */
  public CompensateFeeDto getCompensateFeeByRegistNo(String registNo) throws Exception{
	  CompensateFeeDto compensateFeeDto = null;
	  UICodeAction uiCodeAction = new UICodeAction();
	  UICompensateAction uiCompensateAction = new UICompensateAction();
	  //���ݱ����Ż����Ӧ��������
	  String claimNo = uiCodeAction.translateBusinessCode(registNo ,true);
//	  if(claimNo!=null&&claimNo.trim().length()>0){
		  compensateFeeDto = uiCompensateAction.findCompensateFeeByClaimNo(claimNo);
//	  }
		  
	  return compensateFeeDto;
  }
  
  /**
   * ��ñ�����ѯ��Ϣ
   * @param  conditions����ѯ����
   * @return ��������
   * @throws Exception
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
   public PageRecord findByQueryConditions(String conditions,String pageNo,String recordPerPage) throws SQLException,Exception
   { 
      RegistQueryCommand registQueryCommand = new RegistQueryCommand(conditions,pageNo,recordPerPage);

      return (PageRecord)registQueryCommand.executeCommand();
   }
  
  /**
  * ��ñ�����ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */
  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     RegistQueryCommand registQueryCommand = new RegistQueryCommand(conditions);

     return (Collection)registQueryCommand.executeCommand();
  }

  public Collection findSamePolicyRegist(String policyNo) throws Exception {
    String conditions = " prplregist.policyNo ='" + policyNo + "' order by registNo";

    SamePolicyRegistFindByConCommand SamePolicyRegistFindByConCommand = new
        SamePolicyRegistFindByConCommand(conditions);

    return (Collection) SamePolicyRegistFindByConCommand.execute();
  }
  /**
  * ��ñ�����Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  */
  public Collection getWorkFlowList(String conditions) throws SQLException,Exception
  {
     PrpLregistFindforWorkFlowCommand prpLregistFindforWorkFlowCommand = new PrpLregistFindforWorkFlowCommand(conditions);
     return (Collection)prpLregistFindforWorkFlowCommand.execute();
  }
  /**
   * �����صĽڵ���Ϣ
   * @param  registNo��������
   * @return ��������
   * @throws Exception
   */
  public CaseRelateNodeDto relateNode(String registNo) throws SQLException,UserException,Exception
  {
    RelateNodeFindByConCommand relateNodeFindByConCommand = new RelateNodeFindByConCommand(registNo);
    CaseRelateNodeDto caseRelateNodeDto = (CaseRelateNodeDto)relateNodeFindByConCommand.execute();
    return caseRelateNodeDto;
  }

    /**
   * ���汨��ע����Ϣ
   * @param RegistDto����������DTO
   * @throws Exception
   */
  public void saveRegistCancel(RegistDto registDto) throws SQLException,Exception
  {
  	RegistCancelSaveCommand registCancelSaveCommand = new RegistCancelSaveCommand(registDto);
  	registCancelSaveCommand.execute();
  }
  
  /**
   * ���汨��ע����Ϣ��������
   * @param RegistDto����������DTO
   * @param WorkFlowDto������������DTO
   * @throws Exception
   */
  public void saveRegistCancel(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	RegistCancelSaveCommand registCancelSaveCommand = new RegistCancelSaveCommand(registDto,workFlowDto);
  	registCancelSaveCommand.execute();
  }
	/**
	 * ��õ����������,��ȡ���ʵı����б�
	 * ��Ԫ��ֲ�ո��Ի�����
	 * @param  conditions����ѯ����
	 * @return ��������
	 * @throws Exception 
	 */
	
	public Collection findForRegistNoConditions(String strPolicyNo) throws SQLException,Exception
	{
		BLRegistFacade blRegistFacade = new BLRegistFacade();
		return blRegistFacade.findForPrpLclaimConditions(strPolicyNo);
	}

}
