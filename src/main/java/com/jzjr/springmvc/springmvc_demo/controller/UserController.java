package com.jzjr.springmvc.springmvc_demo.controller;

import com.jzjr.springmvc.springmvc_demo.constants.ServiceExceptionEnum;
import com.jzjr.springmvc.springmvc_demo.core.exception.ServiceException;
import com.jzjr.springmvc.springmvc_demo.dto.UserAddDTO;
import com.jzjr.springmvc.springmvc_demo.dto.UserUpdateDTO;
import com.jzjr.springmvc.springmvc_demo.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("/list") // URL 修改成 /list
    public List<UserVO> list() {
        // 查询列表
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("moko"));
        result.add(new UserVO().setId(2).setUsername("sandy"));
        result.add(new UserVO().setId(3).setUsername("alen"));
        // 返回列表
        return result;
    }

    /**
     * 获得指定用户编号的用户
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get") // URL 修改成 /get
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    /**
     * 添加用户
     *
     * @param addDTO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("add") // URL 修改成 /add
    public Integer add(UserAddDTO addDTO) {
        log.info(addDTO.getUsername());
        log.info(addDTO.getPassword());
        // 插入用户记录，返回编号
        Integer returnId = UUID.randomUUID().hashCode();
        // 返回用户编号
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PutMapping("/update") // URL 修改成 /update ，RequestMethod 改成 POST
    public Boolean update(UserUpdateDTO updateDTO) {
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    /**
     * 删除指定用户编号的用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete") // URL 修改成 /delete ，RequestMethod 改成 DELETE
    public Boolean delete(@RequestParam("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }


    /**
     * 测试抛出 NullPointerException 异常
     */
    @GetMapping("/exception-01")
    public UserVO exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     */
    @GetMapping("/exception-02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }


    @GetMapping("/do_something")
    public void doSomething() {
        log.info("未来去火星");
    }

    @GetMapping("/current_user")
    public UserVO currentUser() {
        log.info("[人造机器人Robot001称为智慧生命体]");
        return new UserVO().setId(10).setUsername(UUID.randomUUID().toString());
    }


    @GetMapping("/exception-03")
    public void exception03() {
        log.info("[人类文明面临威胁]");
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }
}
