package com.arena.sm.api;

import com.arena.common.resp.CmmRespCode;
import com.arena.common.resp.R;
import com.arena.sm.model.SysUser;
import com.arena.sm.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理对外公开API
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping("/rest/user")
public class SysUserController extends RestApiController {

	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 通过id获取字典
	 */
	@ResponseBody
	@GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public R<SysUser> findById(@PathVariable("id") String id) {
		SysUser user = sysUserService.selectById(id);
		return ((R<SysUser>) CmmRespCode.SUCCESS.buildRespCode()).setRspBody(user);
	}
}
