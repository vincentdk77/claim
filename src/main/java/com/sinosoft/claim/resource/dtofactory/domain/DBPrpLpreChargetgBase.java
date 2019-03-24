package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpreChargetgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLpreChargetgBase {
	protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLpreChargetgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpreChargetgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public void insert(PrpLpreChargetgDto PrpLpreChargetgDto) throws Exception{
        String mainStatement = " Insert Into PrpLpreChargetg (" + 
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
                           "'" + PrpLpreChargetgDto.getPreCompensateNo() + "'," + 
                           "'" + PrpLpreChargetgDto.getSerialNo() + "'," + 
                           "'" + PrpLpreChargetgDto.getClaimNo() + "'," + 
                           "'" + PrpLpreChargetgDto.getRiskCode() + "'," + 
                           "" + PrpLpreChargetgDto.getPolicyNo() + "," + 
                           "'" + PrpLpreChargetgDto.getKindCode() + "'," + 
                           "'" + PrpLpreChargetgDto.getChargeCode() + "'," + 
                           "'" + PrpLpreChargetgDto.getChargeEName() + "'," + 
                           "'" + PrpLpreChargetgDto.getCurrenCY() + "'," + 
                           "'" + PrpLpreChargetgDto.getSumPrepaid() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,PrpLpreChargetgDto.getPreCompensateNo());
        dbManager.setInt(2,PrpLpreChargetgDto.getSerialNo());
        dbManager.setString(3,PrpLpreChargetgDto.getClaimNo());
        dbManager.setString(4,PrpLpreChargetgDto.getRiskCode());
        dbManager.setString(5,PrpLpreChargetgDto.getPolicyNo());
        dbManager.setString(6,PrpLpreChargetgDto.getKindCode());
        dbManager.setString(7,PrpLpreChargetgDto.getChargeCode());
        dbManager.setString(8,PrpLpreChargetgDto.getChargeEName());
        dbManager.setString(9,PrpLpreChargetgDto.getCurrenCY());
        dbManager.setDouble(10,PrpLpreChargetgDto.getSumPrepaid());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpreChargetgBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpreChargetgDto PrpLpreChargetgDto = (PrpLpreChargetgDto)i.next();
            insert(PrpLpreChargetgDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String preCompensateNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLpreChargetg" + 
	            		   " Where " +
                           " preCompensateNo = ? " +
                           " and SerialNo = ? ";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLpreChargetg Where " +
                           " preCompensateNo = '" + preCompensateNo + "' And " + 
                           " SerialNo = " + serialNo + "";;
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,preCompensateNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpreChargetgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public void update(PrpLpreChargetgDto PrpLpreChargetgDto) throws Exception{
        String statement = " Update PrpLpreChargetg Set " + 
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
            String debugStatement = "Update PrpLpreChargetg Set " + 
                           " claimNo = '" + PrpLpreChargetgDto.getClaimNo()+ "'," + 
                           " riskCode = '" + PrpLpreChargetgDto.getRiskCode() + "'," + 
                           " policyNo = " + PrpLpreChargetgDto.getPolicyNo() + "," + 
                           " kindCode = '" + PrpLpreChargetgDto.getKindCode() + "'," + 
                           " ChargeCode = '" + PrpLpreChargetgDto.getChargeCode() + "'," + 
                           " charEName = '" + PrpLpreChargetgDto.getChargeEName() + "'," + 
                           " currenCY = '" + PrpLpreChargetgDto.getCurrenCY() + "'," + 
                           " sumprepaid = '" + PrpLpreChargetgDto.getSumPrepaid() + "'," + 
			               " Where " +
                           " preCompensateNo = '" + PrpLpreChargetgDto.getPreCompensateNo() + "' and "+
                           " SerialNo = "+PrpLpreChargetgDto.getSerialNo()+"";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,PrpLpreChargetgDto.getClaimNo());
        dbManager.setString(2,PrpLpreChargetgDto.getRiskCode());
        dbManager.setString(3,PrpLpreChargetgDto.getPolicyNo());
        dbManager.setString(4,PrpLpreChargetgDto.getKindCode());
        dbManager.setString(5,PrpLpreChargetgDto.getChargeCode());
        dbManager.setString(6,PrpLpreChargetgDto.getChargeEName());
        dbManager.setString(7,PrpLpreChargetgDto.getCurrenCY());
        dbManager.setDouble(8,PrpLpreChargetgDto.getSumPrepaid());
        dbManager.setString(9,PrpLpreChargetgDto.getPreCompensateNo());
        dbManager.setInt(10,PrpLpreChargetgDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpreChargetgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @return PrpLpreChargetgDto
     * @throws Exception
     */
    public PrpLpreChargetgDto findByPrimaryKey(String preCompensateNo,int serialNo) throws Exception{
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
        " sumprepaid  From PrpLpreChargetg";
        String statement = mainStatement + " Where " +
                           " preCompensateNo = ? " +
                           " and serialNo = ? ";
        PrpLpreChargetgDto PrpLpreChargetgDto = null;
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
            PrpLpreChargetgDto = new PrpLpreChargetgDto();
            PrpLpreChargetgDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            PrpLpreChargetgDto.setSerialNo(dbManager.getInt(resultSet,2));
            PrpLpreChargetgDto.setClaimNo(dbManager.getString(resultSet,3));
            PrpLpreChargetgDto.setRiskCode(dbManager.getString(resultSet,4));
            PrpLpreChargetgDto.setPolicyNo(dbManager.getString(resultSet,5));
            PrpLpreChargetgDto.setKindCode(dbManager.getString(resultSet,6));
            PrpLpreChargetgDto.setChargeCode(dbManager.getString(resultSet,7));
            PrpLpreChargetgDto.setChargeEName(dbManager.getString(resultSet,8));
            PrpLpreChargetgDto.setCurrenCY(dbManager.getString(resultSet,9));
            PrpLpreChargetgDto.setSumPrepaid(dbManager.getDouble(resultSet,10));
        }
        resultSet.close();
        logger.info("DBPrpLpreChargetgBase.findByPrimaryKey() success!");
        return PrpLpreChargetgDto;
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
		        " sumprepaid  From PrpLpreChargetg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpreChargetgDto PrpLpreChargetgDto = null;
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

            PrpLpreChargetgDto prpLpreChargetgDto = new PrpLpreChargetgDto();
            prpLpreChargetgDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLpreChargetgDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLpreChargetgDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLpreChargetgDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLpreChargetgDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLpreChargetgDto.setKindCode(dbManager.getString(resultSet,6));
            prpLpreChargetgDto.setChargeCode(dbManager.getString(resultSet,7));
            prpLpreChargetgDto.setChargeEName(dbManager.getString(resultSet,8));
            prpLpreChargetgDto.setCurrenCY(dbManager.getString(resultSet,9));
            prpLpreChargetgDto.setSumPrepaid(dbManager.getDouble(resultSet,10));
            collection.add(prpLpreChargetgDto);
        }
        resultSet.close();
        logger.info("DBPrpLpreChargetgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpreChargetg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpreChargetgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLpreChargetg Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpreChargetgBase.getCount() success!");
        return count;
    }
}
