package com.sinosoft.claim.ui.control.action;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.ui.model.PrpLextFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLextInsertCommand;
import com.sinosoft.claim.ui.model.PrpLextDeleteCommand;
;


/**
 * �����������Ϣ�����ࣻ
 * <p>Title:�Ի����������Ϣ���в��룬���ң��޸Ĳ�����</p>
 * <p>Description:�Ի����������Ϣ���в�����</p>
 * <p>Copyright:Sinosoft (c) 2005.8.15</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIPrpLcheckExtAction {
       
	public UIPrpLcheckExtAction (){//Ĭ�Ϲ��캯��
       	
       }
	/**
	 * ִ�в������
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
     * ִ��ɾ������ 
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
	 * ִ���޸Ĳ���
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
	 * �����������Ҳ���
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
		//�ӱ�����Ϣ�еõ������ղ鿱��Ҫ����Ϣ
		
		
		
		return prpLextDto;
	}
	
	
	
	
}