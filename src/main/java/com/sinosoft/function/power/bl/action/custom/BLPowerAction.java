package com.sinosoft.function.power.bl.action.custom;
/**
 * <p>Title: Ȩ��У��</p>
 * <p>Description: �����Ʒ��Ȩ��У�����Action</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ�� κʿ��
 * @version 1.0
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.function.insutil.bl.action.domain.BLPrpDcompanyAction;
import com.sinosoft.function.insutil.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.function.insutil.dto.domain.PrpDcompanyDto;
import com.sinosoft.function.insutil.dto.domain.PrpDuserDto;
import com.sinosoft.function.power.resource.dtofactory.custom.DBPower;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPowerAction extends BLPowerActionBase{
  public BLPowerAction() {
  }
  /**
   * ���ݸ�λ�����񣩼����֣������������ĳ��λ����ԱȨ��
   * @param condtions String
   * @throws SQLException
   * @throws Exception
   * @return Collection
   */
  public Collection findByTask(DBManager dbManager,String condtions) throws SQLException,Exception
  {
     Collection collection = new ArrayList();
     DBPower dbPower = new DBPower(dbManager);
     collection = dbPower.findByTask(condtions) ;
     return collection;
  }
  
  /**
   * ������Ա��ȡ��Ӧ��˾��������������
   * @param userCode String
   * @param tableName String
   * @throws SQLException
   * @throws Exception
   * @return String
   */
  public String getLocalCom(DBManager dbManager,String userCode,String tableName) throws SQLException,Exception
  {
    String conditions = ""; 
  	PrpDuserDto prpDuserDto = new BLPrpDuserAction().findByPrimaryKey(dbManager,userCode); 
  	if (prpDuserDto != null)
  	{
  	    String comCode = prpDuserDto.getComCode();
  	    PrpDcompanyDto prpDcompanyDto = new BLPrpDcompanyAction().findByPrimaryKey(dbManager,comCode);
  	    if (prpDcompanyDto != null)
  	    {
  	    	conditions = " UpperComCode = '"+prpDcompanyDto.getComCode() +
			             "' And ComLevel = '"+prpDcompanyDto.getComLevel()+"'";
  	    	Collection prpDcompanyDtoList = new BLPrpDcompanyAction().findByConditions(dbManager,conditions);
  	    	conditions = " And "+tableName +".ComCode IN ('"+comCode+"'";
  	    	if (prpDcompanyDtoList != null && prpDcompanyDtoList.size() > 0)
  	    	{
  	    		Iterator iterator = prpDcompanyDtoList.iterator();
  	    		while (iterator.hasNext())
  	    		{
  	    			prpDcompanyDto = (PrpDcompanyDto)iterator.next();
  	    			conditions = conditions + ",'"+prpDcompanyDto.getComCode()+"'";
  	    		}
  	    	}
  	    	conditions = conditions + ")";
  	    }
  	}	
    return conditions;
  }
}
