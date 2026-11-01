import java.util.Random;

public class WorldGenHugeTrees extends WorldGenerator {
   private final int a;
   private final int b;
   private final int c;

   public WorldGenHugeTrees(boolean par1, int par2, int par3, int par4) {
      super(par1);
      this.a = par2;
      this.b = par3;
      this.c = par4;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = par2Random.nextInt(3) + this.a;
      boolean flag = true;
      if (par4 >= 1 && par4 + i + 1 <= 256) {
         for (int j = par4; j <= par4 + 1 + i; j++) {
            byte byte0 = 2;
            if (j == par4) {
               byte0 = 1;
            }

            if (j >= par4 + 1 + i - 2) {
               byte0 = 2;
            }

            for (long i1 = par3 - byte0; i1 <= par3 + byte0 && flag; i1++) {
               for (long k1 = par5 - byte0; k1 <= par5 + byte0 && flag; k1++) {
                  if (j >= 0 && j < 256) {
                     int k2 = par1World.getBlockId(i1, j, k1);
                     if (k2 != 0 && k2 != Block.K.bO && k2 != Block.u.bO && k2 != Block.v.bO && k2 != Block.J.bO && k2 != Block.y.bO) {
                        flag = false;
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
         if ((k == Block.u.bO || k == Block.v.bO) && par4 < 256 - i - 1) {
            par1World.setBlock(par3, par4 - 1, par5, Block.v.bO);
            par1World.setBlock(par3 + 1L, par4 - 1, par5, Block.v.bO);
            par1World.setBlock(par3, par4 - 1, par5 + 1L, Block.v.bO);
            par1World.setBlock(par3 + 1L, par4 - 1, par5 + 1L, Block.v.bO);
            this.func_48192_a(par1World, par3, par5, par4 + i, 2, par2Random);

            for (int l = par4 + i - 2 - par2Random.nextInt(4); l > par4 + i / 2; l -= 2 + par2Random.nextInt(4)) {
               float f = par2Random.nextFloat() * (float) Math.PI * 2.0F;
               long l1 = par3 + (int)(0.5F + MathHelper.b(f) * 4.0F);
               long l2 = par5 + (int)(0.5F + MathHelper.a(f) * 4.0F);
               this.func_48192_a(par1World, l1, l2, l, 0, par2Random);

               for (int j3 = 0; j3 < 5; j3++) {
                  long i2 = par3 + (int)(1.5F + MathHelper.b(f) * j3);
                  long i3 = par5 + (int)(1.5F + MathHelper.a(f) * j3);
                  this.setBlockAndMetadata(par1World, i2, l - 3 + j3 / 2, i3, Block.J.bO, this.b);
               }
            }

            for (int j1 = 0; j1 < i; j1++) {
               int j2 = par1World.getBlockId(par3, par4 + j1, par5);
               if (j2 == 0 || j2 == Block.K.bO) {
                  this.setBlockAndMetadata(par1World, par3, par4 + j1, par5, Block.J.bO, this.b);
                  if (j1 > 0) {
                     if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 - 1L, par4 + j1, par5)) {
                        this.setBlockAndMetadata(par1World, par3 - 1L, par4 + j1, par5, Block.bu.bO, 8);
                     }

                     if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + j1, par5 - 1L)) {
                        this.setBlockAndMetadata(par1World, par3, par4 + j1, par5 - 1L, Block.bu.bO, 1);
                     }
                  }
               }

               if (j1 < i - 1) {
                  j2 = par1World.getBlockId(par3 + 1L, par4 + j1, par5);
                  if (j2 == 0 || j2 == Block.K.bO) {
                     this.setBlockAndMetadata(par1World, par3 + 1L, par4 + j1, par5, Block.J.bO, this.b);
                     if (j1 > 0) {
                        if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 2L, par4 + j1, par5)) {
                           this.setBlockAndMetadata(par1World, par3 + 2L, par4 + j1, par5, Block.bu.bO, 2);
                        }

                        if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 1L, par4 + j1, par5 - 1L)) {
                           this.setBlockAndMetadata(par1World, par3 + 1L, par4 + j1, par5 - 1L, Block.bu.bO, 1);
                        }
                     }
                  }

                  j2 = par1World.getBlockId(par3 + 1L, par4 + j1, par5 + 1L);
                  if (j2 == 0 || j2 == Block.K.bO) {
                     this.setBlockAndMetadata(par1World, par3 + 1L, par4 + j1, par5 + 1L, Block.J.bO, this.b);
                     if (j1 > 0) {
                        if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 2L, par4 + j1, par5 + 1L)) {
                           this.setBlockAndMetadata(par1World, par3 + 2L, par4 + j1, par5 + 1L, Block.bu.bO, 2);
                        }

                        if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 1L, par4 + j1, par5 + 2L)) {
                           this.setBlockAndMetadata(par1World, par3 + 1L, par4 + j1, par5 + 2L, Block.bu.bO, 4);
                        }
                     }
                  }

                  j2 = par1World.getBlockId(par3, par4 + j1, par5 + 1L);
                  if (j2 == 0 || j2 == Block.K.bO) {
                     this.setBlockAndMetadata(par1World, par3, par4 + j1, par5 + 1L, Block.J.bO, this.b);
                     if (j1 > 0) {
                        if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 - 1L, par4 + j1, par5 + 1L)) {
                           this.setBlockAndMetadata(par1World, par3 - 1L, par4 + j1, par5 + 1L, Block.bu.bO, 8);
                        }

                        if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + j1, par5 + 2L)) {
                           this.setBlockAndMetadata(par1World, par3, par4 + j1, par5 + 2L, Block.bu.bO, 4);
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

   private void func_48192_a(World par1World, long par2, long par3, int par4, int par5, Random par6Random) {
      byte byte0 = 2;

      for (int i = par4 - byte0; i <= par4; i++) {
         int j = i - par4;
         int k = par5 + 1 - j;

         for (long l = par2 - k; l <= par2 + k + 1L; l++) {
            long i1 = l - par2;

            for (long j1 = par3 - k; j1 <= par3 + k + 1L; j1++) {
               long k1 = j1 - par3;
               if ((i1 >= 0L || k1 >= 0L || i1 * i1 + k1 * k1 <= k * k)
                  && (i1 <= 0L && k1 <= 0L || i1 * i1 + k1 * k1 <= (k + 1) * (k + 1))
                  && (par6Random.nextInt(4) != 0 || i1 * i1 + k1 * k1 <= (k - 1) * (k - 1))
                  && !Block.n[par1World.getBlockId(l, i, j1)]) {
                  this.setBlockAndMetadata(par1World, l, i, j1, Block.K.bO, this.c);
               }
            }
         }
      }
   }
}
