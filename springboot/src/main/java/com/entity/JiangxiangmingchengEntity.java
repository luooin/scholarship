package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 奖项名称
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("jiangxiangmingcheng")
public class JiangxiangmingchengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiangxiangmingchengEntity() {
		
	}
	
	public JiangxiangmingchengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 奖项名称
	 */
					
	private String jiangxiangmingcheng;
	private String jiangxianglx;

	public String getJiangxianglx() {
		return jiangxianglx;
	}

	public void setJiangxianglx(String jiangxianglx) {
		this.jiangxianglx = jiangxianglx;
	}

	private String jiner;

	private String shenqingtiaojian;



	/**
	 * 奖项内容
	 */
					
	private String jiangxiangneirong;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：奖项名称
	 */
	public void setJiangxiangmingcheng(String jiangxiangmingcheng) {
		this.jiangxiangmingcheng = jiangxiangmingcheng;
	}
	/**
	 * 获取：奖项名称
	 */
	public String getJiangxiangmingcheng() {
		return jiangxiangmingcheng;
	}

	public void setJiner(String jiner) {
		this.jiner = jiner;
	}

	public String getJiner() {
		return jiner;
	}

	public void setShenqingtiaojian(String shenqingtiaojian) {
		this.shenqingtiaojian = shenqingtiaojian;
	}

	public String getShenqingtiaojian() {
		return shenqingtiaojian;
	}

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
