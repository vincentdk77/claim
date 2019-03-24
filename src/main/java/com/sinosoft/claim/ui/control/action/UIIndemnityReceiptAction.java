package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.claim.ui.model.PrpLIndemnityReceiptFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLIndemnityReceiptInsertCommand;
import com.sinosoft.claim.ui.model.PrpLIndemnityReceiptUpdateCommand;

public class UIIndemnityReceiptAction {

	/**
	 * ����ҵ��Ż������վ���Ϣ
	 * 
	 * @param businessNo
	 *            ҵ���
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
	 * ��������վ���Ϣ
	 * @param prpLIndemnityReceiptDto
	 * @throws SQLException
	 * @throws Exception
	 */	
	public void insertPrpLIndemnityReceiptDto(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)throws SQLException, Exception {
		PrpLIndemnityReceiptInsertCommand prpLIndemnityReceiptInsertCommand = new PrpLIndemnityReceiptInsertCommand(prpLIndemnityReceiptDto);
		prpLIndemnityReceiptInsertCommand.execute();		
	}
	/**
	 * ��������վ���Ϣ
	 * @param prpLIndemnityReceiptDto
	 * @throws SQLException
	 * @throws Exception
	 */	
	public void updatePrpLIndemnityReceiptDto(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)throws SQLException, Exception {
		PrpLIndemnityReceiptUpdateCommand prpLIndemnityReceiptUpdateCommand = new PrpLIndemnityReceiptUpdateCommand(prpLIndemnityReceiptDto);
		prpLIndemnityReceiptUpdateCommand.execute();
	}
}
