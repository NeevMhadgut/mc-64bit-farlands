import java.util.Random;

public class WorldGenHellLava extends WorldGenerator {
   private int a;

   public WorldGenHellLava(int par1) {
      this.a = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      if (par1World.getBlockId(par3, par4 + 1, par5) != Block.ItemBucket.bO) {
         return false;
      }

      if (par1World.getBlockId(par3, par4, par5) != 0 && par1World.getBlockId(par3, par4, par5) != Block.ItemBucket.bO) {
         return false;
      }

      int i = 0;
      if (par1World.getBlockId(par3 - 1L, par4, par5) == Block.ItemBucket.bO) {
         i++;
      }

      if (par1World.getBlockId(par3 + 1L, par4, par5) == Block.ItemBucket.bO) {
         i++;
      }

      if (par1World.getBlockId(par3, par4, par5 - 1L) == Block.ItemBucket.bO) {
         i++;
      }

      if (par1World.getBlockId(par3, par4, par5 + 1L) == Block.ItemBucket.bO) {
         i++;
      }

      if (par1World.getBlockId(par3, par4 - 1, par5) == Block.ItemBucket.bO) {
         i++;
      }

      int j = 0;
      if (par1World.isAirBlock(par3 - 1L, par4, par5)) {
         j++;
      }

      if (par1World.isAirBlock(par3 + 1L, par4, par5)) {
         j++;
      }

      if (par1World.isAirBlock(par3, par4, par5 - 1L)) {
         j++;
      }

      if (par1World.isAirBlock(par3, par4, par5 + 1L)) {
         j++;
      }

      if (par1World.isAirBlock(par3, par4 - 1, par5)) {
         j++;
      }

      if (i == 4 && j == 1) {
         par1World.setBlockWithNotify(par3, par4, par5, this.a);
         par1World.a = true;
         Block.m[this.a].updateTick(par1World, par3, par4, par5, par2Random);
         par1World.a = false;
      }

      return true;
   }
}
