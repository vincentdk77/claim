package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcompensate�������������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimFittings extends DBPrpLclaimFittingsBase{
    private static Log log = LogFactory.getLog(DBPrpLclaimFittings.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimFittings(DBManager dbManager){
        super(dbManager);
    }

    /**
     * ��������prplclaim��,prplregist���prplclaimstatus���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select * From prplclaimfittings where " + conditions + " order by SerialNo" ;

        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimFittingsDto prpLclaimFittingsDto = null;
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

	     prpLclaimFittingsDto = new PrpLclaimFittingsDto(); 		
            prpLclaimFittingsDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimFittingsDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLclaimFittingsDto.setModelCode(dbManager.getString(resultSet,3));
            prpLclaimFittingsDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLclaimFittingsDto.setResultType(dbManager.getString(resultSet,5));
            prpLclaimFittingsDto.setSerialNo(dbManager.getLong(resultSet,6));
            prpLclaimFittingsDto.setKindCode(dbManager.getString(resultSet,7));
            prpLclaimFittingsDto.setKindName(dbManager.getString(resultSet,8));
            prpLclaimFittingsDto.setFittingCode(dbManager.getString(resultSet,9));
            prpLclaimFittingsDto.setFittingName(dbManager.getString(resultSet,10));
            prpLclaimFittingsDto.setOriginalID(dbManager.getString(resultSet,11));
            prpLclaimFittingsDto.setIndId(dbManager.getInt(resultSet,12));
            prpLclaimFittingsDto.setSys4SPrice(dbManager.getDouble(resultSet,13));
            prpLclaimFittingsDto.setSysMarketPrice(dbManager.getDouble(resultSet,14));
            prpLclaimFittingsDto.setSysmatchPrice(dbManager.getDouble(resultSet,15));
            prpLclaimFittingsDto.setNative4SPrice(dbManager.getDouble(resultSet,16));
            prpLclaimFittingsDto.setNativeMarketPrice(dbManager.getDouble(resultSet,17));
            prpLclaimFittingsDto.setNativeMatchPrice(dbManager.getDouble(resultSet,18));
            prpLclaimFittingsDto.setMaxQuantity(dbManager.getLong(resultSet,19));
            prpLclaimFittingsDto.setCertaSaved(dbManager.getString(resultSet,20));
            prpLclaimFittingsDto.setCertaPrice(dbManager.getDouble(resultSet,21));
            prpLclaimFittingsDto.setCertaQuantity(dbManager.getLong(resultSet,22));
            prpLclaimFittingsDto.setVerifyPrice(dbManager.getDouble(resultSet,23));
            prpLclaimFittingsDto.setRemark(dbManager.getString(resultSet,24));
            prpLclaimFittingsDto.setFlag(dbManager.getString(resultSet,25));
            prpLclaimFittingsDto.setPartId(dbManager.getString(resultSet,26));
            prpLclaimFittingsDto.setOriginalName(dbManager.getString(resultSet,27));
            prpLclaimFittingsDto.setPartGroupCode(dbManager.getString(resultSet,28));
            prpLclaimFittingsDto.setPartGroupName(dbManager.getString(resultSet,29));
            prpLclaimFittingsDto.setSumPrice(dbManager.getDouble(resultSet,30));
            prpLclaimFittingsDto.setSelfConfigFlag(dbManager.getString(resultSet,31));
            prpLclaimFittingsDto.setRepairSitePrice(dbManager.getDouble(resultSet,32));
            prpLclaimFittingsDto.setChgCompSetCode(dbManager.getString(resultSet,33));
            prpLclaimFittingsDto.setChgCompSetName(dbManager.getString(resultSet,34));
            prpLclaimFittingsDto.setChgRefPrice(dbManager.getDouble(resultSet,35));
            prpLclaimFittingsDto.setChgLocPrice(dbManager.getDouble(resultSet,36));
            prpLclaimFittingsDto.setRemnant(dbManager.getDouble(resultSet,37));
            prpLclaimFittingsDto.setStatus(dbManager.getString(resultSet,38));
            collection.add(prpLclaimFittingsDto);
        }
        resultSet.close();
        log.info("DBPrpLclaimFittings.findByConditions() success!");
        return collection;
    }
    
    public void updateStatus(PrpLclaimFittingsDto prpLclaimFittingsDto)
    throws Exception{
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("UPDATE PrpLclaimFittings SET ");
		buffer.append("Status = ? ");
		
		buffer.append("WHERE ");
		buffer.append("RegistNo = ? And ");
		buffer.append("partId = ? And ");
		buffer.append("lossItemCode = ? ");
		
		dbManager.prepareStatement(buffer.toString());
		//���ø����ֶ�;
		dbManager.setString(1,prpLclaimFittingsDto.getStatus());
		dbManager.setString(2,prpLclaimFittingsDto.getRegistNo());
		dbManager.setString(3,prpLclaimFittingsDto.getPartId());
		dbManager.setString(4,prpLclaimFittingsDto.getLossItemCode());
		dbManager.executePreparedUpdate();
		
		}

}
 