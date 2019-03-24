package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.bl.action.domain.BLUwNotionAction;
import com.sinosoft.undwrt.bl.facade.BLUwNotionFacadeBase;


/**
 * ����UwNotion_�˱����⴦��������ҵ�����Facade��<br>
 * ������ 2004-12-24 10:34:28.153<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUwNotionFacade extends BLUwNotionFacadeBase
{
  private static Log logger = LogFactory.getLog(BLUwNotionFacade.class);
	public static final int RULE_LENGTH = 70; //rule�ֶεĳ���

  /**
   * ���캯��
   */
  public BLUwNotionFacade()
  {
    super();
  }

  /**
   * ��������ѯ��������
   * @param conditions ��ѯ����
   * @return Collection ����uwNotionDto�ļ���
   * @throws Exception
   */
  public Collection findByConditions(String conditions) throws Exception{
      Collection collection = new ArrayList();

      if(conditions.trim().length()==0){
          conditions = "1=1";
      }

      DBManager dbManager = new DBManager();
      BLUwNotionAction blUwNotionAction = new BLUwNotionAction();
      try{
    	  dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          collection = blUwNotionAction.findByConditions(dbManager,conditions);
      }catch(Exception exception){
          throw exception;
      }finally{
          dbManager.close();
      }
      return collection;
  }


}
