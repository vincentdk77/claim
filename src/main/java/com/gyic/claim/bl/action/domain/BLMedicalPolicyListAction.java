package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalPolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalPolicyList;

/**
 * ����PLANTINGPOLICYLIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLMedicalPolicyListAction extends BLMedicalPolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalPolicyListAction.class);

    /**
     * ���캯��
     */
    public BLMedicalPolicyListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param medicalpolicylistDto medicalpolicylistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MedicalPolicyListDto medicalpolicylistDto,String mode)
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
//    public PageRecord findMedicalByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
//            throws Exception{
//        DBMedicalPolicyList dbMedicalPolicyList = new DBMedicalPolicyList(dbManager);
//        Collection collection = new ArrayList();
//
//        if(conditions.trim().length()==0){
//            conditions = "1=1";
//        }
//        int count = dbMedicalPolicyList.getMedicalCount(SqlUtils.getWherePartForGetCount(conditions));
//        collection = dbMedicalPolicyList.findMedicalByConditions(conditions,pageNo,rowsPerPage);
//        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
//        return pageRecord;
//    }
}
