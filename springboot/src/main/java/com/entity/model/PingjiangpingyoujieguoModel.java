package com.entity.model;

import com.entity.PingjiangpingyoujieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 评奖评优结果
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */
public class PingjiangpingyoujieguoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 年级
	 */
	
	private String nianji;
		
	/**
	 * 班级
	 */
	
	private String banji;
		
	/**
	 * 奖项名称
	 */
	
	private String jiangxiangmingcheng;
		
	/**
	 * 申请内容
	 */
	
	private String shenqingneirong;
		
	/**
	 * 申请时间
	 */
	
	private String shenqingshijian;
		
	/**
	 * 学习成绩
	 */
	
	private Float xuexichengji;
		
	/**
	 * 思德成绩
	 */
	
	private Float sidechengji;
		
	/**
	 * 评分结果
	 */
	
	private Float pingfenjieguo;
		
	/**
	 * 评分时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingfenshijian;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
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
				
	
	/**
	 * 设置：申请内容
	 */
	 
	public void setShenqingneirong(String shenqingneirong) {
		this.shenqingneirong = shenqingneirong;
	}
	
	/**
	 * 获取：申请内容
	 */
	public String getShenqingneirong() {
		return shenqingneirong;
	}
				
	
	/**
	 * 设置：申请时间
	 */
	 
	public void setShenqingshijian(String shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 * 获取：申请时间
	 */
	public String getShenqingshijian() {
		return shenqingshijian;
	}
				
	
	/**
	 * 设置：学习成绩
	 */
	 
	public void setXuexichengji(Float xuexichengji) {
		this.xuexichengji = xuexichengji;
	}
	
	/**
	 * 获取：学习成绩
	 */
	public Float getXuexichengji() {
		return xuexichengji;
	}
				
	
	/**
	 * 设置：思德成绩
	 */
	 
	public void setSidechengji(Float sidechengji) {
		this.sidechengji = sidechengji;
	}
	
	/**
	 * 获取：思德成绩
	 */
	public Float getSidechengji() {
		return sidechengji;
	}
				
	
	/**
	 * 设置：评分结果
	 */
	 
	public void setPingfenjieguo(Float pingfenjieguo) {
		this.pingfenjieguo = pingfenjieguo;
	}
	
	/**
	 * 获取：评分结果
	 */
	public Float getPingfenjieguo() {
		return pingfenjieguo;
	}
				
	
	/**
	 * 设置：评分时间
	 */
	 
	public void setPingfenshijian(Date pingfenshijian) {
		this.pingfenshijian = pingfenshijian;
	}
	
	/**
	 * 获取：评分时间
	 */
	public Date getPingfenshijian() {
		return pingfenshijian;
	}
			
}
