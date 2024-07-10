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


import com.dao.XueshengchufaDao;
import com.entity.XueshengchufaEntity;
import com.service.XueshengchufaService;
import com.entity.vo.XueshengchufaVO;
import com.entity.view.XueshengchufaView;

@Service("xueshengchufaService")
public class XueshengchufaServiceImpl extends ServiceImpl<XueshengchufaDao, XueshengchufaEntity> implements XueshengchufaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengchufaEntity> page = this.selectPage(
                new Query<XueshengchufaEntity>(params).getPage(),
                new EntityWrapper<XueshengchufaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengchufaEntity> wrapper) {
		  Page<XueshengchufaView> page =new Query<XueshengchufaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengchufaVO> selectListVO(Wrapper<XueshengchufaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengchufaVO selectVO(Wrapper<XueshengchufaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengchufaView> selectListView(Wrapper<XueshengchufaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengchufaView selectView(Wrapper<XueshengchufaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
