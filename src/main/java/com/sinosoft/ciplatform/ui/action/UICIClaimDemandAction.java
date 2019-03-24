package com.sinosoft.ciplatform.ui.action;


import java.sql.SQLException;
import java.util.ArrayList;
import com.sinosoft.claimciplatform.dto.domain.*;
import com.sinosoft.ciplatform.ui.model.CIClaimDemandFindByConditionsCommand;
import com.sinosoft.ciplatform.ui.model.CIClaimDemandFindByPrimaryKeyCommand;

public class UICIClaimDemandAction {
    
	public UICIClaimDemandAction (){//默认构造函数
    	
    }
	
	
	public CIClaimDemandDto findByPrimaryKey(String claimCode)
	{
		CIClaimDemandDto ciClaimDemandDto=new CIClaimDemandDto();
		try
		{
			CIClaimDemandFindByPrimaryKeyCommand prpLcheckFindByPrimaryKeyCommand=new CIClaimDemandFindByPrimaryKeyCommand(claimCode);
		    ciClaimDemandDto=(CIClaimDemandDto)prpLcheckFindByPrimaryKeyCommand.execute();
		
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return ciClaimDemandDto;
	}
	
	public ArrayList  findByConditions(String conditions)throws SQLException,Exception
	{
		CIClaimDemandFindByConditionsCommand ciClaimDemandFindByPrimaryKeyCommand=new CIClaimDemandFindByConditionsCommand(conditions);
		return (ArrayList) ciClaimDemandFindByPrimaryKeyCommand.execute();
	}
	
}