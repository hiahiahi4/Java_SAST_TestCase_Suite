# Java_SAST_TestCase_Suite

## 简介
该测试套为针对SAST能力评测的Java语言测试集。其中包含55个测试用例，涵盖到Java语言多态、重载、反射、Json反序列化、Map、mybatis、lombok注解等代码段，以及常见的安全防护用例。

## 用例分布
该测试套中22个用例真实存在漏洞，34个用例通过一些防护措施之后，漏洞已经修复。

| 目录 | 用例个数 | 描述 |
| ---- | -------- | ---- |
| defense | 28 | 漏洞修复的代码 | 	
| generics | 2 | 多态 |
| json | 7 | Json反序列化（fastjson，jackson） |
| lombok | 2 | lombok注解 |
| map | 5 | Map相关操作 |
| mybatis | 3 | mybatis相关注解 |
| overLoad | 4 | 方法重载 |
| reflect | 4 | Java反射调用 |