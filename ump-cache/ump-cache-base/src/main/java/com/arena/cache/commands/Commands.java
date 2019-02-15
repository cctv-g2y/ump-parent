package com.arena.cache.commands;

import com.arena.cache.commands.support.*;

/**
 * redis 操作命令集
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface Commands
		extends HashCommands, KeyCommands, ListCommands, SetCommands, SortedSetCommands, StringCommands {
}
