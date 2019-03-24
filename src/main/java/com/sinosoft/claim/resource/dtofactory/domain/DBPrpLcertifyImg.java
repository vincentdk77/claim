package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyImg��֤��Ӱ�������ݷ��ʶ�����<br>
 * ������ 2004-11-08 09:50:06.786<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcertifyImg extends DBPrpLcertifyImgBase{
    private static Log logger = LogFactory.getLog(DBPrpLcertifyImg.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcertifyImg(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * ȡ��prplcertifyImg����serialNo���ֵ
     * @param String ��ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getMaxSerialNo(String conditions) 
        throws Exception {
        int maxSerialNo = 0;
        String statement = "Select Max(SerialNo) from PrpLcertifyImg Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
         
        if (resultSet.next()) {
            maxSerialNo = dbManager.getInt(resultSet,1);    
        }
        
        resultSet.close();
        logger.info("DBPrpLcertifyImgBase.getCount() success!");
        return maxSerialNo;
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsNew(String conditions) throws Exception{
        String statement = "select DISTINCT(typecode), picname from prplcertifyimg where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcertifyImgDto prpLcertifyImgDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){
            prpLcertifyImgDto = new PrpLcertifyImgDto();
            prpLcertifyImgDto.setTypeCode(dbManager.getString(resultSet,1));
            prpLcertifyImgDto.setPicName(dbManager.getString(resultSet,2));
            collection.add(prpLcertifyImgDto);
        }
        resultSet.close();
        logger.info("DBPrpLcertifyImgBase.findByConditions() success!");
        return collection;
    }
}
