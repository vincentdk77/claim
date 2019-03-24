package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeFee;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ������Ϣ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompeFeeAction extends BLPrpLinterCompeFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeFeeAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeFeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompeFeeDto prpLinterCompeFeeDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompeFeeDto[] prpLinterCompeFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeFeeDto[] prpLinterCompeFeeDto)
            throws Exception{
        DBPrpLinterCompeFee dbPrpLinterCompeFee = new DBPrpLinterCompeFee(dbManager);
        //�����¼
        for(int i=0;i<prpLinterCompeFeeDto.length;i++){
        	dbPrpLinterCompeFee.insert(prpLinterCompeFeeDto[i]);
        }
    }
}
