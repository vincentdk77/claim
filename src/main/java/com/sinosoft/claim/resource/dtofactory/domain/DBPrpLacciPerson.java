package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciPerson的数据访问对象类<br>
 * 创建于 2005-06-16 11:01:01.468<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciPerson extends DBPrpLacciPersonBase{
    private static Log logger = LogFactory.getLog(DBPrpLacciPerson.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLacciPerson(DBManager dbManager){
        super(dbManager);
    }
    
    public int findBySeriaNo(String condition) throws Exception {
    	int seriaNo = 0;
    	ResultSet resultSet = dbManager.executeQuery("select max(SerialNo) SerialNo from PrpLacciPerson where " + condition);
    	
    	if (resultSet.next()) {
    		seriaNo=resultSet.getInt("SerialNo");
    	}
    	resultSet.close();
    	return seriaNo;
    }
    
    /**
     * 按业务号查找一条数据
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @return PrpLacciPersonDto
     * @throws Exception
     */
    public PrpLacciPersonDto findByPrimaryKeyCertiNo(String certiNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("FamilyNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("RelationCode, ");
        buffer.append("RelationName  ");
        buffer.append("FROM PrpLacciPerson ");
       
        buffer.append("WHERE ");
        buffer.append("CertiNo = ?  ");
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLacciPersonDto prpLacciPersonDto = null;
        if(resultSet.next()){
            prpLacciPersonDto = new PrpLacciPersonDto();
            prpLacciPersonDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLacciPersonDto.setCertiType(dbManager.getString(resultSet,2));
            prpLacciPersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLacciPersonDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLacciPersonDto.setFamilyNo(dbManager.getInt(resultSet,5));
            prpLacciPersonDto.setAcciCode(dbManager.getString(resultSet,6));
            prpLacciPersonDto.setAcciName(dbManager.getString(resultSet,7));
            prpLacciPersonDto.setSex(dbManager.getString(resultSet,8));
            prpLacciPersonDto.setAge(dbManager.getInt(resultSet,9));
            prpLacciPersonDto.setIdentifyType(dbManager.getString(resultSet,10));
            prpLacciPersonDto.setIdentifyNumber(dbManager.getString(resultSet,11));
            prpLacciPersonDto.setRemark(dbManager.getString(resultSet,12));
            prpLacciPersonDto.setFlag(dbManager.getString(resultSet,13));
            prpLacciPersonDto.setPhone(dbManager.getString(resultSet,14));
            prpLacciPersonDto.setAddress(dbManager.getString(resultSet,15));
            prpLacciPersonDto.setRelationCode(dbManager.getString(resultSet,16));
            prpLacciPersonDto.setRelationName(dbManager.getString(resultSet,17));
        }else{
            logger.info("DBPrpLacciPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLacciPersonDto;
    }
    public PrpLacciPersonDto findByCondition2(String certiNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("FamilyNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("RelationCode, ");
        buffer.append("RelationName  ");
        buffer.append("FROM PrpLacciPerson ");
       
        buffer.append("WHERE ");
        buffer.append("CertiNo = ?  ");
        buffer.append("and (Flag is null or Flag='')  ");
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLacciPersonDto prpLacciPersonDto = null;
        if(resultSet.next()){
            prpLacciPersonDto = new PrpLacciPersonDto();
            prpLacciPersonDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLacciPersonDto.setCertiType(dbManager.getString(resultSet,2));
            prpLacciPersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLacciPersonDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLacciPersonDto.setFamilyNo(dbManager.getInt(resultSet,5));
            prpLacciPersonDto.setAcciCode(dbManager.getString(resultSet,6));
            prpLacciPersonDto.setAcciName(dbManager.getString(resultSet,7));
            prpLacciPersonDto.setSex(dbManager.getString(resultSet,8));
            prpLacciPersonDto.setAge(dbManager.getInt(resultSet,9));
            prpLacciPersonDto.setIdentifyType(dbManager.getString(resultSet,10));
            prpLacciPersonDto.setIdentifyNumber(dbManager.getString(resultSet,11));
            prpLacciPersonDto.setRemark(dbManager.getString(resultSet,12));
            prpLacciPersonDto.setFlag(dbManager.getString(resultSet,13));
            prpLacciPersonDto.setPhone(dbManager.getString(resultSet,14));
            prpLacciPersonDto.setAddress(dbManager.getString(resultSet,15));
            prpLacciPersonDto.setRelationCode(dbManager.getString(resultSet,16));
            prpLacciPersonDto.setRelationName(dbManager.getString(resultSet,17));
        }else{
            logger.info("DBPrpLacciPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLacciPersonDto;
    }

    public void updateFlag(PrpLacciPersonDto prpLacciPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLacciPerson SET ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("FamilyNo = ?, ");
        buffer.append("AcciCode = ?, ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("Age = ?, ");
        buffer.append("IdentifyType = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("RelationCode = ?, ");
        buffer.append("RelationName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(prpLacciPersonDto.getCertiNo()).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(prpLacciPersonDto.getCertiType()).append("' AND ");
            debugBuffer.append("Flag=").append("'").append(prpLacciPersonDto.getFlag()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLacciPersonDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ? And ");
        buffer.append("Flag = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLacciPersonDto.getPolicyNo());
        dbManager.setInt(2,prpLacciPersonDto.getFamilyNo());
        dbManager.setString(3,prpLacciPersonDto.getAcciCode());
        dbManager.setString(4,prpLacciPersonDto.getAcciName());
        dbManager.setString(5,prpLacciPersonDto.getSex());
        dbManager.setInt(6,prpLacciPersonDto.getAge());
        dbManager.setString(7,prpLacciPersonDto.getIdentifyType());
        dbManager.setString(8,prpLacciPersonDto.getIdentifyNumber());
        dbManager.setString(9,prpLacciPersonDto.getRemark());
        dbManager.setString(10,prpLacciPersonDto.getPhone());
        dbManager.setString(11,prpLacciPersonDto.getAddress());
        dbManager.setString(12,prpLacciPersonDto.getRelationCode());
        dbManager.setString(13,prpLacciPersonDto.getRelationName());
        //设置条件字段;
        dbManager.setString(14,prpLacciPersonDto.getCertiNo());
        dbManager.setString(15,prpLacciPersonDto.getCertiType());
        dbManager.setString(16,prpLacciPersonDto.getFlag());
        dbManager.setInt(17,prpLacciPersonDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    
    

}
