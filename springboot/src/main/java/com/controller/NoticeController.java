package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.JiaoshiEntity;
import com.entity.Notice;
import com.entity.view.JiaoshiView;
import com.service.JiaoshiService;
import com.service.NoticeService;
import com.service.TokenService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 系统公告
 * 后端接口
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;


    /**
     * 后端列表
     */
    @IgnoreAuth
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, Notice notice,
				  HttpServletRequest request){
        EntityWrapper<Notice> ew = new EntityWrapper<Notice>();

		PageUtils page = noticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, notice), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Notice notice,
		HttpServletRequest request){
        EntityWrapper<Notice> ew = new EntityWrapper<Notice>();

		PageUtils page = noticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, notice), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Notice notice){
       	EntityWrapper<Notice> ew = new EntityWrapper<Notice>();
      	ew.allEq(MPUtil.allEQMapPre( notice, "notice"));
        return R.ok().put("data", noticeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Notice notice){
        EntityWrapper< Notice> ew = new EntityWrapper< Notice>();
 		ew.allEq(MPUtil.allEQMapPre( notice, "notice"));
		Notice noticeView =  noticeService.selectView(ew);
		return R.ok("查询教师成功").put("data", noticeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Notice notice = noticeService.selectById(id);
        return R.ok().put("data", notice);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
		Notice notice = noticeService.selectById(id);
        return R.ok().put("data", notice);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Notice notice, HttpServletRequest request){
		notice.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoshi);
    	Notice user = noticeService.selectOne(new EntityWrapper<Notice>().eq("name", notice.getName()));
		if(user!=null) {
			return R.error("公告已存在");
		}
		notice.setId(new Date().getTime());
		noticeService.insert(notice);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Notice notice, HttpServletRequest request){
		notice.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoshi);
		Notice user = noticeService.selectOne(new EntityWrapper<Notice>().eq("notice", notice.getName()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		notice.setId(new Date().getTime());
		noticeService.insert(notice);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody Notice notice, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoshi);
		noticeService.updateById(notice);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		noticeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
//    /**
//     * 提醒接口
//     */
//	@RequestMapping("/remind/{columnName}/{type}")
//	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
//						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
//		map.put("column", columnName);
//		map.put("type", type);
//
//		if(type.equals("2")) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Calendar c = Calendar.getInstance();
//			Date remindStartDate = null;
//			Date remindEndDate = null;
//			if(map.get("remindstart")!=null) {
//				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
//				c.setTime(new Date());
//				c.add(Calendar.DAY_OF_MONTH,remindStart);
//				remindStartDate = c.getTime();
//				map.put("remindstart", sdf.format(remindStartDate));
//			}
//			if(map.get("remindend")!=null) {
//				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
//				c.setTime(new Date());
//				c.add(Calendar.DAY_OF_MONTH,remindEnd);
//				remindEndDate = c.getTime();
//				map.put("remindend", sdf.format(remindEndDate));
//			}
//		}
//
//		Wrapper<JiaoshiEntity> wrapper = new EntityWrapper<JiaoshiEntity>();
//		if(map.get("remindstart")!=null) {
//			wrapper.ge(columnName, map.get("remindstart"));
//		}
//		if(map.get("remindend")!=null) {
//			wrapper.le(columnName, map.get("remindend"));
//		}
//
//
//		int count = jiaoshiService.selectCount(wrapper);
//		return R.ok().put("count", count);
//	}
	







}
