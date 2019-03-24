package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保清单头表的数据访问对象基类<br>
 */
public class DBInsuremainlistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBInsuremainlistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBInsuremainlistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void insert(InsuremainlistDto insuremainlistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Insuremainlist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(insuremainlistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getFareacode()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getProposalno()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getValidity()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getUpdatecode()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getUpdatedate()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getRemark()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getStarttime()).append("',");
            debugBuffer.append("'").append(insuremainlistDto.getEndtime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,insuremainlistDto.getInusrelistcode());
        dbManager.setString(2,insuremainlistDto.getFareacode());
        dbManager.setString(3,insuremainlistDto.getClasscode());
        dbManager.setString(4,insuremainlistDto.getRiskcode());
        dbManager.setString(5,insuremainlistDto.getProposalno());
        dbManager.setString(6,insuremainlistDto.getPolicyno());
        dbManager.setString(7,insuremainlistDto.getValidity());
        dbManager.setString(8,insuremainlistDto.getUpdatecode());
        dbManager.setDateTime(9,insuremainlistDto.getUpdatedate());
        dbManager.setString(10,insuremainlistDto.getOpcode());
        dbManager.setString(11,insuremainlistDto.getRemark());
        dbManager.setDateTime(12,insuremainlistDto.getStarttime());
        dbManager.setDateTime(13,insuremainlistDto.getEndtime());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Insuremainlist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            InsuremainlistDto insuremainlistDto = (InsuremainlistDto)i.next();
            dbManager.setString(1,insuremainlistDto.getInusrelistcode());
            dbManager.setString(2,insuremainlistDto.getFareacode());
            dbManager.setString(3,insuremainlistDto.getClasscode());
            dbManager.setString(4,insuremainlistDto.getRiskcode());
            dbManager.setString(5,insuremainlistDto.getProposalno());
            dbManager.setString(6,insuremainlistDto.getPolicyno());
            dbManager.setString(7,insuremainlistDto.getValidity());
            dbManager.setString(8,insuremainlistDto.getUpdatecode());
            dbManager.setDateTime(9,insuremainlistDto.getUpdatedate());
            dbManager.setString(10,insuremainlistDto.getOpcode());
            dbManager.setString(11,insuremainlistDto.getRemark());
            dbManager.setDateTime(12,insuremainlistDto.getStarttime());
            dbManager.setDateTime(13,insuremainlistDto.getEndtime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode 投保清单编号
     * @throws Exception
     */
    public void delete(String inusrelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Insuremainlist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void update(InsuremainlistDto insuremainlistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Insuremainlist SET ");
        buffer.append("Fareacode = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Proposalno = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Updatecode = ?, ");
        buffer.append("Updatedate = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Starttime = ?, ");
        buffer.append("Endtime = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Insuremainlist SET ");
            debugBuffer.append("Fareacode = '" + insuremainlistDto.getFareacode() + "', ");
            debugBuffer.append("Classcode = '" + insuremainlistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + insuremainlistDto.getRiskcode() + "', ");
            debugBuffer.append("Proposalno = '" + insuremainlistDto.getProposalno() + "', ");
            debugBuffer.append("Policyno = '" + insuremainlistDto.getPolicyno() + "', ");
            debugBuffer.append("Validity = '" + insuremainlistDto.getValidity() + "', ");
            debugBuffer.append("Updatecode = '" + insuremainlistDto.getUpdatecode() + "', ");
            debugBuffer.append("Updatedate = '" + insuremainlistDto.getUpdatedate() + "', ");
            debugBuffer.append("Opcode = '" + insuremainlistDto.getOpcode() + "', ");
            debugBuffer.append("Remark = '" + insuremainlistDto.getRemark() + "', ");
            debugBuffer.append("Starttime = '" + insuremainlistDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + insuremainlistDto.getEndtime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(insuremainlistDto.getInusrelistcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,insuremainlistDto.getFareacode());
        dbManager.setString(2,insuremainlistDto.getClasscode());
        dbManager.setString(3,insuremainlistDto.getRiskcode());
        dbManager.setString(4,insuremainlistDto.getProposalno());
        dbManager.setString(5,insuremainlistDto.getPolicyno());
        dbManager.setString(6,insuremainlistDto.getValidity());
        dbManager.setString(7,insuremainlistDto.getUpdatecode());
        dbManager.setDateTime(8,insuremainlistDto.getUpdatedate());
        dbManager.setString(9,insuremainlistDto.getOpcode());
        dbManager.setString(10,insuremainlistDto.getRemark());
        dbManager.setDateTime(11,insuremainlistDto.getStarttime());
        dbManager.setDateTime(12,insuremainlistDto.getEndtime());
        //设置条件字段;
        dbManager.setString(13,insuremainlistDto.getInusrelistcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode 投保清单编号
     * @return InsuremainlistDto
     * @throws Exception
     */
    public InsuremainlistDto findByPrimaryKey(String inusrelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append("FROM Insuremainlist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        InsuremainlistDto insuremainlistDto = null;
        if(resultSet.next()){
            insuremainlistDto = new InsuremainlistDto();
            insuremainlistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            insuremainlistDto.setFareacode(dbManager.getString(resultSet,2));
            insuremainlistDto.setClasscode(dbManager.getString(resultSet,3));
            insuremainlistDto.setRiskcode(dbManager.getString(resultSet,4));
            insuremainlistDto.setProposalno(dbManager.getString(resultSet,5));
            insuremainlistDto.setPolicyno(dbManager.getString(resultSet,6));
            insuremainlistDto.setValidity(dbManager.getString(resultSet,7));
            insuremainlistDto.setUpdatecode(dbManager.getString(resultSet,8));
            insuremainlistDto.setUpdatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
            insuremainlistDto.setOpcode(dbManager.getString(resultSet,10));
            insuremainlistDto.setRemark(dbManager.getString(resultSet,11));
            insuremainlistDto.setStarttime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            insuremainlistDto.setEndtime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
        }
        resultSet.close();
        return insuremainlistDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append("FROM Insuremainlist WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        InsuremainlistDto insuremainlistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            insuremainlistDto = new InsuremainlistDto();
            insuremainlistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            insuremainlistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            insuremainlistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            insuremainlistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            insuremainlistDto.setProposalno(dbManager.getString(resultSet,"Proposalno"));
            insuremainlistDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            insuremainlistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            insuremainlistDto.setUpdatecode(dbManager.getString(resultSet,"Updatecode"));
            insuremainlistDto.setUpdatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Updatedate"));
            insuremainlistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            insuremainlistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            insuremainlistDto.setStarttime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Starttime"));
            insuremainlistDto.setEndtime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Endtime"));
            collection.add(insuremainlistDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Insuremainlist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Insuremainlist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
