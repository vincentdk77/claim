package com.sinosoft.claim.dto.domain;

public class DTreeNewDto {
	public String id = "";
	public String parentId = "";
	public String name = "";
	public String url  ="";
	public String title = "";
	public String target = "";
	public String openFlag = "false";
	public String checkBox = "";
	public String checkStatus = "false";
	private int displayNo;
	private String flag = "";
	private int level;
	private String imageExpand = "";
	private String imageCollapse = "";
	private boolean checked = false;
	private boolean disabled = false;
	
	public DTreeNewDto(){
    }
	
	public DTreeNewDto(String id, String parentId, String name, String url, String target, 
			int displayNo, String flag, int level, String imageExpand, String imageCollapse){
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.url = url;
		this.target = target;
		this.displayNo = displayNo;
		this.flag = flag;
		this.level = level;
		this.imageExpand = imageExpand;
		this.imageCollapse = imageCollapse;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getOpenFlag() {
		return openFlag;
	}
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}
	public String getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public int getDisplayNo() {
		return displayNo;
	}
	public void setDisplayNo(int displayNo) {
		this.displayNo = displayNo;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getImageExpand() {
		return imageExpand;
	}
	public void setImageExpand(String imageExpand) {
		this.imageExpand = imageExpand;
	}
	public String getImageCollapse() {
		return imageCollapse;
	}
	public void setImageCollapse(String imageCollapse) {
		this.imageCollapse = imageCollapse;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	
}
