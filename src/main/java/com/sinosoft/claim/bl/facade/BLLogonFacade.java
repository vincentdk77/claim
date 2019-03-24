package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLLogonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.function.insutil.bl.facade.BLEncryptFacade;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 登录逻辑分发EJB
 * <p>Title: 理赔登录样本程序</p>
 * <p>Description: 理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔组
 * @version 1.0
 */
public class BLLogonFacade
{
  public PrpDuserDto checkUser(String usercode,String password) throws SQLException,Exception
  {
    PrpDuserDto prpDuserDto = null;
    //创建数据库管理对象

    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    String encryptCode = "" ;     //加密后的串

    try
     { 
       BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
       encryptCode   =  blEncryptFacade.getEncryptCode(password);
       prpDuserDto =new BLLogonAction().checkUser(dbManager,usercode,encryptCode);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch(Exception ex)
     {
       throw ex;
     }
     finally
     {
       //关闭数据库连接
       dbManager.close();
     }
     return prpDuserDto;
  }
  
  /**
   * 修改用户密码
   * @param prpDuserDto 
   * @throws SQLException
   * @throws Exception
   * @return void*/
  public void updatePwd(PrpDuserDto prpDuserDto) throws SQLException, Exception {
  	 DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
     
     String encryptCode = "" ;     //加密后的串

     try
      { 
        BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
        
        //对密码加密
        encryptCode   =  blEncryptFacade.getEncryptCode(prpDuserDto.getPassword());
        prpDuserDto.setPassword(encryptCode);
        BLPrpDuserAction blPrpDuserAction = new BLPrpDuserAction();
        blPrpDuserAction.update(dbManager, prpDuserDto);
      }
      catch(SQLException sqle)
      {
        throw sqle;
      }
      catch(Exception ex)
      {
        throw ex;
      }
      finally
      {
        //关闭数据库连接
        dbManager.close();
      }
  }
}
