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
 * 学生成绩
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("xueshengchengji")
public class XueshengchengjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XueshengchengjiEntity() {
		
	}
	
	public XueshengchengjiEntity(T t) {
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
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 学院
	 */
					
	private String xueyuan;
	
	/**
	 * 系别
	 */
					
	private String xibie;
	
	/**
	 * 年份
	 */
					
	private String nianfen;
	
	/**
	 * 班级
	 */
					
	private String banji;
	
	/**
	 * 年级
	 */
					
	private String nianji;
	
	/**
	 * 学期
	 */
					
	private String xueqi;
	
	/**
	 * 总成绩
	 */
					
	private Float zongchengji;
	
	/**
	 * 学分绩点
	 */
					
	private Float xuefenjidian;
	
	/**
	 * 学期评语
	 */
					
	private String xueqipingyu;
	
	/**
	 * 评优权重
	 */
					
	private Float pingyouquanzhong;
	
	/**
	 * 评优分值
	 */
					
	private Float pingyoufenzhi;
	
	/**
	 * 登记时间
	 */
					
	private String dengjishijian;
	
	
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
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：学院
	 */
	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}
	/**
	 * 获取：学院
	 */
	public String getXueyuan() {
		return xueyuan;
	}
	/**
	 * 设置：系别
	 */
	public void setXibie(String xibie) {
		this.xibie = xibie;
	}
	/**
	 * 获取：系别
	 */
	public String getXibie() {
		return xibie;
	}
	/**
	 * 设置：年份
	 */
	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}
	/**
	 * 获取：年份
	 */
	public String getNianfen() {
		return nianfen;
	}
	/**
	 * 设置：班级
	 */
	public void setBanji(String banji) {
		this.banji = banji;
	}
	/**
	 * 获取：班级
	 */
	public String getBanji() {
		return banji;
	}
	/**
	 * 设置：年级
	 */
	public void setNianji(String nianji) {
		this.nianji = nianji;
	}
	/**
	 * 获取：年级
	 */
	public String getNianji() {
		return nianji;
	}
	/**
	 * 设置：学期
	 */
	public void setXueqi(String xueqi) {
		this.xueqi = xueqi;
	}
	/**
	 * 获取：学期
	 */
	public String getXueqi() {
		return xueqi;
	}
	/**
	 * 设置：总成绩
	 */
	public void setZongchengji(Float zongchengji) {
		this.zongchengji = zongchengji;
	}
	/**
	 * 获取：总成绩
	 */
	public Float getZongchengji() {
		return zongchengji;
	}
	/**
	 * 设置：学分绩点
	 */
	public void setXuefenjidian(Float xuefenjidian) {
		this.xuefenjidian = xuefenjidian;
	}
	/**
	 * 获取：学分绩点
	 */
	public Float getXuefenjidian() {
		return xuefenjidian;
	}
	/**
	 * 设置：学期评语
	 */
	public void setXueqipingyu(String xueqipingyu) {
		this.xueqipingyu = xueqipingyu;
	}
	/**
	 * 获取：学期评语
	 */
	public String getXueqipingyu() {
		return xueqipingyu;
	}
	/**
	 * 设置：评优权重
	 */
	public void setPingyouquanzhong(Float pingyouquanzhong) {
		this.pingyouquanzhong = pingyouquanzhong;
	}
	/**
	 * 获取：评优权重
	 */
	public Float getPingyouquanzhong() {
		return pingyouquanzhong;
	}
	/**
	 * 设置：评优分值
	 */
	public void setPingyoufenzhi(Float pingyoufenzhi) {
		this.pingyoufenzhi = pingyoufenzhi;
	}
	/**
	 * 获取：评优分值
	 */
	public Float getPingyoufenzhi() {
		return pingyoufenzhi;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(String dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public String getDengjishijian() {
		return dengjishijian;
	}

}
