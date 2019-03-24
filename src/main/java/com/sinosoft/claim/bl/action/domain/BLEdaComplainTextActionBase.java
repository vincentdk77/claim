package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdaComplainText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainText投诉文字表的业务逻辑对象类<br>
 * 创建于 2005-08-20 17:56:01.525<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainTextActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainTextActionBase.class);

    /**
     * 构造函数
     */
    public BLEdaComplainTextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //插入记录
        dbEdaComplainText.insert(edaComplainTextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param acceptNo 投诉登记号
     * @param textType 文本类型
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //删除记录
        dbEdaComplainText.delete(acceptNo, textType, serialNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //按条件删除记录
        dbEdaComplainText.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //更新记录
        dbEdaComplainText.update(edaComplainTextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param acceptNo 投诉登记号
     * @param textType 文本类型
     * @param serialNo 序号
     * @param lineNo 行号
     * @return edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public EdaComplainTextDto findByPrimaryKey(DBManager dbManager,double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        //声明DTO
        EdaComplainTextDto edaComplainTextDto = null;
        //查询数据,赋值给DTO
        edaComplainTextDto = dbEdaComplainText.findByPrimaryKey(acceptNo, textType, serialNo, lineNo);
        return edaComplainTextDto;
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
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdaComplainText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含edaComplainTextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdaComplainText.findByConditions(conditions);
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
        DBEdaComplainText dbEdaComplainText = new DBEdaComplainText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainText.getCount(conditions);
        return count;
    }
}
