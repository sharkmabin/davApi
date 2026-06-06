# davApi

DavApplication -- 基于模块化架构的 Android 多媒体影音应用，支持视频、图片浏览等功能。

## 功能概述

- **模块化架构**：自定义 ModuleManager 从 assets 读取模块配置，动态加载各业务模块
- **首页推荐**：从远程 Host 配置接口获取 API 地址，加载视频/图片列表并展示
- **视频播放**：集成 DKPlayer（含 IjkPlayer），支持完整的播放控制和视频缓存
- **图片浏览**：Photo 模块提供图片查看功能
- **底部导航**：通过 BottomNavigationView 实现首页、电影、图片、阅读、用户等多 Tab 切换
- **ARouter 路由**：使用阿里巴巴 ARouter 实现模块间页面跳转和服务调用
- **网络层**：基于 Retrofit + RxJava + OkHttp 的网络请求架构
- **注解处理器**：自定义编译时注解（EFModuleAnnotation）和 Processor 用于模块化代码生成

## 项目结构

| 目录/模块 | 说明 |
|------|------|
| `app/` | 主应用入口，HomeApplication 和 AndroidManifest |
| `framework_lib/` | 基础框架库 -- BaseApplication、ModuleManager、日志、ECS 打印系统 |
| `dav_common_model/` | 通用模型层 -- BaseFragment、BaseService、网络封装、工具类 |
| `router_lib/` | 路由接口定义 -- RouterPath、IHomeProvider、IMovieProvider、IPhotoProvider 等 |
| `home_module/` | 首页模块 -- HomeFragment、视频列表适配器、Host 配置加载 |
| `movie_module/` | 电影/视频模块 -- MovieFragment |
| `photo_module/` | 图片模块 -- PhotoFragment |
| `main_module/` | 主界面模块 -- MainActivity（BottomNavigationView 多 Tab 切换） |
| `main_annotations/` | 自定义注解 -- @EFModuleAnnotation |
| `processor_lib/` | 注解处理器 -- ModuleCompiler，编译时扫描注解生成模块代理代码 |
| `dkplayer-java/` | DKPlayer 核心库 -- VideoView、播放器抽象、手势控制、渲染 |
| `dkplayer-ui/` | DKPlayer UI 组件 -- StandardVideoController、VodControlView 等 |
| `dkplayer-players/ijk/` | IjkPlayer 播放器适配 |
| `dkplayer-videocache/` | 视频缓存 -- HTTP 代理缓存，支持 LRU 策略 |
| `promptlibrary/` | 弹窗提示库 -- PromptDialog、PromptView 等提示组件 |
| `test.json` | 本地测试用的 Host 配置 JSON |

## 技术栈

- **语言**：Java
- **平台**：Android
- **最低 SDK**：API 16 (Android 4.1)
- **目标 SDK**：API 30 (Android 11)
- **构建工具**：Gradle 4.0.1 + Android Gradle Plugin
- **核心依赖**：
  - **路由**：ARouter（1.5.0）
  - **网络**：Retrofit 2.9.0 + OkHttp 3.14.9 + RxJava 2.x + Gson
  - **UI**：Android Support Library 28.0.0（AppCompat、Design、RecyclerView、ConstraintLayout）
  - **图片加载**：Glide 3.7.0
  - **日志**：Logger 2.2.0
  - **工具**：xUtils 3.9.0
  - **视频播放**：DKPlayer + IjkPlayer + VideoCache

## 构建 / 运行

1. 用 Android Studio 打开项目根目录
2. Gradle Sync 下载依赖（使用阿里云 Maven 镜像）
3. 选择 app 模块运行到设备或模拟器
4. 应用启动后从远程 Host 配置拉取内容 API 地址并加载首页数据

构建产物命名格式：`davApp_V{versionName}_Build{yyyyMMdd}.apk`（当前版本 1.1.0）

## 说明

### 模块化设计

项目采用自定义模块化方案，通过 `ModuleManager` 扫描 assets 目录下以 `CC_Module_` 为前缀的 JSON 配置文件，动态加载各模块的 `IApplicationDelegate` 实现。每个模块可独立调试（`isModule` 开关控制），通过 ARouter 进行模块间通信。

### 动态 Host 配置

应用启动时从 `config.gradle` 中配置的远程 URL（默认指向 `https://gitee.com/mabinbin/davApi/raw/master/host.json`）拉取 Host 配置，获取实际的影视、图片等 API 地址，实现服务端地址的动态切换。

### 项目名称

项目根名为 `DavApplication`，包名 `com.mabin.dav.application`。dav 并非 WebDAV 协议，而是项目代码名（推测为 "Display Audio Video" 缩写）。
