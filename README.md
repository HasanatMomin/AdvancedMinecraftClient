# 🍁 Maple Client - Advanced Minecraft 26.1.2 Forge Client

## Overview
A professional, production-ready Minecraft 26.1.2 Forge client mod with 17+ customizable visual mods, professional GUI, and maximum FPS optimization.

## Requirements
- **Java**: JDK 25 (C:\Program Files\Bellsoft)
- **Minecraft**: 26.1.2
- **Forge**: Latest for 26.1.2

## Building
```bash
./gradlew build
```

**Output**: `build/libs/MapleClient-1.0.jar`

## Features

### ✅ All 17+ Mods Implemented

**Display Mods (9)**:
- ⚡ FPS Display - Real-time FPS counter
- 📡 Ping Display - Server latency indicator
- 🖱️ CPS Display - Separate Left/Right CPS tracking
- ⌨️ Keystrokes - WASD keyboard visualization
- 📍 Coordinates - XYZ position + direction
- 🧪 Potion Effects - Active potions with timers
- 🛡️ Armor Status - Durability with color coding
- 🎯 Reach Display - Last hit distance
- 💥 Combo Counter - Hit counter (resets on damage)

**Gameplay Mods (4)**:
- 🏃 Toggle Sneak/Sprint - R key sprint, CTRL sneak
- 🔍 Zoom - Z key zoom (2x-5x adjustable)
- ☀️ Full Bright - Brightness adjustment (0-100%)
- 🛡️ Hurt Cam Disable - No camera shake on damage

**Entity Mods (4)**:
- 📛 Nametags - Player nametag display
- ✕ Crosshair - Customizable crosshair
- □ Block Outline - Block highlighting
- ⬛ Hitbox Display - Player hitbox visualization

### ✅ Custom GUI System
- 🍁 Maple Client Title Screen
- Right Shift Client Settings overlay
- Tab interface (Mods + Settings)
- Background blur effect
- Professional animations

### ✅ Performance Optimization
- 10-level performance slider (6 to 360+ FPS)
- JVM G1GC tuning (Java 25)
- Render distance optimization
- Particle density control
- Cloud/weather toggle

### ✅ Custom Cape System
- PNG loader from: `C:\Users\lavas\Downloads\cape_texture.png`
- F5 (3rd person) camera rendering only
- Enabled by default
- Physics animations

### ✅ Persistent Configuration
- JSON-based settings
- Auto-save on changes
- Per-mod customization
- Location: `./config/mapleclient/settings.json`

## Keybinds

| Key | Action |
|-----|--------|
| **Right Shift** | Open Client Settings |
| **Z** | Toggle Zoom |
| **R** | Toggle Sprint |
| **CTRL** | Toggle Sneak |

## Installation

1. Build the mod: `./gradlew build`
2. Copy `build/libs/MapleClient-1.0.jar` to your mods folder
3. Launch Minecraft with Forge
4. Press **Right Shift** in-game to open Maple Client Settings

## Features Status

| Feature | Status |
|---------|--------|
| 17+ Mods | ✅ Complete |
| GUI System | ✅ Complete |
| Cape System | ✅ Complete |
| Event Integration | ✅ Complete |
| Performance Slider | ✅ Complete |
| JVM Tuning | ✅ Complete |
| Configuration | ✅ Complete |
| Build System | ✅ Ready |

## License
Proprietary - Maple Client

---

**🍁 Maple Client - Professional Minecraft Customization 🍁**