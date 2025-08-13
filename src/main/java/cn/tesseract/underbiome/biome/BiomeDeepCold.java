package cn.tesseract.underbiome.biome;

import cn.tesseract.underbiome.structure.DecoIceSpike;
import cn.tesseract.underbiome.util.DecoratorRandom;
import net.minecraft.Block;
import net.minecraft.ChunkPosition;
import net.minecraft.World;

import java.util.Random;

public class BiomeDeepCold extends BiomeUnderworldBase {
    public BiomeDeepCold(int id) {
        super(id);
        setEnableSnow();
        setTemperatureRainfall(0.0F, 0.5F);
    }

    public void buildSurface(int index, byte[] blocks, Random random) {
        blocks[index + 1] = (byte) Block.snow.blockID;
    }

    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        DecoratorRandom dec = new DecoratorRandom(random, chunk_origin_x, chunk_origin_z);
        DecoIceSpike ice = new DecoIceSpike();
        for (int i = 0; i < random.nextInt(10); i++) {
            ChunkPosition pos = dec.next();
            ice.generate(world, random, pos.x, 160, pos.z);
        }
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }
}
