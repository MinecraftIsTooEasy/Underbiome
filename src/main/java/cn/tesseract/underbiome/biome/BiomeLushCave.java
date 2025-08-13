package cn.tesseract.underbiome.biome;

import cn.tesseract.underbiome.util.DecoratorRandom;
import net.minecraft.*;

import java.util.Random;

public class BiomeLushCave extends BiomeUnderworldBase {
    public BiomeLushCave(int id) {
        super(id);
    }

    public void buildSurface(int index, byte[] blocks, Random random) {
        if (random.nextInt(3) == 0)
            if (random.nextInt(5) == 0)
                blocks[index] = (byte) Block.cobblestoneMossy.blockID;
            else
                blocks[index] = (byte) Block.cobblestone.blockID;
    }

    public void buildCelling(int index, byte[] blocks, Random random) {
        this.buildSurface(index, blocks, random);
    }

    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        DecoratorRandom dec = new DecoratorRandom(random, chunk_origin_x, chunk_origin_z);
        for (int i = 0; i < random.nextInt(40); i++) {
            ChunkPosition pos = dec.next();
            for (int y = 250; y > 120; y--) {
                Block block = world.getBlock(pos.x, y, pos.z);
                EnumFace face = EnumFace.get(random.nextInt(4) + 2);
                if (random.nextInt(20) == 0 && block != null && block.blockMaterial == Material.stone && world.getBlockId(pos.x, y + 1, pos.z) == 0) {
                    for (int l = 1; l < 2 + random.nextInt(3); l++)
                        world.setBlock(pos.x, y + l, pos.z, Block.web.blockID);
                } else if (block != null && block.blockMaterial == Material.stone && world.getBlockId(pos.x, y - 1, pos.z) == 0) {
                    for (int l = 1; l < 10 + random.nextInt(40); l++)
                        if (Block.vine.canPlaceBlockOnSide(world, pos.x, y - 1, pos.z, face))
                            world.setBlock(pos.x, y - l, pos.z, Block.vine.blockID, Block.vine.getMetadataForFace(face), 4);
                }
            }
        }
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }
}
