package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoins�����ݷ��ʶ������<br>
 * ������ 2013-09-09 20:19:13.218<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpPcoinsBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpPcoinsBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPcoinsBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void insert(PrpPcoinsDto prpPcoinsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpPcoins (");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("mainPolicyNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("flag,");
        buffer.append("chiefFlag,");
        buffer.append("proportionFlag,");
        buffer.append("chgCoinsRate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpPcoinsDto.getEndorseNo()).append("',");
            debugBuffer.append("'").append(prpPcoinsDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpPcoinsDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpPcoinsDto.getMainPolicyNo()).append("',");
            debugBuffer.append("'").append(prpPcoinsDto.getCoinsCode()).append("',");
            debugBuffer.append("'").append(prpPcoinsDto.getCoinsName()).append("',");
            debugBuffer.append("'").append(prpPcoinsDto.getCoinsType()).append("',");
            debugBuffer.append("").append(prpPcoinsDto.getCoinsRate()).append(",");
            debugBuffer.append("'").append(prpPcoinsDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpPcoinsDto.getChiefFlag()).append("',");
            debugBuffer.append("'").append(prpPcoinsDto.getProportionFlag()).append("',");
            debugBuffer.append("").append(prpPcoinsDto.getChgCoinsRate()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpPcoinsDto.getEndorseNo());
        dbManager.setString(2,prpPcoinsDto.getPolicyNo());
        dbManager.setInt(3,prpPcoinsDto.getSerialNo());
        dbManager.setString(4,prpPcoinsDto.getMainPolicyNo());
        dbManager.setString(5,prpPcoinsDto.getCoinsCode());
        dbManager.setString(6,prpPcoinsDto.getCoinsName());
        dbManager.setString(7,prpPcoinsDto.getCoinsType());
        dbManager.setDouble(8,prpPcoinsDto.getCoinsRate());
        dbManager.setString(9,prpPcoinsDto.getFlag());
        dbManager.setString(10,prpPcoinsDto.getChiefFlag());
        dbManager.setString(11,prpPcoinsDto.getProportionFlag());
        dbManager.setDouble(12,prpPcoinsDto.getChgCoinsRate());
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
        buffer.append("INSERT INTO PrpPcoins (");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("mainPolicyNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("flag,");
        buffer.append("chiefFlag,");
        buffer.append("proportionFlag,");
        buffer.append("chgCoinsRate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpPcoinsDto prpPcoinsDto = (PrpPcoinsDto)i.next();
            dbManager.setString(1,prpPcoinsDto.getEndorseNo());
            dbManager.setString(2,prpPcoinsDto.getPolicyNo());
            dbManager.setInt(3,prpPcoinsDto.getSerialNo());
            dbManager.setString(4,prpPcoinsDto.getMainPolicyNo());
            dbManager.setString(5,prpPcoinsDto.getCoinsCode());
            dbManager.setString(6,prpPcoinsDto.getCoinsName());
            dbManager.setString(7,prpPcoinsDto.getCoinsType());
            dbManager.setDouble(8,prpPcoinsDto.getCoinsRate());
            dbManager.setString(9,prpPcoinsDto.getFlag());
            dbManager.setString(10,prpPcoinsDto.getChiefFlag());
            dbManager.setString(11,prpPcoinsDto.getProportionFlag());
            dbManager.setDouble(12,prpPcoinsDto.getChgCoinsRate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String endorseNo,long serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpPcoins ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("endorseNo=").append("'").append(endorseNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("endorseNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.setLong(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void update(PrpPcoinsDto prpPcoinsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpPcoins SET ");
        buffer.append("policyNo = ?, ");
        buffer.append("mainPolicyNo = ?, ");
        buffer.append("coinsCode = ?, ");
        buffer.append("coinsName = ?, ");
        buffer.append("coinsType = ?, ");
        buffer.append("coinsRate = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("chiefFlag = ?, ");
        buffer.append("proportionFlag = ?, ");
        buffer.append("chgCoinsRate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpPcoins SET ");
            debugBuffer.append("policyNo = '" + prpPcoinsDto.getPolicyNo() + "', ");
            debugBuffer.append("mainPolicyNo = '" + prpPcoinsDto.getMainPolicyNo() + "', ");
            debugBuffer.append("coinsCode = '" + prpPcoinsDto.getCoinsCode() + "', ");
            debugBuffer.append("coinsName = '" + prpPcoinsDto.getCoinsName() + "', ");
            debugBuffer.append("coinsType = '" + prpPcoinsDto.getCoinsType() + "', ");
            debugBuffer.append("coinsRate = " + prpPcoinsDto.getCoinsRate() + ", ");
            debugBuffer.append("flag = '" + prpPcoinsDto.getFlag() + "', ");
            debugBuffer.append("chiefFlag = '" + prpPcoinsDto.getChiefFlag() + "', ");
            debugBuffer.append("proportionFlag = '" + prpPcoinsDto.getProportionFlag() + "', ");
            debugBuffer.append("chgCoinsRate = " + prpPcoinsDto.getChgCoinsRate() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("endorseNo=").append("'").append(prpPcoinsDto.getEndorseNo()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpPcoinsDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("endorseNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpPcoinsDto.getPolicyNo());
        dbManager.setString(2,prpPcoinsDto.getMainPolicyNo());
        dbManager.setString(3,prpPcoinsDto.getCoinsCode());
        dbManager.setString(4,prpPcoinsDto.getCoinsName());
        dbManager.setString(5,prpPcoinsDto.getCoinsType());
        dbManager.setDouble(6,prpPcoinsDto.getCoinsRate());
        dbManager.setString(7,prpPcoinsDto.getFlag());
        dbManager.setString(8,prpPcoinsDto.getChiefFlag());
        dbManager.setString(9,prpPcoinsDto.getProportionFlag());
        dbManager.setDouble(10,prpPcoinsDto.getChgCoinsRate());
        //���������ֶ�;
        dbManager.setString(11,prpPcoinsDto.getEndorseNo());
        dbManager.setInt(12,prpPcoinsDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @return PrpPcoinsDto
     * @throws Exception
     */
    public PrpPcoinsDto findByPrimaryKey(String endorseNo,long serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("mainPolicyNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("flag,");
        buffer.append("chiefFlag,");
        buffer.append("proportionFlag,");
        buffer.append("chgCoinsRate ");
        buffer.append("FROM PrpPcoins ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("endorseNo=").append("'").append(endorseNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("endorseNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.setLong(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpPcoinsDto prpPcoinsDto = null;
        if(resultSet.next()){
            prpPcoinsDto = new PrpPcoinsDto();
            prpPcoinsDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcoinsDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcoinsDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpPcoinsDto.setMainPolicyNo(dbManager.getString(resultSet,4));
            prpPcoinsDto.setCoinsCode(dbManager.getString(resultSet,5));
            prpPcoinsDto.setCoinsName(dbManager.getString(resultSet,6));
            prpPcoinsDto.setCoinsType(dbManager.getString(resultSet,7));
            prpPcoinsDto.setCoinsRate(dbManager.getDouble(resultSet,8));
            prpPcoinsDto.setFlag(dbManager.getString(resultSet,9));
            prpPcoinsDto.setChiefFlag(dbManager.getString(resultSet,10));
            prpPcoinsDto.setProportionFlag(dbManager.getString(resultSet,11));
            prpPcoinsDto.setChgCoinsRate(dbManager.getDouble(resultSet,12));
        }
        resultSet.close();
        return prpPcoinsDto;
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
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("mainPolicyNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("flag,");
        buffer.append("chiefFlag,");
        buffer.append("proportionFlag,");
        buffer.append("chgCoinsRate ");
        buffer.append("FROM PrpPcoins WHERE ");
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
        PrpPcoinsDto prpPcoinsDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpPcoinsDto = new PrpPcoinsDto();
            prpPcoinsDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcoinsDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcoinsDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpPcoinsDto.setMainPolicyNo(dbManager.getString(resultSet,4));
            prpPcoinsDto.setCoinsCode(dbManager.getString(resultSet,5));
            prpPcoinsDto.setCoinsName(dbManager.getString(resultSet,6));
            prpPcoinsDto.setCoinsType(dbManager.getString(resultSet,7));
            prpPcoinsDto.setCoinsRate(dbManager.getDouble(resultSet,8));
            prpPcoinsDto.setFlag(dbManager.getString(resultSet,9));
            prpPcoinsDto.setChiefFlag(dbManager.getString(resultSet,10));
            prpPcoinsDto.setProportionFlag(dbManager.getString(resultSet,11));
            prpPcoinsDto.setChgCoinsRate(dbManager.getDouble(resultSet,12));
            collection.add(prpPcoinsDto);
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
        buffer.append("DELETE FROM PrpPcoins WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpPcoins WHERE ");
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
