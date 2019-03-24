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
 * 结案对象Endcase
 * <p>Title: 车险理赔结案  </p>
 * <p>Description: 车险理赔结案</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIEndcaseAction
{
  /**
   * 保存结案
   * @param EndcaseDto：结案对象DTO
   * @throws Exception
   */
  public void save(EndcaseDto endcaseDto) throws SQLException,Exception
  {
      EndcaseSaveCommand endcaseSaveCommand = new EndcaseSaveCommand(endcaseDto);
      endcaseSaveCommand.execute();
  }
  
  
   /**
   * 保存结案带工作流
   * @param EndcaseDto：结案对象DTO
   * @throws Exception
   */
  public void save(EndcaseDto endcaseDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
      EndcaseSaveCommand endcaseSaveCommand = new EndcaseSaveCommand(endcaseDto,workFlowDto);
      endcaseSaveCommand.execute();
  }
  
  /**
   * 删除结案
   * @param caseNo：结案号
   * @throws Exception
   */
  public void delete(String caseNo) throws SQLException,Exception
  {
      EndcaseDeleteCommand endcaseDeleteCommand = new EndcaseDeleteCommand(caseNo);
      endcaseDeleteCommand.execute();
  }

  /**
   * 获得结案信息
   * @param  caseNo：结案号
   * @return 结案对象
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
   * 判断结案号是否存在
   * @param caseNo:结案号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String caseNo,String claimNo,String certiNo,String certiType) throws SQLException,Exception
  {
      EndcaseIsExistCommand endcaseIsExistCommand = new EndcaseIsExistCommand(caseNo,claimNo,certiNo,certiType);
      return ((Boolean)endcaseIsExistCommand.execute()).booleanValue();
  }

  /**
 * 获得结案信息
 * @param  conditions：查询条件
 * @return 结案对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLendcaseFindByConCommand prpLendcaseFindByConCommand = new PrpLendcaseFindByConCommand(conditions);
    return (Collection)prpLendcaseFindByConCommand.execute();
 }

  /**
  * 获得结案查询信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     EndcaseQueryCommand endcaseQueryCommand = new EndcaseQueryCommand(conditions);

     return (Collection)endcaseQueryCommand.executeCommand();
  }
  
  /**
   * 获得结案信息
   * @param  caseNo：结案号
   * @return 结案对象
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
