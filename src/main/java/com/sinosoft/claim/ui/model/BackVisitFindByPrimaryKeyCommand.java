package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLBackVisitFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * ����BLBackVisitFacade��UI Command��<br>
 * ������ 2005-03-26 16:23:01.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BackVisitFindByPrimaryKeyCommand extends BaseCommand{
  private int backVisitNo;
  private String registNo;
  private String backVisitType;
    /**
     *  ���췽��,����һ��BackVisitFindByPrimaryKeyCommand����
     * @param backVisitNo ����backVisitNo
     * @param registNo ����registNo
     * @param backVisitType ����backVisitType
     * @throws Exception 
     */
    public BackVisitFindByPrimaryKeyCommand(int backVisitNo ,String registNo ,String backVisitType) throws Exception {
    		this.backVisitNo = backVisitNo;
    		this.registNo = registNo;
    		this.backVisitType = backVisitType; 
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
      BLBackVisitFacade blBackVisitFacade = new BLBackVisitFacade();
      return blBackVisitFacade.findByPrimaryKey(backVisitNo,registNo,backVisitType);
    }
}
