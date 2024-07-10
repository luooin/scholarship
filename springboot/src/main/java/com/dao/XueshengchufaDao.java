package com.dao;

import com.entity.XueshengchufaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengchufaVO;
import com.entity.view.XueshengchufaView;


/**
 * 学生处罚
 *
 */
public interface XueshengchufaDao extends BaseMapper<XueshengchufaEntity> {
	
	List<XueshengchufaVO> selectListVO(@Param("ew") Wrapper<XueshengchufaEntity> wrapper);
	
	XueshengchufaVO selectVO(@Param("ew") Wrapper<XueshengchufaEntity> wrapper);
	
	List<XueshengchufaView> selectListView(@Param("ew") Wrapper<XueshengchufaEntity> wrapper);

	List<XueshengchufaView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengchufaEntity> wrapper);
	
	XueshengchufaView selectView(@Param("ew") Wrapper<XueshengchufaEntity> wrapper);
	

}
