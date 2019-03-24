package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.PrpLverifyLossFindByConCommand;
import com.sinosoft.claim.ui.model.VerifyLossDeleteCommand;
import com.sinosoft.claim.ui.model.VerifyLossFindByConCommand;
import com.sinosoft.claim.ui.model.VerifyLossIsExistCommand;
import com.sinosoft.claim.ui.model.VerifyLossQueryCommand;
import com.sinosoft.claim.ui.model.VerifyLossSaveCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �������VerifyLoss
 * <p>Title: ����������������action  </p>
 * <p>Description: ����������������action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIVerifyLossAction
{
  /**
   * �������
   * @param VerifyLossDto���������DTO
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto) throws SQLException,Exception
  {
  	VerifyLossSaveCommand verifyLossSaveCommand = new VerifyLossSaveCommand(verifyLossDto);
  	verifyLossSaveCommand.execute();
  }

   /**
   * ��������������
   * @param VerifyLossDto���������DTO
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	VerifyLossSaveCommand verifyLossSaveCommand = new VerifyLossSaveCommand(verifyLossDto,workFlowDto);
  	verifyLossSaveCommand.execute();
  }

  /**
   * ɾ������
   * @param registNo�������
   * @throws Exception
   */
  public void delete(String registNo,String nodeType) throws SQLException,Exception
  {
    VerifyLossDeleteCommand verifyLossDeleteCommand = new VerifyLossDeleteCommand(registNo,nodeType);
  	verifyLossDeleteCommand.execute();
  }

  /**
   * ��ú�����Ϣ
   * @param  registNo�������
   * @return �������
   * @throws Exception
   */
  public VerifyLossDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	VerifyLossFindByConCommand verifyLossFindByConCommand = new VerifyLossFindByConCommand(registNo);
  	VerifyLossDto verifyLossDto = (VerifyLossDto)verifyLossFindByConCommand.execute();

    if (verifyLossDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return verifyLossDto;
  }

  /**
   * �жϺ�����Ƿ����
   * @param registNo:�����
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode,String nodeType) throws SQLException,Exception
  {
  	VerifyLossIsExistCommand verifyLossIsExistCommand = new VerifyLossIsExistCommand(registNo,lossItemCode,nodeType);
  	return ((Boolean)verifyLossIsExistCommand.execute()).booleanValue();
  }
  /**
  * ��ú�����Ϣ
  * @param  conditions����ѯ����
  * @return �������
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLverifyLossFindByConCommand prpLverifyLossFindByConCommand = new PrpLverifyLossFindByConCommand(conditions);

     return (Collection)prpLverifyLossFindByConCommand.execute();
  }

  /**
  * ��ú����ѯ��Ϣ
  * @param  conditions����ѯ����
  * @param  nodeType���ڵ�����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */

  public Collection findByQueryConditions(String conditions,String nodeType) throws SQLException,Exception
  {
     VerifyLossQueryCommand verifyLossQueryCommand = new VerifyLossQueryCommand(conditions,nodeType);

     return (Collection)verifyLossQueryCommand.executeCommand();
  }

  /**
   * ��ú�����Ϣ
   * @param  registNo�������
   * @return �������
   * @throws Exception
   */
  public VerifyLossDto findByPrimaryKey(String registNo,String lossItemCode,String nodeType) throws SQLException,UserException,Exception
  {
  	VerifyLossFindByConCommand verifyLossFindByConCommand = new VerifyLossFindByConCommand(registNo,lossItemCode,nodeType);
  	VerifyLossDto verifyLossDto = (VerifyLossDto)verifyLossFindByConCommand.execute();
 
    if (verifyLossDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return verifyLossDto;
  }
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(String conditions,String nodeType,int pageNo,int recordPerPage) throws SQLException,Exception
  {
     VerifyLossQueryCommand verifyLossQueryCommand = new VerifyLossQueryCommand(conditions,nodeType,pageNo,recordPerPage);

     return (PageRecord)verifyLossQueryCommand.executeCommand();
  }
  //add by zhaolu 20060803 end

}
