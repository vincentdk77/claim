package com.sinosoft.workrove.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.*;
import com.sinosoft.workrove.dto.formbean.WorkRoveDto;
import com.sinosoft.workrove.resource.dtofactory.custom.DBWorkRove;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertainLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertainLoss;
import java.util.*;

/**
 * ����action
 * <p>Title: �������� ����acton</p>
 * <p>Description: �������� ����acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLWorkRoveAction {
	public BLWorkRoveAction() {
	}

	/**
	 * ���涨��
	 * @param certainLossDto���Զ��嶨�����
	 * @param dbManager  ��������
	 * @throws SQLException
	 * @throws Exception
	 */
	public void save(DBManager dbManager, WorkRoveDto workRoveDto)
			throws SQLException, Exception {
		DBWorkRove  dBWorkRove= null;
		//ҵ�����
		dBWorkRove = new DBWorkRove();
		dBWorkRove.insert(dbManager, workRoveDto);
	}	
}
