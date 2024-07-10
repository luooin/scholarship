package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingjiangpingyoujieguoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingjiangpingyoujieguoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiangpingyoujieguoView;


/**
 * 评奖评优结果
 *
 */
public interface PingjiangpingyoujieguoService extends IService<PingjiangpingyoujieguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingjiangpingyoujieguoVO> selectListVO(Wrapper<PingjiangpingyoujieguoEntity> wrapper);
   	
   	PingjiangpingyoujieguoVO selectVO(@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);
   	
   	List<PingjiangpingyoujieguoView> selectListView(Wrapper<PingjiangpingyoujieguoEntity> wrapper);
   	
   	PingjiangpingyoujieguoView selectView(@Param("ew") Wrapper<PingjiangpingyoujieguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingjiangpingyoujieguoEntity> wrapper);
   	

}

