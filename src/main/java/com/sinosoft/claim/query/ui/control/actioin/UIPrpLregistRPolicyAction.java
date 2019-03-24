package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.query.ui.model.PrpLRegistRPolicyFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLRegistRPolicyFindByPrimaryKeyCommand;
/**
 * PrpLperson����
 * <p>Title: ��������PrpLperson  </p>
 * <p>Description: ��������PrpLperson</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class UIPrpLregistRPolicyAction
{

  /**
 * ���PrpLregistRPolicy��Ϣ
 * @param  conditions����ѯ����
 * @return PrpLregistRPolicy����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
 	PrpLRegistRPolicyFindByConditionsCommand prpLRegistRPolicyFindByConditionsCommand = new PrpLRegistRPolicyFindByConditionsCommand(conditions);

    return (Collection)prpLRegistRPolicyFindByConditionsCommand.execute();
 }
 public PrpLRegistRPolicyDto findByPrimaryKey(String registNo,String policyNo) throws SQLException,Exception
 {
 	PrpLRegistRPolicyFindByPrimaryKeyCommand prpLRegistRPolicyFindByPrimaryKeyCommand = new PrpLRegistRPolicyFindByPrimaryKeyCommand(registNo,policyNo);

    return (PrpLRegistRPolicyDto)prpLRegistRPolicyFindByPrimaryKeyCommand.execute();
 }

}
