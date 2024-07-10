package com.dao;

import com.entity.PingjiangpingyoujieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingjiangpingyoujieguoVO;
import com.entity.view.PingjiangpingyoujieguoView;


/**
 * 评奖评优结果
 *
 */
public interface PingjiangpingyoujieguoDao extends BaseMapper<PingjiangpingyoujieguoEntity> {
	
	List<PingjiangpingyoujieguoVO> selectListVO(@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);
	
	PingjiangpingyoujieguoVO selectVO(@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);
	
	List<PingjiangpingyoujieguoView> selectListView(@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);

	List<PingjiangpingyoujieguoView> selectListView(Pagination page,@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);
	
	PingjiangpingyoujieguoView selectView(@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);
	

}
