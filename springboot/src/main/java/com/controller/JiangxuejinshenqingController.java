package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.entity.JiangxiangmingchengEntity;
import com.entity.XueshengEntity;
import com.service.JiangxiangmingchengService;
import com.service.XueshengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiangxuejinshenqingEntity;
import com.entity.view.JiangxuejinshenqingView;

import com.service.JiangxuejinshenqingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

import java.util.stream.Collectors;

/**
 * 奖学金申请
 * 后端接口
 */
@RestController
@RequestMapping("/jiangxuejinshenqing")
public class JiangxuejinshenqingController {
    @Autowired
    private JiangxuejinshenqingService jiangxuejinshenqingService;
    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private JiangxiangmingchengService jiangxiangmingchengService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JiangxuejinshenqingEntity jiangxuejinshenqing,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("jiaoshi")) {
//            // 获取老师的学生学号列表
//            List<String> studentIds = queryStudentIdsForTeacher((String) request.getSession().getAttribute("username"));
//            // 设置学生学号作为查询条件
//            jiangxuejinshenqing.setXuehaoList(studentIds);
//        }

        if (tableName.equals("xuesheng")) {
            jiangxuejinshenqing.setXuehao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<JiangxuejinshenqingEntity> ew = new EntityWrapper<JiangxuejinshenqingEntity>();

        PageUtils page = jiangxuejinshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangxuejinshenqing), params), params));

        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, JiangxuejinshenqingEntity jiangxuejinshenqing,
                  HttpServletRequest request) {
        EntityWrapper<JiangxuejinshenqingEntity> ew = new EntityWrapper<JiangxuejinshenqingEntity>();

        PageUtils page = jiangxuejinshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangxuejinshenqing), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(JiangxuejinshenqingEntity jiangxuejinshenqing) {
        EntityWrapper<JiangxuejinshenqingEntity> ew = new EntityWrapper<JiangxuejinshenqingEntity>();
        ew.allEq(MPUtil.allEQMapPre(jiangxuejinshenqing, "jiangxuejinshenqing"));
        return R.ok().put("data", jiangxuejinshenqingService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiangxuejinshenqingEntity jiangxuejinshenqing) {
        EntityWrapper<JiangxuejinshenqingEntity> ew = new EntityWrapper<JiangxuejinshenqingEntity>();
        ew.allEq(MPUtil.allEQMapPre(jiangxuejinshenqing, "jiangxuejinshenqing"));
        JiangxuejinshenqingView jiangxuejinshenqingView = jiangxuejinshenqingService.selectView(ew);
        return R.ok("查询奖学金申请成功").put("data", jiangxuejinshenqingView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        JiangxuejinshenqingEntity jiangxuejinshenqing = jiangxuejinshenqingService.selectById(id);
        return R.ok().put("data", jiangxuejinshenqing);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        JiangxuejinshenqingEntity jiangxuejinshenqing = jiangxuejinshenqingService.selectById(id);
        return R.ok().put("data", jiangxuejinshenqing);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiangxuejinshenqingEntity jiangxuejinshenqing, HttpServletRequest request) {
        jiangxuejinshenqing.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(jiangxuejinshenqing);
        jiangxuejinshenqingService.insert(jiangxuejinshenqing);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiangxuejinshenqingEntity jiangxuejinshenqing, HttpServletRequest request) {
        jiangxuejinshenqing.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(jiangxuejinshenqing);
        jiangxuejinshenqingService.insert(jiangxuejinshenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiangxuejinshenqingEntity jiangxuejinshenqing, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(jiangxuejinshenqing);
        jiangxuejinshenqingService.updateById(jiangxuejinshenqing);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        jiangxuejinshenqingService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<JiangxuejinshenqingEntity> wrapper = new EntityWrapper<JiangxuejinshenqingEntity>();
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

        int count = jiangxuejinshenqingService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


    @GetMapping("/echarts/bie")
    public R bie() {
        List<JiangxuejinshenqingEntity> list = jiangxuejinshenqingService.selectList(null);
        Map<String, Long> collect = list.stream()
                .filter(x -> ObjectUtil.isNotNull(x.getSfsh()))
                .collect(Collectors.groupingBy(JiangxuejinshenqingEntity::getSfsh, Collectors.counting()));
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(collect)) {
            for (String key : collect.keySet()) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", key);
                map.put("value", collect.get(key));
                mapList.add(map);
            }
        }
        return R.ok().put("data", mapList);
    }


    @GetMapping("/echarts/jsBie")
    public R bie(HttpServletRequest request) {

        XueshengEntity xuesheng = new XueshengEntity();
        xuesheng.setJiaoshixingming((String) request.getSession().getAttribute("username"));
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>(xuesheng);

        List<XueshengEntity> xueshengList = xueshengService.selectList(ew);

        List<Map<String, Object>> mapList = new ArrayList<>();

        for (XueshengEntity xueshengEntity : xueshengList) {
            String studentId = xueshengEntity.getXuehao();

            JiangxuejinshenqingEntity jiangxuejinshenqing = new JiangxuejinshenqingEntity();
            jiangxuejinshenqing.setXuehao(studentId);
            EntityWrapper<JiangxuejinshenqingEntity> ew2 = new EntityWrapper<JiangxuejinshenqingEntity>(jiangxuejinshenqing);
            List<JiangxuejinshenqingEntity> list = jiangxuejinshenqingService.selectList(ew2);
            Map<String, Long> collect = list.stream()
                    .filter(x -> ObjectUtil.isNotNull(x.getSfsh()))
                    .collect(Collectors.groupingBy(JiangxuejinshenqingEntity::getSfsh, Collectors.counting()));
            if (CollectionUtil.isNotEmpty(collect)) {
                for (String key : collect.keySet()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", key);
                    map.put("value", collect.get(key));
                    mapList.add(map);
                }
            }
        }

        return R.ok().put("data", mapList);
    }

    @IgnoreAuth
    @GetMapping("/echarts/line")
    public R line(HttpServletRequest request) {


        JiangxuejinshenqingEntity entity = new JiangxuejinshenqingEntity();
        entity.setXuehao((String) request.getSession().getAttribute("username"));

        EntityWrapper<JiangxuejinshenqingEntity> ew1 = new EntityWrapper<JiangxuejinshenqingEntity>(entity);

        List<JiangxuejinshenqingView> list = jiangxuejinshenqingService.selectListView(ew1);


        // 创建一个映射关系的 Map 对象
        Map<String, Double> resultMap = new HashMap<>();
        // 使用流处理过滤审核状态为"复审通过"的奖项，并查询对应的金额
        list.stream()
                .filter(award -> award.getSfsh().equals("复审通过"))
                .forEach(award -> {
                    String name = award.getJiangxiangmingcheng();
                    JiangxiangmingchengEntity jxmc = new JiangxiangmingchengEntity();
                    jxmc.setJiangxiangmingcheng(name);
                    EntityWrapper<JiangxiangmingchengEntity> ew2 = new EntityWrapper<JiangxiangmingchengEntity>(jxmc);
                    List<JiangxiangmingchengEntity> list1 = jiangxiangmingchengService.selectList(ew2);
                    String amountStr  = list1.stream()
                            .filter(amountEntry -> amountEntry.getJiangxiangmingcheng().equals(name))
                            .findFirst()
                            .map(JiangxiangmingchengEntity::getJiner)
                            .orElse("0.0");

                    double amount = Double.parseDouble(amountStr);
                    String applicationTime = String.valueOf(award.getShenqingshijian().toInstant()).substring(0, 7); // 提取年月部分
                    resultMap.merge(applicationTime, amount, Double::sum);
                });


        List<String> xAxis = new ArrayList<>();
        List<Double> yAxis = new ArrayList<>();


        if (CollectionUtil.isNotEmpty(resultMap)) {
            List<String> sortedKeys = new ArrayList<>(resultMap.keySet());
            Collections.sort(sortedKeys);

            for (String key : sortedKeys) {
                xAxis.add(key);
                yAxis.add(resultMap.get(key));
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("xAxis", xAxis);
        map.put("yAxis", yAxis);
        return R.ok().put("data", map);
    }


}
