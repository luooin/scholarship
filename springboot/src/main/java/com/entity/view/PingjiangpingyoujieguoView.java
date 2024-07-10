package com.entity.view;

import com.entity.PingjiangpingyoujieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 评奖评优结果
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("pingjiangpingyoujieguo")
public class PingjiangpingyoujieguoView  extends PingjiangpingyoujieguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingjiangpingyoujieguoView(){
	}
 
 	public PingjiangpingyoujieguoView(PingjiangpingyoujieguoEntity pingjiangpingyoujieguoEntity){
 	try {
			BeanUtils.copyProperties(this, pingjiangpingyoujieguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
