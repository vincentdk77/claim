package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǲ���˵����Ϣ�����ݷ��ʶ������<br>
 */
public class DBPrpLinterSchedExtBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterSchedExtBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterSchedExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public void insert(PrpLinterSchedExtDto prpLinterSchedExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterSchedExt (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("OperatorCode,");
        buffer.append("Context ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterSchedExtDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterSchedExtDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterSchedExtDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLinterSchedExtDto.getContext()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterSchedExtDto.getId());
        dbManager.setInt(2,prpLinterSchedExtDto.getSerialNo());
        dbManager.setString(3,prpLinterSchedExtDto.getOperatorCode());
        dbManager.setString(4,prpLinterSchedExtDto.getContext());
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
        buffer.append("INSERT INTO PrpLinterSchedExt (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("OperatorCode,");
        buffer.append("Context ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterSchedExtDto prpLinterSchedExtDto = (PrpLinterSchedExtDto)i.next();
            dbManager.setString(1,prpLinterSchedExtDto.getId());
            dbManager.setInt(2,prpLinterSchedExtDto.getSerialNo());
            dbManager.setString(3,prpLinterSchedExtDto.getOperatorCode());
            dbManager.setString(4,prpLinterSchedExtDto.getContext());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterSchedExt ");
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
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @throws Exception
     */
    public void update(PrpLinterSchedExtDto prpLinterSchedExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterSchedExt SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("Context = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterSchedExt SET ");
            debugBuffer.append("SerialNo = " + prpLinterSchedExtDto.getSerialNo() + ", ");
            debugBuffer.append("OperatorCode = '" + prpLinterSchedExtDto.getOperatorCode() + "', ");
            debugBuffer.append("Context = '" + prpLinterSchedExtDto.getContext() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterSchedExtDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,prpLinterSchedExtDto.getSerialNo());
        dbManager.setString(2,prpLinterSchedExtDto.getOperatorCode());
        dbManager.setString(3,prpLinterSchedExtDto.getContext());
        //���������ֶ�;
        dbManager.setString(4,prpLinterSchedExtDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @return PrpLinterSchedExtDto
     * @throws Exception
     */
    public PrpLinterSchedExtDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("OperatorCode,");
        buffer.append("Context ");
        buffer.append("FROM PrpLinterSchedExt ");
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
        PrpLinterSchedExtDto prpLinterSchedExtDto = null;
        if(resultSet.next()){
            prpLinterSchedExtDto = new PrpLinterSchedExtDto();
            prpLinterSchedExtDto.setId(dbManager.getString(resultSet,1));
            prpLinterSchedExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterSchedExtDto.setOperatorCode(dbManager.getString(resultSet,3));
            prpLinterSchedExtDto.setContext(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        return prpLinterSchedExtDto;
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
        buffer.append("SerialNo,");
        buffer.append("OperatorCode,");
        buffer.append("Context ");
        buffer.append("FROM PrpLinterSchedExt WHERE ");
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
        PrpLinterSchedExtDto prpLinterSchedExtDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterSchedExtDto = new PrpLinterSchedExtDto();
            prpLinterSchedExtDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterSchedExtDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterSchedExtDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prpLinterSchedExtDto.setContext(dbManager.getString(resultSet,"Context"));
            collection.add(prpLinterSchedExtDto);
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
        buffer.append("DELETE FROM PrpLinterSchedExt WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterSchedExt WHERE ");
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
