import java.util.Random;

public class WorldGenSand extends WorldGenerator {
   private int a;
   private int b;

   public WorldGenSand(int par1, int par2) {
      this.a = par2;
      this.b = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      if (par1World.getBlockMaterial(par3, par4, par5) != acn.g) {
         return false;
      }

      int i = par2Random.nextInt(this.b - 2) + 2;

      for (int j = -i; j <= i; j++) {
         for (int k = -i; k <= i; k++) {
            if (j * j + k * k <= i * i) {
               for (int j1 = -2; j1 <= 2; j1++) {
                  int k1 = par1World.getBlockId(par3 + j, par4 + j1, par5 + k);
                  if (k1 == Block.v.bO || k1 == Block.u.bO) {
                     par1World.setBlock(par3 + j, par4 + j1, par5 + k, this.a);
                  }
               }
            }
         }
      }

      return true;
   }
}
