package cn.tesseract.underbiome.biome;

import net.minecraft.Block;

import java.util.Random;

public class BiomeMyceliumPatches extends BiomeGenUnderBase {
    public BiomeMyceliumPatches(int id) {
        super(id);
    }


    public void buildSurface(int index, byte[] blocks, Random random) {
        if (random.nextInt(3) == 0)
            blocks[index] = (byte) Block.mycelium.blockID;
    }
}
