import java.util.Random;

public class WorldGenLakes extends WorldGenerator {
   private int a;

   public WorldGenLakes(int par1) {
      this.a = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      par3 -= 8L;
      par5 -= 8L;

      while (par4 > 5 && par1World.isAirBlock(par3, par4, par5)) {
         par4--;
      }

      if (par4 <= 4) {
         return false;
      }

      par4 -= 4;
      boolean[] aflag = new boolean[2048];
      int i = par2Random.nextInt(4) + 4;

      for (int j = 0; j < i; j++) {
         double d = par2Random.nextDouble() * 6.0 + 3.0;
         double d1 = par2Random.nextDouble() * 4.0 + 2.0;
         double d2 = par2Random.nextDouble() * 6.0 + 3.0;
         double d3 = par2Random.nextDouble() * (16.0 - d - 2.0) + 1.0 + d / 2.0;
         double d4 = par2Random.nextDouble() * (8.0 - d1 - 4.0) + 2.0 + d1 / 2.0;
         double d5 = par2Random.nextDouble() * (16.0 - d2 - 2.0) + 1.0 + d2 / 2.0;

         for (int i4 = 1; i4 < 15; i4++) {
            for (int j4 = 1; j4 < 15; j4++) {
               for (int k4 = 1; k4 < 7; k4++) {
                  double d6 = (i4 - d3) / (d / 2.0);
                  double d7 = (k4 - d4) / (d1 / 2.0);
                  double d8 = (j4 - d5) / (d2 / 2.0);
                  double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                  if (d9 < 1.0) {
                     aflag[(i4 * 16 + j4) * 8 + k4] = true;
                  }
               }
            }
         }
      }

      for (int k = 0; k < 16; k++) {
         for (int l1 = 0; l1 < 16; l1++) {
            for (int i3 = 0; i3 < 8; i3++) {
               boolean flag = !aflag[(k * 16 + l1) * 8 + i3]
                  && (
                     k < 15 && aflag[((k + 1) * 16 + l1) * 8 + i3]
                        || k > 0 && aflag[((k - 1) * 16 + l1) * 8 + i3]
                        || l1 < 15 && aflag[(k * 16 + l1 + 1) * 8 + i3]
                        || l1 > 0 && aflag[(k * 16 + (l1 - 1)) * 8 + i3]
                        || i3 < 7 && aflag[(k * 16 + l1) * 8 + i3 + 1]
                        || i3 > 0 && aflag[(k * 16 + l1) * 8 + (i3 - 1)]
                  );
               if (flag) {
                  acn material = par1World.getBlockMaterial(par3 + k, par4 + i3, par5 + l1);
                  if (i3 >= 4 && material.d()) {
                     return false;
                  }

                  if (i3 < 4 && !material.a() && par1World.getBlockId(par3 + k, par4 + i3, par5 + l1) != this.a) {
                     return false;
                  }
               }
            }
         }
      }

      for (int l = 0; l < 16; l++) {
         for (int i2 = 0; i2 < 16; i2++) {
            for (int j3 = 0; j3 < 8; j3++) {
               if (aflag[(l * 16 + i2) * 8 + j3]) {
                  par1World.setBlock(par3 + l, par4 + j3, par5 + i2, j3 < 4 ? this.a : 0);
               }
            }
         }
      }

      for (int i1 = 0; i1 < 16; i1++) {
         for (int j2 = 0; j2 < 16; j2++) {
            for (int k3 = 4; k3 < 8; k3++) {
               if (aflag[(i1 * 16 + j2) * 8 + k3]
                  && par1World.getBlockId(par3 + i1, par4 + k3 - 1, par5 + j2) == Block.v.bO
                  && par1World.getSavedLightValue(wl.a, par3 + i1, par4 + k3, par5 + j2) > 0) {
                  BiomeGenBase biomegenbase = par1World.getBiomeGenForCoords(par3 + i1, par5 + j2);
                  if (biomegenbase.A == Block.by.bO) {
                     par1World.setBlock(par3 + i1, par4 + k3 - 1, par5 + j2, Block.by.bO);
                  } else {
                     par1World.setBlock(par3 + i1, par4 + k3 - 1, par5 + j2, Block.u.bO);
                  }
               }
            }
         }
      }

      if (Block.m[this.a].cd == acn.h) {
         for (int j1 = 0; j1 < 16; j1++) {
            for (int k2 = 0; k2 < 16; k2++) {
               for (int l3 = 0; l3 < 8; l3++) {
                  boolean flag1 = !aflag[(j1 * 16 + k2) * 8 + l3]
                     && (
                        j1 < 15 && aflag[((j1 + 1) * 16 + k2) * 8 + l3]
                           || j1 > 0 && aflag[((j1 - 1) * 16 + k2) * 8 + l3]
                           || k2 < 15 && aflag[(j1 * 16 + k2 + 1) * 8 + l3]
                           || k2 > 0 && aflag[(j1 * 16 + (k2 - 1)) * 8 + l3]
                           || l3 < 7 && aflag[(j1 * 16 + k2) * 8 + l3 + 1]
                           || l3 > 0 && aflag[(j1 * 16 + k2) * 8 + (l3 - 1)]
                     );
                  if (flag1 && (l3 < 4 || par2Random.nextInt(2) != 0) && par1World.getBlockMaterial(par3 + j1, par4 + l3, par5 + k2).a()) {
                     par1World.setBlock(par3 + j1, par4 + l3, par5 + k2, Block.t.bO);
                  }
               }
            }
         }
      }

      if (Block.m[this.a].cd == acn.g) {
         for (int k1 = 0; k1 < 16; k1++) {
            for (int l2 = 0; l2 < 16; l2++) {
               byte byte0 = 4;
               if (par1World.isBlockHydratedDirectly(par3 + k1, par4 + byte0, par5 + l2)) {
                  par1World.setBlock(par3 + k1, par4 + byte0, par5 + l2, Block.aT.bO);
               }
            }
         }
      }

      return true;
   }
}
