package com.gyic.claim.dto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ���嵥ͷ������ݴ���������<br>
 */
public class MedicalInsuremainlistDtoBase implements Serializable {

	private static final long serialVersionUID = 1L;
    private String InusreListCode;
    private String ClassCode;
    private String RiskCode;
    private String ProposalNo;
    private String PolicyNo;
    private String Validity;
    private String UpdateCode;
    private DateTime UpdateDate = new DateTime();
    private String OpCode;
    private String ReMark;
    private DateTime StartTime = new DateTime();
    private DateTime EndTime = new DateTime();
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�InsuremainlistDtoBase����
     */
    public MedicalInsuremainlistDtoBase(){
    }


    public String getInusreListCode(){
        return StringUtils.rightTrim(InusreListCode);
    }



    public void setInusreListCode(String InusreListCode){
        this.InusreListCode = StringUtils.rightTrim(InusreListCode);
    }
	
	
    public String getClassCode(){
        return StringUtils.rightTrim(ClassCode);
    }



    public void setClassCode(String ClassCode){
        this.ClassCode = StringUtils.rightTrim(ClassCode);
    }


    public String getRiskCode(){
        return StringUtils.rightTrim(RiskCode);
    }



    public void setRiskCode(String RiskCode){
        this.RiskCode = StringUtils.rightTrim(RiskCode);
    }
	
	
	public String getProposalNo(){
	    return StringUtils.rightTrim(ProposalNo);
	}
	
	
	
	public void setProposalNo(String ProposalNo){
	    this.ProposalNo = StringUtils.rightTrim(ProposalNo);
	}
	
	
	public String getPolicyNo(){
	    return StringUtils.rightTrim(PolicyNo);
	}
	
	
	
	public void setPolicyNo(String PolicyNo){
	    this.PolicyNo = StringUtils.rightTrim(PolicyNo);
	}
	
	
	public String getValidity(){
	    return StringUtils.rightTrim(Validity);
	}
	
	
	
	public void setValidity(String Validity){
	    this.Validity = StringUtils.rightTrim(Validity);
	}
	
	
	public String getUpdateCode(){
	    return StringUtils.rightTrim(UpdateCode);
	}
	
	
	
	public void setUpdateCode(String UpdateCode){
	    this.UpdateCode = StringUtils.rightTrim(UpdateCode);
	}
	
	
	public DateTime getUpdateDate(){
	    return UpdateDate;
	}
	
	
	
	public void setUpdateDate(DateTime UpdateDate){
	    this.UpdateDate = UpdateDate;
	}
	
	
    public String getOpCode(){
        return OpCode;
    }



    public void setOpCode(String OpCode){
        this.OpCode = StringUtils.rightTrim(OpCode);
    }
	
	
    public String getReMark(){
        return StringUtils.rightTrim(ReMark);
    }



    public void setReMark(String ReMark){
        this.ReMark = StringUtils.rightTrim(ReMark);
    }
    
	
    public DateTime getStartTime(){
        return StartTime;
    }



    public void setStartTime(DateTime StartTime){
	this.StartTime = StartTime;

      }


    public DateTime getEndTime(){
        return EndTime;
    }



    public void setEndTime(DateTime endtime){
	this.EndTime = endtime;

      }
	
}

