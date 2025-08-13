package cn.tesseract.underbiome.biome;

import net.minecraft.BiomeGenUnderworld;
import net.minecraft.World;

import java.util.Random;

public abstract class BiomeUnderworldBase extends BiomeGenUnderworld {
    public BiomeUnderworldBase(int id) {
        super(id);
    }

    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        this.theBiomeDecorator.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }

    public void buildSurface(int index, byte[] blocks, Random random) {

    }

    public void buildCelling(int index, byte[] blocks, Random random) {
    }
}
