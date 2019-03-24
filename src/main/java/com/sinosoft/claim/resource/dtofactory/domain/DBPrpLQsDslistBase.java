package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsDslistDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_Dslist����ͨ�������ϸ�嵥������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLQsDslistBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpLQsDslistBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLQsDslistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public void insert(PrpLQsDslistDto prpLQs_DslistDto) throws Exception{
        String statement = " Insert Into PrpLQs_Dslist(" + 
                           " ProcNo," + 
                           " SerialNo," + 
                           " DamageDate," + 
                           " CbComCode," + 
                           " CbComCName," + 
                           " LpComCode," + 
                           " LpComCName," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredName," + 
                           " ClaimAgntNo," + 
                           " AgntTypeCode," + 
                           " ReciptNo," + 
                           " ClaimAgntFee," + 
                           " RealPayFee," + 
                           " HandlerCode," + 
                           " ProcDate," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " DifferFlag," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLQs_DslistDto.getProcNo());
        dbManager.setInt(2,prpLQs_DslistDto.getSerialNo());
        dbManager.setDateTime(3,prpLQs_DslistDto.getDamageDate());
        dbManager.setString(4,prpLQs_DslistDto.getCbComCode());
        dbManager.setString(5,prpLQs_DslistDto.getCbComCName());
        dbManager.setString(6,prpLQs_DslistDto.getLpComCode());
        dbManager.setString(7,prpLQs_DslistDto.getLpComCName());
        dbManager.setString(8,prpLQs_DslistDto.getPolicyNo());
        dbManager.setString(9,prpLQs_DslistDto.getLicenseNo());
        dbManager.setString(10,prpLQs_DslistDto.getInsuredName());
        dbManager.setString(11,prpLQs_DslistDto.getClaimAgntNo());
        dbManager.setString(12,prpLQs_DslistDto.getAgntTypeCode());
        dbManager.setString(13,prpLQs_DslistDto.getReciptNo());
        dbManager.setDouble(14,prpLQs_DslistDto.getClaimAgntFee());
        dbManager.setDouble(15,prpLQs_DslistDto.getRealPayFee());
        dbManager.setString(16,prpLQs_DslistDto.getHandlerCode());
        dbManager.setDateTime(17,prpLQs_DslistDto.getProcDate());
        dbManager.setString(18,prpLQs_DslistDto.getOperatorCode());
        dbManager.setString(19,prpLQs_DslistDto.getComCode());
        dbManager.setString(20,prpLQs_DslistDto.getDifferFlag());
        dbManager.setString(21,prpLQs_DslistDto.getRemark());
        dbManager.setString(22,prpLQs_DslistDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLQs_DslistBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLQsDslistDto prpLQs_DslistDto = (PrpLQsDslistDto)i.next();
            insert(prpLQs_DslistDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @throws Exception
     */
    public void delete(String procNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLQs_Dslist Where " +
                           " ProcNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,procNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLQs_DslistBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public void update(PrpLQsDslistDto prpLQs_DslistDto) throws Exception{
        String statement = " Update PrpLQs_Dslist Set DamageDate = ?," + 
                           " CbComCode = ?," + 
                           " CbComCName = ?," + 
                           " LpComCode = ?," + 
                           " LpComCName = ?," + 
                           " PolicyNo = ?," + 
                           " LicenseNo = ?," + 
                           " InsuredName = ?," + 
                           " ClaimAgntNo = ?," + 
                           " AgntTypeCode = ?," + 
                           " ReciptNo = ?," + 
                           " ClaimAgntFee = ?," + 
                           " RealPayFee = ?," + 
                           " HandlerCode = ?," + 
                           " ProcDate = ?," + 
                           " OperatorCode = ?," + 
                           " ComCode = ?," + 
                           " DifferFlag = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " ProcNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpLQs_DslistDto.getDamageDate());
        dbManager.setString(2,prpLQs_DslistDto.getCbComCode());
        dbManager.setString(3,prpLQs_DslistDto.getCbComCName());
        dbManager.setString(4,prpLQs_DslistDto.getLpComCode());
        dbManager.setString(5,prpLQs_DslistDto.getLpComCName());
        dbManager.setString(6,prpLQs_DslistDto.getPolicyNo());
        dbManager.setString(7,prpLQs_DslistDto.getLicenseNo());
        dbManager.setString(8,prpLQs_DslistDto.getInsuredName());
        dbManager.setString(9,prpLQs_DslistDto.getClaimAgntNo());
        dbManager.setString(10,prpLQs_DslistDto.getAgntTypeCode());
        dbManager.setString(11,prpLQs_DslistDto.getReciptNo());
        dbManager.setDouble(12,prpLQs_DslistDto.getClaimAgntFee());
        dbManager.setDouble(13,prpLQs_DslistDto.getRealPayFee());
        dbManager.setString(14,prpLQs_DslistDto.getHandlerCode());
        dbManager.setDateTime(15,prpLQs_DslistDto.getProcDate());
        dbManager.setString(16,prpLQs_DslistDto.getOperatorCode());
        dbManager.setString(17,prpLQs_DslistDto.getComCode());
        dbManager.setString(18,prpLQs_DslistDto.getDifferFlag());
        dbManager.setString(19,prpLQs_DslistDto.getRemark());
        dbManager.setString(20,prpLQs_DslistDto.getFlag());
        //���������ֶ�;
        dbManager.setString(21,prpLQs_DslistDto.getProcNo());
        dbManager.setInt(22,prpLQs_DslistDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLQs_DslistBase.update() success!");
    }

    /**
     * ����������һ������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @return PrpLQsDslistDto
     * @throws Exception
     */
    public PrpLQsDslistDto findByPrimaryKey(String procNo,int serialNo) throws Exception{
        String statement = " Select ProcNo," + 
                           " SerialNo," + 
                           " DamageDate," + 
                           " CbComCode," + 
                           " CbComCName," + 
                           " LpComCode," + 
                           " LpComCName," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredName," + 
                           " ClaimAgntNo," + 
                           " AgntTypeCode," + 
                           " ReciptNo," + 
                           " ClaimAgntFee," + 
                           " RealPayFee," + 
                           " HandlerCode," + 
                           " ProcDate," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " DifferFlag," + 
                           " Remark," + 
                           " Flag From PrpLQs_Dslist Where " +
                           " ProcNo = ? And " + 
                           " SerialNo = ?";
        PrpLQsDslistDto prpLQs_DslistDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,procNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLQs_DslistDto = new PrpLQsDslistDto();
            prpLQs_DslistDto.setProcNo(dbManager.getString(resultSet,1));
            prpLQs_DslistDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLQs_DslistDto.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLQs_DslistDto.setCbComCode(dbManager.getString(resultSet,4));
            prpLQs_DslistDto.setCbComCName(dbManager.getString(resultSet,5));
            prpLQs_DslistDto.setLpComCode(dbManager.getString(resultSet,6));
            prpLQs_DslistDto.setLpComCName(dbManager.getString(resultSet,7));
            prpLQs_DslistDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLQs_DslistDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLQs_DslistDto.setInsuredName(dbManager.getString(resultSet,10));
            prpLQs_DslistDto.setClaimAgntNo(dbManager.getString(resultSet,11));
            prpLQs_DslistDto.setAgntTypeCode(dbManager.getString(resultSet,12));
            prpLQs_DslistDto.setReciptNo(dbManager.getString(resultSet,13));
            prpLQs_DslistDto.setClaimAgntFee(dbManager.getDouble(resultSet,14));
            prpLQs_DslistDto.setRealPayFee(dbManager.getDouble(resultSet,15));
            prpLQs_DslistDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLQs_DslistDto.setProcDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLQs_DslistDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLQs_DslistDto.setComCode(dbManager.getString(resultSet,19));
            prpLQs_DslistDto.setDifferFlag(dbManager.getString(resultSet,20));
            prpLQs_DslistDto.setRemark(dbManager.getString(resultSet,21));
            prpLQs_DslistDto.setFlag(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        log.info("DBPrpLQs_DslistBase.findByPrimaryKey() success!");
        return prpLQs_DslistDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select ProcNo," + 
                           " SerialNo," + 
                           " DamageDate," + 
                           " CbComCode," + 
                           " CbComCName," + 
                           " LpComCode," + 
                           " LpComCName," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredName," + 
                           " ClaimAgntNo," + 
                           " AgntTypeCode," + 
                           " ReciptNo," + 
                           " ClaimAgntFee," + 
                           " RealPayFee," + 
                           " HandlerCode," + 
                           " ProcDate," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " DifferFlag," + 
                           " Remark," + 
                           " Flag From PrpLQs_Dslist Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLQsDslistDto prpLQs_DslistDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLQs_DslistDto = new PrpLQsDslistDto();
            prpLQs_DslistDto.setProcNo(dbManager.getString(resultSet,1));
            prpLQs_DslistDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLQs_DslistDto.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLQs_DslistDto.setCbComCode(dbManager.getString(resultSet,4));
            prpLQs_DslistDto.setCbComCName(dbManager.getString(resultSet,5));
            prpLQs_DslistDto.setLpComCode(dbManager.getString(resultSet,6));
            prpLQs_DslistDto.setLpComCName(dbManager.getString(resultSet,7));
            prpLQs_DslistDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLQs_DslistDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLQs_DslistDto.setInsuredName(dbManager.getString(resultSet,10));
            prpLQs_DslistDto.setClaimAgntNo(dbManager.getString(resultSet,11));
            prpLQs_DslistDto.setAgntTypeCode(dbManager.getString(resultSet,12));
            prpLQs_DslistDto.setReciptNo(dbManager.getString(resultSet,13));
            prpLQs_DslistDto.setClaimAgntFee(dbManager.getDouble(resultSet,14));
            prpLQs_DslistDto.setRealPayFee(dbManager.getDouble(resultSet,15));
            prpLQs_DslistDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLQs_DslistDto.setProcDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLQs_DslistDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLQs_DslistDto.setComCode(dbManager.getString(resultSet,19));
            prpLQs_DslistDto.setDifferFlag(dbManager.getString(resultSet,20));
            prpLQs_DslistDto.setRemark(dbManager.getString(resultSet,21));
            prpLQs_DslistDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpLQs_DslistDto);
        }
        resultSet.close();
        log.info("DBPrpLQs_DslistBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLQs_Dslist Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLQs_DslistBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLQs_Dslist Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLQs_DslistBase.getCount() success!");
        return count;
    }
}
