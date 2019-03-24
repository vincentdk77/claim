package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.AcciCheckFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLacciCheckFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindforWorkFlowCommand;
import com.sinosoft.claim.ui.model.RegistDeleteCommand;
import com.sinosoft.claim.ui.model.RegistIsExistCommand;
import com.sinosoft.claim.ui.model.RegistQueryCommand;
import com.sinosoft.claim.ui.model.RegistSaveCommand;
import com.sinosoft.claim.ui.model.RelateNodeFindByConCommand;
import com.sinosoft.claim.ui.model.SamePolicyRegistFindByConCommand;
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
public class UIAcciCheckAction
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
   * @return ����յ������
   * @throws Exception
   */
  public AcciCheckDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	AcciCheckFindByConCommand acciCheckFindByConCommand = new AcciCheckFindByConCommand(registNo);
  	AcciCheckDto acciCheckDto = (AcciCheckDto)acciCheckFindByConCommand.execute();

    if (acciCheckDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return acciCheckDto;
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
   * ���һ�����������е�����Ϣ(�⽡�ն��еķ���)
   * @param conditions ��ѯ����
   * @return �������󼯺�
   * @throws Exception
   * */
  public Collection findByConditionsAcciCheck(String conditions) throws SQLException, Exception {
  	  PrpLacciCheckFindByConditionsCommand prpLacciCheckFindConditionsCommand = new PrpLacciCheckFindByConditionsCommand(conditions);
  	  return (Collection) prpLacciCheckFindConditionsCommand.executeCommand();
  }

}
