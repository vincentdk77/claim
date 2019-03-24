package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLBackVisitFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * 这是BLBackVisitFacade的UI Command类<br>
 * 创建于 2005-03-26 16:23:01.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BackVisitFindByPrimaryKeyCommand extends BaseCommand{
  private int backVisitNo;
  private String registNo;
  private String backVisitType;
    /**
     *  构造方法,构造一个BackVisitFindByPrimaryKeyCommand对象
     * @param backVisitNo 参数backVisitNo
     * @param registNo 参数registNo
     * @param backVisitType 参数backVisitType
     * @throws Exception 
     */
    public BackVisitFindByPrimaryKeyCommand(int backVisitNo ,String registNo ,String backVisitType) throws Exception {
    		this.backVisitNo = backVisitNo;
    		this.registNo = registNo;
    		this.backVisitType = backVisitType; 
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
      BLBackVisitFacade blBackVisitFacade = new BLBackVisitFacade();
      return blBackVisitFacade.findByPrimaryKey(backVisitNo,registNo,backVisitType);
    }
}
