package com.entity.vo;

import com.entity.JiangxiangmingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 奖项名称
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
public class JiangxiangmingchengVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 奖项内容
	 */
	
	private String jiangxiangneirong;
				
	
	/**
	 * 设置：奖项内容
	 */
	 
	public void setJiangxiangneirong(String jiangxiangneirong) {
		this.jiangxiangneirong = jiangxiangneirong;
	}
	
	/**
	 * 获取：奖项内容
	 */
	public String getJiangxiangneirong() {
		return jiangxiangneirong;
	}
			
}
