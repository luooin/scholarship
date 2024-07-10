package com.dao;

import com.entity.JiangxiangmingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiangxiangmingchengVO;
import com.entity.view.JiangxiangmingchengView;


/**
 * 奖项名称
 *
 */
public interface JiangxiangmingchengDao extends BaseMapper<JiangxiangmingchengEntity> {
	
	List<JiangxiangmingchengVO> selectListVO(@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);
	
	JiangxiangmingchengVO selectVO(@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);
	
	List<JiangxiangmingchengView> selectListView(@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);

	List<JiangxiangmingchengView> selectListView(Pagination page,@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);
	
	JiangxiangmingchengView selectView(@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);
	

}
