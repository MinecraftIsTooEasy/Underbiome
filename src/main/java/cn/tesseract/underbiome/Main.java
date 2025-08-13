package cn.tesseract.underbiome;

import cn.tesseract.underbiome.biome.BiomeDeepCold;
import cn.tesseract.underbiome.biome.BiomeUndergarden;
import cn.tesseract.underbiome.biome.GenLayerUnderbiome;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    public static final String MOD_ID = "underbiome";

    @Override
    public void onInitialize() {
        //GenLayerUnderbiome.biomes.add(new BiomeLushCave(70), 20);
        //GenLayerUnderbiome.biomes.add(new BiomeUndergarden(71), 20);
        GenLayerUnderbiome.biomes.add(new BiomeDeepCold(72), 20);
    }
}