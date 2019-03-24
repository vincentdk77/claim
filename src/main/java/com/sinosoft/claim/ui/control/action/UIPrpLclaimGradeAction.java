package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.ui.model.PrpLclaimGradeFindByPrimaryKeyCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * UIPrpLclaimGradeAction对象
 * <p>Title: 理赔业务权限对象UIPrpLclaimGradeAction  </p>
 * <p>Description: 理赔业务权限对象UIPrpLclaimGradeAction</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */

public class UIPrpLclaimGradeAction {

	
 /**
   * 获得理赔业务权限对象
   * @param  UserCode：员工代码
   * @param  TaskCode：任务代码
   * @return 理赔业务权限对象
   * @throws Exception
   */
  public PrpLclaimGradeDto findByPrimaryKey(String UserCode,String TaskCode,String configPara) throws SQLException,UserException,Exception
  {
  	PrpLclaimGradeFindByPrimaryKeyCommand prpLclaimGradeFindByPrimaryKeyCommand = new PrpLclaimGradeFindByPrimaryKeyCommand(UserCode,TaskCode,configPara);        
  	PrpLclaimGradeDto prpLclaimGradeDto = (PrpLclaimGradeDto)prpLclaimGradeFindByPrimaryKeyCommand.execute();
    return prpLclaimGradeDto;
  }
}
