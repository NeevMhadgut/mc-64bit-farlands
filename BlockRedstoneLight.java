import java.util.Random;

public class BlockRedstoneLight extends Block {
   private final boolean a;

   public BlockRedstoneLight(int par1, boolean par2) {
      super(par1, 211, acn.r);
      this.a = par2;
      if (par2) {
         this.a(1.0F);
         this.bN++;
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (!par1World.F) {
         if (this.a && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, 4);
         } else if (!this.a && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
            par1World.setBlockWithNotify(par2, par3, par4, Block.bM.bO);
         }
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         if (this.a && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, 4);
         } else if (!this.a && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
            par1World.setBlockWithNotify(par2, par3, par4, Block.bM.bO);
         }
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F && this.a && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
         par1World.setBlockWithNotify(par2, par3, par4, Block.bL.bO);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.bL.bO;
   }
}
