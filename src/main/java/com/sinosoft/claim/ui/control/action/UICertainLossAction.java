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
 * 定损对象CertainLoss
 * <p>Title: 车险理赔样本定损action  </p>
 * <p>Description: 车险理赔样本定损action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UICertainLossAction
{
  /** 
   * 保存定损
   * @param CertainLossDto：定损对象DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto);
  	certainLossSaveCommand.execute();
  } 
  /** 
   * 保存并案处理定损
   * @param CertainLossDto：并案处理定损对象
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDtoList);
  	certainLossSaveCommand.execute();
  } 
  /**  
   * 保存定损
   * @param CertainLossDto：定损对象DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto,checkDto,workFlowDto);
  	certainLossSaveCommand.execute();
  }
   /**
   * 保存定损带工作流
   * @param CertainLossDto：定损对象DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto,workFlowDto);
  	certainLossSaveCommand.execute();
  }
  /**
   * 保存定损带工作流
   * @param CertainLossDto：定损对象DTO
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDtoList,workFlowDtoList);
  	certainLossSaveCommand.execute();
  }
  /**
   * 保存定损带工作流
   * @param CertainLossDto：定损对象DTO
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto) throws SQLException,Exception
  {
  	CertainLossSaveCommand certainLossSaveCommand = new CertainLossSaveCommand(certainLossDto,checkDto);
  	certainLossSaveCommand.execute();
  }
  /**
   * 删除定损
   * @param registNo：定损号
   * @throws Exception
   */
  public void delete(String registNo) throws SQLException,Exception
  {
    CertainLossDeleteCommand certainLossDeleteCommand = new CertainLossDeleteCommand(registNo);
  	certainLossDeleteCommand.execute();
  }

  /**
   * 获得定损信息
   * @param  registNo：定损号
   * @return 定损对象
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
   * 判断定损号是否存在
   * @param registNo:定损号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode) throws SQLException,Exception
  {
  	CertainLossIsExistCommand certainLossIsExistCommand = new CertainLossIsExistCommand(registNo,lossItemCode);
  	return ((Boolean)certainLossIsExistCommand.execute()).booleanValue();
  }
  /**
  * 获得定损信息
  * @param  conditions：查询条件
  * @return 定损对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcertainLossFindByConCommand prpLcertainLossFindByConCommand = new PrpLcertainLossFindByConCommand(conditions);

     return (Collection)prpLcertainLossFindByConCommand.execute();
  }
  /**
  * 获得定损查询信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     CertainLossQueryCommand certainLossQueryCommand = new CertainLossQueryCommand(conditions);

     return (Collection)certainLossQueryCommand.executeCommand();
  }

  /**
   * 获得定损信息
   * @param  registNo：定损号
   * @return 定损对象
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
