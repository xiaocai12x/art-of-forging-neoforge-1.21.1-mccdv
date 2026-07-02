# MCCDV NeoForge 1.21.1 Port Notes

This folder is the MCCDV port of Art of Forging for Minecraft 1.21.1 / NeoForge 21.1.x.

## Build

Use Java 21:

```powershell
.\gradlew.bat --no-daemon build
```

The NeoForge build file is `build-neoforge.gradle`; `settings.gradle` points Gradle to it.

## Tetra dependency

The build looks for dependencies in this order:

1. `libs/tetra-1.21.1-6.13.0.jar` and `libs/mutil-1.21.1-6.3.1.jar`
2. `../../tetra-port/tetra/build/libs/tetra-1.21.1-6.13.0.jar` and `../../tetra-port/mutil/build/libs/mutil-1.21.1-6.3.1.jar`

For GitHub Actions, either commit/copy the two jars into `libs/`, or build the local `tetra-port` projects before building this addon.

## Porting choices

- ForgeGradle was replaced with `net.neoforged.moddev`.
- `mods.toml` is excluded; `META-INF/neoforge.mods.toml` is used.
- Forge `RegistryObject` usage was migrated to NeoForge `DeferredHolder`.
- Old Forge player capabilities were replaced by `AoFPlayerData`, a small runtime player-state helper. This preserves compile-time call sites and can later be upgraded to NeoForge attachments for persistence.
- Old Forge `SimpleChannel` packet code was stubbed as a no-op compatibility layer. The affected feature is client particle sync for a small set of effects; gameplay math still runs.
