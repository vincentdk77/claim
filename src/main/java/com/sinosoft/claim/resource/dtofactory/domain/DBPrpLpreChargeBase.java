package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLpreChargeBase {
	protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLpreChargeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpreChargeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public void insert(PrpLpreChargeDto PrpLpreChargeDto) throws Exception{
        String mainStatement = " Insert Into PrpLpreCharge (" + 
							        " preCompensateNo, "+
							        " serialNo, "+
							        " claimNo, " +
							        " riskCode, "+
							        " policyNo, "+
							        " kindCode, "+
							        " chargeCode, "+
							        " chargename, "+
							        " currenCY, "+
							        " sumprepaid )";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + PrpLpreChargeDto.getPreCompensateNo() + "'," + 
                           "'" + PrpLpreChargeDto.getSerialNo() + "'," + 
                           "'" + PrpLpreChargeDto.getClaimNo() + "'," + 
                           "'" + PrpLpreChargeDto.getRiskCode() + "'," + 
                           "" + PrpLpreChargeDto.getPolicyNo() + "," + 
                           "'" + PrpLpreChargeDto.getKindCode() + "'," + 
                           "'" + PrpLpreChargeDto.getChargeCode() + "'," + 
                           "'" + PrpLpreChargeDto.getChargeEName() + "'," + 
                           "'" + PrpLpreChargeDto.getCurrenCY() + "'," + 
                           "'" + PrpLpreChargeDto.getSumPrepaid() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,PrpLpreChargeDto.getPreCompensateNo());
        dbManager.setInt(2,PrpLpreChargeDto.getSerialNo());
        dbManager.setString(3,PrpLpreChargeDto.getClaimNo());
        dbManager.setString(4,PrpLpreChargeDto.getRiskCode());
        dbManager.setString(5,PrpLpreChargeDto.getPolicyNo());
        dbManager.setString(6,PrpLpreChargeDto.getKindCode());
        dbManager.setString(7,PrpLpreChargeDto.getChargeCode());
        dbManager.setString(8,PrpLpreChargeDto.getChargeEName());
        dbManager.setString(9,PrpLpreChargeDto.getCurrenCY());
        dbManager.setDouble(10,PrpLpreChargeDto.getSumPrepaid());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpreChargeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpreChargeDto PrpLpreChargeDto = (PrpLpreChargeDto)i.next();
            insert(PrpLpreChargeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String preCompensateNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLpreCharge" + 
	            		   " Where " +
                           " preCompensateNo = ? " +
                           " and SerialNo = ? ";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLpreCharge Where " +
                           " preCompensateNo = '" + preCompensateNo + "' And " + 
                           " SerialNo = " + serialNo + "";;
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,preCompensateNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpreChargeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public void update(PrpLpreChargeDto PrpLpreChargeDto) throws Exception{
        String statement = " Update PrpLpreCharge Set " + 
						        " claimNo = ?, " +
						        " riskCode = ?, "+
						        " policyNo = ?, "+
						        " kindCode = ?, "+
						        " chargeCode = ?, "+
						        " chargename = ?, "+
						        " currenCY = ?, "+
						        " sumprepaid = ?"+
	            		   " Where " +
                           " preCompensateNo = ?  and "+
                           " SerialNo = ? ";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLpreCharge Set " + 
                           " claimNo = '" + PrpLpreChargeDto.getClaimNo()+ "'," + 
                           " riskCode = '" + PrpLpreChargeDto.getRiskCode() + "'," + 
                           " policyNo = " + PrpLpreChargeDto.getPolicyNo() + "," + 
                           " kindCode = '" + PrpLpreChargeDto.getKindCode() + "'," + 
                           " ChargeCode = '" + PrpLpreChargeDto.getChargeCode() + "'," + 
                           " charEName = '" + PrpLpreChargeDto.getChargeEName() + "'," + 
                           " currenCY = '" + PrpLpreChargeDto.getCurrenCY() + "'," + 
                           " sumprepaid = '" + PrpLpreChargeDto.getSumPrepaid() + "'," + 
			               " Where " +
                           " preCompensateNo = '" + PrpLpreChargeDto.getPreCompensateNo() + "' and "+
                           " SerialNo = "+PrpLpreChargeDto.getSerialNo()+"";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,PrpLpreChargeDto.getClaimNo());
        dbManager.setString(2,PrpLpreChargeDto.getRiskCode());
        dbManager.setString(3,PrpLpreChargeDto.getPolicyNo());
        dbManager.setString(4,PrpLpreChargeDto.getKindCode());
        dbManager.setString(5,PrpLpreChargeDto.getChargeCode());
        dbManager.setString(6,PrpLpreChargeDto.getChargeEName());
        dbManager.setString(7,PrpLpreChargeDto.getCurrenCY());
        dbManager.setDouble(8,PrpLpreChargeDto.getSumPrepaid());
        dbManager.setString(9,PrpLpreChargeDto.getPreCompensateNo());
        dbManager.setInt(10,PrpLpreChargeDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpreChargeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @return PrpLpreChargeDto
     * @throws Exception
     */
    public PrpLpreChargeDto findByPrimaryKey(String preCompensateNo,int serialNo) throws Exception{
        String mainStatement = " Select " + 
        " preCompensateNo, "+
        " serialNo, "+
        " claimNo, " +
        " riskCode, "+
        " policyNo, "+
        " kindCode, "+
        " chargeCode, "+
        " chargename, "+
        " currenCY, "+
        " sumprepaid  From PrpLpreCharge";
        String statement = mainStatement + " Where " +
                           " preCompensateNo = ? " +
                           " and serialNo = ? ";
        PrpLpreChargeDto PrpLpreChargeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " preCompensateNo = '" + preCompensateNo + "' "+
                           " and serialNo = "+serialNo+"";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,preCompensateNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            PrpLpreChargeDto = new PrpLpreChargeDto();
            PrpLpreChargeDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            PrpLpreChargeDto.setSerialNo(dbManager.getInt(resultSet,2));
            PrpLpreChargeDto.setClaimNo(dbManager.getString(resultSet,3));
            PrpLpreChargeDto.setRiskCode(dbManager.getString(resultSet,4));
            PrpLpreChargeDto.setPolicyNo(dbManager.getString(resultSet,5));
            PrpLpreChargeDto.setKindCode(dbManager.getString(resultSet,6));
            PrpLpreChargeDto.setChargeCode(dbManager.getString(resultSet,7));
            PrpLpreChargeDto.setChargeEName(dbManager.getString(resultSet,8));
            PrpLpreChargeDto.setCurrenCY(dbManager.getString(resultSet,9));
            PrpLpreChargeDto.setSumPrepaid(dbManager.getDouble(resultSet,10));
        }
        resultSet.close();
        logger.info("DBPrpLpreChargeBase.findByPrimaryKey() success!");
        return PrpLpreChargeDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select " + 
		        " preCompensateNo, "+
		        " serialNo, "+
		        " claimNo, " +
		        " riskCode, "+
		        " policyNo, "+
		        " kindCode, "+
		        " chargeCode, "+
		        " chargename, "+
		        " currenCY, "+
		        " sumprepaid  From PrpLpreCharge Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpreChargeDto PrpLpreChargeDto = null;
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

            PrpLpreChargeDto prpLpreChargeDto = new PrpLpreChargeDto();
            prpLpreChargeDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLpreChargeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLpreChargeDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLpreChargeDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLpreChargeDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLpreChargeDto.setKindCode(dbManager.getString(resultSet,6));
            prpLpreChargeDto.setChargeCode(dbManager.getString(resultSet,7));
            prpLpreChargeDto.setChargeEName(dbManager.getString(resultSet,8));
            prpLpreChargeDto.setCurrenCY(dbManager.getString(resultSet,9));
            prpLpreChargeDto.setSumPrepaid(dbManager.getDouble(resultSet,10));
            collection.add(prpLpreChargeDto);
        }
        resultSet.close();
        logger.info("DBPrpLpreChargeBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLpreCharge Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpreChargeBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpLpreCharge Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpreChargeBase.getCount() success!");
        return count;
    }
}
