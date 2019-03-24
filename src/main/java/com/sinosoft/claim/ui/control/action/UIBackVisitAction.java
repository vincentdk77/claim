package com.sinosoft.claim.ui.control.action;


import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.BackVisitDeleteCommand;
import com.sinosoft.claim.ui.model.BackVisitFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.BackVisitSaveCommand;
import com.sinosoft.claim.ui.model.PrpLbackVisitGetCountCommand;
import com.sinosoft.claim.ui.model.SwfLogFindByConditionsCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �طö���Claim
 * <p>Title: ��������ط�action  </p>
 * <p>Description: ��������ط�action</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class UIBackVisitAction
{
  /**
   * ����طö���
   * @param backVisitDto �طö������DTO
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto) throws SQLException,Exception
  {
    BackVisitSaveCommand  backVisitSaveCommand = new BackVisitSaveCommand(backVisitDto);
    backVisitSaveCommand.execute();
  }

   /**
   * ����طö����������
   * @param backVisitDto���طö������DTO
   * @param workFlowDto
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
     BackVisitSaveCommand  backVisitSaveCommand = new BackVisitSaveCommand(backVisitDto,workFlowDto);
     backVisitSaveCommand.execute();
  }

  /**
   * ɾ���طö���
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws Exception
   */
  public void delete(int  backVisitNo,String registNo,String backVisitType) throws SQLException,Exception
  {
    BackVisitDeleteCommand backVisitDeleteCommand = new BackVisitDeleteCommand(backVisitNo,registNo,backVisitType);
    backVisitDeleteCommand.execute();
  }

   /**
   * ɾ���طö���(����������)
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @param workFlowDto
   * @throws Exception
   */
  public void delete(int backVisitNo,String registNo,String backVisitType,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    BackVisitDeleteCommand backVisitDeleteCommand = new BackVisitDeleteCommand(backVisitNo,registNo,backVisitType,workFlowDto);
    backVisitDeleteCommand.execute();
  }

  /**
  * ��ûطö���
  * @param  claimNo���ⰸ��
  * @return ��������
  * @throws Exception
  */
 public BackVisitDto findByPrimaryKey(int backVisitNo,String registNo,String backVisitType) throws SQLException,UserException,Exception
 {
   BackVisitFindByPrimaryKeyCommand backVisitFindByPrimaryKeyCommand = new BackVisitFindByPrimaryKeyCommand(backVisitNo,registNo,backVisitType);
   BackVisitDto backVisitDto = (BackVisitDto)backVisitFindByPrimaryKeyCommand.execute();

   if (backVisitDto == null)
   {
     throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+backVisitNo+","+registNo+","+backVisitType+")");
   }
   return backVisitDto;
 }

 /**
  *ȡ�ü�¼��
  *@param conditions ��ѯ����
  *@throws SQLException
  *@throws Exception
  */
 public int  getBackVisitCount(String conditions) throws SQLException,Exception 
 {
     Integer backVisitCount = new Integer(0) ;
     PrpLbackVisitGetCountCommand prpLbackVisitGetCountCommand = new PrpLbackVisitGetCountCommand(conditions);
     backVisitCount = (Integer)prpLbackVisitGetCountCommand.execute();
     return backVisitCount.intValue();
 }
 /**
  *ȡ�ûط�ID��
  *@param conditions ��ѯ����
  *@throws SQLException
  *@throws Exception
  */

 public int getMaxNo(String conditions) throws Exception
 {
   int intCount = 0;
   intCount = getBackVisitCount(conditions);
   intCount = intCount +1;
   return intCount;
 }
  /**
  * ��ûط���Ϣ
  * @param  conditions����ѯ����
  * @return �طö���
  * @throws Exception 
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     SwfLogFindByConditionsCommand swfLogFindByConditionsCommand = new SwfLogFindByConditionsCommand(conditions);

     return (Collection)swfLogFindByConditionsCommand.execute();  
  } 
}
