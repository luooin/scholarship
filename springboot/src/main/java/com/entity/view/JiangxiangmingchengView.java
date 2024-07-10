package com.entity.view;

import com.entity.JiangxiangmingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 奖项名称
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiangxiangmingcheng")
public class JiangxiangmingchengView  extends JiangxiangmingchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiangxiangmingchengView(){
	}
 
 	public JiangxiangmingchengView(JiangxiangmingchengEntity jiangxiangmingchengEntity){
 	try {
			BeanUtils.copyProperties(this, jiangxiangmingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
