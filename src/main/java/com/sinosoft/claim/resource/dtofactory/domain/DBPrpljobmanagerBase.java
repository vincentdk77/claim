package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGER�����ݷ��ʶ������<br>
 */
public class DBPrpljobmanagerBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpljobmanagerBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpljobmanagerBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public void insert(PrpljobmanagerDto prpljobmanagerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prpljobmanager (");
        buffer.append("Id,");
        buffer.append("Jobrole,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handledept,");
        buffer.append("Deptname,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Month,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("SystemCode,");
        buffer.append("Classcode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpljobmanagerDto.getId()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getJobrole()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getHandlercode()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getHandlername()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getHandledept()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getDeptname()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getFlowintime()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getModifytime()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getMonth()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getOperator()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getOperatorid()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getSystemCode()).append("',");
            debugBuffer.append("'").append(prpljobmanagerDto.getClasscode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpljobmanagerDto.getId());
        dbManager.setString(2,prpljobmanagerDto.getJobrole());
        dbManager.setString(3,prpljobmanagerDto.getHandlercode());
        dbManager.setString(4,prpljobmanagerDto.getHandlername());
        dbManager.setString(5,prpljobmanagerDto.getHandledept());
        dbManager.setString(6,prpljobmanagerDto.getDeptname());
        dbManager.setString(7,prpljobmanagerDto.getFlowintime());
        dbManager.setString(8,prpljobmanagerDto.getModifytime());
        dbManager.setString(9,prpljobmanagerDto.getMonth());
        dbManager.setString(10,prpljobmanagerDto.getOperator());
        dbManager.setString(11,prpljobmanagerDto.getOperatorid());
        dbManager.setString(12,prpljobmanagerDto.getSystemCode());
        dbManager.setString(13,prpljobmanagerDto.getClasscode());
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
        buffer.append("INSERT INTO Prpljobmanager (");
        buffer.append("Id,");
        buffer.append("Jobrole,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handledept,");
        buffer.append("Deptname,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Month,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("SystemCode,");
        buffer.append("Classcode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpljobmanagerDto prpljobmanagerDto = (PrpljobmanagerDto)i.next();
            dbManager.setString(1,prpljobmanagerDto.getId());
            dbManager.setString(2,prpljobmanagerDto.getJobrole());
            dbManager.setString(3,prpljobmanagerDto.getHandlercode());
            dbManager.setString(4,prpljobmanagerDto.getHandlername());
            dbManager.setString(5,prpljobmanagerDto.getHandledept());
            dbManager.setString(6,prpljobmanagerDto.getDeptname());
            dbManager.setString(7,prpljobmanagerDto.getFlowintime());
            dbManager.setString(8,prpljobmanagerDto.getModifytime());
            dbManager.setString(9,prpljobmanagerDto.getMonth());
            dbManager.setString(10,prpljobmanagerDto.getOperator());
            dbManager.setString(11,prpljobmanagerDto.getOperatorid());
            dbManager.setString(12,prpljobmanagerDto.getSystemCode());
            dbManager.setString(13,prpljobmanagerDto.getClasscode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ID
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prpljobmanager ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public void update(PrpljobmanagerDto prpljobmanagerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prpljobmanager SET ");
        buffer.append("Jobrole = ?, ");
        buffer.append("Handlercode = ?, ");
        buffer.append("Handlername = ?, ");
        buffer.append("Handledept = ?, ");
        buffer.append("Deptname = ?, ");
        buffer.append("Flowintime = ?, ");
        buffer.append("Modifytime = ?, ");
        buffer.append("Month = ?, ");
        buffer.append("Operator = ?, ");
        buffer.append("Operatorid = ?, ");
        buffer.append("SystemCode = ?, ");
        buffer.append("Classcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prpljobmanager SET ");
            debugBuffer.append("Jobrole = '" + prpljobmanagerDto.getJobrole() + "', ");
            debugBuffer.append("Handlercode = '" + prpljobmanagerDto.getHandlercode() + "', ");
            debugBuffer.append("Handlername = '" + prpljobmanagerDto.getHandlername() + "', ");
            debugBuffer.append("Handledept = '" + prpljobmanagerDto.getHandledept() + "', ");
            debugBuffer.append("Deptname = '" + prpljobmanagerDto.getDeptname() + "', ");
            debugBuffer.append("Flowintime = '" + prpljobmanagerDto.getFlowintime() + "', ");
            debugBuffer.append("Modifytime = '" + prpljobmanagerDto.getModifytime() + "', ");
            debugBuffer.append("Month = '" + prpljobmanagerDto.getMonth() + "', ");
            debugBuffer.append("Operator = '" + prpljobmanagerDto.getOperator() + "', ");
            debugBuffer.append("Operatorid = '" + prpljobmanagerDto.getOperatorid() + "', ");
            debugBuffer.append("SystemCode = '" + prpljobmanagerDto.getSystemCode() + "', ");
            debugBuffer.append("Classcode = '" + prpljobmanagerDto.getClasscode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpljobmanagerDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpljobmanagerDto.getJobrole());
        dbManager.setString(2,prpljobmanagerDto.getHandlercode());
        dbManager.setString(3,prpljobmanagerDto.getHandlername());
        dbManager.setString(4,prpljobmanagerDto.getHandledept());
        dbManager.setString(5,prpljobmanagerDto.getDeptname());
        dbManager.setString(6,prpljobmanagerDto.getFlowintime());
        dbManager.setString(7,prpljobmanagerDto.getModifytime());
        dbManager.setString(8,prpljobmanagerDto.getMonth());
        dbManager.setString(9,prpljobmanagerDto.getOperator());
        dbManager.setString(10,prpljobmanagerDto.getOperatorid());
        dbManager.setString(11,prpljobmanagerDto.getSystemCode());
        dbManager.setString(12,prpljobmanagerDto.getClasscode());
        //���������ֶ�;
        dbManager.setString(13,prpljobmanagerDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ID
     * @return PrpljobmanagerDto
     * @throws Exception
     */
    public PrpljobmanagerDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("Jobrole,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handledept,");
        buffer.append("Deptname,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Month,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("SystemCode,");
        buffer.append("Classcode ");
        buffer.append("FROM Prpljobmanager ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpljobmanagerDto prpljobmanagerDto = null;
        if(resultSet.next()){
            prpljobmanagerDto = new PrpljobmanagerDto();
            prpljobmanagerDto.setId(dbManager.getString(resultSet,1));
            prpljobmanagerDto.setJobrole(dbManager.getString(resultSet,2));
            prpljobmanagerDto.setHandlercode(dbManager.getString(resultSet,3));
            prpljobmanagerDto.setHandlername(dbManager.getString(resultSet,4));
            prpljobmanagerDto.setHandledept(dbManager.getString(resultSet,5));
            prpljobmanagerDto.setDeptname(dbManager.getString(resultSet,6));
            prpljobmanagerDto.setFlowintime(dbManager.getString(resultSet,7));
            prpljobmanagerDto.setModifytime(dbManager.getString(resultSet,8));
            prpljobmanagerDto.setMonth(dbManager.getString(resultSet,9));
            prpljobmanagerDto.setOperator(dbManager.getString(resultSet,10));
            prpljobmanagerDto.setOperatorid(dbManager.getString(resultSet,11));
            prpljobmanagerDto.setSystemCode(dbManager.getString(resultSet,12));
            prpljobmanagerDto.setClasscode(dbManager.getString(resultSet,13));
        }
        resultSet.close();
        return prpljobmanagerDto;
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
        buffer.append("Id,");
        buffer.append("Jobrole,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handledept,");
        buffer.append("Deptname,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Month,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("SystemCode,");
        buffer.append("Classcode ");
        buffer.append("FROM Prpljobmanager WHERE ");
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
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpljobmanagerDto prpljobmanagerDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpljobmanagerDto = new PrpljobmanagerDto();
            prpljobmanagerDto.setId(dbManager.getString(resultSet,"Id"));
            prpljobmanagerDto.setJobrole(dbManager.getString(resultSet,"Jobrole"));
            prpljobmanagerDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prpljobmanagerDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prpljobmanagerDto.setHandledept(dbManager.getString(resultSet,"Handledept"));
            prpljobmanagerDto.setDeptname(dbManager.getString(resultSet,"Deptname"));
            prpljobmanagerDto.setFlowintime(dbManager.getString(resultSet,"Flowintime"));
            prpljobmanagerDto.setModifytime(dbManager.getString(resultSet,"Modifytime"));
            prpljobmanagerDto.setMonth(dbManager.getString(resultSet,"Month"));
            prpljobmanagerDto.setOperator(dbManager.getString(resultSet,"Operator"));
            prpljobmanagerDto.setOperatorid(dbManager.getString(resultSet,"Operatorid"));
            prpljobmanagerDto.setSystemCode(dbManager.getString(resultSet,"SystemCode"));
            prpljobmanagerDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            collection.add(prpljobmanagerDto);
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
        buffer.append("DELETE FROM Prpljobmanager WHERE ");
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
        buffer.append("SELECT count(1) FROM Prpljobmanager WHERE ");
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
