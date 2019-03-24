package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.CertainLossDeleteCommand;
import com.sinosoft.claim.ui.model.CertainLossFindByConCommand;
import com.sinosoft.claim.ui.model.CertainLossIsExistCommand;
import com.sinosoft.claim.ui.model.CertainLossQueryCommand;
import com.sinosoft.claim.ui.model.CertainLossSaveCommand;
import com.sinosoft.claim.ui.model.PrpLcertainLossFindByConCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �������CertainLoss
 * <p>Title: ����������������action  </p>
 * <p>Description: ����������������action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UICertainLossAction
{
  /** 
   * ���涨��
   * @param CertainLossDto���������DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto);
  	certainLossSaveCommand.execute();
  } 
  /** 
   * ���沢��������
   * @param CertainLossDto���������������
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDtoList);
  	certainLossSaveCommand.execute();
  } 
  /**  
   * ���涨��
   * @param CertainLossDto���������DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto,checkDto,workFlowDto);
  	certainLossSaveCommand.execute();
  }
   /**
   * ���涨���������
   * @param CertainLossDto���������DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto,workFlowDto);
  	certainLossSaveCommand.execute();
  }
  /**
   * ���涨���������
   * @param CertainLossDto���������DTO
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDtoList,workFlowDtoList);
  	certainLossSaveCommand.execute();
  }
  /**
   * ���涨���������
   * @param CertainLossDto���������DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto,checkDto);
  	certainLossSaveCommand.execute();
  }
  /**
   * ɾ������
   * @param registNo�������
   * @throws Exception
   */
  public void delete(String registNo) throws SQLException,Exception
  {
    CertainLossDeleteCommand certainLossDeleteCommand = new CertainLossDeleteCommand(registNo);
  	certainLossDeleteCommand.execute();
  }

  /**
   * ��ö�����Ϣ
   * @param  registNo�������
   * @return �������
   * @throws Exception
   */
  public CertainLossDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	CertainLossFindByConCommand certainLossFindByConCommand = new CertainLossFindByConCommand(registNo);
  	CertainLossDto certainLossDto = (CertainLossDto)certainLossFindByConCommand.execute();

    if (certainLossDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return certainLossDto;
  }

  /**
   * �ж϶�����Ƿ����
   * @param registNo:�����
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode) throws SQLException,Exception
  {
  	CertainLossIsExistCommand certainLossIsExistCommand = new CertainLossIsExistCommand(registNo,lossItemCode);
  	return ((Boolean)certainLossIsExistCommand.execute()).booleanValue();
  }
  /**
  * ��ö�����Ϣ
  * @param  conditions����ѯ����
  * @return �������
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcertainLossFindByConCommand prpLcertainLossFindByConCommand = new PrpLcertainLossFindByConCommand(conditions);

     return (Collection)prpLcertainLossFindByConCommand.execute();
  }
  /**
  * ��ö����ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     CertainLossQueryCommand certainLossQueryCommand = new CertainLossQueryCommand(conditions);

     return (Collection)certainLossQueryCommand.executeCommand();
  }

  /**
   * ��ö�����Ϣ
   * @param  registNo�������
   * @return �������
   * @throws Exception
   */
  public CertainLossDto findByPrimaryKey(String registNo,String lossItemCode) throws SQLException,UserException,Exception
  {
  	CertainLossFindByConCommand certainLossFindByConCommand = new CertainLossFindByConCommand(registNo,lossItemCode); 
  	CertainLossDto certainLossDto = (CertainLossDto)certainLossFindByConCommand.execute();

    if (certainLossDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return certainLossDto;
  }

  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(String conditions,int pageNo,int recordPerPage) throws SQLException,Exception
  {
	  CertainLossQueryCommand certainLossQueryCommand = new CertainLossQueryCommand(conditions,pageNo,recordPerPage);
      return (PageRecord)certainLossQueryCommand.executeCommand();
  }
  //add by zhaolu 20060803 end

}
