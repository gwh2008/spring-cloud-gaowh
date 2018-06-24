package com.itmuch.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.itmuch.cloud.study.domain.User;
import com.itmuch.cloud.study.repository.UserRepository;
import java.util.List;

/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author gaowh
 */
@RestController
//@RequestMapping(value = "/user")
public class UserController {
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private UserRepository userRepository;

  /**
   * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
   * @RequestMapping(value = "/id", method = RequestMethod.GET)
   * 类似的注解还有@PostMapping等等
   * @param id
   * @return user信息
   */
  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    User findOne = this.userRepository.findOne(id);
    return findOne;
  }

  /**
   * 查询用户列表方法
   * @return
   */
  @RequestMapping(value ="/list" ,method = RequestMethod.GET)
  public List<User> list(){
    return userRepository.findAll();
  }

  /**
   * 添加、更新用户方法
   * @param entity
   * @return
   */
  @RequestMapping(value = "/save",method = RequestMethod.GET)
  public User save(User entity)
  {
    return userRepository.save(entity);
  }

  /**
   * 删除用户方法
   * @param id 用户编号
   * @return
   */
  @RequestMapping(value = "/delete",method = RequestMethod.GET)
  public List<User> delete(Long id)
  {
    userRepository.delete(id);
    return userRepository.findAll();
  }
  /**
   * 本地服务实例的信息
   * @return
   */
  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }
}
