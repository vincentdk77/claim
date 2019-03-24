
package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  ��������������ݿ�������
 * <p>Title: ����������������������ݹ���</p>
 * <p>Description: ����������������������ݹ���</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class DBScheduleAddCertainLoss {
	

	/**
	   * ���캯��
	   * @param dbManager ��Դ������
	   */
	  public DBScheduleAddCertainLoss()
	  {

	  }

	  /**
	   * ����������ȱ��淽��
	   *@param checkDto �鿱����
	   * @throws SQLException
	   * @throws Exception
	   *@return ��
	   */
	  public void insert(DBManager dbManager,CheckDto checkDto)
	    throws SQLException,Exception	
	  {
	  	
	    String registNo="";
	    registNo = checkDto.getPrpLcheckDto().getRegistNo();
	    //����ɾ��ԭ�����������
	    deleteSubInfo(dbManager,registNo,checkDto);
        //���⳵����Ϣ��
	    if(checkDto.getPrpLthirdPartyDtoList()!=null)
	    {
	       new DBPrpLthirdParty(dbManager).insertAll(checkDto.getPrpLthirdPartyDtoList());
	    }
        //���������ı�
	     if(checkDto.getPrpLscheduleItemDtoList() !=null)   {

	       new DBPrpLscheduleItem(dbManager).insertAll(checkDto.getPrpLscheduleItemDtoList()  );
	     }
	   //  else
         //��ʧ��λ��
	     if(checkDto.getPrpLthirdCarLossDtoList()!=null)
	     {
	       new DBPrpLthirdCarLoss(dbManager).insertAll(checkDto.getPrpLthirdCarLossDtoList());
	     }
	     
	     
	     if(checkDto.getPrpLpersonTraceDtoList()!=null)
	     {
	        new DBPrpLpersonTrace(dbManager).insertAll(checkDto.getPrpLpersonTraceDtoList());
	     }
	     
	     if(checkDto.getPrpLthirdPropDtoList()!=null)
	     {
	       new DBPrpLthirdProp(dbManager).insertAll(checkDto.getPrpLthirdPropDtoList());
	     }
	     
	     if(checkDto.getPrpLcheckLossDtoList()!=null)
	     {
	       new DBPrpLcheckLoss(dbManager).insertAll(checkDto.getPrpLcheckLossDtoList());
	     }


	  }
	  
	  
	  /**
	   * �����������ɾ���ӱ���Ϣ
	   * @param checkNo
	   * @throws SQLException
	   * @throws Exception
	   */
	  private void deleteSubInfo(DBManager dbManager,String businessNo,CheckDto checkDto)
	    throws SQLException,Exception
	  {
	    String condition = " registNo = '" + StringUtils.rightTrim(businessNo) + "'";

	    String statement = ""; //ʾ��δ���
	    
	    
	    if(checkDto.getPrpLthirdPartyDtoList() !=null)   {
	    statement = " DELETE FROM prpLthirdParty Where " + condition;
	    dbManager.executeUpdate(statement);
	    }

	    //modify by liyanjie 2005-12-17 ��Ϊ�ڲ���һ����¼ǰ,ɾ����Ӧһ��
	    //�������������scheduleITem�����ݵĻ�
	     // if(checkDto.getPrpLscheduleItemDtoList() !=null)   {
	     //   statement = " DELETE FROM PrpLscheduleItem Where " + condition;
	     //   dbManager.executeUpdate(statement);
	    //}
	    
	    if(checkDto.getPrpLthirdCarLossDtoList() !=null)   {
	    statement = " DELETE FROM prplThirdcarloss Where " + condition;
	    dbManager.executeUpdate(statement);
	    }
	    
	    if(checkDto.getPrpLcheckLossDtoList() !=null)   {
	    	//System.out.println("CheckLoss���ǿյġ�����");
		    statement = " DELETE FROM PrpLcheckLoss Where  " + condition;
		    dbManager.executeUpdate(statement);
		    }
	    
	    statement = " DELETE FROM prplThirdProp Where " + condition;
	    dbManager.executeUpdate(statement);
	    
	    statement =  " DELETE FROM prpLpersonTrace Where " + condition;
	    dbManager.executeUpdate(statement);


	  }



}
