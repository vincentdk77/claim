package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.ui.model.PrpLrecaseSaveCommand;
import com.sinosoft.claim.ui.model.PrpLrecaseUpdateCommand;
import com.sinosoft.claim.ui.model.ReCaseFindByConCommand;
import com.sinosoft.claim.ui.model.ReCaseFindByPrimaryCommand;
import com.sinosoft.claim.ui.model.RecaseGetMaxSerialNoCommand;
import com.sinosoft.claim.ui.model.RecaseSaveCommand;
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
public class UIRecaseAction
{
  /*
   
  public void save(CertifyDto certifyDto) throws SQLException,Exception
  {
  	CertifySaveCommand certifySaveCommand = new CertifySaveCommand(certifyDto);
  	certifySaveCommand.execute();
  }
   */ 
  public void save(ReCaseDto recaseDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	RecaseSaveCommand recaseSaveCommand = new RecaseSaveCommand(recaseDto,workFlowDto);
  	recaseSaveCommand.execute();
  }
 
  public void savePrpLrecase(ReCaseDto recaseDto) throws SQLException,Exception
  {
  	PrpLrecaseSaveCommand prpLrecaseSaveCommand = new PrpLrecaseSaveCommand(recaseDto);
  	prpLrecaseSaveCommand.execute();
  }

  public void update(PrpLrecaseDto prpLrecaseDto) throws SQLException,Exception
  {
    PrpLrecaseUpdateCommand prpLrecaseUpdateCommand = new PrpLrecaseUpdateCommand(prpLrecaseDto);
  	prpLrecaseUpdateCommand.execute();
  }

 
  public ReCaseDto findByPrimaryKey(String claimNo,int serialNo) throws SQLException,UserException,Exception
  {
  	ReCaseFindByPrimaryCommand  reCaseFindByPrimaryCommand = new ReCaseFindByPrimaryCommand(claimNo,serialNo);
  	ReCaseDto  reCaseDto = (ReCaseDto)reCaseFindByPrimaryCommand.execute();

    if (reCaseDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+claimNo+")");
    }
    return reCaseDto;
  }

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
  	ReCaseFindByConCommand  reCaseFindByConCommand = new ReCaseFindByConCommand(conditions);
  	return (Collection)reCaseFindByConCommand.execute();
  }
  
 
/*
  public boolean isExist(String certifyNo) throws SQLException,Exception
  {
  	CertifyIsExistCommand certifyIsExistCommand = new CertifyIsExistCommand(certifyNo);
  	return ((Boolean)certifyIsExistCommand.execute()).booleanValue();
  }
*/ 
  public int getMaxSerialNo(String claimNo) throws SQLException,Exception
  {
     RecaseGetMaxSerialNoCommand  recaseGetMaxSerialNoCommand = new RecaseGetMaxSerialNoCommand(claimNo);

     return ((Integer)recaseGetMaxSerialNoCommand.execute()).intValue();
  }

 
}
