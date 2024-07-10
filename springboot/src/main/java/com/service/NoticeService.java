package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.JiaoshiEntity;
import com.entity.Notice;
import com.entity.view.JiaoshiView;
import com.entity.vo.JiaoshiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 公告
 *
 */
public interface NoticeService extends IService<Notice> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Notice> selectListVO(Wrapper<Notice> wrapper);

	Notice selectVO(@Param("ew") Wrapper<Notice> wrapper);
   	
   	List<Notice> selectListView(Wrapper<Notice> wrapper);

	Notice selectView(@Param("ew") Wrapper<Notice> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Notice> wrapper);
   	

}

