package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLManageAction;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ����PrpLregist-������Ϣ���ҵ�����Facade��<br>
 * ������ 2005-03-18 17:08:11.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLManageFacade {
    private static Log logger = LogFactory.getLog(BLManageFacade.class);

    /**
     * ���캯��
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
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
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
