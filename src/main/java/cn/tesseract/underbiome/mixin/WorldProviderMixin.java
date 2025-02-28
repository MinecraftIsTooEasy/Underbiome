package cn.tesseract.underbiome.mixin;

import cn.tesseract.underbiome.world.WorldProviderUnderbiome;
import net.minecraft.WorldProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldProvider.class)
public class WorldProviderMixin {
    @Inject(method = "getProviderForDimension", at = @At("HEAD"), cancellable = true)
    private static void getProviderForDimension(int dim, CallbackInfoReturnable<WorldProvider> cir) {
        if (dim == -2)
            cir.setReturnValue(new WorldProviderUnderbiome());
    }
}
