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
 * ��֤����Certify
 * <p>Title: ��������������֤action  </p>
 * <p>Description: ��������������֤action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UICertifyImgAction
{
  /**
   * ���浥֤
   * @param CertifyDto����֤����DTO
   * @throws Exception   
   */ 
  public void save(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
  	CertifyImgInsertCommand certifyImgInsertCommand = new CertifyImgInsertCommand(prpLcertifyImgDto);
  	certifyImgInsertCommand.execute(); 
  }    
 
  /**  
   * ɾ����֤
   * @param certifyNo����֤��
   * @throws Exception       
   */
  public void delete(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
  	CertifyImgDeleteCommand certifyImgDeleteCommand = new CertifyImgDeleteCommand(prpLcertifyImgDto);
  	certifyImgDeleteCommand.execute();
  }
 
  /**  
   * ���µ�֤
   * @param certifyNo����֤��
   * @throws Exception      
   */
  public void update(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
  	CertifyImgUpdateCommand certifyImgUpdateCommand = new CertifyImgUpdateCommand(prpLcertifyImgDto);
  	certifyImgUpdateCommand.execute(); 
  }
  /**
   * ��õ�֤��Ϣ
   * @param  certifyNo����֤��
   * @return ��֤����
   * @throws Exception
   */
  public PrpLcertifyImgDto findByPrimaryKey(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,UserException,Exception
  {
  	CertifyImgFindByPrimaryKeyCommand certifyImgFindByPrimaryKeyCommand = new CertifyImgFindByPrimaryKeyCommand(prpLcertifyImgDto);
  	PrpLcertifyImgDto prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)certifyImgFindByPrimaryKeyCommand.execute();

    return prpLcertifyImgDtoTemp;
  }    

  /**
  * ��õ�֤��Ϣ
  * @param  conditions����ѯ����
  * @return ��֤����
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
  	CertifyImgFindByConditionsCommand certifyImgFindByConditionsCommand = new CertifyImgFindByConditionsCommand(conditions);

     return (Collection)certifyImgFindByConditionsCommand.execute();
  }

}
