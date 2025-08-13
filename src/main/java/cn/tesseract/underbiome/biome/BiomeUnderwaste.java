package cn.tesseract.underbiome.biome;

import net.minecraft.World;

import java.util.Random;

public class BiomeUnderwaste extends BiomeUnderworldBase {
    public BiomeUnderwaste(int id) {
        super(id);
    }

    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }
}
