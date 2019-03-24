package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ������ݷ��ʶ������<br>
 */
public class DBPrpLinterCompeInvMainBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCompeInvMainBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompeInvMainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void insert(PrpLinterCompeInvMainDto prpLinterCompeInvMainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCompeInvMain (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("SettleListCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("DateSourceName ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCompeInvMainDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterCompeInvMainDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterCompeInvMainDto.getSettleListCode()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvMainDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvMainDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvMainDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvMainDto.getDateSourceName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCompeInvMainDto.getId());
        dbManager.setInt(2,prpLinterCompeInvMainDto.getSerialNo());
        dbManager.setString(3,prpLinterCompeInvMainDto.getSettleListCode());
        dbManager.setString(4,prpLinterCompeInvMainDto.getRegistNo());
        dbManager.setString(5,prpLinterCompeInvMainDto.getClaimNo());
        dbManager.setString(6,prpLinterCompeInvMainDto.getCompensateNo());
        dbManager.setString(7,prpLinterCompeInvMainDto.getDateSourceName());
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
        buffer.append("INSERT INTO PrpLinterCompeInvMain (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("SettleListCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("DateSourceName ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCompeInvMainDto prpLinterCompeInvMainDto = (PrpLinterCompeInvMainDto)i.next();
            dbManager.setString(1,prpLinterCompeInvMainDto.getId());
            dbManager.setInt(2,prpLinterCompeInvMainDto.getSerialNo());
            dbManager.setString(3,prpLinterCompeInvMainDto.getSettleListCode());
            dbManager.setString(4,prpLinterCompeInvMainDto.getRegistNo());
            dbManager.setString(5,prpLinterCompeInvMainDto.getClaimNo());
            dbManager.setString(6,prpLinterCompeInvMainDto.getCompensateNo());
            dbManager.setString(7,prpLinterCompeInvMainDto.getDateSourceName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @param serialNo ��� PK
     * @throws Exception
     */
    public void delete(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterCompeInvMain ");
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
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void update(PrpLinterCompeInvMainDto prpLinterCompeInvMainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCompeInvMain SET ");
        buffer.append("SettleListCode = ?, ");
        buffer.append("RegistNo = ?, ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("CompensateNo = ?, ");
        buffer.append("DateSourceName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCompeInvMain SET ");
            debugBuffer.append("SettleListCode = '" + prpLinterCompeInvMainDto.getSettleListCode() + "', ");
            debugBuffer.append("RegistNo = '" + prpLinterCompeInvMainDto.getRegistNo() + "', ");
            debugBuffer.append("ClaimNo = '" + prpLinterCompeInvMainDto.getClaimNo() + "', ");
            debugBuffer.append("CompensateNo = '" + prpLinterCompeInvMainDto.getCompensateNo() + "', ");
            debugBuffer.append("DateSourceName = '" + prpLinterCompeInvMainDto.getDateSourceName() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCompeInvMainDto.getId()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLinterCompeInvMainDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLinterCompeInvMainDto.getSettleListCode());
        dbManager.setString(2,prpLinterCompeInvMainDto.getRegistNo());
        dbManager.setString(3,prpLinterCompeInvMainDto.getClaimNo());
        dbManager.setString(4,prpLinterCompeInvMainDto.getCompensateNo());
        dbManager.setString(5,prpLinterCompeInvMainDto.getDateSourceName());
        //���������ֶ�;
        dbManager.setString(6,prpLinterCompeInvMainDto.getId());
        dbManager.setInt(7,prpLinterCompeInvMainDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @param serialNo ��� PK
     * @return PrpLinterCompeInvMainDto
     * @throws Exception
     */
    public PrpLinterCompeInvMainDto findByPrimaryKey(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("SettleListCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("DateSourceName ");
        buffer.append("FROM PrpLinterCompeInvMain ");
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
        PrpLinterCompeInvMainDto prpLinterCompeInvMainDto = null;
        if(resultSet.next()){
            prpLinterCompeInvMainDto = new PrpLinterCompeInvMainDto();
            prpLinterCompeInvMainDto.setId(dbManager.getString(resultSet,1));
            prpLinterCompeInvMainDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterCompeInvMainDto.setSettleListCode(dbManager.getString(resultSet,3));
            prpLinterCompeInvMainDto.setRegistNo(dbManager.getString(resultSet,4));
            prpLinterCompeInvMainDto.setClaimNo(dbManager.getString(resultSet,5));
            prpLinterCompeInvMainDto.setCompensateNo(dbManager.getString(resultSet,6));
            prpLinterCompeInvMainDto.setDateSourceName(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        return prpLinterCompeInvMainDto;
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
        buffer.append("SettleListCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("CompensateNo,");
        buffer.append("DateSourceName ");
        buffer.append("FROM PrpLinterCompeInvMain WHERE ");
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
        PrpLinterCompeInvMainDto prpLinterCompeInvMainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCompeInvMainDto = new PrpLinterCompeInvMainDto();
            prpLinterCompeInvMainDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCompeInvMainDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterCompeInvMainDto.setSettleListCode(dbManager.getString(resultSet,"SettleListCode"));
            prpLinterCompeInvMainDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
            prpLinterCompeInvMainDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
            prpLinterCompeInvMainDto.setCompensateNo(dbManager.getString(resultSet,"CompensateNo"));
            prpLinterCompeInvMainDto.setDateSourceName(dbManager.getString(resultSet,"DateSourceName"));
            collection.add(prpLinterCompeInvMainDto);
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
        buffer.append("DELETE FROM PrpLinterCompeInvMain WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCompeInvMain WHERE ");
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
