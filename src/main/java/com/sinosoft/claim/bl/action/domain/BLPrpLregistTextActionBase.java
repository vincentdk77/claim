package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLregistText-报案文字表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistTextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLregistTextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLregistTextDto prpLregistTextDto) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //插入记录
        dbPrpLregistText.insert(prpLregistTextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 出险登记号
     * @param textType 文本类型
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String textType,int lineNo) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //删除记录
        dbPrpLregistText.delete(registNo, textType, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //按条件删除记录
        dbPrpLregistText.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLregistTextDto prpLregistTextDto) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //更新记录
        dbPrpLregistText.update(prpLregistTextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 出险登记号
     * @param textType 文本类型
     * @param lineNo 行号
     * @return prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public PrpLregistTextDto findByPrimaryKey(DBManager dbManager,String registNo,String textType,int lineNo) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        //声明DTO
        PrpLregistTextDto prpLregistTextDto = null;
        //查询数据,赋值给DTO
        prpLregistTextDto = dbPrpLregistText.findByPrimaryKey(registNo, textType, lineNo);
        return prpLregistTextDto;
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
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregistText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLregistText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLregistTextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregistText.findByConditions(conditions);
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
        DBPrpLregistText dbPrpLregistText = new DBPrpLregistText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregistText.getCount(conditions);
        return count;
    }
}
