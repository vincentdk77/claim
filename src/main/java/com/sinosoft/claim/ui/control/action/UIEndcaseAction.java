package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.EndcaseDeleteCommand;
import com.sinosoft.claim.ui.model.EndcaseFindByCommand;
import com.sinosoft.claim.ui.model.EndcaseFindByConCommand;
import com.sinosoft.claim.ui.model.EndcaseIsExistCommand;
import com.sinosoft.claim.ui.model.EndcaseQueryCommand;
import com.sinosoft.claim.ui.model.EndcaseSaveCommand;
import com.sinosoft.claim.ui.model.PrpLendcaseFindByConCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �᰸����Endcase
 * <p>Title: ��������᰸  </p>
 * <p>Description: ��������᰸</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIEndcaseAction
{
  /**
   * ����᰸
   * @param EndcaseDto���᰸����DTO
   * @throws Exception
   */
  public void save(EndcaseDto endcaseDto) throws SQLException,Exception
  {
      EndcaseSaveCommand endcaseSaveCommand = new EndcaseSaveCommand(endcaseDto);
      endcaseSaveCommand.execute();
  }
  
  
   /**
   * ����᰸��������
   * @param EndcaseDto���᰸����DTO
   * @throws Exception
   */
  public void save(EndcaseDto endcaseDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
      EndcaseSaveCommand endcaseSaveCommand = new EndcaseSaveCommand(endcaseDto,workFlowDto);
      endcaseSaveCommand.execute();
  }
  
  /**
   * ɾ���᰸
   * @param caseNo���᰸��
   * @throws Exception
   */
  public void delete(String caseNo) throws SQLException,Exception
  {
      EndcaseDeleteCommand endcaseDeleteCommand = new EndcaseDeleteCommand(caseNo);
      endcaseDeleteCommand.execute();
  }

  /**
   * ��ý᰸��Ϣ
   * @param  caseNo���᰸��
   * @return �᰸����
   * @throws Exception
   */
  public EndcaseDto findByPrimaryKey(String caseNo,String claimNo,String certiNo,String certiType) throws SQLException,UserException,Exception
  {
    EndcaseFindByConCommand endcaseFindByConCommand = new EndcaseFindByConCommand(caseNo,claimNo,certiNo,certiType);
    EndcaseDto endcaseDto = (EndcaseDto)endcaseFindByConCommand.execute();

    if (endcaseDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+caseNo+")");
    }
    return endcaseDto;
  }

  /**
   * �жϽ᰸���Ƿ����
   * @param caseNo:�᰸��
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String caseNo,String claimNo,String certiNo,String certiType) throws SQLException,Exception
  {
      EndcaseIsExistCommand endcaseIsExistCommand = new EndcaseIsExistCommand(caseNo,claimNo,certiNo,certiType);
      return ((Boolean)endcaseIsExistCommand.execute()).booleanValue();
  }

  /**
 * ��ý᰸��Ϣ
 * @param  conditions����ѯ����
 * @return �᰸����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLendcaseFindByConCommand prpLendcaseFindByConCommand = new PrpLendcaseFindByConCommand(conditions);
    return (Collection)prpLendcaseFindByConCommand.execute();
 }

  /**
  * ��ý᰸��ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     EndcaseQueryCommand endcaseQueryCommand = new EndcaseQueryCommand(conditions);

     return (Collection)endcaseQueryCommand.executeCommand();
  }
  
  /**
   * ��ý᰸��Ϣ
   * @param  caseNo���᰸��
   * @return �᰸����
   * @throws Exception
   */
  public EndcaseDto findByPrimaryKey(String claimNo) throws SQLException,UserException,Exception
  {
    EndcaseFindByCommand endcaseFindByCommand = new EndcaseFindByCommand(claimNo);
    EndcaseDto endcaseDto = (EndcaseDto)endcaseFindByCommand.execute(); 

    if (endcaseDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+claimNo+")");
    }
    return endcaseDto;
  }

}
