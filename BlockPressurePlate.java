import java.util.List;
import java.util.Random;

public class BlockPressurePlate extends Block {
   private agw a;

   protected BlockPressurePlate(int par1, int par2, agw par3EnumMobType, acn par4Material) {
      super(par1, par2, par4Material);
      this.a = par3EnumMobType;
      this.a(true);
      float f = 0.0625F;
      this.a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
   }

   @Override
   public int e() {
      return 20;
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long i) {
      return true;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return par1World.isBlockNormalCube(par2, par3 - 1, par4) || par1World.getBlockId(par2, par3 - 1, par4) == Block.aZ.bO;
   }

   @Override
   public void onBlockAdded(World world, long i, int j, long k) {
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      boolean flag = false;
      if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) && par1World.getBlockId(par2, par3 - 1, par4) != Block.aZ.bO) {
         flag = true;
      }

      if (flag) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F) {
         if (par1World.getBlockMetadata(par2, par3, par4) != 0) {
            this.setStateIfMobInteractsWithPlate(par1World, par2, par3, par4);
         }
      }
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      if (!par1World.F) {
         if (par1World.getBlockMetadata(par2, par3, par4) != 1) {
            this.setStateIfMobInteractsWithPlate(par1World, par2, par3, par4);
         }
      }
   }

   private void setStateIfMobInteractsWithPlate(World par1World, long par2, int par3, long par4) {
      boolean flag = par1World.getBlockMetadata(par2, par3, par4) == 1;
      boolean flag1 = false;
      double f = 0.125;
      List list = null;
      if (this.a == agw.a) {
         list = par1World.b(null, AxisAlignedBB.b(par2 + f, par3, par4 + f, par2 + 1L - f, par3 + 0.25, par4 + 1L - f));
      }

      if (this.a == agw.b) {
         list = par1World.a(EntityLiving.class, AxisAlignedBB.b(par2 + f, par3, par4 + f, par2 + 1L - f, par3 + 0.25, par4 + 1L - f));
      }

      if (this.a == agw.c) {
         list = par1World.a(EntityPlayer.class, AxisAlignedBB.b(par2 + f, par3, par4 + f, par2 + 1L - f, par3 + 0.25, par4 + 1L - f));
      }

      if (list.size() > 0) {
         flag1 = true;
      }

      if (flag1 && !flag) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
         par1World.a(par2 + 0.5, par3 + 0.1, par4 + 0.5, "random.click", 0.3F, 0.6F);
      }

      if (!flag1 && flag) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
         par1World.a(par2 + 0.5, par3 + 0.1, par4 + 0.5, "random.click", 0.3F, 0.5F);
      }

      if (flag1) {
         par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
      }
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (i > 0) {
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
      }

      super.onBlockRemoval(par1World, par2, par3, par4);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      boolean flag = par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 1;
      float f = 0.0625F;
      if (flag) {
         this.a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
      } else {
         this.a(f, 0.0F, f, 1.0F - f, 0.0625F, 1.0F - f);
      }
   }

   @Override
   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return par1IBlockAccess.getBlockMetadata(par2, par3, par4) > 0;
   }

   @Override
   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long par4, int par5) {
      return par1World.getBlockMetadata(par2, par3, par4) == 0 ? false : par5 == 1;
   }

   @Override
   public boolean g() {
      return true;
   }

   @Override
   public void h() {
      float f = 0.5F;
      float f1 = 0.125F;
      float f2 = 0.5F;
      this.a(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
   }

   @Override
   public int f() {
      return 1;
   }
}
