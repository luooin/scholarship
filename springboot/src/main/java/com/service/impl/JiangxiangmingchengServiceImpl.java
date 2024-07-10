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


import com.dao.JiangxiangmingchengDao;
import com.entity.JiangxiangmingchengEntity;
import com.service.JiangxiangmingchengService;
import com.entity.vo.JiangxiangmingchengVO;
import com.entity.view.JiangxiangmingchengView;

@Service("jiangxiangmingchengService")
public class JiangxiangmingchengServiceImpl extends ServiceImpl<JiangxiangmingchengDao, JiangxiangmingchengEntity> implements JiangxiangmingchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiangxiangmingchengEntity> page = this.selectPage(
                new Query<JiangxiangmingchengEntity>(params).getPage(),
                new EntityWrapper<JiangxiangmingchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiangxiangmingchengEntity> wrapper) {
		  Page<JiangxiangmingchengView> page =new Query<JiangxiangmingchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiangxiangmingchengVO> selectListVO(Wrapper<JiangxiangmingchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiangxiangmingchengVO selectVO(Wrapper<JiangxiangmingchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiangxiangmingchengView> selectListView(Wrapper<JiangxiangmingchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiangxiangmingchengView selectView(Wrapper<JiangxiangmingchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
