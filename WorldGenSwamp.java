import java.util.Random;

public class WorldGenSwamp extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = par2Random.nextInt(4) + 5;

      while (par1World.getBlockMaterial(par3, par4 - 1, par5) == acn.g) {
         par4--;
      }

      boolean flag = true;
      if (par4 >= 1 && par4 + i + 1 <= 128) {
         for (int j = par4; j <= par4 + 1 + i; j++) {
            byte byte0 = 1;
            if (j == par4) {
               byte0 = 0;
            }

            if (j >= par4 + 1 + i - 2) {
               byte0 = 3;
            }

            for (long k1 = par3 - byte0; k1 <= par3 + byte0 && flag; k1++) {
               for (long k2 = par5 - byte0; k2 <= par5 + byte0 && flag; k2++) {
                  if (j >= 0 && j < 128) {
                     int j3 = par1World.getBlockId(k1, j, k2);
                     if (j3 != 0 && j3 != Block.K.bO) {
                        if (j3 != Block.B.bO && j3 != Block.A.bO) {
                           flag = false;
                        } else if (j > par4) {
                           flag = false;
                        }
                     }
                  } else {
                     flag = false;
                  }
               }
            }
         }

         if (!flag) {
            return false;
         }

         int k = par1World.getBlockId(par3, par4 - 1, par5);
         if ((k == Block.u.bO || k == Block.v.bO) && par4 < 128 - i - 1) {
            this.func_50073_a(par1World, par3, par4 - 1, par5, Block.v.bO);

            for (int l = par4 - 3 + i; l <= par4 + i; l++) {
               int l1 = l - (par4 + i);
               int l2 = 2 - l1 / 2;

               for (long k3 = par3 - l2; k3 <= par3 + l2; k3++) {
                  long i4 = k3 - par3;

                  for (long k4 = par5 - l2; k4 <= par5 + l2; k4++) {
                     long l4 = k4 - par5;
                     if ((Math.abs(i4) != l2 || Math.abs(l4) != l2 || par2Random.nextInt(2) != 0 && l1 != 0) && !Block.n[par1World.getBlockId(k3, l, k4)]) {
                        this.func_50073_a(par1World, k3, l, k4, Block.K.bO);
                     }
                  }
               }
            }

            for (int i1 = 0; i1 < i; i1++) {
               int i2 = par1World.getBlockId(par3, par4 + i1, par5);
               if (i2 == 0 || i2 == Block.K.bO || i2 == Block.A.bO || i2 == Block.B.bO) {
                  this.func_50073_a(par1World, par3, par4 + i1, par5, Block.J.bO);
               }
            }

            for (int j1 = par4 - 3 + i; j1 <= par4 + i; j1++) {
               int j2 = j1 - (par4 + i);
               int i3 = 2 - j2 / 2;

               for (long l3 = par3 - i3; l3 <= par3 + i3; l3++) {
                  for (long j4 = par5 - i3; j4 <= par5 + i3; j4++) {
                     if (par1World.getBlockId(l3, j1, j4) == Block.K.bO) {
                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(l3 - 1L, j1, j4) == 0) {
                           this.generateVines(par1World, l3 - 1L, j1, j4, 8);
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(l3 + 1L, j1, j4) == 0) {
                           this.generateVines(par1World, l3 + 1L, j1, j4, 2);
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(l3, j1, j4 - 1L) == 0) {
                           this.generateVines(par1World, l3, j1, j4 - 1L, 1);
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(l3, j1, j4 + 1L) == 0) {
                           this.generateVines(par1World, l3, j1, j4 + 1L, 4);
                        }
                     }
                  }
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void generateVines(World par1World, long par2, int par3, long par4, int par5) {
      this.setBlockAndMetadata(par1World, par2, par3, par4, Block.bu.bO, par5);

      for (int i = 4; par1World.getBlockId(par2, --par3, par4) == 0 && i > 0; i--) {
         this.setBlockAndMetadata(par1World, par2, par3, par4, Block.bu.bO, par5);
      }
   }
}
