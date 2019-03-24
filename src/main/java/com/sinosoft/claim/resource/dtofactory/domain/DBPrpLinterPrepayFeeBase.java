package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ԥ�������Ϣ������ݷ��ʶ������<br>
 */
public class DBPrpLinterPrepayFeeBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPrepayFeeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPrepayFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPrepayFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterPrepayFeeDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getChargeCode()).append("',");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getChargeName()).append("',");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getCurrency()).append("',");
            debugBuffer.append("'").append(prpLinterPrepayFeeDto.getKindCode()).append("',");
            debugBuffer.append("").append(prpLinterPrepayFeeDto.getChargeReport()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPrepayFeeDto.getId());
        dbManager.setInt(2,prpLinterPrepayFeeDto.getSerialNo());
        dbManager.setString(3,prpLinterPrepayFeeDto.getChargeCode());
        dbManager.setString(4,prpLinterPrepayFeeDto.getChargeName());
        dbManager.setString(5,prpLinterPrepayFeeDto.getCurrency());
        dbManager.setString(6,prpLinterPrepayFeeDto.getKindCode());
        dbManager.setDouble(7,prpLinterPrepayFeeDto.getChargeReport());
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
        buffer.append("INSERT INTO PrpLinterPrepayFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = (PrpLinterPrepayFeeDto)i.next();
            dbManager.setString(1,prpLinterPrepayFeeDto.getId());
            dbManager.setInt(2,prpLinterPrepayFeeDto.getSerialNo());
            dbManager.setString(3,prpLinterPrepayFeeDto.getChargeCode());
            dbManager.setString(4,prpLinterPrepayFeeDto.getChargeName());
            dbManager.setString(5,prpLinterPrepayFeeDto.getCurrency());
            dbManager.setString(6,prpLinterPrepayFeeDto.getKindCode());
            dbManager.setDouble(7,prpLinterPrepayFeeDto.getChargeReport());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ���� PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterPrepayFee ");
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
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void update(PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPrepayFee SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("ChargeCode = ?, ");
        buffer.append("ChargeName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("ChargeReport = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPrepayFee SET ");
            debugBuffer.append("SerialNo = " + prpLinterPrepayFeeDto.getSerialNo() + ", ");
            debugBuffer.append("ChargeCode = '" + prpLinterPrepayFeeDto.getChargeCode() + "', ");
            debugBuffer.append("ChargeName = '" + prpLinterPrepayFeeDto.getChargeName() + "', ");
            debugBuffer.append("Currency = '" + prpLinterPrepayFeeDto.getCurrency() + "', ");
            debugBuffer.append("KindCode = '" + prpLinterPrepayFeeDto.getKindCode() + "', ");
            debugBuffer.append("ChargeReport = " + prpLinterPrepayFeeDto.getChargeReport() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPrepayFeeDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,prpLinterPrepayFeeDto.getSerialNo());
        dbManager.setString(2,prpLinterPrepayFeeDto.getChargeCode());
        dbManager.setString(3,prpLinterPrepayFeeDto.getChargeName());
        dbManager.setString(4,prpLinterPrepayFeeDto.getCurrency());
        dbManager.setString(5,prpLinterPrepayFeeDto.getKindCode());
        dbManager.setDouble(6,prpLinterPrepayFeeDto.getChargeReport());
        //���������ֶ�;
        dbManager.setString(7,prpLinterPrepayFeeDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ���� PK
     * @return PrpLinterPrepayFeeDto
     * @throws Exception
     */
    public PrpLinterPrepayFeeDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append("FROM PrpLinterPrepayFee ");
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
        PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = null;
        if(resultSet.next()){
            prpLinterPrepayFeeDto = new PrpLinterPrepayFeeDto();
            prpLinterPrepayFeeDto.setId(dbManager.getString(resultSet,1));
            prpLinterPrepayFeeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterPrepayFeeDto.setChargeCode(dbManager.getString(resultSet,3));
            prpLinterPrepayFeeDto.setChargeName(dbManager.getString(resultSet,4));
            prpLinterPrepayFeeDto.setCurrency(dbManager.getString(resultSet,5));
            prpLinterPrepayFeeDto.setKindCode(dbManager.getString(resultSet,6));
            prpLinterPrepayFeeDto.setChargeReport(dbManager.getDouble(resultSet,7));
        }
        resultSet.close();
        return prpLinterPrepayFeeDto;
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
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("KindCode,");
        buffer.append("ChargeReport ");
        buffer.append("FROM PrpLinterPrepayFee WHERE ");
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
        PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPrepayFeeDto = new PrpLinterPrepayFeeDto();
            prpLinterPrepayFeeDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPrepayFeeDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterPrepayFeeDto.setChargeCode(dbManager.getString(resultSet,"ChargeCode"));
            prpLinterPrepayFeeDto.setChargeName(dbManager.getString(resultSet,"ChargeName"));
            prpLinterPrepayFeeDto.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpLinterPrepayFeeDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            prpLinterPrepayFeeDto.setChargeReport(dbManager.getDouble(resultSet,"ChargeReport"));
            collection.add(prpLinterPrepayFeeDto);
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
        buffer.append("DELETE FROM PrpLinterPrepayFee WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPrepayFee WHERE ");
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
