package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSaBankBranch;

/**
 * ����SaBankBranch��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSaBankBranchAction extends BLSaBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLSaBankBranchAction.class);

    /**
     * ���캯��
     */
    public BLSaBankBranchAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param saBankBranchDto saBankBranchDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SaBankBranchDto saBankBranchDto,String mode)
            throws Exception{
    }
}
