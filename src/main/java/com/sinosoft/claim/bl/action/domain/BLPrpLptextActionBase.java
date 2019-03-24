package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLptext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLptext-预赔文字表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.062<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLptextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLptextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLptextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLptextDto prpLptextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLptextDto prpLptextDto) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //插入记录
        dbPrpLptext.insert(prpLptextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param preCompensateNo 预赔登记号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo,int lineNo) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //删除记录
        dbPrpLptext.delete(preCompensateNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //按条件删除记录
        dbPrpLptext.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLptextDto prpLptextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLptextDto prpLptextDto) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //更新记录
        dbPrpLptext.update(prpLptextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param preCompensateNo 预赔登记号
     * @param lineNo 行号
     * @return prpLptextDto prpLptextDto
     * @throws Exception
     */
    public PrpLptextDto findByPrimaryKey(DBManager dbManager,String preCompensateNo,int lineNo) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        //声明DTO
        PrpLptextDto prpLptextDto = null;
        //查询数据,赋值给DTO
        prpLptextDto = dbPrpLptext.findByPrimaryKey(preCompensateNo, lineNo);
        return prpLptextDto;
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
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLptext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLptext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLptextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLptext.findByConditions(conditions);
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
        DBPrpLptext dbPrpLptext = new DBPrpLptext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLptext.getCount(conditions);
        return count;
    }
}
