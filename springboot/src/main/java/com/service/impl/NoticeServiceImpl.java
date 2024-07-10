package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.JiaoshiDao;
import com.dao.NoticeDao;
import com.entity.JiaoshiEntity;
import com.entity.Notice;
import com.entity.view.JiaoshiView;
import com.entity.vo.JiaoshiVO;
import com.service.JiaoshiService;
import com.service.NoticeService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Notice> page = this.selectPage(
                new Query<Notice>(params).getPage(),
                new EntityWrapper<Notice>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Notice> wrapper) {
		  Page<Notice> page =new Query<Notice>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Notice> selectListVO(Wrapper<Notice> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Notice selectVO(Wrapper<Notice> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Notice> selectListView(Wrapper<Notice> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Notice selectView(Wrapper<Notice> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
