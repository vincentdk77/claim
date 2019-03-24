package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingstgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcompensate赔款计算书表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimFittingstg extends DBPrpLclaimFittingstgBase{
    private static Log log = LogFactory.getLog(DBPrpLclaimFittingstg.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimFittingstg(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplclaim表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select * From prplclaimfittingstg where " + conditions + " order by SerialNo" ;

        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimFittingstgDto prpLclaimFittingstgDto = null;
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

	     prpLclaimFittingstgDto = new PrpLclaimFittingstgDto(); 		
            prpLclaimFittingstgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimFittingstgDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLclaimFittingstgDto.setModelCode(dbManager.getString(resultSet,3));
            prpLclaimFittingstgDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLclaimFittingstgDto.setResultType(dbManager.getString(resultSet,5));
            prpLclaimFittingstgDto.setSerialNo(dbManager.getLong(resultSet,6));
            prpLclaimFittingstgDto.setKindCode(dbManager.getString(resultSet,7));
            prpLclaimFittingstgDto.setKindName(dbManager.getString(resultSet,8));
            prpLclaimFittingstgDto.setFittingCode(dbManager.getString(resultSet,9));
            prpLclaimFittingstgDto.setFittingName(dbManager.getString(resultSet,10));
            prpLclaimFittingstgDto.setOriginalID(dbManager.getString(resultSet,11));
            prpLclaimFittingstgDto.setIndId(dbManager.getInt(resultSet,12));
            prpLclaimFittingstgDto.setSys4SPrice(dbManager.getDouble(resultSet,13));
            prpLclaimFittingstgDto.setSysMarketPrice(dbManager.getDouble(resultSet,14));
            prpLclaimFittingstgDto.setSysmatchPrice(dbManager.getDouble(resultSet,15));
            prpLclaimFittingstgDto.setNative4SPrice(dbManager.getDouble(resultSet,16));
            prpLclaimFittingstgDto.setNativeMarketPrice(dbManager.getDouble(resultSet,17));
            prpLclaimFittingstgDto.setNativeMatchPrice(dbManager.getDouble(resultSet,18));
            prpLclaimFittingstgDto.setMaxQuantity(dbManager.getLong(resultSet,19));
            prpLclaimFittingstgDto.setCertaSaved(dbManager.getString(resultSet,20));
            prpLclaimFittingstgDto.setCertaPrice(dbManager.getDouble(resultSet,21));
            prpLclaimFittingstgDto.setCertaQuantity(dbManager.getLong(resultSet,22));
            prpLclaimFittingstgDto.setVerifyPrice(dbManager.getDouble(resultSet,23));
            prpLclaimFittingstgDto.setRemark(dbManager.getString(resultSet,24));
            prpLclaimFittingstgDto.setFlag(dbManager.getString(resultSet,25));
            prpLclaimFittingstgDto.setPartId(dbManager.getString(resultSet,26));
            prpLclaimFittingstgDto.setOriginalName(dbManager.getString(resultSet,27));
            prpLclaimFittingstgDto.setPartGroupCode(dbManager.getString(resultSet,28));
            prpLclaimFittingstgDto.setPartGroupName(dbManager.getString(resultSet,29));
            prpLclaimFittingstgDto.setSumPrice(dbManager.getDouble(resultSet,30));
            prpLclaimFittingstgDto.setSelfConfigFlag(dbManager.getString(resultSet,31));
            prpLclaimFittingstgDto.setRepairSitePrice(dbManager.getDouble(resultSet,32));
            prpLclaimFittingstgDto.setChgCompSetCode(dbManager.getString(resultSet,33));
            prpLclaimFittingstgDto.setChgCompSetName(dbManager.getString(resultSet,34));
            prpLclaimFittingstgDto.setChgRefPrice(dbManager.getDouble(resultSet,35));
            prpLclaimFittingstgDto.setChgLocPrice(dbManager.getDouble(resultSet,36));
            prpLclaimFittingstgDto.setRemnant(dbManager.getDouble(resultSet,37));
            prpLclaimFittingstgDto.setStatus(dbManager.getString(resultSet,38));
            collection.add(prpLclaimFittingstgDto);
        }
        resultSet.close();
        log.info("DBPrpLclaimFittingstg.findByConditions() success!");
        return collection;
    }
    
    public void updateStatus(PrpLclaimFittingstgDto prpLclaimFittingstgDto)
    throws Exception{
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("UPDATE PrpLclaimFittingstg SET ");
		buffer.append("Status = ? ");
		
		buffer.append("WHERE ");
		buffer.append("RegistNo = ? And ");
		buffer.append("partId = ? And ");
		buffer.append("lossItemCode = ? ");
		
		dbManager.prepareStatement(buffer.toString());
		//设置更新字段;
		dbManager.setString(1,prpLclaimFittingstgDto.getStatus());
		dbManager.setString(2,prpLclaimFittingstgDto.getRegistNo());
		dbManager.setString(3,prpLclaimFittingstgDto.getPartId());
		dbManager.setString(4,prpLclaimFittingstgDto.getLossItemCode());
		dbManager.executePreparedUpdate();
		
		}

}
 