package cn.tesseract.underbiome.biome;

import net.minecraft.BiomeGenUnderworld;
import org.joml.SimplexNoise;

import java.util.Random;

public abstract class BiomeGenUnderBase extends BiomeGenUnderworld {

    public BiomeGenUnderBase(int id) {
        super(id);
    }

    public void buildSurface(int index, byte[] blocks, Random random) {
    }
}
