package com.entity.view;

import com.entity.SixiangpindechengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 思想品德成绩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("sixiangpindechengji")
public class SixiangpindechengjiView  extends SixiangpindechengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SixiangpindechengjiView(){
	}
 
 	public SixiangpindechengjiView(SixiangpindechengjiEntity sixiangpindechengjiEntity){
 	try {
			BeanUtils.copyProperties(this, sixiangpindechengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
