import java.util.Random;

public class WorldGenClay extends WorldGenerator {
   private int a = Block.aW.bO;
   private int b;

   public WorldGenClay(int par1) {
      this.b = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      if (par1World.getBlockMaterial(par3, par4, par5) != acn.g) {
         return false;
      }

      int i = par2Random.nextInt(this.b - 2) + 2;

      for (int k = -i; k <= i; k++) {
         for (int l = -i; l <= i; l++) {
            if (k * k + l * l <= i * i) {
               for (int k1 = -1; k1 <= 1; k1++) {
                  int l1 = par1World.getBlockId(par3 + k, par4 + k1, par5 + l);
                  if (l1 == Block.v.bO || l1 == Block.aW.bO) {
                     par1World.setBlock(par3 + k, par4 + k1, par5 + l, this.a);
                  }
               }
            }
         }
      }

      return true;
   }
}
