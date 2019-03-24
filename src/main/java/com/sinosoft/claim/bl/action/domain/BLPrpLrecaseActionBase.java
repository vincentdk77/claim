package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrecase;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrecase-重开赔案表;的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrecaseActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrecaseActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLrecaseActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrecaseDto prpLrecaseDto) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //插入记录
        dbPrpLrecase.insert(prpLrecaseDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param serialNo 重开赔案次数
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //删除记录
        dbPrpLrecase.delete(claimNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //按条件删除记录
        dbPrpLrecase.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrecaseDto prpLrecaseDto) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //更新记录
        dbPrpLrecase.update(prpLrecaseDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param serialNo 重开赔案次数
     * @return prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public PrpLrecaseDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //声明DTO
        PrpLrecaseDto prpLrecaseDto = null;
        //查询数据,赋值给DTO
        prpLrecaseDto = dbPrpLrecase.findByPrimaryKey(claimNo, serialNo);
        return prpLrecaseDto;
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
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrecase.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrecase.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLrecaseDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrecase.findByConditions(conditions);
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
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrecase.getCount(conditions);
        return count;
    }
}
