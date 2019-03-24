package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBCiClaimCompelcrash;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimCompelcrash 理赔车车互碰数据表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCompelcrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCompelcrashActionBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimCompelcrashActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //插入记录
        dbCiClaimCompelcrash.insert(ciClaimCompelcrashDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //删除记录
        dbCiClaimCompelcrash.delete(registNo, policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //按条件删除记录
        dbCiClaimCompelcrash.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //更新记录
        dbCiClaimCompelcrash.update(ciClaimCompelcrashDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号
     * @return ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //声明DTO
        CiClaimCompelcrashDto ciClaimCompelcrashDto = null;
        //查询数据,赋值给DTO
        ciClaimCompelcrashDto = dbCiClaimCompelcrash.findByPrimaryKey(registNo, policyNo);
        return ciClaimCompelcrashDto;
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
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimCompelcrash.getCount(conditions);
        collection = dbCiClaimCompelcrash.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含ciClaimCompelcrashDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimCompelcrash.findByConditions(conditions);
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
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimCompelcrash.getCount(conditions);
        return count;
    }
}
