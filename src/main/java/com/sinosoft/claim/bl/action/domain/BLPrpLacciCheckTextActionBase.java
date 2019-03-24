package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheckText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciCheckText--调查文本信息表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckTextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLacciCheckTextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLacciCheckTextDto prpLacciCheckTextDto) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //插入记录
        dbPrpLacciCheckText.insert(prpLacciCheckTextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param checkNo 调查号
     * @param textType 文字说明类型
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String checkNo,String textType,long lineNo) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //删除记录
        dbPrpLacciCheckText.delete(checkNo, textType, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //按条件删除记录
        dbPrpLacciCheckText.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLacciCheckTextDto prpLacciCheckTextDto) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //更新记录
        dbPrpLacciCheckText.update(prpLacciCheckTextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param checkNo 调查号
     * @param textType 文字说明类型
     * @param lineNo 行号
     * @return prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public PrpLacciCheckTextDto findByPrimaryKey(DBManager dbManager,String checkNo,String textType,long lineNo) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        //声明DTO
        PrpLacciCheckTextDto prpLacciCheckTextDto = null;
        //查询数据,赋值给DTO
        prpLacciCheckTextDto = dbPrpLacciCheckText.findByPrimaryKey(checkNo, textType, lineNo);
        return prpLacciCheckTextDto;
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
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheckText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLacciCheckText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLacciCheckTextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLacciCheckText.findByConditions(conditions);
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
        DBPrpLacciCheckText dbPrpLacciCheckText = new DBPrpLacciCheckText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheckText.getCount(conditions);
        return count;
    }
}
