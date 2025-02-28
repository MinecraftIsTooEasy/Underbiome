package cn.tesseract.underbiome;

import cn.tesseract.underbiome.biome.BiomeMyceliumPatches;
import cn.tesseract.underbiome.biome.GenLayerUnderbiome;
import net.fabricmc.api.ModInitializer;
import net.minecraft.BiomeGenBase;

public class Main implements ModInitializer {
    public static final String MOD_ID = "underbiome";
    public static final BiomeGenBase myceliumPatches = new BiomeMyceliumPatches(70);

    @Override
    public void onInitialize() {
        GenLayerUnderbiome.biomes.add(myceliumPatches, 20);
    }
}