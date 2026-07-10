# Rainforest Kongra Ecosystem

A Minecraft Fabric mod (1.20.1) that turns the jungle into a deadly rainforest.

## What this mod adds

- **Deadly rainforest rain** — If you stand out in the rain in a jungle/rainforest biome (jungle, sparse jungle, bamboo jungle) for too long, you begin to lose life every couple of seconds.
- **KONGRA armor** — Crafted from the hardest-to-find rainforest materials (Kongra Scales, Fangs, Jungle Essence). Wearing the **full 4-piece set** protects you completely from the rainforest rain and gives you a fighting chance against the boss.
- **KONGRA — The Big Boss** — Body of a gorilla, head of a King Cobra. 300 HP, poison bite, huge knockback, and a boss health bar. Without KONGRA armor, you don't stand a chance.
- **Rainforest animals** — Rainforest Jaguar and colorful Rainforest Macaw.

All content is available in the "Rainforest Kongra" creative tab (spawn eggs included for the boss and animals).

---

## How to get the mod .jar — GitHub builds it for FREE (no Java install needed!)

You do **not** need to install Java or any build tools. GitHub will compile the mod for you in the cloud.

### Step-by-step

1. **Create a GitHub account** at https://github.com (free).
2. Click the **+** in the top-right → **New repository**. Give it any name (e.g. `rainforest-kongra`). Click **Create repository**.
3. On the new empty repo page, click the link that says **"uploading an existing file"**.
4. **Extract the ZIP** you downloaded (the one containing all these files) on your computer.
5. **macOS users — IMPORTANT:** The `.github` folder is **invisible by default** in Finder. In Finder, press **Cmd + Shift + .** (period) to show hidden files. If you skip this, the build workflow will **not** be uploaded and the build will **never run**.
6. Open the **extracted folder**. Select **ALL files and folders INSIDE it** — including the hidden `.github` folder, `build.gradle`, `gradle.properties`, `settings.gradle`, the `src` folder, etc.
   - **Drag the CONTENTS, not the folder itself.** Do not drag the outer folder — drag everything inside it into the GitHub upload area.
7. Scroll down and click **Commit changes**.
8. Click the **Actions** tab at the top of your repo. You'll see a build running.
9. Wait about **2 minutes** for it to finish (green checkmark).
10. Click the completed build run, scroll to **Artifacts**, and download **mod-jar**.
11. Unzip it — inside is your mod `.jar` (ignore any `-sources.jar` or `-dev.jar`).
12. Copy the `.jar` into your Minecraft mods folder:
    - Windows: `%appdata%\.minecraft\mods`
    - macOS: `~/Library/Application Support/minecraft/mods`
    - Linux: `~/.minecraft/mods`

You'll need the **Fabric Loader** and **Fabric API** installed for Minecraft 1.20.1.

---

## Tips

- To try the boss, use the **Kongra Spawn Egg** from the creative tab.
- Craft or grab **all four KONGRA armor pieces** and wear them before facing him — the full set stops the rain damage and dramatically boosts your protection.
- The rain only hurts you when you're **exposed to the open sky** in a rainforest biome while it's raining.