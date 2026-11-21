package net.tablesouls.ts_ui_lib.mixin.preview;

import com.mojang.blaze3d.vertex.PoseStack;
import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.utils.math.MathUtils;
import yesman.epicfight.api.utils.math.OpenMatrix4f;

@Mixin(value = MathUtils.class, remap = false)
public abstract class EpicFightMulStackNormalMixin {

    @Inject(
        method = "mulStack(Lcom/mojang/blaze3d/vertex/PoseStack;Lyesman/epicfight/api/utils/math/OpenMatrix4f;)V",
        at = @At("TAIL")
    )
    private static void ts_ui_lib$fixNormals(PoseStack poseStack, OpenMatrix4f matrix, CallbackInfo ci) {
        if (!PlayerModelPreviewRenderer.isRenderingPreview()) return;

        Matrix4f m = OpenMatrix4f.exportToMojangMatrix(matrix);
        Matrix3f normal = new Matrix3f(m).invert().transpose();
        poseStack.last().normal().mul(normal);
    }
}