package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalPolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalPolicyList;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGPOLICYLIST的业务逻辑对象类<br>
 */
public class BLMedicalPolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalPolicyListActionBase.class);

    /**
     * 构造函数
     */
    public BLMedicalPolicyListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalPolicyListDto medicalpolicylistDto)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //插入记录
        dbMedicalpolicylist.insert(medicalpolicylistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //删除记录
        dbMedicalpolicylist.delete(inusrelistcode, idcard);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //按条件删除记录
        dbMedicalpolicylist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalPolicyListDto medicalpolicylistDto)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //更新记录
        dbMedicalpolicylist.update(medicalpolicylistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public MedicalPolicyListDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //声明DTO
        MedicalPolicyListDto medicalpolicylistDto = null;
        //查询数据,赋值给DTO
        medicalpolicylistDto = dbMedicalpolicylist.findByPrimaryKey(inusrelistcode, idcard);
        return medicalpolicylistDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //System.err.println("MedicalPolicyList查询条件：" + conditions);
        int count = dbMedicalpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //System.err.println("MedicalPolicyList查询数目：" + count);
        collection = dbMedicalpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        //System.err.println("查询保单清单");
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含medicalpolicylistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMedicalpolicylist.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalpolicylist.getCount(conditions);
        return count;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
        DBMedicalPolicyList dbMedicalPolicyList = new DBMedicalPolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbMedicalPolicyList.getSum(conditions,fieldName);
        return sum;
    }
}
