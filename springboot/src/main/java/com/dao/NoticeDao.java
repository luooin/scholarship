package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.Notice;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 菜单
 *
 */
public interface NoticeDao extends BaseMapper<Notice> {

    List<Notice> selectListVO(@Param("ew") Wrapper<Notice> wrapper);

    Notice selectVO(@Param("ew") Wrapper<Notice> wrapper);

    List<Notice> selectListView(@Param("ew") Wrapper<Notice> wrapper);

    List<Notice> selectListView(Pagination page,@Param("ew") Wrapper<Notice> wrapper);

    Notice selectView(@Param("ew") Wrapper<Notice> wrapper);
}
