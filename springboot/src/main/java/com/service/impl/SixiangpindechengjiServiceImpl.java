package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SixiangpindechengjiDao;
import com.entity.SixiangpindechengjiEntity;
import com.service.SixiangpindechengjiService;
import com.entity.vo.SixiangpindechengjiVO;
import com.entity.view.SixiangpindechengjiView;

@Service("sixiangpindechengjiService")
public class SixiangpindechengjiServiceImpl extends ServiceImpl<SixiangpindechengjiDao, SixiangpindechengjiEntity> implements SixiangpindechengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SixiangpindechengjiEntity> page = this.selectPage(
                new Query<SixiangpindechengjiEntity>(params).getPage(),
                new EntityWrapper<SixiangpindechengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SixiangpindechengjiEntity> wrapper) {
		  Page<SixiangpindechengjiView> page =new Query<SixiangpindechengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SixiangpindechengjiVO> selectListVO(Wrapper<SixiangpindechengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SixiangpindechengjiVO selectVO(Wrapper<SixiangpindechengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SixiangpindechengjiView> selectListView(Wrapper<SixiangpindechengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SixiangpindechengjiView selectView(Wrapper<SixiangpindechengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
