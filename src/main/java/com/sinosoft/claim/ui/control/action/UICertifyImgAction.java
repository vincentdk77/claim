package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.ui.model.CertifyImgDeleteCommand;
import com.sinosoft.claim.ui.model.CertifyImgFindByConditionsCommand;
import com.sinosoft.claim.ui.model.CertifyImgFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.CertifyImgInsertCommand;
import com.sinosoft.claim.ui.model.CertifyImgUpdateCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 单证对象Certify
 * <p>Title: 车险理赔样本单证action  </p>
 * <p>Description: 车险理赔样本单证action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UICertifyImgAction
{
  /**
   * 保存单证
   * @param CertifyDto：单证对象DTO
   * @throws Exception   
   */ 
  public void save(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
  	CertifyImgInsertCommand certifyImgInsertCommand = new CertifyImgInsertCommand(prpLcertifyImgDto);
  	certifyImgInsertCommand.execute(); 
  }    
 
  /**  
   * 删除单证
   * @param certifyNo：单证号
   * @throws Exception       
   */
  public void delete(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
  	CertifyImgDeleteCommand certifyImgDeleteCommand = new CertifyImgDeleteCommand(prpLcertifyImgDto);
  	certifyImgDeleteCommand.execute();
  }
 
  /**  
   * 更新单证
   * @param certifyNo：单证号
   * @throws Exception      
   */
  public void update(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
  	CertifyImgUpdateCommand certifyImgUpdateCommand = new CertifyImgUpdateCommand(prpLcertifyImgDto);
  	certifyImgUpdateCommand.execute(); 
  }
  /**
   * 获得单证信息
   * @param  certifyNo：单证号
   * @return 单证对象
   * @throws Exception
   */
  public PrpLcertifyImgDto findByPrimaryKey(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,UserException,Exception
  {
  	CertifyImgFindByPrimaryKeyCommand certifyImgFindByPrimaryKeyCommand = new CertifyImgFindByPrimaryKeyCommand(prpLcertifyImgDto);
  	PrpLcertifyImgDto prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)certifyImgFindByPrimaryKeyCommand.execute();

    return prpLcertifyImgDtoTemp;
  }    

  /**
  * 获得单证信息
  * @param  conditions：查询条件
  * @return 单证对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
  	CertifyImgFindByConditionsCommand certifyImgFindByConditionsCommand = new CertifyImgFindByConditionsCommand(conditions);

     return (Collection)certifyImgFindByConditionsCommand.execute();
  }

}
