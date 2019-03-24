package com.sinosoft.claim.ui.model;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CheckSaveCommand extends BaseCommand
{
  private Class[] paramTypes;
  private Object[] params;
  /**
   *  ���췽��,����һ��PrpLthirdPropInsertCommand����
   * @param prpLthirdPropDto ����prpLthirdPropDto
   * @throws Exception
   */  
  public CheckSaveCommand(CheckDto checkDto,CertainLossDto certainLossDto) throws Exception {
		this.params = new Object[]{checkDto,certainLossDto};
  		this.paramTypes = new Class[]{CheckDto.class,CertainLossDto.class };
  }
  public CheckSaveCommand(CheckDto checkDto,CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws Exception {
  		this.params = new Object[]{checkDto,certainLossDto,workFlowDto };
  		this.paramTypes = new Class[]{CheckDto.class,CertainLossDto.class,WorkFlowDto.class };
  } 
  public CheckSaveCommand(ArrayList checkDtoList,ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws Exception {
		this.params = new Object[]{checkDtoList,certainLossDtoList,workFlowDtoList };
		this.paramTypes = new Class[]{ArrayList.class,ArrayList.class,ArrayList.class };
} 
  public CheckSaveCommand(ArrayList checkDtoList,ArrayList certainLossDtoList) throws Exception {
		this.params = new Object[]{checkDtoList,certainLossDtoList};
		this.paramTypes = new Class[]{ArrayList.class,ArrayList.class };
}
  /**
   *  ִ�з���
   *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
   */
  public Object executeCommand() throws Exception{
      Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLCheckFacade");
      Object object = loaderClass.newInstance(); 
      Method method = loaderClass.getMethod("save",paramTypes);
      return method.invoke(object,params);
  }  
}
