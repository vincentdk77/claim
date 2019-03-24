package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǵ�����ñ�-PrpLAcciCheckCharge�����ݷ��ʶ������<br>
 * ������ 2006-01-23 15:30:13.765<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciCheckChargeBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLAcciCheckChargeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLAcciCheckChargeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void insert(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLAcciCheckCharge (");
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getCheckNo()).append("',");
            debugBuffer.append("").append(prpLAcciCheckChargeDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getChargeCode()).append("',");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getChargeName()).append("',");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLAcciCheckChargeDto.getChargeAmount()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLAcciCheckChargeDto.getCheckNo());
        dbManager.setInt(2,prpLAcciCheckChargeDto.getSerialNo());
        dbManager.setString(3,prpLAcciCheckChargeDto.getChargeCode());
        dbManager.setString(4,prpLAcciCheckChargeDto.getChargeName());
        dbManager.setString(5,prpLAcciCheckChargeDto.getCurrency());
        dbManager.setDouble(6,prpLAcciCheckChargeDto.getChargeAmount());
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
        buffer.append("INSERT INTO PrpLAcciCheckCharge (");
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = (PrpLAcciCheckChargeDto)i.next();
            dbManager.setString(1,prpLAcciCheckChargeDto.getCheckNo());
            dbManager.setInt(2,prpLAcciCheckChargeDto.getSerialNo());
            dbManager.setString(3,prpLAcciCheckChargeDto.getChargeCode());
            dbManager.setString(4,prpLAcciCheckChargeDto.getChargeName());
            dbManager.setString(5,prpLAcciCheckChargeDto.getCurrency());
            dbManager.setDouble(6,prpLAcciCheckChargeDto.getChargeAmount());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param checkNo �����-CheckNo
     * @param serialNo ���-SerialNo
     * @throws Exception
     */
    public void delete(String checkNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLAcciCheckCharge ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,checkNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void update(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLAcciCheckCharge SET ");
        buffer.append("ChargeCode = ?, ");
        buffer.append("ChargeName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("ChargeAmount = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLAcciCheckCharge SET ");
            debugBuffer.append("ChargeCode = '" + prpLAcciCheckChargeDto.getChargeCode() + "', ");
            debugBuffer.append("ChargeName = '" + prpLAcciCheckChargeDto.getChargeName() + "', ");
            debugBuffer.append("Currency = '" + prpLAcciCheckChargeDto.getCurrency() + "', ");
            debugBuffer.append("ChargeAmount = " + prpLAcciCheckChargeDto.getChargeAmount() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(prpLAcciCheckChargeDto.getCheckNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLAcciCheckChargeDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLAcciCheckChargeDto.getChargeCode());
        dbManager.setString(2,prpLAcciCheckChargeDto.getChargeName());
        dbManager.setString(3,prpLAcciCheckChargeDto.getCurrency());
        dbManager.setDouble(4,prpLAcciCheckChargeDto.getChargeAmount());
        //���������ֶ�;
        dbManager.setString(5,prpLAcciCheckChargeDto.getCheckNo());
        dbManager.setInt(6,prpLAcciCheckChargeDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param checkNo �����-CheckNo
     * @param serialNo ���-SerialNo
     * @return PrpLAcciCheckChargeDto
     * @throws Exception
     */
    public PrpLAcciCheckChargeDto findByPrimaryKey(String checkNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append("FROM PrpLAcciCheckCharge ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,checkNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        if(resultSet.next()){
            prpLAcciCheckChargeDto = new PrpLAcciCheckChargeDto();
            prpLAcciCheckChargeDto.setCheckNo(dbManager.getString(resultSet,1));
            prpLAcciCheckChargeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLAcciCheckChargeDto.setChargeCode(dbManager.getString(resultSet,3));
            prpLAcciCheckChargeDto.setChargeName(dbManager.getString(resultSet,4));
            prpLAcciCheckChargeDto.setCurrency(dbManager.getString(resultSet,5));
            prpLAcciCheckChargeDto.setChargeAmount(dbManager.getDouble(resultSet,6));
        }else{
            logger.info("DBPrpLAcciCheckChargeBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLAcciCheckChargeDto;
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
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append("FROM PrpLAcciCheckCharge WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLAcciCheckChargeDto = new PrpLAcciCheckChargeDto();
            prpLAcciCheckChargeDto.setCheckNo(dbManager.getString(resultSet,1));
            prpLAcciCheckChargeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLAcciCheckChargeDto.setChargeCode(dbManager.getString(resultSet,3));
            prpLAcciCheckChargeDto.setChargeName(dbManager.getString(resultSet,4));
            prpLAcciCheckChargeDto.setCurrency(dbManager.getString(resultSet,5));
            prpLAcciCheckChargeDto.setChargeAmount(dbManager.getDouble(resultSet,6));
            collection.add(prpLAcciCheckChargeDto);
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
        buffer.append("DELETE FROM PrpLAcciCheckCharge WHERE ");
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
        String  statement ;
                          statement = "SELECT count(1) FROM PrpLAcciCheckCharge WHERE ";
                                   statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
