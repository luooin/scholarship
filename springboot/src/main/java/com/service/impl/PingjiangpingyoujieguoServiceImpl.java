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


import com.dao.PingjiangpingyoujieguoDao;
import com.entity.PingjiangpingyoujieguoEntity;
import com.service.PingjiangpingyoujieguoService;
import com.entity.vo.PingjiangpingyoujieguoVO;
import com.entity.view.PingjiangpingyoujieguoView;

@Service("pingjiangpingyoujieguoService")
public class PingjiangpingyoujieguoServiceImpl extends ServiceImpl<PingjiangpingyoujieguoDao, PingjiangpingyoujieguoEntity> implements PingjiangpingyoujieguoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingjiangpingyoujieguoEntity> page = this.selectPage(
                new Query<PingjiangpingyoujieguoEntity>(params).getPage(),
                new EntityWrapper<PingjiangpingyoujieguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingjiangpingyoujieguoEntity> wrapper) {
		  Page<PingjiangpingyoujieguoView> page =new Query<PingjiangpingyoujieguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PingjiangpingyoujieguoVO> selectListVO(Wrapper<PingjiangpingyoujieguoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingjiangpingyoujieguoVO selectVO(Wrapper<PingjiangpingyoujieguoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingjiangpingyoujieguoView> selectListView(Wrapper<PingjiangpingyoujieguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingjiangpingyoujieguoView selectView(Wrapper<PingjiangpingyoujieguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
