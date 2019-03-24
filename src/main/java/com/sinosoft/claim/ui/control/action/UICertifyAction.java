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
 * ��֤����Certify
 * <p>Title: ��������������֤action  </p>
 * <p>Description: ��������������֤action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UICertifyAction
{
  /**
   * ���浥֤
   * @param CertifyDto����֤����DTO
   * @throws Exception
   */
  public void save(CertifyDto certifyDto) throws SQLException,Exception
  {
  	CertifySaveCommand certifySaveCommand = new CertifySaveCommand(certifyDto);
  	certifySaveCommand.execute();
  }
    /**
   * ���浥֤��������
   * @param CertifyDto����֤����DTO
   * @throws Exception
   */
  public void save(CertifyDto certifyDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CertifySaveCommand certifySaveCommand = new CertifySaveCommand(certifyDto,workFlowDto);
  	certifySaveCommand.execute();
  }
  
  /**
   * ���沢����֤��������
   * @param CertifyDto����֤����DTO
   * @throws Exception
   */
  public void saveAll(CertifyDto certifyDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
	CertifyCombineSaveCommand certifyCombineSaveCommand = new CertifyCombineSaveCommand(certifyDto,workFlowDto);
	certifyCombineSaveCommand.execute();
  }

  /**
   * ɾ����֤
   * @param certifyNo����֤��
   * @throws Exception
   */
  public void delete(String certifyNo) throws SQLException,Exception
  {
    CertifyDeleteCommand certifyDeleteCommand = new CertifyDeleteCommand(certifyNo);
  	certifyDeleteCommand.execute();
  }

  /**
   * ��õ�֤��Ϣ
   * @param  certifyNo����֤��
   * @return ��֤����
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
   * �жϵ�֤���Ƿ����
   * @param certifyNo:��֤��
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String certifyNo) throws SQLException,Exception
  {
  	CertifyIsExistCommand certifyIsExistCommand = new CertifyIsExistCommand(certifyNo);
  	return ((Boolean)certifyIsExistCommand.execute()).booleanValue();
  }
  /**
  * ��õ�֤��Ϣ
  * @param  conditions����ѯ����
  * @return ��֤����
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcertifyFindByConCommand prpLcertifyFindByConCommand = new PrpLcertifyFindByConCommand(conditions);

     return (Collection)prpLcertifyFindByConCommand.execute();
  }

  /**
  * ��õ�֤��ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
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
