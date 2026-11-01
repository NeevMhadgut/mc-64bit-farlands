import java.util.List;
import java.util.Random;

public class BlockDetectorRail extends BlockRail {
   public BlockDetectorRail(int par1, int par2) {
      super(par1, par2, true);
      this.a(true);
   }

   @Override
   public int e() {
      return 20;
   }

   @Override
   public boolean g() {
      return true;
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         if ((i & 8) == 0) {
            this.setStateIfMinecartInteractsWithRail(par1World, par2, par3, par4, i);
         }
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         if ((i & 8) != 0) {
            this.setStateIfMinecartInteractsWithRail(par1World, par2, par3, par4, i);
         }
      }
   }

   @Override
   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) != 0;
   }

   @Override
   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long par4, int par5) {
      return (par1World.getBlockMetadata(par2, par3, par4) & 8) == 0 ? false : par5 == 1;
   }

   private void setStateIfMinecartInteractsWithRail(World par1World, long par2, int par3, long par4, int par5) {
      boolean flag = (par5 & 8) != 0;
      boolean flag1 = false;
      double f = 0.125;
      List list = par1World.a(EntityMinecart.class, AxisAlignedBB.b(par2 + f, par3, par4 + f, par2 + 1L - f, par3 + 1 - f, par4 + 1L - f));
      if (list.size() > 0) {
         flag1 = true;
      }

      if (flag1 && !flag) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, par5 | 8);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      }

      if (!flag1 && flag) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, par5 & 7);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      }

      if (flag1) {
         par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
      }
   }
}
