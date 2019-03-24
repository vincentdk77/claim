package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.query.ui.model.PrpLRegistRPolicyFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLRegistRPolicyFindByPrimaryKeyCommand;
/**
 * PrpLperson对象
 * <p>Title: 车险理赔PrpLperson  </p>
 * <p>Description: 车险理赔PrpLperson</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class UIPrpLregistRPolicyAction
{

  /**
 * 获得PrpLregistRPolicy信息
 * @param  conditions：查询条件
 * @return PrpLregistRPolicy对象
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
