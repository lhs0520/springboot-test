package com.winter.enums;


public enum PointsTypeEnum {

	PAY_POINTS ("01","交电费赠送积分"),
	MARKETING_ACTIVITIES_POINTS ("02","营销活动，赠送积分"),
	FIRST_NOCOSTCONTROL_TRANS_COSTCONTROL_POINTS ("0201","首次使用智能电表，赠送积分"),
	FIRST_BOND_APP_POINTS ("0202","首次绑定户号，赠送积分"),
	FIRST_PAY_POINTS ("0203","首次通过线上渠道交费，赠送积分"),
	FIRST_REALNAME_VALIDATION_POINTS ("0204","首次实名验证，赠送积分"),
	REWARD_POINTS ("03","奖励积分"),
	PRESTORE_POINTS ("04","预存电费，赠送积分"),
	PRESTORE_NORMAL_POINTS ("0401","预存电费，赠送积分"),
	PRESTORE_COSTCONTROL_POINTS ("0402","预存电费，赠送积分"),
	POINTS_DEDUCTION ("05","积分扣减"),
	POINTS_ADJUSTMENT ("06","积分调整"),
	POINTS_DEFAULT ("11","合作平台积分转换新增");
	
	private String code;
	private String description;
	
	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	PointsTypeEnum(String code,String description){
		this.code = code;
		this.description = description;
	}
	
	
	public static String fetchDescription(String code) {
	    for (PointsTypeEnum instance : PointsTypeEnum.values()) {
	      if (instance.getCode().equals(code)) {
	    	  return instance.getDescription();
	      }
	    }
	    return "";
	}
	
}
