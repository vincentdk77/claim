package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLLogonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.function.insutil.bl.facade.BLEncryptFacade;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��¼�߼��ַ�EJB
 * <p>Title: �����¼��������</p>
 * <p>Description: ������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ����������
 * @version 1.0
 */
public class BLLogonFacade
{
  public PrpDuserDto checkUser(String usercode,String password) throws SQLException,Exception
  {
    PrpDuserDto prpDuserDto = null;
    //�������ݿ�������

    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    String encryptCode = "" ;     //���ܺ�Ĵ�

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
       //�ر����ݿ�����
       dbManager.close();
     }
     return prpDuserDto;
  }
  
  /**
   * �޸��û�����
   * @param prpDuserDto 
   * @throws SQLException
   * @throws Exception
   * @return void*/
  public void updatePwd(PrpDuserDto prpDuserDto) throws SQLException, Exception {
  	 DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
     
     String encryptCode = "" ;     //���ܺ�Ĵ�

     try
      { 
        BLEncryptFacade blEncryptFacade = new BLEncryptFacade();
        
        //���������
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
        //�ر����ݿ�����
        dbManager.close();
      }
  }
}
