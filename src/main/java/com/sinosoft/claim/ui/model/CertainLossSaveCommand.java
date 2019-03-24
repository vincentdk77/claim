package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertainLossSaveCommand extends BaseCommand
{  
  private Class[] paramTypes;
  private Object[] params;
  /**
   *  构造方法,构造一个PrpLthirdPropInsertCommand对象
   * @param prpLthirdPropDto 参数prpLthirdPropDto
   * @throws Exception
   */  
  public CertainLossSaveCommand(CertainLossDto certainLossDto) throws Exception {
	this.params = new Object[]{certainLossDto};
		this.paramTypes = new Class[]{CertainLossDto.class };
}  
  public CertainLossSaveCommand(ArrayList certainLossDtoList) throws Exception {
		this.params = new Object[]{certainLossDtoList};
			this.paramTypes = new Class[]{ArrayList.class };
	}  
  public CertainLossSaveCommand(CertainLossDto certainLossDto,CheckDto checkDto) throws Exception {
		this.params = new Object[]{certainLossDto,checkDto};
  		this.paramTypes = new Class[]{CertainLossDto.class ,CheckDto.class};
  }
  public CertainLossSaveCommand(CertainLossDto certainLossDto,CheckDto checkDto,WorkFlowDto workFlowDto) throws Exception {
  		this.params = new Object[]{certainLossDto,checkDto,workFlowDto };
  		this.paramTypes = new Class[]{CertainLossDto.class,CheckDto.class,WorkFlowDto.class };
  }
  public CertainLossSaveCommand(CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws Exception {
		this.params = new Object[]{certainLossDto,workFlowDto };
		this.paramTypes = new Class[]{CertainLossDto.class,WorkFlowDto.class };
}  
  public CertainLossSaveCommand(ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws Exception {
		this.params = new Object[]{certainLossDtoList,workFlowDtoList };
		this.paramTypes = new Class[]{ArrayList.class,ArrayList.class };
  }
  /**
   *  执行方法
   *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
   */
  public Object executeCommand() throws Exception{
      Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLCertainLossFacade");
      Object object = loaderClass.newInstance(); 
      Method method = loaderClass.getMethod("save",paramTypes);
      return method.invoke(object,params); 
  }  
  
}
