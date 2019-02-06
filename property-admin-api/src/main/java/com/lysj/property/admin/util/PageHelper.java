package com.lysj.property.admin.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class PageHelper {

    public static <T> Page<T> defaultPage(Class<T> clz) {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Page<T> page = new Page<>();
        long current = Long.getLong(Objects.requireNonNull(req.getAttribute("page")).toString());
        long size = Long.getLong(Objects.requireNonNull(req.getAttribute("size")).toString());
        return page.setCurrent(current)
                .setSize(size);
    }

}
