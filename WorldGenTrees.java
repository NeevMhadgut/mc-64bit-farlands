import java.util.Random;

public class WorldGenTrees extends WorldGenerator {
   private final int a;
   private final boolean b;
   private final int c;
   private final int d;

   public WorldGenTrees(boolean par1) {
      this(par1, 4, 0, 0, false);
   }

   public WorldGenTrees(boolean par1, int par2, int par3, int par4, boolean par5) {
      super(par1);
      this.a = par2;
      this.c = par3;
      this.d = par4;
      this.b = par5;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = par2Random.nextInt(3) + this.a;
      boolean flag = true;
      if (par4 >= 1 && par4 + i + 1 <= 256) {
         for (int j = par4; j <= par4 + 1 + i; j++) {
            byte byte0 = 1;
            if (j == par4) {
               byte0 = 0;
            }

            if (j >= par4 + 1 + i - 2) {
               byte0 = 2;
            }

            for (long l = par3 - byte0; l <= par3 + byte0 && flag; l++) {
               for (long j1 = par5 - byte0; j1 <= par5 + byte0 && flag; j1++) {
                  if (j >= 0 && j < 256) {
                     int j2 = par1World.getBlockId(l, j, j1);
                     if (j2 != 0 && j2 != Block.K.bO && j2 != Block.u.bO && j2 != Block.v.bO && j2 != Block.J.bO) {
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
            this.func_50073_a(par1World, par3, par4 - 1, par5, Block.v.bO);
            byte byte1 = 3;
            int i1 = 0;

            for (int k1 = par4 - byte1 + i; k1 <= par4 + i; k1++) {
               int k2 = k1 - (par4 + i);
               int j3 = i1 + 1 - k2 / 2;

               for (long l3 = par3 - j3; l3 <= par3 + j3; l3++) {
                  long j4 = l3 - par3;

                  for (long l4 = par5 - j3; l4 <= par5 + j3; l4++) {
                     long i5 = l4 - par5;
                     if ((Math.abs(j4) != j3 || Math.abs(i5) != j3 || par2Random.nextInt(2) != 0 && k2 != 0) && !Block.n[par1World.getBlockId(l3, k1, l4)]) {
                        this.setBlockAndMetadata(par1World, l3, k1, l4, Block.K.bO, this.d);
                     }
                  }
               }
            }

            for (int l1 = 0; l1 < i; l1++) {
               int l2 = par1World.getBlockId(par3, par4 + l1, par5);
               if (l2 == 0 || l2 == Block.K.bO) {
                  this.setBlockAndMetadata(par1World, par3, par4 + l1, par5, Block.J.bO, this.c);
                  if (this.b && l1 > 0) {
                     if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 - 1L, par4 + l1, par5)) {
                        this.setBlockAndMetadata(par1World, par3 - 1L, par4 + l1, par5, Block.bu.bO, 8);
                     }

                     if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 1L, par4 + l1, par5)) {
                        this.setBlockAndMetadata(par1World, par3 + 1L, par4 + l1, par5, Block.bu.bO, 2);
                     }

                     if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + l1, par5 - 1L)) {
                        this.setBlockAndMetadata(par1World, par3, par4 + l1, par5 - 1L, Block.bu.bO, 1);
                     }

                     if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + l1, par5 + 1L)) {
                        this.setBlockAndMetadata(par1World, par3, par4 + l1, par5 + 1L, Block.bu.bO, 4);
                     }
                  }
               }
            }

            if (this.b) {
               for (int i2 = par4 - 3 + i; i2 <= par4 + i; i2++) {
                  int i3 = i2 - (par4 + i);
                  int k3 = 2 - i3 / 2;

                  for (long i4 = par3 - k3; i4 <= par3 + k3; i4++) {
                     for (long k4 = par5 - k3; k4 <= par5 + k3; k4++) {
                        if (par1World.getBlockId(i4, i2, k4) == Block.K.bO) {
                           if (par2Random.nextInt(4) == 0 && par1World.getBlockId(i4 - 1L, i2, k4) == 0) {
                              this.func_48198_a(par1World, i4 - 1L, i2, k4, 8);
                           }

                           if (par2Random.nextInt(4) == 0 && par1World.getBlockId(i4 + 1L, i2, k4) == 0) {
                              this.func_48198_a(par1World, i4 + 1L, i2, k4, 2);
                           }

                           if (par2Random.nextInt(4) == 0 && par1World.getBlockId(i4, i2, k4 - 1L) == 0) {
                              this.func_48198_a(par1World, i4, i2, k4 - 1L, 1);
                           }

                           if (par2Random.nextInt(4) == 0 && par1World.getBlockId(i4, i2, k4 + 1L) == 0) {
                              this.func_48198_a(par1World, i4, i2, k4 + 1L, 4);
                           }
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

   private void func_48198_a(World par1World, long par2, int par3, long par4, int par5) {
      this.setBlockAndMetadata(par1World, par2, par3, par4, Block.bu.bO, par5);

      for (int i = 4; par1World.getBlockId(par2, --par3, par4) == 0 && i > 0; i--) {
         this.setBlockAndMetadata(par1World, par2, par3, par4, Block.bu.bO, par5);
      }
   }
}
