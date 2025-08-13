package cn.tesseract.underbiome.util;

import net.minecraft.ChunkPosition;

import java.util.Random;

public class DecoratorRandom {
    public final Random random;
    public final int x;
    public final int z;

    public DecoratorRandom(Random random, int x, int z) {
        this.random = random;
        this.x = x;
        this.z = z;
    }

    public ChunkPosition next() {
        return new ChunkPosition(x + random.nextInt(16) + 8, 0, z + random.nextInt(16) + 8);
    }
}
