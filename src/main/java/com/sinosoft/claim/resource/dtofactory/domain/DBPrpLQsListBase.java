package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsListDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_list��������ͨ�������ϸ�嵥�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLQsListBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpLQsListBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLQsListBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public void insert(PrpLQsListDto prpLQs_listDto) throws Exception{
        String statement = " Insert Into PrpLQs_list(" + 
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
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLQs_listDto.getProcNo());
        dbManager.setInt(2,prpLQs_listDto.getSerialNo());
        dbManager.setDateTime(3,prpLQs_listDto.getDamageDate());
        dbManager.setString(4,prpLQs_listDto.getCbComCode());
        dbManager.setString(5,prpLQs_listDto.getCbComCName());
        dbManager.setString(6,prpLQs_listDto.getLpComCode());
        dbManager.setString(7,prpLQs_listDto.getLpComCName());
        dbManager.setString(8,prpLQs_listDto.getPolicyNo());
        dbManager.setString(9,prpLQs_listDto.getLicenseNo());
        dbManager.setString(10,prpLQs_listDto.getInsuredName());
        dbManager.setString(11,prpLQs_listDto.getClaimAgntNo());
        dbManager.setString(12,prpLQs_listDto.getAgntTypeCode());
        dbManager.setString(13,prpLQs_listDto.getReciptNo());
        dbManager.setDouble(14,prpLQs_listDto.getClaimAgntFee());
        dbManager.setDouble(15,prpLQs_listDto.getRealPayFee());
        dbManager.setString(16,prpLQs_listDto.getHandlerCode());
        dbManager.setDateTime(17,prpLQs_listDto.getProcDate());
        dbManager.setString(18,prpLQs_listDto.getOperatorCode());
        dbManager.setString(19,prpLQs_listDto.getComCode());
        dbManager.setString(20,prpLQs_listDto.getRemark());
        dbManager.setString(21,prpLQs_listDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLQs_listBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLQsListDto prpLQs_listDto = (PrpLQsListDto)i.next();
            insert(prpLQs_listDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @throws Exception
     */
    public void delete(String procNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLQs_list Where " +
                           " ProcNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,procNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLQs_listBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public void update(PrpLQsListDto prpLQs_listDto) throws Exception{
        String statement = " Update PrpLQs_list Set DamageDate = ?," + 
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
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " ProcNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpLQs_listDto.getDamageDate());
        dbManager.setString(2,prpLQs_listDto.getCbComCode());
        dbManager.setString(3,prpLQs_listDto.getCbComCName());
        dbManager.setString(4,prpLQs_listDto.getLpComCode());
        dbManager.setString(5,prpLQs_listDto.getLpComCName());
        dbManager.setString(6,prpLQs_listDto.getPolicyNo());
        dbManager.setString(7,prpLQs_listDto.getLicenseNo());
        dbManager.setString(8,prpLQs_listDto.getInsuredName());
        dbManager.setString(9,prpLQs_listDto.getClaimAgntNo());
        dbManager.setString(10,prpLQs_listDto.getAgntTypeCode());
        dbManager.setString(11,prpLQs_listDto.getReciptNo());
        dbManager.setDouble(12,prpLQs_listDto.getClaimAgntFee());
        dbManager.setDouble(13,prpLQs_listDto.getRealPayFee());
        dbManager.setString(14,prpLQs_listDto.getHandlerCode());
        dbManager.setDateTime(15,prpLQs_listDto.getProcDate());
        dbManager.setString(16,prpLQs_listDto.getOperatorCode());
        dbManager.setString(17,prpLQs_listDto.getComCode());
        dbManager.setString(18,prpLQs_listDto.getRemark());
        dbManager.setString(19,prpLQs_listDto.getFlag());
        //���������ֶ�;
        dbManager.setString(20,prpLQs_listDto.getProcNo());
        dbManager.setInt(21,prpLQs_listDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLQs_listBase.update() success!");
    }

    /**
     * ����������һ������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @return PrpLQsListDto
     * @throws Exception
     */
    public PrpLQsListDto findByPrimaryKey(String procNo,int serialNo) throws Exception{
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
                           " Remark," + 
                           " Flag From PrpLQs_list Where " +
                           " ProcNo = ? And " + 
                           " SerialNo = ?";
        PrpLQsListDto prpLQs_listDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,procNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLQs_listDto = new PrpLQsListDto();
            prpLQs_listDto.setProcNo(dbManager.getString(resultSet,1));
            prpLQs_listDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLQs_listDto.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLQs_listDto.setCbComCode(dbManager.getString(resultSet,4));
            prpLQs_listDto.setCbComCName(dbManager.getString(resultSet,5));
            prpLQs_listDto.setLpComCode(dbManager.getString(resultSet,6));
            prpLQs_listDto.setLpComCName(dbManager.getString(resultSet,7));
            prpLQs_listDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLQs_listDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLQs_listDto.setInsuredName(dbManager.getString(resultSet,10));
            prpLQs_listDto.setClaimAgntNo(dbManager.getString(resultSet,11));
            prpLQs_listDto.setAgntTypeCode(dbManager.getString(resultSet,12));
            prpLQs_listDto.setReciptNo(dbManager.getString(resultSet,13));
            prpLQs_listDto.setClaimAgntFee(dbManager.getDouble(resultSet,14));
            prpLQs_listDto.setRealPayFee(dbManager.getDouble(resultSet,15));
            prpLQs_listDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLQs_listDto.setProcDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLQs_listDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLQs_listDto.setComCode(dbManager.getString(resultSet,19));
            prpLQs_listDto.setRemark(dbManager.getString(resultSet,20));
            prpLQs_listDto.setFlag(dbManager.getString(resultSet,21));
        }
        resultSet.close();
        log.info("DBPrpLQs_listBase.findByPrimaryKey() success!");
        return prpLQs_listDto;
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
                           " Remark," + 
                           " Flag From PrpLQs_list Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLQsListDto prpLQs_listDto = null;
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

            prpLQs_listDto = new PrpLQsListDto();
            prpLQs_listDto.setProcNo(dbManager.getString(resultSet,1));
            prpLQs_listDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLQs_listDto.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLQs_listDto.setCbComCode(dbManager.getString(resultSet,4));
            prpLQs_listDto.setCbComCName(dbManager.getString(resultSet,5));
            prpLQs_listDto.setLpComCode(dbManager.getString(resultSet,6));
            prpLQs_listDto.setLpComCName(dbManager.getString(resultSet,7));
            prpLQs_listDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLQs_listDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLQs_listDto.setInsuredName(dbManager.getString(resultSet,10));
            prpLQs_listDto.setClaimAgntNo(dbManager.getString(resultSet,11));
            prpLQs_listDto.setAgntTypeCode(dbManager.getString(resultSet,12));
            prpLQs_listDto.setReciptNo(dbManager.getString(resultSet,13));
            prpLQs_listDto.setClaimAgntFee(dbManager.getDouble(resultSet,14));
            prpLQs_listDto.setRealPayFee(dbManager.getDouble(resultSet,15));
            prpLQs_listDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLQs_listDto.setProcDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLQs_listDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLQs_listDto.setComCode(dbManager.getString(resultSet,19));
            prpLQs_listDto.setRemark(dbManager.getString(resultSet,20));
            prpLQs_listDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpLQs_listDto);
        }
        resultSet.close();
        log.info("DBPrpLQs_listBase.findByConditions() success!");
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
        String statement = "Delete From PrpLQs_list Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLQs_listBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLQs_list Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLQs_listBase.getCount() success!");
        return count;
    }
}
