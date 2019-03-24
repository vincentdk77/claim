package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SETTLEMAINLIST的数据访问对象基类<br>
 */
public class DBSettlemainlistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBSettlemainlistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSettlemainlistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void insert(SettlemainlistDto settlemainlistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Settlemainlist (");
        buffer.append("Settlelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Reportcode,");
        buffer.append("Registercode,");
        buffer.append("Compensateno,");
        buffer.append("Policyno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Damagetime ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(settlemainlistDto.getSettlelistcode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getFareacode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getReportcode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getRegistercode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getCompensateno()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getValidity()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getRemark()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getUpdatecode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getUpdatedate()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(settlemainlistDto.getDamagetime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,settlemainlistDto.getSettlelistcode());
        dbManager.setString(2,settlemainlistDto.getFareacode());
        dbManager.setString(3,settlemainlistDto.getInusrelistcode());
        dbManager.setString(4,settlemainlistDto.getReportcode());
        dbManager.setString(5,settlemainlistDto.getRegistercode());
        dbManager.setString(6,settlemainlistDto.getCompensateno());
        dbManager.setString(7,settlemainlistDto.getPolicyno());
        dbManager.setString(8,settlemainlistDto.getClasscode());
        dbManager.setString(9,settlemainlistDto.getRiskcode());
        dbManager.setString(10,settlemainlistDto.getValidity());
        dbManager.setString(11,settlemainlistDto.getRemark());
        dbManager.setString(12,settlemainlistDto.getUpdatecode());
        dbManager.setDateTime(13,settlemainlistDto.getUpdatedate());
        dbManager.setString(14,settlemainlistDto.getOpcode());
        dbManager.setDateTime(15,settlemainlistDto.getDamagetime());
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
        buffer.append("INSERT INTO Settlemainlist (");
        buffer.append("Settlelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Reportcode,");
        buffer.append("Registercode,");
        buffer.append("Compensateno,");
        buffer.append("Policyno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Damagetime ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SettlemainlistDto settlemainlistDto = (SettlemainlistDto)i.next();
            dbManager.setString(1,settlemainlistDto.getSettlelistcode());
            dbManager.setString(2,settlemainlistDto.getFareacode());
            dbManager.setString(3,settlemainlistDto.getInusrelistcode());
            dbManager.setString(4,settlemainlistDto.getReportcode());
            dbManager.setString(5,settlemainlistDto.getRegistercode());
            dbManager.setString(6,settlemainlistDto.getCompensateno());
            dbManager.setString(7,settlemainlistDto.getPolicyno());
            dbManager.setString(8,settlemainlistDto.getClasscode());
            dbManager.setString(9,settlemainlistDto.getRiskcode());
            dbManager.setString(10,settlemainlistDto.getValidity());
            dbManager.setString(11,settlemainlistDto.getRemark());
            dbManager.setString(12,settlemainlistDto.getUpdatecode());
            dbManager.setDateTime(13,settlemainlistDto.getUpdatedate());
            dbManager.setString(14,settlemainlistDto.getOpcode());
            dbManager.setDateTime(15,settlemainlistDto.getDamagetime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param settlelistcode SETTLELISTCODE
     * @throws Exception
     */
    public void delete(String settlelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Settlemainlist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void update(SettlemainlistDto settlemainlistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Settlemainlist SET ");
        buffer.append("Fareacode = ?, ");
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Reportcode = ?, ");
        buffer.append("Registercode = ?, ");
        buffer.append("Compensateno = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Updatecode = ?, ");
        buffer.append("Updatedate = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Damagetime = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Settlemainlist SET ");
            debugBuffer.append("Fareacode = '" + settlemainlistDto.getFareacode() + "', ");
            debugBuffer.append("Inusrelistcode = '" + settlemainlistDto.getInusrelistcode() + "', ");
            debugBuffer.append("Reportcode = '" + settlemainlistDto.getReportcode() + "', ");
            debugBuffer.append("Registercode = '" + settlemainlistDto.getRegistercode() + "', ");
            debugBuffer.append("Compensateno = '" + settlemainlistDto.getCompensateno() + "', ");
            debugBuffer.append("Policyno = '" + settlemainlistDto.getPolicyno() + "', ");
            debugBuffer.append("Classcode = '" + settlemainlistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + settlemainlistDto.getRiskcode() + "', ");
            debugBuffer.append("Validity = '" + settlemainlistDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + settlemainlistDto.getRemark() + "', ");
            debugBuffer.append("Updatecode = '" + settlemainlistDto.getUpdatecode() + "', ");
            debugBuffer.append("Updatedate = '" + settlemainlistDto.getUpdatedate() + "', ");
            debugBuffer.append("Opcode = '" + settlemainlistDto.getOpcode() + "', ");
            debugBuffer.append("Damagetime = '" + settlemainlistDto.getDamagetime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlemainlistDto.getSettlelistcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,settlemainlistDto.getFareacode());
        dbManager.setString(2,settlemainlistDto.getInusrelistcode());
        dbManager.setString(3,settlemainlistDto.getReportcode());
        dbManager.setString(4,settlemainlistDto.getRegistercode());
        dbManager.setString(5,settlemainlistDto.getCompensateno());
        dbManager.setString(6,settlemainlistDto.getPolicyno());
        dbManager.setString(7,settlemainlistDto.getClasscode());
        dbManager.setString(8,settlemainlistDto.getRiskcode());
        dbManager.setString(9,settlemainlistDto.getValidity());
        dbManager.setString(10,settlemainlistDto.getRemark());
        dbManager.setString(11,settlemainlistDto.getUpdatecode());
        dbManager.setDateTime(12,settlemainlistDto.getUpdatedate());
        dbManager.setString(13,settlemainlistDto.getOpcode());
        dbManager.setDateTime(14,settlemainlistDto.getDamagetime());
        //设置条件字段;
        dbManager.setString(15,settlemainlistDto.getSettlelistcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param settlelistcode SETTLELISTCODE
     * @return SettlemainlistDto
     * @throws Exception
     */
    public SettlemainlistDto findByPrimaryKey(String settlelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Reportcode,");
        buffer.append("Registercode,");
        buffer.append("Compensateno,");
        buffer.append("Policyno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Damagetime ");
        buffer.append("FROM Settlemainlist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        SettlemainlistDto settlemainlistDto = null;
        if(resultSet.next()){
            settlemainlistDto = new SettlemainlistDto();
            settlemainlistDto.setSettlelistcode(dbManager.getString(resultSet,1));
            settlemainlistDto.setFareacode(dbManager.getString(resultSet,2));
            settlemainlistDto.setInusrelistcode(dbManager.getString(resultSet,3));
            settlemainlistDto.setReportcode(dbManager.getString(resultSet,4));
            settlemainlistDto.setRegistercode(dbManager.getString(resultSet,5));
            settlemainlistDto.setCompensateno(dbManager.getString(resultSet,6));
            settlemainlistDto.setPolicyno(dbManager.getString(resultSet,7));
            settlemainlistDto.setClasscode(dbManager.getString(resultSet,8));
            settlemainlistDto.setRiskcode(dbManager.getString(resultSet,9));
            settlemainlistDto.setValidity(dbManager.getString(resultSet,10));
            settlemainlistDto.setRemark(dbManager.getString(resultSet,11));
            settlemainlistDto.setUpdatecode(dbManager.getString(resultSet,12));
            settlemainlistDto.setUpdatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            settlemainlistDto.setOpcode(dbManager.getString(resultSet,14));
            settlemainlistDto.setDamagetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
        }
        resultSet.close();
        return settlemainlistDto;
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
        buffer.append("Settlelistcode,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Reportcode,");
        buffer.append("Registercode,");
        buffer.append("Compensateno,");
        buffer.append("Policyno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Damagetime ");
        buffer.append("FROM Settlemainlist WHERE ");
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
        String sql = "select sysdate from dual";
        ResultSet resultSet = dbManager.executeQuery(sql);
        resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        SettlemainlistDto settlemainlistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            settlemainlistDto = new SettlemainlistDto();
            settlemainlistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            settlemainlistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            settlemainlistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            settlemainlistDto.setReportcode(dbManager.getString(resultSet,"Reportcode"));
            settlemainlistDto.setRegistercode(dbManager.getString(resultSet,"Registercode"));
            settlemainlistDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            settlemainlistDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            settlemainlistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            settlemainlistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            settlemainlistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            settlemainlistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            settlemainlistDto.setUpdatecode(dbManager.getString(resultSet,"Updatecode"));
            settlemainlistDto.setUpdatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Updatedate"));
            settlemainlistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            settlemainlistDto.setDamagetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Damagetime"));
            collection.add(settlemainlistDto);
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
        buffer.append("DELETE FROM Settlemainlist WHERE ");
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
        buffer.append("SELECT count(*) FROM Settlemainlist WHERE ");
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
