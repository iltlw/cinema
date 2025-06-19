# 星幕影院

## 注意
## 一、开发者注意事项
### 1.
开发者向此仓库推送时，请先新建一个自己的分支，待自己的分支形成一个稳定版本之后，再合并到master分支。

### 2.
如果发现自己的分支（远程或本地）和主分支差距过大，可以先将主分支签出到本地，在本地协调主分支和自己的分支的冲突。

如果发现主分支无法运行，请先按以下步骤检查和处理：

(1) 首先确认正确签出了主分支最新版本（如不方便直接与本地自己的master分支合并，可在本地以自己的master分支为基础新建一个其他名称的分支，但一定要确保master分支是直接强制签出的，保证文件与远程一致）。

(2) 阅读README.md中的“二、运行前须知”部分并做相应调整。

(3) 尝试刷新本地Maven状态，确保本地依赖包和pom.xml文件中的一致。

(4) 尝试在浏览器中按Ctrl+F5强制刷新页面，或在浏览器设置中清除缓存。

(5) 如果以上方法都无效，请尝试在新目录中重新克隆仓库。

## 二、运行前须知
### 1.
本项目推荐使用的开发工具版本：Tomcat 11.0+, JDK 21+, IntelliJ IDEA 2025+, MySQL 8.0+（版本符合要求的必要性从高到低依次递减）。

### 2.
运行Web应用前需要运行src/main/sql目录下的SQL文件，创建数据库表和视图并插入数据。如果发现本地数据库与SQL文件中的不一致，请先删除本地所有（或冲突的）数据库表，再重新运行SQL文件。

### 3.
src/main/resources目录下的xxx.example是xxx文件的模板（例如jdbc.properties.example是jdbc.properties文件的模板），使用前请新建一个xxx.example文件的副本并命名为xxx，并且将xxx文件中的内容改为适合你本地环境的相应内容。

【不要直接重命名xxx.example，因为Git会默认跟踪仓库中已存在的文件并造成提交时xxx.example被删除（除非你不参与此项目的开发，或保证每次提交时不包括xxx.example文件的删除）。】

### 4.
本项目Tomcat的配置中，“应用程序上下文”一项为空，“URL”一项的域名和端口号后面没有任何内容。

#### 介绍
{**以下是 Gitee 平台说明，您可以替换此简介**
Gitee 是 OSCHINA 推出的基于 Git 的代码托管平台（同时支持 SVN）。专为开发者提供稳定、高效、安全的云端软件开发协作平台
无论是个人、团队、或是企业，都能够用 Gitee 实现代码托管、项目管理、协作开发。企业项目请看 [https://gitee.com/enterprises](https://gitee.com/enterprises)}

#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
