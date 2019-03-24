package com.sinosoft.workrove.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCLAIMDCOMPANY�����ݷ��ʶ������<br>
 */
public class DBPrplclaimdcompanyBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplclaimdcompanyBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplclaimdcompanyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public void insert(PrplclaimdcompanyDto prplclaimdcompanyDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplclaimdcompany (");
        buffer.append("Nodetype,");
        buffer.append("Comcode,");
        buffer.append("Comname,");
        buffer.append("Uppercomcode,");
        buffer.append("Limitflag,");
        buffer.append("Schedulecomflag,");
        buffer.append("Moneylimit,");
        buffer.append("Iscommit ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getNodetype()).append("',");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getComcode()).append("',");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getComname()).append("',");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getUppercomcode()).append("',");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getLimitflag()).append("',");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getSchedulecomflag()).append("',");
            debugBuffer.append("").append(prplclaimdcompanyDto.getMoneylimit()).append(",");
            debugBuffer.append("'").append(prplclaimdcompanyDto.getIscommit()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplclaimdcompanyDto.getNodetype());
        dbManager.setString(2,prplclaimdcompanyDto.getComcode());
        dbManager.setString(3,prplclaimdcompanyDto.getComname());
        dbManager.setString(4,prplclaimdcompanyDto.getUppercomcode());
        dbManager.setString(5,prplclaimdcompanyDto.getLimitflag());
        dbManager.setString(6,prplclaimdcompanyDto.getSchedulecomflag());
        dbManager.setDouble(7,prplclaimdcompanyDto.getMoneylimit());
        dbManager.setString(8,prplclaimdcompanyDto.getIscommit());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplclaimdcompany (");
        buffer.append("Nodetype,");
        buffer.append("Comcode,");
        buffer.append("Comname,");
        buffer.append("Uppercomcode,");
        buffer.append("Limitflag,");
        buffer.append("Schedulecomflag,");
        buffer.append("Moneylimit,");
        buffer.append("Iscommit ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplclaimdcompanyDto prplclaimdcompanyDto = (PrplclaimdcompanyDto)i.next();
            dbManager.setString(1,prplclaimdcompanyDto.getNodetype());
            dbManager.setString(2,prplclaimdcompanyDto.getComcode());
            dbManager.setString(3,prplclaimdcompanyDto.getComname());
            dbManager.setString(4,prplclaimdcompanyDto.getUppercomcode());
            dbManager.setString(5,prplclaimdcompanyDto.getLimitflag());
            dbManager.setString(6,prplclaimdcompanyDto.getSchedulecomflag());
            dbManager.setDouble(7,prplclaimdcompanyDto.getMoneylimit());
            dbManager.setString(8,prplclaimdcompanyDto.getIscommit());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param nodetype NODETYPE
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(String nodetype,String comcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplclaimdcompany ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Comcode=").append("'").append(comcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Comcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,nodetype);
        dbManager.setString(2,comcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public void update(PrplclaimdcompanyDto prplclaimdcompanyDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplclaimdcompany SET ");
        buffer.append("Comname = ?, ");
        buffer.append("Uppercomcode = ?, ");
        buffer.append("Limitflag = ?, ");
        buffer.append("Schedulecomflag = ?, ");
        buffer.append("Moneylimit = ?, ");
        buffer.append("Iscommit = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplclaimdcompany SET ");
            debugBuffer.append("Comname = '" + prplclaimdcompanyDto.getComname() + "', ");
            debugBuffer.append("Uppercomcode = '" + prplclaimdcompanyDto.getUppercomcode() + "', ");
            debugBuffer.append("Limitflag = '" + prplclaimdcompanyDto.getLimitflag() + "', ");
            debugBuffer.append("Schedulecomflag = '" + prplclaimdcompanyDto.getSchedulecomflag() + "', ");
            debugBuffer.append("Moneylimit = " + prplclaimdcompanyDto.getMoneylimit() + ", ");
            debugBuffer.append("Iscommit = '" + prplclaimdcompanyDto.getIscommit() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Nodetype=").append("'").append(prplclaimdcompanyDto.getNodetype()).append("' AND ");
            debugBuffer.append("Comcode=").append("'").append(prplclaimdcompanyDto.getComcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Comcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplclaimdcompanyDto.getComname());
        dbManager.setString(2,prplclaimdcompanyDto.getUppercomcode());
        dbManager.setString(3,prplclaimdcompanyDto.getLimitflag());
        dbManager.setString(4,prplclaimdcompanyDto.getSchedulecomflag());
        dbManager.setDouble(5,prplclaimdcompanyDto.getMoneylimit());
        dbManager.setString(6,prplclaimdcompanyDto.getIscommit());
        //���������ֶ�;
        dbManager.setString(7,prplclaimdcompanyDto.getNodetype());
        dbManager.setString(8,prplclaimdcompanyDto.getComcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param nodetype NODETYPE
     * @param comcode COMCODE
     * @return PrplclaimdcompanyDto
     * @throws Exception
     */
    public PrplclaimdcompanyDto findByPrimaryKey(String nodetype,String comcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Nodetype,");
        buffer.append("Comcode,");
        buffer.append("Comname,");
        buffer.append("Uppercomcode,");
        buffer.append("Limitflag,");
        buffer.append("Schedulecomflag,");
        buffer.append("Moneylimit,");
        buffer.append("Iscommit ");
        buffer.append("FROM Prplclaimdcompany ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Comcode=").append("'").append(comcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Comcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,nodetype);
        dbManager.setString(2,comcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplclaimdcompanyDto prplclaimdcompanyDto = null;
        if(resultSet.next()){
            prplclaimdcompanyDto = new PrplclaimdcompanyDto();
            prplclaimdcompanyDto.setNodetype(dbManager.getString(resultSet,1));
            prplclaimdcompanyDto.setComcode(dbManager.getString(resultSet,2));
            prplclaimdcompanyDto.setComname(dbManager.getString(resultSet,3));
            prplclaimdcompanyDto.setUppercomcode(dbManager.getString(resultSet,4));
            prplclaimdcompanyDto.setLimitflag(dbManager.getString(resultSet,5));
            prplclaimdcompanyDto.setSchedulecomflag(dbManager.getString(resultSet,6));
            prplclaimdcompanyDto.setMoneylimit(dbManager.getDouble(resultSet,7));
            prplclaimdcompanyDto.setIscommit(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        return prplclaimdcompanyDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Nodetype,");
        buffer.append("Comcode,");
        buffer.append("Comname,");
        buffer.append("Uppercomcode,");
        buffer.append("Limitflag,");
        buffer.append("Schedulecomflag,");
        buffer.append("Moneylimit,");
        buffer.append("Iscommit ");
        buffer.append("FROM Prplclaimdcompany WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //��Oracle�Ż�
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
        System.out.println(buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrplclaimdcompanyDto prplclaimdcompanyDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplclaimdcompanyDto = new PrplclaimdcompanyDto();
            prplclaimdcompanyDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplclaimdcompanyDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            prplclaimdcompanyDto.setComname(dbManager.getString(resultSet,"Comname"));
            prplclaimdcompanyDto.setUppercomcode(dbManager.getString(resultSet,"Uppercomcode"));
            prplclaimdcompanyDto.setLimitflag(dbManager.getString(resultSet,"Limitflag"));
            prplclaimdcompanyDto.setSchedulecomflag(dbManager.getString(resultSet,"Schedulecomflag"));
            prplclaimdcompanyDto.setMoneylimit(dbManager.getDouble(resultSet,"Moneylimit"));
            prplclaimdcompanyDto.setIscommit(dbManager.getString(resultSet,"Iscommit"));
            collection.add(prplclaimdcompanyDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplclaimdcompany WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM Prplclaimdcompany WHERE ");
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
