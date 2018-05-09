/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImgService
 * Author:   zlh
 * Date:     2018/4/30 23:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.Img;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ImgService {
    @WebMethod
    List<Img> selectImgList();
}