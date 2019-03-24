package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPaymentInfo;

/**
 * ���Ǵ�������ӱ�-----�⸶��Ϣ��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPaymentInfoAction extends BLPrpLinterPaymentInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPaymentInfoAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPaymentInfoAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPaymentInfoDto prpLinterPaymentInfoDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPaymentInfoDto[] prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDto)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //�����¼
        for(int i=0;i<prpLinterPaymentInfoDto.length;i++){
        	dbPrpLinterPaymentInfo.insert(prpLinterPaymentInfoDto[i]);
        }
    }
}
