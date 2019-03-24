package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGnodeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgnode工作流节点模板表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGnodeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpGnodeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGnodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public void insert(PrpGnodeDto prpGnodeDto) throws Exception{
        String statement = " Insert Into PrpGnode(" + 
                           " ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " SonNodeNo," + 
                           " SonNodeName," + 
                           " LimitDay," + 
                           " GradeCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " NodeFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpGnodeDto.getModelNo());
        dbManager.setInt(2,prpGnodeDto.getNodeNo());
        dbManager.setString(3,prpGnodeDto.getNodeName());
        dbManager.setInt(4,prpGnodeDto.getSonNodeNo());
        dbManager.setString(5,prpGnodeDto.getSonNodeName());
        dbManager.setInt(6,prpGnodeDto.getLimitDay());
        dbManager.setString(7,prpGnodeDto.getGradeCode());
        dbManager.setString(8,prpGnodeDto.getComCode());
        dbManager.setString(9,prpGnodeDto.getMakeCom());
        dbManager.setString(10,prpGnodeDto.getNodeFlag());
        dbManager.setString(11,prpGnodeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGnodeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGnodeDto prpGnodeDto = (PrpGnodeDto)i.next();
            insert(prpGnodeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param modelNo 模板号
     * @param nodeNo 节点号
     * @param sonNodeNo 子节点号
     * @throws Exception
     */
    public void delete(int modelNo,int nodeNo,int sonNodeNo) throws Exception{
        String statement = " Delete From PrpGnode Where " +
                           " ModelNo = ? And " + 
                           " NodeNo = ? And " + 
                           " SonNodeNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,nodeNo);
        dbManager.setInt(3,sonNodeNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGnodeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public void update(PrpGnodeDto prpGnodeDto) throws Exception{
        String statement = " Update PrpGnode Set NodeName = ?," + 
                           " SonNodeName = ?," + 
                           " LimitDay = ?," + 
                           " GradeCode = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " NodeFlag = ?," + 
                           " Flag = ? Where " +
                           " ModelNo = ? And " + 
                           " NodeNo = ? And " + 
                           " SonNodeNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpGnodeDto.getNodeName());
        dbManager.setString(2,prpGnodeDto.getSonNodeName());
        dbManager.setInt(3,prpGnodeDto.getLimitDay());
        dbManager.setString(4,prpGnodeDto.getGradeCode());
        dbManager.setString(5,prpGnodeDto.getComCode());
        dbManager.setString(6,prpGnodeDto.getMakeCom());
        dbManager.setString(7,prpGnodeDto.getNodeFlag());
        dbManager.setString(8,prpGnodeDto.getFlag());
        //设置条件字段;
        dbManager.setInt(9,prpGnodeDto.getModelNo());
        dbManager.setInt(10,prpGnodeDto.getNodeNo());
        dbManager.setInt(11,prpGnodeDto.getSonNodeNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGnodeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param modelNo 模板号
     * @param nodeNo 节点号
     * @param sonNodeNo 子节点号
     * @return PrpGnodeDto
     * @throws Exception
     */
    public PrpGnodeDto findByPrimaryKey(int modelNo,int nodeNo,int sonNodeNo) throws Exception{
        String statement = " Select ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " SonNodeNo," + 
                           " SonNodeName," + 
                           " LimitDay," + 
                           " GradeCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " NodeFlag," + 
                           " Flag From PrpGnode Where " +
                           " ModelNo = ? And " + 
                           " NodeNo = ? And " + 
                           " SonNodeNo = ?";
        PrpGnodeDto prpGnodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,nodeNo);
        dbManager.setInt(3,sonNodeNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGnodeDto = new PrpGnodeDto();
            prpGnodeDto.setModelNo(dbManager.getInt(resultSet,1));
            prpGnodeDto.setNodeNo(dbManager.getInt(resultSet,2));
            prpGnodeDto.setNodeName(dbManager.getString(resultSet,3));
            prpGnodeDto.setSonNodeNo(dbManager.getInt(resultSet,4));
            prpGnodeDto.setSonNodeName(dbManager.getString(resultSet,5));
            prpGnodeDto.setLimitDay(dbManager.getInt(resultSet,6));
            prpGnodeDto.setGradeCode(dbManager.getString(resultSet,7));
            prpGnodeDto.setComCode(dbManager.getString(resultSet,8));
            prpGnodeDto.setMakeCom(dbManager.getString(resultSet,9));
            prpGnodeDto.setNodeFlag(dbManager.getString(resultSet,10));
            prpGnodeDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpGnodeBase.findByPrimaryKey() success!");
        return prpGnodeDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " SonNodeNo," + 
                           " SonNodeName," + 
                           " LimitDay," + 
                           " GradeCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " NodeFlag," + 
                           " Flag From PrpGnode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGnodeDto prpGnodeDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpGnodeDto = new PrpGnodeDto();
            prpGnodeDto.setModelNo(dbManager.getInt(resultSet,1));
            prpGnodeDto.setNodeNo(dbManager.getInt(resultSet,2));
            prpGnodeDto.setNodeName(dbManager.getString(resultSet,3));
            prpGnodeDto.setSonNodeNo(dbManager.getInt(resultSet,4));
            prpGnodeDto.setSonNodeName(dbManager.getString(resultSet,5));
            prpGnodeDto.setLimitDay(dbManager.getInt(resultSet,6));
            prpGnodeDto.setGradeCode(dbManager.getString(resultSet,7));
            prpGnodeDto.setComCode(dbManager.getString(resultSet,8));
            prpGnodeDto.setMakeCom(dbManager.getString(resultSet,9));
            prpGnodeDto.setNodeFlag(dbManager.getString(resultSet,10));
            prpGnodeDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpGnodeDto);
        }
        resultSet.close();
        log.info("DBPrpGnodeBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpGnode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGnodeBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpGnode Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGnodeBase.getCount() success!");
        return count;
    }
}
