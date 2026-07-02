# 上传到 GitHub 说明

## 推荐仓库名

建议仓库名：

```text
art-of-forging-neoforge-1.21.1-mccdv
```

建议仓库描述：

```text
Unofficial MCCDV NeoForge 1.21.1 port of Art of Forging, a Tetra addon.
```

## 上传前检查

上传前建议确认：

- [ ] `README.md` 为中文说明。
- [ ] `LICENSE` 存在，且为 MIT 协议。
- [ ] `NOTICE.md` 已说明原项目、迁移改动、第三方依赖与非官方性质。
- [ ] `.github/workflows/build.yml` 存在。
- [ ] 不上传 `.gradle/`、`build/`、`.gradle-user-home*`。
- [ ] 如果上传 `libs/` 中的 Tetra/Mutil jar，需要同时保留对应依赖的许可证和来源说明。

## 使用 GitHub CLI 创建仓库

如果本机已登录 `gh`：

```bash
git init
git add .
git commit -m "Port Art of Forging to NeoForge 1.21.1"
gh repo create art-of-forging-neoforge-1.21.1-mccdv --public --source . --remote origin --push
```

如果要建私有仓库，将 `--public` 改为 `--private`。

## 依赖 jar 说明

GitHub Actions 编译前必须能找到：

- `libs/tetra-1.21.1-6.13.0.jar`
- `libs/mutil-1.21.1-6.3.1.jar`

或者修改 workflow，在构建本项目之前先构建/下载 MCCDV 的 Tetra 与 Mutil。
