package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgenttgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimAgent-�����Ᵽ����Ϣ������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimAgenttgBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLclaimAgenttgBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimAgenttgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLclaimAgenttgDto prpLclaimAgenttgDto
     * @throws Exception
     */
    public void insert(PrpLclaimAgenttgDto prpLclaimAgenttgDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimAgenttg (" + 
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
                           "'" + prpLclaimAgenttgDto.getClaimNo() + "'," + 
                           "'" + prpLclaimAgenttgDto.getPolicyNo() + "'," + 
                           "'" + prpLclaimAgenttgDto.getCentreCode() + "'," + 
                           "'" + prpLclaimAgenttgDto.getCentreName() + "'," + 
                           "'" + prpLclaimAgenttgDto.getUnitCode() + "'," + 
                           "'" + prpLclaimAgenttgDto.getUnitName() + "'," + 
                           "'" + prpLclaimAgenttgDto.getOperateDate() + "'," + 
                           "'" + prpLclaimAgenttgDto.getConveyance() + "'," + 
                           "'" + prpLclaimAgenttgDto.getStartSiteCode() + "'," + 
                           "'" + prpLclaimAgenttgDto.getStartSiteName() + "'," + 
                           "'" + prpLclaimAgenttgDto.getViaSiteCode() + "'," + 
                           "'" + prpLclaimAgenttgDto.getViaSiteName() + "'," + 
                           "'" + prpLclaimAgenttgDto.getEndSiteCode() + "'," + 
                           "'" + prpLclaimAgenttgDto.getEndSiteName() + "'," + 
                           "'" + prpLclaimAgenttgDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimAgenttgDto.getClaimNo());
        dbManager.setString(2,prpLclaimAgenttgDto.getPolicyNo());
        dbManager.setString(3,prpLclaimAgenttgDto.getCentreCode());
        dbManager.setString(4,prpLclaimAgenttgDto.getCentreName());
        dbManager.setString(5,prpLclaimAgenttgDto.getUnitCode());
        dbManager.setString(6,prpLclaimAgenttgDto.getUnitName());
        dbManager.setDateTime(7,prpLclaimAgenttgDto.getOperateDate());
        dbManager.setString(8,prpLclaimAgenttgDto.getConveyance());
        dbManager.setString(9,prpLclaimAgenttgDto.getStartSiteCode());
        dbManager.setString(10,prpLclaimAgenttgDto.getStartSiteName());
        dbManager.setString(11,prpLclaimAgenttgDto.getViaSiteCode());
        dbManager.setString(12,prpLclaimAgenttgDto.getViaSiteName());
        dbManager.setString(13,prpLclaimAgenttgDto.getEndSiteCode());
        dbManager.setString(14,prpLclaimAgenttgDto.getEndSiteName());
        dbManager.setString(15,prpLclaimAgenttgDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimAgenttgBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimAgenttg (" + 
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
            PrpLclaimAgenttgDto prpLclaimAgenttgDto = (PrpLclaimAgenttgDto)i.next();
            dbManager.setString(1,prpLclaimAgenttgDto.getClaimNo());
            dbManager.setString(2,prpLclaimAgenttgDto.getPolicyNo());
            dbManager.setString(3,prpLclaimAgenttgDto.getCentreCode());
            dbManager.setString(4,prpLclaimAgenttgDto.getCentreName());
            dbManager.setString(5,prpLclaimAgenttgDto.getUnitCode());
            dbManager.setString(6,prpLclaimAgenttgDto.getUnitName());
            dbManager.setDateTime(7,prpLclaimAgenttgDto.getOperateDate());
            dbManager.setString(8,prpLclaimAgenttgDto.getConveyance());
            dbManager.setString(9,prpLclaimAgenttgDto.getStartSiteCode());
            dbManager.setString(10,prpLclaimAgenttgDto.getStartSiteName());
            dbManager.setString(11,prpLclaimAgenttgDto.getViaSiteCode());
            dbManager.setString(12,prpLclaimAgenttgDto.getViaSiteName());
            dbManager.setString(13,prpLclaimAgenttgDto.getEndSiteCode());
            dbManager.setString(14,prpLclaimAgenttgDto.getEndSiteName());
            dbManager.setString(15,prpLclaimAgenttgDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimAgenttgBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param claimNo �ⰸ��
     * @throws Exception
     */
    public void delete(String claimNo) throws Exception{
        String statement = " Delete From PrpLclaimAgenttg" + 
	            		   " Where " +
                           " ClaimNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimAgenttg Where " +
                           " ClaimNo = '" + claimNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimAgenttgBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLclaimAgenttgDto prpLclaimAgenttgDto
     * @throws Exception
     */
    public void update(PrpLclaimAgenttgDto prpLclaimAgenttgDto) throws Exception{
        String statement = " Update PrpLclaimAgenttg Set PolicyNo = ?," + 
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
            String debugStatement = "Update PrpLclaimAgenttg Set " + 
                           " ClaimNo = '" + prpLclaimAgenttgDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLclaimAgenttgDto.getPolicyNo() + "'," + 
                           " CentreCode = '" + prpLclaimAgenttgDto.getCentreCode() + "'," + 
                           " CentreName = '" + prpLclaimAgenttgDto.getCentreName() + "'," + 
                           " UnitCode = '" + prpLclaimAgenttgDto.getUnitCode() + "'," + 
                           " UnitName = '" + prpLclaimAgenttgDto.getUnitName() + "'," + 
                           " OperateDate = '" + prpLclaimAgenttgDto.getOperateDate() + "'," + 
                           " Conveyance = '" + prpLclaimAgenttgDto.getConveyance() + "'," + 
                           " StartSiteCode = '" + prpLclaimAgenttgDto.getStartSiteCode() + "'," + 
                           " StartSiteName = '" + prpLclaimAgenttgDto.getStartSiteName() + "'," + 
                           " ViaSiteCode = '" + prpLclaimAgenttgDto.getViaSiteCode() + "'," + 
                           " ViaSiteName = '" + prpLclaimAgenttgDto.getViaSiteName() + "'," + 
                           " EndSiteCode = '" + prpLclaimAgenttgDto.getEndSiteCode() + "'," + 
                           " EndSiteName = '" + prpLclaimAgenttgDto.getEndSiteName() + "'," + 
                           " Flag = '" + prpLclaimAgenttgDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLclaimAgenttgDto.getClaimNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLclaimAgenttgDto.getPolicyNo());
        dbManager.setString(2,prpLclaimAgenttgDto.getCentreCode());
        dbManager.setString(3,prpLclaimAgenttgDto.getCentreName());
        dbManager.setString(4,prpLclaimAgenttgDto.getUnitCode());
        dbManager.setString(5,prpLclaimAgenttgDto.getUnitName());
        dbManager.setDateTime(6,prpLclaimAgenttgDto.getOperateDate());
        dbManager.setString(7,prpLclaimAgenttgDto.getConveyance());
        dbManager.setString(8,prpLclaimAgenttgDto.getStartSiteCode());
        dbManager.setString(9,prpLclaimAgenttgDto.getStartSiteName());
        dbManager.setString(10,prpLclaimAgenttgDto.getViaSiteCode());
        dbManager.setString(11,prpLclaimAgenttgDto.getViaSiteName());
        dbManager.setString(12,prpLclaimAgenttgDto.getEndSiteCode());
        dbManager.setString(13,prpLclaimAgenttgDto.getEndSiteName());
        dbManager.setString(14,prpLclaimAgenttgDto.getFlag());
        //���������ֶ�;
        dbManager.setString(15,prpLclaimAgenttgDto.getClaimNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimAgenttgBase.update() success!");
    }

    /**
     * ����������һ������
     * @param claimNo �ⰸ��
     * @return PrpLclaimAgenttgDto
     * @throws Exception
     */
    public PrpLclaimAgenttgDto findByPrimaryKey(String claimNo) throws Exception{
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
                           " Flag From PrpLclaimAgenttg";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ?";
        PrpLclaimAgenttgDto prpLclaimAgenttgDto = null;
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
            prpLclaimAgenttgDto = new PrpLclaimAgenttgDto();
            prpLclaimAgenttgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimAgenttgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimAgenttgDto.setCentreCode(dbManager.getString(resultSet,3));
            prpLclaimAgenttgDto.setCentreName(dbManager.getString(resultSet,4));
            prpLclaimAgenttgDto.setUnitCode(dbManager.getString(resultSet,5));
            prpLclaimAgenttgDto.setUnitName(dbManager.getString(resultSet,6));
            prpLclaimAgenttgDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLclaimAgenttgDto.setConveyance(dbManager.getString(resultSet,8));
            prpLclaimAgenttgDto.setStartSiteCode(dbManager.getString(resultSet,9));
            prpLclaimAgenttgDto.setStartSiteName(dbManager.getString(resultSet,10));
            prpLclaimAgenttgDto.setViaSiteCode(dbManager.getString(resultSet,11));
            prpLclaimAgenttgDto.setViaSiteName(dbManager.getString(resultSet,12));
            prpLclaimAgenttgDto.setEndSiteCode(dbManager.getString(resultSet,13));
            prpLclaimAgenttgDto.setEndSiteName(dbManager.getString(resultSet,14));
            prpLclaimAgenttgDto.setFlag(dbManager.getString(resultSet,15));
            logger.info("DBPrpLclaimAgenttgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimAgenttgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimAgenttgDto;
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
                           " Flag From PrpLclaimAgenttg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimAgenttgDto prpLclaimAgenttgDto = null;
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

            prpLclaimAgenttgDto = new PrpLclaimAgenttgDto();
            prpLclaimAgenttgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimAgenttgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimAgenttgDto.setCentreCode(dbManager.getString(resultSet,3));
            prpLclaimAgenttgDto.setCentreName(dbManager.getString(resultSet,4));
            prpLclaimAgenttgDto.setUnitCode(dbManager.getString(resultSet,5));
            prpLclaimAgenttgDto.setUnitName(dbManager.getString(resultSet,6));
            prpLclaimAgenttgDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLclaimAgenttgDto.setConveyance(dbManager.getString(resultSet,8));
            prpLclaimAgenttgDto.setStartSiteCode(dbManager.getString(resultSet,9));
            prpLclaimAgenttgDto.setStartSiteName(dbManager.getString(resultSet,10));
            prpLclaimAgenttgDto.setViaSiteCode(dbManager.getString(resultSet,11));
            prpLclaimAgenttgDto.setViaSiteName(dbManager.getString(resultSet,12));
            prpLclaimAgenttgDto.setEndSiteCode(dbManager.getString(resultSet,13));
            prpLclaimAgenttgDto.setEndSiteName(dbManager.getString(resultSet,14));
            prpLclaimAgenttgDto.setFlag(dbManager.getString(resultSet,15));
            collection.add(prpLclaimAgenttgDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimAgenttgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimAgenttg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimAgenttgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimAgenttg Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimAgenttgBase.getCount() success!");
        return count;
    }
}
