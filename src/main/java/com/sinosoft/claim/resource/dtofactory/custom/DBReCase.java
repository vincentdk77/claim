package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrecase;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��֤���ݿ�������
 * <p>Title: �������ⵥ֤���ݹ���</p>
 * <p>Description: �������ⵥ֤���ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBReCase {
	private DBManager dbManager = null; //��Դ������

	/**
	 * ���캯��
	 * @param dbManager ��Դ������
	 */
	public DBReCase() {
	}

	public void insert(DBManager dbManager, ReCaseDto reCaseDto)
			throws SQLException, Exception {

		//��ɾ���
		PrpLrecaseDto prpLrecaseDto = new PrpLrecaseDto();
		prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
		
		deleteSubInfo(dbManager, reCaseDto);
		new DBPrpLrecase(dbManager).insert(prpLrecaseDto);
		//updateClaimStatus(dbManager,ReCaseDto);
	}

	private void deleteSubInfo(DBManager dbManager, ReCaseDto ReCaseDto)
			throws SQLException, Exception {
		String condition = "";
		String statement = "";
		if (ReCaseDto.getPrpLrecaseDto() != null) {
			String claimNo = ReCaseDto.getPrpLrecaseDto().getClaimNo().trim();
			int serialNo = ReCaseDto.getPrpLrecaseDto().getSerialNo();
			condition = " claimNo = " + "'" + claimNo + "' and serialNo ="
					+ serialNo;
			statement = " DELETE FROM PrpLRecase Where " + condition;
			dbManager.executeUpdate(statement);
		}
	}

	public ReCaseDto findByPrimaryKey(DBManager dbManager, String claimNo,
			int serialNo) throws SQLException, Exception {
		ReCaseDto ReCaseDto = new ReCaseDto();
		ReCaseDto.setPrpLclaimDto(new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo));
		ReCaseDto.setPrpLrecaseDto(new DBPrpLrecase(dbManager).findByPrimaryKey(claimNo, serialNo));
		
		return ReCaseDto;
	}

}
