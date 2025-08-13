//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.tesseract.underbiome.world;

import net.minecraft.BiomeGenBase;
import net.minecraft.Block;
import net.minecraft.MapGenBase;
import net.minecraft.MathHelper;

import java.util.Random;

public class MapGenRavine extends MapGenBase {
    private float[] field_75046_d = new float[1024];
    private static final byte grass_block_id;
    private static final byte stone_block_id;
    private static final byte dirt_block_id;
    private static final byte water_moving_block_id;
    private static final byte water_still_block_id;
    private static final byte lava_moving_block_id;
    private static final byte sand_block_id;
    private static final byte sand_stone_block_id;

    public MapGenRavine() {
    }

    protected void generateRavine(long par1, int par3, int par4, byte[] par5ArrayOfByte, double par6, double par8, double par10, float par12, float par13, float par14, int par15, int par16, double par17) {
        Random var19 = new Random(par1);
        double var20 = (double)(par3 * 16 + 8);
        double var22 = (double)(par4 * 16 + 8);
        float var24 = 0.0F;
        float var25 = 0.0F;
        if (par16 <= 0) {
            int var26 = this.range * 16 - 16;
            par16 = var26 - var19.nextInt(var26 / 4);
        }

        boolean var54 = false;
        if (par15 == -1) {
            par15 = par16 / 2;
            var54 = true;
        }

        float var27 = 1.0F;

        for(int var28 = 0; var28 < 128; ++var28) {
            if (var28 == 0 || var19.nextInt(3) == 0) {
                var27 = 1.0F + var19.nextFloat() * var19.nextFloat() * 1.0F;
            }

            this.field_75046_d[var28] = var27 * var27;
        }

        for(; par15 < par16; ++par15) {
            double var53 = (double)1.5F + (double)(MathHelper.sin((float)par15 * (float)Math.PI / (float)par16) * par12 * 1.0F);
            double var30 = var53 * par17;
            var53 *= (double)var19.nextFloat() * (double)0.25F + (double)0.75F;
            var30 *= (double)var19.nextFloat() * (double)0.25F + (double)0.75F;
            float var32 = MathHelper.cos(par14);
            float var33 = MathHelper.sin(par14);
            par6 += (double)(MathHelper.cos(par13) * var32);
            par8 += (double)var33;
            par10 += (double)(MathHelper.sin(par13) * var32);
            par14 *= 0.7F;
            par14 += var25 * 0.05F;
            par13 += var24 * 0.05F;
            var25 *= 0.8F;
            var24 *= 0.5F;
            var25 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
            var24 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
            if (var54 || var19.nextInt(4) != 0) {
                double var34 = par6 - var20;
                double var36 = par10 - var22;
                double var38 = (double)(par16 - par15);
                double var40 = (double)(par12 + 2.0F + 16.0F);
                if (var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
                    return;
                }

                if (par6 >= var20 - (double)16.0F - var53 * (double)2.0F && par10 >= var22 - (double)16.0F - var53 * (double)2.0F && par6 <= var20 + (double)16.0F + var53 * (double)2.0F && par10 <= var22 + (double)16.0F + var53 * (double)2.0F) {
                    int var56 = MathHelper.floor_double(par6 - var53) - par3 * 16 - 1;
                    int var35 = MathHelper.floor_double(par6 + var53) - par3 * 16 + 1;
                    int var55 = MathHelper.floor_double(par8 - var30) - 1;
                    int var37 = MathHelper.floor_double(par8 + var30) + 1;
                    int var57 = MathHelper.floor_double(par10 - var53) - par4 * 16 - 1;
                    int var39 = MathHelper.floor_double(par10 + var53) - par4 * 16 + 1;
                    if (var56 < 0) {
                        var56 = 0;
                    }

                    if (var35 > 16) {
                        var35 = 16;
                    }

                    if (var55 < 1) {
                        var55 = 1;
                    }

                    if (var37 > 120) {
                        var37 = 120;
                    }

                    if (var57 < 0) {
                        var57 = 0;
                    }

                    if (var39 > 16) {
                        var39 = 16;
                    }

                    boolean var58 = false;

                    for(int var41 = var56; !var58 && var41 < var35; ++var41) {
                        for(int var42 = var57; !var58 && var42 < var39; ++var42) {
                            for(int var43 = var37 + 1; !var58 && var43 >= var55 - 1; --var43) {
                                int var44 = (var41 * 16 + var42) * 128 + var43;
                                if (var43 >= 0 && var43 < 128) {
                                    if (par5ArrayOfByte[var44] == Block.waterMoving.blockID || par5ArrayOfByte[var44] == Block.waterStill.blockID) {
                                        var58 = true;
                                    }

                                    if (var43 != var55 - 1 && var41 != var56 && var41 != var35 - 1 && var42 != var57 && var42 != var39 - 1) {
                                        var43 = var55;
                                    }
                                }
                            }
                        }
                    }

                    if (!var58) {
                        for(int var69 = var56; var69 < var35; ++var69) {
                            double var59 = ((double)(var69 + par3 * 16) + (double)0.5F - par6) / var53;

                            for(int var44 = var57; var44 < var39; ++var44) {
                                double var45 = ((double)(var44 + par4 * 16) + (double)0.5F - par10) / var53;
                                int var47 = (var69 * 16 + var44) * 128 + var37;
                                boolean var48 = false;
                                if (var59 * var59 + var45 * var45 < (double)1.0F) {
                                    for(int var49 = var37 - 1; var49 >= var55; --var49) {
                                        double var50 = ((double)var49 + (double)0.5F - par8) / var30;
                                        if ((var59 * var59 + var45 * var45) * (double)this.field_75046_d[var49] + var50 * var50 / (double)6.0F < (double)1.0F) {
                                            byte var52 = par5ArrayOfByte[var47];
                                            if (var52 == Block.grass.blockID) {
                                                var48 = true;
                                            }

                                            if (var52 == stone_block_id || var52 == dirt_block_id || var52 == grass_block_id || var52 == sand_block_id || var52 == sand_stone_block_id) {
                                                if (var49 < 10) {
                                                    par5ArrayOfByte[var47] = (byte)Block.lavaMoving.blockID;
                                                } else {
                                                    par5ArrayOfByte[var47] = 0;
                                                    if (var48 && par5ArrayOfByte[var47 - 1] == Block.dirt.blockID) {
                                                        par5ArrayOfByte[var47 - 1] = this.worldObj.getBiomeGenForCoords(var69 + par3 * 16, var44 + par4 * 16).topBlock;
                                                    } else if (par5ArrayOfByte[var47 + 1] == sand_block_id) {
                                                        int index = var47 + 1;
                                                        par5ArrayOfByte[index] = 0;

                                                        while(true) {
                                                            ++index;
                                                            if (par5ArrayOfByte[index] != sand_block_id) {
                                                                break;
                                                            }

                                                            par5ArrayOfByte[index] = 0;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        --var47;
                                    }
                                }
                            }
                        }

                        if (var54) {
                            break;
                        }
                    }
                }
            }
        }

    }

    protected void recursiveGenerate(World par1World, int par2, int par3, int par4, int par5, byte[] par6ArrayOfByte) {
        boolean force_generation = false;
        if (par1World.getSeed() == 1L && par2 == -6 && par3 == 31) {
            force_generation = true;
        }

        if (this.rand.nextInt(this.worldObj.worldInfo.getEarliestMITEReleaseRunIn() >= 139 ? 100 : 50) == 0 || force_generation) {
            double var7 = (double)(par2 * 16 + this.rand.nextInt(16));
            double var9 = (double)(this.rand.nextInt(this.rand.nextInt(40) + 8) + 20);
            double var11 = (double)(par3 * 16 + this.rand.nextInt(16));
            byte var13 = 1;

            for(int var14 = 0; var14 < var13; ++var14) {
                float var15 = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float var16 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float var17 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
                this.generateRavine(this.rand.nextLong(), par4, par5, par6ArrayOfByte, var7, var9, var11, var17, var15, var16, 0, 0, (double)3.0F);
            }
        }

    }

    public boolean isGenAllowedInBiome(BiomeGenBase biome) {
        return biome != BiomeGenBase.ocean;
    }

    static {
        grass_block_id = (byte)Block.grass.blockID;
        stone_block_id = (byte)Block.stone.blockID;
        dirt_block_id = (byte)Block.dirt.blockID;
        water_moving_block_id = (byte)Block.waterMoving.blockID;
        water_still_block_id = (byte)Block.waterStill.blockID;
        lava_moving_block_id = (byte)Block.lavaMoving.blockID;
        sand_block_id = (byte)Block.sand.blockID;
        sand_stone_block_id = (byte)Block.sandStone.blockID;
    }
}
