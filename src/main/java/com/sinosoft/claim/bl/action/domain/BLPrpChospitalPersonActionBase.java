package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpChospitalPerson;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpChospitalPerson的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpChospitalPersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpChospitalPersonActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpChospitalPersonActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpChospitalPersonDto prpChospitalPersonDto)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //插入记录
        dbPrpChospitalPerson.insert(prpChospitalPersonDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo PolicyNo
     * @param hospitalNumber HospitalNumber
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String hospitalNumber)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //删除记录
        dbPrpChospitalPerson.delete(policyNo, hospitalNumber);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //按条件删除记录
        dbPrpChospitalPerson.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpChospitalPersonDto prpChospitalPersonDto)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //更新记录
        dbPrpChospitalPerson.update(prpChospitalPersonDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo PolicyNo
     * @param hospitalNumber HospitalNumber
     * @return prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public PrpChospitalPersonDto findByPrimaryKey(DBManager dbManager,String policyNo,String hospitalNumber)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //声明DTO
        PrpChospitalPersonDto prpChospitalPersonDto = null;
        //查询数据,赋值给DTO
        prpChospitalPersonDto = dbPrpChospitalPerson.findByPrimaryKey(policyNo, hospitalNumber);
        return prpChospitalPersonDto;
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
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpChospitalPerson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpChospitalPerson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpChospitalPersonDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpChospitalPerson.findByConditions(conditions);
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
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpChospitalPerson.getCount(conditions);
        return count;
    }
}
