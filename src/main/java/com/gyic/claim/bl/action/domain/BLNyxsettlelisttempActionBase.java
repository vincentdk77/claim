package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelisttemp;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleListTemp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXSETTLELISTTEMP的业务逻辑对象类<br>
 */
public class BLNyxsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelisttempActionBase.class);

    /**
     * 构造函数
     */
    public BLNyxsettlelisttempActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //插入记录
        dbNyxsettlelisttemp.insert(nyxsettlelisttempDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //删除记录
        dbNyxsettlelisttemp.delete(registcode, stringtimestamp, indexofsettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //按条件删除记录
        dbNyxsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //更新记录
        dbNyxsettlelisttemp.update(nyxsettlelisttempDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //声明DTO
        NyxsettlelisttempDto nyxsettlelisttempDto = null;
        //查询数据,赋值给DTO
        nyxsettlelisttempDto = dbNyxsettlelisttemp.findByPrimaryKey(registcode, stringtimestamp, indexofsettle);
        return nyxsettlelisttempDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含nyxsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxsettlelisttemp.findByConditions(conditions);
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
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelisttemp.getCount(conditions);
        return count;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
    	DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbNyxsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
