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
 * 这是PLANTINGPOLICYLIST的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLMedicalPolicyListAction extends BLMedicalPolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalPolicyListAction.class);

    /**
     * 构造函数
     */
    public BLMedicalPolicyListAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param medicalpolicylistDto medicalpolicylistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MedicalPolicyListDto medicalpolicylistDto,String mode)
            throws Exception{
    }
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
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
