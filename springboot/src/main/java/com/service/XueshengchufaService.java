package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengchufaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengchufaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengchufaView;


/**
 * 学生处罚
 *
 */
public interface XueshengchufaService extends IService<XueshengchufaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengchufaVO> selectListVO(Wrapper<XueshengchufaEntity> wrapper);
   	
   	XueshengchufaVO selectVO(@Param("ew") Wrapper<XueshengchufaEntity> wrapper);
   	
   	List<XueshengchufaView> selectListView(Wrapper<XueshengchufaEntity> wrapper);
   	
   	XueshengchufaView selectView(@Param("ew") Wrapper<XueshengchufaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengchufaEntity> wrapper);
   	

}

