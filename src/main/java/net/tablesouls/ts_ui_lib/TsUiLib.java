package net.tablesouls.ts_ui_lib;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TsUiLib.MODID)
public class TsUiLib {
    public static final String MODID = "ts_ui_lib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public TsUiLib(IEventBus modBus) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modBus.addListener(TsUiLib::onClientSetup);
        }
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(net.tablesouls.ts_ui_lib.compat.EntityModelFeaturesCompat::init);
    }
}