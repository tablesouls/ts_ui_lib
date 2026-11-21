package net.tablesouls.ts_ui_lib.mixin.preview.parcool;

import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "com.alrex.parcool.client.animation.system.PlayerAnimator", remap = false)
public abstract class AnimationV4PreviewMixin {

    @Inject(method = "getCurrentTransformation", at = @At("HEAD"), cancellable = true, remap = false)
    private void ts_ui_lib$suppressForPreview(CallbackInfoReturnable<Object> cir) {
        if (PlayerModelPreviewRenderer.isRenderingPreview()) {
            cir.setReturnValue(null);
        }
    }
}