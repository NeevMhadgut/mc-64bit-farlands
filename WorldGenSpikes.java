import java.util.Random;

public class WorldGenSpikes extends WorldGenerator {
   private int a;

   public WorldGenSpikes(int par1) {
      this.a = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      if (par1World.isAirBlock(par3, par4, par5) && par1World.getBlockId(par3, par4 - 1, par5) == this.a) {
         int i = par2Random.nextInt(32) + 6;
         int j = par2Random.nextInt(4) + 1;

         for (long k = par3 - j; k <= par3 + j; k++) {
            for (long i1 = par5 - j; i1 <= par5 + j; i1++) {
               long k1 = k - par3;
               long i2 = i1 - par5;
               if (k1 * k1 + i2 * i2 <= j * j + 1 && par1World.getBlockId(k, par4 - 1, i1) != this.a) {
                  return false;
               }
            }
         }

         for (int l = par4; l < par4 + i && l < 256; l++) {
            for (long j1 = par3 - j; j1 <= par3 + j; j1++) {
               for (long l1 = par5 - j; l1 <= par5 + j; l1++) {
                  long j2 = j1 - par3;
                  long k2 = l1 - par5;
                  if (j2 * j2 + k2 * k2 <= j * j + 1) {
                     par1World.setBlockWithNotify(j1, l, l1, Block.ap.bO);
                  }
               }
            }
         }

         EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(par1World);
         entityendercrystal.c(par3 + 0.5, par4 + i, par5 + 0.5, par2Random.nextFloat() * 360.0F, 0.0F);
         par1World.a(entityendercrystal);
         par1World.setBlockWithNotify(par3, par4 + i, par5, Block.z.bO);
         return true;
      } else {
         return false;
      }
   }
}
