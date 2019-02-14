package com.arena.sm.api;

import com.arena.common.resp.CmmRespCode;
import com.arena.common.resp.R;
import com.arena.sm.model.SysDict;
import com.arena.sm.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 字典管理对外公开API
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping("/rest/dict")
public class SysDictController extends RestApiController {

	@Autowired
	private ISysDictService sysDictService;

	/**
	 * 通过id获取字典
	 */
	@ResponseBody
	@GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public R<SysDict> findById(@PathVariable("id") String id) {
		SysDict dict = sysDictService.queryDictById(id);
		return ((R<SysDict>) CmmRespCode.SUCCESS.buildRespCode()).setRspBody(dict);
	}
}
