package com.dao;

import com.entity.SixiangpindechengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SixiangpindechengjiVO;
import com.entity.view.SixiangpindechengjiView;


/**
 * 思想品德成绩
 *
 */
public interface SixiangpindechengjiDao extends BaseMapper<SixiangpindechengjiEntity> {
	
	List<SixiangpindechengjiVO> selectListVO(@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);
	
	SixiangpindechengjiVO selectVO(@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);
	
	List<SixiangpindechengjiView> selectListView(@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);

	List<SixiangpindechengjiView> selectListView(Pagination page,@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);
	
	SixiangpindechengjiView selectView(@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);
	

}
