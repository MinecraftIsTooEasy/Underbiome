package cn.tesseract.underbiome.biome;

import cn.tesseract.underbiome.structure.WorldGenBlockBlob;
import cn.tesseract.underbiome.util.DecoratorRandom;
import net.minecraft.Block;
import net.minecraft.ChunkPosition;
import net.minecraft.Material;
import net.minecraft.World;

import java.util.Random;

public class BiomeUndergarden extends BiomeUnderworldBase {
    public BiomeUndergarden(int id) {
        super(id);
    }

    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        DecoratorRandom dec = new DecoratorRandom(random, chunk_origin_x, chunk_origin_z);
        WorldGenBlockBlob blob = new WorldGenBlockBlob(Block.cobblestoneMossy, 0);
        for (int i = 0; i < 4 + random.nextInt(6); i++) {
            ChunkPosition pos = dec.next();
            for (int y = 250; y > 120; y--) {
                if (world.getBlock(pos.x, y, pos.z) == Block.stone && world.getBlockId(pos.x, y + 1, pos.z) == 0) {
                    if (random.nextInt(4) == 0)
                        generateShrub(world, pos.x, y + 2, pos.z, random.nextInt(4) + 1, random);
                    else if (random.nextInt(2) == 0)
                        blob.generate(world, random, pos.x, y + 2, pos.z);
                    else {
                        int size = 2 + random.nextInt(3);
                        for (int m = -size; m < size; m++)
                            for (int n = -size; n < size; n++)
                                if (Math.sqrt(m * m + n * n) <= size && world.isAirBlock(pos.x + m, y + 1, pos.z + n) && world.isBlockSolid(pos.x + m, y, pos.z + n))
                                    world.setBlock(pos.x + m, y, pos.z + n, Block.grass.blockID);
                    }
                }
            }
        }
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }

    private void generateShrub(World world, int x, int y, int z, int size, Random rand) {
        int width = Math.min(size, 6);
        int height = size > 3 ? 2 : 1;

        for (int i = 0; i < size; i++) {
            int rX = rand.nextInt(width * 2) - width;
            int rY = rand.nextInt(height);
            int rZ = rand.nextInt(width * 2) - width;

            if (i == 0 && size > 4) {
                buildLeaves(world, x + rX, y, z + rZ, 3);
            } else if (i == 1 && size > 2) {
                buildLeaves(world, x + rX, y, z + rZ, 2);
            } else {
                buildLeaves(world, x + rX, y + rY, z + rZ, 1);
            }
        }
    }

    public void buildLeaves(World world, int x, int y, int z, int size) {
        if (world.isBlockSolid(x, y - 2, z)) {
            for (int i = -size; i <= size; i++) {
                for (int j = -1; j <= 1; j++) {
                    for (int k = -size; k <= size; k++) {
                        if (Math.abs(i) + Math.abs(j) + Math.abs(k) <= size) {
                            buildBlock(world, x + i, y + j, z + k, Block.leaves, 0);
                        }
                    }
                }
            }
            world.setBlock(x, y - 1, z, Block.wood.blockID, 0, 0);
            world.setBlock(x, y - 2, z, Block.dirt.blockID, 0, 0);
        }
    }

    public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
        Block b = world.getBlock(x, y, z);
        if (b == null || b.blockMaterial == Material.vine
                || b.blockMaterial == Material.plants
                || b == Block.snow) {
            world.setBlock(x, y, z, block.blockID, meta, 0);
        }
    }
}
