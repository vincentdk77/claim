package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.claim.ui.model.PrpLIndemnityReceiptFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLIndemnityReceiptInsertCommand;
import com.sinosoft.claim.ui.model.PrpLIndemnityReceiptUpdateCommand;

public class UIIndemnityReceiptAction {

	/**
	 * 根据业务号获得赔款收据信息
	 * 
	 * @param businessNo
	 *            业务号
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public PrpLIndemnityReceiptDto findPrpLIndemnityReceiptDtoByBusinessNo(
			String businessNo) throws SQLException, Exception {
		PrpLIndemnityReceiptFindByPrimaryKeyCommand prpLIndemnityReceiptFindByPrimaryKeyCommand = new PrpLIndemnityReceiptFindByPrimaryKeyCommand(
				businessNo);
		PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = (PrpLIndemnityReceiptDto) prpLIndemnityReceiptFindByPrimaryKeyCommand
				.execute();
		return prpLIndemnityReceiptDto;
	}

	/**
	 * 增加赔款收据信息
	 * @param prpLIndemnityReceiptDto
	 * @throws SQLException
	 * @throws Exception
	 */	
	public void insertPrpLIndemnityReceiptDto(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)throws SQLException, Exception {
		PrpLIndemnityReceiptInsertCommand prpLIndemnityReceiptInsertCommand = new PrpLIndemnityReceiptInsertCommand(prpLIndemnityReceiptDto);
		prpLIndemnityReceiptInsertCommand.execute();		
	}
	/**
	 * 更新赔款收据信息
	 * @param prpLIndemnityReceiptDto
	 * @throws SQLException
	 * @throws Exception
	 */	
	public void updatePrpLIndemnityReceiptDto(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)throws SQLException, Exception {
		PrpLIndemnityReceiptUpdateCommand prpLIndemnityReceiptUpdateCommand = new PrpLIndemnityReceiptUpdateCommand(prpLIndemnityReceiptDto);
		prpLIndemnityReceiptUpdateCommand.execute();
	}
}
