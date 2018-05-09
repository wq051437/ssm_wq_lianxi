/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImgServiceImpl
 * Author:   zlh
 * Date:     2018/4/30 23:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.dao.RoleMapper;
import com.jk.model.Img;
import com.jk.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;


@WebService
@Component("imgService")
public class ImgServiceImpl implements ImgService{
    @Autowired
    private RoleMapper roleDao;
    public List<Img> selectImgList() {
        return roleDao.selectImgList();
    }
}