package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCertify;

/**
 * ���ǵ�֤��Ϣ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCertifyAction extends BLPrpLinterCertifyActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCertifyAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCertifyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCertifyDto prpLinterCertifyDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCertifyDto[] prpLinterCertifyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCertifyDto[] prpLinterCertifyDto)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //�����¼
        for(int i=0;i<prpLinterCertifyDto.length;i++){
        	dbPrpLinterCertify.insert(prpLinterCertifyDto[i]);
        }
    }
}
