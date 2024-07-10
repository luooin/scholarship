package com.entity.vo;

import com.entity.SixiangpindechengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 思想品德成绩
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
public class SixiangpindechengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 班级
	 */
	
	private String banji;
		
	/**
	 * 学期
	 */
	
	private String xueqi;
		
	/**
	 * 年级
	 */
	
	private String nianji;
		
	/**
	 * 年份
	 */
	
	private String nianfen;
		
	/**
	 * 教师姓名
	 */
	
	private String jiaoshixingming;
		
	/**
	 * 热爱祖国
	 */
	
	private Float reaizuguo;
		
	/**
	 * 诚实守信
	 */
	
	private Float chengshishouxin;
		
	/**
	 * 遵纪守法
	 */
	
	private Float zunjishoufa;
		
	/**
	 * 自强向上
	 */
	
	private Float ziqiangxiangshang;
		
	/**
	 * 团结合作
	 */
	
	private Float tuanjiehezuo;
		
	/**
	 * 学习态度
	 */
	
	private Float xuexitaidu;
		
	/**
	 * 总分
	 */
	
	private Float zongfen;
		
	/**
	 * 评优权重
	 */
	
	private Float pingyouquanzhong;
		
	/**
	 * 评优分值
	 */
	
	private Float pingyoufenzhi;
		
	/**
	 * 评价
	 */
	
	private String pingjia;
		
	/**
	 * 登记时间
	 */
	
	private String dengjishijian;
				
	
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
	 * 设置：教师姓名
	 */
	 
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
				
	
	/**
	 * 设置：热爱祖国
	 */
	 
	public void setReaizuguo(Float reaizuguo) {
		this.reaizuguo = reaizuguo;
	}
	
	/**
	 * 获取：热爱祖国
	 */
	public Float getReaizuguo() {
		return reaizuguo;
	}
				
	
	/**
	 * 设置：诚实守信
	 */
	 
	public void setChengshishouxin(Float chengshishouxin) {
		this.chengshishouxin = chengshishouxin;
	}
	
	/**
	 * 获取：诚实守信
	 */
	public Float getChengshishouxin() {
		return chengshishouxin;
	}
				
	
	/**
	 * 设置：遵纪守法
	 */
	 
	public void setZunjishoufa(Float zunjishoufa) {
		this.zunjishoufa = zunjishoufa;
	}
	
	/**
	 * 获取：遵纪守法
	 */
	public Float getZunjishoufa() {
		return zunjishoufa;
	}
				
	
	/**
	 * 设置：自强向上
	 */
	 
	public void setZiqiangxiangshang(Float ziqiangxiangshang) {
		this.ziqiangxiangshang = ziqiangxiangshang;
	}
	
	/**
	 * 获取：自强向上
	 */
	public Float getZiqiangxiangshang() {
		return ziqiangxiangshang;
	}
				
	
	/**
	 * 设置：团结合作
	 */
	 
	public void setTuanjiehezuo(Float tuanjiehezuo) {
		this.tuanjiehezuo = tuanjiehezuo;
	}
	
	/**
	 * 获取：团结合作
	 */
	public Float getTuanjiehezuo() {
		return tuanjiehezuo;
	}
				
	
	/**
	 * 设置：学习态度
	 */
	 
	public void setXuexitaidu(Float xuexitaidu) {
		this.xuexitaidu = xuexitaidu;
	}
	
	/**
	 * 获取：学习态度
	 */
	public Float getXuexitaidu() {
		return xuexitaidu;
	}
				
	
	/**
	 * 设置：总分
	 */
	 
	public void setZongfen(Float zongfen) {
		this.zongfen = zongfen;
	}
	
	/**
	 * 获取：总分
	 */
	public Float getZongfen() {
		return zongfen;
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
	 * 设置：评价
	 */
	 
	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}
	
	/**
	 * 获取：评价
	 */
	public String getPingjia() {
		return pingjia;
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
