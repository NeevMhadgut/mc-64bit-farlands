import java.util.Random;

public class BlockSnowBlock extends Block {
   protected BlockSnowBlock(int par1, int par2) {
      super(par1, par2, acn.w);
      this.a(true);
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.aD.bQ;
   }

   @Override
   public int a(Random par1Random) {
      return 4;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par1World.getSavedLightValue(wl.b, par2, par3, par4) > 11) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }
}
