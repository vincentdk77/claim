package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdAgentSysData的数据访问对象基类<br>
 * 创建于 2005-07-19 09:58:57.588<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdAgentSysDataBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBEdAgentSysDataBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdAgentSysDataBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void insert(EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        String mainStatement = " Insert Into EdAgentSysData (" + 
                           " CALLID," + 
                           " ANI," + 
                           " BUSINESSNO," + 
                           " AGENTID," + 
                           " TASKCODE," + 
                           " RECORDFLAG," + 
                           " INPUTDATE," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + edAgentSysDataDto.getCALLID() + "'," + 
                           "'" + edAgentSysDataDto.getANI() + "'," + 
                           "'" + edAgentSysDataDto.getBUSINESSNO() + "'," + 
                           "'" + edAgentSysDataDto.getAGENTID() + "'," + 
                           "'" + edAgentSysDataDto.getTASKCODE() + "'," + 
                           "'" + edAgentSysDataDto.getRECORDFLAG() + "'," + 
                           "'" + edAgentSysDataDto.getINPUTDATE() + "'," + 
                           "'" + edAgentSysDataDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,edAgentSysDataDto.getCALLID());
        dbManager.setString(2,edAgentSysDataDto.getANI());
        dbManager.setString(3,edAgentSysDataDto.getBUSINESSNO());
        dbManager.setString(4,edAgentSysDataDto.getAGENTID());
        dbManager.setString(5,edAgentSysDataDto.getTASKCODE());
        dbManager.setString(6,edAgentSysDataDto.getRECORDFLAG());
        dbManager.setDateTime(7,edAgentSysDataDto.getINPUTDATE());
        dbManager.setString(8,edAgentSysDataDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBEdAgentSysDataBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            EdAgentSysDataDto edAgentSysDataDto = (EdAgentSysDataDto)i.next();
            insert(edAgentSysDataDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param cALLID 呼叫标识
     * @throws Exception
     */
    public void delete(String cALLID) throws Exception{
        String statement = " Delete From EdAgentSysData" + 
	            		   " Where " +
                           " CALLID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From EdAgentSysData Where " +
                           " CALLID = '" + cALLID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,cALLID);
        dbManager.executePreparedUpdate();
        logger.info("DBEdAgentSysDataBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void update(EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        String statement = " Update EdAgentSysData Set ANI = ?," + 
                           " BUSINESSNO = ?," + 
                           " AGENTID = ?," + 
                           " TASKCODE = ?," + 
                           " RECORDFLAG = ?," + 
                           " INPUTDATE = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " CALLID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update EdAgentSysData Set " + 
                           " CALLID = '" + edAgentSysDataDto.getCALLID() + "'," + 
                           " ANI = '" + edAgentSysDataDto.getANI() + "'," + 
                           " BUSINESSNO = '" + edAgentSysDataDto.getBUSINESSNO() + "'," + 
                           " AGENTID = '" + edAgentSysDataDto.getAGENTID() + "'," + 
                           " TASKCODE = '" + edAgentSysDataDto.getTASKCODE() + "'," + 
                           " RECORDFLAG = '" + edAgentSysDataDto.getRECORDFLAG() + "'," + 
                           " INPUTDATE = '" + edAgentSysDataDto.getINPUTDATE() + "'," + 
                           " Flag = '" + edAgentSysDataDto.getFlag() + "'" + 
			               " Where " +
                           " CALLID = '" + edAgentSysDataDto.getCALLID() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,edAgentSysDataDto.getANI());
        dbManager.setString(2,edAgentSysDataDto.getBUSINESSNO());
        dbManager.setString(3,edAgentSysDataDto.getAGENTID());
        dbManager.setString(4,edAgentSysDataDto.getTASKCODE());
        dbManager.setString(5,edAgentSysDataDto.getRECORDFLAG());
        dbManager.setDateTime(6,edAgentSysDataDto.getINPUTDATE());
        dbManager.setString(7,edAgentSysDataDto.getFlag());
        //设置条件字段;
        dbManager.setString(8,edAgentSysDataDto.getCALLID());
        dbManager.executePreparedUpdate();

        logger.info("DBEdAgentSysDataBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param cALLID 呼叫标识
     * @return EdAgentSysDataDto
     * @throws Exception
     */
    public EdAgentSysDataDto findByPrimaryKey(String cALLID) throws Exception{
        String mainStatement = " Select CALLID," + 
                           " ANI," + 
                           " BUSINESSNO," + 
                           " AGENTID," + 
                           " TASKCODE," + 
                           " RECORDFLAG," + 
                           " INPUTDATE," + 
                           " Flag From EdAgentSysData";
        String statement = mainStatement + " Where " +
                           " CALLID = ?";
        EdAgentSysDataDto edAgentSysDataDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CALLID = '" + cALLID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,cALLID);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            edAgentSysDataDto = new EdAgentSysDataDto();
            edAgentSysDataDto.setCALLID(dbManager.getString(resultSet,1));
            edAgentSysDataDto.setANI(dbManager.getString(resultSet,2));
            edAgentSysDataDto.setBUSINESSNO(dbManager.getString(resultSet,3));
            edAgentSysDataDto.setAGENTID(dbManager.getString(resultSet,4));
            edAgentSysDataDto.setTASKCODE(dbManager.getString(resultSet,5));
            edAgentSysDataDto.setRECORDFLAG(dbManager.getString(resultSet,6));
            edAgentSysDataDto.setINPUTDATE(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            edAgentSysDataDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        logger.info("DBEdAgentSysDataBase.findByPrimaryKey() success!");
        return edAgentSysDataDto;
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
        String statement = "Select CALLID," + 
                           " ANI," + 
                           " BUSINESSNO," + 
                           " AGENTID," + 
                           " TASKCODE," + 
                           " RECORDFLAG," + 
                           " INPUTDATE," + 
                           " Flag From EdAgentSysData Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        EdAgentSysDataDto edAgentSysDataDto = null;
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

            edAgentSysDataDto = new EdAgentSysDataDto();
            edAgentSysDataDto.setCALLID(dbManager.getString(resultSet,1));
            edAgentSysDataDto.setANI(dbManager.getString(resultSet,2));
            edAgentSysDataDto.setBUSINESSNO(dbManager.getString(resultSet,3));
            edAgentSysDataDto.setAGENTID(dbManager.getString(resultSet,4));
            edAgentSysDataDto.setTASKCODE(dbManager.getString(resultSet,5));
            edAgentSysDataDto.setRECORDFLAG(dbManager.getString(resultSet,6));
            edAgentSysDataDto.setINPUTDATE(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            edAgentSysDataDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(edAgentSysDataDto);
        }
        resultSet.close();
        logger.info("DBEdAgentSysDataBase.findByConditions() success!");
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
        String statement = "Delete From EdAgentSysData Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBEdAgentSysDataBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from EdAgentSysData Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBEdAgentSysDataBase.getCount() success!");
        return count;
    }
}
