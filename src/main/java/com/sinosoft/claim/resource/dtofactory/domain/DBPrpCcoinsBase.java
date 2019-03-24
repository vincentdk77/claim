package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCcoins�����ݷ��ʶ������<br>
 * ������ 2005-12-21 09:21:03.421<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCcoinsBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpCcoinsBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCcoinsBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void insert(PrpCcoinsDto prpCcoinsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCcoins (");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("MainPolicyNo,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CoinsRate,");
        buffer.append("Flag,");
        buffer.append("ChiefFlag,");
        buffer.append("ProportionFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCcoinsDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpCcoinsDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpCcoinsDto.getMainPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCcoinsDto.getCoinsCode()).append("',");
            debugBuffer.append("'").append(prpCcoinsDto.getCoinsName()).append("',");
            debugBuffer.append("'").append(prpCcoinsDto.getCoinsType()).append("',");
            debugBuffer.append("").append(prpCcoinsDto.getCoinsRate()).append(",");
            debugBuffer.append("'").append(prpCcoinsDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpCcoinsDto.getChiefFlag()).append("',");
            debugBuffer.append("'").append(prpCcoinsDto.getProportionFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCcoinsDto.getPolicyNo());
        dbManager.setInt(2,prpCcoinsDto.getSerialNo());
        dbManager.setString(3,prpCcoinsDto.getMainPolicyNo());
        dbManager.setString(4,prpCcoinsDto.getCoinsCode());
        dbManager.setString(5,prpCcoinsDto.getCoinsName());
        dbManager.setString(6,prpCcoinsDto.getCoinsType());
        dbManager.setDouble(7,prpCcoinsDto.getCoinsRate());
        dbManager.setString(8,prpCcoinsDto.getFlag());
        dbManager.setString(9,prpCcoinsDto.getChiefFlag());
        dbManager.setString(10,prpCcoinsDto.getProportionFlag());
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
        buffer.append("INSERT INTO PrpCcoins (");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("MainPolicyNo,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CoinsRate,");
        buffer.append("Flag,");
        buffer.append("ChiefFlag,");
        buffer.append("ProportionFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCcoinsDto prpCcoinsDto = (PrpCcoinsDto)i.next();
            dbManager.setString(1,prpCcoinsDto.getPolicyNo());
            dbManager.setInt(2,prpCcoinsDto.getSerialNo());
            dbManager.setString(3,prpCcoinsDto.getMainPolicyNo());
            dbManager.setString(4,prpCcoinsDto.getCoinsCode());
            dbManager.setString(5,prpCcoinsDto.getCoinsName());
            dbManager.setString(6,prpCcoinsDto.getCoinsType());
            dbManager.setDouble(7,prpCcoinsDto.getCoinsRate());
            dbManager.setString(8,prpCcoinsDto.getFlag());
            dbManager.setString(9,prpCcoinsDto.getChiefFlag());
            dbManager.setString(10,prpCcoinsDto.getProportionFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param policyNo PolicyNo
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCcoins ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void update(PrpCcoinsDto prpCcoinsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCcoins SET ");
        buffer.append("MainPolicyNo = ?, ");
        buffer.append("CoinsCode = ?, ");
        buffer.append("CoinsName = ?, ");
        buffer.append("CoinsType = ?, ");
        buffer.append("CoinsRate = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("ChiefFlag = ?, ");
        buffer.append("ProportionFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCcoins SET ");
            debugBuffer.append("MainPolicyNo = '" + prpCcoinsDto.getMainPolicyNo() + "', ");
            debugBuffer.append("CoinsCode = '" + prpCcoinsDto.getCoinsCode() + "', ");
            debugBuffer.append("CoinsName = '" + prpCcoinsDto.getCoinsName() + "', ");
            debugBuffer.append("CoinsType = '" + prpCcoinsDto.getCoinsType() + "', ");
            debugBuffer.append("CoinsRate = " + prpCcoinsDto.getCoinsRate() + ", ");
            debugBuffer.append("Flag = '" + prpCcoinsDto.getFlag() + "', ");
            debugBuffer.append("ChiefFlag = '" + prpCcoinsDto.getChiefFlag() + "', ");
            debugBuffer.append("ProportionFlag = '" + prpCcoinsDto.getProportionFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCcoinsDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpCcoinsDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpCcoinsDto.getMainPolicyNo());
        dbManager.setString(2,prpCcoinsDto.getCoinsCode());
        dbManager.setString(3,prpCcoinsDto.getCoinsName());
        dbManager.setString(4,prpCcoinsDto.getCoinsType());
        dbManager.setDouble(5,prpCcoinsDto.getCoinsRate());
        dbManager.setString(6,prpCcoinsDto.getFlag());
        dbManager.setString(7,prpCcoinsDto.getChiefFlag());
        dbManager.setString(8,prpCcoinsDto.getProportionFlag());
        //���������ֶ�;
        dbManager.setString(9,prpCcoinsDto.getPolicyNo());
        dbManager.setInt(10,prpCcoinsDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param policyNo PolicyNo
     * @param serialNo SerialNo
     * @return PrpCcoinsDto
     * @throws Exception
     */
    public PrpCcoinsDto findByPrimaryKey(String policyNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("MainPolicyNo,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CoinsRate,");
        buffer.append("Flag,");
        buffer.append("ChiefFlag,");
        buffer.append("ProportionFlag ");
        buffer.append("FROM PrpCcoins ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCcoinsDto prpCcoinsDto = null;
        if(resultSet.next()){
            prpCcoinsDto = new PrpCcoinsDto();
            prpCcoinsDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcoinsDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCcoinsDto.setMainPolicyNo(dbManager.getString(resultSet,3));
            prpCcoinsDto.setCoinsCode(dbManager.getString(resultSet,4));
            prpCcoinsDto.setCoinsName(dbManager.getString(resultSet,5));
            prpCcoinsDto.setCoinsType(dbManager.getString(resultSet,6));
            prpCcoinsDto.setCoinsRate(dbManager.getDouble(resultSet,7));
            prpCcoinsDto.setFlag(dbManager.getString(resultSet,8));
            prpCcoinsDto.setChiefFlag(dbManager.getString(resultSet,9));
            prpCcoinsDto.setProportionFlag(dbManager.getString(resultSet,10));
        }else{
            logger.info("DBPrpCcoinsBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpCcoinsDto;
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
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("MainPolicyNo,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CoinsRate,");
        buffer.append("Flag,");
        buffer.append("ChiefFlag,");
        buffer.append("ProportionFlag ");
        buffer.append("FROM PrpCcoins WHERE ");
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
        PrpCcoinsDto prpCcoinsDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCcoinsDto = new PrpCcoinsDto();
            prpCcoinsDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcoinsDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCcoinsDto.setMainPolicyNo(dbManager.getString(resultSet,3));
            prpCcoinsDto.setCoinsCode(dbManager.getString(resultSet,4));
            prpCcoinsDto.setCoinsName(dbManager.getString(resultSet,5));
            prpCcoinsDto.setCoinsType(dbManager.getString(resultSet,6));
            prpCcoinsDto.setCoinsRate(dbManager.getDouble(resultSet,7));
            prpCcoinsDto.setFlag(dbManager.getString(resultSet,8));
            prpCcoinsDto.setChiefFlag(dbManager.getString(resultSet,9));
            prpCcoinsDto.setProportionFlag(dbManager.getString(resultSet,10));
            collection.add(prpCcoinsDto);
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
        buffer.append("DELETE FROM PrpCcoins WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpCcoins WHERE ");
        conditions = SqlUtils.getWherePartForGetCount(conditions);
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
