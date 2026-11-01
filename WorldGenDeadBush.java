import java.util.Random;

public class WorldGenDeadBush extends WorldGenerator {
   private int a;

   public WorldGenDeadBush(int par1) {
      this.a = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = 0;

      while (((i = par1World.getBlockId(par3, par4, par5)) == 0 || i == Block.K.bO) && par4 > 0) {
         par4--;
      }

      for (int j = 0; j < 4; j++) {
         long k = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
         int l = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
         long i1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
         if (par1World.isAirBlock(k, l, i1) && ((BlockFlower)Block.m[this.a]).canBlockStay(par1World, k, l, i1)) {
            par1World.setBlock(k, l, i1, this.a);
         }
      }

      return true;
   }
}
