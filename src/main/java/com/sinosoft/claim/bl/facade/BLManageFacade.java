package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLManageAction;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是PrpLregist-报案信息表的业务对象Facade类<br>
 * 创建于 2005-03-18 17:08:11.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLManageFacade {
    private static Log logger = LogFactory.getLog(BLManageFacade.class);

    /**
     * 构造函数
     */
    public BLManageFacade(){
        super();
    }
  public AnaResultDto findByDto(AnaRepCommonDto anaRepCommonDto,int intPageNo,int intRowsPerPage) throws Exception
  {
    BLManageAction blManageAction = new BLManageAction();
    AnaResultDto anaResultDto = new AnaResultDto();

    DBManager dbManager = new DBManager();

    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
      anaResultDto = blManageAction.findByDto(dbManager,anaRepCommonDto,intPageNo,intRowsPerPage);
    }
    catch(Exception exception)
    {
      throw exception;
    }
    finally
    {
      dbManager.close();
    }

    return anaResultDto;
  }

  public AnaResultDto findByDto(AnaRepCommonDto anaRepCommonDto) throws Exception
  {
    AnaResultDto anaResultDto = new AnaResultDto();
    anaResultDto = findByDto(anaRepCommonDto,0,0);
    return anaResultDto;
  }
	
}
