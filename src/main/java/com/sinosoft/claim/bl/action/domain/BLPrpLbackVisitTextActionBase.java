package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisitText;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitText--回访备注表的业务逻辑对象类<br>
 * 创建于 2005-03-23 09:00:38.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitTextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitTextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //插入记录
        dbPrpLbackVisitText.insert(prpLbackVisitTextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param lineNo 行序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //删除记录
        dbPrpLbackVisitText.delete(backVisitID, registNo, backVisitType, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //按条件删除记录
        dbPrpLbackVisitText.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //更新记录
        dbPrpLbackVisitText.update(prpLbackVisitTextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param lineNo 行序号
     * @return prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextDto findByPrimaryKey(DBManager dbManager,int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        //声明DTO
        PrpLbackVisitTextDto prpLbackVisitTextDto = null;
        //查询数据,赋值给DTO
        prpLbackVisitTextDto = dbPrpLbackVisitText.findByPrimaryKey(backVisitID, registNo, backVisitType, lineNo);
        return prpLbackVisitTextDto;
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
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitText.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLbackVisitText.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLbackVisitTextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLbackVisitText.findByConditions(conditions);
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
        DBPrpLbackVisitText dbPrpLbackVisitText = new DBPrpLbackVisitText(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitText.getCount(conditions);
        return count;
    }
}
