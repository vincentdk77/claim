package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLJobLinker;

/**
 * ����PrpLJobLinker��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLJobLinkerAction extends BLPrpLJobLinkerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLJobLinkerAction.class);

    /**
     * ���캯��
     */
    public BLPrpLJobLinkerAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLJobLinkerDto prpLJobLinkerDto,String mode)
            throws Exception{
    }
}
