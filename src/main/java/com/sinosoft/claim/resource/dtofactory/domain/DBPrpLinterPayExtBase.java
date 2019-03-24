package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�------������������ݷ��ʶ������<br>
 */
public class DBPrpLinterPayExtBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPayExtBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPayExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(PrpLinterPayExtDto prpLinterPayExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPayExt (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("OperatorCodeName,");
        buffer.append("Context ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPayExtDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterPayExtDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterPayExtDto.getOperatorCodeName()).append("',");
            debugBuffer.append("'").append(prpLinterPayExtDto.getContext()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPayExtDto.getId());
        dbManager.setInt(2,prpLinterPayExtDto.getSerialNo());
        dbManager.setString(3,prpLinterPayExtDto.getOperatorCodeName());
        dbManager.setString(4,prpLinterPayExtDto.getContext());
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
        buffer.append("INSERT INTO PrpLinterPayExt (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("OperatorCodeName,");
        buffer.append("Context ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPayExtDto prpLinterPayExtDto = (PrpLinterPayExtDto)i.next();
            dbManager.setString(1,prpLinterPayExtDto.getId());
            dbManager.setInt(2,prpLinterPayExtDto.getSerialNo());
            dbManager.setString(3,prpLinterPayExtDto.getOperatorCodeName());
            dbManager.setString(4,prpLinterPayExtDto.getContext());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @throws Exception
     */
    public void delete(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterPayExt ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void update(PrpLinterPayExtDto prpLinterPayExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPayExt SET ");
        buffer.append("OperatorCodeName = ?, ");
        buffer.append("Context = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPayExt SET ");
            debugBuffer.append("OperatorCodeName = '" + prpLinterPayExtDto.getOperatorCodeName() + "', ");
            debugBuffer.append("Context = '" + prpLinterPayExtDto.getContext() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPayExtDto.getId()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLinterPayExtDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLinterPayExtDto.getOperatorCodeName());
        dbManager.setString(2,prpLinterPayExtDto.getContext());
        //���������ֶ�;
        dbManager.setString(3,prpLinterPayExtDto.getId());
        dbManager.setInt(4,prpLinterPayExtDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @return PrpLinterPayExtDto
     * @throws Exception
     */
    public PrpLinterPayExtDto findByPrimaryKey(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("OperatorCodeName,");
        buffer.append("Context ");
        buffer.append("FROM PrpLinterPayExt ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterPayExtDto prpLinterPayExtDto = null;
        if(resultSet.next()){
            prpLinterPayExtDto = new PrpLinterPayExtDto();
            prpLinterPayExtDto.setId(dbManager.getString(resultSet,1));
            prpLinterPayExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterPayExtDto.setOperatorCodeName(dbManager.getString(resultSet,3));
            prpLinterPayExtDto.setContext(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        return prpLinterPayExtDto;
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
        buffer.append("OperatorCodeName,");
        buffer.append("Context ");
        buffer.append("FROM PrpLinterPayExt WHERE ");
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
        PrpLinterPayExtDto prpLinterPayExtDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPayExtDto = new PrpLinterPayExtDto();
            prpLinterPayExtDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPayExtDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterPayExtDto.setOperatorCodeName(dbManager.getString(resultSet,"OperatorCodeName"));
            prpLinterPayExtDto.setContext(dbManager.getString(resultSet,"Context"));
            collection.add(prpLinterPayExtDto);
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
        buffer.append("DELETE FROM PrpLinterPayExt WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPayExt WHERE ");
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
