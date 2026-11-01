# MC 64-bit Farlands

Pushing Minecraft beyond 30,000,000. This mod rewrites core coordinate math and chunk generation to bring true 64-bit limits to modern versions.

## Overview

MC 64-bit Farlands is an experimental Minecraft modification focused on removing the traditional world-size limits imposed by 32-bit coordinate math. The project targets the core gameplay and generation systems that normally break down around large coordinate values and aims to extend those limits toward true 64-bit range support.

This repository contains the codebase and supporting resource files for that effort, including the game-side class tree and localization assets.

## Key Goals

- Extend world coordinates beyond the standard 30,000,000 barrier
- Rewrite the core coordinate logic used by Minecraft world generation and movement
- Improve compatibility with large-world gameplay and chunk handling
- Push modern versions of Minecraft toward true 64-bit world limits

## Repository Layout

- `lang/` — language resource files
- `net/` — Minecraft-related code structure
- compiled `.class` files — generated Java class artifacts for the project

## Technology Notes

This project is centered around low-level Minecraft internals. It is not a typical end-user mod packaging repository and may require a matching toolchain, deobfuscation workflow, or loader setup depending on how it is being built or run.

## Status

This project is best understood as an ambitious experimental engineering effort: the idea is to rework the assumptions that limit Minecraft's world size and push them to a much larger coordinate domain.

## License

This repository does not currently include a license file. If you are using or distributing this project, confirm the intended licensing terms before publishing or redistributing any code or assets.

## Contributing

Contributions are welcome if you are working on core coordinate math, chunk generation, compatibility patches, or related large-world improvements. Please ensure any changes remain consistent with the project's intended 64-bit world objective.
