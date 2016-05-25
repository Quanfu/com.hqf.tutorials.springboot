package com.hqf.tutorials.springboot.dao;

import com.hqf.tutorials.springboot.models.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by huoquanfu on 2016/5/25.
 * 在CrudRepository自带常用的crud方法.
 * 这样一个基本dao就写完了.
 */
public interface DemoRepository extends CrudRepository<Demo, Long> {


}
