package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompePayFee;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ��������������Ϣ��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompePayFeeAction extends BLPrpLinterCompePayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompePayFeeAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompePayFeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompePayFeeDto prpLinterCompePayFeeDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompePayFeeDto[] prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //�����¼
        for(int i=0;i<prpLinterCompePayFeeDto.length;i++){
        	dbPrpLinterCompePayFee.insert(prpLinterCompePayFeeDto[i]);
        }
    }
}
