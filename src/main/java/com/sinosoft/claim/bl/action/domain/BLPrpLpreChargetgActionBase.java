package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpreChargetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpreChargetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLpreChargetgActionBase {
	private static Log logger = LogFactory.getLog(BLPrpLpreChargetgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpreChargetgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpreChargetgDto prpLpreChargetgDto) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //插入记录
        dbPrpLpreChargetg.insert(prpLpreChargetgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //删除记录
        dbPrpLpreChargetg.delete(preCompensateNo,serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //按条件删除记录
        dbPrpLpreChargetg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpreChargetgDto PrpLpreChargetgDto) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //更新记录
        dbPrpLpreChargetg.update(PrpLpreChargetgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @return PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public PrpLpreChargetgDto findByPrimaryKey(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //声明DTO
        PrpLpreChargetgDto PrpLpreChargetgDto = null;
        //查询数据,赋值给DTO
        PrpLpreChargetgDto = dbPrpLpreChargetg.findByPrimaryKey(preCompensateNo,serialNo);
        return PrpLpreChargetgDto;
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
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreChargetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpreChargetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含PrpLpreChargetgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpreChargetg.findByConditions(conditions);
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
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreChargetg.getCount(conditions);
        return count;
    }
}
