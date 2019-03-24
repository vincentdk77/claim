package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.PrepayApproveCommand;
import com.sinosoft.claim.ui.model.PrepayApproveQueryCommand;
import com.sinosoft.claim.ui.model.PrepayDeleteCommand;
import com.sinosoft.claim.ui.model.PrepayFindByConCommand;
import com.sinosoft.claim.ui.model.PrepayIsExistCommand;
import com.sinosoft.claim.ui.model.PrepayQueryCommand;
import com.sinosoft.claim.ui.model.PrepaySaveCommand;
import com.sinosoft.claim.ui.model.PrpLprepayFindByConCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * Ԥ�����Prepay
 * <p>Title: ��������Ԥ��  </p>
 * <p>Description: ��������Ԥ��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIPrepayAction
{
  /**
   * ����Ԥ���������
   * @param PrepayDto��Ԥ�����DTO
   * @throws Exception
   */
  public void save(PrepayDto prepayDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
          PrepaySaveCommand prepaySaveCommand = new PrepaySaveCommand(prepayDto,workFlowDto);
          prepaySaveCommand.execute();
  }
  /**
   * ����Ԥ��
   * @param PrepayDto��Ԥ�����DTO
   * @throws Exception
   */
  public void save(PrepayDto prepayDto) throws SQLException,Exception
  {
          PrepaySaveCommand prepaySaveCommand = new PrepaySaveCommand(prepayDto);
          prepaySaveCommand.execute();
  }
 
 
  /**
   * ɾ��Ԥ��
   * @param prepayNo��Ԥ���
   * @throws Exception
   */
  public void delete(String PrepayNo) throws SQLException,Exception
  {
    PrepayDeleteCommand prepayDeleteCommand = new PrepayDeleteCommand(PrepayNo);
          prepayDeleteCommand.execute();
  }

  /**
   * ���Ԥ����Ϣ
   * @param  prepayNo��Ԥ���
   * @return Ԥ�����
   * @throws Exception
   */
  public PrepayDto findByPrimaryKey(String prepayNo) throws SQLException,UserException,Exception
  {
          PrepayFindByConCommand prepayFindByConCommand = new PrepayFindByConCommand(prepayNo);
          PrepayDto prepayDto = (PrepayDto)prepayFindByConCommand.execute();

    if (prepayDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+prepayNo+")");
    }
    return prepayDto;
  }

  /**
   * �ж�Ԥ����Ƿ����
   * @param prepayNo:Ԥ���
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String prepayNo) throws SQLException,Exception
  {
          PrepayIsExistCommand prepayIsExistCommand = new PrepayIsExistCommand(prepayNo);
          return ((Boolean)prepayIsExistCommand.execute()).booleanValue();
  }

  /**
 * ���Ԥ����Ϣ
 * @param  conditions����ѯ����
 * @return Ԥ�����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLprepayFindByConCommand prpLprepayFindByConCommand = new PrpLprepayFindByConCommand(conditions);

    return (Collection)prpLprepayFindByConCommand.execute();
 }

  /**
  * ���Ԥ���ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     PrepayQueryCommand prepayQueryCommand = new PrepayQueryCommand(conditions);

     return (Collection)prepayQueryCommand.executeCommand();
  }
  
   /**
   * ���Ԥ����Ϣ
   * @param  conditions����ѯ����
   * @return Ԥ�����
   * @throws Exception
   */
   public Collection findByApproveConditions(String conditions) throws SQLException,Exception
   {
     PrepayApproveQueryCommand prepayApproveQueryCommand = new PrepayApproveQueryCommand(conditions);

     return (Collection)prepayApproveQueryCommand.executeCommand();
   }  
   
  /**
   * ����Ԥ��
   * @param PrepayDto��Ԥ�����DTO
   * @throws Exception
  * Add By liubvo 2004-09-08 Reason:Ԥ�⸴��update
   */
  public void approve(String prepayNo,String userCode,String underWriteFlag) throws SQLException,Exception
  {
  	PrepayApproveCommand prepayApproveCommand = new PrepayApproveCommand(prepayNo,userCode,underWriteFlag);
  	prepayApproveCommand.execute();
  } 
}
