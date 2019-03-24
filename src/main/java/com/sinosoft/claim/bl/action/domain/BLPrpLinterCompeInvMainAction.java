package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvMain;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompeInvMainAction extends BLPrpLinterCompeInvMainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvMainAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeInvMainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompeInvMainDto prpLinterCompeInvMainDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompeInvMainDto[] prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        BLPrpLinterCompeInvDetailAction bLPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();

        //�����¼
        for(int i=0;i<prpLinterCompeInvMainDto.length;i++){
        	dbPrpLinterCompeInvMain.insert(prpLinterCompeInvMainDto[i]);
        	bLPrpLinterCompeInvDetailAction.insert(dbManager, prpLinterCompeInvMainDto[i].getPrpLinterCompeInvDetailDto());
        }
    }
}
