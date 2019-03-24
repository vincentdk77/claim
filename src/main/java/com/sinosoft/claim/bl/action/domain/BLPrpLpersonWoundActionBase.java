package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonWound-伤情信息表(新增)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonWoundActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonWoundActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonWoundActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //插入记录
        dbPrpLpersonWound.insert(prpLpersonWoundDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param serialNo 序号
     * @param personNo 人员序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,int personNo) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //删除记录
        dbPrpLpersonWound.delete(registNo, serialNo, personNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //按条件删除记录
        dbPrpLpersonWound.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //更新记录
        dbPrpLpersonWound.update(prpLpersonWoundDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param serialNo 序号
     * @param personNo 人员序号
     * @return prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public PrpLpersonWoundDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,int personNo) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        //声明DTO
        PrpLpersonWoundDto prpLpersonWoundDto = null;
        //查询数据,赋值给DTO
        prpLpersonWoundDto = dbPrpLpersonWound.findByPrimaryKey(registNo, serialNo, personNo);
        return prpLpersonWoundDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonWound.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpersonWound.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpersonWoundDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpersonWound.findByConditions(conditions);
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
        DBPrpLpersonWound dbPrpLpersonWound = new DBPrpLpersonWound(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonWound.getCount(conditions);
        return count;
    }
}
