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
 * 预赔对象Prepay
 * <p>Title: 车险理赔预赔  </p>
 * <p>Description: 车险理赔预赔</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIPrepayAction
{
  /**
   * 保存预赔带工作流
   * @param PrepayDto：预赔对象DTO
   * @throws Exception
   */
  public void save(PrepayDto prepayDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
          PrepaySaveCommand prepaySaveCommand = new PrepaySaveCommand(prepayDto,workFlowDto);
          prepaySaveCommand.execute();
  }
  /**
   * 保存预赔
   * @param PrepayDto：预赔对象DTO
   * @throws Exception
   */
  public void save(PrepayDto prepayDto) throws SQLException,Exception
  {
          PrepaySaveCommand prepaySaveCommand = new PrepaySaveCommand(prepayDto);
          prepaySaveCommand.execute();
  }
 
 
  /**
   * 删除预赔
   * @param prepayNo：预赔号
   * @throws Exception
   */
  public void delete(String PrepayNo) throws SQLException,Exception
  {
    PrepayDeleteCommand prepayDeleteCommand = new PrepayDeleteCommand(PrepayNo);
          prepayDeleteCommand.execute();
  }

  /**
   * 获得预赔信息
   * @param  prepayNo：预赔号
   * @return 预赔对象
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
   * 判断预赔号是否存在
   * @param prepayNo:预赔号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String prepayNo) throws SQLException,Exception
  {
          PrepayIsExistCommand prepayIsExistCommand = new PrepayIsExistCommand(prepayNo);
          return ((Boolean)prepayIsExistCommand.execute()).booleanValue();
  }

  /**
 * 获得预赔信息
 * @param  conditions：查询条件
 * @return 预赔对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLprepayFindByConCommand prpLprepayFindByConCommand = new PrpLprepayFindByConCommand(conditions);

    return (Collection)prpLprepayFindByConCommand.execute();
 }

  /**
  * 获得预赔查询信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     PrepayQueryCommand prepayQueryCommand = new PrepayQueryCommand(conditions);

     return (Collection)prepayQueryCommand.executeCommand();
  }
  
   /**
   * 获得预赔信息
   * @param  conditions：查询条件
   * @return 预赔对象
   * @throws Exception
   */
   public Collection findByApproveConditions(String conditions) throws SQLException,Exception
   {
     PrepayApproveQueryCommand prepayApproveQueryCommand = new PrepayApproveQueryCommand(conditions);

     return (Collection)prepayApproveQueryCommand.executeCommand();
   }  
   
  /**
   * 保存预赔
   * @param PrepayDto：预赔对象DTO
   * @throws Exception
  * Add By liubvo 2004-09-08 Reason:预赔复核update
   */
  public void approve(String prepayNo,String userCode,String underWriteFlag) throws SQLException,Exception
  {
  	PrepayApproveCommand prepayApproveCommand = new PrepayApproveCommand(prepayNo,userCode,underWriteFlag);
  	prepayApproveCommand.execute();
  } 
}
