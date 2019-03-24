package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLMessageAction;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;



/**
 * ����PrpLmessage������ת�������Ա��ҵ�����Facade��<br>
 * ������ 2004-07-27 16:11:43.797<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLmessageFacade extends BLPrpLmessageFacadeBase{
  private static Log logger = LogFactory.getLog(BLPrpLmessageFacade.class);

  /**
   * ���캯��
   */
  public BLPrpLmessageFacade() {
    super();
  }

  /**
   * ������������
   * @param prplmessageDto PrpLmessageDto
   * @throws SQLException
   * @throws Exception
   */
  public void save(PrpLmessageDto prpLmessageDto) throws SQLException,
      Exception {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    //��ʼ����
    dbManager.beginTransaction();
    try {
      new BLMessageAction().save(dbManager, prpLmessageDto);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch (SQLException sqle) {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch (Exception ex) {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally {
      //�ر����ݿ�����
      dbManager.close();
    }
  }

  /**
     * ȡ�����
     * @param registNo
     * @param dbManager  ��������
     * @return messageID
     * @throws SQLException
     * @throws Exception
     */
      public int getNo(String registNo) throws SQLException,Exception
      {

        int messageID =0 ;
        //�������ݿ�������
         DBManager dbManager = new DBManager();
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        try
        {
          messageID = new BLMessageAction().getNo(dbManager,registNo);
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
        return messageID;
      }


}






