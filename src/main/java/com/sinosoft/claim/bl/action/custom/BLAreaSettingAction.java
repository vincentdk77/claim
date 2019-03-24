package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.AreaSettingDto;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBAreaSetting;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplareasetting;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLAreaSettingAction {
	
	public void save(DBManager dbManager,AreaSettingDto areaSettingDto) throws Exception{
		DBAreaSetting dbAreaSetting = null;
		dbAreaSetting = new DBAreaSetting();
		if(areaSettingDto != null){
			if(areaSettingDto.getAreaSettingDto() != null && !"".equals(areaSettingDto.getAreaSettingDto())){
				PrplareasettingDto prplareasettingDto = areaSettingDto.getAreaSettingDto();
				if(prplareasettingDto.getHandlercode() != null && !"".equals(prplareasettingDto.getHandlercode())){//�����ˡ�����ɾ�� ��Ӧ����������
					String statement =  " DELETE FROM prplareasetting Where classcode='"+prplareasettingDto.getClasscode()+"' and handlercode='"+prplareasettingDto.getHandlercode()+"' and handledept='"+prplareasettingDto.getHandledept()+"'"  ;
			        dbManager.executeUpdate(statement);
			        dbAreaSetting.delete(dbManager,prplareasettingDto.getHandlercode());
				}else{//���ݻ���ɾ�� ��Ӧ����������
					String statement =  " DELETE FROM prplareasetting Where classcode='"+prplareasettingDto.getClasscode()+"' and handledept='"+prplareasettingDto.getHandledept()+"'"  ;
			        dbManager.executeUpdate(statement);
			        dbAreaSetting.delete(dbManager,prplareasettingDto.getHandlercode());
				}
			}
		}
		
		dbAreaSetting.insert(dbManager,areaSettingDto);
	}
	
	/**
	 * �ж��Ƿ��������������Ϣ
	 * @param dbManager
	 * @param registNo
	 * @return 
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean isExist(DBManager dbManager,String id)throws SQLException,Exception{   
		  DBPrplareasetting blPrplareasetting = new DBPrplareasetting(dbManager);
	      String strSql ="handlercode='"+ id+"'";
	      if(blPrplareasetting.getCount(strSql)<1)
	      //     if (new DBPrpLregist().getCount(dbManager,registNo) == null)
	      {
	        return false;
	      }else
	      {
	        return true;
	      }
	  }
	
	/**
	   * ��������ѯ��������
	   * @param dbManager DBManager
	   * @param conditions String
	   * @param pageNo int
	   * @param rowsPerPage int
	   * @throws Exception
	   * @return Collection
	   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
	   */
	  public PageRecord findByQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrplareasetting dbPrplareasetting = new DBPrplareasetting(dbManager);
	    Collection collection = new ArrayList();

	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    int count = dbPrplareasetting.getCount(SqlUtils.getWherePartForGetCount(conditions));
      int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

      if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "��ѯ�����������ϵͳ����");
		}
	    collection = dbPrplareasetting.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
	}

}
