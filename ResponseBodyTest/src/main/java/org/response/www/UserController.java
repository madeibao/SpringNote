package org.response.www;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 22:36
 * @Description TODO
 * @Version 1.0
 **/

@RestController
public class UserController {

    Map<Long, UserDto> userDtoMap = new ConcurrentHashMap<>();

    {
        userDtoMap.put(1L, new UserDto(1L, "路人", 30));
        userDtoMap.put(2L, new UserDto(2L, "张三", 20));
        userDtoMap.put(3L, new UserDto(3L, "李四", 18));
    }

    @GetMapping("/user/list.do")
    public ResultDto<Collection<UserDto>> list() {
        return ResultDto.success(this.userDtoMap.values());
    }

    @GetMapping("/user/{id}.do")
    public ResultDto<UserDto> user(@PathVariable("id") Long id) {
        return ResultDto.success(this.userDtoMap.get(id));
    }

}