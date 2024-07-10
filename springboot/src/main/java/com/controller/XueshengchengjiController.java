package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.entity.JiangxuejinshenqingEntity;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XueshengchengjiEntity;
import com.entity.view.XueshengchengjiView;

import com.service.XueshengchengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 学生成绩
 * 后端接口
 */
@RestController
@RequestMapping("/xueshengchengji")
public class XueshengchengjiController {
    @Autowired
    private XueshengchengjiService xueshengchengjiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, XueshengchengjiEntity xueshengchengji,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("xuesheng")) {
            xueshengchengji.setXuehao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();

        PageUtils page = xueshengchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengchengji), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, XueshengchengjiEntity xueshengchengji,
                  HttpServletRequest request) {
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();

        PageUtils page = xueshengchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengchengji), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(XueshengchengjiEntity xueshengchengji) {
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();
        ew.allEq(MPUtil.allEQMapPre(xueshengchengji, "xueshengchengji"));
        return R.ok().put("data", xueshengchengjiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengchengjiEntity xueshengchengji) {
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();
        ew.allEq(MPUtil.allEQMapPre(xueshengchengji, "xueshengchengji"));
        XueshengchengjiView xueshengchengjiView = xueshengchengjiService.selectView(ew);
        return R.ok("查询学生成绩成功").put("data", xueshengchengjiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        XueshengchengjiEntity xueshengchengji = xueshengchengjiService.selectById(id);
        return R.ok().put("data", xueshengchengji);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        XueshengchengjiEntity xueshengchengji = xueshengchengjiService.selectById(id);
        return R.ok().put("data", xueshengchengji);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengchengjiEntity xueshengchengji, HttpServletRequest request) {
        xueshengchengji.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(xueshengchengji);
        xueshengchengjiService.insert(xueshengchengji);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengchengjiEntity xueshengchengji, HttpServletRequest request) {
        xueshengchengji.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(xueshengchengji);
        xueshengchengjiService.insert(xueshengchengji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengchengjiEntity xueshengchengji, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(xueshengchengji);
        xueshengchengjiService.updateById(xueshengchengji);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        xueshengchengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if (type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if (map.get("remindstart") != null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if (map.get("remindend") != null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<XueshengchengjiEntity> wrapper = new EntityWrapper<XueshengchengjiEntity>();
        if (map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if (map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("xuesheng")) {
            wrapper.eq("xuehao", (String) request.getSession().getAttribute("username"));
        }

        int count = xueshengchengjiService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


    @GetMapping("/echarts/line")
    public R line(HttpServletRequest request) {
        XueshengchengjiEntity xueshengchengji = new XueshengchengjiEntity();
        xueshengchengji.setXuehao((String) request.getSession().getAttribute("username"));
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>(xueshengchengji);
        List<XueshengchengjiEntity> list = xueshengchengjiService.selectList(ew);

        List<String> xAxis = new ArrayList<>();
        List<Float> yAxis = new ArrayList<>();

        list.forEach(e->{
            xAxis.add(e.getNianfen());
            yAxis.add(e.getZongchengji());
        });

        Map<String, Object> map = new HashMap<>();
        map.put("xAxis", xAxis);
        map.put("yAxis", yAxis);
        return R.ok().put("data", map);
    }

}
