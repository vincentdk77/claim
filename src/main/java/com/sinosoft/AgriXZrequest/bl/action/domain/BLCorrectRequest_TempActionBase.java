package com.sinosoft.AgriXZrequest.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.AgriXZrequest.resource.dtofactory.domain.DBCorrectRequest_Temp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CorrectRequest_Temp的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCorrectRequest_TempActionBase{
    private static Logger logger = Logger.getLogger(BLCorrectRequest_TempActionBase.class);

    /**
     * 构造函数
     */
    public BLCorrectRequest_TempActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //插入记录
        dbCorrectRequest_Temp.insert(correctRequest_TempDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param batchNo batchNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String batchNo)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //删除记录
        dbCorrectRequest_Temp.delete(batchNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //按条件删除记录
        dbCorrectRequest_Temp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //更新记录
        dbCorrectRequest_Temp.update(correctRequest_TempDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param batchNo batchNo
     * @return correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public CorrectRequest_TempDto findByPrimaryKey(DBManager dbManager,String batchNo)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //声明DTO
        CorrectRequest_TempDto correctRequest_TempDto = null;
        //查询数据,赋值给DTO
        correctRequest_TempDto = dbCorrectRequest_Temp.findByPrimaryKey(batchNo);
        return correctRequest_TempDto;
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
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCorrectRequest_Temp.getCount(conditions);
        collection = dbCorrectRequest_Temp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含correctRequest_TempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCorrectRequest_Temp.findByConditions(conditions);
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
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCorrectRequest_Temp.getCount(conditions);
        return count;
    }
}
