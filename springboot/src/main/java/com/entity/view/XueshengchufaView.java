package com.entity.view;

import com.entity.XueshengchufaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生处罚
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueshengchufa")
public class XueshengchufaView  extends XueshengchufaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengchufaView(){
	}
 
 	public XueshengchufaView(XueshengchufaEntity xueshengchufaEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengchufaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
