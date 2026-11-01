import java.util.Random;

public class BlockSilverfish extends Block {
   public BlockSilverfish(int par1) {
      super(par1, 1, acn.y);
      this.c(0.0F);
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
   }

   @Override
   public int a(int par1, int par2) {
      if (par2 == 1) {
         return Block.w.bN;
      } else {
         return par2 == 2 ? Block.bm.bN : Block.t.bN;
      }
   }

   @Override
   public void onBlockDestroyedByPlayer(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         EntitySilverfish entitysilverfish = new EntitySilverfish(par1World);
         entitysilverfish.c(par2 + 0.5, par3, par4 + 0.5, 0.0F, 0.0F);
         par1World.a(entitysilverfish);
         entitysilverfish.ba();
      }

      super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   public static boolean e(int par0) {
      return par0 == Block.t.bO || par0 == Block.w.bO || par0 == Block.bm.bO;
   }

   public static int h(int par0) {
      if (par0 == Block.w.bO) {
         return 1;
      } else {
         return par0 != Block.bm.bO ? 0 : 2;
      }
   }

   @Override
   protected ItemStack b(int par1) {
      Block block = Block.t;
      if (par1 == 1) {
         block = Block.w;
      }

      if (par1 == 2) {
         block = Block.bm;
      }

      return new ItemStack(block);
   }
}
