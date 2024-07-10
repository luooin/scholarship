package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SixiangpindechengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SixiangpindechengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SixiangpindechengjiView;


/**
 * 思想品德成绩
 *
 */
public interface SixiangpindechengjiService extends IService<SixiangpindechengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SixiangpindechengjiVO> selectListVO(Wrapper<SixiangpindechengjiEntity> wrapper);
   	
   	SixiangpindechengjiVO selectVO(@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);
   	
   	List<SixiangpindechengjiView> selectListView(Wrapper<SixiangpindechengjiEntity> wrapper);
   	
   	SixiangpindechengjiView selectView(@Param("ew") Wrapper<SixiangpindechengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SixiangpindechengjiEntity> wrapper);
   	

}

