package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGERTIME�����ݷ��ʶ������<br>
 */
public class DBPrpljobmanagertimeBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpljobmanagertimeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpljobmanagertimeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void insert(PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prpljobmanagertime (");
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpljobmanagertimeDto.getFid()).append("',");
            debugBuffer.append("'").append(prpljobmanagertimeDto.getDatetype()).append("',");
            debugBuffer.append("'").append(prpljobmanagertimeDto.getTime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpljobmanagertimeDto.getFid());
        dbManager.setString(2,prpljobmanagertimeDto.getDatetype());
        dbManager.setString(3,prpljobmanagertimeDto.getTime());
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
        buffer.append("INSERT INTO Prpljobmanagertime (");
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpljobmanagertimeDto prpljobmanagertimeDto = (PrpljobmanagertimeDto)i.next();
            dbManager.setString(1,prpljobmanagertimeDto.getFid());
            dbManager.setString(2,prpljobmanagertimeDto.getDatetype());
            dbManager.setString(3,prpljobmanagertimeDto.getTime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param fid FID
     * @throws Exception
     */
    public void delete(String fid)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prpljobmanagertime ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fid=").append("'").append(fid).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fid = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,fid);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void update(PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prpljobmanagertime SET ");
        buffer.append("Datetype = ?, ");
        buffer.append("Time = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prpljobmanagertime SET ");
            debugBuffer.append("Datetype = '" + prpljobmanagertimeDto.getDatetype() + "', ");
            debugBuffer.append("Time = '" + prpljobmanagertimeDto.getTime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fid=").append("'").append(prpljobmanagertimeDto.getFid()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fid = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpljobmanagertimeDto.getDatetype());
        dbManager.setString(2,prpljobmanagertimeDto.getTime());
        //���������ֶ�;
        dbManager.setString(3,prpljobmanagertimeDto.getFid());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param fid FID
     * @return PrpljobmanagertimeDto
     * @throws Exception
     */
    public PrpljobmanagertimeDto findByPrimaryKey(String fid)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append("FROM Prpljobmanagertime ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fid=").append("'").append(fid).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fid = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,fid);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        if(resultSet.next()){
            prpljobmanagertimeDto = new PrpljobmanagertimeDto();
            prpljobmanagertimeDto.setFid(dbManager.getString(resultSet,1));
            prpljobmanagertimeDto.setDatetype(dbManager.getString(resultSet,2));
            prpljobmanagertimeDto.setTime(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        return prpljobmanagertimeDto;
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
        buffer.append("Fid,");
        buffer.append("Datetype,");
        buffer.append("Time ");
        buffer.append("FROM Prpljobmanagertime WHERE ");
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
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpljobmanagertimeDto = new PrpljobmanagertimeDto();
            prpljobmanagertimeDto.setFid(dbManager.getString(resultSet,"Fid"));
            prpljobmanagertimeDto.setDatetype(dbManager.getString(resultSet,"Datetype"));
            prpljobmanagertimeDto.setTime(dbManager.getString(resultSet,"Time"));
            collection.add(prpljobmanagertimeDto);
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
        buffer.append("DELETE FROM Prpljobmanagertime WHERE ");
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
        buffer.append("SELECT count(1) FROM Prpljobmanagertime WHERE ");
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
