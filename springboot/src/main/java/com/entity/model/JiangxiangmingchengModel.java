package com.entity.model;

import com.entity.JiangxiangmingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 奖项名称
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */
public class JiangxiangmingchengModel  implements Serializable {
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
