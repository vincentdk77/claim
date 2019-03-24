package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.EndorseDto;
import com.sinosoft.claim.ui.model.EndorseFindByConCommand;
import com.sinosoft.claim.ui.model.EndorseFindConditions;
import com.sinosoft.claim.ui.model.PrpPheadFindByConCommand;
import com.sinosoft.claim.ui.model.PrpPmainCheckStatusCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * UI批单逻辑
 * <p>Title: 车险理赔样本程序 批单action</p>
 * <p>Description: 车险理赔样本程序 批单action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author     liubvo
 * @version    1.0
 */
public class UIEndorseAction
{
  /**
   * 保存批单
   * @param endorseNo：批单对象
   * @throws Exception
   */
   /*
  public void save(EndorseDto endorseNo) throws SQLException,Exception
  {
  	EndorseSaveCommand policySaveCommand = new EndorseSaveCommand(endorseNo);
  	policySaveCommand.execute();
  }
  */
  /**
   * 删除批单
   * @param endorseNo
   * @throws Exception
   */
   /*
  public void delete(String endorseNo) throws SQLException,Exception
  {
    EndorseDeleteCommand policyDeleteCommand = new EndorseDeleteCommand(endorseNo);
  	policyDeleteCommand.execute();
  }
  */
  /**
   * 获得批单
   * @param endorseNo 批单号
   * @return 批单对象
   * @throws Exception
   */
  public EndorseDto findByPrimaryKey(String endorseNo) throws SQLException,UserException,Exception
  {
  	EndorseFindByConCommand policyFindByConCommand = new EndorseFindByConCommand(endorseNo);
    EndorseDto endorseDto = (EndorseDto)policyFindByConCommand.execute();

    if (endorseNo == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+endorseNo+")");
    }
    return endorseDto;
  }
  /**
   * 获得批单
   * @param endorseNo 批单号
   * @return 批单对象
   * @throws Exception
   */
  public EndorseDto findByConditions(String policyNo) throws SQLException,UserException,Exception
  {
  	EndorseFindConditions endorseFindConditions = new EndorseFindConditions(policyNo);
    EndorseDto endorseDto = (EndorseDto)endorseFindConditions.execute();

    if (policyNo == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+policyNo+")");
    }
    return endorseDto;
  }
  /**
   * 获得批单
   * @param endorseNo 批单号
   * @return 批单对象
   * @throws Exception
   */
  public Collection findByPrpPheadConditions(String conditions) throws SQLException,UserException,Exception
  { 
  	PrpPheadFindByConCommand prpPheadFindByConCommand = new PrpPheadFindByConCommand(conditions);
    Collection collection = (Collection)prpPheadFindByConCommand.execute();

    if (conditions == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrpPheadConditions("+conditions+")");
    }
    return collection; 
  } 
  
  //modify by liuyanmei add 20051111 satrt
  //reason:交验此保单是否处于批改状态
  public int  checkStatus(String policyNo) throws Exception
  { 
  	int checkFlag =0;
  	PrpPmainCheckStatusCommand prpPmainCheckStatusCommand = new PrpPmainCheckStatusCommand(policyNo);
  	checkFlag =((Integer) prpPmainCheckStatusCommand.execute()).intValue(); 
  	return checkFlag;
  }
//modify by liuyanmei add 20051111 end
  /**
   * 判断批单是否存在
   * @param endorseNo
   * @return 是/否
   * @throws Exception
   */
 /* 
  public boolean isExist(String endorseNo) throws SQLException,Exception
  {
  	EndorseIsExistCommand policyIsExistCommand = new EndorseIsExistCommand(endorseNo);
  	return ((Boolean)policyIsExistCommand.execute()).booleanValue();
  }
 */
}
