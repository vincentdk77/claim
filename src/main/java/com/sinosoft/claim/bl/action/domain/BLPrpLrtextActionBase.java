package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrtextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrtext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrtext-追偿损余文字说明的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrtextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrtextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLrtextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrtextDto prpLrtextDto) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //插入记录
        dbPrpLrtext.insert(prpLrtextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //删除记录
        dbPrpLrtext.delete(claimNo, textType, serialNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //按条件删除记录
        dbPrpLrtext.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrtextDto prpLrtextDto) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //更新记录
        dbPrpLrtext.update(prpLrtextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param serialNo 序号
     * @param lineNo 行号
     * @return prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public PrpLrtextDto findByPrimaryKey(DBManager dbManager,String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //声明DTO
        PrpLrtextDto prpLrtextDto = null;
        //查询数据,赋值给DTO
        prpLrtextDto = dbPrpLrtext.findByPrimaryKey(claimNo, textType, serialNo, lineNo);
        return prpLrtextDto;
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
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrtext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrtext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLrtextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrtext.findByConditions(conditions);
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
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrtext.getCount(conditions);
        return count;
    }
}
