# NOTICE

## 项目来源

本仓库是 `Art of Forging` 的 MCCDV NeoForge 1.21.1 迁移分支。

原项目：

- 名称：Art of Forging
- 原作者：Acetheeldritchking, MindFaer
- 原项目说明：Tetra addon
- 原项目元数据许可证：MIT

本仓库包含针对 Minecraft 1.21.1 / NeoForge 21.1.233 / Java 21 的迁移改动。

## 本迁移分支的主要改动

- ForgeGradle -> NeoForge ModDev Gradle。
- Forge 1.20.1 API -> NeoForge 1.21.1 API。
- 旧 Forge capability -> `AoFPlayerData` 运行期玩家状态层。
- 旧 Forge `SimpleChannel` 网络层 -> no-op 兼容层。
- 资源包格式、注册表、事件类、MobEffect 字段等 1.21.1 兼容修正。

## 许可证说明

本项目源码按 MIT 协议发布，见 [LICENSE](./LICENSE)。

MIT 协议允许复制、修改、发布、再授权和商业使用，但必须保留版权声明和许可证文本。

## 第三方依赖说明

本仓库构建时依赖 Tetra、Mutil、Curios、NeoForge、Minecraft 等第三方项目或运行环境。

这些依赖不因本仓库使用 MIT 协议而改变其自身许可证。尤其注意：

- 如果只在 Gradle 构建时引用外部依赖，不需要把这些依赖的源码并入本仓库。
- 如果为了 GitHub Actions 编译，把 `tetra-1.21.1-6.13.0.jar`、`mutil-1.21.1-6.3.1.jar` 或其他 jar 放进 `libs/` 并提交到仓库，需要同时保留对应项目的许可证和来源说明。
- 不应把第三方 jar 声明为本项目原创代码。

## 非官方声明

本迁移分支不是原作者官方版本，也不是 Tetra 官方版本。发布时建议在仓库描述中明确写出“unofficial port / 非官方迁移版”。
