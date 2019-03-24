package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisit--回访信息主表的数据访问对象基类<br>
 * 创建于 2005-03-25 20:44:44.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisitBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLbackVisitBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLbackVisitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        String mainStatement = " Insert Into PrpLbackVisit (" + 
                           " BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " CustomType," + 
                           " Phone," + 
                           " Fax," + 
                           " PostCode," + 
                           " Email," + 
                           " LinkerName," + 
                           " Address," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDept," + 
                           " BackVisitTime," + 
                           " CustomOpinion," + 
                           " DeliverDepart," + 
                           " DeliverTime," + 
                           " DeliverPerson," + 
                           " DeliverBackTime," + 
                           " BackCustomTime," + 
                           " HurryFlag," + 
                           " Status," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLbackVisitDto.getBackVisitID() + "," + 
                           "'" + prpLbackVisitDto.getRegistNo() + "'," + 
                           "'" + prpLbackVisitDto.getBackVisitType() + "'," + 
                           "'" + prpLbackVisitDto.getPolicyNo() + "'," + 
                           "'" + prpLbackVisitDto.getLicenseNo() + "'," + 
                           "'" + prpLbackVisitDto.getInsuredCode() + "'," + 
                           "'" + prpLbackVisitDto.getInsuredName() + "'," + 
                           "'" + prpLbackVisitDto.getCustomType() + "'," + 
                           "'" + prpLbackVisitDto.getPhone() + "'," + 
                           "'" + prpLbackVisitDto.getFax() + "'," + 
                           "'" + prpLbackVisitDto.getPostCode() + "'," + 
                           "'" + prpLbackVisitDto.getEmail() + "'," + 
                           "'" + prpLbackVisitDto.getLinkerName() + "'," + 
                           "'" + prpLbackVisitDto.getAddress() + "'," + 
                           "'" + prpLbackVisitDto.getHandlerCode() + "'," + 
                           "'" + prpLbackVisitDto.getHandlerName() + "'," + 
                           "'" + prpLbackVisitDto.getHandleDept() + "'," + 
                           "'" + prpLbackVisitDto.getBackVisitTime() + "'," + 
                           "'" + prpLbackVisitDto.getCustomOpinion() + "'," + 
                           "'" + prpLbackVisitDto.getDeliverDepart() + "'," + 
                           "'" + prpLbackVisitDto.getDeliverTime() + "'," + 
                           "'" + prpLbackVisitDto.getDeliverPerson() + "'," + 
                           "'" + prpLbackVisitDto.getDeliverBackTime() + "'," + 
                           "'" + prpLbackVisitDto.getBackCustomTime() + "'," + 
                           "'" + prpLbackVisitDto.getHurryFlag() + "'," + 
                           "'" + prpLbackVisitDto.getStatus() + "'," + 
                           "'" + prpLbackVisitDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLbackVisitDto.getBackVisitID());
        dbManager.setString(2,prpLbackVisitDto.getRegistNo());
        dbManager.setString(3,prpLbackVisitDto.getBackVisitType());
        dbManager.setString(4,prpLbackVisitDto.getPolicyNo());
        dbManager.setString(5,prpLbackVisitDto.getLicenseNo());
        dbManager.setString(6,prpLbackVisitDto.getInsuredCode());
        dbManager.setString(7,prpLbackVisitDto.getInsuredName());
        dbManager.setString(8,prpLbackVisitDto.getCustomType());
        dbManager.setString(9,prpLbackVisitDto.getPhone());
        dbManager.setString(10,prpLbackVisitDto.getFax());
        dbManager.setString(11,prpLbackVisitDto.getPostCode());
        dbManager.setString(12,prpLbackVisitDto.getEmail());
        dbManager.setString(13,prpLbackVisitDto.getLinkerName());
        dbManager.setString(14,prpLbackVisitDto.getAddress());
        dbManager.setString(15,prpLbackVisitDto.getHandlerCode());
        dbManager.setString(16,prpLbackVisitDto.getHandlerName());
        dbManager.setString(17,prpLbackVisitDto.getHandleDept());
        dbManager.setString(18,prpLbackVisitDto.getBackVisitTime());
        dbManager.setString(19,prpLbackVisitDto.getCustomOpinion());
        dbManager.setString(20,prpLbackVisitDto.getDeliverDepart());
        dbManager.setString(21,prpLbackVisitDto.getDeliverTime());
        dbManager.setString(22,prpLbackVisitDto.getDeliverPerson());
        dbManager.setString(23,prpLbackVisitDto.getDeliverBackTime());
        dbManager.setString(24,prpLbackVisitDto.getBackCustomTime());
        dbManager.setString(25,prpLbackVisitDto.getHurryFlag());
        dbManager.setString(26,prpLbackVisitDto.getStatus());
        dbManager.setString(27,prpLbackVisitDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLbackVisitBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLbackVisit (" + 
                           " BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " CustomType," + 
                           " Phone," + 
                           " Fax," + 
                           " PostCode," + 
                           " Email," + 
                           " LinkerName," + 
                           " Address," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDept," + 
                           " BackVisitTime," + 
                           " CustomOpinion," + 
                           " DeliverDepart," + 
                           " DeliverTime," + 
                           " DeliverPerson," + 
                           " DeliverBackTime," + 
                           " BackCustomTime," + 
                           " HurryFlag," + 
                           " Status," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLbackVisitDto prpLbackVisitDto = (PrpLbackVisitDto)i.next();
            dbManager.setInt(1,prpLbackVisitDto.getBackVisitID());
            dbManager.setString(2,prpLbackVisitDto.getRegistNo());
            dbManager.setString(3,prpLbackVisitDto.getBackVisitType());
            dbManager.setString(4,prpLbackVisitDto.getPolicyNo());
            dbManager.setString(5,prpLbackVisitDto.getLicenseNo());
            dbManager.setString(6,prpLbackVisitDto.getInsuredCode());
            dbManager.setString(7,prpLbackVisitDto.getInsuredName());
            dbManager.setString(8,prpLbackVisitDto.getCustomType());
            dbManager.setString(9,prpLbackVisitDto.getPhone());
            dbManager.setString(10,prpLbackVisitDto.getFax());
            dbManager.setString(11,prpLbackVisitDto.getPostCode());
            dbManager.setString(12,prpLbackVisitDto.getEmail());
            dbManager.setString(13,prpLbackVisitDto.getLinkerName());
            dbManager.setString(14,prpLbackVisitDto.getAddress());
            dbManager.setString(15,prpLbackVisitDto.getHandlerCode());
            dbManager.setString(16,prpLbackVisitDto.getHandlerName());
            dbManager.setString(17,prpLbackVisitDto.getHandleDept());
            dbManager.setString(18,prpLbackVisitDto.getBackVisitTime());
            dbManager.setString(19,prpLbackVisitDto.getCustomOpinion());
            dbManager.setString(20,prpLbackVisitDto.getDeliverDepart());
            dbManager.setString(21,prpLbackVisitDto.getDeliverTime());
            dbManager.setString(22,prpLbackVisitDto.getDeliverPerson());
            dbManager.setString(23,prpLbackVisitDto.getDeliverBackTime());
            dbManager.setString(24,prpLbackVisitDto.getBackCustomTime());
            dbManager.setString(25,prpLbackVisitDto.getHurryFlag());
            dbManager.setString(26,prpLbackVisitDto.getStatus());
            dbManager.setString(27,prpLbackVisitDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLbackVisitBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType) throws Exception{
        String statement = " Delete From PrpLbackVisit" + 
	            		   " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLbackVisit Where " +
                           " BackVisitID = " + backVisitID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " BackVisitType = '" + backVisitType + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,backVisitID);
        dbManager.setString(2,registNo);
        dbManager.setString(3,backVisitType);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLbackVisitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void update(PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        String statement = " Update PrpLbackVisit Set PolicyNo = ?," + 
                           " LicenseNo = ?," + 
                           " InsuredCode = ?," + 
                           " InsuredName = ?," + 
                           " CustomType = ?," + 
                           " Phone = ?," + 
                           " Fax = ?," + 
                           " PostCode = ?," + 
                           " Email = ?," + 
                           " LinkerName = ?," + 
                           " Address = ?," + 
                           " HandlerCode = ?," + 
                           " HandlerName = ?," + 
                           " HandleDept = ?," + 
                           " BackVisitTime = ?," + 
                           " CustomOpinion = ?," + 
                           " DeliverDepart = ?," + 
                           " DeliverTime = ?," + 
                           " DeliverPerson = ?," + 
                           " DeliverBackTime = ?," + 
                           " BackCustomTime = ?," + 
                           " HurryFlag = ?," + 
                           " Status = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLbackVisit Set " + 
                           " BackVisitID = " + prpLbackVisitDto.getBackVisitID() + "," + 
                           " RegistNo = '" + prpLbackVisitDto.getRegistNo() + "'," + 
                           " BackVisitType = '" + prpLbackVisitDto.getBackVisitType() + "'," + 
                           " PolicyNo = '" + prpLbackVisitDto.getPolicyNo() + "'," + 
                           " LicenseNo = '" + prpLbackVisitDto.getLicenseNo() + "'," + 
                           " InsuredCode = '" + prpLbackVisitDto.getInsuredCode() + "'," + 
                           " InsuredName = '" + prpLbackVisitDto.getInsuredName() + "'," + 
                           " CustomType = '" + prpLbackVisitDto.getCustomType() + "'," + 
                           " Phone = '" + prpLbackVisitDto.getPhone() + "'," + 
                           " Fax = '" + prpLbackVisitDto.getFax() + "'," + 
                           " PostCode = '" + prpLbackVisitDto.getPostCode() + "'," + 
                           " Email = '" + prpLbackVisitDto.getEmail() + "'," + 
                           " LinkerName = '" + prpLbackVisitDto.getLinkerName() + "'," + 
                           " Address = '" + prpLbackVisitDto.getAddress() + "'," + 
                           " HandlerCode = '" + prpLbackVisitDto.getHandlerCode() + "'," + 
                           " HandlerName = '" + prpLbackVisitDto.getHandlerName() + "'," + 
                           " HandleDept = '" + prpLbackVisitDto.getHandleDept() + "'," + 
                           " BackVisitTime = '" + prpLbackVisitDto.getBackVisitTime() + "'," + 
                           " CustomOpinion = '" + prpLbackVisitDto.getCustomOpinion() + "'," + 
                           " DeliverDepart = '" + prpLbackVisitDto.getDeliverDepart() + "'," + 
                           " DeliverTime = '" + prpLbackVisitDto.getDeliverTime() + "'," + 
                           " DeliverPerson = '" + prpLbackVisitDto.getDeliverPerson() + "'," + 
                           " DeliverBackTime = '" + prpLbackVisitDto.getDeliverBackTime() + "'," + 
                           " BackCustomTime = '" + prpLbackVisitDto.getBackCustomTime() + "'," + 
                           " HurryFlag = '" + prpLbackVisitDto.getHurryFlag() + "'," + 
                           " Status = '" + prpLbackVisitDto.getStatus() + "'," + 
                           " Flag = '" + prpLbackVisitDto.getFlag() + "'" + 
			               " Where " +
                           " BackVisitID = " + prpLbackVisitDto.getBackVisitID() + " And " + 
                           " RegistNo = '" + prpLbackVisitDto.getRegistNo() + "' And " + 
                           " BackVisitType = '" + prpLbackVisitDto.getBackVisitType() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLbackVisitDto.getPolicyNo());
        dbManager.setString(2,prpLbackVisitDto.getLicenseNo());
        dbManager.setString(3,prpLbackVisitDto.getInsuredCode());
        dbManager.setString(4,prpLbackVisitDto.getInsuredName());
        dbManager.setString(5,prpLbackVisitDto.getCustomType());
        dbManager.setString(6,prpLbackVisitDto.getPhone());
        dbManager.setString(7,prpLbackVisitDto.getFax());
        dbManager.setString(8,prpLbackVisitDto.getPostCode());
        dbManager.setString(9,prpLbackVisitDto.getEmail());
        dbManager.setString(10,prpLbackVisitDto.getLinkerName());
        dbManager.setString(11,prpLbackVisitDto.getAddress());
        dbManager.setString(12,prpLbackVisitDto.getHandlerCode());
        dbManager.setString(13,prpLbackVisitDto.getHandlerName());
        dbManager.setString(14,prpLbackVisitDto.getHandleDept());
        dbManager.setString(15,prpLbackVisitDto.getBackVisitTime());
        dbManager.setString(16,prpLbackVisitDto.getCustomOpinion());
        dbManager.setString(17,prpLbackVisitDto.getDeliverDepart());
        dbManager.setString(18,prpLbackVisitDto.getDeliverTime());
        dbManager.setString(19,prpLbackVisitDto.getDeliverPerson());
        dbManager.setString(20,prpLbackVisitDto.getDeliverBackTime());
        dbManager.setString(21,prpLbackVisitDto.getBackCustomTime());
        dbManager.setString(22,prpLbackVisitDto.getHurryFlag());
        dbManager.setString(23,prpLbackVisitDto.getStatus());
        dbManager.setString(24,prpLbackVisitDto.getFlag());
        //设置条件字段;
        dbManager.setInt(25,prpLbackVisitDto.getBackVisitID());
        dbManager.setString(26,prpLbackVisitDto.getRegistNo());
        dbManager.setString(27,prpLbackVisitDto.getBackVisitType());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLbackVisitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @return PrpLbackVisitDto
     * @throws Exception
     */
    public PrpLbackVisitDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType) throws Exception{
        String mainStatement = " Select BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " CustomType," + 
                           " Phone," + 
                           " Fax," + 
                           " PostCode," + 
                           " Email," + 
                           " LinkerName," + 
                           " Address," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDept," + 
                           " BackVisitTime," + 
                           " CustomOpinion," + 
                           " DeliverDepart," + 
                           " DeliverTime," + 
                           " DeliverPerson," + 
                           " DeliverBackTime," + 
                           " BackCustomTime," + 
                           " HurryFlag," + 
                           " Status," + 
                           " Flag From PrpLbackVisit";
        String statement = mainStatement + " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ?";
        PrpLbackVisitDto prpLbackVisitDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BackVisitID = " + backVisitID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " BackVisitType = '" + backVisitType + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,backVisitID);
        dbManager.setString(2,registNo);
        dbManager.setString(3,backVisitType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLbackVisitDto = new PrpLbackVisitDto();
            prpLbackVisitDto.setBackVisitID(dbManager.getInt(resultSet,1));
            prpLbackVisitDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLbackVisitDto.setBackVisitType(dbManager.getString(resultSet,3));
            prpLbackVisitDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLbackVisitDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLbackVisitDto.setInsuredCode(dbManager.getString(resultSet,6));
            prpLbackVisitDto.setInsuredName(dbManager.getString(resultSet,7));
            prpLbackVisitDto.setCustomType(dbManager.getString(resultSet,8));
            prpLbackVisitDto.setPhone(dbManager.getString(resultSet,9));
            prpLbackVisitDto.setFax(dbManager.getString(resultSet,10));
            prpLbackVisitDto.setPostCode(dbManager.getString(resultSet,11));
            prpLbackVisitDto.setEmail(dbManager.getString(resultSet,12));
            prpLbackVisitDto.setLinkerName(dbManager.getString(resultSet,13));
            prpLbackVisitDto.setAddress(dbManager.getString(resultSet,14));
            prpLbackVisitDto.setHandlerCode(dbManager.getString(resultSet,15));
            prpLbackVisitDto.setHandlerName(dbManager.getString(resultSet,16));
            prpLbackVisitDto.setHandleDept(dbManager.getString(resultSet,17));
            prpLbackVisitDto.setBackVisitTime(dbManager.getString(resultSet,18));
            prpLbackVisitDto.setCustomOpinion(dbManager.getString(resultSet,19));
            prpLbackVisitDto.setDeliverDepart(dbManager.getString(resultSet,20));
            prpLbackVisitDto.setDeliverTime(dbManager.getString(resultSet,21));
            prpLbackVisitDto.setDeliverPerson(dbManager.getString(resultSet,22));
            prpLbackVisitDto.setDeliverBackTime(dbManager.getString(resultSet,23));
            prpLbackVisitDto.setBackCustomTime(dbManager.getString(resultSet,24));
            prpLbackVisitDto.setHurryFlag(dbManager.getString(resultSet,25));
            prpLbackVisitDto.setStatus(dbManager.getString(resultSet,26));
            prpLbackVisitDto.setFlag(dbManager.getString(resultSet,27));
            logger.info("DBPrpLbackVisitBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLbackVisitBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLbackVisitDto;
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
        String statement = "Select BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " CustomType," + 
                           " Phone," + 
                           " Fax," + 
                           " PostCode," + 
                           " Email," + 
                           " LinkerName," + 
                           " Address," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDept," + 
                           " BackVisitTime," + 
                           " CustomOpinion," + 
                           " DeliverDepart," + 
                           " DeliverTime," + 
                           " DeliverPerson," + 
                           " DeliverBackTime," + 
                           " BackCustomTime," + 
                           " HurryFlag," + 
                           " Status," + 
                           " Flag From PrpLbackVisit Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLbackVisitDto prpLbackVisitDto = null;
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

            prpLbackVisitDto = new PrpLbackVisitDto();
            prpLbackVisitDto.setBackVisitID(dbManager.getInt(resultSet,1));
            prpLbackVisitDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLbackVisitDto.setBackVisitType(dbManager.getString(resultSet,3));
            prpLbackVisitDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLbackVisitDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLbackVisitDto.setInsuredCode(dbManager.getString(resultSet,6));
            prpLbackVisitDto.setInsuredName(dbManager.getString(resultSet,7));
            prpLbackVisitDto.setCustomType(dbManager.getString(resultSet,8));
            prpLbackVisitDto.setPhone(dbManager.getString(resultSet,9));
            prpLbackVisitDto.setFax(dbManager.getString(resultSet,10));
            prpLbackVisitDto.setPostCode(dbManager.getString(resultSet,11));
            prpLbackVisitDto.setEmail(dbManager.getString(resultSet,12));
            prpLbackVisitDto.setLinkerName(dbManager.getString(resultSet,13));
            prpLbackVisitDto.setAddress(dbManager.getString(resultSet,14));
            prpLbackVisitDto.setHandlerCode(dbManager.getString(resultSet,15));
            prpLbackVisitDto.setHandlerName(dbManager.getString(resultSet,16));
            prpLbackVisitDto.setHandleDept(dbManager.getString(resultSet,17));
            prpLbackVisitDto.setBackVisitTime(dbManager.getString(resultSet,18));
            prpLbackVisitDto.setCustomOpinion(dbManager.getString(resultSet,19));
            prpLbackVisitDto.setDeliverDepart(dbManager.getString(resultSet,20));
            prpLbackVisitDto.setDeliverTime(dbManager.getString(resultSet,21));
            prpLbackVisitDto.setDeliverPerson(dbManager.getString(resultSet,22));
            prpLbackVisitDto.setDeliverBackTime(dbManager.getString(resultSet,23));
            prpLbackVisitDto.setBackCustomTime(dbManager.getString(resultSet,24));
            prpLbackVisitDto.setHurryFlag(dbManager.getString(resultSet,25));
            prpLbackVisitDto.setStatus(dbManager.getString(resultSet,26));
            prpLbackVisitDto.setFlag(dbManager.getString(resultSet,27));
            collection.add(prpLbackVisitDto);
        }
        resultSet.close();
        logger.info("DBPrpLbackVisitBase.findByConditions() success!");
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
        String statement = "Delete From PrpLbackVisit Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLbackVisitBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLbackVisit Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLbackVisitBase.getCount() success!");
        return count;
    }
}
