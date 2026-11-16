package net.tablesouls.ts_ui_lib.mixin.preview.emfcompat;

import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "strm.emfcompat.core.EMFCompatAnimationHook", remap = false)
public abstract class EMFCompatAnimationHookMixin {

    @Inject(method = "onAnimationEnd", at = @At("HEAD"), cancellable = true, remap = false)
    private void ts_ui_lib$skipRestoreInPreview(CallbackInfo ci) {
        if (PlayerModelPreviewRenderer.isRenderingPreview()) {
            ci.cancel();
        }
    }

    @Inject(method = "onBipedPoseCopyEnd", at = @At("HEAD"), cancellable = true, remap = false)
    private void ts_ui_lib$skipArmourCopyInPreview(CallbackInfo ci) {
        if (PlayerModelPreviewRenderer.isRenderingPreview()) {
            ci.cancel();
        }
    }
}