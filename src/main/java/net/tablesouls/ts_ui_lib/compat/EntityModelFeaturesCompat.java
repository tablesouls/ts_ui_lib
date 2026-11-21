package net.tablesouls.ts_ui_lib.compat;

import net.neoforged.fml.ModList;
import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;

import java.util.function.Function;

public class EntityModelFeaturesCompat {
    public static void init() {
        if (!ModList.get().isLoaded("entity_model_features")) return;
        try {
            Class<?> api = Class.forName("traben.entity_model_features.EMFAnimationApi");
            Function<Object, Boolean> pauseWhilePreviewing = entity -> PlayerModelPreviewRenderer.isRenderingPreview();
            api.getMethod("registerPauseCondition", Function.class).invoke(null, pauseWhilePreviewing);
        } catch (Throwable ignored) {}
    }
}
