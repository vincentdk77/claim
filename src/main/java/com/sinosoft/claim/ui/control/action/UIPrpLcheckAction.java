package com.sinosoft.claim.ui.control.action;


import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.model.PrpLcheckFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByPrimaryKeyCommand;

public class UIPrpLcheckAction {
    
	public UIPrpLcheckAction (){//默认构造函数
    	
    }
	
	
	public PrpLcheckDto findByPrimaryKey(String registNo)
	{
		PrpLcheckDto prpLcheckDto=new PrpLcheckDto();
		try
		{
		PrpLcheckFindByPrimaryKeyCommand prpLcheckFindByPrimaryKeyCommand=new PrpLcheckFindByPrimaryKeyCommand(registNo,1);
		prpLcheckDto=(PrpLcheckDto)prpLcheckFindByPrimaryKeyCommand.execute();
		
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return prpLcheckDto;
	}
	
	public PrpLregistDto  findByPrimaKey(String registNo)
	{
		PrpLregistDto prpLregistDto=new PrpLregistDto();
		try
		{
			PrpLregistFindByPrimaryKeyCommand prpLregistFindByPrimaryKeyCommand=new PrpLregistFindByPrimaryKeyCommand(registNo);
			prpLregistDto=(PrpLregistDto)prpLregistFindByPrimaryKeyCommand.execute();
			if (prpLregistDto == null)
			{
//			throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+riskCode+")");
				prpLregistDto = new PrpLregistDto();
			} 
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return prpLregistDto;
		
	}
	
}