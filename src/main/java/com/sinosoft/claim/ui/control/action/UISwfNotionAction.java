package com.sinosoft.claim.ui.control.action;


import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.model.SwfNotionFindByPrimaryKeyCommand;


public class UISwfNotionAction {
    
	public UISwfNotionAction (){//默认构造函数
    	
    }
	
	
	public SwfNotionDto findByPrimaryKey(String flowId, int logNo, int lineNo )
	{
		SwfNotionDto swfNotionDto=new SwfNotionDto();
		try
		{
			SwfNotionFindByPrimaryKeyCommand  swfNotionFindByPrimaryKeyCommand=new SwfNotionFindByPrimaryKeyCommand(flowId,logNo,1);
			swfNotionDto=(SwfNotionDto)swfNotionFindByPrimaryKeyCommand.execute();
		
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return swfNotionDto;
	}
	
	
}