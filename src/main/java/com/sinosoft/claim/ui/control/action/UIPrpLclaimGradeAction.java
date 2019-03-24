package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.ui.model.PrpLclaimGradeFindByPrimaryKeyCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * UIPrpLclaimGradeAction����
 * <p>Title: ����ҵ��Ȩ�޶���UIPrpLclaimGradeAction  </p>
 * <p>Description: ����ҵ��Ȩ�޶���UIPrpLclaimGradeAction</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */

public class UIPrpLclaimGradeAction {

	
 /**
   * �������ҵ��Ȩ�޶���
   * @param  UserCode��Ա������
   * @param  TaskCode���������
   * @return ����ҵ��Ȩ�޶���
   * @throws Exception
   */
  public PrpLclaimGradeDto findByPrimaryKey(String UserCode,String TaskCode,String configPara) throws SQLException,UserException,Exception
  {
  	PrpLclaimGradeFindByPrimaryKeyCommand prpLclaimGradeFindByPrimaryKeyCommand = new PrpLclaimGradeFindByPrimaryKeyCommand(UserCode,TaskCode,configPara);        
  	PrpLclaimGradeDto prpLclaimGradeDto = (PrpLclaimGradeDto)prpLclaimGradeFindByPrimaryKeyCommand.execute();
    return prpLclaimGradeDto;
  }
}
