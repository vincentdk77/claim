package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;

/**
 * 自定义意健险调查数据传输对象
 * <p>Title: 意健险调查DTO</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author wangwei
 * @version 1.0
 */
public class AcciCheckDto implements Serializable
{
	 /** 赔款费用信息 */
    private ArrayList prpLchargeDtoList;
	
	/**意健险调查主信息*/
	private PrpLacciCheckDto prpLacciCheckDto;
	/**意键险调查文本信息*/
	private PrpLacciCheckTextDto prpLacciCheckTextDto;
	/**意键险调查文本信息（多行）*/
	private ArrayList prpLacciCheckTextDtoList;
	/**设置报案信息*/
	private PrpLregistDto prpLregistDto;
	
	/**
	 * 意健险时的调查费用列表
	 */
	private Collection prpLAcciCheckChargeDtoList = new ArrayList();
	
//add by liuyanmei 20051221	start
	
	 public ArrayList getPrpLchargeDtoList() {
        return prpLchargeDtoList;
    }
	 public void setPrpLchargeDtoList(ArrayList prpLchargeDtoList) {
        this.prpLchargeDtoList = prpLchargeDtoList;
    }
// add by liuyanmei 20051221 end
	/**
	 * 设置报案信息
	 * @param 设置报案信息*/
	public void setPrpLregistDto(PrpLregistDto prpLregistDto) {
	    this.prpLregistDto = prpLregistDto;
	}
	/**
	 * 获得报案信息
	 * @return 获得报案信息*/
	public PrpLregistDto getPrpLregistDto() {
		return this.prpLregistDto;
	}
	
	/**
	 * 设置意健险调查主信息
	 * @param prpLacciCheckDto 意健险调查主信息*/
	public void setPrpLacciCheckDto(PrpLacciCheckDto prpLacciCheckDto) {
		this.prpLacciCheckDto = prpLacciCheckDto;
	}
	/**
	 * 获得意健险调查主信息
	 * @return 意健险调查主信息*/
	public PrpLacciCheckDto getPrpLacciCheckDto( ) {
		return this.prpLacciCheckDto;
	}
	
	/**
	 * 设置意键险调查文本信息（多行）
	 * @param prpLacciCheckTextDto*/
	public void setPrpLacciCheckTextDtoList(ArrayList prpLacciCheckTextDtoList) {
		this.prpLacciCheckTextDtoList = prpLacciCheckTextDtoList;
	}
	/**
	 * 获得意键险调查文本信息（多行）
	 * @return 意键险调查文本信息*/
	public ArrayList getPrpLacciCheckTextDtoList() {
		return this.prpLacciCheckTextDtoList;
	}
	
	/**
	 * 设置意键险调查文本信息
	 * @param prpLacciCheckTextDto*/
	public void setPrpLacciCheckTextDto(PrpLacciCheckTextDto prpLacciCheckTextDto) {
		this.prpLacciCheckTextDto = prpLacciCheckTextDto;
	}
	/**
	 * 获得意键险调查文本信息
	 * @return 意键险调查文本信息*/
	public PrpLacciCheckTextDto getPrpLacciCheckTextDto() {
		return this.prpLacciCheckTextDto;
	}
	/**设置意健险调查费用列表
	 * @param prpLAcciCheckChargeDtoList 意健险调查费用列表
	 */
	
	public void setPrpLAcciCheckChargeDtoList(Collection prpLAcciCheckChargeDtoList) {
		this.prpLAcciCheckChargeDtoList = prpLAcciCheckChargeDtoList;
	}
	
	/**获得意健险调查费用列表
	 * @return  prpLAcciCheckChargeDtoList 意健险调查费用列表
	 */
	
	public Collection getPrpLAcciCheckChargeDtoList() {
		return prpLAcciCheckChargeDtoList;
	}
}
