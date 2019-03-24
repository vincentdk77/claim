package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgentDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimAgent-�����Ᵽ����Ϣ������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimAgentBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLclaimAgentBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimAgentBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void insert(PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimAgent (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " OperateDate," + 
                           " Conveyance," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimAgentDto.getClaimNo() + "'," + 
                           "'" + prpLclaimAgentDto.getPolicyNo() + "'," + 
                           "'" + prpLclaimAgentDto.getCentreCode() + "'," + 
                           "'" + prpLclaimAgentDto.getCentreName() + "'," + 
                           "'" + prpLclaimAgentDto.getUnitCode() + "'," + 
                           "'" + prpLclaimAgentDto.getUnitName() + "'," + 
                           "'" + prpLclaimAgentDto.getOperateDate() + "'," + 
                           "'" + prpLclaimAgentDto.getConveyance() + "'," + 
                           "'" + prpLclaimAgentDto.getStartSiteCode() + "'," + 
                           "'" + prpLclaimAgentDto.getStartSiteName() + "'," + 
                           "'" + prpLclaimAgentDto.getViaSiteCode() + "'," + 
                           "'" + prpLclaimAgentDto.getViaSiteName() + "'," + 
                           "'" + prpLclaimAgentDto.getEndSiteCode() + "'," + 
                           "'" + prpLclaimAgentDto.getEndSiteName() + "'," + 
                           "'" + prpLclaimAgentDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimAgentDto.getClaimNo());
        dbManager.setString(2,prpLclaimAgentDto.getPolicyNo());
        dbManager.setString(3,prpLclaimAgentDto.getCentreCode());
        dbManager.setString(4,prpLclaimAgentDto.getCentreName());
        dbManager.setString(5,prpLclaimAgentDto.getUnitCode());
        dbManager.setString(6,prpLclaimAgentDto.getUnitName());
        dbManager.setDateTime(7,prpLclaimAgentDto.getOperateDate());
        dbManager.setString(8,prpLclaimAgentDto.getConveyance());
        dbManager.setString(9,prpLclaimAgentDto.getStartSiteCode());
        dbManager.setString(10,prpLclaimAgentDto.getStartSiteName());
        dbManager.setString(11,prpLclaimAgentDto.getViaSiteCode());
        dbManager.setString(12,prpLclaimAgentDto.getViaSiteName());
        dbManager.setString(13,prpLclaimAgentDto.getEndSiteCode());
        dbManager.setString(14,prpLclaimAgentDto.getEndSiteName());
        dbManager.setString(15,prpLclaimAgentDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimAgentBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimAgent (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " OperateDate," + 
                           " Conveyance," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimAgentDto prpLclaimAgentDto = (PrpLclaimAgentDto)i.next();
            dbManager.setString(1,prpLclaimAgentDto.getClaimNo());
            dbManager.setString(2,prpLclaimAgentDto.getPolicyNo());
            dbManager.setString(3,prpLclaimAgentDto.getCentreCode());
            dbManager.setString(4,prpLclaimAgentDto.getCentreName());
            dbManager.setString(5,prpLclaimAgentDto.getUnitCode());
            dbManager.setString(6,prpLclaimAgentDto.getUnitName());
            dbManager.setDateTime(7,prpLclaimAgentDto.getOperateDate());
            dbManager.setString(8,prpLclaimAgentDto.getConveyance());
            dbManager.setString(9,prpLclaimAgentDto.getStartSiteCode());
            dbManager.setString(10,prpLclaimAgentDto.getStartSiteName());
            dbManager.setString(11,prpLclaimAgentDto.getViaSiteCode());
            dbManager.setString(12,prpLclaimAgentDto.getViaSiteName());
            dbManager.setString(13,prpLclaimAgentDto.getEndSiteCode());
            dbManager.setString(14,prpLclaimAgentDto.getEndSiteName());
            dbManager.setString(15,prpLclaimAgentDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimAgentBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param claimNo �ⰸ��
     * @throws Exception
     */
    public void delete(String claimNo) throws Exception{
        String statement = " Delete From PrpLclaimAgent" + 
	            		   " Where " +
                           " ClaimNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimAgent Where " +
                           " ClaimNo = '" + claimNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimAgentBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void update(PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        String statement = " Update PrpLclaimAgent Set PolicyNo = ?," + 
                           " CentreCode = ?," + 
                           " CentreName = ?," + 
                           " UnitCode = ?," + 
                           " UnitName = ?," + 
                           " OperateDate = ?," + 
                           " Conveyance = ?," + 
                           " StartSiteCode = ?," + 
                           " StartSiteName = ?," + 
                           " ViaSiteCode = ?," + 
                           " ViaSiteName = ?," + 
                           " EndSiteCode = ?," + 
                           " EndSiteName = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimAgent Set " + 
                           " ClaimNo = '" + prpLclaimAgentDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLclaimAgentDto.getPolicyNo() + "'," + 
                           " CentreCode = '" + prpLclaimAgentDto.getCentreCode() + "'," + 
                           " CentreName = '" + prpLclaimAgentDto.getCentreName() + "'," + 
                           " UnitCode = '" + prpLclaimAgentDto.getUnitCode() + "'," + 
                           " UnitName = '" + prpLclaimAgentDto.getUnitName() + "'," + 
                           " OperateDate = '" + prpLclaimAgentDto.getOperateDate() + "'," + 
                           " Conveyance = '" + prpLclaimAgentDto.getConveyance() + "'," + 
                           " StartSiteCode = '" + prpLclaimAgentDto.getStartSiteCode() + "'," + 
                           " StartSiteName = '" + prpLclaimAgentDto.getStartSiteName() + "'," + 
                           " ViaSiteCode = '" + prpLclaimAgentDto.getViaSiteCode() + "'," + 
                           " ViaSiteName = '" + prpLclaimAgentDto.getViaSiteName() + "'," + 
                           " EndSiteCode = '" + prpLclaimAgentDto.getEndSiteCode() + "'," + 
                           " EndSiteName = '" + prpLclaimAgentDto.getEndSiteName() + "'," + 
                           " Flag = '" + prpLclaimAgentDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLclaimAgentDto.getClaimNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLclaimAgentDto.getPolicyNo());
        dbManager.setString(2,prpLclaimAgentDto.getCentreCode());
        dbManager.setString(3,prpLclaimAgentDto.getCentreName());
        dbManager.setString(4,prpLclaimAgentDto.getUnitCode());
        dbManager.setString(5,prpLclaimAgentDto.getUnitName());
        dbManager.setDateTime(6,prpLclaimAgentDto.getOperateDate());
        dbManager.setString(7,prpLclaimAgentDto.getConveyance());
        dbManager.setString(8,prpLclaimAgentDto.getStartSiteCode());
        dbManager.setString(9,prpLclaimAgentDto.getStartSiteName());
        dbManager.setString(10,prpLclaimAgentDto.getViaSiteCode());
        dbManager.setString(11,prpLclaimAgentDto.getViaSiteName());
        dbManager.setString(12,prpLclaimAgentDto.getEndSiteCode());
        dbManager.setString(13,prpLclaimAgentDto.getEndSiteName());
        dbManager.setString(14,prpLclaimAgentDto.getFlag());
        //���������ֶ�;
        dbManager.setString(15,prpLclaimAgentDto.getClaimNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimAgentBase.update() success!");
    }

    /**
     * ����������һ������
     * @param claimNo �ⰸ��
     * @return PrpLclaimAgentDto
     * @throws Exception
     */
    public PrpLclaimAgentDto findByPrimaryKey(String claimNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " PolicyNo," + 
                           " CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " OperateDate," + 
                           " Conveyance," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " Flag From PrpLclaimAgent";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ?";
        PrpLclaimAgentDto prpLclaimAgentDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimAgentDto = new PrpLclaimAgentDto();
            prpLclaimAgentDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimAgentDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimAgentDto.setCentreCode(dbManager.getString(resultSet,3));
            prpLclaimAgentDto.setCentreName(dbManager.getString(resultSet,4));
            prpLclaimAgentDto.setUnitCode(dbManager.getString(resultSet,5));
            prpLclaimAgentDto.setUnitName(dbManager.getString(resultSet,6));
            prpLclaimAgentDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLclaimAgentDto.setConveyance(dbManager.getString(resultSet,8));
            prpLclaimAgentDto.setStartSiteCode(dbManager.getString(resultSet,9));
            prpLclaimAgentDto.setStartSiteName(dbManager.getString(resultSet,10));
            prpLclaimAgentDto.setViaSiteCode(dbManager.getString(resultSet,11));
            prpLclaimAgentDto.setViaSiteName(dbManager.getString(resultSet,12));
            prpLclaimAgentDto.setEndSiteCode(dbManager.getString(resultSet,13));
            prpLclaimAgentDto.setEndSiteName(dbManager.getString(resultSet,14));
            prpLclaimAgentDto.setFlag(dbManager.getString(resultSet,15));
            logger.info("DBPrpLclaimAgentBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimAgentBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimAgentDto;
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
        String statement = "Select ClaimNo," + 
                           " PolicyNo," + 
                           " CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " OperateDate," + 
                           " Conveyance," + 
                           " StartSiteCode," + 
                           " StartSiteName," + 
                           " ViaSiteCode," + 
                           " ViaSiteName," + 
                           " EndSiteCode," + 
                           " EndSiteName," + 
                           " Flag From PrpLclaimAgent Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimAgentDto prpLclaimAgentDto = null;
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

            prpLclaimAgentDto = new PrpLclaimAgentDto();
            prpLclaimAgentDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimAgentDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimAgentDto.setCentreCode(dbManager.getString(resultSet,3));
            prpLclaimAgentDto.setCentreName(dbManager.getString(resultSet,4));
            prpLclaimAgentDto.setUnitCode(dbManager.getString(resultSet,5));
            prpLclaimAgentDto.setUnitName(dbManager.getString(resultSet,6));
            prpLclaimAgentDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLclaimAgentDto.setConveyance(dbManager.getString(resultSet,8));
            prpLclaimAgentDto.setStartSiteCode(dbManager.getString(resultSet,9));
            prpLclaimAgentDto.setStartSiteName(dbManager.getString(resultSet,10));
            prpLclaimAgentDto.setViaSiteCode(dbManager.getString(resultSet,11));
            prpLclaimAgentDto.setViaSiteName(dbManager.getString(resultSet,12));
            prpLclaimAgentDto.setEndSiteCode(dbManager.getString(resultSet,13));
            prpLclaimAgentDto.setEndSiteName(dbManager.getString(resultSet,14));
            prpLclaimAgentDto.setFlag(dbManager.getString(resultSet,15));
            collection.add(prpLclaimAgentDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimAgentBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimAgent Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimAgentBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimAgent Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimAgentBase.getCount() success!");
        return count;
    }
}
