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
 * 核损对象VerifyLoss
 * <p>Title: 车险理赔样本核损action  </p>
 * <p>Description: 车险理赔样本核损action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIVerifyLossAction
{
  /**
   * 保存核损
   * @param VerifyLossDto：核损对象DTO
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto) throws SQLException,Exception
  {
  	VerifyLossSaveCommand verifyLossSaveCommand = new VerifyLossSaveCommand(verifyLossDto);
  	verifyLossSaveCommand.execute();
  }

   /**
   * 保存核损带工作流
   * @param VerifyLossDto：核损对象DTO
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	VerifyLossSaveCommand verifyLossSaveCommand = new VerifyLossSaveCommand(verifyLossDto,workFlowDto);
  	verifyLossSaveCommand.execute();
  }

  /**
   * 删除核损
   * @param registNo：核损号
   * @throws Exception
   */
  public void delete(String registNo,String nodeType) throws SQLException,Exception
  {
    VerifyLossDeleteCommand verifyLossDeleteCommand = new VerifyLossDeleteCommand(registNo,nodeType);
  	verifyLossDeleteCommand.execute();
  }

  /**
   * 获得核损信息
   * @param  registNo：核损号
   * @return 核损对象
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
   * 判断核损号是否存在
   * @param registNo:核损号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode,String nodeType) throws SQLException,Exception
  {
  	VerifyLossIsExistCommand verifyLossIsExistCommand = new VerifyLossIsExistCommand(registNo,lossItemCode,nodeType);
  	return ((Boolean)verifyLossIsExistCommand.execute()).booleanValue();
  }
  /**
  * 获得核损信息
  * @param  conditions：查询条件
  * @return 核损对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLverifyLossFindByConCommand prpLverifyLossFindByConCommand = new PrpLverifyLossFindByConCommand(conditions);

     return (Collection)prpLverifyLossFindByConCommand.execute();
  }

  /**
  * 获得核损查询信息
  * @param  conditions：查询条件
  * @param  nodeType：节点类型
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions,String nodeType) throws SQLException,Exception
  {
     VerifyLossQueryCommand verifyLossQueryCommand = new VerifyLossQueryCommand(conditions,nodeType);

     return (Collection)verifyLossQueryCommand.executeCommand();
  }

  /**
   * 获得核损信息
   * @param  registNo：核损号
   * @return 核损对象
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
