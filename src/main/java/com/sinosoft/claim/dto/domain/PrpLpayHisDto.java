package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是prpLpayHis的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayHisDto extends PrpLpayHisDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private String editElementDate = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLpayHisDto对象
     */
    public PrpLpayHisDto(){
    }
}
