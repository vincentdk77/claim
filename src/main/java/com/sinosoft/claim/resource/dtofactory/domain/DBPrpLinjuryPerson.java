package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciPerson的数据访问对象类<br>
 * 创建于 2005-06-16 11:01:01.468<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinjuryPerson extends DBPrpLinjuryPersonBase{
    private static Log logger = LogFactory.getLog(DBPrpLinjuryPerson.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinjuryPerson(DBManager dbManager){
        super(dbManager);
    }
    
    public int findBySeriaNo(String condition) throws Exception {
    	int seriaNo = 0;
    	ResultSet resultSet = dbManager.executeQuery("select max(SerialNo) SerialNo from PrpLinjuryperson where " + condition);
    	
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
    public PrpLinjuryPersonDto findByPrimaryKeyCertiNo(String CompensateNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append("FROM PrpLinjuryperson ");
       
        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? ");
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,CompensateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
        if(resultSet.next()){
            prpLinjuryPersonDto = new PrpLinjuryPersonDto();
            prpLinjuryPersonDto.setAcciName(dbManager.getString(resultSet,1));
            prpLinjuryPersonDto.setSex(dbManager.getString(resultSet,2));
            prpLinjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,3));
        }else{
            logger.info("DBPrpLinjuryPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLinjuryPersonDto;
    }
    public PrpLinjuryPersonDto findByCondition2(String CompensateNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append("FROM PrpLacciPerson ");
       
        buffer.append("WHERE ");
        buffer.append("CompensateNo = ?  ");
        buffer.append("and (Flag is null or Flag='')  ");
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,CompensateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
        if(resultSet.next()){
            prpLinjuryPersonDto = new PrpLinjuryPersonDto();
            prpLinjuryPersonDto.setAcciName(dbManager.getString(resultSet,1));
            prpLinjuryPersonDto.setSex(dbManager.getString(resultSet,2));
            prpLinjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,3));
        }else{
            logger.info("DBPrpLacciPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLinjuryPersonDto;
    }

    public void updateFlag(PrpLinjuryPersonDto prpLinjuryPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinjuryPerson SET ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("IdentifyNumber = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLinjuryPersonDto.getAcciName()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? ");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinjuryPersonDto.getAcciName());
        dbManager.setString(2,prpLinjuryPersonDto.getSex());
        dbManager.setString(3,prpLinjuryPersonDto.getIdentifyNumber());
        //设置条件字段;
        dbManager.executePreparedUpdate();

    }

    
    

}
