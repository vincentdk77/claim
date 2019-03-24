package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLreplevy;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLreplevy-权益转让及追偿信息的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLreplevyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLreplevyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLreplevyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLreplevyDto prpLreplevyDto) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //插入记录
        dbPrpLreplevy.insert(prpLreplevyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param times 次数
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int times) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //删除记录
        dbPrpLreplevy.delete(claimNo, times);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //按条件删除记录
        dbPrpLreplevy.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLreplevyDto prpLreplevyDto) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //更新记录
        dbPrpLreplevy.update(prpLreplevyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param times 次数
     * @return prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public PrpLreplevyDto findByPrimaryKey(DBManager dbManager,String claimNo,int times) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        //声明DTO
        PrpLreplevyDto prpLreplevyDto = null;
        //查询数据,赋值给DTO
        prpLreplevyDto = dbPrpLreplevy.findByPrimaryKey(claimNo, times);
        return prpLreplevyDto;
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
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreplevy.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLreplevy.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLreplevyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLreplevy.findByConditions(conditions);
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
        DBPrpLreplevy dbPrpLreplevy = new DBPrpLreplevy(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreplevy.getCount(conditions);
        return count;
    }
}
