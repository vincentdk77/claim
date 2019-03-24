package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.ui.model.PrpLextFindByPrimaryKeyCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UIPrpLextAction
{
	public PrpLextDto findByPrimaryKey(String certiNo,String certiType) throws SQLException,UserException,Exception
	  {
		PrpLextFindByPrimaryKeyCommand prpLextFindByPrimaryKeyCommand = new PrpLextFindByPrimaryKeyCommand(certiNo,certiType);
		PrpLextDto prpLextDto = (PrpLextDto)prpLextFindByPrimaryKeyCommand.execute();
	    if (prpLextDto == null)
	    {
	      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+certiNo+")");
	    }
	    return prpLextDto;
	  }
}