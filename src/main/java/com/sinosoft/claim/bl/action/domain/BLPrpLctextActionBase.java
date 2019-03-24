package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLctext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLctext-赔款计算文字表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLctextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLctextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLctextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLctextDto prpLctextDto) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //插入记录
        dbPrpLctext.insert(prpLctextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param textType 文字说明类型 ▲
--** 赔款计算/备注/…
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String textType,int lineNo) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //删除记录
        dbPrpLctext.delete(compensateNo, textType, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //按条件删除记录
        dbPrpLctext.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLctextDto prpLctextDto) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //更新记录
        dbPrpLctext.update(prpLctextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param textType 文字说明类型 ▲
--** 赔款计算/备注/…
     * @param lineNo 行号
     * @return prpLctextDto prpLctextDto
     * @throws Exception
     */
    public PrpLctextDto findByPrimaryKey(DBManager dbManager,String compensateNo,String textType,int lineNo) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //声明DTO
        PrpLctextDto prpLctextDto = null;
        //查询数据,赋值给DTO
        prpLctextDto = dbPrpLctext.findByPrimaryKey(compensateNo, textType, lineNo);
        return prpLctextDto;
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
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLctext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLctext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLctextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLctext.findByConditions(conditions);
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
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLctext.getCount(conditions);
        return count;
    }
}
