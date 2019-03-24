package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.CertifyCombineSaveCommand;
import com.sinosoft.claim.ui.model.CertifyDeleteCommand;
import com.sinosoft.claim.ui.model.CertifyFindByConCommand;
import com.sinosoft.claim.ui.model.CertifyIsExistCommand;
import com.sinosoft.claim.ui.model.CertifyQueryCommand;
import com.sinosoft.claim.ui.model.CertifySaveCommand;
import com.sinosoft.claim.ui.model.PrpLcertifyFindByConCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
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
public class UICertifyAction
{
  /**
   * 保存单证
   * @param CertifyDto：单证对象DTO
   * @throws Exception
   */
  public void save(CertifyDto certifyDto) throws SQLException,Exception
  {
  	CertifySaveCommand certifySaveCommand = new CertifySaveCommand(certifyDto);
  	certifySaveCommand.execute();
  }
    /**
   * 保存单证带工作流
   * @param CertifyDto：单证对象DTO
   * @throws Exception
   */
  public void save(CertifyDto certifyDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CertifySaveCommand certifySaveCommand = new CertifySaveCommand(certifyDto,workFlowDto);
  	certifySaveCommand.execute();
  }
  
  /**
   * 保存并案单证带工作流
   * @param CertifyDto：单证对象DTO
   * @throws Exception
   */
  public void saveAll(CertifyDto certifyDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
	CertifyCombineSaveCommand certifyCombineSaveCommand = new CertifyCombineSaveCommand(certifyDto,workFlowDto);
	certifyCombineSaveCommand.execute();
  }

  /**
   * 删除单证
   * @param certifyNo：单证号
   * @throws Exception
   */
  public void delete(String certifyNo) throws SQLException,Exception
  {
    CertifyDeleteCommand certifyDeleteCommand = new CertifyDeleteCommand(certifyNo);
  	certifyDeleteCommand.execute();
  }

  /**
   * 获得单证信息
   * @param  certifyNo：单证号
   * @return 单证对象
   * @throws Exception
   */
  public CertifyDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	CertifyFindByConCommand certifyFindByConCommand = new CertifyFindByConCommand(registNo);
  	CertifyDto certifyDto = (CertifyDto)certifyFindByConCommand.execute();

    if (certifyDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return certifyDto;
  }

  /**
   * 判断单证号是否存在
   * @param certifyNo:单证号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String certifyNo) throws SQLException,Exception
  {
  	CertifyIsExistCommand certifyIsExistCommand = new CertifyIsExistCommand(certifyNo);
  	return ((Boolean)certifyIsExistCommand.execute()).booleanValue();
  }
  /**
  * 获得单证信息
  * @param  conditions：查询条件
  * @return 单证对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcertifyFindByConCommand prpLcertifyFindByConCommand = new PrpLcertifyFindByConCommand(conditions);

     return (Collection)prpLcertifyFindByConCommand.execute();
  }

  /**
  * 获得单证查询信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     CertifyQueryCommand certifyQueryCommand = new CertifyQueryCommand(conditions);

     return (Collection)certifyQueryCommand.executeCommand();
  }
  
  //add by zhaolu 20060803 start
//add by zhaolu 20060726 start
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws SQLException,Exception
  {
     CertifyQueryCommand certifyQueryCommand = new CertifyQueryCommand(conditions,pageNo,recordPerPage);

     return (PageRecord)certifyQueryCommand.executeCommand();
  }
  //add by zhaolu 20060726 end
  //add by zhaolu 20060803 end
  
}
