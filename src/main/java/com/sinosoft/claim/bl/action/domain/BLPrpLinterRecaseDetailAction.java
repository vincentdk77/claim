package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseDetail;

/**
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ����״̬���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterRecaseDetailAction extends BLPrpLinterRecaseDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRecaseDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterRecaseDetailDto prpLinterRecaseDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterRecaseDetailDto prpLinterRecaseDetailDto,String mode)
            throws Exception{
    }
}
