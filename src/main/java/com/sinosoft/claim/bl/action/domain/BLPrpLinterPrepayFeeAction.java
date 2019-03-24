package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPrepayFee;

/**
 * ����Ԥ�������Ϣ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPrepayFeeAction extends BLPrpLinterPrepayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPrepayFeeAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPrepayFeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPrepayFeeDto prpLinterPrepayFeeDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPrepayFeeDto[] prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //�����¼
        for(int i=0;i<prpLinterPrepayFeeDto.length;i++){
        	dbPrpLinterPrepayFee.insert(prpLinterPrepayFeeDto[i]);
        }
    }
}
