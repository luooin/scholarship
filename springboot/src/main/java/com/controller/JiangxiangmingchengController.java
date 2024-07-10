package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.entity.JiangxuejinshenqingEntity;
import com.entity.XueshengchengjiEntity;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiangxiangmingchengEntity;
import com.entity.view.JiangxiangmingchengView;

import com.service.JiangxiangmingchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 奖项名称
 * 后端接口
 */
@RestController
@RequestMapping("/jiangxiangmingcheng")
public class JiangxiangmingchengController {
    @Autowired
    private JiangxiangmingchengService jiangxiangmingchengService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiangxiangmingchengEntity jiangxiangmingcheng,
		HttpServletRequest request){
        EntityWrapper<JiangxiangmingchengEntity> ew = new EntityWrapper<JiangxiangmingchengEntity>();

		PageUtils page = jiangxiangmingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangxiangmingcheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiangxiangmingchengEntity jiangxiangmingcheng, 
		HttpServletRequest request){
        EntityWrapper<JiangxiangmingchengEntity> ew = new EntityWrapper<JiangxiangmingchengEntity>();

		PageUtils page = jiangxiangmingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangxiangmingcheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiangxiangmingchengEntity jiangxiangmingcheng){
       	EntityWrapper<JiangxiangmingchengEntity> ew = new EntityWrapper<JiangxiangmingchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiangxiangmingcheng, "jiangxiangmingcheng")); 
        return R.ok().put("data", jiangxiangmingchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiangxiangmingchengEntity jiangxiangmingcheng){
        EntityWrapper< JiangxiangmingchengEntity> ew = new EntityWrapper< JiangxiangmingchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiangxiangmingcheng, "jiangxiangmingcheng")); 
		JiangxiangmingchengView jiangxiangmingchengView =  jiangxiangmingchengService.selectView(ew);
		return R.ok("查询奖项名称成功").put("data", jiangxiangmingchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiangxiangmingchengEntity jiangxiangmingcheng = jiangxiangmingchengService.selectById(id);
        return R.ok().put("data", jiangxiangmingcheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiangxiangmingchengEntity jiangxiangmingcheng = jiangxiangmingchengService.selectById(id);
        return R.ok().put("data", jiangxiangmingcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiangxiangmingchengEntity jiangxiangmingcheng, HttpServletRequest request){
    	jiangxiangmingcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiangxiangmingcheng);
        jiangxiangmingchengService.insert(jiangxiangmingcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiangxiangmingchengEntity jiangxiangmingcheng, HttpServletRequest request){
    	jiangxiangmingcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiangxiangmingcheng);
        jiangxiangmingchengService.insert(jiangxiangmingcheng);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiangxiangmingchengEntity jiangxiangmingcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiangxiangmingcheng);
        jiangxiangmingchengService.updateById(jiangxiangmingcheng);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiangxiangmingchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiangxiangmingchengEntity> wrapper = new EntityWrapper<JiangxiangmingchengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jiangxiangmingchengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}


    @IgnoreAuth
    @GetMapping("/echarts/bar")
    public R bar() {
        List<JiangxiangmingchengEntity> list = jiangxiangmingchengService.selectList(null);

        List<String> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();

        Map<String, Integer> collect = list.stream()
                .collect(Collectors.groupingBy(JiangxiangmingchengEntity::getJiangxianglx, Collectors.summingInt(entity -> Integer.parseInt(entity.getJiner()))));


        if (CollectionUtil.isNotEmpty(collect)) {
            for (String key : collect.keySet()) {
                xAxis.add(key);
                yAxis.add(collect.get(key));
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("xAxis", xAxis);
        map.put("yAxis", yAxis);
        return R.ok().put("data", map);
    }



}
