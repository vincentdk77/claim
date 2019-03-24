package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;

/**
 * ����PLANTINGPOLICYLIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingpolicylistAction extends BLPlantingpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingpolicylistAction.class);

    /**
     * ���캯��
     */
    public BLPlantingpolicylistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param plantingpolicylistDto plantingpolicylistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PlantingpolicylistDto plantingpolicylistDto,String mode)
            throws Exception{
    }
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPlantingByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbPlantingpolicylist.getPlantingCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingpolicylist.findPlantingByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * ��������ѯ��������
     * @param dbManager
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord findNewPlantingByConditions(DBManager dbManager,
			String conditions, int pageNo, int rowsPerPage) throws Exception {
		DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
		Collection collection = new ArrayList();

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}
		int count = dbPlantingpolicylist.getNewPlantingCount(SqlUtils.getWherePartForGetCount(conditions));
		collection = dbPlantingpolicylist.findNewPlantingByConditions(conditions,pageNo, rowsPerPage);
		PageRecord pageRecord = new PageRecord(count, pageNo, 1, rowsPerPage,collection);
		return pageRecord;
	}
}
