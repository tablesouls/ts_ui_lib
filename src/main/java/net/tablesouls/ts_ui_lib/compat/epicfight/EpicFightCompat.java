package net.tablesouls.ts_ui_lib.compat.epicfight;

import net.minecraftforge.fml.ModList;

public class EpicFightCompat {
    public static final String MODID = "epicfight";
    public static final boolean LOADED = ModList.get().isLoaded(MODID);
}