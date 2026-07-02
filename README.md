# Art of Forging - MCCDV NeoForge 1.21.1 迁移版

这是 `Art of Forging` 的 MCCDV 服务器迁移分支，目标环境为：

- Minecraft `1.21.1`
- NeoForge `21.1.233`
- Java `21`
- Tetra `1.21.1-6.13.0`
- Mutil `1.21.1-6.3.1`

本仓库不是上游官方发布版本，而是为了 MCCDV S7 服务器将原本面向 Forge 1.20.1 的 Tetra 附属迁移到 NeoForge 1.21.1 的适配版本。

## 当前状态

已完成的迁移工作：

- ForgeGradle 迁移到 `net.neoforged.moddev`。
- `mods.toml` 迁移到 `META-INF/neoforge.mods.toml`。
- Java 目标版本升级到 21。
- 物品、效果、创造模式标签页、loot modifier 等注册逻辑迁移到 NeoForge 注册体系。
- 旧 Forge 事件包名迁移到 NeoForge 事件包名。
- 旧 Forge capability 调用替换为 `AoFPlayerData` 运行期玩家状态层。
- 旧 Forge `SimpleChannel` 网络层暂时替换为 no-op 兼容层。
- 资源 JSON 已做语法解析检查。
- NeoForge import 已对照本地 `neoforge-21.1.233-universal.jar` 做存在性检查。
- Tetra/Mutil import 已对照本地 1.21.1 Tetra/Mutil 源码做存在性检查。

尚未完成或需要 GitHub Actions / 本地 Gradle 编译继续确认的事项：

- Curios 9 API 的方法签名仍需通过实际编译确认。
- Tetra GUI/stat API 的方法签名仍需通过实际编译确认。
- no-op 网络层会导致部分客户端粒子同步暂时不可用。
- `AoFPlayerData` 目前只保存运行期状态，后续如需跨重登持久化，应迁移到 NeoForge Attachment。

## 构建

使用 Java 21：

```bash
./gradlew --no-daemon build
```

Windows：

```powershell
.\gradlew.bat --no-daemon build
```

## Tetra / Mutil 依赖

本项目依赖 MCCDV 已迁移的 Tetra / Mutil jar。构建脚本会按以下顺序查找：

1. 当前仓库内：
   - `libs/tetra-1.21.1-6.13.0.jar`
   - `libs/mutil-1.21.1-6.3.1.jar`
2. 工作区相对路径：
   - `../../tetra-port/tetra/build/libs/tetra-1.21.1-6.13.0.jar`
   - `../../tetra-port/mutil/build/libs/mutil-1.21.1-6.3.1.jar`

如果把本项目单独作为 GitHub 仓库，建议将上述两个依赖 jar 放入 `libs/`，或者在 GitHub Actions 中先构建/下载 Tetra 与 Mutil。

## 开源协议

原 `Art of Forging` 项目元数据标注为 MIT 协议，原作者为 `Acetheeldritchking, MindFaer`。本迁移分支继续按 MIT 协议发布。

请保留：

- [LICENSE](./LICENSE)
- [NOTICE.md](./NOTICE.md)

如果仓库中额外提交 `libs/` 里的第三方 jar，请同时确认并保留那些 jar 对应项目的许可证与来源说明。不要把第三方 jar 当作本项目 MIT 代码的一部分重新授权。

## 免责声明

这是社区适配分支，不代表原作者或 Tetra 官方维护。用于服务器前请先在测试服验证启动、数据包加载、物品注册、战斗效果和 Curios 兼容性。
