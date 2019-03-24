package com.sinosoft.claim.ui.control.action;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.ui.model.PrpLextFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLextInsertCommand;
import com.sinosoft.claim.ui.model.PrpLextDeleteCommand;
;


/**
 * 货运险相关信息操作类；
 * <p>Title:对货运险相关信息进行插入，查找，修改操作；</p>
 * <p>Description:对货运险相关信息进行操作；</p>
 * <p>Copyright:Sinosoft (c) 2005.8.15</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIPrpLcheckExtAction {
       
	public UIPrpLcheckExtAction (){//默认构造函数
       	
       }
	/**
	 * 执行插入操作
	 * @param PrpLextDto
	 * @return void
	 * @throws Exception
	 */
    public void insert(PrpLextDto prpLextDto) throws Exception{
    	try{
    	   PrpLextInsertCommand prpLextInsertCommand = new PrpLextInsertCommand(prpLextDto);
    	   prpLextInsertCommand.execute();
    	}catch(Exception e){
    	   throw e;
    	}
    	 
    }
    /**
     * 执行删除操作 
     * @param certiNo
     * @param certiType
     * @throws Exception
     */
	public void delete(String certiNo,String certiType)throws Exception{
		try{
		    PrpLextDeleteCommand prpLextDeleteCommand = new PrpLextDeleteCommand(certiNo,certiType);
		    prpLextDeleteCommand.execute();
		}catch(Exception e){
		}
	}
	/**
	 * 执行修改操作
	 * @param prpLextDto
	 * @throws Exception
	 */
	public void modify(PrpLextDto prpLextDto)throws Exception{
		String certiNo = prpLextDto.getCertiNo();
		String certiType = prpLextDto.getCertiType();
		this.delete(certiNo,certiType);
		this.insert(prpLextDto);	 
	}
	/**
	 * 根据主键查找操作
	 * @param certiNo
	 * @param certiType
	 * @return PrpLextDto
	 */
	public PrpLextDto findByPrimaryKey(String certiNo,String certiType){
		PrpLextDto prpLextDto = new PrpLextDto();
	    try{
	    	PrpLextFindByPrimaryKeyCommand command = new PrpLextFindByPrimaryKeyCommand(certiNo,certiType);
	    	command.execute();
	    }catch(Exception e){
	    }
	    return prpLextDto;
	}
	public PrpLextDto findDetailFromPolicy(PolicyDto policyDto){
		PrpLextDto prpLextDto = new PrpLextDto();
		//从保单信息中得到货运险查勘需要的信息
		
		
		
		return prpLextDto;
	}
	
	
	
	
}