package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiangxiangmingchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiangxiangmingchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiangxiangmingchengView;


/**
 * 奖项名称
 *
 */
public interface JiangxiangmingchengService extends IService<JiangxiangmingchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiangxiangmingchengVO> selectListVO(Wrapper<JiangxiangmingchengEntity> wrapper);
   	
   	JiangxiangmingchengVO selectVO(@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);
   	
   	List<JiangxiangmingchengView> selectListView(Wrapper<JiangxiangmingchengEntity> wrapper);
   	
   	JiangxiangmingchengView selectView(@Param("ew") Wrapper<JiangxiangmingchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiangxiangmingchengEntity> wrapper);
   	

}

