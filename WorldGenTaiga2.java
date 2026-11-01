import java.util.Random;

public class WorldGenTaiga2 extends WorldGenerator {
   public WorldGenTaiga2(boolean par1) {
      super(par1);
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = par2Random.nextInt(4) + 6;
      int j = 1 + par2Random.nextInt(2);
      int k = i - j;
      int l = 2 + par2Random.nextInt(2);
      boolean flag = true;
      if (par4 >= 1 && par4 + i + 1 <= 256) {
         for (int i1 = par4; i1 <= par4 + 1 + i && flag; i1++) {
            int k1 = 1;
            if (i1 - par4 < j) {
               k1 = 0;
            } else {
               k1 = l;
            }

            for (long i2 = par3 - k1; i2 <= par3 + k1 && flag; i2++) {
               for (long k2 = par5 - k1; k2 <= par5 + k1 && flag; k2++) {
                  if (i1 >= 0 && i1 < 256) {
                     int l2 = par1World.getBlockId(i2, i1, k2);
                     if (l2 != 0 && l2 != Block.K.bO) {
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

         int j1 = par1World.getBlockId(par3, par4 - 1, par5);
         if ((j1 == Block.u.bO || j1 == Block.v.bO) && par4 < 256 - i - 1) {
            this.func_50073_a(par1World, par3, par4 - 1, par5, Block.v.bO);
            int l1 = par2Random.nextInt(2);
            int j2 = 1;
            boolean flag1 = false;

            for (int i3 = 0; i3 <= k; i3++) {
               int k3 = par4 + i - i3;

               for (long i4 = par3 - l1; i4 <= par3 + l1; i4++) {
                  long k4 = i4 - par3;

                  for (long l4 = par5 - l1; l4 <= par5 + l1; l4++) {
                     long i5 = l4 - par5;
                     if ((Math.abs(k4) != l1 || Math.abs(i5) != l1 || l1 <= 0) && !Block.n[par1World.getBlockId(i4, k3, l4)]) {
                        this.setBlockAndMetadata(par1World, i4, k3, l4, Block.K.bO, 1);
                     }
                  }
               }

               if (l1 >= j2) {
                  l1 = flag1 ? 1 : 0;
                  flag1 = true;
                  if (++j2 > l) {
                     j2 = l;
                  }
               } else {
                  l1++;
               }
            }

            int j3 = par2Random.nextInt(3);

            for (int l3 = 0; l3 < i - j3; l3++) {
               int j4 = par1World.getBlockId(par3, par4 + l3, par5);
               if (j4 == 0 || j4 == Block.K.bO) {
                  this.setBlockAndMetadata(par1World, par3, par4 + l3, par5, Block.J.bO, 1);
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
}
